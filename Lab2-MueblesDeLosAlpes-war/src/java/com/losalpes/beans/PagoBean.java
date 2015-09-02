/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.DatosPago;
import com.losalpes.bos.Factura;
import com.losalpes.bos.Mueble;
import com.losalpes.bos.TipoTarjeta;
import com.losalpes.servicios.IServicioPago;
import com.losalpes.servicios.impl.ServicioPagoMock;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;


/**
 *
 * @author Zamir
 */
@ManagedBean
public class PagoBean {
    
    @ManagedProperty(value = "#{tiendaBean}")
    private TiendaBean tiendaBean;
    
    private IServicioPago servicioPago = new ServicioPagoMock();
    
    /**
     * Número de identificación del cliente
     */
    private String idCliente;
    
    /**
     * Nombre tarjetahabiente
     */
    private String nombreTarjetaHabiente;
    
    /**
     * Marca de la tarjeta
     */
    private String tipoTarjeta;
    
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

    public void setTiendaBean(TiendaBean tiendaBean) {
        this.tiendaBean = tiendaBean;
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
     * Retorna la marca de la tarjeta elegida
     * @return marca tarjeta
     */
    public String getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * Establece la marca de la tarjeta
     * @param tipoTarjeta Marca tarjeta
     */
    public void setTipoTarjeta(String tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
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

    /**
     * Creates a new instance of PagoBean
     */
    public PagoBean() {
    }
    
    /**
     * Método que se llama al realizar un pago
     * @return 
     */
    public String realizarPago(){
        DatosPago datosPago = new DatosPago();
        Factura factura = new Factura();
        TipoTarjeta tTarjeta = TipoTarjeta.valueOf(tipoTarjeta);
        
        
        System.out.println("Realizando pago valor: " + tiendaBean.getTotal()
            + "pagando con " + tTarjeta);
        
        factura.setFecha(new Date());
        factura.setItemsComprados(tiendaBean.getMueblesSeleccionados());
        factura.setValorCompra(tiendaBean.getSubtotal());
        factura.setValorImpuestos(tiendaBean.getImpuestos());
        factura.setValorTotal(tiendaBean.getTotal());
        factura.setIdCliente(new BigDecimal(idCliente));
        factura.setNombreCliente(nombreTarjetaHabiente);
        factura.setTipoTarjeta(tTarjeta);
        
        datosPago.setFactura(factura);
        int aprobacion = servicioPago.realizarPago(datosPago);
        if (aprobacion <= 0) {
            //No se aprobó la transacción
            //Mostar mensaje de error en el pago
            return "error";
        }
        return "success";
        
    }
    
    public List<String[]> getListaTiposTarjeta(){
        List<String[]> tiposTarjeta = new ArrayList<>();
        
        for (TipoTarjeta tt: TipoTarjeta.values()) {
            String[] dato = new String[2];
            dato[0] = tt.toString(); //Value
            dato[1] = getItemLabel(tt); //Label
            tiposTarjeta.add(dato);
        }
        return tiposTarjeta;
    }

    private String getItemLabel(TipoTarjeta tt) {
        StringBuilder sb = new StringBuilder();
        sb.append("<img src=\"resources/img/creditcards/");
        sb.append(tt.toString().toLowerCase());
        sb.append(".gif\" ");
        //Atributo alt
        sb.append("alt=\"");
        sb.append(tt.getMarca());
        sb.append("\" ");
        //Atributo title
        sb.append("title=\"");
        sb.append(tt.getMarca());
        sb.append("\" ");
        //Cierre tag img
        sb.append("/>");
        return sb.toString();
    }
    
}
