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
import models.Categoria;

/**
 *
 * @author leonardozanotti
 */
public class CategoriaDAO implements DAO<Categoria> {
    private static final String QUERY_INSERIR = "INSERT INTO CategoriaProduto (nome) VALUES (?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM CategoriaProduto WHERE idCategoria = (?)";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM CategoriaProduto";
    private static final String QUERY_ALTERAR = "UPDATE CategoriaProduto SET nome = (?) WHERE idCategoria = (?)";
    private static final String QUERY_REMOVER = "DELETE FROM CategoriaProduto WHERE idCategoria = (?)";

    private Connection con = null;

    public CategoriaDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar CategoriaDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Categoria buscar(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(CategoriaDAO.QUERY_BUSCAR)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    return new Categoria(
                            rs.getInt("idCategoria"),
                            rs.getString("nome")
                    );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando categoria: " + CategoriaDAO.QUERY_BUSCAR, e);
        }
    }

    @Override
    public List<Categoria> buscarTodos() throws DAOException {
        List<Categoria> Categorias = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(CategoriaDAO.QUERY_BUSCAR_TODOS); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Categoria category = new Categoria(
                    rs.getInt("idCategoria"),
                    rs.getString("nome")
                );
                Categorias.add(category);
            }
            return Categorias;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos as categorias: " + CategoriaDAO.QUERY_BUSCAR_TODOS, e);
        }
    }

    @Override
    public void inserir(Categoria c) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(CategoriaDAO.QUERY_INSERIR)) {
            st.setString(1, c.getNome());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro inserindo categoria: " + CategoriaDAO.QUERY_INSERIR + "/ " + c.toString(), e);
        }
    }

    @Override
    public void atualizar(Categoria c) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(CategoriaDAO.QUERY_ALTERAR)) {
            st.setString(1, c.getNome());
            st.setInt(2, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro atualizando categoria: " + CategoriaDAO.QUERY_ALTERAR + "/ " + c.toString(), e);
        }
    }

    @Override
    public void remover(Categoria c) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(CategoriaDAO.QUERY_REMOVER)) {
            st.setInt(1, c.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo categoria: " + CategoriaDAO.QUERY_REMOVER + "/ " + c.toString(), e);
        }
    }
    
}
