/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Factura;
import com.losalpes.servicios.IServicioFactura;
import com.losalpes.servicios.impl.ServicioFacturaMock;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 * Managed bean para el reporte
 * @author Zamir
 */
@ManagedBean
@RequestScoped
public class FacturaBean {

    /**
     * Servicio de negocio de facturas
     */
    private IServicioFactura servicioFactura;
    
    /**
     * Facturas a mostar en la vista
     */
    private List<Factura> facturas;
    
    /**
     * Fecha de inicio de búsqueda (Filtro)
     */
    private Date inicio;
    
    /**
     * Fecha final de búsqueda (filtro)
     */
    private Date fin;
    
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        servicioFactura = ServicioFacturaMock.getInstance();
    }

    /**
     * Retorna la fecha inicial para la búsqueda
     * @return fecha inicio búsqueda
     */
    public Date getInicio() {
        return inicio;
    }

    /**
     * Establece la fecha inicial para la búsqueda
     * @param inicio inicio búsqueda
     */
    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    /**
     * Retorna la fecha final para la búsqueda
     * @return fecha fin búsqueda
     */
    public Date getFin() {
        return fin;
    }

    /**
     * Establece la fecha final para la búsqueda
     * @param fin fecha fin busqueda.
     */
    public void setFin(Date fin) {
        this.fin = fin;
    }    
    
    /**
     * Retorna la lista de facturas cargadas con o sin filtro
     * @return Lista de facturas deseadas
     */
    public List<Factura> getFacturas(){
        if (facturas == null || facturas.size() == 0) {
            facturas = servicioFactura.obtenerFacturas(inicio, fin);
        }
        return facturas;
    }
    
    /**
     * Método para realizar el filtro de facturas
     */
    public void filtar(){
        facturas = servicioFactura.obtenerFacturas(inicio, fin);
    }
    
}
