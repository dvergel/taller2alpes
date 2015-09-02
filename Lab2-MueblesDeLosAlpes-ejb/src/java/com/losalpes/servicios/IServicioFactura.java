package com.losalpes.servicios;

import com.losalpes.bos.Factura;
import java.util.Date;
import java.util.List;

/**
 * Administrador de las facturas del sistema
 * @author Zamir
 */
public interface IServicioFactura {
    
    /**
     * Guarda la factura en el sistema y genera su número
     * @param factura Factura a guardar
     * @return Número de factura generada
     */
    int guardarFactura(Factura factura);
    
    /**
     * Retorna todas las facturas del sistema
     * @return Facturas del sistema
     */
    List<Factura> obtenerFacturas();
    
    /**
     * Retorna las facturas de acuerdo a un rango de fechas
     * @param inicio Fecha inicial de la factura
     * @param fin Fecha final
     * @return Facturas en un rango de fechas
     */
    List<Factura> obtenerFacturas(Date inicio, Date fin);
    
    /**
     * Anula una factura en el sistema
     * @param numero Numero de factua a anular
     * @return <b>true</b> Si fue anulada la factura, <b>false</b> en caso
     * contrario
     */
    boolean anularFactura(int numero);
    
}
