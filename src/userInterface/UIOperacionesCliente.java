/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.*;
import controller.OperacionesClienteController;
import controller.PagoController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.text.Text;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;

/**
 *
 * @author Juan José Ramos
 */
public class UIOperacionesCliente {

    private static final UIOperacionesCliente instance = new UIOperacionesCliente();

    private UIOperacionesCliente() {
    }

    public static UIOperacionesCliente getUI() {
        return instance;
    }
    
    public void start(Stage primaryStage, Cliente cliente) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
        Scene scene = new Scene(vbox, 1500, 800, Color.WHITE);

        GridPane gridPane = new GridPane();
        HBox h1 = new HBox(10);

        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setGridLinesVisible(true);

        /*------IMAGEN DEL PROFILE-------------*/
        ImageView view = new ImageView("/resources/profile.jpeg");
        view.setFitHeight(250);
        view.setFitWidth(250);
        gridPane.add(view, 0, 0);

        /*--------DATOS DEL PROFILE------------*/
        HBox h = new HBox();

        GridPane grid2 = new GridPane();
        grid2.setVgap(10);
        grid2.setHgap(10);
        Text t = new Text("Datos del Cliente");
        t.setFont(Font.font("Montserrat", FontWeight.BOLD, 20));

        grid2.add(t, 0, 1, 3, 1);
        grid2.setGridLinesVisible(true);

        Label label = getLabel("Nombre:");
        Label label2 = getLabel("Juan fdsfdsfdsfdsfdsfdsdfsfsd");

        grid2.add(label, 0, 3);
        grid2.add(label2, 1, 3);

        Label label3 = getLabel("Nombre:");
        Label label4 = getLabel("Hola FDSFDSFDS");
        grid2.add(label3, 0, 4);
        grid2.add(label4, 1, 4);

        Label label5 = getLabel("Telefono:");
        Label label6 = getLabel("Hola FDSFDSFDS");
        grid2.add(label5, 0, 5);
        grid2.add(label6, 1, 5);

        Label label7 = getLabel("Cantidad de cuentas:");
        Label label8 = getLabel("Hola FDSFDSFDS");
        grid2.add(label7, 0, 6);
        grid2.add(label8, 1, 6);

        Label label9 = getLabel("Cantidad Tarjetas:");
        Label label10 = getLabel("Hola FDSFDSFDS");
        grid2.add(label9, 0, 7);
        grid2.add(label10, 1, 7);

        h.getChildren().addAll(grid2);

        gridPane.add(h, 0, 2);

        /*--------------OPERACIONES PRINCIPALES-------------*/
        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        
        Tab tab = new Tab();
        tab.setText("TARJETAS DE CREDITO");
        tab.setContent(ObtenerTarjetasCliente.getTarjetaCliente().getVistaTarjetas(cliente.getId()));
        tab.setClosable(false);
        

        
        Tab tab0 = new Tab();
        tab0.setText("PRESTAMOS");
        tab0.setContent(ObtenerPrestamoCliente.getPrestamoCliente().getVistaPrestamo(cliente.getId()));
        tab0.setClosable(false);
        
        Tab tab1 = new Tab();
        tab1.setText("PAGOS");
        tab1.setContent(ObtenerPagosCliente.getPagoCliente().getVistaPago(cliente.getId()));
        tab1.setClosable(false);
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        tabPane.getTabs().addAll(tab, tab0, tab1);
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
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public Label getLabel(String texto) {
        Label label = new Label(texto);

        return label;
    }

    private MenuBar getMenuBar(Stage primaryStage, Cliente cliente) {
        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("REGRESAR");
        Menu menuAgencia = new Menu("AGENCIA BANCARIA");

        MenuItem menuItemSalir = new MenuItem("_Salir");
        
        MenuItem menuItemRegresar = new MenuItem("_Regresar");
        
        MenuItem menuItemAgencia = new MenuItem("_Pago de servicios");
        
        menuItemRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Stage stage = new Stage();
                UISeleccionCliente.getUI().start(primaryStage);
            }
        });
        menuItemSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        menuItemAgencia.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIPagoServicios.getUI().start(primaryStage, cliente);
            }
        });
        
        
        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);
        menuAgencia.getItems().addAll(menuItemAgencia);
        
        menuBar.getMenus().addAll(menuArchivo, menuAgencia);
        return menuBar;
    }
}



class ObtenerTarjetasCliente {
    private static final ObtenerTarjetasCliente instancia = new ObtenerTarjetasCliente();
    private ObtenerTarjetasCliente() {
    }

    public static ObtenerTarjetasCliente getTarjetaCliente() {
        return instancia;
    }
    
    
    private TableColumn<TarjetaCliente, String> tableColumnTarjeta;
    private TableColumn<TarjetaCliente, String> tableColumnFecha;
    private TableColumn<TarjetaCliente, String> tableColumnCredito;
    private TableColumn<TarjetaCliente, String> tableColumnDeuda;

    private TableView<TarjetaCliente> tableView;
    private ObservableList<TarjetaCliente> observableList;

    
    /*----TABLA TARJETA CREDITO---------*/
    
    public HBox getVistaTarjetas(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Tarjetas del Cliente ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        tableColumnTarjeta = new TableColumn<>();
        tableColumnTarjeta.setText("Numero de Tarjeta");
        tableColumnTarjeta.setCellValueFactory(new PropertyValueFactory<>("numero"));
        tableColumnTarjeta.setMinWidth(200);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de vencimiento");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        tableColumnFecha.setMinWidth(200);

        
        
        tableColumnCredito = new TableColumn<>();
        tableColumnCredito.setText("Límite de crédito Q");
        tableColumnCredito.setCellValueFactory(new PropertyValueFactory<>("credito"));
        tableColumnCredito.setMinWidth(200);

        tableColumnDeuda = new TableColumn<>();
        tableColumnDeuda.setText("Monto adeudado Q");
        tableColumnDeuda.setCellValueFactory(new PropertyValueFactory<>("deuda"));
        tableColumnDeuda.setMinWidth(200);

        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnTarjeta, tableColumnFecha, tableColumnCredito, tableColumnDeuda);
        tableView.setMinSize(100, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(700, 600);
        return hBoxVista;
        
    }
    private ObservableList<TarjetaCliente> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(OperacionesClienteController.getInstancia().getArrayTarjetaCliente(idCliente));
        return observableList;
    }
}





class ObtenerPrestamoCliente {
    private static final ObtenerPrestamoCliente instancia = new ObtenerPrestamoCliente();
    private ObtenerPrestamoCliente() {
    }

    public static ObtenerPrestamoCliente getPrestamoCliente() {
        return instancia;
    }
    
    
    private TableColumn<PrestamoCliente, String> tableColumnNombre;
    private TableColumn<PrestamoCliente, String> tableColumnFecha;
    private TableColumn<PrestamoCliente, String> tableColumnCredito;
    private TableColumn<PrestamoCliente, String> tableColumnDeuda;
    private TableColumn<PrestamoCliente, String> tableColumnEstado;

    private TableView<PrestamoCliente> tableView;
    private ObservableList<PrestamoCliente> observableList;

    
    /*----TABLA PRESTAMOS---------*/
    
    public HBox getVistaPrestamo(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Prestamos del Cliente ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        tableColumnNombre = new TableColumn<>();
        tableColumnNombre.setText("ID");
        tableColumnNombre.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnNombre.setMinWidth(60);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha del Prestamo");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        tableColumnFecha.setMinWidth(200);

        
        
        tableColumnCredito = new TableColumn<>();
        tableColumnCredito.setText("Monto prestado Q");
        tableColumnCredito.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableColumnCredito.setMinWidth(200);

        tableColumnDeuda = new TableColumn<>();
        tableColumnDeuda.setText("Monto abonado Q");
        tableColumnDeuda.setCellValueFactory(new PropertyValueFactory<>("abono"));
        tableColumnDeuda.setMinWidth(200);

        tableColumnEstado = new TableColumn<>();
        tableColumnEstado.setText("Estado");
        tableColumnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableColumnEstado.setMinWidth(200);
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnNombre, tableColumnFecha, tableColumnCredito, tableColumnDeuda, tableColumnEstado);
        tableView.setMinSize(100, 300);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(700, 600);
        return hBoxVista;
        
    }
    private ObservableList<PrestamoCliente> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(OperacionesClienteController.getInstancia().getArrayPrestamoCliente(idCliente));
        return observableList;
    }


    
}

class ObtenerPagosCliente{
    private static final ObtenerPagosCliente instancia = new ObtenerPagosCliente();
    private ObtenerPagosCliente() {
    }

    public static ObtenerPagosCliente getPagoCliente() {
        return instancia;
    }
    
    private TableColumn<Pago, String> tableColumnId;
    private TableColumn<Pago, String> tableColumnFecha;
    private TableColumn<Pago, String> tableColumnServicio;
    private TableColumn<Pago, String> tableColumnTipoPago;
    private TableColumn<Pago, String> tableColumnMonto;

    private TableView<Pago> tableView;
    private ObservableList<Pago> observableList;

    public HBox getVistaPago(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Registro de Pagos ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("ID");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnId.setMinWidth(40);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha del Pago");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableColumnFecha.setMinWidth(150);

        
        
        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto Q");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableColumnMonto.setMinWidth(150);

        tableColumnTipoPago = new TableColumn<>();
        tableColumnTipoPago.setText("Tipo Pago");
        tableColumnTipoPago.setCellValueFactory(new PropertyValueFactory<>("tipoPago"));
        tableColumnTipoPago.setMinWidth(300);

        tableColumnServicio = new TableColumn<>();
        tableColumnServicio.setText("Servicio");
        tableColumnServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        tableColumnServicio.setMinWidth(90);
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnMonto, tableColumnTipoPago, tableColumnServicio);
        tableView.setMinSize(100, 300);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(700, 600);
        return hBoxVista;
        
    }
    private ObservableList<Pago> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(PagoController.getInstancia().getArrayPagosCliente(idCliente));
        return observableList;
    }

    
    
}