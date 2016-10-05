/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.modelos;

import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author MBrandle
 */
public class Periodo {
    private List<SelectItem> listPeriodos;
    private int idResp;
    private String desResp;
    
    
    public Periodo(List<SelectItem> listPeriodos, int idResp, String desResp){
        this.listPeriodos=listPeriodos;
        this.idResp=idResp;
        this.desResp=desResp;
    }

    /**
     * @return the listPeriodos
     */
    public List<SelectItem> getListPeriodos() {
        return listPeriodos;
    }

    /**
     * @param listPeriodos the listPeriodos to set
     */
    public void setListPeriodos(List<SelectItem> listPeriodos) {
        this.listPeriodos = listPeriodos;
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
     * @return the desResp
     */
    public String getDesResp() {
        return desResp;
    }

    /**
     * @param desResp the desResp to set
     */
    public void setDesResp(String desResp) {
        this.desResp = desResp;
    }
}
