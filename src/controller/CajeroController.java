/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Cajero;
import java.util.ArrayList;
import java.util.InputMismatchException;

/**
 *
 * @author Juan José Ramos
 */
public class CajeroController {

    /*Variables*/
    Cajero[] cajero = new Cajero[100];
    private ArrayList<Cajero> arrayList =new ArrayList();
    
    
    
    /*SINGLETON*/
    private static CajeroController instancia;
    public static CajeroController getCajeroControler() {
        if (instancia == null) {
            instancia = new CajeroController();
        }
        return instancia;
    }
    /*----------*/
    
    private CajeroController(){
        arrayList = new ArrayList();
        arrayList.clear();
   }
    
    /*agregar*/
    public void agregar(Double efectivo, String ubicacion, String estado) {
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] == null) {
                cajero[i] = new Cajero(i, 0, efectivo, ubicacion, estado);

                break;
            }
        }
    }
    /*Eliminar*/
    public void borrar(int id) {
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i].getId() == id) {
                cajero[i] = null;
                break;
            }
        }
    }

    public void actualizar(int id, int transacciones, Double efectivo, String ubicacion, String estado) {
        for (int i = 0; i < cajero.length; i++) {
            Cajero c = cajero[id];
            c.setEfectivo(efectivo);
            c.setEstado(estado);
            c.setTransaccion(transacciones);
            c.setUbicacion(ubicacion);
        }
    }

    /*bucar*/
    public ArrayList<Cajero> buscar(String valor) {
        this.arrayList.clear();
        
        for (Cajero c : cajero) {
            if (c != null) {
                if (c.getUbicacion().toUpperCase().contains(valor.toUpperCase()) ||
                    c.getEstado().toUpperCase().contains(valor.toUpperCase())) {
                    arrayList.add(c);
                }
            }
        }
        /*Cajero[] c = new Cajero[1000];
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] != null) {
                if (cajero[i].) {
                    for (int j = 0; j < c.length; j++) {
                        if (c[j] == null) {
                            c[j] = cajero[i];
                            break;
                        }
                    }
                }
            }
        }
        for (Cajero ca : c) {
            if (ca != null) {
               arrayList.add(ca);
            }
        }*/
        return arrayList;
    }

    /*obtiene todos los cajeros*/
    public ArrayList<Cajero> getArray() {
        this.arrayList.clear();
        for (Cajero c : cajero) {
            if (c != null) {
                arrayList.add(c);
            }
        }
        
        return arrayList;
    }
    
    public Cajero[] obtenerCajeros(){
        return this.cajero;
    }
    
    
    /*OBTIENE TODAS LAS DIRECCIONES*/
    public ArrayList<String> getDireccion() {
        
        ArrayList<String> array = new ArrayList();
        
        for (Cajero c : cajero) {
            if (c != null) {
                if (c.getEstado().equals("Disponible")) {
                    array.add(c.getId() + "-" + c.getUbicacion());
                }
                
            }
        }
        return array;
    }


    public Cajero bucarCajeroUnico(String cadena){
        String[] parts = cadena.split("-");
        String id = parts[0];
        if (esNumero(id)) {
            for (int i = 0; i < cajero.length ; i++) {
            if (cajero[i] != null) {
                if (cajero[i].getId() == Integer.parseInt(id)) {
                    return cajero[i];
                }
            }
            }
        } else {
            return null;
        }
        
        
        return null;
    }

    public boolean esNumero(String cadena, String cadena2) {
        boolean resultado;

        try {
            Integer.parseInt(cadena);
            Double.parseDouble(cadena2);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }

        return resultado;
    }
    
    public int getCantidad(){
        int cantidad = 0;
        for (int i = 0; i < cajero.length; i++) {
            if (cajero[i] != null) {
                cantidad++;  
                        
            }
        }
        return cantidad;
    }

    public boolean esNumero(String cadena) {
        boolean resultado;
        
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }
        
        return resultado;
    }
}
