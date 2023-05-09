package org.example;

import org.example.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        try (//Autoclose
             Connection conn = ConexionBaseDatos.getInstance();
             Statement stmt = conn.createStatement();
             ResultSet result = stmt.executeQuery("SELECT * FROM productos")) {

            while (result.next()) {
                System.out.print(result.getInt("id"));
                System.out.print(" | ");
                System.out.print(result.getString("nombre"));
                System.out.print(" | ");
                System.out.print(result.getInt("precio"));
                System.out.print(" | ");
                System.out.println(result.getDate("fecha_registro"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
