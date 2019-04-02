/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
import beans.CuentaMonetariaCliente;
import beans.TarjetaCredito;
import controller.AgenciaController;
import controller.CuentasCliente;
import controller.PagoController;
import controller.TarjetasYPrestamosCliente;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Optional;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
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
import jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author Juan José Ramos
 */
public class UICompras {
    


    /*SINGLETON*/
    private static final UICompras instance = new UICompras();

    private UICompras() {
    }

    public static UICompras getUI() {
        return instance;
    }
    
    public void start(Stage primaryStage, Cliente cliente){
        VBox v = new VBox();
        v.setStyle("-fx-background-color: white");
        Scene scene = new Scene(v, 700, 700, Color.WHITE);
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text textTitle = new Text("COMPTAS CON TARJETA");
        textTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 1, 1);

        Label labelCombo = new Label("Numero de Tarjeta: ");
        gridPane.add(labelCombo, 1, 3);
        
        
        /* BUSCA LAS TARJETAS DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        ObservableList tarjetas = FXCollections.observableArrayList(TarjetasYPrestamosCliente.getInstancia().getArrayTarjetaClienteEspecifico(cliente.getId()));

        ComboBox comboPago = new ComboBox();
        comboPago.getItems().addAll(tarjetas);
        comboPago.setPrefSize(350, 15);
        gridPane.add(comboPago, 2, 3);

        Label labelMontoT = new Label("Credito: ");
        gridPane.add(labelMontoT, 1, 4);

        TextField textFieldMontoT = new TextField();
        textFieldMontoT.setPrefSize(350, 15);
        gridPane.add(textFieldMontoT, 2, 4);

        
        comboPago.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                TarjetaCredito tarjeta = TarjetasYPrestamosCliente.getInstancia().buscarTarjetaCliente(Integer.parseInt(comboPago.getSelectionModel().getSelectedItem().toString()));
                textFieldMontoT.setText(String.valueOf(tarjeta.getDeuda()));                
            }
        });
        
        

        Label labelMonto = new Label("Monto: ");
        gridPane.add(labelMonto, 1, 5);

        TextField textFieldMonto = new TextField();
        textFieldMonto.setPrefSize(350, 15);
        gridPane.add(textFieldMonto, 2, 5);

        
        Label labelDescripcion = new Label("Articulo: ");
        gridPane.add(labelDescripcion, 1, 6);

        TextField textFieldArticulo = new TextField();
        textFieldArticulo.setPrefSize(350, 15);
        gridPane.add(textFieldArticulo, 2, 6);
        
        
        Label labelAgencia = new Label("Agencia Bancaria: ");
        gridPane.add(labelAgencia, 1, 7);

        ComboBox comboAgencia = new ComboBox();
        /* BUSCA LAS AGENCIAS Y LOS METE EN UN COMBOBOX*/
        ObservableList agencias = FXCollections.observableArrayList(AgenciaController.getAgenciaController().getNombreAgencia());

        comboAgencia.getItems().addAll(agencias);
        comboAgencia.setPrefSize(350, 15);
        gridPane.add(comboAgencia, 2, 7);
        
        Button buttonAceptar = new Button("Aceptar");
        buttonAceptar.setDefaultButton(true);
        buttonAceptar.setId("btnVerdeV");
        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldMonto.getText().trim().length() != 0 && comboPago.getSelectionModel().getSelectedItem()!= null
                        && PagoController.getInstancia().esNumero(textFieldMonto.getText().trim())) {
                    
                    TarjetaCredito t = TarjetasYPrestamosCliente.getInstancia().buscarTarjetaCliente(Integer.parseInt(comboPago.getSelectionModel().getSelectedItem().toString()));
                    if (t != null) {
                        if (t.getCredito() >= Double.parseDouble(textFieldMonto.getText().trim()) ) {
                            
                            if (t.getCredito() >= (Double.parseDouble(textFieldMonto.getText().trim())  + t.getDeuda())) {
                                 PagoController.getInstancia().agregar(textFieldArticulo.getText(), Double.parseDouble(textFieldMonto.getText()), 
                                        "Tarjeta No." + comboPago.getSelectionModel().getSelectedItem().toString(), cliente,

                                        "", comboAgencia.getSelectionModel().getSelectedItem().toString());

                                        TarjetasYPrestamosCliente.getInstancia().agregarCompras(Integer.parseInt(comboPago.getSelectionModel().getSelectedItem().toString()), 
                                                                Double.parseDouble(textFieldMonto.getText().trim()), cliente.getId());

                                        getAlert("Compra realizada con exito");
                                        textFieldMonto.clear();
                                        textFieldArticulo.clear();
                            } else {
                            getAlert("La tarjeta no posee saldo suficiente para realizar la compra");
                        }
                            
                        } else {
                             getAlert("El total excede el limite de credito, no se puede proceder");
                        }
                        
                        
                    }
                    
                } else {
                    getAlert("No puede dejar en blanco o escribir letras donde en el monto del pago");
                }

            }
        });

        
        Button buttonCancelar = new Button("Cancelar");
        buttonCancelar.setDefaultButton(true);
        buttonCancelar.setId("btnRojoR");
        buttonCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIOperacionesCliente.getUI().start(primaryStage, cliente);
            }
        });
        HBox hboxButtons = new HBox(10);
        hboxButtons.getChildren().addAll(buttonAceptar, buttonCancelar);
        gridPane.add(hboxButtons, 1, 9);

        scene.getStylesheets().addAll("/resources/root.css");

        v.getChildren().addAll(getMenuBar(primaryStage, cliente), gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }
    
    private MenuBar getMenuBar(Stage primaryStage, Cliente cliente) {
        MenuBar menuBar = new MenuBar();

        javafx.scene.control.Menu menuArchivo = new javafx.scene.control.Menu("Opciones");

        MenuItem menuItemRegresar = new MenuItem("_Regresar");
        MenuItem menuItemSalir = new MenuItem("_Salir");

        menuItemSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });

        menuItemRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIOperacionesCliente.getUI().start(primaryStage, cliente);
            }
        });

        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);

        menuBar.getMenus().addAll(menuArchivo);
        return menuBar;
    }

    public void getAlert(String cadena) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Error!");
        alerta.setHeaderText(null);
        alerta.setContentText(cadena);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.showAndWait();
    }
}
