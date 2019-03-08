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
        
        
        AgenciaController.getAgenciaController().agregar("BAM", "dir1", "tel1", 5, 5, 332.997);
        AgenciaController.getAgenciaController().agregar("CRED", "dir2", "tel2", 15, 5, 15265.03);
        AgenciaController.getAgenciaController().agregar("BAN", "dir3", "tel3", 11, 5, 998.03);
        AgenciaController.getAgenciaController().agregar("BI", "dir4", "tel4", 9, 5, 50.03);
        AgenciaController.getAgenciaController().agregar("FIC", "dir5", "tel5", 7, 5, 37.03);
        
        
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
