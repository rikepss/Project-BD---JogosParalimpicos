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
public class Transporte_EquipDAO {
    private Connection conn;
    public Transporte_EquipDAO(){        
        conn = new Conexao().getConn();
    }/*cadastra um transporte de equipamento caso nao ultrapasse o volume do veiculo destino*/
    public boolean inserirEquipamento(Veiculo veiculo, Equipamento equip, CentroDePratica cp, String data) throws SQLException{
        float cargaAtual = getCapacidadeAtual(veiculo, data);
        float capacidade = 0;
        Statement st = null;
        ResultSet rs = null;   
        String query;
        Regiao regiao;
        EquipamentoDAO eDAO = new EquipamentoDAO();
        equip.setVolume( eDAO.getVolume(equip.getId()));
        try{
            st = conn.createStatement();
            rs = st.executeQuery("select capacidade from veiculo_carga where placa = upper('"+ veiculo.getPlaca()+"')");
            
            while(rs.next()){
                    capacidade = rs.getFloat(1);
            }
                System.out.println(capacidade);
            if(equip.getVolume() + cargaAtual < capacidade){
                st.executeUpdate("INSERT INTO TRANSPORTE_EQUIP(CENTRO_DE_PRATICA, VEICULO, EQUIPAMENTO, DATA) VALUES('"
                        + cp.getId() + "','"
                        + veiculo.getPlaca() + "','"
                        + equip.getId() + "',TO_DATE('"
                        + data + "','dd/mm/yyyy') )");
                return true;
            }else{
                System.out.println("Capacidade ultrapassada");
                return false;
            }
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
        
    }
    /*Retorna o volume total que o Veiculo transporta no momento*/
    public float getCapacidadeAtual(Veiculo veiculo, String data) throws SQLException{
        float cargaAtual = 0;
        Statement st = null;
        ResultSet rs = null;   
        String query;
        Regiao regiao;
        //query = "SELECT * FROM REGIAO;";
        try{
            st = conn.createStatement();
            rs = st.executeQuery("SELECT VC.PLACA, SUM(EQ.VOLUME) " +
"FROM TRANSPORTE_EQUIP TE JOIN EQUIPAMENTO EQ " +
"ON EQ.ID = TE.EQUIPAMENTO JOIN VEICULO_CARGA VC " +
"ON VC.PLACA = TE.VEICULO " +
"WHERE VC.PLACA = UPPER('" + veiculo.getPlaca() + "') AND TE.DATA = TO_DATE('" + data +
"','dd/mm/yyyy') GROUP BY VC.PLACA");
            
            while(rs.next()){
                    cargaAtual = rs.getFloat(2);
            }
            return cargaAtual;
        }finally{
            if(st != null)
                st.close();
            if(rs != null)
                rs.close();
        }
    }
}
