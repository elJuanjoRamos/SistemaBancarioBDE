/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import beans.Empleado;

/**
 *
 * @author Juan José Ramos
 */
public class EmpleadoController {
        private static final EmpleadoController EmpleadoController = new EmpleadoController();
    
    private Empleado[] array = new Empleado[1000];
    private Empleado[] arrayAux = new Empleado[1000];
    
    
    private EmpleadoController() {
    }

    private static EmpleadoController instance;
    public static EmpleadoController getEmpleadoController(){
        if(instance == null){
            instance = new EmpleadoController();
        }
        return instance;
    }
    
    public void agregar(String nombre, String direccion, String telefono, String departamento) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                array[i] = new Empleado(i, nombre, direccion, telefono, departamento);
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
    public void actualizar(int id, String nombre, String direccion, String telefono, String departamento) {
        for (int i = 0; i < array.length; i++) {
            if (i == id) {
                Empleado e = array[i];
                e.setNombre(nombre);
                e.setDireccion(direccion);
                e.setTelefono(telefono);
                e.setDepartamento(departamento);
            }
        }
    }
    
    public Empleado[] buscar(String nombre){
        Empleado[] resultado = new Empleado[1000];
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
    
    
    public Empleado[] getArray() {
        return this.array;
    }
    
    
    
}