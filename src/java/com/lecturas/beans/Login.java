/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.beans;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import com.lecturas.datos.LoginDatos;
import com.lecturas.modelos.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.ExternalContext;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

    private static final long serialVersionUID = 1094801825228386363L;
    private Logear logActual;
    private int usuario;
    private String password;
    

    /**
     * @return the logActual
     */
    public Logear getLogActual() {
        return logActual;
    }

    /**
     * @param logActual the logActual to set
     */
    public void setLogActual(Logear logActual) {
        this.logActual = logActual;
    }

    //validate login
    public void validateUsernamePassword() {
        logActual = LoginDatos.autenticar(usuario, password);
        if (logActual.getIdResp() == 0) {
            HttpSession session = SessionBean.getSession();
            session.setAttribute("username", logActual.getUsuarioActual().getNombre());
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO,"Bienvenido:"+logActual.getUsuarioActual().getNombre(),"Bienvenido:"+logActual.getUsuarioActual().getNombre()));
            ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ec.redirect("admin.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            FacesContext.getCurrentInstance().addMessage(
                    null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR,"Error: "+ logActual.getRespDesc(),"Error: "+ logActual.getRespDesc()));
        }
    }

    //logout event, invalidate session
    public void logout() {
        HttpSession session = SessionBean.getSession();
        session.invalidate();
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
            try {
                ec.redirect("index.xhtml");
            } catch (IOException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    
    public String getNombreActual(){
        return logActual.getUsuarioActual().getNombre();
    }

    /**
     * @return the usuario
     */
    public int getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(int usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
}
