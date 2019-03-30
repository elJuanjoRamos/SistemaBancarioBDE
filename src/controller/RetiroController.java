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
import java.util.InputMismatchException;
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
        
        
        
       
            AgenciaBancaria a = AgenciaController.getAgenciaController().buscarAgenciaUnica(objeto);
        
            Cajero cajero = CajeroController.getCajeroControler().bucarCajeroUnico(objeto);
        
        if (a != null) {
            System.out.println("entro");
            Double efectivo = a.getEfectivo();
            if (efectivo >= monto) {
                a.setEfectivo(efectivo - monto);
                a.getEfectivo();
        
            }
        } else if(cajero != null) {
            System.out.println("entro");
            Double efectivo = cajero.getEfectivo();
            
            if (efectivo >= monto) {
                int t = cajero.getTransaccion();
                cajero.setEfectivo(efectivo - monto);
                cajero.setTransaccion(t + 1);
                
            }
        }
        
        
        
        
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new Retiro(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000 , cuenta, monto, d, cliente, objeto);
                break;
            }
        }
        

        if (CuentasCliente.getCuentasCliente().getArrayCAClieteUnica(Integer.parseInt(cuenta)) != null) {

            CuentaAhorroCliente c = CuentasCliente.getCuentasCliente().getArrayCAClieteUnica(Integer.parseInt(cuenta));

            Double montoInicial = c.getMontoInicial();

            c.getCuentaAhorro().setMontoInicial(montoInicial - monto);
            c.setMontoInicial(montoInicial - monto);

        } else if (CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(cuenta)) != null) {

            CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(cuenta));

            Double montoInicial = c.getMontoInicial();

            c.getCuenta().setMontoInicial(montoInicial - monto);
            c.setMontoInicial(montoInicial - monto);

        }
        
   
        
        
    }
    
    public boolean esNumero(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException e) {
            return false;
        } catch (InputMismatchException a) {
            return false;
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
    
    public Retiro[] obtenerRetiros(){
        return this.array;
    }

    
}
