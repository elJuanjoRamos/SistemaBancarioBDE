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
/**
 *
 * @author Juan José Ramos
 */
public class CRUDCliente {
    
    private static final CRUDCliente CRUDCliente = new CRUDCliente();
    
    
    
    private CRUDCliente() {
    }

    public static CRUDCliente getCRUDCliente() {
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
    
    
    private TableColumn<Cliente, Integer> tableColumnIdCliente;
    private TableColumn<Cliente, String> tableColumnNombreCliente;
    private TableColumn<Cliente, String> tableColumnDireccionCliente;
    private TableColumn<Cliente, String> tableColumnTelefonoCliente;
    
    private TableView<Cliente> tableView;
   
    public HBox getViewCliente() {
        hBoxCRUD = new HBox();
        
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        
        textTitle = new Text("  Clientes  ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        hBoxBuscar = new HBox(10);
        
        textFieldBuscar = new TextField();
        textFieldBuscar.setPromptText("Buscar cliente");
        textFieldBuscar.textProperty().addListener((newValue) -> {
            //updateTableViewItemsbusqueda(textFieldBuscar.getText().trim());
        });
        
        buttonBuscar = new Button("Buscar");
        buttonBuscar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               // updateTableViewItems();
            }
        });
        
        hBoxBuscar.getChildren().addAll(textFieldBuscar, buttonBuscar);
        gridPane.add(hBoxBuscar, 0, 1);
        
        hBoxButtons = new HBox(10);
        
        buttonNuevo = new Button("Nuevo");
            buttonNuevo.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    /*hBoxCRUD.getChildren().clear();
                    hBoxCRUD.getChildren().addAll(gridPane, Animation.getAnimation().
                            getGridPanAnimation(CreateProfesor.getCREATE_Profesor().getGridPane()));*/
            }
        });
        
        buttonModificar = new Button("Modificar");

        buttonEliminar = new Button("Eliminar");
        
        hBoxButtons.getChildren().addAll(buttonNuevo, buttonModificar, 
                buttonEliminar);
        gridPane.add(hBoxButtons, 0, 2);
        
        
        
        
        tableColumnIdCliente = new TableColumn<>();
        tableColumnIdCliente.setText("ID");
        tableColumnIdCliente.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnIdCliente.setMinWidth(70);
        
        tableColumnNombreCliente = new TableColumn<>();
        tableColumnNombreCliente.setText("Nombre");
        tableColumnNombreCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnNombreCliente.setMinWidth(100);
        
        
        tableColumnTelefonoCliente = new TableColumn<>();
        tableColumnTelefonoCliente.setText("Telefono");
        tableColumnTelefonoCliente.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumnTelefonoCliente.setMinWidth(100);
        
        tableColumnDireccionCliente = new TableColumn<>();
        tableColumnDireccionCliente.setText("Direccion");
        tableColumnDireccionCliente.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnDireccionCliente.setMinWidth(100);
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList());
        
        tableView.getColumns().addAll(tableColumnIdCliente, tableColumnNombreCliente, tableColumnTelefonoCliente, tableColumnDireccionCliente);
        tableView.setMinSize(350, 350);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        
        tableView.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override 
            public void handle(MouseEvent event) {
                if (event.isPrimaryButtonDown() && event.getClickCount() == 2) {
                /*hBoxCRUD.getChildren().clear();
                hBoxCRUD.getChildren().addAll(gridPane, Animation.getAnimation().getGridPanAnimation(VerProfesor.getVer_Profesor()
                        .getGridPane(tableView.getSelectionModel().getSelectedItem())));*/
                }
            }
        });
        
        gridPane.add(tableView, 0, 3, 2, 1);
        
        hBoxCRUD.getChildren().add(gridPane);
        hBoxCRUD.setAlignment(Pos.CENTER_LEFT);
        hBoxCRUD.setMinSize(630, 400);
        return hBoxCRUD;
    }
    private ObservableList<Cliente> getObservableList() {
        ObservableList<Cliente> observableList = FXCollections.observableArrayList(ClienteController.getClienteController().getArrayCliete());
        return observableList;
    }
    
}
