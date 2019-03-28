/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
import controller.ClienteController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
public class UISeleccionCliente {
    /*--------INTANCIA----------*/
    private static final UISeleccionCliente instancia = new UISeleccionCliente();
    
    public static UISeleccionCliente getUI() {
        return instancia;
    }
    
    /*----------VARIABLES----------*/
    private TableColumn<Cliente, Integer> tableColumnIdCliente;
    private TableColumn<Cliente, String> tableColumnNombreCliente;
    private TableColumn<Cliente, String> tableColumnDireccionCliente;
    private TableColumn<Cliente, String> tableColumnTelefonoCliente;

    private TableView<Cliente> tableView;
    private ObservableList<Cliente> observableList;

    private UISeleccionCliente() {
            
        
    }

    /*------------------------------------*/
    public void start(Stage primaryStage) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        Group root = new Group();
        Scene scene = new Scene(root, 800, 600, Color.WHITE);

        
        HBox h = new HBox(10);
        HBox h2 = new HBox(10);
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        Text textTitle = new Text("  CLIENTES REGISTRADOS  ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));        
        gridPane.add(textTitle,0,0);

        
        TextField textFieldBuscar = new TextField();
        textFieldBuscar.setPromptText("Buscar cliente");
        
        Button buttonBuscar = new Button("Bucar");
        buttonBuscar.setId("btnAzulA");
        buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (textFieldBuscar.getText().length() != 0) {
                    actualizarTablabusqueda(textFieldBuscar.getText().trim());
                } 
            }
        });

        Button buttonReg = new Button("Reestablecer");
        buttonReg.setId("btnAzulA");
        buttonReg.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                       observableList.clear();
                        observableList = FXCollections.observableArrayList(ClienteController.getClienteController().getArrayCliete());
                        tableView.setItems(observableList);
 
            }
        });
        
        
        
        Button buttonAceptar = new Button("Aceptar");
        buttonAceptar.setId("btnVerdeV");
        buttonAceptar.setGraphic(new ImageView("/resources/5.png"));
        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                 if (tableView.getSelectionModel().getSelectedItem() != null) {
                     UIOperacionesCliente.getUI().start(primaryStage, tableView.getSelectionModel().getSelectedItem());
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("Seleccione un cliente para continuar");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();
                 }
            }
        });

        Button buttonCancelar = new Button("Cancelar");
        buttonCancelar.setId("btnRojoR");
        buttonCancelar.setGraphic(new ImageView("/resources/4.png"));
        buttonCancelar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIMenu.getUI().start(primaryStage);
            }
        });
        h.getChildren().addAll(textFieldBuscar, buttonBuscar, buttonReg);
        gridPane.add(h, 0, 4);
        
         
        h2.getChildren().addAll(buttonAceptar, buttonCancelar);
        gridPane.add(h2, 1, 4);
        
        
        
        /*SECCION */
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
        tableView.setMinSize(200, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        
        
        
        gridPane.add(tableView, 0, 7, 2, 1);
        
        root.getChildren().add(gridPane);
        scene.getStylesheets().addAll("/resources/root.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    private ObservableList<Cliente> getObservableList() {
        observableList = FXCollections.observableArrayList(ClienteController.getClienteController().getArrayCliete());
        return observableList;
    }
    
    public void actualizarTablabusqueda(String nombre) {
        if (ClienteController.getClienteController().buscar(nombre) != null) {
            observableList = FXCollections.observableArrayList(ClienteController.getClienteController().buscar(nombre));
            tableView.setItems(observableList);
        } else {
            observableList.clear();
            observableList = FXCollections.observableArrayList(ClienteController.getClienteController().getArrayCliete());
        
        }
    }
    


}
