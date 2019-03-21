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
    
    
    /*----------OBTENER UNA UNICA TARJETA---------------*/
    
    public TarjetaCredito buscarTarjetaCliente(int idTarjeta) {
        TarjetaCredito resultado = new TarjetaCredito();
        for (int i = 0; i < this.arrayTarjetaCliente.length; i++) {
            if (arrayTarjetaCliente[i] != null) {
                if (arrayTarjetaCliente[i].getTarjeta().getId() ==  idTarjeta) {
                    resultado =  arrayTarjetaCliente[i].getTarjeta();
                }
            }            
        }
        return resultado;
    }
    
    
    public String[] getArrayTarjetaClienteEspecifico(int idCliente) {
        String[] result = new String[10];
        
        for (int i = 0; i < this.arrayTarjetaCliente.length; i++) {
            if (arrayTarjetaCliente[i] != null) {
                if (arrayTarjetaCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(arrayTarjetaCliente[i].getTarjeta().getId());
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    
    /*---------------Modificar tarjeta al pagar------------*/
    public void modificarTarjeta(int idTarjeta, Double monto, int idCliente){
        for (int i = 0; i < arrayTarjetaCliente.length; i++) {
            if (arrayTarjetaCliente[i] != null) {
                if (arrayTarjetaCliente[i].getTarjeta().getId() == idTarjeta) {
                    System.out.println(idTarjeta);
                    System.out.println(arrayTarjetaCliente[i].getTarjeta().getId());
                    System.out.println(arrayTarjetaCliente[i].getTarjeta().getDeuda());
                    
                    Double deuda = arrayTarjetaCliente[i].getTarjeta().getDeuda();
                    arrayTarjetaCliente[i].getTarjeta().setDeuda(deuda - monto);
                    arrayTarjetaCliente[i].setDeuda(deuda-monto);
                }
            }
        }
    }
    

    
    
    
    
    
    
    
    
    
    /*---------SECCION PRESTMAMOS--------------*/

        
    public void agregarPrestamo(Date fechaPrestamo, Double monto, Double abono) {
        this.noPrestamo = aleatorio.nextInt(900000-100000+1)+100000;
        for (int i = 0; i < arrayPrestamo.length; i++) {
            if (arrayPrestamo[i] == null) {
                arrayPrestamo[i] = new Prestamo(i, fechaPrestamo, monto, abono, "Pendiente", String.valueOf(this.noPrestamo));
                break;
            }
        }
        
        
    }
    
    
    
    public Prestamo buscarPrestamo(int codigo) {
        Prestamo t = new Prestamo();
        for (int i = 0; i < arrayPrestamo.length; i++) {
            if (arrayPrestamo[i] != null) {
                if (arrayPrestamo[i].getCodigo().equals(String.valueOf(codigo))) {
                    t = arrayPrestamo[i];
                    break;
                }
            }
        }
        return t;
    }
    
    public void agregarPrestamoCliente(int idCliente) {
        
        for (int i = 0; i < arrayPrestamoCliente.length; i++) {
            if (arrayPrestamoCliente[i] == null) {
                arrayPrestamoCliente[i] = new PrestamoCliente(ClienteController.getClienteController().buscar(idCliente), buscarPrestamo(this.noPrestamo));
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
    
    /*----------BUSCAR UN PRESTAMO POR CODIGO DE UN CLIENTE ESPECIFICO ----------*/
    public Prestamo buscarPrestamoCliente(String id) {
        Prestamo resultado = new Prestamo();
        for (int i = 0; i < this.arrayPrestamoCliente.length; i++) {
            if (arrayPrestamoCliente[i] != null) {
                if (arrayPrestamoCliente[i].getPrestamo().getCodigo().equals(id)) {
                    resultado =  arrayPrestamoCliente[i].getPrestamo();
                }
            }            
        }
        return resultado;
    }
    
    
    public String[] getArrayPrestamoClienteEspecifico(int idCliente) {
        String[] result = new String[10];
        
        for (int i = 0; i < this.arrayPrestamoCliente.length; i++) {
            if (arrayPrestamoCliente[i] != null) {
                if (arrayPrestamoCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(arrayPrestamoCliente[i].getCodigo());
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    /*-----------------MODIFICAR PRESTAMO DEL CLIENTE---------------------*/
    public void modificarPrestamo(String codigo, Double monto, int idCliente){
        
        for (int i = 0; i < arrayPrestamoCliente.length; i++) {
            if (arrayPrestamoCliente[i] != null) {
                if (arrayPrestamoCliente[i].getPrestamo().getCodigo().equals(codigo)) {
                    
                    Double deuda = arrayPrestamoCliente[i].getPrestamo().getDeuda();
                    Double abono = arrayPrestamoCliente[i].getPrestamo().getAbono();
                    
                    arrayPrestamoCliente[i].getPrestamo().setDeuda(deuda - monto);
                    arrayPrestamoCliente[i].getPrestamo().setAbono(abono + monto);
                    
                    
                    arrayPrestamoCliente[i].setDeuda(deuda-monto);
                    arrayPrestamoCliente[i].setAbono(abono + monto);
                    
                    
                }
            }
        }
        
    }
}
