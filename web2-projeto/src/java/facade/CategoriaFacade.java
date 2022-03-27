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
        Categoria Categoria = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            Categoria = dao.buscar(id);
        }
        return Categoria;
    }
    
    public static List<Categoria> buscarTodos() throws DAOException, SQLException, IOException {
        List<Categoria> Categorias = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            Categorias = dao.buscarTodos();
        }
        return Categorias;
    }
    
    public static void remover(Categoria c) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            CategoriaDAO dao = new CategoriaDAO(con);
            dao.remover(c);
        }
    }
}
