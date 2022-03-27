/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models;

import java.util.Date;

/**
 *
 * @author leonardozanotti
 */
public class Atendimento {
    private int id, idProduto, idUsuario;
    private Date dataInicio, dataFim;
    private String reclamacao, solucao, tipoAtendimento, situacao;

    public Atendimento(int idProduto, int idUsuario, Date dataInicio, Date dataFim, String reclamacao, String solucao, String tipoAtendimento, String situacao) {
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.reclamacao = reclamacao;
        this.solucao = solucao;
        this.tipoAtendimento = tipoAtendimento;
        this.situacao = situacao;
    }
    
    public Atendimento(int id, int idProduto, int idUsuario, Date dataInicio, Date dataFim, String reclamacao, String solucao, String tipoAtendimento, String situacao) {
        this.id = id;
        this.idProduto = idProduto;
        this.idUsuario = idUsuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.reclamacao = reclamacao;
        this.solucao = solucao;
        this.tipoAtendimento = tipoAtendimento;
        this.situacao = situacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public String getReclamacao() {
        return reclamacao;
    }

    public void setReclamacao(String reclamacao) {
        this.reclamacao = reclamacao;
    }

    public String getSolucao() {
        return solucao;
    }

    public void setSolucao(String solucao) {
        this.solucao = solucao;
    }

    public String getTipoAtendimento() {
        return tipoAtendimento;
    }

    public void setTipoAtendimento(String tipoAtendimento) {
        this.tipoAtendimento = tipoAtendimento;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
}
