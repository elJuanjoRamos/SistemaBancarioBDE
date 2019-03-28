/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.*;
import controller.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author Juan José Ramos
 */
public class UIDeposito {

    public static final JMetro.Style style = JMetro.Style.LIGHT;

    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

    /*SINGLETON*/
    private static final UIDeposito instance = new UIDeposito();

    private UIDeposito() {
    }

    public static UIDeposito getUI() {
        return instance;
    }
    /*-----------*/

    public void start(Stage primaryStage, Cliente cliente) {

        primaryStage.setTitle("DEPOSITOS DEL CLIENTE");
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
        //screenSize.getWidth(), screenSize.getHeight()
        Scene scene = new Scene(vbox, 700,700, Color.WHITE);

        GridPane gridPane = new GridPane();
        HBox h1 = new HBox(10);

        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setGridLinesVisible(false);


        /*--------------OPERACIONES PRINCIPALES-------------*/
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();

        Tab tab = new Tab();
        tab.setText("Mis Depositos             ");
        tab.setContent(MisDepositos.getInstancia().getVista(cliente));
        tab.setClosable(false);

        Tab tab0 = new Tab();
        tab0.setText("Depositos a otros clientes");
        tab0.setContent(MisDepositosOtroCliente.getInstancia().getVista(cliente));
        tab0.setClosable(false);

        tabPane.getTabs().addAll(tab, tab0);
        tabPane.setSide(Side.TOP);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        borderPane.setCenter(tabPane);

        gridPane.add(borderPane, 3, 0, 5, 5);

        /*-----no tocar-----------*/
        h1.getChildren().add(gridPane);
        h1.setAlignment(Pos.CENTER);
        h1.setMinSize(300, 300);

        vbox.getChildren().addAll(getMenuBar(primaryStage, cliente), h1);
        scene.getStylesheets().addAll("/resources/root.css");
        new JMetro(style).applyTheme(scene);

        primaryStage.setScene(scene);
        //primaryStage.setMaximized(true);
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

class MisDepositos {
    /*SINGLETON*/

    private static final MisDepositos instancia = new MisDepositos();

    private MisDepositos() {
    }

    public static MisDepositos getInstancia() {
        return instancia;
    }
    /*-------*/

    public HBox getVista(Cliente cliente) {
        HBox hBoxVista = new HBox();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        Label labelCombo = new Label("Cuenta a depositar: ");
        gridPane.add(labelCombo, 1, 0);

        ComboBox comboCuenta = new ComboBox();

        /* BUSCA LAS CUENTAS  DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        ObservableList cuentas = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayCuentasCliete(cliente.getId()));

        comboCuenta.getItems().addAll(cuentas);
        comboCuenta.setEditable(true);
        gridPane.add(comboCuenta, 2, 0);

        Label labelMonto = new Label("Monto: ");
        gridPane.add(labelMonto, 1, 3);

        TextField textFieldMonto = new TextField();
        gridPane.add(textFieldMonto, 2, 3);

        Label labelTipo = new Label("Tipo de Pago: ");
        gridPane.add(labelTipo, 1, 4);

        ComboBox comboTipo = new ComboBox();
        comboTipo.getItems().addAll("Efectivo", "Cheque");
        comboTipo.setPromptText("Tipo de pago");
        comboTipo.setEditable(true);
        gridPane.add(comboTipo, 2, 4);

        Label labelCuenta2 = new Label("Numero Cuenta monetaria: ");
        gridPane.add(labelCuenta2, 1, 6);

        ComboBox comboCuenta2 = new ComboBox();

        
        
        Label labelAgencia = new Label("Agencia Bancaria: ");
        gridPane.add(labelAgencia, 1, 7);
        
        ComboBox comboAgencia = new ComboBox();
          /* BUSCA LAS AGENCIAS Y LOS METE EN UN COMBOBOX*/
        ObservableList agencias = FXCollections.observableArrayList(AgenciaController.getAgenciaController().getNombreAgencia());

        comboAgencia.getItems().addAll(agencias);
        comboAgencia.setEditable(true);

        gridPane.add(comboAgencia, 2, 7);

        /* BUSCA LAS CUENTAS MONETARIAS DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        ObservableList cuentas2 = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayNoCMCliete(cliente.getId()));

        comboCuenta2.getItems().addAll(cuentas2);
        comboCuenta2.setEditable(true);
        gridPane.add(comboCuenta2, 2, 6);
        labelCuenta2.setVisible(false);
        comboCuenta2.setVisible(false);

        comboTipo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                if (getOpcion(comboTipo.getSelectionModel().getSelectedItem().toString())) {
                    labelCuenta2.setVisible(true);
                    comboCuenta2.setVisible(true);
                } else {
                    labelCuenta2.setVisible(false);
                    comboCuenta2.setVisible(false);
                }
            }
        });

        Button buttonAceptar = new Button("Aceptar");

        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldMonto.getText().trim().length() != 0 && DepositoController.getInstancia().esNumero(textFieldMonto.getText().trim()) && Double.parseDouble(textFieldMonto.getText().trim()) > 0) {
                    if (comboCuenta.getSelectionModel().getSelectedItem() != null && comboTipo.getSelectionModel().getSelectedItem() != null) {
                        if (comboTipo.getSelectionModel().getSelectedItem().toString().equals("Efectivo")) {

                            DepositoController.getInstancia().agregar(cliente.getId(), comboCuenta.getSelectionModel().getSelectedItem().toString(),
                                    Double.parseDouble(textFieldMonto.getText().trim()), comboTipo.getSelectionModel().getSelectedItem().toString(), cliente, "", 
                                    comboAgencia.getSelectionModel().getSelectedItem().toString());

                            UIDeposito.getUI().getAlert("Deposito realizado con exito");
                            textFieldMonto.clear();
                        } else if (comboTipo.getSelectionModel().getSelectedItem().toString().equals("Cheque")) {
                            if (comboCuenta2.getSelectionModel().getSelectedItem() != null) {
                                String cadena = comboTipo.getSelectionModel().getSelectedItem().toString() + " - Cuenta No. " + comboCuenta2.getSelectionModel().getSelectedItem().toString();

                                if (!comboCuenta.getSelectionModel().getSelectedItem().toString().equals(comboCuenta2.getSelectionModel().getSelectedItem().toString())) {
                                    
                                    CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(comboCuenta2.getSelectionModel().getSelectedItem().toString()));
                                    
                                    if (c.getMontoInicial() >= Double.parseDouble(textFieldMonto.getText().trim())) {
                                        DepositoController.getInstancia().agregar(cliente.getId(), comboCuenta.getSelectionModel().getSelectedItem().toString(),
                                            Double.parseDouble(textFieldMonto.getText().trim()), cadena, cliente, comboCuenta2.getSelectionModel().getSelectedItem().toString(), 
                                            comboAgencia.getSelectionModel().getSelectedItem().toString());
                                        textFieldMonto.clear();
                                         UIDeposito.getUI().getAlert("Deposito realizado con exito");
                                    } else {
                                         UIDeposito.getUI().getAlert("El saldo de la cuenta no es suficiente");
                                    }
                                    

                                } else {
                                    UIDeposito.getUI().getAlert("La cuenta para depositar no puede ser la misma de donde se va a generar el cheque");
                                }
                            } else {
                                UIDeposito.getUI().getAlert("Por favor seleccione un numero cuenta valido");
                            }
                        }

                    } else {
                        UIDeposito.getUI().getAlert("No puede dejar campos en blanco");
                    }

                } else {
                    UIDeposito.getUI().getAlert("No puede dejar en blanco, escribir letras o valores menores a 1 en el monto del deposito");
                }

            }
        });

        gridPane.add(buttonAceptar, 1, 9);

        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);

        return hBoxVista;
    }

    public Boolean getOpcion(String opcion) {
        if (opcion.trim().equals("Cheque")) {
            return true;
        }
        return false;
    }

}





class MisDepositosOtroCliente {
    /*SINGLETON*/

    private static final MisDepositosOtroCliente instancia = new MisDepositosOtroCliente();

    private MisDepositosOtroCliente() {
    }

    public static MisDepositosOtroCliente getInstancia() {
        return instancia;
    }
    /*-------*/

    public HBox getVista(Cliente cliente) {
        HBox hBoxVista = new HBox();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        
        
        Label labelCliente = new Label("Cliente para depositar: ");
        gridPane.add(labelCliente, 1, 0);

         ComboBox comboCliente = new ComboBox();
          /* BUSCA LOS CLIENTES Y LOS METE EN UN COMBOBOX*/
        ObservableList clientes = FXCollections.observableArrayList(ClienteController.getClienteController().getNombresClietes());

        comboCliente.getItems().addAll(clientes);
        comboCliente.setEditable(true);
        gridPane.add(comboCliente, 2, 0);

        
        
        Label labelCombo = new Label("Cuenta a depositar: ");
        gridPane.add(labelCombo, 1, 1);

        ComboBox comboCuenta = new ComboBox();
        comboCuenta.setEditable(true);
        gridPane.add(comboCuenta, 2, 1);

        
        labelCombo.setVisible(false);
        comboCuenta.setVisible(false);

        comboCliente.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                comboCuenta.setVisible(true);
                labelCombo.setVisible(true);
                /* BUSCA LAS CUENTAS  DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
                ObservableList cuentas = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayCuentasCliete(
                        ClienteController.getClienteController().buscarClieteUnico(comboCliente.getSelectionModel().getSelectedItem().toString()).getId()));

                comboCuenta.getItems().addAll(cuentas);

            }
        });
        
        
        Label labelMonto = new Label("Monto: ");
        gridPane.add(labelMonto, 1, 2);

        TextField textFieldMonto = new TextField();
        gridPane.add(textFieldMonto, 2, 2);

        Label labelTipo = new Label("Tipo de Pago: ");
        gridPane.add(labelTipo, 1, 4);

        ComboBox comboTipo = new ComboBox();
        comboTipo.getItems().addAll("Efectivo", "Cheque");
        comboTipo.setPromptText("Tipo de pago");
        comboTipo.setEditable(true);
        gridPane.add(comboTipo, 2, 4);

        Label labelCuenta2 = new Label("Numero Cuenta monetaria: ");
        gridPane.add(labelCuenta2, 1, 6);

        ComboBox comboCuenta2 = new ComboBox();

         Label labelAgencia = new Label("Agencia Bancaria: ");
        gridPane.add(labelAgencia, 1, 7);
        
        ComboBox comboAgencia = new ComboBox();
          /* BUSCA LAS AGENCIAS Y LOS METE EN UN COMBOBOX*/
        ObservableList agencias = FXCollections.observableArrayList(AgenciaController.getAgenciaController().getNombreAgencia());

        comboAgencia.getItems().addAll(agencias);
        comboAgencia.setEditable(true);

        gridPane.add(comboAgencia, 2, 7);
        /* BUSCA LAS CUENTAS MONETARIAS DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        ObservableList cuentas2 = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayNoCMCliete(cliente.getId()));

        comboCuenta2.getItems().addAll(cuentas2);
        comboCuenta2.setEditable(true);
        gridPane.add(comboCuenta2, 2, 6);
        labelCuenta2.setVisible(false);
        comboCuenta2.setVisible(false);

        comboTipo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                if (getOpcion(comboTipo.getSelectionModel().getSelectedItem().toString())) {
                    labelCuenta2.setVisible(true);
                    comboCuenta2.setVisible(true);
                } else {
                    labelCuenta2.setVisible(false);
                    comboCuenta2.setVisible(false);
                }
            }
        });

        Button buttonAceptar = new Button("Aceptar");

        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldMonto.getText().trim().length() != 0 && DepositoController.getInstancia().esNumero(textFieldMonto.getText().trim()) && Double.parseDouble(textFieldMonto.getText().trim()) > 0) {
                    if (comboCuenta.getSelectionModel().getSelectedItem() != null && comboTipo.getSelectionModel().getSelectedItem() != null) {
                        if (comboTipo.getSelectionModel().getSelectedItem().toString().equals("Efectivo")) {

                            DepositoController.getInstancia().agregar(cliente.getId(), comboCuenta.getSelectionModel().getSelectedItem().toString(),
                                    Double.parseDouble(textFieldMonto.getText().trim()), comboTipo.getSelectionModel().getSelectedItem().toString(), 
                                    
                                    ClienteController.getClienteController().buscarClieteUnico(comboCliente.getSelectionModel().getSelectedItem().toString()), "", 
                                    comboAgencia.getSelectionModel().getSelectedItem().toString());

                            UIDeposito.getUI().getAlert("Deposito realizado con exito");
                            textFieldMonto.clear();
                        } else if (comboTipo.getSelectionModel().getSelectedItem().toString().equals("Cheque")) {
                            if (comboCuenta2.getSelectionModel().getSelectedItem() != null) {
                                String cadena = comboTipo.getSelectionModel().getSelectedItem().toString() + " - Cuenta No. " + comboCuenta2.getSelectionModel().getSelectedItem().toString();

                                if (!comboCuenta.getSelectionModel().getSelectedItem().toString().equals(comboCuenta2.getSelectionModel().getSelectedItem().toString())) {
                                    
                                    CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(comboCuenta2.getSelectionModel().getSelectedItem().toString()));
                                  
                                    if (c.getMontoInicial() >= Double.parseDouble(textFieldMonto.getText().trim())) {
                                        DepositoController.getInstancia().agregar(cliente.getId(), comboCuenta.getSelectionModel().getSelectedItem().toString(),
                                            Double.parseDouble(textFieldMonto.getText().trim()), cadena, 
                                            
                                            ClienteController.getClienteController().buscarClieteUnico(comboCliente.getSelectionModel().getSelectedItem().toString()), 
                                            comboCuenta2.getSelectionModel().getSelectedItem().toString(), comboAgencia.getSelectionModel().getSelectedItem().toString());
                                            textFieldMonto.clear();
                                            UIDeposito.getUI().getAlert("Deposito realizado con exito");

                                    } else {
                                        UIDeposito.getUI().getAlert("El saldo de la cuenta no es sifuciente");
                                    }
                                      
                                    
                                } else {
                                    UIDeposito.getUI().getAlert("La cuenta para depositar no puede ser la misma de donde se va a generar el cheque");
                                }
                            } else {
                                UIDeposito.getUI().getAlert("Por favor seleccione un numero cuenta valido");
                            }
                        }

                    } else {
                        UIDeposito.getUI().getAlert("No puede dejar campos en blanco");
                    }

                } else {
                    UIDeposito.getUI().getAlert("No puede dejar en blanco, escribir letras o valores menores a 1 en el monto del deposito");
                }

            }
        });

        gridPane.add(buttonAceptar, 1, 9);

        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);

        return hBoxVista;
    }

    public Boolean getOpcion(String opcion) {
        if (opcion.trim().equals("Cheque")) {
            return true;
        }
        return false;
    }

}
