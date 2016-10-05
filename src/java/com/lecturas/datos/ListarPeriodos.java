/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.datos;

import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lecturas.utilerias.UConexion;
import com.lecturas.modelos.Periodo;

/**
 *
 * @author MBrandle
 */
public class ListarPeriodos {

    public static Periodo Listar() {
        Periodo periodoActual = null;
        try {
            List<SelectItem> listPeriodos = new ArrayList<SelectItem>();
            try (Connection conexion = UConexion.getConnection();
                    PreparedStatement stmtPeriodos = conexion.prepareStatement("select DISTINCT peri_le from lecturas where longitud_le<>0 and latitud_le<>0");
                    ResultSet rsPeriodos = stmtPeriodos.executeQuery()) {
                while (rsPeriodos.next()) {
                    String periodo = null;
                    periodo = rsPeriodos.getString("peri_le");
                    listPeriodos.add(new SelectItem(periodo));
                }
                rsPeriodos.close();
                stmtPeriodos.close();
                conexion.close();
                periodoActual= new Periodo(listPeriodos, 0, "Ok");
            }
        } catch (Exception ex) {
            periodoActual = new Periodo(null, -1, ex.getMessage());
        }
        return periodoActual;
    }
}
