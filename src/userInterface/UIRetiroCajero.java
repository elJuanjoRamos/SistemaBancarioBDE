/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
import beans.CuentaAhorro;
import beans.CuentaMonetaria;
import controller.CajeroController;
import controller.CuentasCliente;
import controller.RetiroController;
import java.awt.Dimension;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
public class UIRetiroCajero {
    /*SINGLETON*/

    private static final JMetro.Style style = JMetro.Style.LIGHT;

    private UIRetiroCajero() {
    }

    private static UIRetiroCajero instance;

    public static UIRetiroCajero getUI() {
        if (instance == null) {
            instance = new UIRetiroCajero();
        }
        return instance;
    }

    public void start(Stage primaryStage, Cliente cliente) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
        Scene scene = new Scene(vbox, 700, 700, Color.WHITE);
        HBox hBoxVista = new HBox();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        Text textTitle = new Text("  CAJERO AUTOMATICO ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        Label labelCombo1 = new Label("Cuenta para consultar: ");
        gridPane.add(labelCombo1, 0, 2);

        ComboBox comboCuenta1 = new ComboBox();
        comboCuenta1.setPrefSize(350, 15);
        /* BUSCA LAS CUENTAS  DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        ObservableList cuentas1 = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayCuentasCliete(cliente.getId()));
        comboCuenta1.getItems().addAll(cuentas1);
        gridPane.add(comboCuenta1, 1, 2, 3, 1);
        
        
        Label labelMontoC = new Label("Monto de cuenta: ");
        gridPane.add(labelMontoC, 0, 3);

        TextField textFieldBuscar = new TextField();
        gridPane.add(textFieldBuscar, 1, 3,3, 1);
        
        
        Button buttonConsultar = new Button("Consultar saldo");
        buttonConsultar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (comboCuenta1.getSelectionModel().getSelectedItem() != null) {
                    CuentaAhorro ca = CuentasCliente.getCuentasCliente().buscarCuentaAhorros(Integer.parseInt(comboCuenta1.getSelectionModel().getSelectedItem().toString()));
                    CuentaMonetaria cm =CuentasCliente.getCuentasCliente().buscarCuentaMonetaria(Integer.parseInt(comboCuenta1.getSelectionModel().getSelectedItem().toString()));
                    if (ca != null ) {
                        textFieldBuscar.setText(String.valueOf(ca.getMontoInicial()));
                    } else if( cm != null) {
                        textFieldBuscar.setText(String.valueOf(cm.getMontoInicial()));
                        
                    }
                    
                    
                } 
            }
        });
        gridPane.add(buttonConsultar, 1, 4);
        
        

        Label labelAgencia = new Label("Cajero del retiro: ");
        labelAgencia.setId("labelTexto");
        gridPane.add(labelAgencia, 0, 9);

        ComboBox comboCajero = new ComboBox();
        /* BUSCA LOS CLIENTES Y LOS METE EN UN COMBOBOX*/
        ObservableList cajero = FXCollections.observableArrayList(CajeroController.getCajeroControler().getDireccion());

        comboCajero.getItems().addAll(cajero);
        comboCajero.setPrefSize(350, 15);
        gridPane.add(comboCajero, 1, 9,3, 1);
        

        Label labelCombo = new Label("Cuenta de retiro: ");
        gridPane.add(labelCombo, 0, 10);

        ComboBox comboCuenta = new ComboBox();
        /* BUSCA LAS CUENTAS  DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        ObservableList cuentas = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayCuentasCliete(cliente.getId()));

        comboCuenta.getItems().addAll(cuentas);
        comboCuenta.setPrefSize(350, 15);
        gridPane.add(comboCuenta, 1, 10,3, 1);

        Label labelMonto = new Label("Monto: ");
        gridPane.add(labelMonto, 0, 11);

        ComboBox comboMonto = new ComboBox();
        comboMonto.getItems().addAll("100", "200", "500", "1000", "5000");
        comboMonto.setPromptText("Cantidad de retiro");
        comboMonto.setPrefSize(350, 15);
        gridPane.add(comboMonto, 1, 11,3, 1);

        Button buttonAceptar = new Button("Aceptar");

        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (comboCajero.getSelectionModel().getSelectedItem() != null && comboMonto.getSelectionModel().getSelectedItem() != null
                        && comboCuenta.getSelectionModel().getSelectedItem() != null) {

                    if (CuentasCliente.getCuentasCliente().buscarCuentaAhorros(Integer.parseInt(comboCuenta.getSelectionModel().getSelectedItem().toString())) != null
                            && CajeroController.getCajeroControler().bucarCajeroUnico(comboCajero.getSelectionModel().getSelectedItem().toString()) != null) {

                        CuentaAhorro cuenta = CuentasCliente.getCuentasCliente().buscarCuentaAhorros(Integer.parseInt(comboCuenta.getSelectionModel().getSelectedItem().toString()));
                        if (cuenta.getMontoInicial() >= Double.parseDouble(comboMonto.getSelectionModel().getSelectedItem().toString())
                                && CajeroController.getCajeroControler().bucarCajeroUnico(comboCajero.getSelectionModel().getSelectedItem().toString()).getEfectivo()
                                >= Double.parseDouble(comboMonto.getSelectionModel().getSelectedItem().toString())) {

                            RetiroController.getRetiroController().agregar(comboCuenta.getSelectionModel().getSelectedItem().toString(),
                                    Double.parseDouble(comboMonto.getSelectionModel().getSelectedItem().toString()), cliente.getId(),
                                    comboCajero.getSelectionModel().getSelectedItem().toString());

                            getAlert("Retiro realizado con exito");

                        } else {
                            getAlert("El saldo de su cuenta o del cajero no es suficiente");
                        }

                    } else if (CuentasCliente.getCuentasCliente().buscarCuentaMonetaria(Integer.parseInt(comboCuenta.getSelectionModel().getSelectedItem().toString())) != null
                            && CajeroController.getCajeroControler().bucarCajeroUnico(comboCajero.getSelectionModel().getSelectedItem().toString()) != null) {

                        CuentaMonetaria cuenta = CuentasCliente.getCuentasCliente().buscarCuentaMonetaria(Integer.parseInt(comboCuenta.getSelectionModel().getSelectedItem().toString()));
                        if (cuenta.getMontoInicial() >= Double.parseDouble(comboMonto.getSelectionModel().getSelectedItem().toString())
                                && CajeroController.getCajeroControler().bucarCajeroUnico(comboCajero.getSelectionModel().getSelectedItem().toString()).getEfectivo()
                                >= Double.parseDouble(comboMonto.getSelectionModel().getSelectedItem().toString())) {

                            RetiroController.getRetiroController().agregar(comboCuenta.getSelectionModel().getSelectedItem().toString(),
                                    Double.parseDouble(comboMonto.getSelectionModel().getSelectedItem().toString()), cliente.getId(),
                                    comboCajero.getSelectionModel().getSelectedItem().toString());
                            getAlert("Retiro realizado con exito");

                        } else {
                            getAlert("El saldo de su cuenta no es suficiente");
                        }
                    }

                } else {
                    UIDeposito.getUI().getAlert("No puede dejar en blanco");
                }

            }
        });

        Button buttonCancelar = new Button("Cancelar");

        buttonCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIOperacionesCliente.getUI().start(primaryStage, cliente);

            }
        });

        gridPane.add(buttonAceptar, 1, 13);

        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);

        vbox.getChildren().addAll(getMenuBar(primaryStage, cliente), hBoxVista);
        scene.getStylesheets().addAll("/resources/root.css");
        //scene.getStylesheets().addAll("/resources/jmetro.css");
        //new JMetro(style).applyTheme(scene);
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
