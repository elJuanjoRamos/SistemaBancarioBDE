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
    private int noTarjeta;
    private String fechaVencimiento;
    private Double credito;
    private Double deuda;

    public TarjetaCredito() {
    }

    public TarjetaCredito(int noTarjeta, String fechaVencimiento, Double credito, Double deuda) {
        this.noTarjeta = noTarjeta;
        this.fechaVencimiento = fechaVencimiento;
        this.credito = credito;
        this.deuda = deuda;
    }

    public int getNoTarjeta() {
        return noTarjeta;
    }

    public void setNoTarjeta(int noTarjeta) {
        this.noTarjeta = noTarjeta;
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
