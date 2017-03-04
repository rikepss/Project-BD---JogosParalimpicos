/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lenovo
 */
public class Transporte_PessoaDAO {
    private Connection conn;
    public Transporte_PessoaDAO(){        
        conn = new Conexao().getConn();
    }
    
    public List<Transporte_Pessoa> getMembrosByVeiculo(Veiculo veiculo, String data) throws SQLException{
        List<Transporte_Pessoa> list = new ArrayList<Transporte_Pessoa>();
        Statement st = null;
        ResultSet rs = null;   
        String query;
        Transporte_Pessoa tp;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT CP.NOME, CP.ENDERECO, TP.VEICULO, M.NOME AS MEMBRO, TP.DATA\n" +
"FROM CENTRO_DE_PRATICA CP JOIN TRANSPORTE_PESSOA TP\n" +
"ON CP.ID = TP.CENTRO_DE_PRATICA JOIN\n" +
"MEMBRO M ON M.N_CARTAO = TP.MEMBRO WHERE VEICULO = UPPER('" + veiculo.getPlaca()+"') AND TP.DATA = '" + data + "'");
            
            while(rs.next()){
                    tp = convertRowToObject(rs);
                    //System.out.println(regiao.getNome());
                    list.add(tp);  
            }
            return list;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
    }
    private Transporte_Pessoa convertRowToObject(ResultSet rs)throws SQLException{
        Transporte_Pessoa tp = new Transporte_Pessoa();
        CentroDePratica cp = new CentroDePratica();
        cp.setNome(rs.getString("NOME"));
        cp.setEndereco(rs.getString("ENDERECO"));
        tp.setCentroDePratica(cp);
        tp.setVeiculos(rs.getString("VEICULO"));               
        tp.setMembros(rs.getString("MEMBRO"));
        tp.setDatas(rs.getString("DATA"));
        return tp;
    }
    public static void main(String args[]) {
        Transporte_PessoaDAO regiaoDAO = new Transporte_PessoaDAO();
        Veiculo regiao = new Veiculo();
        regiao.setPlaca("ABC-1234");
        String data = "03/08/2016";
        List<Transporte_Pessoa> list = null;
        try{
            list = regiaoDAO.getMembrosByVeiculo(regiao, data);
            if(list == null)
                System.out.println("NULL list");
            
            for(int i = 0; i < list.size();i++){
                System.out.println(list.get(i).getVeiculos());
                System.out.println(list.get(i).getCentroDePratica().getNome());
                System.out.println(list.get(i).getCentroDePratica().getEndereco());
                System.out.println(list.get(i).getDatas());
                System.out.println(list.get(i).getMembros());
            }
            
        }catch(Exception ex){
            System.out.println("Erro");
            ex.printStackTrace();
        }
    
    }
}
