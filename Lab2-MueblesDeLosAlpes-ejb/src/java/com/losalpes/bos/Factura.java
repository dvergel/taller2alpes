package com.losalpes.bos;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Representa una factura de venta.
 * 
 * El número de la factura es automaticamente generado por el sistema no debe
 * ser establecido manualmente.
 *
 * @author Zamir
 * @version 1.0
 * @created 01-sep-2015 07:01:37 p.m.
 */
public class Factura {
    
    public enum Estado {
        PAGADA,ANULADA
    }

    /**
     * Número de la factura
     */
    private int numero;
    
    /**
     * Fecha de compra o emisión de la factura
     */
    private Date fecha;
    
    /**
     * Identificación del tarjetahabiente
     */
    private BigDecimal idCliente;
    
    /**
     * Nombre del tarjetahabiente
     */
    private String nombreCliente;
    
    /**
     * Valor de la compra o subtotal de la compra.
     */
    private BigDecimal valorCompra;
    
    /**
     * Valor de los impuestos generados
     */
    private BigDecimal valorImpuestos;
    
    /**
     * Valor total de la factura (Valor pagado)
     */
    private BigDecimal valorTotal;
    
    /**
     * Tipo de tarjeta usado para la compra
     */
    private TipoTarjeta tipoTarjeta;
    
    /**
     * Items comprados
     */
    private List<Mueble> itemsComprados;
    
    /**
     * Estado de la factura
     */
    private Estado estado;

    public Factura() {
        super();
    }

    /**
     * Constructor de la factura usando parámetros
     * @param fecha
     * @param idCliente
     * @param nombreCliente
     * @param valorCompra
     * @param valorImpuestos
     * @param valorTotal
     * @param tipoTarjeta
     * @param itemsComprados 
     */
    public Factura(Date fecha, BigDecimal idCliente, String nombreCliente, 
                   BigDecimal valorCompra, BigDecimal valorImpuestos, 
                   BigDecimal valorTotal, TipoTarjeta tipoTarjeta, 
                   List<Mueble> itemsComprados) {
        this.fecha = fecha;
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.valorCompra = valorCompra;
        this.valorImpuestos = valorImpuestos;
        this.valorTotal = valorTotal;
        this.tipoTarjeta = tipoTarjeta;
        this.itemsComprados = itemsComprados;
    }

    /**
     * Retorna el numero de la factura
     * @return Numero de la factura
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Establece el número de la factura
     * @param numero Número de factura
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    /**
     * Retorna la fecha de generación de factura o fecha de compra
     * @return Fecha de compra
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha de emisión de la factura
     * @param fecha Fecha de emisión de factura
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * Retorna el número de identificación del cliente
     * @return identificacion del cliente
     */
    public BigDecimal getIdCliente() {
        return idCliente;
    }

    /**
     * Establece el número de identificacion del tarjetahabiente
     * @param idCliente Id del cliente
     */
    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Nombre del tarjetahabiente.
     * @return Nombre del tarjetahabiente
     */
    public String getNombreCliente() {
        return nombreCliente;
    }

    /**
     * Establece el nombre del tarjetahabiente
     * @param nombreCliente Nombre tarjetahabiente
     */
    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    /**
     * Retorna el subtotal del valor de la compra
     * @return Subtotal de la compra
     */
    public BigDecimal getValorCompra() {
        return valorCompra;
    }

    /**
     * Establece el subtotal de la compra
     * @param valorCompra Subtotal
     */
    public void setValorCompra(BigDecimal valorCompra) {
        this.valorCompra = valorCompra;
    }

    /**
     * Retorna el valor de los impuestos generados en la compra
     * @return Valor impuestos
     */
    public BigDecimal getValorImpuestos() {
        return valorImpuestos;
    }

    /**
     * Establece el valor de los impuestos generados en la compra
     * @param valorImpuestos Valor impuestos
     */
    public void setValorImpuestos(BigDecimal valorImpuestos) {
        this.valorImpuestos = valorImpuestos;
    }

    /**
     * Retorna el valor total de la factura, este es el valor a pagar por el
     * cliente
     * @return Valor total de compra 
     */
    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    /**
     * Establece el valor total de la factura, este es el valor a pagar por el
     * cliente
     * @param valorTotal Valor total de la compra
     */
    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    /**
     * Retorna el tipo de tarjeta de crédito usada para el pago
     * @return Tipo de tarjeta usada
     */
    public TipoTarjeta getTipoTarjeta() {
        return tipoTarjeta;
    }

    /**
     * Establece el tipo de tarjeta de crédito usada para el pago
     * @param tipoTarjeta tipo de tarjeta
     */
    public void setTipoTarjeta(TipoTarjeta tipoTarjeta) {
        this.tipoTarjeta = tipoTarjeta;
    }

    /**
     * Retorna la lista de items comprados
     * @return items comprados
     */
    public List<Mueble> getItemsComprados() {
        return itemsComprados;
    }

    /**
     * Establece la lista de items comprados
     * @param itemsComprados Items comprados
     */
    public void setItemsComprados(List<Mueble> itemsComprados) {
        this.itemsComprados = itemsComprados;
    }

    /**
     * Retorna el estado de la factura
     * @return Estado
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Establece el estado de la factura
     * @param estado Estado
     */
    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    


}
