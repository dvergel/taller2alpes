/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Mueble;
import com.losalpes.servicios.IServicioCatalogo;
import com.losalpes.servicios.IServicioPago;
import com.losalpes.servicios.impl.ServicioCatalogoMock;
import com.losalpes.servicios.impl.ServicioPagoMock;
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
     * Servicio de pago de facturas
     */
    private IServicioPago servicioPago;
    
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
        servicioPago = new ServicioPagoMock();
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
    
    /**
     * Recalcula los valores de la compra a medida que se modifica la selección
     * de muebles
     */
    public void recalcularValores(){
        subtotal = BigDecimal.ZERO;
        for (Mueble mueble: mueblesSeleccionados) {
            subtotal = subtotal.add(mueble.getPrecio());
        }
        impuestos = subtotal.multiply(new BigDecimal("0.16"), MathContext.UNLIMITED);
    }
    
    /**
     * Elimina todos los elementos seleccionados
     */
    public void resetSelection(){
        mueblesSeleccionados = null;
        subtotal = BigDecimal.ZERO;
        impuestos = BigDecimal.ZERO;
    }
    
    /**
     * Redirige al cliente a la página de pago
     * @return 
     */
    public String irAPagar(){
        if (mueblesSeleccionados != null && mueblesSeleccionados.size()>0) {
            return "checkout";
        }
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Seleccione muebles "));
        return "";
    }
    
    
    
   
    
}
