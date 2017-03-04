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
public class CentroDePratica {
    private int id;
    private String nome;
    private Regiao regiao;
    private String endereco;
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRegiao(Regiao regiao) {
        this.regiao = regiao;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public Regiao getRegiao() {
        return regiao;
    }

    public String getEndereco() {
        return endereco;
    }
}
