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
public class Solicitudes {
    
    private int idSolicitud;
    private int idCliente;
    private Date fecha;
    private boolean estado;
    private Double monto;
    private int indicador;
    
    
    
    private Cliente cliente;
    private String nombre;
    private String direccion; 
    private String telefono;
    

    public Solicitudes() {
    }

    public Solicitudes(int idSolicitud, int idCliente, Date fecha, boolean estado, Double monto, Cliente cliente, int indicador) {
        this.idSolicitud = idSolicitud;
        this.idCliente = idCliente;
        this.fecha = fecha;
        this.estado = estado;
        this.monto = monto;
        this.cliente = cliente;
        this.nombre = cliente.getNombre();
        this.direccion = cliente.getDireccion();
        this.telefono = cliente.getTelefono();
        this.indicador = indicador;
    }

    public int getIdSolicitud() {
        return idSolicitud;
    }

    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public boolean isEstado() {
        return estado;
    }

    public boolean getEstado(){
        return this.estado;
    }
    
    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public int getIndicador() {
        return indicador;
    }

    public void setIndicador(int indicador) {
        this.indicador = indicador;
    }
    
    
    
}
