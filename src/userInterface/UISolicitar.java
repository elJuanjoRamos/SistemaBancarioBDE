/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
import controller.*;
import java.util.InputMismatchException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Juan José Ramos
 */
public class UISolicitar {
    /*SINGLETON*/
    private static final UISolicitar instance = new UISolicitar();

    private UISolicitar() {
    }

    public static UISolicitar getUI() {
        return instance;
    }
    
    public void start(Stage primaryStage, Cliente cliente) {
        VBox v = new VBox();
        v.setStyle("-fx-background-color: white");
        Scene scene = new Scene(v, 700, 700, Color.WHITE);
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        
        Text textTitle = new Text("SOLICITUDES");
        textTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        
        
        
        Label labelTarjeta = new Label("SOLICITUD DE TARJETA ");
        gridPane.add(labelTarjeta, 1, 2);

        Button buttonTarjeta = new Button("Generar Solicitud");
        buttonTarjeta.setDefaultButton(true);
        buttonTarjeta.setId("btnVerdeV");
        buttonTarjeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                    
                    
                SolicitudController.getSolicitudController().generarSolicitud(cliente.getId(), cliente, 0.0, 1);
                    getAlert("Solicitud generada con exito");

                
            }
        });
        
        gridPane.add(buttonTarjeta, 1, 3);
        
        
        
        Label labelPrestamo = new Label("SOLICITUD DE PRESTAMO ");
        gridPane.add(labelPrestamo, 1,4);

        TextField textMonto = new TextField();
        textMonto.setPromptText("Monto");
        gridPane.add(textMonto, 1,5);

        
        
        
        Button buttonPrestamo = new Button("Generar Solicitud");
        buttonPrestamo.setDefaultButton(true);
        buttonPrestamo.setId("btnRojoR");
        buttonPrestamo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (esNumero(textMonto.getText())) {
                    
                    
                    SolicitudController.getSolicitudController().generarSolicitud(cliente.getId(), cliente, Double.parseDouble(textMonto.getText()), 0);
                    getAlert("Solicitud generada con exito");

                } else {
                    getAlert("Solo puede instroducir valores numericos en el monto");
                }
            }
        });
        gridPane.add(buttonPrestamo, 1,6);

       
        
        
        Label labelCuentaA = new Label("SOLICITUD DE CUENTA AHORRO ");
        gridPane.add(labelCuentaA, 1,8);

        TextField textCuentaA = new TextField();
        textCuentaA.setPromptText("Monto");
        gridPane.add(textCuentaA, 1,9);

        
        
        
        Button buttonCuentaA = new Button("Generar Solicitud");
        buttonCuentaA.setDefaultButton(true);
        buttonCuentaA.setId("btnRojoR");
        buttonCuentaA.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (esNumero(textCuentaA.getText())) {
                    
                    
                    SolicitudController.getSolicitudController().generarSolicitud(cliente.getId(), cliente, Double.parseDouble(textCuentaA.getText()), 3);
                    getAlert("Solicitud generada con exito");

                } else {
                    getAlert("Solo puede instroducir valores numericos en el monto");
                }
            }
        });
        gridPane.add(buttonCuentaA, 1,10);

        
        
        
        
        
        
        
                
        Label labelCuentaM = new Label("SOLICITUD DE CUENTA MONETARIA ");
        gridPane.add(labelCuentaM, 1,11);

        TextField textCuentaM = new TextField();
        textCuentaM.setPromptText("Monto");
        gridPane.add(textCuentaM, 1,12);

        
        
        
        Button buttonCuentaN = new Button("Generar Solicitud");
        buttonCuentaN.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (esNumero(textCuentaM.getText())) {
                    
                    
                    SolicitudController.getSolicitudController().generarSolicitud(cliente.getId(), cliente, Double.parseDouble(textCuentaM.getText()), 2);
                    getAlert("Solicitud generada con exito");

                } else {
                    getAlert("Solo puede instroducir valores numericos en el monto");
                }
            }
        });
        gridPane.add(buttonCuentaN, 1,13);

        
        
        
        
        
        
        
         scene.getStylesheets().addAll("/resources/root.css");

        v.getChildren().addAll(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();
        
    }
    

     public void getAlert(String cadena) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alert");
        alerta.setHeaderText(null);
        alerta.setContentText(cadena);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.showAndWait();
    }
    public boolean esNumero(String cadena) {
        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }

        return resultado;
    }
}
