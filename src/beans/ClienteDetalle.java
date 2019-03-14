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
public class ClienteDetalle {
    private Cliente cliente;
    private TarjetaCredito tarjeta;
    private Prestamo prestamo;

    public ClienteDetalle() {
    }

    public ClienteDetalle(Cliente cliente, TarjetaCredito tarjeta, Prestamo prestamo) {
        this.cliente = cliente;
        this.tarjeta = tarjeta;
        this.prestamo = prestamo;
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

    public Prestamo getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(Prestamo prestamo) {
        this.prestamo = prestamo;
    }
    
    
    
}
