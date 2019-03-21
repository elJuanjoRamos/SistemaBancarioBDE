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
public class PrestamoCliente {
    private Cliente cliente;
    private Prestamo prestamo;

    private int id;
    private Date fechaPrestamo;
    private Double monto;
    private Double abono;
    private String estado;
    
    public PrestamoCliente() {
    }

    public PrestamoCliente(Cliente cliente, Prestamo prestamo) {
        this.cliente = cliente;
        this.prestamo = prestamo;
        this.id = prestamo.getId();
        this.fechaPrestamo = prestamo.getFechaPrestamo();
        this.monto = prestamo.getMonto();
        this.abono = prestamo.getAbono();
        this.estado = prestamo.getEstado();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    
    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }

    public int getId() {
        return id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public Double getMonto() {
        return monto;
    }

    public Double getAbono() {
        return abono;
    }

    public String getEstado() {
        return estado;
    }
    
    
    
}
