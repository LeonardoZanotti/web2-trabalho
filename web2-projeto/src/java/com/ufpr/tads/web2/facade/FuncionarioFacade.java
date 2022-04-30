/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Funcionario;
import com.ufpr.tads.web2.dao.AtendimentoDao;
import com.ufpr.tads.web2.dao.FuncionarioDao;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;


public class FuncionarioFacade {
    public static Funcionario logaFuncionario(String email, String senha) throws FuncionarioException
    {
        try
        {
            String senhaCriptografada = Ferramentas.criptografaSenha(senha);
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.logaFuncionario(email, senhaCriptografada);
            
            return funcionario;
        }
        catch(NoSuchAlgorithmException | UnsupportedEncodingException | SQLException | ClassNotFoundException e)
        {
            throw new FuncionarioException("Funcionario nao cadastrado ou dados incorretos", e);
        }
    }
    
    public static ArrayList<Funcionario> getLista() throws FuncionarioException
    {
        try
        {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            ArrayList<Funcionario> listaFuncionarios = funcionarioDao.retornaListaFuncionarios();
            return listaFuncionarios;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new FuncionarioException("Erro ao retornar lista de funcionarios", e);
        }
    }
    
    public static Funcionario adicionaFuncionario(Funcionario funcionario) throws FuncionarioException
    {
        try
        {
            String senhaCriptografada = Ferramentas.criptografaSenha(funcionario.getSenha());
            funcionario.setSenha(senhaCriptografada);
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionarioNovo = funcionarioDao.adicionaFuncionario(funcionario);
            return funcionarioNovo;
        }
        catch(SQLException | NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException e)
        {
            throw new FuncionarioException("Erro ao adicionar funcionario", e);
        }
    }
    
    public static Funcionario retornaFuncionario(int id) throws FuncionarioException
    {
        try
        {
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            Funcionario funcionario = funcionarioDao.retornaFuncionarioPorId(id);
            return funcionario;
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new FuncionarioException("Erro ao buscar funcionario de id: " + id, e);
        }
    }
    
    public static boolean modificaFuncionario(Funcionario funcionario) throws FuncionarioException
    {
        try
        {
            String senhaCriptografada = Ferramentas.criptografaSenha(funcionario.getSenha());
            Funcionario funcionarioAntigo = FuncionarioFacade.retornaFuncionario(funcionario.getIdFuncionario());
            String novaSenha = funcionario.getSenha();
            String senhaAntiga = funcionarioAntigo.getSenha();
            if (!novaSenha.equals(senhaAntiga))
                    funcionario.setSenha(senhaCriptografada);   
            
            FuncionarioDao funcionarioDao = new FuncionarioDao();
            boolean confereModificacao = funcionarioDao.modificaFuncionario(funcionario);
            
            return confereModificacao;
        }
        catch(SQLException | ClassNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException e)
        {
            throw new FuncionarioException("Erro ao modificar funcionario", e);
        }
    }
    
    public static boolean removerFuncionario(Funcionario funcionario) throws FuncionarioException
    {
        try
        {
            AtendimentoDao atendimentoDao = new AtendimentoDao();
            ArrayList<Atendimento> listaAtendimentos = atendimentoDao.retornaAtendimentosPorFuncionario(funcionario);
            
            if (listaAtendimentos.isEmpty()) {
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                boolean confereRemocao = funcionarioDao.removeFuncionario(funcionario);
                return confereRemocao;
            }
            else {
                return false;
            }
        }
        catch(SQLException | ClassNotFoundException e)
        {
            throw new FuncionarioException("Erro ao remover funcionario", e);
        }
    }
}
