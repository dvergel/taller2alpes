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
     * Número de identificación del cliente
     */
    private String idCliente;
    
    /**
     * Nombre tarjetahabiente
     */
    private String nombreTarjetaHabiente;
    
    /**
     * Número de la tarjeta
     */
    private String numeroTarjeta;
    
    /**
     * Fecha vencimiento tarjeta
     */
    private String fechaVencimientoTarjeta;
    
    /**
     * Código de seguridad de la tarjeta
     */
    private String codSeguridadTarjeta;

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

    /**
     * Retorna el número de identificación del tarjetahabiente
     * @return id tarjetahabiente
     */
    public String getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el número de identificación del tarjetahabiente.
     * @param idCliente id tarjetahabiente
     */
    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Retorna el nombre del tarjetahabiente
     * @return nombre tarjetahabiente
     */
    public String getNombreTarjetaHabiente() {
        return nombreTarjetaHabiente;
    }

    /**
     * Establece el nombre del tarjetahabiente
     * @param nombreTarjetaHabiente nombre
     */
    public void setNombreTarjetaHabiente(String nombreTarjetaHabiente) {
        this.nombreTarjetaHabiente = nombreTarjetaHabiente;
    }

    /**
     * Retorna el número de la tarjeta
     * @return numero de tarjeta
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece el numero de la tarjeta
     * @param numeroTarjeta numero de tarjeta
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Retorna el mes y año de vencimiento de la tarjeta
     * @return fecha vencimiento tarjeta
     */
    public String getFechaVencimientoTarjeta() {
        return fechaVencimientoTarjeta;
    }

    /**
     * Establece la fecha de vencimiento de la tarjeta
     * @param fechaVencimientoTarjeta fecha vencimiento
     */
    public void setFechaVencimientoTarjeta(String fechaVencimientoTarjeta) {
        this.fechaVencimientoTarjeta = fechaVencimientoTarjeta;
    }

    /**
     * Retorna el código de seguridad de la tarjeta
     * @return código de tarjeta
     */
    public String getCodSeguridadTarjeta() {
        return codSeguridadTarjeta;
    }

    /**
     * Establece el código de seguridad de la tarjeta
     * @param codSeguridadTarjeta codigo seguridad
     */
    public void setCodSeguridadTarjeta(String codSeguridadTarjeta) {
        this.codSeguridadTarjeta = codSeguridadTarjeta;
    }
    
    
    
}
