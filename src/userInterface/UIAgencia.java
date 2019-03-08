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
    private static final UIAgencia CRUDAgenciaBancaria = new UIAgencia();

    private UIAgencia() {
    }

    public static UIAgencia getAgencia() {
        return CRUDAgenciaBancaria;
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
                    alert.setHeaderText("No ha seleccionado ningun AgenciaBancaria para modificar");
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
                    alert.setTitle("Materialogo de Cofirmacion");
                    alert.setHeaderText("Segudo Que Desea Eliminar ");

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
        if (AgenciaController.getAgenciaController().buscar(nombre) != null) {
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
    private TextField textFieldTelefono;
    private Label labelTelefono;
    private Button buttonAgregar;
    private Button buttonCerrar;

    private CrearAgencia() {
        //updateObservableListGrado();
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

        labelNombre = new Label("Nombre: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField();
        gridPane.add(textFieldNombre, 1, 3, 2, 1);

        labelDireccion = new Label("Direccion: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField();
        gridPane.add(textFieldDireccion, 1, 4, 2, 1);

        labelTelefono = new Label("Telefono: ");
        gridPane.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField();
        gridPane.add(textFieldTelefono, 1, 5, 2, 1);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                UIAgencia.getCRUDAgencia().restarthBoxCRUD();
            }
        });

        buttonAgregar = new Button("Agregar");
        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

/*                if (textFieldNombre.getText().length() != 0 && textFieldDireccion.getText().length() != 0 && textFieldTelefono.getText().length() != 0) {
                    AgenciaController.getAgenciaController().agregar(textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText());
                    textFieldNombre.clear();
                    textFieldDireccion.clear();
                    textFieldTelefono.clear();

                    UIAgencia.getCRUDAgencia().actualizarDatosTabla();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Error!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("No puede dejar campos en blanco.");
                    alerta.initStyle(StageStyle.UTILITY);
                    alerta.showAndWait();

                }
                UIAgencia.getCRUDAgencia().actualizarDatosTabla();
*/
            }
        });

        gridPane.add(buttonAgregar, 1, 7);
        gridPane.add(buttonCerrar, 2, 7);
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
    private Alert alert = new Alert(AlertType.INFORMATION);

    private ActualizarAgencia() {
        alert.setTitle("Informacion");
        alert.setHeaderText(null);
    }

    public static synchronized ActualizarAgencia getActualizarAgencia() {
        return ActualizarAgencia;
    }

    public GridPane getGridPane(AgenciaBancaria Agencia) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Modificar");
        textTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Nombre: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField(Agencia.getNombre());
        gridPane.add(textFieldNombre, 1, 3, 3, 1);

        labelDireccion = new Label("Direccion: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField(Agencia.getDireccion());
        gridPane.add(textFieldDireccion, 1, 4, 3, 1);

        labelDireccion = new Label("Telefono: ");
        gridPane.add(labelDireccion, 0, 5);

        labelDireccion = new Label("Telefono: ");
        gridPane.add(labelDireccion, 0, 5);
        textFieldTelefono = new TextField(Agencia.getTelefono());
        gridPane.add(textFieldTelefono, 1, 5, 3, 1);

        buttonModificar = new Button("Modificar");
        buttonModificar.setDefaultButton(true);
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                /*if (textFieldNombre.getText().trim().length() != 0
                        && textFieldDireccion.getText().trim().length() != 0
                        && textFieldTelefono.getText().trim().length() != 0) {
                    AgenciaController.getAgenciaController().actualizar(Agencia.getId(), textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText());
                    UIAgencia.getCRUDAgencia().actualizarDatosTabla();


                } else {
                    
                    alert.setContentText("No puede dejar datos en blanco");
                    alert.showAndWait();
                }*/
            }
        });

        gridPane.add(buttonModificar, 0, 6);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // UIAgencia.getCRUDAgencia().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 1, 6);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
}
