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
public class Deposito {
    private int id;
    private int idDepositante;
    private String cuenta;
    private Double monto;
    private Date fecha;
    private String tipoDeposito;
    private Cliente cliente;
    private String nombre;
    public Deposito() {
    }

    public Deposito(int id, int idDepositante, String cuenta, Double monto, Date fecha, String tipoDeposito, Cliente cliente) {
        this.id = id;
        this.idDepositante = idDepositante;
        this.cuenta = cuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.tipoDeposito = tipoDeposito;
        this.cliente = cliente;
        this.nombre = cliente.getNombre();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCuenta() {
        return cuenta;
    }

    public void setCuenta(String cuenta) {
        this.cuenta = cuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoDeposito() {
        return tipoDeposito;
    }

    public void setTipoDeposito(String tipoDeposito) {
        this.tipoDeposito = tipoDeposito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdDepositante() {
        return idDepositante;
    }

    public void setIdDepositante(int idDepositante) {
        this.idDepositante = idDepositante;
    }
    
    
    
    
}
