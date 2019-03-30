/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import controller.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

/**
 *
 * @author Juan José Ramos
 */
public class SolicitudController {
    /*SINGLETON*/
    
    private static SolicitudController instance;
    
    Solicitudes[] solicitud = new Solicitudes[1000];
    ArrayList<Solicitudes> arrayListSolicitud = new ArrayList();
    
    
    Date d = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Random aleatorio = new Random();
    
    
    public static SolicitudController getSolicitudController(){
        if(instance == null){
            instance = new SolicitudController();
        }
        return instance;
    }
    
    
    
     
    
    public void generarSolicitud(int idCliente, Cliente cliente, Double monto, int indicador){
        
        for (int i = 0; i < solicitud.length; i++) {
            if (solicitud[i] == null) {
                solicitud[i] = new Solicitudes(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000, idCliente, d, false, monto, cliente, indicador);
                break;
            }
        }
    }
    
     public ArrayList<Solicitudes> getSolicitudPrestamo() {
        this.arrayListSolicitud.clear();
        for (Solicitudes c : solicitud) {
            if (c != null) {
                if (c.getIndicador() == 0 &&  c.getEstado() == false) {
                    arrayListSolicitud.add(c);
                }
            }
        }
        return arrayListSolicitud;
    }
     
     
     public ArrayList<Solicitudes> getSolicitudTarjeta() {
        this.arrayListSolicitud.clear();
        for (Solicitudes c : solicitud) {
            if (c != null) {
                if (c.getIndicador() == 1 &&  c.getEstado() == false) {
                    arrayListSolicitud.add(c);
                }
            }
        }
        return arrayListSolicitud;
    } 
     
     
    public ArrayList<Solicitudes> getSolicitudCuentaM() {
        this.arrayListSolicitud.clear();
        for (Solicitudes c : solicitud) {
            if (c != null) {
                if (c.getIndicador() == 2 &&  c.getEstado() == false) {
                    arrayListSolicitud.add(c);
                }
            }
        }
        return arrayListSolicitud;
    } 
     
    public ArrayList<Solicitudes> getSolicitudCuentaA() {
        this.arrayListSolicitud.clear();
        for (Solicitudes c : solicitud) {
            if (c != null) {
                if (c.getIndicador() == 3 &&  c.getEstado() == false) {
                    arrayListSolicitud.add(c);
                }
            }
        }
        return arrayListSolicitud;
    }  
     
     
     
     
     
     
     
     
     
     
     
     
     
    public void aceptarSolicitud(Solicitudes solicitud1){
         
         TarjetasYPrestamosCliente.getInstancia().agregarPrestamo(solicitud1.getMonto(), 0.0);
         TarjetasYPrestamosCliente.getInstancia().agregarPrestamoCliente(solicitud1.getCliente().getId());
         
         for (int i = 0; i < solicitud.length; i++) {
             if (solicitud[i] != null) {
                 if (solicitud[i].getIdSolicitud() == solicitud1.getIdSolicitud()) {
                     solicitud[i].setEstado(true);
                }
             }
         }  
     }
    
    public void aceptarTarjeta(Solicitudes s, Double monto){
         
        
        TarjetasYPrestamosCliente.getInstancia().agregarTarjeta(dateFormat.format(s.getFecha()), monto, monto);
        TarjetasYPrestamosCliente.getInstancia().agregarTarjetaCliente(s.getCliente().getId());
        
         
         for (int i = 0; i < solicitud.length; i++) {
             if (solicitud[i] != null) {
                 if (solicitud[i].getIdSolicitud() == s.getIdSolicitud()) {
                     solicitud[i].setEstado(true);
                }
             }
         }  
     }
 
    
    public void aceptarSolicitudCuentaM(Solicitudes solicitud1){
         
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(solicitud1.getMonto());
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(solicitud1.getCliente().getId());
        
         for (int i = 0; i < solicitud.length; i++) {
             if (solicitud[i] != null) {
                 if (solicitud[i].getIdSolicitud() == solicitud1.getIdSolicitud()) {
                     solicitud[i].setEstado(true);
                }
             }
         }  
    }
    
    
    public void aceptarSolicitudCuentaA(Solicitudes solicitud1){
         
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(solicitud1.getMonto());
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(solicitud1.getCliente().getId());
        
         for (int i = 0; i < solicitud.length; i++) {
             if (solicitud[i] != null) {
                 if (solicitud[i].getIdSolicitud() == solicitud1.getIdSolicitud()) {
                     solicitud[i].setEstado(true);
                }
             }
         }  
    }
}
