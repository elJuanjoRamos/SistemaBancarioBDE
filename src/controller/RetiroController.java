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
    private ArrayList<RetiroAgencia> arrayList =new ArrayList();
    private RetiroAgencia[] array = new RetiroAgencia[1000];
        
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
    
    public void agregar(String cuenta, Double monto, int cliente, String agencia){
        
        AgenciaBancaria resultado = AgenciaController.getAgenciaController().buscarUnica(agencia);
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new RetiroAgencia(aleatorio.nextInt(900000000 - 100000000 + 1) + 100000000 , cuenta, monto, d, cliente, resultado);
                break;
            }
        }
        
        
        
    }
    
    public ArrayList<RetiroAgencia> getArrayRetiro(int idCliente) {
        for (RetiroAgencia r : array) {
            if (r != null) {
                if (r.getCliente() == idCliente) {
                    arrayList.add(r);
                }
            }
        }
        return arrayList;
    }

    
}
