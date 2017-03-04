/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.*;

/**
 *
 * @author lenovo
 */
public class getConnection {
    private Connection conn;
    private Statement st;
    private ResultSet rs;   
    
    public void closeConnection(){
        try{
            st.close();
            rs.close();
            conn.close();
        }catch(SQLException ex){
            System.out.println("Erro ao fechar Conexao");
        }
        
    }
    public void openConnection(/*String servidor, String porta, String banco, String user, String pwd*/){
        String driver = "thin";
        String hostname = "grad.icmc.usp.br";
        String port = "15215";
        String sid = "orcl";
        String username = "e9778536";
        String password = "9085583";
        String strcon = "jdbc:oracle:"+driver+":@"+hostname+":"+port+":"+sid;
        try{
            this.conn = DriverManager.getConnection(strcon, username, password); 
            //Statement para a consulta
            this.st = conn.createStatement();
            System.out.println("Conectado!");
        }catch(SQLException ex){
            System.out.println("Erro de Conexao");
            ex.printStackTrace();
        }
        
    }
    public void executarQuery(String query) throws SQLException{
        this.rs = st.executeQuery(query);
        //Varre tupla a tupla
        while (rs.next()){
            System.out.println(rs.getString("POSICAO")+" "+rs.getString("JOGADOR"));
        }
    }
    public void executarUpdate(String query) throws SQLException{
        st.executeUpdate(query);
    
    }
    public void exibeConsulta() throws SQLException{
        StringBuffer str = new StringBuffer();
        int colCount = rs.getMetaData().getColumnCount();
        while(rs.next()){
            for(int i = 0;i <= colCount; i++){
                str.append(rs.getString(i) + "\t");
            }
            str.append("\n");
        }
        System.out.println(str);
    }

}
