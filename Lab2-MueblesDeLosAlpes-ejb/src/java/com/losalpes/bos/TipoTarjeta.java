package com.losalpes.bos;



/**
 * Tipos de tarjetas recibidas por el sistema para efectuar una compra.
 * @author Zamir
 * @version 1.0
 * @created 01-sep-2015 07:01:40 p.m.
 */
public enum TipoTarjeta {
    
    MASTER_CARD("Master Card","master"),
    VISA("Visa","visa"),
    AMERICAN_EXPRESS("American Express", "amex"),
    DINERS("Diners Club Internacional","diners");
        
    /**
     * Nombre de la marca de la tarjeta
     */
    private String marca;
        
    /**
     * Alias o nombre corto
     */
    private String alias;
    
    private TipoTarjeta(String marca, String alias){
        this.marca = marca;
        this.alias = alias;
    }

    @Override
    public String toString() {
        return marca;
    }

    public String getAlias() {
        return alias;
    }        
        
}