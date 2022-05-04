/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class LoginBean implements Serializable {
    private String nome;
    private int id;
    
    public LoginBean() {}
    
    public LoginBean(int id, String nome){
        this.id   = id;
        this.nome = nome;
    }
    
    public int getId(){
        return id;
    }
    public String getNome(){
        return nome;
    }
}
