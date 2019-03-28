/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
/**
 *
 * @author Juan José Ramos
 */
public class TarjetasYPrestamosCliente {
    /*Instancias*/
    Random aleatorio = new Random();
    
    /*Variables*/
    
    TarjetaCliente[] arrayTarjetaCliente = new TarjetaCliente[1000];
    PrestamoCliente[] arrayPrestamoCliente = new PrestamoCliente[1000];
    TarjetaCredito[] arrayTarjeta = new TarjetaCredito[1000];
    Prestamo[] arrayPrestamo = new Prestamo[1000];
    
    private ArrayList<TarjetaCliente> arrayListTarjeta =new ArrayList();
    private ArrayList<PrestamoCliente> arrayListPrestamo =new ArrayList();
    
    public int noTarjetaTransaccion = 0;
    public int noPrestamo;
    
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date d = new Date();
        
    
    public TarjetasYPrestamosCliente() {
        arrayListTarjeta =new ArrayList();
        arrayListPrestamo =new ArrayList();
    }
    
    
    /*--------Singleton-------*/
    private static final TarjetasYPrestamosCliente transaccionController = new TarjetasYPrestamosCliente();
    private static TarjetasYPrestamosCliente instancia;
    
    
    
    public static TarjetasYPrestamosCliente getInstancia() {
        if (instancia == null) {
            instancia = new TarjetasYPrestamosCliente();
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
    
    public ArrayList<TarjetaCliente> getArrayTarjetaCliente(int idCliente) {
        this.arrayListTarjeta.clear();
        
        for (TarjetaCliente c : arrayTarjetaCliente) {
            
            if (c != null) {
                
                if (c.getCliente().getId() == idCliente) {
                    arrayListTarjeta.add(c);
                }
                
            }
        }
        
        return arrayListTarjeta;
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
    
    
    public ArrayList<String> getArrayTarjetaClienteEspecifico(int idCliente) {
        
        ArrayList<String> array = new ArrayList();
        
        for (TarjetaCliente c : arrayTarjetaCliente) {
            if (c != null) {
                if (c.getCliente().getId() == idCliente) {
                    array.add(String.valueOf(c.getTarjeta().getId()));
                }
            }
            
        }
        
        return array;
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

        
    public void agregarPrestamo(Double monto, Double abono) {
        this.noPrestamo = aleatorio.nextInt(900000-100000+1)+100000;
        for (int i = 0; i < arrayPrestamo.length; i++) {
            if (arrayPrestamo[i] == null) {
                arrayPrestamo[i] = new Prestamo(i, d, monto, abono, "Pendiente", String.valueOf(this.noPrestamo));
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
    
    
    
    public ArrayList<PrestamoCliente> getArrayPrestamoCliente(int idCliente) {
        this.arrayListPrestamo.clear();
        
        for (PrestamoCliente c : arrayPrestamoCliente) {
            if (c != null) {
                if (c.getCliente().getId() == idCliente) {
                    arrayListPrestamo.add(c);
                }
            }
        }
        
        return arrayListPrestamo;
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
    
    
    public ArrayList<String> getArrayPrestamoClienteEspecifico(int idCliente) {
        ArrayList<String> arrayList = new ArrayList();
        
        for (PrestamoCliente c : arrayPrestamoCliente) {
            if (c != null) {
                if (c.getCliente().getId() == idCliente) {
                    arrayList.add(c.getCodigo());
                }
            }   
        }
        
        return arrayList;
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
                    
                    if (arrayPrestamoCliente[i].getDeuda() == 0) {
                        arrayPrestamoCliente[i].setEstado("Pagado");
                    }
                    
                    
                }
            }
        }
        
    }
}
