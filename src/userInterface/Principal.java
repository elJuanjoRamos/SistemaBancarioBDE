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
import java.io.IOException;
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
    public void start(Stage primaryStage) throws IOException{
      
      
        ClienteController.getClienteController().agregar("Juan José Ramos", "Jutapa, Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Anna Marison Castillo", "Jutiapa, Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Pedro Fernando Gonzalez" , "Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Jackeline Mendez", "Zona 18, Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Luis Fernando Garcia", "Villanueva, Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Didier Dominguez", "Villanueva, Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Lisseth Arevalo", "Jutiapa, Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Hector Maldonado", "Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Herbert Bustamante", "Guatemala", "12345678");
        ClienteController.getClienteController().agregar("Herson Belteron", "Escuintla, Guatemala", "12345678");
        
        
        //AGENCIA
        AgenciaController.getAgenciaController().agregar("1", "DIR1", "TEL", 1, 1, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("2", "DIR1", "TEL", 1, 1, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("3", "DIR1", "TEL", 1, 1, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("4", "DIR1", "TEL", 1, 1, 0, 100000.00);
        
        
        
        
        
        
        //AGENCIAAUTOBANCOS
        AgenciaController.getAgenciaController().agregar("A", "dir1", "tel1", 5, 5, 1, 332.997);
        AgenciaController.getAgenciaController().agregar("B", "dir2", "tel2", 15, 5, 2, 15265.03);
        AgenciaController.getAgenciaController().agregar("C", "dir3", "tel3", 11, 5, 3, 998.03);
        AgenciaController.getAgenciaController().agregar("D", "dir4", "tel4", 9, 5, 4, 50.03);
        AgenciaController.getAgenciaController().agregar("E", "dir5", "tel5", 7, 5, 5, 37.03);
        
        
        /*EMPLEADOS*/
        EmpleadoController.getEmpleadoController().agregar("María Carmen Villela", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("María Rodas", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Carmen Armas", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Javier Perez", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Denis Perez", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Acevedo Flores", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Felisia Garcia", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Carlos Campos", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Carlos Marroquin", "Guatemala", "12345654", "Call-Center", "-");
        EmpleadoController.getEmpleadoController().agregar("Kevin Flores", "Guatemala", "12345654", "Call-Center", "-");
        
        
        
        
 
        
        
        
        
        
        EmpleadoController.getEmpleadoController().agregar("Pedro Campos", "Guatemala", "12345654", "Agencia", "0");
        EmpleadoController.getEmpleadoController().agregar("Eduardo Marroquin", "Guatemala", "12345654", "Agencia", "0");
        EmpleadoController.getEmpleadoController().agregar("Amalia Flores", "Guatemala", "12345654", "Agencia", "0");
        
        
        EmpleadoController.getEmpleadoController().agregar("Julia Castellano", "Guatemala", "12345654", "Agencia", "1");
        EmpleadoController.getEmpleadoController().agregar("Arturo Najera", "Guatemala", "12345654", "Agencia", "1");
        EmpleadoController.getEmpleadoController().agregar("Marvin Rosa", "Guatemala", "12345654", "Agencia", "1");
        
        
        EmpleadoController.getEmpleadoController().agregar("Katherine Estrada", "Guatemala", "12345654", "Agencia", "2");
        EmpleadoController.getEmpleadoController().agregar("Luis Ramos", "Guatemala", "12345654", "Agencia", "2");
        EmpleadoController.getEmpleadoController().agregar("Miriam Ramos", "Guatemala", "12345654", "Agencia", "2");
        
        
        EmpleadoController.getEmpleadoController().agregar("Teresa Estrada", "Guatemala", "12345654", "Agencia", "3");
        EmpleadoController.getEmpleadoController().agregar("Maria Amalia", "Guatemala", "12345654", "Agencia", "3");
        EmpleadoController.getEmpleadoController().agregar("Donald Castro", "Guatemala", "12345654", "Agencia", "3");
        
        
        
        EmpleadoController.getEmpleadoController().agregar("Pamela Estrada", "Guatemala", "12345654", "Oficinas Centrales", "-");
        EmpleadoController.getEmpleadoController().agregar("Simon Vargas", "Guatemala", "12345654", "Oficinas Centrales", "-");
        
        
        EmpleadoController.getEmpleadoController().agregar("Lis Campos", "Guatemala", "12345654", "Agencia", "4");
        EmpleadoController.getEmpleadoController().agregar("Daniela Marroquin", "Guatemala", "12345654", "Agencia", "4");
        EmpleadoController.getEmpleadoController().agregar("Teodoro Flores", "Guatemala", "12345654", "Agencia", "4");
        
        
        
        
        
        
        
        
        //CAJEROS
        CajeroController.getCajeroControler().agregar(100000.00, "Zona 1", "Disponible" );
        CajeroController.getCajeroControler().agregar(100000.00, "Centro Comercial Miraflores", "Disponible" );
        CajeroController.getCajeroControler().agregar(100000.00, "USAC", "No Disponible" );
        CajeroController.getCajeroControler().agregar(100000.00, "Avenida Petapa", "No Disponible" );
        
         
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        
        /*Agregar Tarjetas a Clientes*/
        TarjetasYPrestamosCliente.getInstancia().agregarTarjeta(dateFormat.format(d), 15320.215, 4545.5);
        TarjetasYPrestamosCliente.getInstancia().agregarTarjetaCliente(0);
        
    
        
        
        
        /*Agregar Prestamos al cliente*/
        TarjetasYPrestamosCliente.getInstancia().agregarPrestamo(100.00, 0.0);
        TarjetasYPrestamosCliente.getInstancia().agregarPrestamoCliente(0);
        
        
        /*Agregar cuentas a cliente */
        
        //Clente 1
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(100.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(200.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(0);
        
        
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(150.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(200.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        
        
        
        //cliente 2
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(300.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(1);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(400.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(1);
        
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(350.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(1);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(450.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(1);
        
        
        //cliente 3
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(2);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(600.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(2);
        
        
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(550.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(2);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(650.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(2);
        
        
        //PDFController.getPDFController().crearPDFClientes();
//RETIROS
        
        
        
        
        //DepositoController.getInstancia().agregar(0, "8987898797", 46554.4, "Efectivo", ClienteController.getClienteController().buscar(0));
        
        
        
        //UIMenu.getUI().start(primaryStage);
        
        

        //UIOperacionesCliente.getUI().start(primaryStage, ClienteController.getClienteController().buscar(0));
        //UISeleccionCliente.getUI().start(primaryStage);
        AdminInterface.getAdminInterface().start(primaryStage);
       // AccessWindow.getAccessWindow().getGridPane(primaryStage);        


    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
    
}
