/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package facade;

import database.ConnectionFactory;
import database.DAOException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import models.Categoria;
import models.dao.CategoriaDAO;

/**
 *
 * @author leonardozanotti
 */
public class CategoriaFacade {
    public static void inserir(Categoria c) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            dao.inserir(c);
        }
    }
    
    public static void alterar(Categoria c) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            dao.atualizar(c);
        }
    }
    
    public static Categoria buscar(int id) throws DAOException, SQLException, IOException {
        Categoria categoria;
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            categoria = dao.buscar(id);
        }
        return categoria;
    }
    
    public static List<Categoria> buscarTodos() throws DAOException, SQLException, IOException {
        List<Categoria> categorias;
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            categorias = dao.buscarTodos();
        }
        return categorias;
    }
    
    public static void remover(Categoria c) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            dao.remover(c);
        }
    }
}
