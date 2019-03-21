/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Juan José Ramos
 */
public class CuentaAhorroCliente {
    private int id;
    private Cliente cliente;
    private CuentaAhorro cuentaAhorro;

    
    private Date fechaApertura;
    private Double montoInicial;

    
    public CuentaAhorroCliente() {
    }

    public CuentaAhorroCliente(int id, Cliente cliente, CuentaAhorro cuentaAhorro) {
        this.id = id;
        this.cliente = cliente;
        this.cuentaAhorro = cuentaAhorro;
        this.fechaApertura = cuentaAhorro.getFechaApertura();
        this.montoInicial = cuentaAhorro.getMontoInicial();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public CuentaAhorro getCuentaAhorro() {
        return cuentaAhorro;
    }

    public void setCuentaAhorro(CuentaAhorro cuentaAhorro) {
        this.cuentaAhorro = cuentaAhorro;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    
    
    
    
}
