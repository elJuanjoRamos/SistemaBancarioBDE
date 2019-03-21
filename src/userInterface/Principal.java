/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.application.Application;

import javafx.stage.Stage;

import controller.*;

import beans.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
/**
 *
 * @author Juan José Ramos
 */
public class Principal extends Application {
    ImageView view = new ImageView();
    private HBox hBox;
    private HBox hBox2;
    private GridPane gridPane;
    private GridPane gridPane2;
    private HBox hBoxButtons;
    
    private Button buttonUser;
    private Button buttonLogin;
    

    
    @Override
    public void start(Stage primaryStage) {
       /*
        hBox = new HBox();
        hBox2 = new HBox(); 
        
        hBoxButtons = new HBox(10);
  
        
        buttonLogin = new Button("Modulo Admin");
        buttonLogin.setId("btnAzul");
        
        buttonUser = new Button("Modulo Transaccion ");
        buttonUser.setId("btnRojo");
        
        //UNO
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setMinSize(900, 650);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        
        
        hBoxButtons.getChildren().addAll(buttonLogin, buttonUser );
        
        
        gridPane.add(hBoxButtons, 1,90);
        
        hBox.getChildren().addAll(gridPane);
        
        
        //dos

        Image image = new Image("/resources/BID.png"); 
        
        gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(30, 30, 30, 30));
        gridPane2.setAlignment(Pos.CENTER);
        
        view.setImage(image);
        view.setFitHeight(475);
        view.setFitWidth(800);
        gridPane2.add(view, 0, 0);
        
        hBox2.getChildren().addAll(gridPane2);
        
        Group root = new Group();
        Scene scene = new Scene(root, 850,700);

        root.getChildren().addAll(hBox, hBox2);
        scene.getStylesheets().addAll("/resources/root.css");

        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AccessWindow.getAccessWindow().getGridPane(primaryStage);
            }
        });
        buttonUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UITransacciones.getUI().start(primaryStage);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();*/
      
        ClienteController.getClienteController().agregar("pedro", "dir1", "tel");
        ClienteController.getClienteController().agregar("raul", "dir2", "tel");
        ClienteController.getClienteController().agregar("jenny", "dir3", "tel");
        
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
        
        //CAJEROS
        CajeroController.getCajeroControler().agregar(153231.55, "Zona 1", "Disponible" );
        CajeroController.getCajeroControler().agregar(56456.01, "Centro Comercial Miraflores", "Disponible" );
        CajeroController.getCajeroControler().agregar(5456.21, "USAC", "No Disponible" );
        CajeroController.getCajeroControler().agregar(556.12, "Avenida Petapa", "No Disponible" );
        
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        
        
        /*Agregar Tarjetas a Clientes*/
        OperacionesClienteController.getInstancia().agregarTarjeta(dateFormat.format(d), 15320.215, 4545.5);
        OperacionesClienteController.getInstancia().agregarTarjetaCliente(0);
        
        /*OperacionesClienteController.getInstancia().agregarTarjeta(dateFormat.format(d), 15320.215, 4545.5);
        OperacionesClienteController.getInstancia().agregarTarjetaCliente(0);
        OperacionesClienteController.getInstancia().agregarTarjeta(dateFormat.format(d), 45654.456, 45498.6);
        OperacionesClienteController.getInstancia().agregarTarjetaCliente(0);*/
        
        
        
        
        
        
        /*Agregar Prestamos al cliente*/
        OperacionesClienteController.getInstancia().agregarPrestamo(d, 456465.365, 45454.3);
        
        OperacionesClienteController.getInstancia().agregarPrestamoCliente(0, 0);
        
        
        /*Agregar cuentas a cliente */
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(d, 4564654.6);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(d, 787897.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(0);
        
        
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(d, 42321.32);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(d, 83219321.0);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        
        
        CuentaAhorroCliente[] a = CuentasCliente.getCuentasCliente().getArrayCACliete(0);
        
        
        CuentaMonetariaCliente[] b = CuentasCliente.getCuentasCliente().getArrayCMCliete(0);
        
        
  
        /*PrestamoCliente[] a = OperacionesClienteController.getInstancia().getArrayPrestamoCliente(0); 
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i].getAbono());
            System.out.println(a[i].getFechaPrestamo());
            System.out.println(a[i].getMonto());
        }*/
        
        
        

        //UIOperacionesCliente.getUI().start(primaryStage, null);
        UISeleccionCliente.getUI().start(primaryStage);
        //AdminInterface.getAdminInterface().start(primaryStage);
       // AccessWindow.getAccessWindow().getGridPane(primaryStage);        


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
    
}
