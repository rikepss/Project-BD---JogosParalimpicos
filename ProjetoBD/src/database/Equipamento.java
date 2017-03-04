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
public class Equipamento {
    private int id;
    private String tipo;
    private int quantidade;
    private float volume;
    private String placaVeiculo;
    private Membro dono;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public void setVolume(float volume) {
        this.volume = volume;
    }

    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    public void setDono(Membro dono) {
        this.dono = dono;
    }

    public String getTipo() {
        return tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public float getVolume() {
        return volume;
    }

    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    public Membro getDono() {
        return dono;
    }
    
}