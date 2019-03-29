/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.*;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Juan José Ramos
 */
public class AgenciaController {
    
    
    private ArrayList<AgenciaBancaria> arrayList =new ArrayList();
    private ArrayList<AgenciaBancaria> arrayListAutoBanco =new ArrayList();
    
    
    /*SINGLETON*/
    private static final AgenciaController AgenciaController = new AgenciaController();
    
    
    private static AgenciaController instance;

    public static AgenciaController getAgenciaController(){
        if(instance == null){
            instance = new AgenciaController();
        }
        return instance;
    }
    /*-------------*/

    private AgenciaController() {
        arrayList = new ArrayList<>();
        arrayListAutoBanco = new ArrayList<>();
    }

    private AgenciaBancaria[] array = new AgenciaBancaria[1000];
    
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
                array[i] = null ;
                break;
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
    
    /*BUSCAR*/
    public ArrayList<AgenciaBancaria> buscar(String nombre){
        this.arrayList.clear();
        AgenciaBancaria[] resultado = new AgenciaBancaria[1000];
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getNombre().toUpperCase().contains(nombre.toUpperCase()) ||
                    array[i].getDireccion().toUpperCase().contains(nombre.toUpperCase()) ||
                    array[i].getTelefono().toUpperCase().contains(nombre.toUpperCase())) {
                    for (int j = 0; j < 1000; j++) {
                        if (resultado[j] == null) {
                            resultado[j] = array[i];
                            break;
                        }
                    }        
                }
            }
        }
        for (AgenciaBancaria a : resultado) {
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }   

    
    /*ARRAY DE LAS AGENCIAS SIN AUTOBANCO*/
    public ArrayList<AgenciaBancaria> getArray() {
        this.arrayList.clear();
        
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
        for (AgenciaBancaria a : resultado) {
            if (a != null) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }
    
    
    /*ARRAY DE LAS CUENTAS CON AUTOBANCO*/
    public ArrayList<AgenciaBancaria> getArray2() {
        this.arrayListAutoBanco.clear();
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
        for (AgenciaBancaria a : resultado) {
            if (a != null) {
                arrayListAutoBanco.add(a);
            }
        }
        return arrayListAutoBanco;    
    }
    /*ARRAY DE NOMBRES DE AGENCIAS SIN AUTOBANCO*/
    public ArrayList<String> getNombreAgencia() {
        ArrayList<String> agencias = new ArrayList();
        
        for (AgenciaBancaria agencia : array) {
            if (agencia != null)  {
                if (agencia.getAuto() == 0) {
                    agencias.add(agencia.getNombre());
                }
            }
        }
        
        return agencias;    
    }
    
    /*ARRAY DE NOMBRES DE AGENCIAS SIN AUTOBANCO*/
    public ArrayList<String> getNombreAgenciaAutoBanco() {
        ArrayList<String> agencias = new ArrayList();
        
        for (AgenciaBancaria agencia : array) {
            if (agencia != null)  {
                if (agencia.getAuto() != 0) {
                    agencias.add(agencia.getNombre());
                }
            }
        }
        
        return agencias;    
    }
    
    
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
    
    public AgenciaBancaria buscarAgenciaUnica(String nombre){
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (nombre.equalsIgnoreCase(array[i].getNombre())) {
                    return array[i];
                }
            }
        }
        return null;
    }
    
    
    public ArrayList<String> buscarCajasAgencia(int idAgencia){
        ArrayList<String> noCajas = new ArrayList(); 
        AgenciaBancaria a;
        for (AgenciaBancaria d : array) {
            if (d !=null) {
                if (d.getId() == idAgencia) {
                    if (d.getAuto() != 0) {
                        for (int i = 0; i < d.getId(); i++) {
                            noCajas.add(String.valueOf(i));
                        }
                    }
                }
            }
        }
        
        return noCajas;
    }
    
    
    public AgenciaBancaria[] obtenerAgencias(){
        return this.array;
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
