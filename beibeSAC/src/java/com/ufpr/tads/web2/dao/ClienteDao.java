/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ClienteDao {
    private ConnectionFactory connectionFactory;
    private final String findLogin = "SELECT idCliente, idPessoa, email, senha FROM Cliente WHERE email=? AND senha=?;";
    private final String select = "SELECT idCliente, idPessoa, email, senha FROM Cliente;";
    private final String selectById = "SELECT idCliente, idPessoa, email, senha FROM Cliente WHERE idCliente=?;";
    private final String insert = "INSERT INTO Cliente (idPessoa, email, senha) VALUES (?,?,?);";
    private final String update = "UPDATE Cliente SET senha=? WHERE idCliente=?;";
    private final String delete = "DELETE FROM Cliente WHERE idCliente=?;";

    public ClienteDao() {}
    
    public ClienteDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }

    public Cliente logaCliente(String login, String senha) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Cliente cliente = new Cliente();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(findLogin);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                cliente.setIdPessoa(pessoa.getIdPessoa());
                cliente.setPrimeiroNome(pessoa.getPrimeiroNome());
                cliente.setSobreNome(pessoa.getSobreNome());
                cliente.setCpf(pessoa.getCpf());
                cliente.setTelefone(pessoa.getTelefone());
                cliente.setEndereco(pessoa.getEndereco());
            }
            return cliente;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public ArrayList<Cliente> retornaListaClientes() throws SQLException, ClassNotFoundException 
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Cliente> clientes = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Cliente cliente = new Cliente();
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                cliente.setIdPessoa(pessoa.getIdPessoa());
                cliente.setPrimeiroNome(pessoa.getPrimeiroNome());
                cliente.setSobreNome(pessoa.getSobreNome());
                cliente.setCpf(pessoa.getCpf());
                cliente.setTelefone(pessoa.getTelefone());
                cliente.setEndereco(pessoa.getEndereco());
                clientes.add(cliente);
            }
            return clientes;
        } finally {
            pstm.close();
            con.close();
        }      
    }
    
    public Cliente adicionaCliente(Cliente cliente) throws SQLException, ClassNotFoundException 
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaCliente = cliente;
            Pessoa pessoaNovo = pessoaDao.adicionaPessoa(pessoaCliente);
            
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, pessoaNovo.getIdPessoa());
            pstm.setString(2, cliente.getEmail());
            pstm.setString(3, cliente.getSenha());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                cliente.setIdCliente(id);
            }
            return cliente;
        } finally {
            pstm.close();
            con.close();
        }
    }

    public Cliente retornaClientePorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Cliente cliente = new Cliente();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                cliente.setIdCliente(rs.getInt("idCliente"));
                cliente.setEmail(rs.getString("email"));
                cliente.setSenha(rs.getString("senha"));
                
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                cliente.setIdPessoa(pessoa.getIdPessoa());
                cliente.setPrimeiroNome(pessoa.getPrimeiroNome());
                cliente.setSobreNome(pessoa.getSobreNome());
                cliente.setCpf(pessoa.getCpf());
                cliente.setTelefone(pessoa.getTelefone());
                cliente.setEndereco(pessoa.getEndereco());
            }
            return cliente;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean modificaCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaCliente = cliente;
            pessoaDao.modificaPessoa(pessoaCliente);
            
            pstm = con.prepareStatement(update);
            pstm.setString(1, cliente.getSenha());
            pstm.setInt(2, cliente.getIdCliente());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean removeCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setLong(1, cliente.getIdCliente());
            int i = pstm.executeUpdate();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaCliente = cliente;
            pessoaDao.removePessoa(pessoaCliente);

            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }   
}
