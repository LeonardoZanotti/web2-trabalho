/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.ufpr.tads.web2.beans.Endereco;

public class EnderecoDao {
    private ConnectionFactory connectionFactory;
    private final String selectById = "SELECT idEndereco, idCidade, rua, numero, complemento, bairro, cep FROM Endereco WHERE idEndereco = ?;";
    private final String insert = "INSERT INTO Endereco (idCidade, rua, numero, complemento, bairro, cep) VALUES (?,?,?,?,?,?);";
    private final String update = "UPDATE Endereco SET idCidade=?, rua=?, numero=?, complemento=?, bairro=?, cep=? WHERE idEndereco=?;";
    private final String delete = "DELETE FROM Endereco WHERE idEndereco=?;";

    public EnderecoDao() {
    }

    public EnderecoDao(ConnectionFactory conFactory) {
        this.connectionFactory = conFactory;
    }

    public Endereco adicionaEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            pstm.setInt(1, endereco.getCidade().getId());
            pstm.setString(2, endereco.getRua());
            pstm.setInt(3, endereco.getNumero());
            pstm.setString(4, endereco.getComplemento());
            pstm.setString(5, endereco.getBairro());
            pstm.setInt(6, endereco.getCep());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();

            Long insertKey = null;
            if (rsKey.next()) {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                endereco.setId(id);
            }
            return endereco;
        } finally {
            pstm.close();
            con.close();
        }
    }

    public Endereco retornaEnderecoPorId(int id) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;

        Endereco endereco = new Endereco();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                endereco.setId(rs.getInt("idEndereco"));
                endereco.setRua(rs.getString("rua"));
                endereco.setNumero(rs.getInt("numero"));
                endereco.setComplemento(rs.getString("complemento"));
                endereco.setBairro(rs.getString("bairro"));
                endereco.setCep(rs.getInt("cep"));

                CidadeDao cidadeDao = new CidadeDao();
                endereco.setCidade(cidadeDao.retornaCidadePorId(rs.getInt("idCidade")));
            }
            return endereco;
        } finally {
            pstm.close();
            con.close();
        }
    }

    public boolean modificaEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(update);
            pstm.setInt(1, endereco.getCidade().getId());
            pstm.setString(2, endereco.getRua());
            pstm.setInt(3, endereco.getNumero());
            pstm.setString(4, endereco.getComplemento());
            pstm.setString(5, endereco.getBairro());
            pstm.setInt(6, endereco.getCep());
            pstm.setInt(7, endereco.getId());

            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }

    public boolean removeEndereco(Endereco endereco) throws SQLException, ClassNotFoundException {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setInt(1, endereco.getId());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
