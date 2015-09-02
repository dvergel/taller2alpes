/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.bos;

/**
 * Clase para representar los datos que ingresan para realizar un pago
 * Los datos contenidos en esta clase no serán almacenados después del pago
 * @author Zamir
 */
public class DatosPago {
    
    /**
     * Factura a pagar
     */
    private Factura factura;

    /**
     * Retorna la factura a pagar
     * @return factura
     */
    public Factura getFactura() {
        return factura;
    }

    /**
     * Establece la factura a pagar
     * @param factura factura
     */
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    
    
    
}
