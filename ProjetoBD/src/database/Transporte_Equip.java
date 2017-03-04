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
public class Transporte_Equip {
    private List<Equipamento> equipamentos;
    private CentroDePratica centro_de_pratica;
    private Veiculo placaVeiculo;
    private String data;
    
    public List<Equipamento> getEquipameentos() {
        return equipamentos;
    }

    public void setEquipameentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }


    public void setEquipamentos(List<Equipamento> equipamentos) {
        this.equipamentos = equipamentos;
    }


    public List<Equipamento> getEquipamentos() {
        return equipamentos;
    }

    public void setCentro_de_pratica(CentroDePratica centro_de_pratica) {
        this.centro_de_pratica = centro_de_pratica;
    }

    public void setPlacaVeiculo(Veiculo placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }
    
}
