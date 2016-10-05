/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lecturas.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.lecturas.datos.ListarPeriodos;
import com.lecturas.modelos.*;
import com.sun.corba.se.impl.naming.pcosnaming.NameService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.model.SelectItem;

/**
 *
 * @author MBrandle
 */
@ManagedBean
@SessionScoped
public class ListarPeriodoBean {
    private Periodo periodosActual;
    private List<SelectItem> lista;
    private String strPeriodo;
    
    
    private static final long serialVersionUID = 4256272866128337548L;

    /**
     * @return the periodosActual
     */
    public Periodo getPeriodosActual() {
        return periodosActual;
    }

    /**
     * @param periodosActual the periodosActual to set
     */
    public void setPeriodosActual(Periodo periodosActual) {
        this.periodosActual = periodosActual;
    }

    /**
     * @return the lista
     */
    public List<SelectItem> getLista() {
        return lista;
    }

    /**
     * @param lista the lista to set
     */
    public void setLista(List<SelectItem> lista) {
        this.lista = lista;
    }

    /**
     * @return the strPeriodo
     */
    public String getStrPeriodo() {
        return strPeriodo;
    }

    /**
     * @param strPeriodo the strPeriodo to set
     */
    public void setStrPeriodo(String strPeriodo) {
        this.strPeriodo = strPeriodo;
    }
    
    public List<SelectItem> getPeriodos(){
        ListarPeriodos lt=new ListarPeriodos();
        periodosActual=lt.Listar();
        lista=periodosActual.getListPeriodos();
        return lista;
    }
}
