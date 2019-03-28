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
public class SolicitudController {
    /*SINGLETON*/
    
    private static SolicitudController instance;
    
    SolicitudTarjeta[] solicitudTarjeta = new SolicitudTarjeta[1000];
    ArrayList<SolicitudTarjeta> arrayTarjeta = new ArrayList();
    
    SolicitudPrestamo[] solicitudPrestamo = new SolicitudPrestamo[1000];
   ArrayList<SolicitudPrestamo> arrayPrestamo = new ArrayList();
    
    
    Date d = new Date();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Random aleatorio = new Random();
    
    
    public static SolicitudController getSolicitudController(){
        if(instance == null){
            instance = new SolicitudController();
        }
        return instance;
    }
    
    public void generarSolicitudTarjeta(int idCliente, Cliente cliente){
        
        for (int i = 0; i < solicitudTarjeta.length; i++) {
            
            if (solicitudTarjeta[i] == null) {
                solicitudTarjeta[i] = new SolicitudTarjeta(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000, idCliente, d, false, cliente);
                break;
            }
        }
       
    }
    
    public ArrayList<SolicitudTarjeta> getSolicitudTarjeta() {
        this.arrayTarjeta.clear();
        for (SolicitudTarjeta c : solicitudTarjeta) {
            if (c != null) {
                if (c.getEstado() == false) {
                    arrayTarjeta.add(c);
                }
            }
        }
        return arrayTarjeta;
    }
    
     
    
    public void generarSolicitudPrestamo(int idCliente, Cliente cliente, Double monto){
        
        for (int i = 0; i < solicitudPrestamo.length; i++) {
            if (solicitudPrestamo[i] == null) {
                solicitudPrestamo[i] = new SolicitudPrestamo(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000, idCliente, d, false, monto, cliente);
                break;
            }
        }
    }
    
     public ArrayList<SolicitudPrestamo> getSolicitudPrestamo() {
        this.arrayPrestamo.clear();
        for (SolicitudPrestamo c : solicitudPrestamo) {
            if (c != null) {
                if (c.getEstado() == false) {
                    arrayPrestamo.add(c);
                }
            }
        }
        return arrayPrestamo;
    }
     
     
     
    public void aceptarPrestamo(SolicitudPrestamo solicitud){
         
         TarjetasYPrestamosCliente.getInstancia().agregarPrestamo(solicitud.getMonto(), 0.0);
         TarjetasYPrestamosCliente.getInstancia().agregarPrestamoCliente(solicitud.getCliente().getId());
         
         for (int i = 0; i < solicitudPrestamo.length; i++) {
             if (solicitudPrestamo[i] != null) {
                 if (solicitudPrestamo[i].getIdSolicitud() == solicitud.getIdSolicitud()) {
                     System.out.println("eta entrando aceptar prestamo");
                     solicitudPrestamo[i].setEstado(true);
                }
             }
         }  
     }
    
    public void aceptarTarjeta(SolicitudTarjeta solicitud, Double monto){
         
        
        TarjetasYPrestamosCliente.getInstancia().agregarTarjeta(dateFormat.format(solicitud.getFecha()), monto, 0.0);
        TarjetasYPrestamosCliente.getInstancia().agregarTarjetaCliente(solicitud.getCliente().getId());
        
         
         for (int i = 0; i < solicitudTarjeta.length; i++) {
             if (solicitudTarjeta[i] != null) {
                 if (solicitudTarjeta[i].getIdSolicitud() == solicitud.getIdSolicitud()) {
                     System.out.println("esta etrando aceptar tarjeta");
                     solicitudTarjeta[i].setEstado(true);
                     System.out.println(solicitudTarjeta[i].getEstado());
                }
             }
         }  
     }
}
