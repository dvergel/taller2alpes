/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Factura;
import com.losalpes.servicios.IServicioFactura;
import com.losalpes.servicios.impl.ServicioFacturaMock;
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
     * Factura seleccionada
     */
    private Factura facturaSeleccionada;
    
    /**
     * Creates a new instance of FacturaBean
     */
    public FacturaBean() {
        servicioFactura = ServicioFacturaMock.getInstance();
    }

    public Factura getFacturaSeleccionada() {
        return facturaSeleccionada;
    }

    public void setFacturaSeleccionada(Factura facturaSeleccionada) {
        this.facturaSeleccionada = facturaSeleccionada;
    }
    
    
    
    public List<Factura> getFacturas(){
        return servicioFactura.obtenerFacturas();
    }
    
}
