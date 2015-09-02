/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios.impl;

import com.losalpes.bos.DatosPago;
import com.losalpes.servicios.IServicioFactura;
import com.losalpes.servicios.IServicioPago;

/**
 *
 * @author Zamir
 */
public class ServicioPagoMock implements IServicioPago {
    
    private IServicioFactura servicioFactura;

    public ServicioPagoMock() {
       servicioFactura = ServicioFacturaMock.getInstance();
    }  

    @Override
    public int realizarPago(DatosPago datosPago) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
