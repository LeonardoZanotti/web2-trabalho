/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Situacao implements Serializable {
    private int idSituacao;
    private String estado;
    
    public Situacao() {}
    
    public Situacao(String estado){
        this.estado = estado;
    }
    
    public int getIdSituacao(){
        return this.idSituacao;
    }
    public void setIdSituacao(int idSituacao){
        this.idSituacao = idSituacao;
    }
    public String getEstado(){
        return this.estado;
    }
    public void setEstado(String estado){
        this.estado = estado;
    }
}
