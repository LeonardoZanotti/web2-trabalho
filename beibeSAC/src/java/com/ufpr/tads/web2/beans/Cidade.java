/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Cidade implements Serializable {
    private int idCidade;
    private String nome;
    private Estado estado;
    
    public Cidade() {}
    
    public Cidade(String nome, Estado estado){
        this.nome   = nome;
        this.estado = estado;
    }
    
    public int getId(){
        return this.idCidade;
    }
    public void setId(int idCidade){
        this.idCidade = idCidade;
    }
    
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public Estado getEstado(){
        return this.estado;
    }
    public void setEstado(Estado estado){
        this.estado = estado;
    }
}
