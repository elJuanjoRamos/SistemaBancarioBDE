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
public class Prestamo {
    private int id;
    private Date fechaPrestamo;
    private Double monto;
    private Double abono;
    private String estado;
    private String codigo;
    
    public Prestamo() {
    }

    public Prestamo(int id, Date fechaPrestamo, Double monto, Double abono, String estado, String codigo) {
        this.id = id;
        this.fechaPrestamo = fechaPrestamo;
        this.monto = monto;
        this.abono = abono;
        this.estado = estado;
        this.codigo = codigo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(Date fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Double getDeuda() {
        return monto;
    }

    public void setDeuda(Double monto) {
        this.monto = monto;
    }

    public Double getAbono() {
        return abono;
    }

    public void setAbono(Double abono) {
        this.abono = abono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    
    
    
    
}
