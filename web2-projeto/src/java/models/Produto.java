/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

/**
 *
 * @author leonardozanotti
 */
public class Produto {
    private int id, peso;
    private String nome, categoria, descricao;

    public Produto(int peso, String nome, String categoria, String descricao) {
        this.peso = peso;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public Produto(int id, int peso, String nome, String categoria, String descricao) {
        this.id = id;
        this.peso = peso;
        this.nome = nome;
        this.categoria = categoria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
