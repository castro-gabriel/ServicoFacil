package servicofacil.gabriel.servicofacil.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {

    private static String USER = "gabrielcastro";
    private static String PASS = "screamo1997";
    private static String URL = "jdbc:mysql://localhost:3306/servicofacil";

    public static Connection getConnection() throws SQLException {

        try{
            Class.forName("com.mysql.jdbc.Driver");
        }catch(ClassNotFoundException e){
            e.printStackTrace();
        }

        return DriverManager.getConnection(URL, USER, PASS);
    }

}
