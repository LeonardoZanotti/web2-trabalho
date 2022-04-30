/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Situacao;
import com.ufpr.tads.web2.dao.SituacaoDao;
import java.sql.SQLException;
import java.util.ArrayList;


public class SituacaoFacade {   
    public static ArrayList<Situacao> getLista() throws SituacaoException
    {
        try
        {
            SituacaoDao situacaoDao = new SituacaoDao();
            ArrayList<Situacao> listaSituacoes = situacaoDao.retornaListaSituacoes();
            return listaSituacoes;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new SituacaoException("Erro ao retornar lista de situacoes", e);
        }
    }
    
    public static Situacao retornaSituacao(int id) throws SituacaoException
    {
        try
        {
            SituacaoDao situacaoDao = new SituacaoDao();
            Situacao situacao = situacaoDao.retornaSituacaoPorId(id);
            return situacao;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new SituacaoException("Erro ao buscar situacao de id: " + id, e);
        }
    }
}
