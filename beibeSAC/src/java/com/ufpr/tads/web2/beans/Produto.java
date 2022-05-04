/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;


public class Produto implements Serializable{
    private int idProduto;
    private String nome;
    private String descricao;
    private CategoriaProduto categoria;
    private float preco;
    private float peso;
    private int quantidadeReclamacoes;
    
    public Produto() {}
    
    public Produto(String nome, String descricao, CategoriaProduto categoria, float preco ,float peso, int quantidadeReclamacoes){
        this.nome                  = nome;
        this.descricao             = descricao;
        this.categoria             = categoria;
        this.preco                 = preco;
        this.peso                  = peso;
        this.quantidadeReclamacoes = quantidadeReclamacoes;
    }
    
    public int getIdProduto(){
        return this.idProduto;
    }
    public void setIdProduto(int idProduto){
        this.idProduto = idProduto;
    }
    public String getNome(){
        return this.nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    public String getDescricao(){
        return this.descricao;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    
    public CategoriaProduto getCategoria(){
        return this.categoria;
    }
    public void setCategoria(CategoriaProduto categoria){
        this.categoria = categoria;
    }
    public float getPreco(){
        return this.preco;
    }
    public void setPreco(float preco){
        this.preco = preco;
    }
    public float getPeso(){
        return this.peso;
    }
    public void setPeso(float peso){
        this.peso = peso;
    }
    public int getQtdReclamacoes(){
        return this.quantidadeReclamacoes;
    }
    public void setQtdReclamacoes(int quantidadeReclamacoes){
        this.quantidadeReclamacoes = quantidadeReclamacoes;
    }
}
