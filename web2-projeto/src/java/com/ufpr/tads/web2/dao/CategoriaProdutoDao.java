/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.CategoriaProduto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class CategoriaProdutoDao {
    private ConnectionFactory connectionFactory;
    private final String select = "SELECT idCategoria, nome FROM CategoriaProduto;";
    private final String selectById = "SELECT idCategoria, nome FROM CategoriaProduto WHERE idCategoria = ?;";
    private final String insert = "INSERT INTO CategoriaProduto (nome) VALUES (?);";
    private final String update = "UPDATE CategoriaProduto SET nome = ? WHERE idCategoria = ?;";
    private final String delete = "DELETE from CategoriaProduto WHERE idCategoria=?;";
    
    public CategoriaProdutoDao() {}
    
    public CategoriaProdutoDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public ArrayList<CategoriaProduto> retornaListaCategorias() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<CategoriaProduto> categorias = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                CategoriaProduto categoria = new CategoriaProduto();
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
                categorias.add(categoria);
            }
            return categorias;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public CategoriaProduto adicionaCategoria(CategoriaProduto categoria) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstm.setString(1, categoria.getNome());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                categoria.setIdCategoria(id);
            }
            return categoria;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public CategoriaProduto retornaCategoriaPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        CategoriaProduto categoria = new CategoriaProduto();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                categoria.setIdCategoria(rs.getInt("idCategoria"));
                categoria.setNome(rs.getString("nome"));
            }
            return categoria;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean modificaCategoria(CategoriaProduto categoria) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(update);
            pstm.setString(1, categoria.getNome());
            pstm.setInt(2, categoria.getIdCategoria());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean removeCategoria(CategoriaProduto categoria) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setLong(1, categoria.getIdCategoria());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
