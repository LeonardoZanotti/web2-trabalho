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
import models.Atendimento;

/**
 *
 * @author leonardozanotti
 */
public class AtendimentoDAO implements DAO<Atendimento> {
    private static final String QUERY_INSERIR = "INSERT INTO Atendimento (idProduto, idUsuario, dataHoraInicio, dataHoraFim, reclamacao, solucao, tipoAtendimento, situacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String QUERY_BUSCAR = "SELECT * FROM Atendimento WHERE idAtendimento = (?)";
    private static final String QUERY_BUSCAR_TODOS = "SELECT * FROM Atendimento ORDER BY dataHoraInicio ASC";
    private static final String QUERY_BUSCAR_ABERTOS = "SELECT * FROM Atendimento WHERE situacao = 'aberto' ORDER BY dataHoraInicio ASC";
    private static final String QUERY_BUSCAR_CLIENTE = "SELECT * FROM Atendimento WHERE idUsuario = (?) ORDER BY dataHoraInicio DESC";
    private static final String QUERY_ALTERAR = "UPDATE Atendimento SET idProduto = (?), idUsuario = (?), dataHoraInicio = (?), dataHoraFim = (?), reclamacao = (?), solucao = (?), tipoAtendimento = (?), situacao = (?) WHERE idAtendimento = (?)";
    private static final String QUERY_REMOVER = "DELETE FROM Atendimento WHERE idAtendimento = (?)";

    private Connection con = null;

    public AtendimentoDAO(Connection con) throws DAOException {
        if (con == null) {
            throw new DAOException("Conexão nula ao criar AtendimentoDAO.");
        }
        this.con = con;
    }
    
    @Override
    public Atendimento buscar(long id) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(AtendimentoDAO.QUERY_BUSCAR)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next())
                    return new Atendimento(
                        rs.getInt("idAtendimento"),
                        rs.getInt("idProduto"),
                        rs.getInt("idUsuario"),
                        rs.getDate("dataHoraInicio"),
                        rs.getDate("dataHoraFim"),
                        rs.getString("reclamacao"),
                        rs.getString("solucao"),
                        rs.getString("tipoAtendimento"),
                        rs.getString("situacao")
                    );
            }
            return null;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando atendimento: " + AtendimentoDAO.QUERY_BUSCAR, e);
        }
    }

    @Override
    public List<Atendimento> buscarTodos() throws DAOException {
        List<Atendimento> Atendimentos = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(AtendimentoDAO.QUERY_BUSCAR_TODOS); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Atendimento atendimento = new Atendimento(
                    rs.getInt("idAtendimento"),
                    rs.getInt("idProduto"),
                    rs.getInt("idUsuario"),
                    rs.getDate("dataHoraInicio"),
                    rs.getDate("dataHoraFim"),
                    rs.getString("reclamacao"),
                    rs.getString("solucao"),
                    rs.getString("tipoAtendimento"),
                    rs.getString("situacao")
                );
                Atendimentos.add(atendimento);
            }
            return Atendimentos;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os atendimentos: " + AtendimentoDAO.QUERY_BUSCAR_TODOS, e);
        }
    }
    
    public List<Atendimento> buscarAbertos() throws DAOException {
        List<Atendimento> Atendimentos = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(AtendimentoDAO.QUERY_BUSCAR_ABERTOS); ResultSet rs = st.executeQuery()) {
            while (rs.next()) {
                Atendimento atendimento = new Atendimento(
                    rs.getInt("idAtendimento"),
                    rs.getInt("idProduto"),
                    rs.getInt("idUsuario"),
                    rs.getDate("dataHoraInicio"),
                    rs.getDate("dataHoraFim"),
                    rs.getString("reclamacao"),
                    rs.getString("solucao"),
                    rs.getString("tipoAtendimento"),
                    rs.getString("situacao")
                );
                Atendimentos.add(atendimento);
            }
            return Atendimentos;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os atendimentos abertos: " + AtendimentoDAO.QUERY_BUSCAR_ABERTOS, e);
        }
    }
    
    public List<Atendimento> buscarPorCliente(long id) throws DAOException {
        List<Atendimento> Atendimentos = new ArrayList<>();
        try (PreparedStatement st = this.con.prepareStatement(AtendimentoDAO.QUERY_BUSCAR_CLIENTE)) {
            st.setLong(1, id);
            try (ResultSet rs = st.executeQuery()) {
                while (rs.next()) {
                    Atendimento atendimento = new Atendimento(
                        rs.getInt("idAtendimento"),
                        rs.getInt("idProduto"),
                        rs.getInt("idUsuario"),
                        rs.getDate("dataHoraInicio"),
                        rs.getDate("dataHoraFim"),
                        rs.getString("reclamacao"),
                        rs.getString("solucao"),
                        rs.getString("tipoAtendimento"),
                        rs.getString("situacao")
                    );
                    Atendimentos.add(atendimento);
                }
            }
            return Atendimentos;
        } catch (SQLException e) {
            throw new DAOException("Erro buscando todos os atendimentos do cliente: " + AtendimentoDAO.QUERY_BUSCAR_CLIENTE, e);
        }
    }
    
    @Override
    public void inserir(Atendimento a) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(AtendimentoDAO.QUERY_INSERIR)) {
            st.setInt(1, a.getIdProduto());
            st.setInt(2, a.getIdUsuario());
            st.setDate(3, (java.sql.Date) a.getDataInicio());
            st.setDate(4, (java.sql.Date) a.getDataFim());
            st.setString(5, a.getReclamacao());
            st.setString(6, a.getSolucao());
            st.setString(7, a.getTipoAtendimento());
            st.setString(8, a.getSituacao());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro inserindo atendimento: " + AtendimentoDAO.QUERY_INSERIR + "/ " + a.toString(), e);
        }
    }

    @Override
    public void atualizar(Atendimento a) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(AtendimentoDAO.QUERY_ALTERAR)) {
            st.setInt(1, a.getIdProduto());
            st.setInt(2, a.getIdUsuario());
            st.setDate(3, (java.sql.Date) a.getDataInicio());
            st.setDate(4, (java.sql.Date) a.getDataFim());
            st.setString(5, a.getReclamacao());
            st.setString(6, a.getSolucao());
            st.setString(7, a.getTipoAtendimento());
            st.setString(8, a.getSituacao());
            st.setInt(9, a.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro atualizando atendimento: " + AtendimentoDAO.QUERY_ALTERAR + "/ " + a.toString(), e);
        }
    }

    @Override
    public void remover(Atendimento a) throws DAOException {
        try (PreparedStatement st = con.prepareStatement(AtendimentoDAO.QUERY_REMOVER)) {
            st.setInt(1, a.getId());
            st.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Erro removendo atendimento: " + AtendimentoDAO.QUERY_REMOVER + "/ " + a.toString(), e);
        }
    }
}
