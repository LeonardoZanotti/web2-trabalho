/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.beans;

import java.io.Serializable;
import java.util.Calendar;


public class Atendimento implements Serializable{
    private int idAtendimento;
    private Cliente cliente;
    private Funcionario funcionario;
    private Produto produto;
    private TipoAtendimento tipoAtendimento;
    private Calendar dataHoraInicio;
    private Calendar dataHoraFim;
    private String reclamacao;
    private String solucao;
    private Situacao estado;
    
    public Atendimento() {}
    
    public Atendimento(Cliente cliente, Produto produto, TipoAtendimento tipoAtendimento, 
                       String reclamacao, Calendar dataHoraInicio, Situacao estado){
        this.cliente         = cliente;
        this.produto         = produto;
        this.tipoAtendimento = tipoAtendimento;
        this.reclamacao      = reclamacao;
        this.dataHoraInicio  = dataHoraInicio;
        this.estado          = estado;
    }
    
    public Atendimento(Cliente cliente, Funcionario funcionario,Produto produto, TipoAtendimento tipoAtendimento, 
                       String reclamacao, String solucao, Calendar dataHoraInicio, Calendar dataHoraFim,Situacao estado){
        this.cliente         = cliente;
        this.funcionario     = funcionario;
        this.produto         = produto;
        this.tipoAtendimento = tipoAtendimento;
        this.reclamacao      = reclamacao;
        this.solucao         = solucao;
        this.dataHoraInicio  = dataHoraInicio;
        this.dataHoraFim     = dataHoraFim;
        this.estado          = estado;
    }  
    
    public int getIdAtendimento(){
        return this.idAtendimento;
    }
    public void setIdAtendimento(int idAtendimento){
        this.idAtendimento = idAtendimento;
    }
    public Cliente getCliente(){
        return this.cliente;
    }
    public void setCliente(Cliente cliente){
        this.cliente = cliente;
    }
    public Funcionario getFuncionario(){
        return this.funcionario;
    }
    public void setFuncionario(Funcionario funcionario){
        this.funcionario = funcionario;
    }
    public Produto getProduto(){
        return this.produto;
    }
    public void setProduto(Produto produto){
        this.produto = produto;
    }
    
    public TipoAtendimento getTipoAtendimento(){
        return this.tipoAtendimento;
    }
    public void setTipoAtendimento(TipoAtendimento tipoAtendimento){
        this.tipoAtendimento = tipoAtendimento;
    }
    public Calendar getDataHoraInicio(){
        return this.dataHoraInicio;
    }
    public void setDataHoraInicio(Calendar dataHoraInicio){
        this.dataHoraInicio = dataHoraInicio;
    }
    
    public Calendar getDataHoraFim(){
        return this.dataHoraFim;
    }
    public void setDataHoraFim(Calendar dataHoraFim){
        this.dataHoraFim = dataHoraFim;
    }
    public String getReclamacao(){
        return this.reclamacao;
    }
    public void setReclamacao(String reclamacao){
        this.reclamacao = reclamacao;
    }
    public String getSolucao(){
        return this.solucao;
    }
    public void setSolucao(String solucao){
        this.solucao = solucao;
    }
    public Situacao getSituacao(){
        return this.estado;
    }
    public void setSituacao(Situacao estado){
        this.estado = estado;
    }
}
