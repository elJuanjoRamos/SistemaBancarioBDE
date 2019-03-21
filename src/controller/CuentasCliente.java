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
public class CuentasCliente {
    private static final CuentasCliente CuentasCliente = new CuentasCliente();
    
    
     /*Instancias*/
    Random aleatorio = new Random();
    
    /*variables*/
    private CuentaAhorro[] cuentaAhorro = new CuentaAhorro[1000];
    private CuentaMonetaria[] cuentaMonetaria = new CuentaMonetaria[1000];
    private CuentaAhorroCliente[] cuentaAhorroCliente = new CuentaAhorroCliente[1000];
    private CuentaMonetariaCliente[] cuentaMonetariaCliente = new CuentaMonetariaCliente[1000];
    
    public int noCuentaMonetaria;
    public int noCuentaAhorro;
    
    
    
    private CuentasCliente() {
    }

    private static CuentasCliente instance;
    public static CuentasCliente getCuentasCliente(){
        if(instance == null){
            instance = new CuentasCliente();
        }
        return instance;
    }
    
    
    /*-------------------CUENTA DE AHORRO--------------*/
    public void agregarCuentaAhorro(Date fechaApertura, Double montoInicial){
        this.noCuentaAhorro = aleatorio.nextInt(900000000-100000000+1)+100000000; 
        for (int i = 0; i < cuentaAhorro.length; i++) {
            if (cuentaAhorro[i] == null) {
                cuentaAhorro[i] = new CuentaAhorro(noCuentaAhorro, fechaApertura, montoInicial);
                break;
            }
        }
    }
    public CuentaAhorro buscarCuentaAhorros(int id) {
        CuentaAhorro t = new CuentaAhorro();
        for (int i = 0; i < cuentaAhorro.length; i++) {
            if (cuentaAhorro[i] != null) {
                if (cuentaAhorro[i].getId() == id) {
                    t = cuentaAhorro[i];
                    break;
                }
            }
        }
        return t;
    }
    public CuentaAhorroCliente[] getArrayCACliete(int idCliente){
        CuentaAhorroCliente[] result = new CuentaAhorroCliente[1000];
        
        for (int i = 0; i < this.cuentaAhorroCliente.length; i++) {
            if (cuentaAhorroCliente[i] != null) {
                if (cuentaAhorroCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = cuentaAhorroCliente[i];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    
    public String[] getArrayNoCACliete(int idCliente){
        String[] result = new String[1000];
        
        for (int i = 0; i < this.cuentaAhorroCliente.length; i++) {
            if (cuentaAhorroCliente[i] != null) {
                if (cuentaAhorroCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(cuentaAhorroCliente[i].getCuentaAhorro().getId());
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
    /*----------------CUENTA MONETARIA---------------*/
    public void agregarCuentaMonetaria(Date fechaApertura, Double montoInicial){
        this.noCuentaMonetaria = aleatorio.nextInt(900000000-100000000+1)+100000000; 
        for (int i = 0; i < cuentaMonetaria.length; i++) {
            if (cuentaMonetaria[i] == null) {
                cuentaMonetaria[i] = new CuentaMonetaria(noCuentaMonetaria, fechaApertura, montoInicial);
                break;
            }
        }
    }
 
    public CuentaMonetaria buscarCuentaMonetaria(int id) {
        CuentaMonetaria t = new CuentaMonetaria();
        for (int i = 0; i < cuentaMonetaria.length; i++) {
            if (cuentaMonetaria[i] != null) {
                if (cuentaMonetaria[i].getId() == id) {
                    t = cuentaMonetaria[i];
                    break;
                }
            }
        }
        return t;
    }
        public CuentaMonetariaCliente[] getArrayCMCliete(int idCliente){
        CuentaMonetariaCliente[] result = new CuentaMonetariaCliente[1000];
        
        for (int i = 0; i < this.cuentaMonetariaCliente.length; i++) {
            if (cuentaMonetariaCliente[i] != null) {
                if (cuentaMonetariaCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = cuentaMonetariaCliente[i];
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    
        
    public String[] getArrayNoCMCliete(int idCliente){
        String[] result = new String[10];
        
        for (int i = 0; i < this.cuentaMonetariaCliente.length; i++) {
            if (cuentaMonetariaCliente[i] != null) {
                if (cuentaMonetariaCliente[i].getCliente().getId() ==  idCliente) {
                    
                    for (int j = 0; j < result.length; j++) {
                        if (result[j] == null) {
                            result[j] = String.valueOf(cuentaMonetariaCliente[i].getCuenta().getId());
                            break;
                        }
                    }
                }
            }
        }
        return result;
    }
    /*----------------CUENTA MONETARIA CLIENTE-------------------*/
    
    
    public void agregarCuentaMonetariaCliente(int idCliente) {
        for (int i = 0; i < cuentaMonetariaCliente.length; i++) {
            if (cuentaMonetariaCliente[i] == null) {
                cuentaMonetariaCliente[i] = new CuentaMonetariaCliente(i, ClienteController.getClienteController().buscar(idCliente), buscarCuentaMonetaria(this.noCuentaMonetaria));
                break;
            }
        }
    }
    
    
    public void agregarCuentaAhorroCliente(int idCliente) {
        for (int i = 0; i < cuentaAhorroCliente.length; i++) {
            if (cuentaAhorroCliente[i] == null) {
                cuentaAhorroCliente[i] = new CuentaAhorroCliente(i, ClienteController.getClienteController().buscar(idCliente), buscarCuentaAhorros(this.noCuentaAhorro));
                break;
            }
        }
    }
    
    
    
    
}
