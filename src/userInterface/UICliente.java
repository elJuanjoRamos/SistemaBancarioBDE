/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
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
import javafx.scene.image.ImageView;

/**
 *
 * @author Juan José Ramos
 */
public class UICliente {

    private static final UICliente CRUDCliente = new UICliente();

    private UICliente() {
    }

    public static UICliente getCRUDCliente() {
        return CRUDCliente;
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

    private TableColumn<Cliente, Integer> tableColumnIdCliente;
    private TableColumn<Cliente, String> tableColumnNombreCliente;
    private TableColumn<Cliente, String> tableColumnDireccionCliente;
    private TableColumn<Cliente, String> tableColumnTelefonoCliente;

    private TableView<Cliente> tableView;
    private ObservableList<Cliente> observableList;

    public void restarthBoxCRUD() {
        hBoxCRUD.getChildren().clear();
        hBoxCRUD.getChildren().add(gridPane);
    }

    public HBox getViewCliente() {
        hBoxCRUD = new HBox();
        hBoxButtons = new HBox(10);
        hBoxBuscar = new HBox(10);

        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));

        textTitle = new Text("  Clientes  ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);

        
        
        textFieldBuscar = new TextField();
        textFieldBuscar.setPromptText("Buscar cliente");
        
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
        gridPane.add(hBoxBuscar, 0, 1);
        

        buttonNuevo = new Button("Nuevo");
        buttonNuevo.setId("btnAzulA");
        buttonNuevo.setGraphic(new ImageView("/resources/1.png"));
        
        buttonNuevo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                hBoxCRUD.getChildren().clear();
                hBoxCRUD.getChildren().addAll(gridPane, Animacion.getAnimatedGridPane().getAnimatedGridPane(CrearCliente.getCrearCliente().getGridPane()));
            }
        });

        
        buttonModificar = new Button("Modificar");
        buttonModificar.setId("btnNaranja");
        buttonModificar.setGraphic(new ImageView("/resources/3.png"));
        
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    hBoxCRUD.getChildren().clear();
                    hBoxCRUD.getChildren().addAll(gridPane, Actualizar.getActualizar().getGridPane(tableView.getSelectionModel().getSelectedItem()));
                    tableView.getSelectionModel().clearSelection();
                    
                    actualizarDatosTabla();
                } else {
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("No ha seleccionado ningun cliente para modificar");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();
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
                        for (Cliente cliente : tableView.getSelectionModel().getSelectedItems()) {
                            ClienteController.getClienteController().borrar(cliente.getId());
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
        gridPane.add(hBoxButtons, 0, 4);

        tableColumnIdCliente = new TableColumn<>();
        tableColumnIdCliente.setText("ID");
        tableColumnIdCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnIdCliente.setMinWidth(70);

        tableColumnNombreCliente = new TableColumn<>();
        tableColumnNombreCliente.setText("Nombre");
        tableColumnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnNombreCliente.setMinWidth(200);

        tableColumnTelefonoCliente = new TableColumn<>();
        tableColumnTelefonoCliente.setText("Telefono");
        tableColumnTelefonoCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumnTelefonoCliente.setMinWidth(200);

        tableColumnDireccionCliente = new TableColumn<>();
        tableColumnDireccionCliente.setText("Direccion");
        tableColumnDireccionCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnDireccionCliente.setMinWidth(200);

        tableView = new TableView<>();
        tableView.setItems(getObservableList());

        tableView.getColumns().addAll(tableColumnIdCliente, tableColumnNombreCliente, tableColumnTelefonoCliente, tableColumnDireccionCliente);
        tableView.setMinSize(100, 250);
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
        hBoxCRUD.setMinSize(700, 600);
        return hBoxCRUD;
    }

    private ObservableList<Cliente> getObservableList() {
        observableList = FXCollections.observableArrayList(ClienteController.getClienteController().getArrayCliete());
        return observableList;
    }

    public void actualizarDatosTabla() {
        actualizarDatos();
        tableView.setItems(observableList);
    }
    public void actualizarDatos() {
        observableList.clear();
        observableList = FXCollections.observableArrayList(ClienteController.getClienteController().getArrayCliete());
        
    }

    
    
    public void actualizarTablabusqueda(String nombre) {
        
        
        if (ClienteController.getClienteController().buscar(nombre) != null) {
           
            observableList = FXCollections.observableArrayList(ClienteController.getClienteController().buscar(nombre));
            tableView.setItems(observableList);
        
        } else {
            actualizarDatosTabla();
        }
    }
    
    
    

}

class CrearCliente {

    private static final CrearCliente CrearCliente = new CrearCliente();
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

    private CrearCliente() {
    }

    public static CrearCliente getCrearCliente() {
        return CrearCliente;
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
        buttonCerrar.setId("btnRojoR");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UICliente.getCRUDCliente().restarthBoxCRUD();
            }
        });

        buttonAgregar = new Button("Agregar");
        buttonAgregar.setId("btnVerdeV");
        buttonAgregar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (textFieldNombre.getText().length() != 0 && textFieldDireccion.getText().length() != 0 && textFieldTelefono.getText().length() != 0) {
                    ClienteController.getClienteController().agregar(textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText());
                    textFieldNombre.clear();
                    textFieldDireccion.clear();
                    textFieldTelefono.clear();

                    UICliente.getCRUDCliente().actualizarDatosTabla();
                } else {
                    Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                    alerta.setTitle("Error!");
                    alerta.setHeaderText(null);
                    alerta.setContentText("No puede dejar campos en blanco.");
                    alerta.initStyle(StageStyle.UTILITY);
                    alerta.showAndWait();

                }
                UICliente.getCRUDCliente().actualizarDatosTabla();

            }
        });

        gridPane.add(buttonAgregar, 1, 7);
        gridPane.add(buttonCerrar, 2, 7);
        gridPane.setMinSize(200, 400);
        gridPane.getStyleClass().add("gridPane");

        return gridPane;
    }
}

class Actualizar {

    private static final Actualizar Actualizar = new Actualizar();
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

    private Actualizar() {
       
    }

    public static Actualizar getActualizar() {
        return Actualizar;
    }

    public GridPane getGridPane(Cliente cliente) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Modificar");
        textTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Nombre: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField(cliente.getNombre());
        gridPane.add(textFieldNombre, 1, 3, 3, 1);

        labelDireccion = new Label("Direccion: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField(cliente.getDireccion());
        gridPane.add(textFieldDireccion, 1, 4, 3, 1);
        
        
        labelTelefono = new Label("Telefono: ");
        gridPane.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField(cliente.getTelefono());
        gridPane.add(textFieldTelefono, 1, 5, 3, 1);

        buttonModificar = new Button("Modificar");
        buttonModificar.setId("btnNaranja");
        buttonModificar.setDefaultButton(true);
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldNombre.getText().trim().length() != 0
                        && textFieldDireccion.getText().trim().length() != 0
                        && textFieldTelefono.getText().trim().length() != 0) {
                    ClienteController.getClienteController().actualizar(cliente.getId(), textFieldNombre.getText(), textFieldDireccion.getText(), textFieldTelefono.getText());
                    UICliente.getCRUDCliente().actualizarDatosTabla();


                } else {
                    
                    alert.setContentText("No puede dejar datos en blanco");
                    alert.showAndWait();
                }
            }
        });

        gridPane.add(buttonModificar, 1, 6);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setId("btnRojoR");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UICliente.getCRUDCliente().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 2, 6);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
}
