/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import beans.*;
import java.util.ArrayList;

/**
 *
 * @author Juan José Ramos
 */
public class ClienteController {
    
    /*VARIABLES*/
    private ArrayList<Cliente> arrayList =new ArrayList();
    private Cliente[] array = new Cliente[1000];
    
    
    /*SINGLETON*/
    private static final ClienteController ClienteController = new ClienteController();
    
    
    private ClienteController() {
        arrayList = new ArrayList<>();
    }

    private static ClienteController instance;
    public static ClienteController getClienteController(){
        if(instance == null){
            instance = new ClienteController();
        }
        return instance;
    }
    /*--------*/
    public void agregar(String nombre, String direccion, String telefono) {
            for (int i = 0; i < array.length; i++) {
                if (array[i] == null) {
                    array[i] = new Cliente(i, nombre, direccion, telefono);
                    break;
                }
            }
        
    }
    public void borrar(int id) {
        Cliente[] c = new Cliente[1100];
        for (int i = 0; i < array.length; i++) {
            if( i == id ) {
                array[i] = null;
                
                break;
            } 
        }
    }
    public void actualizar(int id, String nombre, String direccion, String telefono) {
        for (int i = 0; i < array.length; i++) {
            if (i == id) {
                Cliente c = array[i];
                c.setNombre(nombre);
                c.setDireccion(direccion);
                c.setTelefono(telefono);
            }
        }
    }
    

    public ArrayList<Cliente> buscar(String nombre){
        this.arrayList.clear();
        Cliente[] resultado = new Cliente[1000];
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getNombre().toUpperCase().contains(nombre.toUpperCase())||
                    array[i].getTelefono().toUpperCase().contains(nombre.toUpperCase()) ||
                    array[i].getDireccion().toUpperCase().contains(nombre.toUpperCase())) {
                    for (int j = 0; j < 1000; j++) {
                        if (resultado[j] == null) {
                            resultado[j] = array[i];
                            break;
                        }
                    }        
                }
            }
        }
        for (Cliente c : resultado) {
            if (c != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }   
    
    public Cliente buscar(int id){
        Cliente resultado = new Cliente();
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getId() ==  id) {
                    resultado = array[i];
                    break;        
                }
            }
        }
        return resultado;
    }
    
    
        public boolean buscarNombre(String nombre){
        
        for (int i = 0; i < array.length; i++) {
            if (array[i] != null) {
                if (nombre.equalsIgnoreCase(array[i].getNombre())) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public Cliente buscarClieteUnico(String nombre){
        
        for (int i = 0; i < 1000; i++) {
            if (array[i] != null) {
                if (array[i].getNombre().equals(nombre)) {
                    return array[i];
                }
            }
        }
        return null;
    }
    
    
    public ArrayList<Cliente> getArrayCliete() {
        this.arrayList.clear();
        
        for (Cliente c : array) {
            if (c != null) {
                arrayList.add(c);
            }
        }
        
        return arrayList;
    }
    
    public ArrayList<String> getNombresClietes() {
        ArrayList<String> nombres = new ArrayList();
        
        for (Cliente c : array) {
            if (c != null) {
                nombres.add(c.getNombre());
            }
        }
        
        return nombres;
    }
   
}
