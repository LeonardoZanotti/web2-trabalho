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
    private int id;
    private Date dataInicio, dataFim;
    private String reclamacao, solucao, tipoAtendimento, situacao;

    public Atendimento(Date dataInicio, Date dataFim, String reclamacao, String solucao, String tipoAtendimento, String situacao) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.reclamacao = reclamacao;
        this.solucao = solucao;
        this.tipoAtendimento = tipoAtendimento;
        this.situacao = situacao;
    }
    
    public Atendimento( int id, Date dataInicio, Date dataFim, String reclamacao, String solucao, String tipoAtendimento, String situacao) {
        this.id = id;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.reclamacao = reclamacao;
        this.solucao = solucao;
        this.tipoAtendimento = tipoAtendimento;
        this.situacao = situacao;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
}
