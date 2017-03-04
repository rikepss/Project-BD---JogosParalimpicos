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
public class Membro {
    private int n_cartao;
    private String delegacao;
    private String passaporte;
    private char sexo;
    private String cpf;
    private String nome;

    public int getN_cartao() {
        return n_cartao;
    }

    public void setN_cartao(int n_cartao) {
        this.n_cartao = n_cartao;
    }

    public void setDelegacao(String delegacao) {
        this.delegacao = delegacao;
    }

    public void setPassaporte(String passaporte) {
        this.passaporte = passaporte;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCor_cartao(String cor_cartao) {
        this.cor_cartao = cor_cartao;
    }

    public String getDelegacao() {
        return delegacao;
    }

    public String getPassaporte() {
        return passaporte;
    }

    public char getSexo() {
        return sexo;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCor_cartao() {
        return cor_cartao;
    }
    private String cor_cartao;
}