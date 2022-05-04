/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Pessoa implements Serializable {
    private int idPessoa;
    private String primeiroNome;
    private String sobreNome;
    private long cpf;
    private Endereco endereco;
    private String telefone;
    
    public Pessoa() {}
    
    public Pessoa(String primeiroNome, String sobreNome, long cpf, Endereco endereco, String telefone){
        this.primeiroNome = primeiroNome;
        this.sobreNome    = sobreNome;
        this.cpf          = cpf;
        this.endereco     = endereco;
        this.telefone     = telefone;
    }
    
    public int getIdPessoa(){
        return this.idPessoa;
    }
    public void setIdPessoa(int idPessoa){
        this.idPessoa = idPessoa;
    }
    
    public String getPrimeiroNome(){
        return this.primeiroNome;
    }
    public void setPrimeiroNome(String primeiroNome){
        this.primeiroNome = primeiroNome;
    }
    
    public String getSobreNome(){
        return this.sobreNome;
    }
    public void setSobreNome(String sobreNome){
        this.sobreNome = sobreNome;
    }
    public long getCpf(){
        return this.cpf;
    }
    public void setCpf(long cpf){
        this.cpf = cpf;
    }
    public Endereco getEndereco(){
        return this.endereco;
    }
    public void setEndereco(Endereco endereco){
        this.endereco = endereco;
    }
    public String getTelefone(){
        return this.telefone;
    }
    public void setTelefone(String telefone){
        this.telefone = telefone;
    }  
}
