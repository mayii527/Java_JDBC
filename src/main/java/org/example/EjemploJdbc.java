package org.example;

import org.example.Repositorio.ProductoRepositorioImpl;
import org.example.Repositorio.Repositorio;
import org.example.modelo.Producto;
import org.example.util.ConexionBaseDatos;

import java.sql.*;

public class EjemploJdbc {
    public static void main(String[] args) {
        try (/*Autoclose*/Connection conn = ConexionBaseDatos.getInstance()) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            repositorio.listar().forEach(System.out::println);
            System.out.println(repositorio.porId(3L));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
