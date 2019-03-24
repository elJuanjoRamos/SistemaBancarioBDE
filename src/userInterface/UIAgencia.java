/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

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
import controller.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;

import beans.*;

/**
 *
 * @author Juan José Ramos
 */
public class UIAgencia {

    /*SINGLETON*/
    private static final UIAgencia CRUDAgenciaBancaria = new UIAgencia();

    private UIAgencia() {
    }

    public static UIAgencia getAgencia() {
        return CRUDAgenciaBancaria;
    }
    /*----------------*/
    private HBox hBoxCRUD;
    private GridPane gridPane;
    private Text textTitle;
    private HBox hBoxBuscar;
    private TextField textFieldBuscar;
    private Button buttonBuscar;
    private HBox hBoxButtons;
    private Button buttonNuevo;
    private Button buttonModificar;
    private Button buttonEliminar;
    private Button buttonReestablecer;

    private TableColumn<AgenciaBancaria, Integer> tableColumnIdAgenciaBancaria;
    private TableColumn<AgenciaBancaria, String> tableColumnNombreAgenciaBancaria;
    private TableColumn<AgenciaBancaria, String> tableColumnDireccionAgenciaBancaria;
    private TableColumn<AgenciaBancaria, String> tableColumnTelefonoAgenciaBancaria;
    private TableColumn<AgenciaBancaria, Integer> tableColumnNoCajasAgenciaBancaria;
    private TableColumn<AgenciaBancaria, Integer> tableColumnNoEscritoriosAgenciaBancaria;
    private TableColumn<AgenciaBancaria, Double> tableColumnEfectivoAgenciaBancaria;

    private TableView<AgenciaBancaria> tableView;
    private ObservableList<AgenciaBancaria> observableList;

    public void restarthBoxCRUD() {
        hBoxCRUD.getChildren().clear();
        hBoxCRUD.getChildren().add(gridPane);
    }

    public HBox getViewAgencia() {
        hBoxCRUD = new HBox();
        hBoxButtons = new HBox(10);
        hBoxBuscar = new HBox(10);

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        textTitle = new Text("  AgenciaBancarias  ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);

        textFieldBuscar = new TextField();
        textFieldBuscar.setPromptText("Buscar AgenciaBancaria");

        buttonBuscar = new Button("Bucar");
        buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldBuscar.getText().length() != 0) {
                    actualizarTablabusqueda(textFieldBuscar.getText().trim());
                }
            }
        });

        buttonReestablecer = new Button("Reestablecer");
        buttonReestablecer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textFieldBuscar.clear();
                actualizarDatosTabla();
            }
        });
        hBoxBuscar.getChildren().addAll(textFieldBuscar, buttonBuscar, buttonReestablecer);
        gridPane.add(hBoxBuscar, 0, 1);

        buttonNuevo = new Button("Nuevo");
        buttonNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hBoxCRUD.getChildren().clear();
                hBoxCRUD.getChildren().addAll(gridPane, Animacion.getAnimatedGridPane().getAnimatedGridPane(CrearAgencia.getCrearAgencia().getGridPane()));
            }
        });

        buttonModificar = new Button("Modificar");
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    hBoxCRUD.getChildren().clear();
                    
                    hBoxCRUD.getChildren().addAll(gridPane, Animacion.getAnimatedGridPane().getAnimatedGridPane(ActualizarAgencia.getActualizarAgencia()
                            .getGridPane(tableView.getSelectionModel().getSelectedItem())));
                    tableView.getSelectionModel().clearSelection();
                    actualizarDatosTabla();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("No ha seleccionado ninguna Agencia para modificar");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();
                }

            }
        });

        buttonEliminar = new Button("Eliminar");
        buttonEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setTitle("Cofirmacion");
                    alert.setHeaderText("Seguro que desea eliminar?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        for (AgenciaBancaria AgenciaBancaria : tableView.getSelectionModel().getSelectedItems()) {
                            AgenciaController.getAgenciaController().borrar(AgenciaBancaria.getId());
                            tableView.getSelectionModel().clearSelection();
                        }
                        restarthBoxCRUD();
                        actualizarDatosTabla();
                    }

                } else {
                    Alert alert = new Alert(AlertType.WARNING);
                    alert.setTitle("Materialgo de Error");
                    alert.setHeaderText("No Se Selecciono un Elemento para Eliminar");
                    alert.showAndWait();
                }
            }
        });

        hBoxButtons.getChildren().addAll(buttonNuevo, buttonModificar, buttonEliminar);
        gridPane.add(hBoxButtons, 0, 4);

        tableColumnIdAgenciaBancaria = new TableColumn<>();
        tableColumnIdAgenciaBancaria.setText("ID");
        tableColumnIdAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnIdAgenciaBancaria.setMinWidth(40);

        tableColumnNombreAgenciaBancaria = new TableColumn<>();
        tableColumnNombreAgenciaBancaria.setText("Nombre");
        tableColumnNombreAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnNombreAgenciaBancaria.setMinWidth(150);

        tableColumnTelefonoAgenciaBancaria = new TableColumn<>();
        tableColumnTelefonoAgenciaBancaria.setText("Telefono");
        tableColumnTelefonoAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumnTelefonoAgenciaBancaria.setMinWidth(100);

        tableColumnDireccionAgenciaBancaria = new TableColumn<>();
        tableColumnDireccionAgenciaBancaria.setText("Direccion");
        tableColumnDireccionAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnDireccionAgenciaBancaria.setMinWidth(100);

        tableColumnNoCajasAgenciaBancaria = new TableColumn<>();
        tableColumnNoCajasAgenciaBancaria.setText("No Cajas");
        tableColumnNoCajasAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("noCajas"));
        tableColumnNoCajasAgenciaBancaria.setMinWidth(60);

        tableColumnNoEscritoriosAgenciaBancaria = new TableColumn<>();
        tableColumnNoEscritoriosAgenciaBancaria.setText("Escritorios SEalCl");
        tableColumnNoEscritoriosAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("escritorios"));
        tableColumnNoEscritoriosAgenciaBancaria.setMinWidth(60);

        tableColumnEfectivoAgenciaBancaria = new TableColumn<>();
        tableColumnEfectivoAgenciaBancaria.setText("Efectivo Q.00");
        tableColumnEfectivoAgenciaBancaria.setCellValueFactory(new PropertyValueFactory<>("efectivo"));
        tableColumnEfectivoAgenciaBancaria.setMinWidth(80);

        tableView = new TableView<>();
        tableView.setItems(getObservableList());

        tableView.getColumns().addAll(tableColumnIdAgenciaBancaria, tableColumnNombreAgenciaBancaria,
                tableColumnTelefonoAgenciaBancaria, tableColumnDireccionAgenciaBancaria,
                tableColumnNoCajasAgenciaBancaria, tableColumnNoEscritoriosAgenciaBancaria,
                tableColumnEfectivoAgenciaBancaria);
        tableView.setMinSize(730, 150);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    hBoxCRUD.getChildren().clear();
                }
            }
        });

        gridPane.add(tableView, 0, 7, 2, 1);

        hBoxCRUD.getChildren().add(gridPane);
        hBoxCRUD.setAlignment(Pos.CENTER_LEFT);
        hBoxCRUD.setMinSize(730, 600);
        return hBoxCRUD;
    }

    private ObservableList<AgenciaBancaria> getObservableList() {
        observableList = FXCollections.observableArrayList(AgenciaController.getAgenciaController().getArray());
        return observableList;
    }

    public void actualizarDatosTabla() {
        actualizarDatos();
        tableView.setItems(observableList);
    }

    public void actualizarDatos() {
        observableList.clear();
        observableList = FXCollections.observableArrayList(AgenciaController.getAgenciaController().getArray());

    }

    public void actualizarTablabusqueda(String nombre) {
        if (!AgenciaController.getAgenciaController().buscar(nombre).isEmpty()) {
            observableList = FXCollections.observableArrayList(AgenciaController.getAgenciaController().buscar(nombre));
            tableView.setItems(observableList);
        } else {
            actualizarDatosTabla();
        }
    }
}

class CrearAgencia {

    private static final CrearAgencia CrearAgencia = new CrearAgencia();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelDireccion;
    private TextField textFieldDireccion;
    private Label labelTelefono;
    private TextField textFieldTelefono;

    private Label labelcajas;
    private TextField textFieldcajas;

    private Label labelescritorio;
    private TextField textFieldescritorio;

    private Label labelefectivo;
    private TextField textFieldefectivo;

    private Button buttonAgregar;
    private Button buttonCerrar;

    private CrearAgencia() {
    }

    public static CrearAgencia getCrearAgencia() {
        return CrearAgencia;
    }

    public GridPane getGridPane() {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Agregar");
        textTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Nombre Agencia: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField();
        gridPane.add(textFieldNombre, 1, 3, 2, 1);

        labelDireccion = new Label("Direccion Agencia: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField();
        gridPane.add(textFieldDireccion, 1, 4, 2, 1);

        labelTelefono = new Label("Telefono Agencia: ");
        gridPane.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField();
        gridPane.add(textFieldTelefono, 1, 5, 2, 1);

        labelcajas = new Label("Cajas de la Agencia: ");
        gridPane.add(labelcajas, 0, 6);

        textFieldcajas = new TextField();
        gridPane.add(textFieldcajas, 1, 6, 2, 1);

        labelescritorio = new Label("Escitorios Servicio al Cliente: ");
        gridPane.add(labelescritorio, 0, 7);

        textFieldescritorio = new TextField();
        gridPane.add(textFieldescritorio, 1, 7, 2, 1);

        labelefectivo = new Label("Efectivo neto: ");
        gridPane.add(labelefectivo, 0, 8);

        textFieldefectivo = new TextField();
        gridPane.add(textFieldefectivo, 1, 8, 2, 1);

        buttonCerrar = new Button("Cerrar");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIAgencia.getAgencia().restarthBoxCRUD();
            }
        });

        buttonAgregar = new Button("Agregar");
        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textFieldNombre.getText().length() != 0 && textFieldDireccion.getText().length() != 0 && textFieldTelefono.getText().length() != 0
                        && textFieldcajas.getText().length() != 0 && textFieldescritorio.getText().length() != 0 && textFieldefectivo.getText().length() != 0) {

                    if (AgenciaController.getAgenciaController().esNumero(textFieldcajas.getText(), textFieldescritorio.getText(), textFieldefectivo.getText(), "0")) {

                        if (AgenciaController.getAgenciaController().buscarAgencia(textFieldNombre.getText())) {
                            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                            alerta.setTitle("Information!");
                            alerta.setHeaderText(null);
                            alerta.setContentText("Ya existe una agencia o agencia con autobanco asociada con ese nombre");
                            alerta.initStyle(StageStyle.UTILITY);
                            alerta.showAndWait();
                        } else {

                            AgenciaController.getAgenciaController().agregar(textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText(),
                                Integer.parseInt(textFieldcajas.getText()), Integer.parseInt(textFieldescritorio.getText()),0, Double.parseDouble(textFieldefectivo.getText()));
                            
                            
                            
                            
                            textFieldNombre.clear();
                            textFieldDireccion.clear();
                            textFieldTelefono.clear();
                            textFieldcajas.clear();
                            textFieldescritorio.clear();
                            textFieldefectivo.clear();
                            UIAgencia.getAgencia().actualizarDatosTabla();

                        }

                    } else {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Error!");
                        alerta.setHeaderText(null);
                        alerta.setContentText("No puede introducir letras donde van valores numericos");
                        alerta.initStyle(StageStyle.UTILITY);
                        alerta.showAndWait();
                    }
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Error!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("No puede dejar campos en blanco.");
                    alerta.initStyle(StageStyle.UTILITY);
                    alerta.showAndWait();

                }

            }
        });

        gridPane.add(buttonAgregar, 1, 9);
        gridPane.add(buttonCerrar, 2, 9);
        gridPane.setMinSize(200, 400);
        gridPane.getStyleClass().add("gridPane");

        return gridPane;
    }
}

class ActualizarAgencia {

    private static final ActualizarAgencia ActualizarAgencia = new ActualizarAgencia();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelDireccion;
    private TextField textFieldDireccion;
    private Label labelTelefono;
    private TextField textFieldTelefono;
    private Button buttonModificar;

    private Label labelcajas;
    private TextField textFieldcajas;

    private Label labelescritorio;
    private TextField textFieldescritorio;

    private Label labelefectivo;
    private TextField textFieldefectivo;

    private Button buttonAgregar;
    private Button buttonCerrar;

    private Alert alert = new Alert(AlertType.INFORMATION);

    private ActualizarAgencia() {
    }

    public static synchronized ActualizarAgencia getActualizarAgencia() {
        return ActualizarAgencia;
    }

    public GridPane getGridPane(AgenciaBancaria Agencia) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Actualizar Datos");
        textTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Nombre Agecia: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField(Agencia.getNombre());
        gridPane.add(textFieldNombre, 1, 3, 3, 1);

        labelDireccion = new Label("Direccion Agencia: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField(Agencia.getDireccion());
        gridPane.add(textFieldDireccion, 1, 4, 3, 1);

        labelTelefono = new Label("Telefono Agencia: ");
        gridPane.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField(Agencia.getTelefono());
        gridPane.add(textFieldTelefono, 1, 5, 3, 1);

        
        labelcajas = new Label("Cajas de la Agencia: ");
        gridPane.add(labelcajas, 0, 6);

        textFieldcajas = new TextField(String.valueOf(Agencia.getNoCajas()));
        gridPane.add(textFieldcajas, 1, 6, 3, 1);

        labelescritorio = new Label("Escitorios Servicio al Cliente: ");
        gridPane.add(labelescritorio, 0, 7);

        textFieldescritorio = new TextField(String.valueOf(Agencia.getEscritorios()));
        gridPane.add(textFieldescritorio, 1, 7, 3, 1);

        labelefectivo = new Label("Efectivo neto: ");
        gridPane.add(labelefectivo, 0, 8);

        textFieldefectivo = new TextField(String.valueOf(Agencia.getEfectivo()));
        gridPane.add(textFieldefectivo, 1, 8, 3, 1);

        
        
        buttonModificar = new Button("Modificar");
        buttonModificar.setDefaultButton(true);
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                if (textFieldNombre.getText().length() != 0 && textFieldDireccion.getText().length() != 0 && textFieldTelefono.getText().length() != 0
                        && textFieldcajas.getText().length() != 0 && textFieldescritorio.getText().length() != 0 && textFieldefectivo.getText().length() != 0) {

                    if (AgenciaController.getAgenciaController().esNumero(textFieldcajas.getText(), textFieldescritorio.getText(), textFieldefectivo.getText(), "0" )) {

                        if (AgenciaController.getAgenciaController().buscarAgencia(textFieldNombre.getText())) {
                            Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                            alerta.setTitle("Information!");
                            alerta.setHeaderText(null);
                            alerta.setContentText("Ya existe una agencia o agencia con autobanco asociada con ese nombre");
                            alerta.initStyle(StageStyle.UTILITY);
                            alerta.showAndWait();
                        } else {

                            AgenciaController.getAgenciaController().actualizar(Agencia.getId(), textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText(),
                                    Integer.parseInt(textFieldcajas.getText()), Integer.parseInt(textFieldescritorio.getText()), 0, Double.parseDouble(textFieldefectivo.getText()));
                            UIAgencia.getAgencia().actualizarDatosTabla();
                             UIAgencia.getAgencia().restarthBoxCRUD();
                        }

                    } else {
                        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Error!");
                        alerta.setHeaderText(null);
                        alerta.setContentText("No puede introducir letras donde van valores numericos");
                        alerta.initStyle(StageStyle.UTILITY);
                        alerta.showAndWait();
                    }
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Error!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("No puede dejar campos en blanco.");
                    alerta.initStyle(StageStyle.UTILITY);
                    alerta.showAndWait();

                }

            }

        });

        gridPane.add(buttonModificar, 1, 9);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIAgencia.getAgencia().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 2, 9);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
}
