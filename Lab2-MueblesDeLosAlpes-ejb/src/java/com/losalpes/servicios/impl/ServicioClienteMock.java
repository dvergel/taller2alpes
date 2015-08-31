/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.servicios.impl;

import com.losalpes.bos.Cliente;
import com.losalpes.servicios.IServicioCliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dev
 */
public class ServicioClienteMock implements IServicioCliente {
    
    public List<Cliente> clientes = new ArrayList<Cliente>();

    public ServicioClienteMock() {
        //TODO añadir clientes por defecto
    }

    @Override
    public void agregarCliente(Cliente cliente) {
        getClientes().add(cliente);
    }

    @Override
    public void eliminarCliente(Cliente cliente) {
        getClientes().remove(cliente);
    }

    @Override
    public List<Cliente> consultarCliente() {
        return getClientes();
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
}
