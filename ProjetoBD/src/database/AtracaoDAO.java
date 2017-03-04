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
import ui.RegiaoTableModel;

/**
 *
 * @author lenovo
 */
public class AtracaoDAO {
    

    private Connection conn;
    public AtracaoDAO(){        
        conn = new Conexao().getConn();
    }
    public List<Regiao> getRegiao(Atracao atracao) throws SQLException{
        List<Regiao> list = new ArrayList<Regiao>();
        Statement st = null;
        ResultSet rs = null;   
        String query;
        Regiao regiao;
        
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT REGIAO FROM ATRACAOREG WHERE ATRACAO = '" + atracao.getNome()+"'");
            
            while(rs.next()){
                    regiao = convertRowToObject(rs);
                    //System.out.println(regiao.getNome());
                    list.add(regiao);  
            }
            return list;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
    }
    private Regiao convertRowToObject(ResultSet rs)throws SQLException{
        Regiao regiao = new Regiao();
        String nome = rs.getString("REGIAO");
        regiao.setNome(nome);
        return regiao;
    }
    public static void main(String args[]) {
        AtracaoDAO regiao = new AtracaoDAO();
        Atracao atracao = new Atracao();
        atracao.setNome("Museu da CBF");
        List<Regiao> list = null;
        try{
            list = regiao.getRegiao(atracao);
            if(list == null)
                System.out.println("NULL list");
            
            for(int i = 0; i < list.size();i++){
                System.out.println(list.get(i).getNome());
            }
            
        }catch(Exception ex){
            System.out.println("Erro");
            ex.printStackTrace();
        }
    
    }
}
