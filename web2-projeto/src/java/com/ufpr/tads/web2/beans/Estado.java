/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Estado implements Serializable {
    private int idEstado;
    private String nome;
    private String sigla;
    
    public Estado() {}
    
    public Estado(String nome, String sigla)
    {
        this.nome  = nome;
        this.sigla = sigla;
    }
    
    public int getId()
    {
        return this.idEstado;
    }
    public void setId(int idEstado)
    {
        this.idEstado = idEstado;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    public String getSigla()
    {
        return this.sigla;
    }
    public void setSigla(String sigla)
    {
        this.sigla = sigla;
    }
}
