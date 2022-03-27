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
    private int id, idCategoria;
    private float peso;
    private String nome, descricao;

    public Produto(float peso, String nome, int idCategoria, String descricao) {
        this.peso = peso;
        this.nome = nome;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public Produto(int id, float peso, String nome, int idCategoria, String descricao) {
        this.id = id;
        this.peso = peso;
        this.nome = nome;
        this.idCategoria = idCategoria;
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(int idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
}
