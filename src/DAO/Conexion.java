package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class Conexion {
    private static String driver= "com.mysql.jdbc.Driver";
    private static String database= "royalacademy";
    private static String hostname= "localhost";
    private static String port="3306";
    private static String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database + "?useSSL=false";//desactivamos el uso de SSL(Secure Sockets Layer) con "?useSSL=false
    private static String username= "root";
    private static String password = "";
    
    private Conexion() {}
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
