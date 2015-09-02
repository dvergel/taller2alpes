/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios.impl;

import com.losalpes.bos.DatosPago;
import com.losalpes.servicios.IServicioFactura;
import com.losalpes.servicios.IServicioPago;
import java.util.Random;

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
        servicioFactura.guardarFactura(datosPago.getFactura());
        /*Random random = new Random();
        return random.nextInt(1000);*/
        return 1000;
    }
    
}
