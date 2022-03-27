/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author leonardozanotti
 */
public class ConnectionFactory implements AutoCloseable {
    private static String DRIVER, URL, DATABASE, USER, PASSWORD;
    private Connection con = null;
    
    public Connection getConnection() throws DAOException, FileNotFoundException, IOException {
        if (this.con == null) {
            try {
                Properties prop = new Properties();
                prop.load(getClass().getResourceAsStream("./database.properties"));
                ConnectionFactory.DRIVER = prop.getProperty("db.driver");
                ConnectionFactory.URL = prop.getProperty("db.url");
                ConnectionFactory.DATABASE = prop.getProperty("db.database");
                ConnectionFactory.USER = prop.getProperty("db.user");
                ConnectionFactory.PASSWORD = prop.getProperty("db.password");
                Class.forName(ConnectionFactory.DRIVER);
                this.con = DriverManager.getConnection(ConnectionFactory.URL + ConnectionFactory.DATABASE, ConnectionFactory.USER, ConnectionFactory.PASSWORD);
                System.out.println("Connection established!");
            }
            catch (ClassNotFoundException e) {
                throw new DAOException("Driver do banco não encontrado: " + ConnectionFactory.DRIVER, e);
            }
            catch (SQLException e) {
                throw new DAOException("Erro conectando ao banco de dados: " + ConnectionFactory.URL + "/" + ConnectionFactory.USER + "/" + ConnectionFactory.PASSWORD, e);
            }
        }
        return this.con;
    }
    
    @Override
    public void close() throws Exception {
        if (this.con != null) {
            try {
                this.con.close();
                this.con = null;
                System.out.println("Connection closed!");
            }
            catch (Exception e) {
                System.out.println("Erro fechando a conexão.");
                e.printStackTrace();
            }
        }
    }
}
