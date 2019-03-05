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
    private int transacciones;
    private int efectivo;
    private String ubicacion;
    private Boolean estado;
    
    public Cajero(){}
    
    public Cajero(int id,int transacciones,int efectivo,String ubicacion, Boolean estado) {
        this.id = id;
        this.transacciones = transacciones;
        this.efectivo = efectivo;
        this.ubicacion = ubicacion;
        this.estado = estado;
    }
    
    //Metodos Get
    public int getId() {
        return this.id;
    }
    public int getTransaccion() {
        return this.transacciones; 
    }
    public int getEfectivo() {
        return this.efectivo; 
    }
    public String getUbicacion() {
        return this.ubicacion; 
    }
    public Boolean getEstado() {
        return this.estado; 
    }
    
    //Metodos Set
    public void setId(int var) {
        this.id = var;
    }
    public void setTransaccion(int var) {
        this.transacciones = var;
    }
    public void setEfectivo(int var) {
        this.efectivo = var;
    }
    public void setUbicacion(String var) {
        this.ubicacion = var;
    }
    public void setEstado(Boolean var) {
        this.estado = var;
    }
}
