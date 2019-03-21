/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author Juan José Ramos
 */
public class OperacionesClienteController {
    /*Instancias*/
    Random aleatorio = new Random();
    
    /*Variables*/
    
    TarjetaCliente[] arrayTarjetaCliente = new TarjetaCliente[1000];
    PrestamoCliente[] arrayPrestamoCliente = new PrestamoCliente[1000];
    TarjetaCredito[] arrayTarjeta = new TarjetaCredito[1000];
    Prestamo[] arrayPrestamo = new Prestamo[1000];
    
    public int noTarjetaTransaccion = 0;
    public int noPrestamo;
    
    
    
    
    
    
    /*--------Singleton-------*/
    private static final OperacionesClienteController transaccionController = new OperacionesClienteController();
    private static OperacionesClienteController instancia;
    public OperacionesClienteController() {
    }
    
    public static OperacionesClienteController getInstancia() {
        if (instancia == null) {
            instancia = new OperacionesClienteController();
        }
        return instancia;
    }
    /*--------------------*/
    


    
    
    
    
    
    
    
    /*--------SECCION DE TARJETAS------*/
    
    public void agregarTarjeta(String fechaVencimiento, Double credito, Double deuda) {
        this.noTarjetaTransaccion = aleatorio.nextInt(900000000-100000000+1)+100000000; 
        for (int i = 0; i < arrayTarjeta.length; i++) {
            if (arrayTarjeta[i] == null) {
                arrayTarjeta[i] = new TarjetaCredito(noTarjetaTransaccion, fechaVencimiento, credito, deuda);
               
                break;   
                
            }
        }
    }
    
    
    
    public TarjetaCredito buscarTarjeta(int id) {
        TarjetaCredito t = new TarjetaCredito();
        for (int i = 0; i < arrayTarjeta.length; i++) {
            if (arrayTarjeta[i] != null) {
                if (arrayTarjeta[i].getId() == id) {
                    t = arrayTarjeta[i];
                    break;
                }
            }
        }
        return t;
    }
    
        
    public void agregarTarjetaCliente(int idCliente) {
        
        for (int i = 0; i < arrayTarjetaCliente.length; i++) {
            if (arrayTarjetaCliente[i] == null) {
                arrayTarjetaCliente[i] = new TarjetaCliente(ClienteController.getClienteController().buscar(idCliente), buscarTarjeta(this.noTarjetaTransaccion));
                break;
            }
        }
    }
    
    public TarjetaCredito[] getTarjeta(){
        return this.arrayTarjeta;
    }
    
    public TarjetaCliente[] getArrayTarjetaCliente(int idCliente) {
        TarjetaCliente[] result = new TarjetaCliente[1000];
        
        for (int i = 0; i < this.arrayTarjetaCliente.length; i++) {
            if (arrayTarjetaCliente[i] != null) {
                if (arrayTarjetaCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = arrayTarjetaCliente[i];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /*----------------------------------------*/
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*---------SECCION PRESTMAMOS--------------*/

        
    public void agregarPrestamo(Date fechaPrestamo, Double monto, Double abono) {
        
        for (int i = 0; i < arrayPrestamo.length; i++) {
            if (arrayPrestamo[i] == null) {
                arrayPrestamo[i] = new Prestamo(i, fechaPrestamo, monto, abono, "Pendiente");
                break;
            }
        }
    }
    
    
    
    public Prestamo buscarPrestamo(int id) {
        Prestamo t = new Prestamo();
        for (int i = 0; i < arrayPrestamo.length; i++) {
            if (arrayPrestamo[i] != null) {
                if (arrayPrestamo[i].getId() == id) {
                    t = arrayPrestamo[i];
                    break;
                }
            }
        }
        return t;
    }
    
    public void agregarPrestamoCliente(int idCliente, int idPrestamo) {
        for (int i = 0; i < arrayPrestamoCliente.length; i++) {
            if (arrayPrestamoCliente[i] == null) {
                arrayPrestamoCliente[i] = new PrestamoCliente(ClienteController.getClienteController().buscar(idCliente), buscarPrestamo(idPrestamo));
                break;
            }
        }  
    }
    
    public PrestamoCliente[] getPrestamoCliente(){
        return this.arrayPrestamoCliente;
    }
    
    public PrestamoCliente[] getArrayPrestamoCliente(int idCliente) {
        PrestamoCliente[] result = new PrestamoCliente[1000];
        
        for (int i = 0; i < this.arrayPrestamoCliente.length; i++) {
            if (arrayPrestamoCliente[i] != null) {
                if (arrayPrestamoCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = arrayPrestamoCliente[i];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
}
