package com.losalpes.bos;



/**
 * Tipos de tarjetas recibidas por el sistema para efectuar una compra.
 * @author Zamir
 * @version 1.0
 * @created 01-sep-2015 07:01:40 p.m.
 */
public enum TipoTarjeta {
    
    MASTER("Master Card"),
    VISA("Visa"),
    AMEX("American Express"),
    DINERS("Diners Club Internacional");
        
    /**
     * Nombre de la marca de la tarjeta
     */
    private String marca;
        
    /**
     * Alias o nombre corto
     */
    private String alias;
    
    private TipoTarjeta(String marca){
        this.marca = marca;
    }

    public String getMarca() {
        return marca;
    }  
        
}