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
public class Retiro {
    private int id;
    private String cuenta;
    private Double monto;
    private Date fecha;
    private int cliente;
    private String cadena;
    
    public Retiro() {
    }

    public Retiro(int id, String cuenta, Double monto, Date fecha, int cliente, String cadena) {
        this.id = id;
        this.cuenta = cuenta;
        this.monto = monto;
        this.fecha = fecha;
        this.cliente = cliente;
        this.cadena = cadena;
        
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

    public String getCadena() {
        return cadena;
    }

    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    
    
    
    
     
}
