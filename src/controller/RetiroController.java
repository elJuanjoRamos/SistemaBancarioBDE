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
public class RetiroController {
    /*VARIABLES*/
    private ArrayList<Retiro> arrayList =new ArrayList();
    private Retiro[] array = new Retiro[1000];
    private Retiro[] arrayRetiroCajero = new Retiro[1000];
    
    /*Instancias*/
    Random aleatorio = new Random();
    DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
    Date d = new Date();
    
    /*SINGLETON*/
    private static final RetiroController RetiroController = new RetiroController();
   
    private RetiroController() {
        arrayList = new ArrayList<>();
    }

    private static RetiroController instance;
    public static RetiroController getRetiroController(){
        if(instance == null){
            instance = new RetiroController();
        }
        return instance;
    }
    /*--------*/
    
    
    /*Agregar retiro de agencia*/
    public void agregar(String cuenta, Double monto, int cliente, String objeto){
        
        String[] cadena = objeto.split("-");
        
        String detalle ="";
        
         
        if (AgenciaController.getAgenciaController().buscarUnica(objeto) != null)  {
            AgenciaBancaria resultado = AgenciaController.getAgenciaController().buscarUnica(cadena[0]);
            
            detalle =  "Agencia " + cadena[0];
            
            System.out.println("agencia");
            
            
        } else if(CajeroController.getCajeroControler().bucarCajeroUnico(cadena[0]) != null) {
            System.out.println("cajero");
            detalle = "Cajero No." + objeto;
        }
        
        
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new Retiro(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000 , cuenta, monto, d, cliente, detalle);
                break;
            }
        }
        
        if (CuentasCliente.getCuentasCliente().buscarCuentaAhorros(Integer.parseInt(cuenta)) != null) {

            Double montoInicial = CuentasCliente.getCuentasCliente().buscarCuentaAhorros(Integer.parseInt(cuenta)).getMontoInicial();
            CuentasCliente.getCuentasCliente().buscarCuentaAhorros(Integer.parseInt(cuenta)).setMontoInicial(montoInicial - monto);
                        
        } else if (CuentasCliente.getCuentasCliente().buscarCuentaMonetaria(Integer.parseInt(cuenta)) != null) {

            Double montoInicial = CuentasCliente.getCuentasCliente().buscarCuentaMonetaria(Integer.parseInt(cuenta)).getMontoInicial();
            CuentasCliente.getCuentasCliente().buscarCuentaMonetaria(Integer.parseInt(cuenta)).setMontoInicial(montoInicial - monto);
        }
    }
    
    
    /*agregar retiro de cajero*/
        
    
    
    public ArrayList<Retiro> getArrayRetiro(int idCliente) {
        this.arrayList.clear();
        for (Retiro r : array) {
            if (r != null) {
                if (r.getCliente() == idCliente) {
                    arrayList.add(r);
                }
            }
        }
        return arrayList;
    }

    
}
