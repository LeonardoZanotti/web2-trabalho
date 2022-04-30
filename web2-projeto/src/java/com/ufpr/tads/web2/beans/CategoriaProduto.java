/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class CategoriaProduto implements Serializable {
    private int idCategoria;
    private String nome;
    
    public CategoriaProduto() {}
    
    public CategoriaProduto(String nome)
    {
        this.nome = nome;
    }
    
    public int getIdCategoria()
    {
        return this.idCategoria;
    }
    public void setIdCategoria(int idCategoria)
    {
        this.idCategoria = idCategoria;
    }
    
    public String getNome()
    {
        return this.nome;
    }
    public void setNome(String nome)
    {
        this.nome = nome;
    }
}
