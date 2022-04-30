/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Gerente extends Pessoa implements Serializable {
    private int idGerente;
    private String email;
    private String senha;
    
    public Gerente() {}
    
    public Gerente(String primeiroNome, String sobreNome, long cpf, Endereco endereco,
                   String telefone, String email, String senha)
    {
        super(primeiroNome, sobreNome, cpf, endereco, telefone);
        this.email = email;
        this.senha = senha;
    }
    
    public int getIdGerente()
    {
        return this.idGerente;
    }
    public void setIdGerente(int idGerente)
    {
        this.idGerente = idGerente;
    }
    
    public String getEmail()
    {
        return this.email;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    public String getSenha()
    {
        return this.senha;
    }
    public void setSenha(String senha)
    {
        this.senha = senha;
    }
}
