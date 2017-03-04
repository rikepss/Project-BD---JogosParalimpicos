/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author lenovo
 */
public class RegiaoDAO {
    
    private Connection conn;
    public RegiaoDAO(){        
        conn = new Conexao().getConn();
    }
    /*public List<Regiao> getAllRegiao() throws Exception{
        List<Regiao> list = new ArrayList<Regiao>();
        Statement st = null;
        ResultSet rs = null;   
        String query;
        Regiao regiao;
        //query = "SELECT * FROM REGIAO;";
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT * FROM REGIAO");
            
            while(rs.next()){
                    //regiao = convertRowToObject(rs);
                    //System.out.println(regiao.getNome());
                    //list.add(regiao);  
            }
            return list;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }        
    }*/
    public List<Atracao> getAtracao(Regiao regiao) throws SQLException{
        List<Atracao> list = new ArrayList<Atracao>();
        Statement st = null;
        ResultSet rs = null;   
        String query;
        Atracao atracao;
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT AR.ATRACAO, AT.ENDERECO FROM ATRACAOREG AR JOIN ATRACAO AT ON AR.ATRACAO=AT.NOME WHERE REGIAO = UPPER('" + regiao.getNome()+"')");
            
            while(rs.next()){
                    atracao = convertRowToObject(rs);
                    //System.out.println(regiao.getNome());
                    list.add(atracao);  
            }
            return list;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
    }
    private Atracao convertRowToObject(ResultSet rs)throws SQLException{
        Atracao atracao = new Atracao();
        String nome = rs.getString("ATRACAO");
        atracao.setNome(nome);
        String endereco = rs.getString("ENDERECO");
        atracao.setEndereco(endereco);
        return atracao;
    }
    public static void main(String args[]) {
        RegiaoDAO regiaoDAO = new RegiaoDAO();
        Regiao regiao = new Regiao();
        regiao.setNome("BARRA");
        List<Atracao> list = null;
        try{
            list = regiaoDAO.getAtracao(regiao);
            if(list == null)
                System.out.println("NULL list");
            
            for(int i = 0; i < list.size();i++){
                System.out.println(list.get(i).getNome());
                System.out.println(list.get(i).getEndereco());
            }
            
        }catch(Exception ex){
            System.out.println("Erro");
            ex.printStackTrace();
        }
    
    }
}
