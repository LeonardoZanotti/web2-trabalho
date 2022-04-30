/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import com.ufpr.tads.web2.beans.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EstadoDao {
    private ConnectionFactory connectionFactory;
    private final String select = "SELECT idEstado, nome, sigla FROM Estado;";
    private final String selectById = "SELECT idEstado, nome, sigla FROM Estado WHERE idEstado = ?;";
    
    public EstadoDao() {}
    
    public EstadoDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public ArrayList<Estado> retornaListaEstados() throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        ArrayList<Estado> estados = new ArrayList<>();
         try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(select);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                estados.add(estado);
            }
            return estados;
        } finally {
            pstm.close();
            con.close();
        }
    }
    
    public Estado retornaEstadoPorId(int id) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;

        Estado estado = new Estado();
        try {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(selectById);
            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next()) {
                estado.setId(rs.getInt("idEstado"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
            }
            return estado;
        } finally {
            pstm.close();
            con.close();
        }
    }
}
