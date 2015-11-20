/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ctrl_soft;

/**
 *
 * @author Ude
 */
public class Funcionario {

    protected Long id;
    protected Long idFilial;
    protected String nome;
    protected String usuario;
    protected String senha;
    protected int ra;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected String endereco;
    protected String cidade;
    protected String uf;
    protected String cargo;

    public Funcionario() {

    }
    
    public Funcionario(Long id, Long idFilial, String nome, String usuario, String senha, int ra, String cpf, 
            String telefone, String email, String endereco, String cidade, String uf, String cargo) {
        this.id = id;
        this.idFilial = idFilial;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.ra = ra;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.endereco = endereco;
        this.cidade = cidade;
        this.uf = uf;
        this.cargo = cargo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdFilial() {
        return idFilial;
    }

    public void setIdFilial(long idFilial) {
        this.idFilial = idFilial;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
     public boolean autenticar(String usuario, String senha) {
        if (this.usuario != null) {

        }
        return false;
    }

    public boolean autorizar(String cargo) {
        return this.cargo.equals(cargo);
    }
   
}
