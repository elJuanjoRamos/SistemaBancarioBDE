/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

/**
 *
 * @author Juan José Ramos
 */

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

import beans.Cajero;
import javafx.scene.control.ComboBox;
import javafx.scene.image.ImageView;

public class UICajero {
    private static final UICajero CRUDCajero = new UICajero();

    
    private UICajero() {
    }
    public static UICajero getCRUDCajero() {
        return CRUDCajero;
    }
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
    
    
    
    /************SECCION TABLAS***********/
    
    private TableColumn<Cajero, Integer> tableColumnId;
    private TableColumn<Cajero, String> tableColumnUbicacion;
    private TableColumn<Cajero, String> tableColumnEfectivo;
    private TableColumn<Cajero, String> tableColumnEstado;
    private TableColumn<Cajero, String> tableColumnTransaccion;
    
    private TableView<Cajero> tableView;
     
    private ObservableList<Cajero> observableList;

    /**************************************/
    
    
    
    public HBox getViewCajero() {
        hBoxCRUD = new HBox();
        hBoxButtons = new HBox(10);
        hBoxBuscar = new HBox(10);

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        textTitle = new Text("  Cajeros Automaticos  ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 35));
        gridPane.add(textTitle, 0, 2);

        textFieldBuscar = new TextField();
        textFieldBuscar.setPromptText("Buscar direccion");
        
        buttonBuscar = new Button("Bucar");
        buttonBuscar.setId("btnVerdeV");
        buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldBuscar.getText().length() != 0) {
                    actualizarTablabusqueda(textFieldBuscar.getText().trim());
                } 
            }
        });

        buttonReestablecer = new Button("Reestablecer");
        buttonReestablecer.setId("btnVerdeV");
        buttonReestablecer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                textFieldBuscar.clear();
                actualizarDatosTabla();
            }
        });
        hBoxBuscar.getChildren().addAll(textFieldBuscar, buttonBuscar, buttonReestablecer);
        gridPane.add(hBoxBuscar, 0, 6);
        

        buttonNuevo = new Button("Nuevo");
        buttonNuevo.setId("btnAzulA");
        buttonNuevo.setGraphic(new ImageView("/resources/1.png"));
        buttonNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hBoxCRUD.getChildren().clear();
                
                hBoxCRUD.getChildren().addAll(gridPane, Animacion.getAnimatedGridPane().getAnimatedGridPane(CrearCajero.getCrearCajero().getGridPane()));
            }
        });

        buttonModificar = new Button("Modificar");
        buttonModificar.setId("btnNaranja");
        buttonModificar.setGraphic(new ImageView("/resources/3.png"));
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    if (tableView.getSelectionModel().getSelectedItem() != null) {
                        hBoxCRUD.getChildren().clear();
                        hBoxCRUD.getChildren().addAll(gridPane, ActualizarCajero.getActualizarCajero()
                                .getGridPane(tableView.getSelectionModel().getSelectedItem()));
                        tableView.getSelectionModel().clearSelection();
                        actualizarDatosTabla();
                    } else {
                        Alert alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Information");
                        alert.setHeaderText("No ha seleccionado ningun cliente para modificar");
                        alert.initStyle(StageStyle.UTILITY);
                        alert.showAndWait();
                    }
                } catch (NullPointerException e) {
                    
                }

            }
        });

        buttonEliminar = new Button("Eliminar");
        buttonEliminar.setId("btnRojoR");
        buttonEliminar.setGraphic(new ImageView("/resources/2.png"));
        buttonEliminar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    Alert alert = new Alert(AlertType.CONFIRMATION);
                    alert.initStyle(StageStyle.DECORATED);
                    alert.setTitle("Materialogo de Cofirmacion");
                    alert.setHeaderText("Segudo Que Desea Eliminar ");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK) {
                        for (Cajero c : tableView.getSelectionModel().getSelectedItems()) {
                            CajeroController.getCajeroControler().borrar(c.getId());
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

        Button buttonReportes = new Button("Generar Reporte");
        buttonReportes.setGraphic(new ImageView("/resources/6.png"));
        
        buttonReportes.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ReporteController.getReporteController().CrearPDFCajeros();
            }
        });

        hBoxButtons.getChildren().addAll(buttonNuevo, buttonModificar,
                buttonEliminar, buttonReportes);
        gridPane.add(hBoxButtons, 0, 9);

        tableColumnId = new TableColumn<>();
        tableColumnId.setText("ID");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnId.setMinWidth(70);

        
        
        tableColumnUbicacion = new TableColumn<>();
        tableColumnUbicacion.setText("Ubicacion");
        tableColumnUbicacion.setCellValueFactory(new PropertyValueFactory<>("ubicacion"));
        tableColumnUbicacion.setMinWidth(250);

        tableColumnEfectivo = new TableColumn<>();
        tableColumnEfectivo.setText("Efectivo");
        tableColumnEfectivo.setCellValueFactory(new PropertyValueFactory<>("efectivo"));
        tableColumnEfectivo.setMinWidth(250);

        tableColumnEstado = new TableColumn<>();
        tableColumnEstado.setText("Estado");
        tableColumnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableColumnEstado.setMinWidth(200);

        
        tableColumnTransaccion = new TableColumn<>();
        tableColumnTransaccion.setText("Transacciones");
        tableColumnTransaccion.setCellValueFactory(new PropertyValueFactory<>("transaccion"));
        tableColumnTransaccion.setMinWidth(200);

        tableView = new TableView<>();
        tableView.setItems(getObservableList());
        tableView.getColumns().addAll(tableColumnId, tableColumnUbicacion, tableColumnEfectivo, tableColumnEstado, tableColumnTransaccion);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    hBoxCRUD.getChildren().clear();
                }
            }
        });

        gridPane.add(tableView, 0, 11);
        gridPane.setMaxWidth(1032);
        hBoxCRUD.getChildren().add(gridPane);
        hBoxCRUD.setAlignment(Pos.CENTER_LEFT);
        return hBoxCRUD;

    }
    
    
    public void restarthBoxCRUD() {
        hBoxCRUD.getChildren().clear();
        hBoxCRUD.getChildren().add(gridPane);
    }
    
        private ObservableList<Cajero> getObservableList() {
        observableList = FXCollections.observableArrayList(CajeroController.getCajeroControler().getArray());
        return observableList;
    }

    public void actualizarDatosTabla() {
        actualizarDatos();
        tableView.setItems(observableList);
    }
    public void actualizarDatos() {
        observableList.clear();
        observableList = FXCollections.observableArrayList(CajeroController.getCajeroControler().getArray());
        
    }

    public void actualizarTablabusqueda(String valor) {
        if (!CajeroController.getCajeroControler().buscar(valor).isEmpty()) {
            observableList = FXCollections.observableArrayList(CajeroController.getCajeroControler().buscar(valor));
            tableView.setItems(observableList);
        } else {
            actualizarDatosTabla();
        }
    }
    
}



class CrearCajero {
    
    private static final CrearCajero CrearCajero = new CrearCajero();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelUbicacion;
    private TextField textFieldUbicacion;
    private Label labelEfectivo;
    private TextField textFieldEfectivo;
    private ComboBox comboEstado;
    private Label labelCombo;
    private Button buttonAgregar;
    private Button buttonCerrar;

    private CrearCajero() {
    }

    public static CrearCajero getCrearCajero() {
        return CrearCajero;
    }
 
    
    public GridPane getGridPane() {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Agregar");
        textTitle.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelUbicacion = new Label("Ubicacion: ");
        gridPane.add(labelUbicacion, 0, 3);

        textFieldUbicacion = new TextField();
        gridPane.add(textFieldUbicacion, 1, 3, 2, 1);

        labelEfectivo = new Label("Efectivo: ");
        gridPane.add(labelEfectivo, 0, 4);

        textFieldEfectivo = new TextField();
        gridPane.add(textFieldEfectivo, 1, 4, 2, 1);

        labelCombo = new Label("Estado: ");
        gridPane.add(labelCombo, 0, 5);

        comboEstado = new ComboBox();
        comboEstado.getItems().addAll("Disponible", "No Disponible");
        gridPane.add(comboEstado, 1, 5, 2, 1);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setId("btnRojoR");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UICajero.getCRUDCajero().restarthBoxCRUD();
            }
        });

        buttonAgregar = new Button("Agregar");
        buttonAgregar.setId("btnVerdeV");
        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textFieldUbicacion.getText().length() != 0 && textFieldEfectivo.getText().length() != 0 && comboEstado.getSelectionModel().getSelectedItem() != null) {
                    if (CajeroController.getCajeroControler().esNumero("0", textFieldEfectivo.getText())) {
                          CajeroController.getCajeroControler().agregar(Double.parseDouble(textFieldEfectivo.getText()), textFieldUbicacion.getText(), comboEstado.getSelectionModel().getSelectedItem().toString());
                        textFieldEfectivo.clear();
                        textFieldUbicacion.clear();
                         UICajero.getCRUDCajero().actualizarDatosTabla();
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
                UICajero.getCRUDCajero().actualizarDatosTabla();

            }
        });
        
        gridPane.add(buttonAgregar, 1, 7);
        gridPane.add(buttonCerrar, 2, 7);
        gridPane.setMinSize(200, 400);
        gridPane.getStyleClass().add("gridPane");

        return gridPane;
    }
}


class ActualizarCajero {

    private static final ActualizarCajero ActualizarCajero = new ActualizarCajero();
    private GridPane gridPane;
     private Text textTitle;
    private Label labelUbicacion;
    private TextField textFieldUbicacion;
    private Label labelEfectivo;
    private TextField textFieldEfectivo;
     private Label labelT;
    private TextField textFieldT;
    private ComboBox comboEstado;
    private Label labelCombo;
    private Button buttonModificar;
    private Button buttonCerrar;
    private Alert alert = new Alert(AlertType.INFORMATION);

    private ActualizarCajero() {
        
    }

    public static synchronized ActualizarCajero getActualizarCajero() {
        return ActualizarCajero;
    }

    public GridPane getGridPane(Cajero c) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Modificar");
        textTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelUbicacion = new Label("Ubicacion: ");
        gridPane.add(labelUbicacion, 0, 3);

        textFieldUbicacion = new TextField(c.getUbicacion());
        gridPane.add(textFieldUbicacion, 1, 3, 3, 1);

        labelEfectivo = new Label("Efectivo: ");
        gridPane.add(labelEfectivo, 0, 4);

        textFieldEfectivo = new TextField(String.valueOf(c.getEfectivo()));
        gridPane.add(textFieldEfectivo, 1, 4, 3, 1);

        labelT = new Label("Transacciones: ");
        gridPane.add(labelT, 0, 5);
        
        textFieldT = new TextField(String.valueOf(c.getTransaccion()));
        gridPane.add(textFieldT, 1, 5, 3, 1);

        labelCombo = new Label("Estado: ");
        gridPane.add(labelCombo, 0, 6);

        comboEstado = new ComboBox();
        comboEstado.getItems().addAll("Disponible", "No Disponible");
        gridPane.add(comboEstado, 1, 6, 3, 1);
        
        buttonModificar = new Button("Modificar");
        buttonModificar.setDefaultButton(true);
        buttonModificar.setId("btnVerdeV");
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldUbicacion.getText().trim().length() != 0
                        && textFieldEfectivo.getText().trim().length() != 0
                        && textFieldT.getText().trim().length() != 0
                        && comboEstado.getSelectionModel().getSelectedItem() != null) {
                    
                    if (CajeroController.getCajeroControler().esNumero(textFieldT.getText(), textFieldEfectivo.getText())) {
                        CajeroController.getCajeroControler().actualizar(c.getId(), Integer.parseInt(textFieldT.getText()), 
                                Double.parseDouble(textFieldEfectivo.getText()), textFieldUbicacion.getText(), comboEstado.getSelectionModel().getSelectedItem().toString());
                        UICajero.getCRUDCajero().actualizarDatosTabla();

                        
                    } else {
                         Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                        alerta.setTitle("Error!");
                        alerta.setHeaderText(null);
                        alerta.setContentText("No puede introducir letras donde van valores numericos");
                        alerta.initStyle(StageStyle.UTILITY);
                        alerta.showAndWait();
                    }
               
                } else {
                    
                    alert.setContentText("No puede dejar datos en blanco");
                    alert.showAndWait();
                }
            }
        });

        gridPane.add(buttonModificar, 0, 7);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setId("btnRojoR");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UICajero.getCRUDCajero().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 1, 7);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
}