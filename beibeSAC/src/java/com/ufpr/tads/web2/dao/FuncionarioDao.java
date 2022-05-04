/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Funcionario;
import com.ufpr.tads.web2.beans.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class FuncionarioDao {
    private ConnectionFactory connectionFactory;
    private final String findLogin = "SELECT idFuncionario, idPessoa, email, senha FROM Funcionario WHERE email=? AND senha=?;";
    private final String select = "SELECT idFuncionario, idPessoa, email, senha FROM Funcionario;";
    private final String selectById = "SELECT idFuncionario, idPessoa, email, senha FROM Funcionario WHERE idFuncionario=?;";
    private final String insert = "INSERT INTO Funcionario (idPessoa, email, senha) VALUES (?,?,?);";
    private final String update = "UPDATE Funcionario SET senha=? WHERE idFuncionario=?;";
    private final String delete = "DELETE FROM Funcionario WHERE idFuncionario=?;";
    
    public FuncionarioDao() {}
    
    public FuncionarioDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public Funcionario logaFuncionario(String login, String senha) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Funcionario funcionario = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(findLogin);
            pstm.setString(1, login);
            pstm.setString(2, senha);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                funcionario.setIdPessoa(pessoa.getIdPessoa());
                funcionario.setPrimeiroNome(pessoa.getPrimeiroNome());
                funcionario.setSobreNome(pessoa.getSobreNome());
                funcionario.setCpf(pessoa.getCpf());
                funcionario.setTelefone(pessoa.getTelefone());
                funcionario.setEndereco(pessoa.getEndereco());
            }
            return funcionario;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public ArrayList<Funcionario> retornaListaFuncionarios() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Funcionario> funcionarios = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Funcionario funcionario = new Funcionario();
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                funcionario.setIdPessoa(pessoa.getIdPessoa());
                funcionario.setPrimeiroNome(pessoa.getPrimeiroNome());
                funcionario.setSobreNome(pessoa.getSobreNome());
                funcionario.setCpf(pessoa.getCpf());
                funcionario.setTelefone(pessoa.getTelefone());
                funcionario.setEndereco(pessoa.getEndereco());
                funcionarios.add(funcionario);
            }
            return funcionarios;
        } finally {
            pstm.close();
            con.close();
        }  
    }
    
    public Funcionario adicionaFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaFuncionario = funcionario;
            Pessoa pessoaNovo = pessoaDao.adicionaPessoa(pessoaFuncionario);
            
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, pessoaNovo.getIdPessoa());
            pstm.setString(2, funcionario.getEmail());
            pstm.setString(3, funcionario.getSenha());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                funcionario.setIdFuncionario(id);
            }
            return funcionario;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Funcionario retornaFuncionarioPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Funcionario funcionario = new Funcionario();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                funcionario.setIdFuncionario(rs.getInt("idFuncionario"));
                funcionario.setEmail(rs.getString("email"));
                funcionario.setSenha(rs.getString("senha"));
                
                PessoaDao pessoaDao = new PessoaDao();
                Pessoa pessoa = pessoaDao.retornaPessoaPorId(rs.getInt("idPessoa"));
                funcionario.setIdPessoa(pessoa.getIdPessoa());
                funcionario.setPrimeiroNome(pessoa.getPrimeiroNome());
                funcionario.setSobreNome(pessoa.getSobreNome());
                funcionario.setCpf(pessoa.getCpf());
                funcionario.setTelefone(pessoa.getTelefone());
                funcionario.setEndereco(pessoa.getEndereco());
            }
            return funcionario;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean modificaFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaFuncionario = funcionario;
            pessoaDao.modificaPessoa(pessoaFuncionario);
            
            pstm = con.prepareStatement(update);
            pstm.setString(1, funcionario.getSenha());
            pstm.setInt(2, funcionario.getIdFuncionario());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean removeFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setInt(1, funcionario.getIdFuncionario());
            int i = pstm.executeUpdate();
            
            PessoaDao pessoaDao = new PessoaDao();
            Pessoa pessoaFuncionario = funcionario;
            pessoaDao.removePessoa(pessoaFuncionario);
            
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
