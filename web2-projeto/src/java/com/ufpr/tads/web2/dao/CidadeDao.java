/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Cidade;
import com.ufpr.tads.web2.beans.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CidadeDao {
    private ConnectionFactory connectionFactory;
    private final String select = "SELECT idCidade, nome, idEstado FROM Cidade;";
    private final String selectById = "SELECT idCidade, idEstado, nome FROM Cidade WHERE idCidade = ?;";
    private final String selectByEstado = "SELECT idCidade, idEstado, nome FROM Cidade WHERE idEstado = ?;";
    
    public CidadeDao() {}
    
    public CidadeDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public ArrayList<Cidade> retornaListaCidades() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Cidade> cidades = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nome"));
                
                EstadoDao estadoDao = new EstadoDao();
                cidade.setEstado(estadoDao.retornaEstadoPorId(rs.getInt("idEstado")));
                cidades.add(cidade);
            }
            return cidades;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public ArrayList<Cidade> retornaListaCidadesPorEstado(Estado estado) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Cidade> cidades = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectByEstado);
            pstm.setInt(1, estado.getId());
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nome"));
                cidade.setEstado(estado);
                cidades.add(cidade);
            }
            return cidades;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Cidade retornaCidadePorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        Cidade cidade = new Cidade();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                cidade.setId(rs.getInt("idCidade"));
                cidade.setNome(rs.getString("nome"));
                
                EstadoDao estadoDao = new EstadoDao();
                cidade.setEstado(estadoDao.retornaEstadoPorId(rs.getInt("idEstado")));
            }
            return cidade;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
