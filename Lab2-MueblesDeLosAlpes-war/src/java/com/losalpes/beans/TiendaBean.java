/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.impl.ServicioCatalogoMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 * Managed bean para el manejo de la tienda Web
 * @author Zamir
 */
@ManagedBean
@SessionScoped
public class TiendaBean {
    
     /**
     * Relación con la interfaz que provee los servicios necesarios del catálogo.
     */
    private IServicioCatalogo catalogo;
    
    /**
     * Muebles seleccionados por el usuario
     */
    private List<Mueble> mueblesSeleccionados;

    /**
     * Creates a new instance of TiendaBean
     */
    public TiendaBean() {
        catalogo = new ServicioCatalogoMock();
    }

    public List<Mueble> getMueblesSeleccionados() {
        return mueblesSeleccionados;
    }

    public void setMueblesSeleccionados(List<Mueble> mueblesSeleccionados) {
        this.mueblesSeleccionados = mueblesSeleccionados;
    }
    
    /**
     * Devuelve una lista con todos los muebles del sistema
     * @return muebles Muebles del sistema
     */
    public List<Mueble> getMuebles(){
        return catalogo.darMuebles();
    }
    
}
