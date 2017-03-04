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
public class Regiao {
    private String nome;
    private List<Atracao> atracoes;
    public String getNome() {
        return nome;
    }

    public List<Atracao> getAtracoes() {
        return atracoes;
    }

    public void setAtracoes(List<Atracao> atracoes) {
        this.atracoes = atracoes;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
