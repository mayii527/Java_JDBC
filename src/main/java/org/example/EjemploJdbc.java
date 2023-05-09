package org.example;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/jaca_curso?serverTimezone=GMT-5";
        String username = "root";
        String password = "sasa";

        try {
            Connection conn = DriverManager.getConnection(url,username,password);
            Statement stmt = conn.createStatement();
            ResultSet result = stmt.executeQuery("SELECT * FROM productos");
            while (result.next()){
                System.out.println(result.getString("nombre"));
            }
            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
