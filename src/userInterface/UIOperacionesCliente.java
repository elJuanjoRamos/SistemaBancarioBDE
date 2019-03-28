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
import jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author Juan José Ramos
 */
public class UIOperacionesCliente {
    public static final JMetro.Style style = JMetro.Style.LIGHT;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    
    
    /*SINGLETON*/
    private static final UIOperacionesCliente instance = new UIOperacionesCliente();

    private UIOperacionesCliente() {
    }

    public static UIOperacionesCliente getUI() {
        return instance;
    }
    ///////////////////
    
    public void start(Stage primaryStage, Cliente cliente) {
        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
   
        
        Scene scene = new Scene(vbox, screenSize.getWidth(), screenSize.getHeight(), Color.WHITE);

        GridPane gridPane = new GridPane();
        HBox h1 = new HBox(10);

        gridPane.setHgap(20);
        gridPane.setVgap(20);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setGridLinesVisible(false);

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
        grid2.setGridLinesVisible(false);

        Label label = getLabel("Nombre: ");
        Label label2 = getLabel(cliente.getNombre());

        grid2.add(label, 0, 3);
        grid2.add(label2, 1, 3);

        Label label3 = getLabel("Direccion: ");
        Label label4 = getLabel(cliente.getDireccion());
        grid2.add(label3, 0, 4);
        grid2.add(label4, 1, 4);

        Label label5 = getLabel("Telefono:");
        Label label6 = getLabel(cliente.getTelefono());
        grid2.add(label5, 0, 5);
        grid2.add(label6, 1, 5);

        /*Label label7 = getLabel("Cantidad de cuentas:");
        Label label8 = getLabel("Hola FDSFDSFDS");
        grid2.add(label7, 0, 6);
        grid2.add(label8, 1, 6);

        Label label9 = getLabel("Cantidad Tarjetas:");
        Label label10 = getLabel("Hola FDSFDSFDS");
        grid2.add(label9, 0, 7);
        grid2.add(label10, 1, 7);*/

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
        tab1.setContent(ObtenerPagosCliente.getPagoCliente().getVistaDeposito(cliente.getId()));
        tab1.setClosable(false);
        
        Tab tab2 = new Tab();
        tab2.setText("DEPOSITOS");
        tab2.setContent(ObtenerDepositosCliente.getObtenerDepositosCliente().getVistaDeposito(cliente.getId()));
        tab2.setClosable(false);
        
        Tab tab3 = new Tab();
        tab3.setText("RETIROS");
        tab3.setContent(ObtenerRetiroCliente.getObtenerRetiroCliente().getVista(cliente.getId()));
        tab3.setClosable(false);
        
        
        
        
        Tab tab4 = new Tab();
        tab4.setText("CUENTAS AHORRO");
        tab4.setContent(ObtenerCuentasAhorro.getObtenerCuentasAhorro().getVista(cliente.getId()));
        tab4.setClosable(false);
        
        Tab tab5 = new Tab();
        tab5.setText("CUENTAS MONETARIAS");
        tab5.setContent(ObtenerCuentasMonetaria.getObtenerCuentasMonetaria().getVista(cliente.getId()));
        tab5.setClosable(false);
        
        
        
        
             
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        tabPane.getTabs().addAll(tab, tab0, tab1, tab2, tab3, tab4, tab5);
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
        primaryStage.setMaximized(true);
        primaryStage.show();
    }

    
    public Label getLabel(String texto) {
        Label label = new Label(texto);

        return label;
    }

    private MenuBar getMenuBar(Stage primaryStage, Cliente cliente) {
        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("OPCIONES");
        Menu menuAgencia = new Menu("AGENCIA BANCARIA");
        Menu menuAgenciaAB = new Menu("AGENCIA AUTO BANCO");
        Menu menuCajero = new Menu("CAJERO");
        Menu menuCallCenter = new Menu("CallCenter");
        
        
        
        
        Menu menuPago = new Menu("_Área de cajas");
        Menu menuPagoAB = new Menu("_Área de cajas Auto Banco");
        Menu menuAtencionCliente = new Menu("_Área de atención al cliente");
        
        
        MenuItem menuItemSalir = new MenuItem("_Salir");
        MenuItem menuItemRegresar = new MenuItem("_Regresar");
        
        
        /*AGENCIA*/
        MenuItem menuItemPagoServicio = new MenuItem("_Pago de Servicios");
        MenuItem menuItemPagoTarjeta = new MenuItem("_Pago de Tarjetas");
        MenuItem menuItemPagoPrestamo = new MenuItem("_Pago de Prestamos");
        MenuItem menuItemDeposito = new MenuItem("_Deposito");
        MenuItem menuItemRetiro = new MenuItem("_Retiros");
        
        //AGENCIA AUTO BANCO/
        MenuItem menuItemPagoServicioAB = new MenuItem("_Pago de Servicios");
        MenuItem menuItemPagoTarjetaAB = new MenuItem("_Pago de Tarjetas");
        MenuItem menuItemPagoPrestamoAB = new MenuItem("_Pago de Prestamos");
        MenuItem menuItemDepositoAB = new MenuItem("_Deposito");
        MenuItem menuItemRetiroAB = new MenuItem("_Retiros");
        
        
        MenuItem menuItemTransferencia = new MenuItem("");
        MenuItem menuItemCajero = new MenuItem("_Ir a cajero");
        
        MenuItem menuItemAtencion = new MenuItem("_Ir a Atencion al cliente");
        
        
        
        menuItemRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIMenu.getUI().start(primaryStage);
            }
        });
        menuItemSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        menuItemPagoServicio.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIPagoServicios.getUI().start(primaryStage, cliente);
            }
        });
        
        menuItemPagoServicioAB.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIPagoServiciosAB.getUI().start(primaryStage, cliente);
            }
        });
        
        menuItemPagoPrestamo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIPagoPrestamo.getUI().start(primaryStage, cliente);
            }
        });
        
        menuItemPagoTarjeta.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIPagoTarjeta.getUI().start(primaryStage, cliente);
            }
        });
        
        menuItemDeposito.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIDeposito.getUI().start(primaryStage, cliente);
            }
          });
        
        menuItemRetiro.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIRetiro.getUI().start(primaryStage, cliente);
            }
          });
        
        menuItemCajero.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UIRetiroCajero.getUI().start(primaryStage, cliente);
            }
          });
        
        menuItemAtencion.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UISolicitar.getUI().start(new Stage(), cliente);
            }
          });
        
        
        
        
        menuPago.getItems().addAll(menuItemPagoServicio, menuItemPagoTarjeta, menuItemPagoPrestamo, menuItemDeposito, 
                                    menuItemRetiro);
    
        menuPagoAB.getItems().addAll(menuItemPagoServicioAB, menuItemPagoTarjetaAB, menuItemPagoPrestamoAB, menuItemDepositoAB, 
                                    menuItemRetiroAB);
    
        
        menuAtencionCliente.getItems().add(menuItemAtencion);
        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);
        menuAgencia.getItems().addAll(menuPago, menuAtencionCliente);
        menuAgenciaAB.getItems().addAll(menuPagoAB);
        
        menuCajero.getItems().add(menuItemCajero);
        
        
        menuBar.getMenus().addAll(menuArchivo, menuAgencia,menuAgenciaAB, menuCajero);
        return menuBar;
        
        
    }
    
    
}



class ObtenerTarjetasCliente {
    /*----SINGLETON------*/
    private static final ObtenerTarjetasCliente instancia = new ObtenerTarjetasCliente();
    private ObtenerTarjetasCliente() {
    }

    public static ObtenerTarjetasCliente getTarjetaCliente() {
        return instancia;
    }
    /*------------*/
    
    
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
        tableColumnTarjeta.setMinWidth(300);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de vencimiento");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaVencimiento"));
        tableColumnFecha.setMinWidth(350);

        
        
        tableColumnCredito = new TableColumn<>();
        tableColumnCredito.setText("Límite de crédito Q");
        tableColumnCredito.setCellValueFactory(new PropertyValueFactory<>("credito"));
        tableColumnCredito.setMinWidth(350);

        tableColumnDeuda = new TableColumn<>();
        tableColumnDeuda.setText("Monto adeudado Q");
        tableColumnDeuda.setCellValueFactory(new PropertyValueFactory<>("deuda"));
        tableColumnDeuda.setMinWidth(350);

        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnTarjeta, tableColumnFecha, tableColumnCredito, tableColumnDeuda);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        tableView.setMinSize(4000, 4000);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<TarjetaCliente> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(TarjetasYPrestamosCliente.getInstancia().getArrayTarjetaCliente(idCliente));
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
    
    
    private TableColumn<PrestamoCliente, String> tableColumnId;
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
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("ID");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tableColumnId.setMinWidth(60);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha del Prestamo");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaPrestamo"));
        tableColumnFecha.setMinWidth(400);

        
        
        tableColumnCredito = new TableColumn<>();
        tableColumnCredito.setText("Monto prestado Q");
        tableColumnCredito.setCellValueFactory(new PropertyValueFactory<>("deuda"));
        tableColumnCredito.setMinWidth(350);

        tableColumnDeuda = new TableColumn<>();
        tableColumnDeuda.setText("Monto abonado Q");
        tableColumnDeuda.setCellValueFactory(new PropertyValueFactory<>("abono"));
        tableColumnDeuda.setMinWidth(350);

        tableColumnEstado = new TableColumn<>();
        tableColumnEstado.setText("Estado");
        tableColumnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableColumnEstado.setMinWidth(200);
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnCredito, tableColumnDeuda, tableColumnEstado);
        tableView.setMinSize(400, 4000);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<PrestamoCliente> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(TarjetasYPrestamosCliente.getInstancia().getArrayPrestamoCliente(idCliente));
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
    private TableColumn<Pago, String> tableColumnAgencia;

    private TableView<Pago> tableView;
    private ObservableList<Pago> observableList;

    public HBox getVistaDeposito(int idCliente) {
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
        tableColumnId.setMinWidth(100);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha del Pago");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableColumnFecha.setMinWidth(250);

        
        
        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto Q");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableColumnMonto.setMinWidth(220);

        tableColumnTipoPago = new TableColumn<>();
        tableColumnTipoPago.setText("Tipo Pago");
        tableColumnTipoPago.setCellValueFactory(new PropertyValueFactory<>("tipoPago"));
        tableColumnTipoPago.setMinWidth(380);

        tableColumnServicio = new TableColumn<>();
        tableColumnServicio.setText("Servicio");
        tableColumnServicio.setCellValueFactory(new PropertyValueFactory<>("servicio"));
        tableColumnServicio.setMinWidth(400);
        
        tableColumnAgencia = new TableColumn<>();
        tableColumnAgencia.setText("Agencia");
        tableColumnAgencia.setCellValueFactory(new PropertyValueFactory<>("nombreAgencia"));
        tableColumnAgencia.setMinWidth(250);
        
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnMonto, tableColumnTipoPago, tableColumnServicio, tableColumnAgencia);
        tableView.setMinSize(4000, 4000);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<Pago> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(PagoController.getInstancia().getArrayPagosCliente(idCliente));
        return observableList;
    }

    
    
}



class ObtenerDepositosCliente {
    private static final ObtenerDepositosCliente instancia = new ObtenerDepositosCliente();
    private ObtenerDepositosCliente() {
    }

    public static ObtenerDepositosCliente getObtenerDepositosCliente() {
        return instancia;
    }
    
    
    private TableColumn<Deposito, String> tableColumnCodigo;
    private TableColumn<Deposito, String> tableColumnCliente;
    private TableColumn<Deposito, String> tableColumnCuenta;
    private TableColumn<Deposito, String> tableColumnMonto;
    private TableColumn<Deposito, String> tableColumnFecha;
    private TableColumn<Deposito, String> tableColumnTipo;
    private TableColumn<Deposito, String> tableColumnAgencia;

    private TableView<Deposito> tableView;
    private ObservableList<Deposito> observableList;

    
    /*----TABLA PRESTAMOS---------*/
    
    public HBox getVistaDeposito(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Prestamos del Cliente ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        
        tableColumnCodigo = new TableColumn<>();
        tableColumnCodigo.setText("Codigo Deposito");
        tableColumnCodigo.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnCodigo.setMinWidth(200);

        
        tableColumnCliente = new TableColumn<>();
        tableColumnCliente.setText("Destinatario");
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnCliente.setMinWidth(200);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha del Deposito");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableColumnFecha.setMinWidth(250);

        
        
        tableColumnCuenta = new TableColumn<>();
        tableColumnCuenta.setText("No Cuenta");
        tableColumnCuenta.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        tableColumnCuenta.setMinWidth(200);

        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto Q");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableColumnMonto.setMinWidth(200);

        tableColumnTipo = new TableColumn<>();
        tableColumnTipo.setText("Forma de Deposito");
        tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoDeposito"));
        tableColumnTipo.setMinWidth(280);
        
        tableColumnAgencia = new TableColumn<>();
        tableColumnAgencia.setText("Agencia");
        tableColumnAgencia.setCellValueFactory(new PropertyValueFactory<>("nombreAgencia"));
        tableColumnAgencia.setMinWidth(280);
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnCodigo,tableColumnCliente,tableColumnCuenta,tableColumnMonto, tableColumnFecha, tableColumnTipo, tableColumnAgencia);
        tableView.setMinSize(4000, 4000);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<Deposito> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(DepositoController.getInstancia().getArrayList(idCliente));
        return observableList;
    }
}


class ObtenerRetiroCliente {
    /*----SINGLETON------*/
    private static final ObtenerRetiroCliente instancia = new ObtenerRetiroCliente();
    private ObtenerRetiroCliente() {
    }

    public static ObtenerRetiroCliente getObtenerRetiroCliente() {
        return instancia;
    }
    /*------------*/
    
    
    private TableColumn<Retiro, String> tableColumnId;
    private TableColumn<Retiro, String> tableColumnFecha;
    private TableColumn<Retiro, String> tableColumnMonto;
    private TableColumn<Retiro, String> tableColumnCuenta;
    private TableColumn<Retiro, String> tableColumnAgencia;

    private TableView<Retiro> tableView;
    private ObservableList<Retiro> observableList;

    
    /*----TABLA TARJETA CREDITO---------*/
    
    public HBox getVista(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Retiros del Cliente ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("Numero de Retiro");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("id"));
        tableColumnId.setMinWidth(250);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de retiro");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableColumnFecha.setMinWidth(350);

        
        
        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto del retiro Q");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableColumnMonto.setMinWidth(250);

        tableColumnCuenta = new TableColumn<>();
        tableColumnCuenta.setText("Numero de cuenta");
        tableColumnCuenta.setCellValueFactory(new PropertyValueFactory<>("cuenta"));
        tableColumnCuenta.setMinWidth(250);


        tableColumnAgencia = new TableColumn<>();
        tableColumnAgencia.setText("Direccion deposito");
        tableColumnAgencia.setCellValueFactory(new PropertyValueFactory<>("cadena"));
        tableColumnAgencia.setMinWidth(250);

        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnMonto, tableColumnCuenta, tableColumnAgencia);
        tableView.setMinSize(100, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<Retiro> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(RetiroController.getRetiroController().getArrayRetiro(idCliente));
        return observableList;
    }
}

class ObtenerCuentasAhorro {
    /*----SINGLETON------*/
    private static final ObtenerCuentasAhorro instancia = new ObtenerCuentasAhorro();
    private ObtenerCuentasAhorro() {
    }

    public static ObtenerCuentasAhorro getObtenerCuentasAhorro() {
        return instancia;
    }
    /*------------*/
    
    private TableColumn<CuentaAhorroCliente, String> tableColumnId;
    private TableColumn<CuentaAhorroCliente, String> tableColumnFecha;
    private TableColumn<CuentaAhorroCliente, String> tableColumnMonto;
    private TableView<CuentaAhorroCliente> tableView;
    private ObservableList<CuentaAhorroCliente> observableList;
    
    public HBox getVista(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Retiros del Cliente ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("Numero de Cuenta");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idCuenta"));
        tableColumnId.setMinWidth(250);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de apertura");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaApertura"));
        tableColumnFecha.setMinWidth(350);

        
        
        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto Q");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("montoInicial"));
        tableColumnMonto.setMinWidth(250);

     
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnMonto);
        tableView.setMinSize(100, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<CuentaAhorroCliente> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayCACliete(idCliente));
        return observableList;
    }
    
    
    
}



class ObtenerCuentasMonetaria {
    /*----SINGLETON------*/
    private static final ObtenerCuentasMonetaria instancia = new ObtenerCuentasMonetaria();
    private ObtenerCuentasMonetaria() {
    }

    public static ObtenerCuentasMonetaria getObtenerCuentasMonetaria() {
        return instancia;
    }
    /*------------*/
    
    private TableColumn<CuentaMonetariaCliente, String> tableColumnId;
    private TableColumn<CuentaMonetariaCliente, String> tableColumnFecha;
    private TableColumn<CuentaMonetariaCliente, String> tableColumnMonto;
    private TableView<CuentaMonetariaCliente> tableView;
    private ObservableList<CuentaMonetariaCliente> observableList;
    
    public HBox getVista(int idCliente) {
        HBox hBoxVista = new HBox();
        
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Retiros del Cliente ");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("Numero de Cuenta");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idCuenta"));
        tableColumnId.setMinWidth(250);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de apertura");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fechaApertura"));
        tableColumnFecha.setMinWidth(350);

        
        
        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto Q");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("montoInicial"));
        tableColumnMonto.setMinWidth(250);

     
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList(idCliente));

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnMonto);
        tableView.setMinSize(100, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 3, 2, 1);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<CuentaMonetariaCliente> getObservableList(int idCliente) {
        observableList = FXCollections.observableArrayList(CuentasCliente.getCuentasCliente().getArrayCMCliete(idCliente));
        return observableList;
    }
    
    
    
}

