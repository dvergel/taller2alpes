/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.losalpes.beans;

import com.losalpes.bos.Cliente;
import com.losalpes.servicios.IServicioCliente;
import com.losalpes.servicios.impl.ServicioClienteMock;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;

/**
 *
 * @author Dev
 */
@ManagedBean
@ViewScoped
public class ClienteBean {

    private Cliente cliente = new Cliente();
    private int index;
    private IServicioCliente clientes;
    private boolean selected = false;
    private String title = "Clientes";

    public ClienteBean() {
        this.cliente = new Cliente();
        this.clientes = new ServicioClienteMock();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public IServicioCliente getClientes() {
        return clientes;
    }

    public void setClientes(IServicioCliente clientes) {
        this.clientes = clientes;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void agregarCliente() {
        if (!isSelected()) {
            clientes.agregarCliente(cliente);
            cliente = new Cliente();
        }
    }

    public void removerCliente() {
        clientes.eliminarCliente(cliente);
    }

    public List<Cliente> getLClientes() {
        return clientes.consultarCliente();
    }

    public void onRowSelect(SelectEvent event) {
        setCliente((Cliente) event.getObject());
        setSelected(true);
    }

    public void onRowUnselect(UnselectEvent event) {
        reset();
    }

    public void reset() {
        setCliente(new Cliente());
        setSelected(false);
    }

    public void refresh() {
        reset();
    }

    public void initNew() {
        reset();
    }

    public void initEdit() {
    }

}
