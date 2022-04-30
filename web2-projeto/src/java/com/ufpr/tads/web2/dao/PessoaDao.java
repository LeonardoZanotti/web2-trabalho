/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Endereco;
import com.ufpr.tads.web2.beans.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class PessoaDao {
    private ConnectionFactory connectionFactory;
    private final String selectById = "SELECT idPessoa, idEndereco, primeiroNome, sobreNome, cpf, telefone FROM Pessoa WHERE idPessoa=?;";
    private final String insert = "INSERT INTO Pessoa (idEndereco, primeiroNome, sobreNome, cpf, telefone) VALUES (?,?,?,?,?);";
    private final String update = "UPDATE Pessoa SET primeiroNome=?, sobreNome=?, telefone=? WHERE idPessoa=?;";
    private final String delete = "DELETE FROM Pessoa WHERE idPessoa=?;";
    
    public PessoaDao() {}
    
    public PessoaDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public Pessoa adicionaPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException
    {
        // ver como dar rollback ou trigger
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            EnderecoDao enderecoDao = new EnderecoDao();
            Endereco enderecoNovo = enderecoDao.adicionaEndereco(pessoa.getEndereco());
            
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, enderecoNovo.getId());
            pstm.setString(2, pessoa.getPrimeiroNome());
            pstm.setString(3, pessoa.getSobreNome());
            pstm.setLong(4, pessoa.getCpf());
            pstm.setString(5, pessoa.getTelefone());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                pessoa.setIdPessoa(id);
            }
            return pessoa;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Pessoa retornaPessoaPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Pessoa pessoa = new Pessoa();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                pessoa.setIdPessoa(rs.getInt("idPessoa"));
                pessoa.setPrimeiroNome(rs.getString("primeiroNome"));
                pessoa.setSobreNome(rs.getString("sobreNome"));
                pessoa.setCpf(rs.getLong("cpf"));
                pessoa.setTelefone(rs.getString("telefone"));

                EnderecoDao enderecoDao = new EnderecoDao();
                pessoa.setEndereco(enderecoDao.retornaEnderecoPorId(rs.getInt("idEndereco")));
            }
            return pessoa;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean modificaPessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            
            EnderecoDao enderecoDao = new EnderecoDao();
            enderecoDao.modificaEndereco(pessoa.getEndereco());
            
            pstm = con.prepareStatement(update);
            pstm.setString(1, pessoa.getPrimeiroNome());
            pstm.setString(2, pessoa.getSobreNome());
            pstm.setString(3, pessoa.getTelefone());
            pstm.setInt(4, pessoa.getIdPessoa());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean removePessoa(Pessoa pessoa) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setLong(1, pessoa.getIdPessoa());
            int i = pstm.executeUpdate();
            
            EnderecoDao enderecoDao = new EnderecoDao();
            enderecoDao.removeEndereco(pessoa.getEndereco());

            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
