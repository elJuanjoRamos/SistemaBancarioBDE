/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Date;

/**
 *
 * @author Ana Ramos
 */
public class RetiroAgencia {
    private int id;
    private String cuenta;
    private Double monto;
    private Date fecha;
    private int cliente;
    private int idAgencia;
    private AgenciaBancaria agencia;
    private String nombre;
    
    public RetiroAgencia() {
    }

    public RetiroAgencia(int id, String cuenta, Double monto, Date fecha, int cliente, AgenciaBancaria agencia) {
        this.id = id;
        this.cuenta = cuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.cliente = cliente;
        this.agencia = agencia;
        this.idAgencia = agencia.getId();
        this.nombre = agencia.getNombre();
        
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

    public int getCliente() {
        return cliente;
    }

    public void setCliente(int cliente) {
        this.cliente = cliente;
    }

    public int getIdAgencia() {
        return idAgencia;
    }

    public void setIdAgencia(int idAgencia) {
        this.idAgencia = idAgencia;
    }

    public AgenciaBancaria getAgencia() {
        return agencia;
    }

    public void setAgencia(AgenciaBancaria agencia) {
        this.agencia = agencia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
     
}
