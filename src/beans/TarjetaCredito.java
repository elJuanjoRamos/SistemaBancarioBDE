/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Ana Ramos
 */
public class TarjetaCredito {
    private int id;
    private String fechaVencimiento;
    private Double credito;
    private Double deuda;

    public TarjetaCredito() {
    }

    public TarjetaCredito(int noTarjeta, String fechaVencimiento, Double credito, Double deuda) {
        this.id = noTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.credito = credito;
        this.deuda = deuda;
    }

    public int getId() {
        return id;
    }

    public void setId(int noTarjeta) {
        this.id = noTarjeta;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public Double getDeuda() {
        return deuda;
    }

    public void setDeuda(Double deuda) {
        this.deuda = deuda;
    }
    
    
}
