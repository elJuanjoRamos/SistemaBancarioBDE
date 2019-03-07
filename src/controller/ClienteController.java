/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import beans.*;

/**
 *
 * @author Juan José Ramos
 */
public class ClienteController {
    private static final ClienteController ClienteController = new ClienteController();
    
    private Cliente[] arrayCliente = new Cliente[1000];
    private Cliente[] arrayAux = new Cliente[1000];
    
    
    private ClienteController() {
    }

    private static ClienteController instance;
    public static ClienteController getClienteController(){
        if(instance == null){
            instance = new ClienteController();
        }
        return instance;
    }
    
    public void agregar(String nombre, String direccion, String telefono) {
        
        for (int i = 0; i < arrayCliente.length; i++) {
            if (arrayCliente[i] == null) {
                arrayCliente[i] = new Cliente(i, nombre, direccion, telefono);
                break;
            }
        }
        
    }
    public void mostrar() {
        for (int i = 0; i < arrayCliente.length; i++) {
            if (arrayCliente[i] != null) {
                System.out.println(arrayCliente[i].getNombre());
                System.out.println(arrayCliente[i].getDireccion());
                System.out.println(arrayCliente[i].getTelefono());
        
            }
        }
    }
    
    public void borrar(int id) {
        for (int i = 0; i < arrayCliente.length; i++) {
            if( i == id ) {
                arrayCliente[i] = null;
                if (arrayCliente[i + 1] != null ) {
                    arrayCliente[i] = arrayCliente[i + 1];
                    arrayCliente[i + 1 ] = null;
                    break;
                }
            } 
        }
    }
    public void actualizar(int id, String nombre, String direccion, String telefono) {
        for (int i = 0; i < arrayCliente.length; i++) {
            if (i == id) {
                Cliente c = arrayCliente[i];
                c.setNombre(nombre);
                c.setDireccion(direccion);
                c.setTelefono(telefono);
            }
        }
        mostrar();
    }
    
    public Cliente[] getBuscar(String nombre){
        System.out.println(nombre);
        Cliente[] resultado = new Cliente[1000];
        int a = 0;
        for (int i = 0; i < arrayCliente.length; i++) {
            for (int j = 0; j < resultado.length; j++) {
                if(arrayCliente[i].getNombre().toUpperCase().contains(nombre.toUpperCase())){
                    resultado[j] = arrayCliente[i];
                }
            }
        }
         return resultado;
     }
    public Cliente[] getArrayCliete() {
        return this.arrayCliente;
    }
    
    
    
   
}
