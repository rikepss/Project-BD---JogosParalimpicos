/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author lenovo
 */
public class Conexao {
    private Connection conn; 
    private String username = "e9778536";
    private String password = "9085583";
    public Conexao(){
        String driver = "thin";
        String hostname = "grad.icmc.usp.br";
        String port = "15215";
        String sid = "orcl";
        String strcon = "jdbc:oracle:"+driver+":@"+hostname+":"+port+":"+sid;
        try{
            this.conn = DriverManager.getConnection(strcon, username, password);             
            System.out.println("Conectado!");
        }catch(SQLException ex){
            System.out.println("Erro de Conexao");
            ex.printStackTrace();
        }
    }

    public Connection getConn() {
        return conn;
    }
    
}
