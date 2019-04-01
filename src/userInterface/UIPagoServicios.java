/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.*;
import controller.*;
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
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.StageStyle;

/**
 *
 * @author Juan José Ramos
 */
public class UIPagoServicios {

    /*SINGLETON*/
    private static final UIPagoServicios instance = new UIPagoServicios();

    private UIPagoServicios() {
    }

    public static UIPagoServicios getUI() {
        return instance;
    }
    /*------------*/
    private ObservableList<String> cuentas;
        
    
    public void start(Stage primaryStage, Cliente cliente) {
        VBox v = new VBox();
        v.setStyle("-fx-background-color: white");
        Scene scene = new Scene(v, 700, 700, Color.WHITE);
        GridPane gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        Text textTitle = new Text("PAGO DE SERVICIOS");
        textTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 1, 1);

        Label labelCombo = new Label("Servicio de Pago: ");
        gridPane.add(labelCombo, 1, 3);
        ComboBox comboPago = new ComboBox();
        comboPago.setPrefSize(350, 15);
        
        comboPago.getItems().addAll("Agua", "Luz", "Telefono");
        comboPago.setPromptText("Servicio");
        
        gridPane.add(comboPago, 2, 3,2,1);

        Label labelMonto = new Label("Monto: ");
        gridPane.add(labelMonto, 1, 4);

        TextField textFieldMonto = new TextField();
        textFieldMonto.setPrefSize(350, 15);
        gridPane.add(textFieldMonto, 2, 4,2,1);

        Label labelTipo = new Label("Tipo de Pago: ");
        gridPane.add(labelTipo, 1, 5);

        ComboBox comboTipo = new ComboBox();
        comboTipo.getItems().addAll("Efectivo", "Cheque");
        comboTipo.setPrefSize(350, 15);
        
        comboTipo.setPromptText("Tipo de pago");

        Label labelCuenta = new Label("Numero de cuenta: ");
        gridPane.add(labelCuenta, 1, 6);

        Label labelAgencia = new Label("Agencia Bancaria: ");
        gridPane.add(labelAgencia, 1, 7,2,1);
        
        ComboBox comboAgencia = new ComboBox();
          /* BUSCA LAS AGENCIAS Y LOS METE EN UN COMBOBOX*/
        ObservableList agencias = FXCollections.observableArrayList(AgenciaController.getAgenciaController().getNombreAgencia());

        comboAgencia.getItems().addAll(agencias);
        comboAgencia.setPrefSize(350, 15);
        gridPane.add(comboAgencia, 2, 7,2,1);

        ComboBox comboCuenta = new ComboBox();

        /* BUSCA LAS CUENTAS MONETARIAS DEL CLIENTE Y LAS METE EN UN COMBOBOX*/
        
        comboCuenta.getItems().addAll(getCuentaMonetaria(cliente.getId()));
        gridPane.add(comboCuenta, 2, 6,2,1);
        comboCuenta.setPrefSize(350, 15);
        
        labelCuenta.setVisible(false);
        comboCuenta.setVisible(false);

        comboTipo.valueProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue ov, String t, String t1) {
                if (getOpcion(comboTipo.getSelectionModel().getSelectedItem().toString())) {
                    labelCuenta.setVisible(true);
                    comboCuenta.setVisible(true);
                } else {
                    labelCuenta.setVisible(false);
                    comboCuenta.setVisible(false);
                }
            }
        });
        gridPane.add(comboTipo, 2, 5,2,1);

        Button buttonAceptar = new Button("Aceptar");
        buttonAceptar.setDefaultButton(true);
        buttonAceptar.setId("btnVerdeV");
        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldMonto.getText().trim().length() != 0 && PagoController.getInstancia().esNumero(textFieldMonto.getText().trim())) {
                    if (comboPago.getSelectionModel().getSelectedItem() != null
                            && comboTipo.getSelectionModel().getSelectedItem().toString().equals("Efectivo")) {
                        
                        PagoController.getInstancia().agregar(comboPago.getSelectionModel().getSelectedItem().toString(),
                                Double.parseDouble(textFieldMonto.getText().trim()), comboTipo.getSelectionModel().getSelectedItem().toString(), cliente, "",
                                comboAgencia.getSelectionModel().getSelectedItem().toString());
                        
                        getAlert("Pago realizado con exito");
                        textFieldMonto.clear();
                        
                        
                    } else if (comboPago.getSelectionModel().getSelectedItem() != null
                            && comboTipo.getSelectionModel().getSelectedItem().toString().equals("Cheque")) {
                        
                        
                        
                        if (comboCuenta.getSelectionModel().getSelectedItem() != null ) {
                            if (textFieldMonto.getText().trim().length() != 0) {
                                CuentaMonetariaCliente c = CuentasCliente.getCuentasCliente().getArrayCMClieteUnica(Integer.parseInt(comboCuenta.getSelectionModel().getSelectedItem().toString()));
                            
                            if (c != null) {
                                if (c.getMontoInicial() >= Double.parseDouble(textFieldMonto.getText().trim()) && c.getCantidadCheques() > 0) {
                                        

                                   Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                                   alert.initStyle(StageStyle.DECORATED);
                                   alert.setTitle(" Cofirmacion");
                                   alert.setHeaderText("Desea eminir un Cheque de la cuenta " + comboCuenta.getSelectionModel().getSelectedItem().toString() + ""
                                           + " por el monto de Q" +  textFieldMonto.getText());

                                   Optional<ButtonType> result = alert.showAndWait();
                                   if (result.get() == ButtonType.OK) {
                                      
                                       int cantidadCheque = c.getCantidadCheques();
                                        c.setCantidadCheques(cantidadCheque -1);
                                        String cadena = comboTipo.getSelectionModel().getSelectedItem().toString() + " - Cuenta No. " + comboCuenta.getSelectionModel().getSelectedItem().toString();
                                        PagoController.getInstancia().agregar(comboPago.getSelectionModel().getSelectedItem().toString(), Double.parseDouble(textFieldMonto.getText().trim()), cadena, cliente,
                                                comboCuenta.getSelectionModel().getSelectedItem().toString(), comboAgencia.getSelectionModel().getSelectedItem().toString());
                                        textFieldMonto.clear();
                                        getAlert("Pago realizado con exito");
                                   }
                                    

                                    } else {
                                        getAlert("El numero de cuenta no posee saldo suficiente o se ha quedado sin cheques");
                                    }
                                } else {
                                    getAlert("Numero de cuenta no valido");
                                }
                            } else {
                                getAlert("Ingrese el monto para pagar");
                            }
                            
                        } else {
                            getAlert("Por favor seleccione un numero cuenta valido");
                        }
                    } else {
                        getAlert("No puede dejar campos en blanco");
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
        gridPane.add(hboxButtons, 1, 8);

        scene.getStylesheets().addAll("/resources/root.css");

        v.getChildren().addAll(getMenuBar(primaryStage, cliente), gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public Boolean getOpcion(String opcion) {
        if (opcion.trim().equals("Cheque")) {
            return true;
        }
        return false;
    }

    private MenuBar getMenuBar(Stage primaryStage, Cliente cliente) {
        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new javafx.scene.control.Menu("Opciones");

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
    
    public ObservableList<String> getCuentaMonetaria(int id){
        
        if (!CuentasCliente.getCuentasCliente().getArrayNoCMCliete(id).isEmpty()) {
           cuentas = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayNoCMCliete(id));
        }
        return cuentas;
    }
    
    
}
