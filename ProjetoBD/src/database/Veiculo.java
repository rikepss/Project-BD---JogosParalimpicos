/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author lenovo
 */
public class Veiculo {
    private String placa;
    private float capacidade;
    private float cargaAtual;
    
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public float getCargaAtual() {
        return cargaAtual;
    }

    public String getPlaca() {
        return placa;
    }

    public void setCargaAtual(float cargaAtual) {
        this.cargaAtual = cargaAtual;
    }

    public float getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(float capacidade) {
        this.capacidade = capacidade;
    }
}
