/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;

/**
 *
 * @author lenovo
 */
public class Transporte_Pessoa {
    private CentroDePratica centroDePratica;
    private String veiculos;
    private String membros;
    private String datas;

    public CentroDePratica getCentroDePratica() {
        return centroDePratica;
    }

    

    public String getVeiculos() {
        return veiculos;
    }

    public String getMembros() {
        return membros;
    }

    public void setCentroDePratica(CentroDePratica centroDePratica) {
        this.centroDePratica = centroDePratica;
    }

    
    public void setVeiculos(String veiculos) {
        this.veiculos = veiculos;
    }

    public void setMembros(String membros) {
        this.membros = membros;
    }

   
    public void setDatas(String datas) {
        this.datas = datas;
    }

    public String getDatas() {
        return datas;
    }

}
