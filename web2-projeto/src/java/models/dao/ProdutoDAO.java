/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package models.dao;

import database.DAO;
import database.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Produto;
import models.Produto;

/**
 *
 * @author leonardozanotti
 */
public class ProdutoDAO implements DAO<Produto> {
private static final String QUERY_INSERIR = "INSERT INTO Produto (idCategoria, nome, descricao, peso) VALUES (?, ?, ?, ?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM Produto WHERE idProduto = (?)";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM Produto";
    private static final String QUERY_ALTERAR = "UPDATE Produto SET idCategoria = (?), nome = (?), descricao = (?), peso = (?) WHERE idProduto = (?)";
    private static final String QUERY_REMOVER = "DELETE FROM Produto WHERE idProduto = (?)";

    private Connection con = null;

    public ProdutoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar ProdutoDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Produto buscar(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ProdutoDAO.QUERY_BUSCAR)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    return new Produto(
                        rs.getInt("idProduto"),
                        rs.getFloat("peso"),
                        rs.getString("nome"),
                        rs.getInt("idCategoria"),
                        rs.getString("descricao")
                    );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando produto: " + ProdutoDAO.QUERY_BUSCAR, e);
        }
    }

    @Override
    public List<Produto> buscarTodos() throws DAOException {
        List<Produto> Produtos = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(ProdutoDAO.QUERY_BUSCAR_TODOS); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Produto product = new Produto(
                    rs.getInt("idProduto"),
                    rs.getFloat("peso"),
                    rs.getString("nome"),
                    rs.getInt("idCategoria"),
                    rs.getString("descricao")
                );
                Produtos.add(product);
            }
            return Produtos;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os produtos: " + ProdutoDAO.QUERY_BUSCAR_TODOS, e);
        }
    }

    @Override
    public void inserir(Produto p) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ProdutoDAO.QUERY_INSERIR)) {
            st.setInt(1, p.getIdCategoria());
            st.setString(2, p.getNome());
            st.setString(3, p.getDescricao());
            st.setFloat(4, p.getPeso());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro inserindo produto: " + ProdutoDAO.QUERY_INSERIR + "/ " + p.toString(), e);
        }
    }

    @Override
    public void atualizar(Produto p) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ProdutoDAO.QUERY_ALTERAR)) {
            st.setInt(1, p.getIdCategoria());
            st.setString(2, p.getNome());
            st.setString(3, p.getDescricao());
            st.setFloat(4, p.getPeso());
            st.setInt(5, p.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro atualizando produto: " + ProdutoDAO.QUERY_ALTERAR + "/ " + p.toString(), e);
        }
    }

    @Override
    public void remover(Produto p) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(ProdutoDAO.QUERY_REMOVER)) {
            st.setInt(1, p.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo produto: " + ProdutoDAO.QUERY_REMOVER + "/ " + p.toString(), e);
        }
    }
}
