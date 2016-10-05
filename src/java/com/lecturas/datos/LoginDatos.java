/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.datos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lecturas.utilerias.UConexion;
import com.lecturas.modelos.Logear;
import com.lecturas.modelos.Usuario;


/**
 *
 * @author MBrandle
 */
public class LoginDatos {
    public static Logear autenticar (int usuario, String password){
        Logear logActual;
        try{
            Connection conexion=UConexion.getConnection();
            PreparedStatement stmtLogin=conexion.prepareStatement("select nomb_ac from "
                    +  " acceso where clav_ac=? and pass_ac=?");
            stmtLogin.setInt(1, usuario);
            stmtLogin.setString(2, password);
            ResultSet rsLogin=stmtLogin.executeQuery();
            if(rsLogin.next()){
                Usuario usuActual=new Usuario(usuario, password, rsLogin.getString("nomb_ac"));
                logActual=new Logear(usuActual, 0, "Ok");
            }else{
                logActual=new Logear(null, 1, "Usuario No Valido");
            }
            rsLogin.close();
            stmtLogin.close();
            conexion.close();
        }catch(Exception ex){
            logActual=new Logear(null, 2,ex.getMessage());
        }
        return logActual;
    }
}
