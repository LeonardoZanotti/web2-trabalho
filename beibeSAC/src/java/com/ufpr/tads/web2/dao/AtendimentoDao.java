/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Atendimento;
import com.ufpr.tads.web2.beans.Cliente;
import com.ufpr.tads.web2.beans.Funcionario;
import com.ufpr.tads.web2.beans.Situacao;
import com.ufpr.tads.web2.beans.TipoAtendimento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;


public class AtendimentoDao {
    private ConnectionFactory connectionFactory;
    private final String select = "SELECT idAtendimento,idCliente,idFuncionario,idProduto,idTipoAtendimento,idSituacao,dataHoraInicio,dataHoraFim,reclamacao,solucao FROM Atendimento;";
    private final String selectById = "SELECT idAtendimento,idCliente,idFuncionario,idProduto,idTipoAtendimento,idSituacao,dataHoraInicio,dataHoraFim,reclamacao,solucao FROM Atendimento WHERE idAtendimento=?;";
    private final String selectByCliente = "SELECT idAtendimento,idCliente,idFuncionario,idProduto,idTipoAtendimento,idSituacao,dataHoraInicio,dataHoraFim,reclamacao,solucao FROM Atendimento WHERE idCliente=?;";
    private final String selectByFuncionario = "SELECT idAtendimento,idCliente,idFuncionario,idProduto,idTipoAtendimento,idSituacao,dataHoraInicio,dataHoraFim,reclamacao,solucao FROM Atendimento WHERE idFuncionario=?;";
    private final String selectByTipo = "SELECT idAtendimento, idCliente, idFuncionario, idProduto, idTipoAtendimento, idSituacao, dataHoraInicio, dataHoraFim, reclamacao, solucao FROM Atendimento WHERE idTipoAtendimento=?;";
    private final String selectBySituacao = "SELECT idAtendimento,idCliente,idFuncionario,idProduto,idTipoAtendimento,idSituacao,dataHoraInicio,dataHoraFim,reclamacao,solucao FROM Atendimento WHERE idSituacao=?;";
    private final String insert = "INSERT INTO Atendimento (idCliente,idProduto,idTipoAtendimento,idSituacao,dataHoraInicio,reclamacao) VALUES (?,?,?,?,?,?);";
    private final String update = "UPDATE Atendimento SET idCliente=?,idFuncionario=?,idProduto=?,idTipoAtendimento=?,idSituacao=?,dataHoraInicio=?,dataHoraFim=?,reclamacao=?,solucao=? WHERE idAtendimento=?;";
    private final String delete = "DELETE FROM Atendimento WHERE idAtendimento=?;";
    
    public AtendimentoDao() {}
    
    public AtendimentoDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public ArrayList<Atendimento> retornaTodosAtendimentos() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Atendimento> atendimentos = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
                atendimento.setDataHoraInicio(timestampToCalendar(rs.getTimestamp("dataHoraInicio")));
                atendimento.setDataHoraFim(timestampToCalendar(rs.getTimestamp("dataHoraFim")));
                atendimento.setReclamacao(rs.getString("reclamacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                
                ClienteDao clienteDao = new ClienteDao();
                atendimento.setCliente(clienteDao.retornaClientePorId(rs.getInt("idCliente")));
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                atendimento.setFuncionario(funcionarioDao.retornaFuncionarioPorId(rs.getInt("idFuncionario")));
                ProdutoDao produtoDao = new ProdutoDao();
                atendimento.setProduto(produtoDao.retornaProdutoPorId(rs.getInt("idProduto")));
                TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
                atendimento.setTipoAtendimento(tipoAtendimentoDao.retornaTipoAtendimentoPorId(rs.getInt("idTipoAtendimento")));
                SituacaoDao situacaoDao = new SituacaoDao();
                atendimento.setSituacao(situacaoDao.retornaSituacaoPorId(rs.getInt("idSituacao")));
                
                atendimentos.add(atendimento);
            }
            return atendimentos;
        } finally {
            pstm.close();
            con.close();
        }  
    }
    
    public ArrayList<Atendimento> retornaAtendimentosPorCliente(Cliente cliente) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Atendimento> atendimentos = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectByCliente);
            pstm.setInt(1, cliente.getIdCliente());
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
                atendimento.setDataHoraInicio(timestampToCalendar(rs.getTimestamp("dataHoraInicio")));
                atendimento.setDataHoraFim(timestampToCalendar(rs.getTimestamp("dataHoraFim")));
                atendimento.setReclamacao(rs.getString("reclamacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setCliente(cliente);
                
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                atendimento.setFuncionario(funcionarioDao.retornaFuncionarioPorId(rs.getInt("idFuncionario")));
                ProdutoDao produtoDao = new ProdutoDao();
                atendimento.setProduto(produtoDao.retornaProdutoPorId(rs.getInt("idProduto")));
                TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
                atendimento.setTipoAtendimento(tipoAtendimentoDao.retornaTipoAtendimentoPorId(rs.getInt("idTipoAtendimento")));
                SituacaoDao situacaoDao = new SituacaoDao();
                atendimento.setSituacao(situacaoDao.retornaSituacaoPorId(rs.getInt("idSituacao")));
                
                atendimentos.add(atendimento);
            }
            return atendimentos;
        } finally {
            pstm.close();
            con.close();
        }  
    }
    
    public ArrayList<Atendimento> retornaAtendimentosPorFuncionario(Funcionario funcionario) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Atendimento> atendimentos = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectByFuncionario);
            pstm.setInt(1, funcionario.getIdFuncionario());
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
                atendimento.setDataHoraInicio(timestampToCalendar(rs.getTimestamp("dataHoraInicio")));
                atendimento.setDataHoraFim(timestampToCalendar(rs.getTimestamp("dataHoraFim")));
                atendimento.setReclamacao(rs.getString("reclamacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setFuncionario(funcionario);
                
                ClienteDao clienteDao = new ClienteDao();
                atendimento.setCliente(clienteDao.retornaClientePorId(rs.getInt("idCliente")));
                ProdutoDao produtoDao = new ProdutoDao();
                atendimento.setProduto(produtoDao.retornaProdutoPorId(rs.getInt("idProduto")));
                TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
                atendimento.setTipoAtendimento(tipoAtendimentoDao.retornaTipoAtendimentoPorId(rs.getInt("idTipoAtendimento")));
                SituacaoDao situacaoDao = new SituacaoDao();
                atendimento.setSituacao(situacaoDao.retornaSituacaoPorId(rs.getInt("idSituacao")));
                
                atendimentos.add(atendimento);
            }
            return atendimentos;
        } finally {
            pstm.close();
            con.close();
        }  
    }
    public ArrayList<Atendimento> retornaAtendimentosPorTipo(TipoAtendimento tipo) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        
        ArrayList<Atendimento> atendimentos = new ArrayList<>();
        try
        {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectByTipo);
            pstm.setInt(1, tipo.getIdTipo());
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
                atendimento.setDataHoraInicio(timestampToCalendar(rs.getTimestamp("dataHoraInicio")));
                atendimento.setDataHoraFim(timestampToCalendar(rs.getTimestamp("dataHoraFim")));
                atendimento.setReclamacao(rs.getString("reclamacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                SituacaoDao situacaoDao = new SituacaoDao();
                atendimento.setSituacao(situacaoDao.retornaSituacaoPorId(rs.getInt("idSituacao")));
                
                ClienteDao clienteDao = new ClienteDao();
                atendimento.setCliente(clienteDao.retornaClientePorId(rs.getInt("idCliente")));
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                atendimento.setFuncionario(funcionarioDao.retornaFuncionarioPorId(rs.getInt("idFuncionario")));
                ProdutoDao produtoDao = new ProdutoDao();
                atendimento.setProduto(produtoDao.retornaProdutoPorId(rs.getInt("idProduto")));
                atendimento.setTipoAtendimento(tipo);
                
                atendimentos.add(atendimento);
            }
            return atendimentos;            
        }
        finally
        {
            pstm.close();
            con.close();
        }
    }
    public ArrayList<Atendimento> retornaAtendimentosPorSituacao(Situacao situacao) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Atendimento> atendimentos = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectBySituacao);
            pstm.setInt(1, situacao.getIdSituacao());
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Atendimento atendimento = new Atendimento();
                atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
                atendimento.setDataHoraInicio(timestampToCalendar(rs.getTimestamp("dataHoraInicio")));
                atendimento.setDataHoraFim(timestampToCalendar(rs.getTimestamp("dataHoraFim")));
                atendimento.setReclamacao(rs.getString("reclamacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                atendimento.setSituacao(situacao);
                
                ClienteDao clienteDao = new ClienteDao();
                atendimento.setCliente(clienteDao.retornaClientePorId(rs.getInt("idCliente")));
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                atendimento.setFuncionario(funcionarioDao.retornaFuncionarioPorId(rs.getInt("idFuncionario")));
                ProdutoDao produtoDao = new ProdutoDao();
                atendimento.setProduto(produtoDao.retornaProdutoPorId(rs.getInt("idProduto")));
                TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
                atendimento.setTipoAtendimento(tipoAtendimentoDao.retornaTipoAtendimentoPorId(rs.getInt("idTipoAtendimento")));
                
                atendimentos.add(atendimento);
            }
            return atendimentos;
        } finally {
            pstm.close();
            con.close();
        } 
    }
    
    public Atendimento adicionaAtendimento(Atendimento atendimento) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            pstm.setInt(1, atendimento.getCliente().getIdCliente());
            pstm.setInt(2, atendimento.getProduto().getIdProduto());
            pstm.setInt(3, atendimento.getTipoAtendimento().getIdTipo());
            pstm.setInt(4, 1); // Situação Aberta
            pstm.setTimestamp(5, new Timestamp(atendimento.getDataHoraInicio().getTimeInMillis()));
            pstm.setString(6, atendimento.getReclamacao());
            pstm.executeUpdate();
            ResultSet rsKey = pstm.getGeneratedKeys();
            
            Long insertKey = null;
            if (rsKey.next())
            {
                insertKey = rsKey.getLong(1);
                int id = insertKey.intValue();
                atendimento.setIdAtendimento(id);
            }
            return atendimento;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Atendimento retornaAtendimentoPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        Atendimento atendimento = new Atendimento();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                atendimento.setIdAtendimento(rs.getInt("idAtendimento"));
                atendimento.setDataHoraInicio(timestampToCalendar(rs.getTimestamp("dataHoraInicio")));
                atendimento.setDataHoraFim(timestampToCalendar(rs.getTimestamp("dataHoraFim")));
                atendimento.setReclamacao(rs.getString("reclamacao"));
                atendimento.setSolucao(rs.getString("solucao"));
                
                ClienteDao clienteDao = new ClienteDao();
                atendimento.setCliente(clienteDao.retornaClientePorId(rs.getInt("idCliente")));
                FuncionarioDao funcionarioDao = new FuncionarioDao();
                atendimento.setFuncionario(funcionarioDao.retornaFuncionarioPorId(rs.getInt("idFuncionario")));
                ProdutoDao produtoDao = new ProdutoDao();
                atendimento.setProduto(produtoDao.retornaProdutoPorId(rs.getInt("idProduto")));
                TipoAtendimentoDao tipoAtendimentoDao = new TipoAtendimentoDao();
                atendimento.setTipoAtendimento(tipoAtendimentoDao.retornaTipoAtendimentoPorId(rs.getInt("idTipoAtendimento")));
                SituacaoDao situacaoDao = new SituacaoDao();
                atendimento.setSituacao(situacaoDao.retornaSituacaoPorId(rs.getInt("idSituacao")));
            }
            return atendimento;
        } finally {
            pstm.close();
            con.close();
        }  
    }
    
    public boolean modificaAtendimento(Atendimento atendimento) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(update);
            pstm.setInt(1, atendimento.getCliente().getIdCliente());
            pstm.setInt(2, atendimento.getFuncionario().getIdFuncionario());
            pstm.setInt(3, atendimento.getProduto().getIdProduto());
            pstm.setInt(4, atendimento.getTipoAtendimento().getIdTipo());
            pstm.setInt(5, 2); // Situacao Fechada
            pstm.setTimestamp(6, new Timestamp(atendimento.getDataHoraInicio().getTimeInMillis()));
            pstm.setTimestamp(7, new Timestamp(atendimento.getDataHoraFim().getTimeInMillis()));
            pstm.setString(8, atendimento.getReclamacao());
            pstm.setString(9, atendimento.getSolucao());
            pstm.setInt(10, atendimento.getIdAtendimento());
            pstm.executeUpdate();
            
            return true;
        } finally {
            pstm.close();
            con.close();
        }  
    }
    
    public boolean removeAtendimento(Atendimento atendimento) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(delete);
            pstm.setLong(1, atendimento.getIdAtendimento());
            int i = pstm.executeUpdate();
            return i > 0;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    private static Calendar timestampToCalendar(final Timestamp timestamp) {
        if (timestamp == null)
            return null;
        final Calendar cal = Calendar.getInstance();
        cal.setTime(timestamp);
        return cal;
    }
}
