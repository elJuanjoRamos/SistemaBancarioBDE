/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import jdk.nashorn.internal.ir.ForNode;

/**
 *
 * @author Juan José Ramos
 */
public class PagoController {
    
    /*Variables*/
    Pago[] pago = new Pago[1000];
    
    
    /*-----------SINGLETON-----------*/
    private static final PagoController PagoController = new PagoController();
    private static PagoController instancia;
    public PagoController() {
    }
    
    public static PagoController getInstancia() {
        if (instancia == null) {
            instancia = new PagoController();
        }
        return instancia;
    }
    /*------------------------------*/
    
    
    public void agregar(String servicio, Double monto, String tipoPago, Cliente cliente) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        
        
        for (int i = 0; i < pago.length; i++) {
            if (pago[i] == null ) {
                pago[i] = new Pago(i,servicio, monto, tipoPago, dateFormat.format(d), cliente);
                break;
            }
        }
        
        for (int i = 0; i < pago.length; i++) {
            if (pago[i] != null) {
                System.out.println(pago[i].getCliente().getNombre());
                System.out.println(pago[i].getServicio());
                System.out.println(pago[i].getTipoPago());
                System.out.println(pago[i].getMonto());
            }
        }
    }
    
    
    
    /*BUSCAR PAGOS DE UN CLIENTE ESPECIFICO*/
        
    public Pago[] getArrayPagosCliente(int idCliente) {
        Pago[] result = new Pago[1000];
        
        for (int i = 0; i < this.pago.length; i++) {
            if (pago[i] != null) {
                if (pago[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = pago[i];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    
    
    
    
    public boolean esNumero(String cadena) {
        boolean resultado;
        
        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }
        
        return resultado;
    }
    
    
    
}
