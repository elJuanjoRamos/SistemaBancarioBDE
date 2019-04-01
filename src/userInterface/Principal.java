/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
import javafx.application.Application;

import javafx.stage.Stage;

import controller.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 *
 * @author Juan José Ramos
 */
public class Principal extends Application {
    
    
    @Override
    public void start(Stage primaryStage) throws IOException{
      
      
        ClienteController.getClienteController().agregar("Erick Peñate", "Jutapa, Guatemala", "12345678");
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
        AgenciaController.getAgenciaController().agregar("Agencia A", "DIR A", "TEL A", 1, 1, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("Agencia B", "DIR B", "TEL B", 8, 9, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("Agencia C", "DIR C", "TEL C", 3, 5, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("Agencia D", "DIR D", "TEL D", 4, 1, 0, 100000.00);
        AgenciaController.getAgenciaController().agregar("Agencia E", "DIR E", "TEL E", 2, 5, 0, 100000.00);
        
        
        //AGENCIAAUTOBANCOS
        AgenciaController.getAgenciaController().agregar("Agencia AutoBanco F", "DIR F", "TEL F", 5, 5, 1, 332.997);
        AgenciaController.getAgenciaController().agregar("Agencia AutoBanco G", "DIR G", "TEL G", 15, 5, 2, 15265.03);
        AgenciaController.getAgenciaController().agregar("Agencia AutoBanco H", "DIR H", "TEL H", 11, 5, 3, 998.03);
        AgenciaController.getAgenciaController().agregar("Agencia AutoBanco I", "DIR I", "TEL I", 9, 5, 4, 50.03);
        AgenciaController.getAgenciaController().agregar("Agencia AutoBanco J", "DIR J", "TEL J", 7, 5, 5, 37.03);
        
        
        /*EMPLEADOS*/
        EmpleadoController.getEmpleadoController().agregar("María Carmen Villela", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("María Rodas", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Carmen Armas", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Javier Perez", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Denis Perez", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Acevedo Flores", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Felisia Garcia", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Carlos Campos", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Carlos Marroquin", "Guatemala", "12345654", "Call-Center", "-","-");
        EmpleadoController.getEmpleadoController().agregar("Kevin Flores", "Guatemala", "12345654", "Call-Center", "-","-");
        
        
        
        
        
        EmpleadoController.getEmpleadoController().agregar("Pedro Campos", "Guatemala", "12345654", "Agencia", "Agencia A", "0");
        EmpleadoController.getEmpleadoController().agregar("Eduardo Marroquin", "Guatemala", "12345654", "Agencia","Agencia A", "0");
        EmpleadoController.getEmpleadoController().agregar("Amalia Flores", "Guatemala", "12345654", "Agencia","Agencia A", "0");
        
        
        EmpleadoController.getEmpleadoController().agregar("Julia Castellano", "Guatemala", "12345654", "Agencia","Agencia B", "1");
        EmpleadoController.getEmpleadoController().agregar("Arturo Najera", "Guatemala", "12345654", "Agencia", "Agencia B","1");
        EmpleadoController.getEmpleadoController().agregar("Marvin Rosa", "Guatemala", "12345654", "Agencia","Agencia B", "1");
        
        
        EmpleadoController.getEmpleadoController().agregar("Katherine Estrada", "Guatemala", "12345654", "Agencia", "Agencia C", "2");
        EmpleadoController.getEmpleadoController().agregar("Luis Ramos", "Guatemala", "12345654", "Agencia","Agencia C", "2");
        EmpleadoController.getEmpleadoController().agregar("Miriam Ramos", "Guatemala", "12345654", "Agencia", "Agencia C", "2");
        
        
        EmpleadoController.getEmpleadoController().agregar("Teresa Estrada", "Guatemala", "12345654", "Agencia","Agencia D", "3");
        EmpleadoController.getEmpleadoController().agregar("Maria Amalia", "Guatemala", "12345654", "Agencia","Agencia D", "3");
        EmpleadoController.getEmpleadoController().agregar("Donald Castro", "Guatemala", "12345654", "Agencia","Agencia D", "3");
        
        
        
        
        EmpleadoController.getEmpleadoController().agregar("Lis Campos", "Guatemala", "12345654", "Agencia","Agencia E", "4");
        EmpleadoController.getEmpleadoController().agregar("Daniela Marroquin", "Guatemala", "12345654", "Agencia","Agencia E", "4");
        EmpleadoController.getEmpleadoController().agregar("Teodoro Flores", "Guatemala", "12345654", "Agencia","Agencia E", "4");
        EmpleadoController.getEmpleadoController().agregar("Marco Castellano", "Guatemala", "12345654", "Agencia","Agencia E", "4");
        EmpleadoController.getEmpleadoController().agregar("Estuardo Arevalo", "Guatemala", "12345654", "Agencia","Agencia E", "4");
        
        
        
        
        EmpleadoController.getEmpleadoController().agregar("Erick Perez", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco F", "5");
        EmpleadoController.getEmpleadoController().agregar("Estuardo Garza", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco F", "5");
        EmpleadoController.getEmpleadoController().agregar("Carla Lepe", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco F", "5");
        
        EmpleadoController.getEmpleadoController().agregar("Jairo Marcos", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco G", "6");
        EmpleadoController.getEmpleadoController().agregar("Mishell Moran", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco G", "6");
        EmpleadoController.getEmpleadoController().agregar("Karelin Ramos", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco G", "6");
        
        EmpleadoController.getEmpleadoController().agregar("Rebeca Robles", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco H", "7");
        EmpleadoController.getEmpleadoController().agregar("Vanesa Montero", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco H", "7");
        EmpleadoController.getEmpleadoController().agregar("Brenda Alma", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco H", "7");
        
        EmpleadoController.getEmpleadoController().agregar("Erick Mansilla", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco I", "8");
        EmpleadoController.getEmpleadoController().agregar("Clauida Galindo", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco I", "8");
        EmpleadoController.getEmpleadoController().agregar("David Galindo", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco I", "8");
        
        EmpleadoController.getEmpleadoController().agregar("Hugo Elvira", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco J", "9");
        EmpleadoController.getEmpleadoController().agregar("Selvin Martinez", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco J", "9");
        EmpleadoController.getEmpleadoController().agregar("Jonathan perez", "Guatemala", "12345654", "Auto Banco","Agencia AutoBanco J", "9");
        
        
        
        
        
        
        
        
        
        //CAJEROS
        CajeroController.getCajeroControler().agregar(100000.00, "Zona 1", "Disponible" );
        CajeroController.getCajeroControler().agregar(100000.00, "Centro Comercial Miraflores", "Disponible" );
        CajeroController.getCajeroControler().agregar(100000.00, "USAC", "No Disponible" );
        CajeroController.getCajeroControler().agregar(100000.00, "Avenida Petapa", "No Disponible" );
        
         
        
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date d = new Date();
        
        /*Agregar Tarjetas a Clientes*/
        TarjetasYPrestamosCliente.getInstancia().agregarTarjeta(dateFormat.format(d), 15000.0, 7500.0);
        TarjetasYPrestamosCliente.getInstancia().agregarTarjetaCliente(0);
        
    
        
        
        
        /*Agregar Prestamos al cliente*/
        TarjetasYPrestamosCliente.getInstancia().agregarPrestamo(100.00, 0.0);
        TarjetasYPrestamosCliente.getInstancia().agregarPrestamoCliente(0);
        
        
        TarjetasYPrestamosCliente.getInstancia().agregarPrestamo(100000.00, 0.0);
        TarjetasYPrestamosCliente.getInstancia().agregarPrestamoCliente(5);
        
        

        
        
        //CUENTAS DE CLIENTES
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(550.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(700.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(9000.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(0);
        
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(1500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(1);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(5000.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(1);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(4530.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(2);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(7900.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(2);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(8000.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(3);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(432.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(3);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(4);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(780.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(4);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(1500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(4);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(6000.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(4);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(7000.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(4);
        
        
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(5);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(550.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(5);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(6);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(800.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(6);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(456.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(7);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(680.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(7);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(8);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(550.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(8);
        
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(500.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(9);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(4980.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(9);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorro(8987.0);
        CuentasCliente.getCuentasCliente().agregarCuentaAhorroCliente(9);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(550.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(9);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(5668.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(9);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetaria(350.00);
        CuentasCliente.getCuentasCliente().agregarCuentaMonetariaCliente(9);
        
        
        
        
        
        
        
        
        
        
        UIMenu.getUI().start(primaryStage);
     
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
    
}
