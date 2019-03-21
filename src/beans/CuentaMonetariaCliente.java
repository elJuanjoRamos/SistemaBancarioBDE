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
public class CuentaMonetariaCliente {
    private int id;
    private Cliente cliente;
    private CuentaMonetaria cuenta;

    
    private Date fechaApertura;
    private Double montoInicial;

    
    public CuentaMonetariaCliente() {
    }

    public CuentaMonetariaCliente(int id, Cliente cliente, CuentaMonetaria cuenta) {
        this.id = id;
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.fechaApertura = cuenta.getFechaApertura();
        this.montoInicial = cuenta.getMontoInicial();
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

    public CuentaMonetaria getCuenta() {
        return cuenta;
    }

    public void setCuentaMonetaria(CuentaMonetaria cuenta) {
        this.cuenta = cuenta;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public Double getMontoInicial() {
        return montoInicial;
    }

    
}
