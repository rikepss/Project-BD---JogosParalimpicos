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

/**
 *
 * @author lenovo
 */
public class VeiculoDAO {
    private Connection conn;
    public VeiculoDAO(){        
        conn = new Conexao().getConn();
    }
    public String getTipo(String placa) throws SQLException{
        Statement st = null;
        ResultSet rs = null;   
        String tipo = "";
       
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select tipo from veiculo where placa = upper('" + placa + "')");
            
            while(rs.next()){
                    tipo = rs.getString(1);
            }
            return tipo;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
    }
}
