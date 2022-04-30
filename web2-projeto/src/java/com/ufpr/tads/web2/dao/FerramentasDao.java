/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class FerramentasDao {
    private ConnectionFactory connectionFactory;
    private final String confereEmail = 
            "select email from cliente where email = ?" +
            " union " +
            "select email from gerente where email = ?" +
            " union " +
            "select email from funcionario where email = ?";
    
    public FerramentasDao() {}
    
    public FerramentasDao(ConnectionFactory conFactory)
    {
        this.connectionFactory = conFactory;
    }
    
    public boolean confereEmail(String email) throws SQLException, ClassNotFoundException
    {
        Connection con = null;
        PreparedStatement pstm = null;
        String existe = null;
        
        try
        {
            con = ConnectionFactory.getConnection();
            pstm = con.prepareStatement(confereEmail);
            pstm.setString(1, email);
            pstm.setString(2, email);
            pstm.setString(3, email);
            ResultSet rs = pstm.executeQuery();
            
            while (rs.next())
            {
                existe = rs.getString("email");
            }
            
            if (existe != null)
                return true;
            else
                return false;        
        }
        finally
        {
            pstm.close();
            con.close();
        }
    }
}
