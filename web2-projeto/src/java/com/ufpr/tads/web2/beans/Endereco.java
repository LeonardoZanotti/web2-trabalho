/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Endereco implements Serializable {
    private int idEndereco;
    private String rua;
    private int numero;
    private String complemento;
    private String bairro;
    private int cep;
    private Cidade cidade;
    
    public Endereco() {}
    
    public Endereco(String rua, int numero, String complemento, String bairro, int cep, Cidade cidade)
    {
        this.rua         = rua;
        this.numero      = numero;
        this.complemento = complemento;
        this.bairro      = bairro;
        this.cep         = cep;
        this.cidade      = cidade;
    }
    
    public int getId()
    {
        return this.idEndereco;
    }
    public void setId(int idEndereco)
    {
        this.idEndereco = idEndereco;
    }
    
    public String getRua()
    {
        return this.rua;
    }
    public void setRua(String rua)
    {
        this.rua = rua;
    }
    
    public int getNumero()
    {
        return this.numero;
    }
    public void setNumero(int numero)
    {
        this.numero = numero;
    }
    
    public String getComplemento()
    {
        return this.complemento;
    }
    public void setComplemento(String complemento)
    {
        this.complemento = complemento;
    }
    
    public String getBairro()
    {
        return this.bairro;
    }
    public void setBairro(String bairro)
    {
        this.bairro = bairro;
    }
    
    public int getCep()
    {
        return this.cep;
    }
    public void setCep(int cep)
    {
        this.cep = cep;
    }
    
    public Cidade getCidade()
    {
        return this.cidade;
    }
    public void setCidade(Cidade cidade)
    {
        this.cidade = cidade;
    }
            
}
