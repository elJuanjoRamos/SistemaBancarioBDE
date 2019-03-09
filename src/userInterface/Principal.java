/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.application.Application;

import javafx.stage.Stage;

import controller.*;
/**
 *
 * @author Juan José Ramos
 */
public class Principal extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        ClienteController.getClienteController().agregar("1", "dir1", "tel");
        ClienteController.getClienteController().agregar("2", "dir2", "tel");
        ClienteController.getClienteController().agregar("3", "dir3", "tel");
        
        EmpleadoController.getEmpleadoController().agregar("juan", "dir1", "tel", "Call-Center");
        EmpleadoController.getEmpleadoController().agregar("luis", "dir2", "tel", "Agencia");
        EmpleadoController.getEmpleadoController().agregar("pedro", "dir3", "tel", "Autobanco");
        
        //AGENCIA
        AgenciaController.getAgenciaController().agregar("1", "DIR1", "TEL", 1, 1, 0, 50.450);
        AgenciaController.getAgenciaController().agregar("2", "DIR1", "TEL", 1, 1, 0, 50.450);
        AgenciaController.getAgenciaController().agregar("3", "DIR1", "TEL", 1, 1, 0, 50.450);
        AgenciaController.getAgenciaController().agregar("4", "DIR1", "TEL", 1, 1, 0, 50.450);
        
        
        
        
        
        
        //AGENCIAAUTOBANCOS
        AgenciaController.getAgenciaController().agregar("A", "dir1", "tel1", 5, 5, 1, 332.997);
        AgenciaController.getAgenciaController().agregar("B", "dir2", "tel2", 15, 5, 2, 15265.03);
        AgenciaController.getAgenciaController().agregar("C", "dir3", "tel3", 11, 5, 3, 998.03);
        AgenciaController.getAgenciaController().agregar("D", "dir4", "tel4", 9, 5, 4, 50.03);
        AgenciaController.getAgenciaController().agregar("E", "dir5", "tel5", 7, 5, 5, 37.03);
        
        
        //AccessWindow.getAccessWindow().getGridPane(primaryStage);
        AdminInterface.getAdminInterface().start(primaryStage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
    
}
