/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios;

import com.losalpes.bos.DatosPago;

/**
 * Servicio que ejecuta la solicitud de pago de una factura usando los 
 * medios de pago seleccionados
 * @author Zamir
 */
public interface IServicioPago {
    
    /**
     * Ejecuta el pago de una factura de acuerdo con los datos del pago
     * @param datosPago Datos del pago (Incluye factura)
     * @return número de aprobación de la transacción. -1 si no fue posible
     * realizar el pago.
     */
    public int realizarPago(DatosPago datosPago);
    
}
