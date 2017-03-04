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
public class Atracao {
    private String nome;
    private String endereco;
    private List<Regiao> regioes;

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setRegioes(List<Regiao> regioes) {
        this.regioes = regioes;
    }

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public List<Regiao> getRegioes() {
        return regioes;
    }
}
