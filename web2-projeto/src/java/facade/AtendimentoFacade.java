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
        Atendimento Atendimento = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            Atendimento = dao.buscar(id);
        }
        return Atendimento;
    }
    
    public static List<Atendimento> buscarTodos() throws DAOException, SQLException, IOException {
        List<Atendimento> Atendimentos = null;
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            Atendimentos = dao.buscarTodos();
        }
        return Atendimentos;
    }
    
    public static void remover(Atendimento a) throws DAOException, SQLException, IOException {
        try (Connection con = new ConnectionFactory().getConnection()) {
            AtendimentoDAO dao = new AtendimentoDAO(con);
            dao.remover(a);
        }
    }
}
