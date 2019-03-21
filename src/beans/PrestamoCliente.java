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
    private Double deuda;
    private Double abono;
    private String estado;
    private String codigo;
    
    public PrestamoCliente() {
    }

    public PrestamoCliente(Cliente cliente, Prestamo prestamo) {
        this.cliente = cliente;
        this.prestamo = prestamo;
        this.id = prestamo.getId();
        this.fechaPrestamo = prestamo.getFechaPrestamo();
        this.deuda = prestamo.getDeuda();
        this.abono = prestamo.getAbono();
        this.estado = prestamo.getEstado();
        this.codigo = prestamo.getCodigo();
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

    public Double getDeuda() {
        return deuda;
    }

    public Double getAbono() {
        return abono;
    }

    public String getEstado() {
        return estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public void setDeuda(Double monto) {
        this.deuda = monto;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    
    
}
