/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.AgenciaBancaria;
import java.util.InputMismatchException;

/**
 *
 * @author Juan José Ramos
 */
public class AgenciaController {
    private static final AgenciaController AgenciaController = new AgenciaController();
    
    private AgenciaBancaria[] array = new AgenciaBancaria[1000];
    
    
    private AgenciaController() {
    }

    private static AgenciaController instance;
    public static AgenciaController getAgenciaController(){
        if(instance == null){
            instance = new AgenciaController();
        }
        return instance;
    }
    
    public void agregar(String nombre, String direccion, String telefono, int noCajas, int escritorios, int autob, double efectivo) {
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new AgenciaBancaria(nombre, direccion, telefono, i, noCajas, escritorios,autob, efectivo);
                break;
            }
        }
        
    }
    public void borrar(int id) {
        for (int i = 0; i < array.length; i++) {
            if( i == id ) {
                array[i] = null;
                if (array[i + 1] != null ) {
                    array[i] = array[i + 1];
                    array[i + 1 ] = null;
                    break;
                }
            } 
        }
    }
    public void actualizar(int id, String nombre, String direccion, String telefono, int noCajas, int escritorios, int auto, double efectivo) {
        for (int i = 0; i < array.length; i++) {
            if (i == id) {
                AgenciaBancaria c = array[i];
                c.setNombre(nombre);
                c.setDireccion(direccion);
                c.setTelefono(telefono);
                c.setEscritorios(escritorios);
                c.setNoCajas(noCajas);
                c.setAuto(auto);
                c.setEfectivo(efectivo);
            }
        }
    }
    

    public AgenciaBancaria[] buscar(String nombre){
        AgenciaBancaria[] resultado = new AgenciaBancaria[1000];
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getNombre().toUpperCase().contains(nombre.toUpperCase())) {
                    for (int j = 0; j < 1000; j++) {
                        if (resultado[j] == null) {
                            resultado[j] = array[i];
                            break;
                        }
                    }        
                }
            }
        }
        return resultado;
    }   
    
    
    public AgenciaBancaria[] getArray() {
        AgenciaBancaria[] resultado = new AgenciaBancaria[1000];
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getAuto()== 0) {
                    for (int j = 0; j < 1000; j++) {
                        if (resultado[j] == null) {
                            resultado[j] = array[i];
                            break;
                        }
                    }        
                }
            }
        }
        return resultado;
    }
    
    public AgenciaBancaria[] getArray2() {
        AgenciaBancaria[] resultado = new AgenciaBancaria[1000];
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getAuto() != 0) {
                    for (int j = 0; j < 1000; j++) {
                        if (resultado[j] == null) {
                            resultado[j] = array[i];
                            break;
                        }
                    }        
                }
            }
        }
        return resultado;    }
    
    public boolean buscarAgencia(String nombre){
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (nombre.equalsIgnoreCase(array[i].getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean esNumero(String cadena, String cadena2, String cadena3, String cadena4) {
        
        
        boolean resultado;
        
        try {
            Integer.parseInt(cadena);
            Integer.parseInt(cadena2);
            Double.parseDouble(cadena3);
            Double.parseDouble(cadena4);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }
        
        return resultado;
    }
}
