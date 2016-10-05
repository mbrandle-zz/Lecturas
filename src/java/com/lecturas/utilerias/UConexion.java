/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.utilerias;

import java.sql.Connection;
import javax.naming.InitialContext;
import javax.sql.DataSource;

/**
 *
 * @author MBrandle
 */
public class UConexion {

    private static Connection con = null;

    public static Connection getConnection() {
        InitialContext ctx;
        DataSource ds;

        try {
            ctx = new InitialContext();
            //ds = (DataSource) ctx.lookup("java:comp/env/jdbc/MySQLDataSource");
            ds = (DataSource) ctx.lookup("jdbc/MySQLDataSource");
            con=ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        /*try {
         if (con != null && !con.isClosed()) {
         return con;
         }
         System.out.println("Cargando driver...");

         try {
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Driver Cargado!");
         } catch (ClassNotFoundException e) {
         throw new IllegalStateException("Driver No Encontrado!", e);
         }

         String url = "jdbc:mysql://localhost:3306/comercial_madera";
         String username = "root";
         String password = "jcasadmin";
         System.out.println("Conectando A Base De Datos...");
         con = DriverManager.getConnection(url, username, password);
         System.out.println("Conectado a La Base de Datos!");
         return con;
         } catch (Exception e) {
         e.printStackTrace();
         throw new RuntimeException(e);
         }*/
        return con;
    }
}
