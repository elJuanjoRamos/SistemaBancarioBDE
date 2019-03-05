/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Juan Jose Ramos
 */
public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    
    /*private CuentaAhorro[] cuentaAhorro;
    private CuentaMonetaria[] cuentaMonetaria;
    private Prestamo[] prestamos;
    private TarjetaCredito[] tarjetaCredito;
    private Transaccion[] transacciones;
    */
    
    public Cliente(int id,String nombre,String direccion,String telefono /*,
                    CuentaAhorro[] ahorro, CuentaMonetaria[] monetaria, 
                    Prestamo[] prestamo, TarjetaCredito[] tcredito, Transaccion[] trans*/){
       
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        /*this.cuentaAhorro = ahorro;
        this.cuentaMonetaria = monetaria;
        this.prestamos = prestamo;
        this.tarjetaCredito = tcredito;
        this.transacciones = trans;*/
        
    }
   
    public Cliente() {
        
    }
    
    //Metodos Gett
    
    public Integer getId() {
        return this.id;
    }
    public String getNombre() {
        return this.nombre;
    }
    public String getDireccion() {
        return this.direccion;
    }
    public String getTelefono() {
        return this.telefono;
    }
    /*public CuentaAhorro getCuentaAhorro() {
        //return this.cuentaAhorro;
    }
    public CuentaMonetaria getCuentaMonetaria() {
        //return this.cuentaMonetaria;
        
    }
    
    public Prestamo getPrestamo() {
        return this.prestamos;
    }
    
    public TarjetaCredito getTarjetaCredito() {
        return this.tarjetaCredito;
    }
    public Transaccion getTransaccion() {
        return this.transacciones;
    } */       
    
    //Metdos Sett
    public void setId(int var) {
        this.id = var;
    }
    public void setNombre(String var) {
        this.nombre = var;
    }
    public void setDireccion(String var) {
        this.direccion = var;
    }
    public void setTelefono(String var) {
        this.telefono = var;
    }
    /*public void setCuentaAhorro(CuentaAhorro var) {
        this.cuentaAhorro = var;
    }
    
    public void setCuentaMonetaria(CuentaMonetaria var) {
        this.cuentaMonetaria = var;
    }
    
    public void setPrestamo(Prestamo var) {
        this.prestamos = var;
    }
    
    public void setTarjetaCredito(TarjetaCredito var) {
        this.tarjetaCredito = var;
    }
    public void setTransacciones(Transaccion var) {
        this.transacciones = transaccion;
    }*/
}
