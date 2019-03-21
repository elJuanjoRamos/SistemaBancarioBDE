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
public class TarjetaCliente {
    private Cliente cliente;
    private TarjetaCredito tarjeta;
    
    private int numero;
    private String fechaVencimiento;
    private Double credito;
    private Double deuda; 
    
    public TarjetaCliente() {
    }

    public TarjetaCliente(Cliente cliente, TarjetaCredito tarjeta) {
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.numero = tarjeta.getId();
        this.fechaVencimiento = tarjeta.getFechaVencimiento();
        this.credito = tarjeta.getCredito();
        this.deuda = tarjeta.getDeuda();
        
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TarjetaCredito getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(TarjetaCredito tarjeta) {
        this.tarjeta = tarjeta;
    }

    public int getNumero() {
        return numero;
    }

    public String getFechaVencimiento() {
        return fechaVencimiento;
    }

    public Double getCredito() {
        return credito;
    }

    public Double getDeuda() {
        return deuda;
    }
    
    


}
