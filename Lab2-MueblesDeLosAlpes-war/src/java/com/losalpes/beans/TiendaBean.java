/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.impl.ServicioCatalogoMock;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

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
     * Subtotal de los muebles seleccionados para comprar
     */
    private BigDecimal subtotal;
    
    /**
     * Impuestos generados por la compra
     */
    private BigDecimal impuestos;

    /**
     * Creates a new instance of TiendaBean
     */
    public TiendaBean() {
        subtotal = BigDecimal.ZERO;
        impuestos = BigDecimal.ZERO;
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

    /**
     * Retorna el subtotal de la compra a realizar
     * @return Subtotal de la compra
     */
    public BigDecimal getSubtotal() {
        return subtotal;
    }

    /**
     * Retorna el valor de los impuestos de la compra
     * @return Valor de los impuestos
     */
    public BigDecimal getImpuestos() {
        return impuestos;
    }
    
    /**
     * Retorna el valor total de la compra incluyendo impuestos
     * @return Gran total de la compra
     */
    public BigDecimal getTotal(){
        return subtotal.add(impuestos);
    }
    
    public void recalcularValores(){
        subtotal = BigDecimal.ZERO;
        for (Mueble mueble: mueblesSeleccionados) {
            subtotal = subtotal.add(mueble.getPrecio());
        }
        impuestos.multiply(new BigDecimal("0.16"), MathContext.UNLIMITED);
    }
    
    public void resetSelection(){
        mueblesSeleccionados = null;
        subtotal = BigDecimal.ZERO;
        impuestos = BigDecimal.ZERO;
    }
    
    public String irAPagar(){
        if (mueblesSeleccionados != null && mueblesSeleccionados.size()>0) {
            return "checkout";
        }
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Your message: ") );
        context.addMessage(null, new FacesMessage("Second Message", "Additional Message Detail"));
        return "";
    }
    
}
