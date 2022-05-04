/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.facade;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.dao.ClienteDao;
import com.ufpr.tads.web2.dao.EnderecoDao;

public class ClienteFacade {
    public static Cliente logaCliente(String email, String senha) throws ClienteException {
        try {
            String senhaCriptografada = Ferramentas.criptografaSenha(senha);
            ClienteDao clienteDao = new ClienteDao();
            Cliente cliente = clienteDao.logaCliente(email, senhaCriptografada);

            return cliente;
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | SQLException | ClassNotFoundException e) {
            throw new ClienteException("Usuario nao cadastrado ou dados incorretos", e);
        }
    }

    public static ArrayList<Cliente> getLista() throws ClienteException {
        try {
            ClienteDao clienteDao = new ClienteDao();
            ArrayList<Cliente> listaClientes = clienteDao.retornaListaClientes();
            return listaClientes;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ClienteException("Erro ao retornar lista de clientes", e);
        }
    }

    public static Cliente adicionaCliente(Cliente cliente) throws ClienteException {
        try {
            String senhaCriptografada = Ferramentas.criptografaSenha(cliente.getSenha());
            cliente.setSenha(senhaCriptografada);
            ClienteDao clienteDao = new ClienteDao();
            Cliente clienteNovo = clienteDao.adicionaCliente(cliente);
            return clienteNovo;
        } catch (SQLException | NoSuchAlgorithmException | UnsupportedEncodingException | ClassNotFoundException e) {
            throw new ClienteException("Erro ao adicionar cliente", e);
        }
    }

    public static Cliente retornaCliente(int id) throws ClienteException {
        try {
            ClienteDao clienteDao = new ClienteDao();
            Cliente cliente = clienteDao.retornaClientePorId(id);
            return cliente;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ClienteException("Erro ao buscar cliente de id: " + id, e);
        }
    }

    public static boolean modificaCliente(Cliente cliente) throws ClienteException {
        try {
            String senhaCriptografada = Ferramentas.criptografaSenha(cliente.getSenha());
            Cliente clienteAntigo = ClienteFacade.retornaCliente(cliente.getIdCliente());
            String novaSenha = cliente.getSenha();
            String senhaAntiga = clienteAntigo.getSenha();
            if (!novaSenha.equals(senhaAntiga))
                cliente.setSenha(senhaCriptografada);

            ClienteDao clienteDao = new ClienteDao();
            EnderecoDao enderecoDao = new EnderecoDao();
            boolean confereModificacao = clienteDao.modificaCliente(cliente)
                    && enderecoDao.modificaEndereco(cliente.getEndereco());

            return confereModificacao;
        } catch (SQLException | ClassNotFoundException | NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new ClienteException("Erro ao modificar cliente", e);
        }
    }

    public static boolean removerCliente(Cliente cliente) throws ClienteException {
        try {
            ClienteDao clienteDao = new ClienteDao();
            boolean confereRemocao = clienteDao.removeCliente(cliente);

            return confereRemocao;
        } catch (SQLException | ClassNotFoundException e) {
            throw new ClienteException("Erro ao remover cliente", e);
        }
    }

}
