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

/**
 *
 * @author Juan José Ramos
 */
public class PagoController {
    
    /*Variables*/
    Pago[] pago = new Pago[1000];
    private ArrayList<Pago> arrayList = new ArrayList();

    
    public PagoController() {
         arrayList = new ArrayList();
    }
    
    /*-----------SINGLETON-----------*/
    private static final PagoController PagoController = new PagoController();
    private static PagoController instancia;
   
    public static PagoController getInstancia() {
        if (instancia == null) {
            instancia = new PagoController();
        }
        return instancia;
    }
    /*------------------------------*/
    
    
    public void agregar(String servicio, Double monto, String tipoPago, Cliente cliente, String cuenta, String agencia) {
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        
        
        for (int i = 0; i < pago.length; i++) {
            if (pago[i] == null ) {
                pago[i] = new Pago(i,servicio, monto, tipoPago, dateFormat.format(d), cliente, AgenciaController.getAgenciaController().buscarAgenciaUnica(agencia));
                break;
            }
        }
        
        if (AgenciaController.getAgenciaController().buscarAgenciaUnica(agencia) != null) {
            AgenciaBancaria a = AgenciaController.getAgenciaController().buscarAgenciaUnica(agencia);
            Double efectivo = a.getEfectivo();
            
            a.setEfectivo(efectivo + monto);
        }
        
        if (!cuenta.equals("")) {
            CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(cuenta));
            Double devito = c.getMontoInicial();
            
            c.getCuenta().setMontoInicial(devito - monto);
            c.setMontoInicial(devito-monto);

        }

    }
    
    
    
    /*BUSCAR PAGOS DE UN CLIENTE ESPECIFICO*/
        
    public ArrayList<Pago> getArrayPagosCliente(int idCliente) {
        this.arrayList.clear();
        
        for (Pago c : pago) {
            if (c != null) {
                if (c.getCliente().getId() == idCliente) {
                    arrayList.add(c);
                }
            }
        }
        return arrayList;
    }
    
    public Pago[] obtenerPagos() {
        return this.pago;
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
