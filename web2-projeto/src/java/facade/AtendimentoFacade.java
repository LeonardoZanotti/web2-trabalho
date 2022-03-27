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
import models.Atendimento;
import models.dao.AtendimentoDAO;

/**
 *
 * @author leonardozanotti
 */
public class AtendimentoFacade {
    public static void inserir(Atendimento a) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            dao.inserir(a);
        }
    }
    
    public static void alterar(Atendimento a) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            dao.atualizar(a);
        }
    }
    
    public static Atendimento buscar(int id) throws DAOException, SQLException, IOException {
        Atendimento atendimento;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            atendimento = dao.buscar(id);
        }
        return atendimento;
    }
    
    public static List<Atendimento> buscarPorCliente(int id) throws DAOException, SQLException, IOException {
        List<Atendimento> atendimentos;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            atendimentos = dao.buscarPorCliente(id);
        }
        return atendimentos;
    }
    
    public static List<Atendimento> buscarTodos() throws DAOException, SQLException, IOException {
        List<Atendimento> atendimentos;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            atendimentos = dao.buscarTodos();
        }
        return atendimentos;
    }
    
    public static List<Atendimento> buscarAbertos() throws DAOException, SQLException, IOException {
        List<Atendimento> atendimentos;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            atendimentos = dao.buscarAbertos();
        }
        return atendimentos;
    }
    
    public static void remover(Atendimento a) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            dao.remover(a);
        }
    }
}
