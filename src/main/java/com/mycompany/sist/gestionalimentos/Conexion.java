
package com.mycompany.sist.gestionalimentos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
 private String url;
    private String db;
    private String user;
    private String password;
    private String driver;
    private Connection connection;

    public Conexion() {
        this.url = "jdbc:mysql://localhost:3306/";
        this.db = "GestionAlimentos";
        this.user = "root"; //////cambiar usuario
        this.password = "Jose1234"; /////////cambiar password
        this.driver = "com.mysql.cj.jdbc.Driver";
    }

    public Connection conectar() {
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + db, user, password);
            return connection;
        } catch (ClassNotFoundException ex) {
            System.out.println("Error class: " + ex.toString());
        } catch (SQLException ex) {
            System.out.println("Error SQL: " + ex.toString());
        }
        return null;
    }

    public void desconectar() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Conexion finalizada");
            } catch (SQLException ex) {
                System.out.println("Error SQL: " + ex.toString());
            }
        }
    }   
}
