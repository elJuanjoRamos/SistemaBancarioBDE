/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.application.Application;

import javafx.stage.Stage;

import beans.*;
import controller.ClienteController;
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
