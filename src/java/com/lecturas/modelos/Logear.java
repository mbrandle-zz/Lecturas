/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.modelos;

/**
 *
 * @author MBrandle
 */
public class Logear {
    private Usuario usuarioActual;
    private int idResp;
    private String respDesc;

    /**
     * @return the usuarioActual
     */
    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    /**
     * @param usuarioActual the usuarioActual to set
     */
    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }

    /**
     * @return the idResp
     */
    public int getIdResp() {
        return idResp;
    }

    /**
     * @param idResp the idResp to set
     */
    public void setIdResp(int idResp) {
        this.idResp = idResp;
    }

    /**
     * @return the respDesc
     */
    public String getRespDesc() {
        return respDesc;
    }

    /**
     * @param respDesc the respDesc to set
     */
    public void setRespDesc(String respDesc) {
        this.respDesc = respDesc;
    }
    
    public Logear(Usuario usuarioActual, int idResp, String respDesc){
        this.usuarioActual=usuarioActual;
        this.idResp=idResp;
        this.respDesc=respDesc;
    }
}
