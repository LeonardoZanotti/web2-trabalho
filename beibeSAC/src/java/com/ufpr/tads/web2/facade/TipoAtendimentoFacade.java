/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.TipoAtendimento;
import com.ufpr.tads.web2.dao.TipoAtendimentoDao;
import java.sql.SQLException;
import java.util.ArrayList;


public class TipoAtendimentoFacade {
    public static ArrayList<TipoAtendimento> getLista() throws TipoAtendimentoException
    {
        try
        {
            TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
            ArrayList<TipoAtendimento> listaTiposAtendimento =  tipoAtendimentoDao.retornaListaTipoAtendimentos();
            return listaTiposAtendimento;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new TipoAtendimentoException("Erro ao retornar tipos de atendimento", e);
        }
    }
    
    public static TipoAtendimento retornaTipoAtendimento(int id) throws TipoAtendimentoException
    {
        try
        {
            TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
            TipoAtendimento tipoAtendimento = tipoAtendimentoDao.retornaTipoAtendimentoPorId(id);
            return tipoAtendimento;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new TipoAtendimentoException("Erro ao buscar tipo de atendimento de id: " + id, e);
        }
    }
}
