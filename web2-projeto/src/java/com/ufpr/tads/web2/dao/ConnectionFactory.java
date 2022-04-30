/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ufpr.tads.web2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionFactory {

    public static Connection getConnection(){
        Connection con = null;
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/TrabalhoFinalSAC","postgres","root");
            System.out.println("Conexao realizada com sucesso");
            return con;
        } catch (SQLException e){
            System.out.println("Erro - Conexao"+e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("Erro - Driver"+e.getMessage());
        } return con;
    }
}
