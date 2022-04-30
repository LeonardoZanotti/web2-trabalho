/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProdutoDao {
    private ConnectionFactory connectionFactory;
    private final String select = "SELECT idProduto, idCategoriaProduto, nome, descricao, peso, preco, quantidadeReclamacoes FROM Produto;";
    private final String selectById = "SELECT idProduto, idCategoriaProduto, nome, descricao, peso, preco, quantidadeReclamacoes FROM Produto WHERE idProduto = ?;";
    private final String insert = "INSERT INTO Produto (idCategoriaProduto, nome, descricao, peso, preco, quantidadeReclamacoes) VALUES (?,?,?,?,?,?);";
    private final String update = "UPDATE Produto SET idCategoriaProduto=?, nome=?, descricao=?, peso=?, preco=?, quantidadeReclamacoes=? WHERE idProduto = ?;";
    private final String delete = "DELETE from Produto WHERE idProduto=?;";
    
    public ProdutoDao() {}
    
    public ProdutoDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public ArrayList<Produto> retornaListaProdutos() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Produto> produtos = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPeso(rs.getFloat("peso"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQtdReclamacoes(rs.getInt("quantidadeReclamacoes"));
                
                CategoriaProdutoDao categoriaDao = new CategoriaProdutoDao();
                produto.setCategoria(categoriaDao.retornaCategoriaPorId(rs.getInt("idCategoriaProduto")));
                
                produtos.add(produto);
            }
            return produtos;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Produto adicionaProduto(Produto produto) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            
            pstm.setInt(1, produto.getCategoria().getIdCategoria());
            pstm.setString(2, produto.getNome());
            pstm.setString(3, produto.getDescricao());
            pstm.setFloat(4, produto.getPeso());
            pstm.setFloat(5, produto.getPreco());
            pstm.setInt(6, 0); // Quantidade de Reclamações
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                produto.setIdProduto(id);
            }
            return produto;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Produto retornaProdutoPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        Produto produto = new Produto();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                produto.setIdProduto(rs.getInt("idProduto"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setPeso(rs.getFloat("peso"));
                produto.setPreco(rs.getFloat("preco"));
                produto.setQtdReclamacoes(rs.getInt("quantidadeReclamacoes"));
                
                CategoriaProdutoDao categoriaDao = new CategoriaProdutoDao();
                produto.setCategoria(categoriaDao.retornaCategoriaPorId(rs.getInt("idCategoriaProduto")));
            }
            return produto;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean modificaProduto(Produto produto) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(update);
            pstm.setInt(1, produto.getCategoria().getIdCategoria());
            pstm.setString(2, produto.getNome());
            pstm.setString(3, produto.getDescricao());
            pstm.setFloat(4, produto.getPeso());
            pstm.setFloat(5, produto.getPreco());
            pstm.setInt(6, produto.getQtdReclamacoes());
            pstm.setInt(7, produto.getIdProduto());
            
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public boolean removeProduto(Produto produto) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        // Pegar Atendimentos e ver se algum ta com Siuacao pendente
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setLong(1, produto.getIdProduto());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
