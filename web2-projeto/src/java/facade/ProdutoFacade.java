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
import models.Produto;
import models.dao.ProdutoDAO;

/**
 *
 * @author leonardozanotti
 */
public class ProdutoFacade {
    public static void inserir(Produto p) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            dao.inserir(p);
        }
    }
    
    public static void alterar(Produto p) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            dao.atualizar(p);
        }
    }
    
    public static Produto buscar(int id) throws DAOException, SQLException, IOException {
        Produto produto = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            produto = dao.buscar(id);
        }
        return produto;
    }
    
    public static List<Produto> buscarTodos() throws DAOException, SQLException, IOException {
        List<Produto> produtos = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            produtos = dao.buscarTodos();
        }
        return produtos;
    }
    
    public static void remover(Produto p) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            ProdutoDAO dao = new ProdutoDAO(con);
            dao.remover(p);
        }
    }
}
