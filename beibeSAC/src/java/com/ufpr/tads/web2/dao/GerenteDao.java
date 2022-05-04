/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Gerente;
import com.ufpr.tads.web2.beans.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class GerenteDao {
    private ConnectionFactory connectionFactory;
    private final String findLogin = "SELECT idGerente, idPessoa, email, senha FROM Gerente WHERE email=? AND senha=?;";
    private final String select = "SELECT idGerente, idPessoa, email, senha FROM Gerente;";
    private final String selectById = "SELECT idGerente, idPessoa, email, senha FROM Gerente WHERE idGerente=?;";
    private final String insert = "INSERT INTO Gerente (idPessoa, email, senha) VALUES (?,?,?);";
    private final String update = "UPDATE Gerente SET senha=? WHERE idGerente=?;";
    private final String delete = "DELETE FROM Gerente WHERE idGerente=?;";
    
    public GerenteDao() {}
    
    public GerenteDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public Gerente logaGerente(String login, String senha) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Gerente gerente = new Gerente();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(findLogin);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));                
                gerente.setIdGerente(rs.getInt("idGerente"));
                gerente.setEmail(rs.getString("email"));
                gerente.setSenha(rs.getString("senha"));
                gerente.setIdPessoa(pessoa.getIdPessoa());
                gerente.setPrimeiroNome(pessoa.getPrimeiroNome());
                gerente.setSobreNome(pessoa.getSobreNome());
                gerente.setCpf(pessoa.getCpf());
                gerente.setTelefone(pessoa.getTelefone());
                gerente.setEndereco(pessoa.getEndereco());
            }
            return gerente;
        } finally {
            pstm.close();
            con.close();
        }
    }

    public ArrayList<Gerente> retornaListaGerentes() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Gerente> gerentes = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Gerente gerente = new Gerente();
                gerente.setIdGerente(rs.getInt("idGerente"));
                gerente.setEmail(rs.getString("email"));
                gerente.setSenha(rs.getString("senha"));
                
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                gerente.setIdPessoa(pessoa.getIdPessoa());
                gerente.setPrimeiroNome(pessoa.getPrimeiroNome());
                gerente.setSobreNome(pessoa.getSobreNome());
                gerente.setCpf(pessoa.getCpf());
                gerente.setTelefone(pessoa.getTelefone());
                gerente.setEndereco(pessoa.getEndereco());
                gerentes.add(gerente);
            }
            return gerentes;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Gerente adicionaGerente(Gerente gerente) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaGerente = gerente;
            Pessoa pessoaNovo = pessoaDao.adicionaPessoa(pessoaGerente);
            
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, pessoaNovo.getIdPessoa());
            pstm.setString(2, gerente.getEmail());
            pstm.setString(3, gerente.getSenha());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                gerente.setIdGerente(id);
            }
            return gerente;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Gerente retornaGerentePorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Gerente gerente = new Gerente();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                gerente.setIdGerente(rs.getInt("idGerente"));
                gerente.setEmail(rs.getString("email"));
                gerente.setSenha(rs.getString("senha"));
                
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                gerente.setIdPessoa(pessoa.getIdPessoa());
                gerente.setPrimeiroNome(pessoa.getPrimeiroNome());
                gerente.setSobreNome(pessoa.getSobreNome());
                gerente.setCpf(pessoa.getCpf());
                gerente.setTelefone(pessoa.getTelefone());
                gerente.setEndereco(pessoa.getEndereco());
            }
            return gerente;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean modificaGerente(Gerente gerente) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaGerente = gerente;
            pessoaDao.modificaPessoa(pessoaGerente);
            
            pstm = con.prepareStatement(update);
            pstm.setString(1, gerente.getSenha());
            pstm.setInt(2, gerente.getIdGerente());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }

    public boolean removeGerente(Gerente gerente) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setLong(1, gerente.getIdGerente());
            int i = pstm.executeUpdate();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaGerente = gerente;
            pessoaDao.removePessoa(pessoaGerente);
            
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
