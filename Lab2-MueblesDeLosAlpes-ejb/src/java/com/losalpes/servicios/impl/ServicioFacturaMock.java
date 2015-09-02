/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios.impl;

import com.losalpes.bos.Factura;
import com.losalpes.servicios.IServicioFactura;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Zamir
 */
public class ServicioFacturaMock implements IServicioFactura {
    
    /*
     * Se implementa tipo singleton para que pueda verse las facturas sin 
     * importar las sesiones.
     */
    
    private List<Factura> facturas;
    
    private static ServicioFacturaMock instance;
    
    private ServicioFacturaMock(){
        facturas = new ArrayList<>();
    }

    @Override
    public int guardarFactura(Factura factura) {
        facturas.add(factura);
        int numero = facturas.size();
        factura.setNumero(numero);
        return numero;
    }

    @Override
    public List<Factura> obtenerFacturas() {
        return facturas;
    }

    @Override
    public List<Factura> obtenerFacturas(Date inicio, Date fin) {
        if (inicio == null || fin == null) return facturas;
        List<Factura> filtroFacturas = new ArrayList<>();
        for (Factura factura: facturas) {
            int iniCompare = factura.getFecha().compareTo(inicio);
            int finCompare = factura.getFecha().compareTo(fin);
            if (iniCompare >= 0 && finCompare < 0) {
                filtroFacturas.add(factura);
            }
            System.out.println(factura.getFecha());
        }
        return filtroFacturas;
    }

    @Override
    public boolean anularFactura(int numero) {
        if (numero <= 0 || numero > facturas.size()) return false;
        facturas.get(numero - 1).setEstado(Factura.Estado.ANULADA);
        return true;
    }
    
    /**
     * Retorna la instancia del servicio.
     * @return instancia
     */
    public static ServicioFacturaMock getInstance(){
        if (instance == null) {
            instance = new ServicioFacturaMock();
        }
        return instance;
    }
    
}
