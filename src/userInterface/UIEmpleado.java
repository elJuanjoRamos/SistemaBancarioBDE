/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Empleado;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.StageStyle;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;
import javafx.scene.control.ButtonType;

import controller.*;
import javafx.scene.control.ComboBox;

/**
 *
 * @author Juan José Ramos
 */
public class UIEmpleado {

    private static final UIEmpleado UIEmpleado = new UIEmpleado();

    private UIEmpleado() {
    }

    public static UIEmpleado getUIEmpleado() {
        return UIEmpleado;
    }

    private HBox hBoxCRUD;
    private GridPane gridPane;
    private Text textTitle;
    private HBox hBoxBuscar;
    private TextField textFieldBuscar;
    private Button buttonBuscar;
    private Button buttonReestablecer;
    private HBox hBoxButtons;
    private Button buttonNuevo;
    private Button buttonModificar;
    private Button buttonEliminar;

    private TableColumn<Empleado, Integer> tableColumnIdEmpleado;
    private TableColumn<Empleado, String> tableColumnNombreEmpleado;
    private TableColumn<Empleado, String> tableColumnDireccionEmpleado;
    private TableColumn<Empleado, String> tableColumnTelefonoEmpleado;
    private TableColumn<Empleado, String> tableColumnPuestoEmpleado;

    private TableView<Empleado> tableView;
    private ObservableList<Empleado> observableList;

    public void restarthBoxCRUD() {
        hBoxCRUD.getChildren().clear();
        hBoxCRUD.getChildren().add(gridPane);
    }

    public HBox getVistaData() {
        hBoxCRUD = new HBox();
        hBoxButtons = new HBox(10);
        hBoxBuscar = new HBox(10);

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        textTitle = new Text("  Empleados  ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);

        textFieldBuscar = new TextField();
        textFieldBuscar.setPromptText("Buscar Empleado");
        
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
                hBoxCRUD.getChildren().addAll(gridPane, Animacion.getAnimatedGridPane().getAnimatedGridPane(CrearEmpleado.getCrearEmpleado().getGridPane()));
            }
        });

        buttonModificar = new Button("Modificar");
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    hBoxCRUD.getChildren().clear();
                    hBoxCRUD.getChildren().addAll(gridPane, Animacion.getAnimatedGridPane().getAnimatedGridPane(ActualizarEmpleado.getActualizarEmpleado()
                            .getGridPane(tableView.getSelectionModel().getSelectedItem())));
                    tableView.getSelectionModel().clearSelection();
                    actualizarDatosTabla();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("No ha seleccionado ningun Empleado para modificar");
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
                        for (Empleado Empleado : tableView.getSelectionModel().getSelectedItems()) {
                            EmpleadoController.getEmpleadoController().borrar(Empleado.getId());
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

        hBoxButtons.getChildren().addAll(buttonNuevo, buttonModificar,
                buttonEliminar);
        gridPane.add(hBoxButtons, 0, 2);

        tableColumnIdEmpleado = new TableColumn<>();
        tableColumnIdEmpleado.setText("ID");
        tableColumnIdEmpleado.setCellValueFactory(new PropertyValueFactory<>("id") );
        tableColumnIdEmpleado.setMinWidth(70);

        tableColumnNombreEmpleado = new TableColumn<>();
        tableColumnNombreEmpleado.setText("Nombre");
        tableColumnNombreEmpleado.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnNombreEmpleado.setMinWidth(200);

        tableColumnTelefonoEmpleado = new TableColumn<>();
        tableColumnTelefonoEmpleado.setText("Telefono");
        tableColumnTelefonoEmpleado.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumnTelefonoEmpleado.setMinWidth(200);

        tableColumnDireccionEmpleado = new TableColumn<>();
        tableColumnDireccionEmpleado.setText("Direccion");
        tableColumnDireccionEmpleado.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnDireccionEmpleado.setMinWidth(200);

        
        tableColumnPuestoEmpleado = new TableColumn<>();
        tableColumnPuestoEmpleado.setText("Departamento");
        tableColumnPuestoEmpleado.setCellValueFactory(new PropertyValueFactory<>("departamento"));
        tableColumnPuestoEmpleado.setMinWidth(200);

        tableView = new TableView<>();
        tableView.setItems(getObservableList());

        tableView.getColumns().addAll(tableColumnIdEmpleado, tableColumnNombreEmpleado, tableColumnTelefonoEmpleado, tableColumnDireccionEmpleado, tableColumnPuestoEmpleado);
        tableView.setMinSize(100, 300);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                    hBoxCRUD.getChildren().clear();
                }
            }
        });

        gridPane.add(tableView, 0, 6);

        hBoxCRUD.getChildren().add(gridPane);
        hBoxCRUD.setAlignment(Pos.CENTER_LEFT);
        hBoxCRUD.setMinSize(700, 600);
        return hBoxCRUD;
    }

    private ObservableList<Empleado> getObservableList() {
        observableList = FXCollections.observableArrayList(EmpleadoController.getEmpleadoController().getArray());
        return observableList;
    }

    public void actualizarDatosTabla() {
        actualizarDatos();
        tableView.setItems(observableList);
    }
    public void actualizarDatos() {
        observableList.clear();
        observableList = FXCollections.observableArrayList(EmpleadoController.getEmpleadoController().getArray());
        
    }

    public void actualizarTablabusqueda(String nombre) {
        if (EmpleadoController.getEmpleadoController().buscar(nombre) != null) {
            observableList = FXCollections.observableArrayList(EmpleadoController.getEmpleadoController().buscar(nombre));
            tableView.setItems(observableList);
        } else {
            actualizarDatosTabla();
        }
    }
}

class CrearEmpleado {

    private static final CrearEmpleado CrearEmpleado = new CrearEmpleado();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelDireccion;
    private TextField textFieldDireccion;
    private Label labelTelefono;
    private TextField textFieldTelefono;
    private Label labelDepartamento;
    private ComboBox comboDepartamento;
    private Button buttonAgregar;
    private Button buttonCerrar;

    private CrearEmpleado() {
    }

    public static CrearEmpleado getCrearEmpleado() {
        return CrearEmpleado;
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

        
        labelDepartamento = new Label("Departamento: ");
        gridPane.add(labelDepartamento, 0, 6);

        comboDepartamento = new ComboBox();
        comboDepartamento.getItems().addAll("Agencia","Auto Banco","Cajero","Call-Center");
        gridPane.add(comboDepartamento, 1, 6, 2, 1);

        
        buttonCerrar = new Button("Cerrar");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIEmpleado.getUIEmpleado().restarthBoxCRUD();
            }
        });

        buttonAgregar = new Button("Agregar");
        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textFieldNombre.getText().length() != 0 && textFieldDireccion.getText().length() != 0 && textFieldTelefono.getText().length() != 0 &&
                        comboDepartamento.getSelectionModel().getSelectedItem() != null) {
                    EmpleadoController.getEmpleadoController().agregar(textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText(), comboDepartamento.getSelectionModel().getSelectedItem().toString());
                    textFieldNombre.clear();
                    textFieldDireccion.clear();
                    textFieldTelefono.clear();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Error!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("No puede dejar campos en blanco.");
                    alerta.initStyle(StageStyle.UTILITY);
                    alerta.showAndWait();

                }
                UIEmpleado.getUIEmpleado().actualizarDatosTabla();

            }
        });

        gridPane.add(buttonAgregar, 1, 7);
        gridPane.add(buttonCerrar, 2, 7);
        gridPane.setMinSize(200, 400);
        gridPane.getStyleClass().add("gridPane");

        return gridPane;
    }
}

class ActualizarEmpleado {

    private static final ActualizarEmpleado ActualizarEmpleado = new ActualizarEmpleado();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelDireccion;
    private TextField textFieldDireccion;
    private Label labelTelefono;
    private TextField textFieldTelefono;
    private Button buttonModificar;
    private Button buttonCerrar;
    private Alert alert = new Alert(AlertType.INFORMATION);
    private Label labelDepartamento;
    private ComboBox comboDepartamento;

    private ActualizarEmpleado() {
        alert.setTitle("Informacion");
        alert.setHeaderText(null);
    }

    public static ActualizarEmpleado getActualizarEmpleado() {
        return ActualizarEmpleado;
    }

    public GridPane getGridPane(Empleado empleado) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Modificar");
        textTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Nombre: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField(empleado.getNombre());
        gridPane.add(textFieldNombre, 1, 3, 3, 1);

        labelDireccion = new Label("Direccion: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField(empleado.getDireccion());
        gridPane.add(textFieldDireccion, 1, 4, 3, 1);

        labelTelefono = new Label("Telefono: ");
        gridPane.add(labelTelefono, 0, 5);
        
        textFieldTelefono = new TextField(empleado.getTelefono());
        gridPane.add(textFieldTelefono, 1, 5, 3, 1);

        labelDepartamento = new Label("Departamento: ");
        gridPane.add(labelDepartamento, 0, 6);

        comboDepartamento = new ComboBox();
        comboDepartamento.getItems().addAll("Agencia","Auto Banco","Cajero","Call-Center");
        gridPane.add(comboDepartamento, 1, 6, 3, 1);

        buttonModificar = new Button("Modificar");
        buttonModificar.setDefaultButton(true);
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldNombre.getText().trim().length() != 0
                        && textFieldDireccion.getText().trim().length() != 0
                        && textFieldTelefono.getText().trim().length() != 0 
                        && comboDepartamento.getSelectionModel().getSelectedItem() != null) {
                    
                    EmpleadoController.getEmpleadoController().actualizar(empleado.getId(), textFieldNombre.getText(), 
                            textFieldDireccion.getText(), textFieldTelefono.getText(), comboDepartamento.getSelectionModel().getSelectedItem().toString());
                    UIEmpleado.getUIEmpleado().actualizarDatosTabla();
                    

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

        gridPane.add(buttonModificar, 0, 7);

        buttonCerrar = new Button("Cerrar");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIEmpleado.getUIEmpleado().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 1, 7);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
}
