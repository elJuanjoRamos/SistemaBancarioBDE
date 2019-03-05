/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;
import beans.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
/**
 *
 * @author Juan José Ramos
 */
public class ClienteController {
    private static final ClienteController ClienteController = new ClienteController();
    
    Cliente[] arrayCliente = new Cliente[1000];
    
    
    private ClienteController() {
    }

    public static ClienteController getClienteController() {
        return ClienteController;
    }
    
    public void agregarCliente(String nombre, String telefono, String direccion) {
        
        for (int i = 0; i < arrayCliente.length; i++) {
            if( arrayCliente[i] == null ) {
                arrayCliente[i] = new Cliente(i, nombre, telefono, direccion);
                break;
            }
        } 
    }
    
    public Cliente[] getArrayCliete() {
        return this.arrayCliente;
    }
    
   
}
