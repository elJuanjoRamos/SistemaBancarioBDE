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
    private int contador;
    
    private Date fechaApertura;
    private Double montoInicial;
    private int idCuenta;
    private int cantidadCheques;
    
    public CuentaMonetariaCliente() {
    }

    public CuentaMonetariaCliente(int id, Cliente cliente, CuentaMonetaria cuenta, int contador) {
        this.id = id;
        this.cliente = cliente;
        this.cuenta = cuenta;
        this.fechaApertura = cuenta.getFechaApertura();
        this.montoInicial = cuenta.getMontoInicial();
        this.idCuenta = cuenta.getId();
        this.contador = contador;
        this.cantidadCheques = cuenta.getCantidadCheques();
        
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

    public int getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(int idCuenta) {
        this.idCuenta = idCuenta;
    }

    public void setCuenta(CuentaMonetaria cuenta) {
        this.cuenta = cuenta;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public void setMontoInicial(Double montoInicial) {
        this.montoInicial = montoInicial;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public int getCantidadCheques() {
        return cantidadCheques;
    }

    public void setCantidadCheques(int cantidadCheques) {
        this.cantidadCheques = cantidadCheques;
    }

    
}
