/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Situacao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class SituacaoDao {
    private ConnectionFactory connectionFactory;
    private final String select = "SELECT idSituacao, estado FROM Situacao;";
    private final String selectById = "SELECT idSituacao, estado FROM Situacao WHERE idSituacao = ?;";
    
    public SituacaoDao() {}
    
    public SituacaoDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public ArrayList<Situacao> retornaListaSituacoes() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Situacao> situacoes = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Situacao situacao = new Situacao();
                situacao.setIdSituacao(rs.getInt("idSituacao"));
                situacao.setEstado(rs.getString("estado"));
                situacoes.add(situacao);
            }
            return situacoes;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Situacao retornaSituacaoPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        Situacao situacao = new Situacao();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                situacao.setIdSituacao(rs.getInt("idSituacao"));
                situacao.setEstado(rs.getString("estado"));
            }
            return situacao;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
