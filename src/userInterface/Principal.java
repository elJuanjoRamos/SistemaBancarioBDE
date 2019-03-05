/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import beans.*;
import controller.ClienteController;
/**
 *
 * @author Juan José Ramos
 */
public class Principal extends Application {
    
    Cliente[] c = new Cliente[20];
    Cliente a = new Cliente();
    Cliente b = new Cliente();
    Cliente e = new Cliente();
    
    
    
    @Override
    public void start(Stage primaryStage) {
        
        agregar();
        AccessWindow.getAccessWindow().getGridPane(primaryStage);
            
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    public void agregar() {
        ClienteController.getClienteController().agregarCliente("a", "dir1", "tel");
        ClienteController.getClienteController().agregarCliente("s", "dir2", "tel");
     ClienteController.getClienteController().agregarCliente("c", "dir3", "tel");
     
     
       }
    
    
}
