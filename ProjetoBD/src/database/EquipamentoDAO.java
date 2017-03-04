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
public class EquipamentoDAO {
    private Connection conn;
    public EquipamentoDAO(){        
        conn = new Conexao().getConn();
    }
    public float getVolume(int id) throws SQLException{
        Statement st = null;
        ResultSet rs = null;   
        float volume = 0;
       
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select volume from equipamento where id = " + id + " ");
            
            while(rs.next()){
                    volume = rs.getFloat(1);
            }
            return volume;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
    }
    
}
