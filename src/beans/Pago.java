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
public class Pago {
    
    private int id;
    private String servicio;
    private Double monto;
    private String tipoPago;
    private String fecha;
    private Cliente cliente;
    private AgenciaBancaria agencia;
    private String nombreAgencia;
    
    public Pago() {
    }

    public Pago(int id, String servicio, Double monto, String tipoPago, String fecha, Cliente cliente,AgenciaBancaria agenciaBancaria) {
        this.id = id;
        this.servicio = servicio;
        this.monto = monto;
        this.tipoPago = tipoPago;
        this.fecha = fecha;
        this.cliente = cliente;
        this.agencia = agenciaBancaria;
        this.nombreAgencia = agenciaBancaria.getNombre();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getServicio() {
        return servicio;
    }

    public void setServicio(String servicio) {
        this.servicio = servicio;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(String tipoPago) {
        this.tipoPago = tipoPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public AgenciaBancaria getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBancaria agencia) {
        this.agencia = agencia;
    }

    public String getNombreAgencia() {
        return nombreAgencia;
    }

    public void setNombreAgencia(String nombreAgencia) {
        this.nombreAgencia = nombreAgencia;
    }
    
    
    
    
}
