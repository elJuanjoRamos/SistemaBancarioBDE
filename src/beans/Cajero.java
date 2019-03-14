/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Juan José Ramos
 */
public class Cajero {
    private int id;
    private int transaccion;
    private Double efectivo;
    private String ubicacion;
    private String estado;
    
    public Cajero(){}
    
    public Cajero(int id,int transacciones,Double efectivo,String ubicacion, String estado) {
        this.id = id;
        this.transaccion = transacciones;
        this.efectivo = efectivo;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    
    //Metodos Get
    public int getId() {
        return this.id;
    }
    public int getTransaccion() {
        return this.transaccion; 
    }
    public Double getEfectivo() {
        return this.efectivo; 
    }
    public String getUbicacion() {
        return this.ubicacion; 
    }
    public String getEstado() {
        return this.estado; 
    }
    
    //Metodos Set
    public void setId(int var) {
        this.id = var;
    }
    public void setTransaccion(int var) {
        this.transaccion = var;
    }
    public void setEfectivo(Double var) {
        this.efectivo = var;
    }
    public void setUbicacion(String var) {
        this.ubicacion = var;
    }
    public void setEstado(String var) {
        this.estado = var;
    }
}
