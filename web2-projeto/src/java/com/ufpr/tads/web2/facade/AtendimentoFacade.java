/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Funcionario;
import com.ufpr.tads.web2.beans.Situacao;
import com.ufpr.tads.web2.dao.AtendimentoDao;

public class AtendimentoFacade {
    public static ArrayList<Atendimento> getLista() throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            ArrayList<Atendimento> listaAtendimentos = atendimentoDao.retornaTodosAtendimentos();
            return listaAtendimentos;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException("Erro ao retornar lista de atendimentos", e);
        }
    }

    public static ArrayList<Atendimento> getListaPorCliente(Cliente cliente) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            ArrayList<Atendimento> listaAtendimentosPorCliente = atendimentoDao.retornaAtendimentosPorCliente(cliente);
            return listaAtendimentosPorCliente;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException(
                    "Erro ao retornar lista de atendimentos de cliente: " + cliente.getIdCliente(), e);
        }
    }

    public static ArrayList<Atendimento> getListaPorFuncionario(Funcionario funcionario) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            ArrayList<Atendimento> listaAtendimentosPorFuncionario = atendimentoDao
                    .retornaAtendimentosPorFuncionario(funcionario);
            return listaAtendimentosPorFuncionario;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException(
                    "Erro ao retornar lista de atendimentos de funcionario: " + funcionario.getIdFuncionario(), e);
        }
    }

    public static ArrayList<Atendimento> getListaPorSituacao(Situacao situacao) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            ArrayList<Atendimento> listaAtendimentosPorSituacao = atendimentoDao
                    .retornaAtendimentosPorSituacao(situacao);
            return listaAtendimentosPorSituacao;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException(
                    "Erro ao retornar lista de atendimentos de situacao: " + situacao.getIdSituacao(), e);
        }
    }

    public static Atendimento adicionaAtendimento(Atendimento atendimento) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            Atendimento atendimentoNovo = atendimentoDao.adicionaAtendimento(atendimento);
            return atendimentoNovo;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException("Erro ao adicionar atendimento", e);
        }
    }

    public static Atendimento retornaAtendimento(int id) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            Atendimento atendimento = atendimentoDao.retornaAtendimentoPorId(id);
            return atendimento;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException("Erro ao buscar atendimento de id: " + id, e);
        }
    }

    public static boolean modificaAtendimento(Atendimento atendimento) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            boolean confereModificacao = atendimentoDao.modificaAtendimento(atendimento);

            return confereModificacao;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException("Erro ao modificar atendimento", e);
        }
    }

    public static boolean removerAtendimento(Atendimento atendimento) throws AtendimentoException {
        try {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            boolean confereRemocao = atendimentoDao.removeAtendimento(atendimento);

            return confereRemocao;
        } catch (SQLException | ClassNotFoundException e) {
            throw new AtendimentoException("Erro ao remover atendimento", e);
        }
    }
}
