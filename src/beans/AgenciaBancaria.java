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
public class AgenciaBancaria {

    private String nombre;
    private String direccion;
    private String telefono;
    private int id;
    private int noCajas;
    private int escritorios;
    private int auto;
    private double efectivo;

    public AgenciaBancaria() {
    }

    public AgenciaBancaria(String nombre, String direccion, String telefono, int idAgencia, int noCajas,
            int escritorios, int autob, double efectivo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.id = idAgencia;
        this.noCajas = noCajas;
        this.auto = autob;
        this.escritorios = escritorios;
        this.efectivo = efectivo;
    }

    //Metodos Get

    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public String getTelefono() {
        return this.telefono;
    }

    public int getId() {
        return this.id;
    }

    public int getNoCajas() {
        return this.noCajas;
    }

    public int getEscritorios() {
        return this.escritorios;
    }

    public double getEfectivo() {
        return this.efectivo;
    }
  //Metodos Set

    public void setNombre(String var) {
        this.nombre = var;
    }

    public void setDireccion(String var) {
        this.direccion = var;
    }

    public void setTelefono(String var) {
        this.telefono = var;
    }

    public void setId(int var) {
        this.id = var;
    }

    public void setNoCajas(int var) {
        this.noCajas = var;
    }

    public void setEscritorios(int var) {
        this.escritorios = var;
    }

    public void setEfectivo(double var) {
        this.efectivo = var;
    }

    public int getAuto() {
        return auto;
    }

    public void setAuto(int auto) {
        this.auto = auto;
    }

}
