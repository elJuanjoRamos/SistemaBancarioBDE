/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.*;
import controller.ClienteController;
import controller.CuentasCliente;
import controller.SolicitudController;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.InputMismatchException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
public class UIDeptoFinanciero {
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   
    /*SINGLETON*/
    private static final UIDeptoFinanciero instance = new UIDeptoFinanciero();
    
    private UIDeptoFinanciero() {
    }

    public static UIDeptoFinanciero getUI() {
        return instance;
    }
    public void start(Stage primaryStage) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
   
        Scene scene = new Scene(vbox, screenSize.getWidth(), screenSize.getHeight(), Color.WHITE);

        
        
        
        
        TabPane tabPane = new TabPane();
        tabPane.minWidth(945);
        tabPane.minHeight(546);
        tabPane.setId("tabPane");
        
        BorderPane borderPane = new BorderPane();
        Tab tab = new Tab();
        Text t = new Text("Solicitudes Prestamo");
        t.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
        tab.setGraphic(t);
        tab.setContent(obtenerPrestamos.getobtenerPrestamos().getVista());
        tab.setClosable(false);
        
        Tab tab1 = new Tab();
        Text t2 = new Text("Solicitudes Tarjeta");
        t2.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        tab1.setGraphic(t2);
        tab1.setContent(obtenerTarjeta.getobtenerTarjeta().getVista());
        tab1.setClosable(false);

        
        
        tabPane.getTabs().addAll(tab1, tab);

        tabPane.setSide(Side.LEFT);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        vbox.getChildren().addAll(getMenuBar(primaryStage), borderPane);
        
        scene.getStylesheets().addAll("/resources/root.css");
        
        
        //new JMetro(style).applyTheme(scene);
        primaryStage.setScene(scene);
        primaryStage.setMaximized(true);
        primaryStage.show();
        
        
        
        
    }
        private MenuBar getMenuBar(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        javafx.scene.control.Menu menuArchivo = new javafx.scene.control.Menu("Opciones");

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
                UIMenu.getUI().start(primaryStage);
            }
        });

        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);

        menuBar.getMenus().addAll(menuArchivo);
        return menuBar;
    }

    
    
}


class obtenerTarjeta{
    
        /*----SINGLETON------*/
    private static final obtenerTarjeta instancia = new obtenerTarjeta();
    
    private obtenerTarjeta() {
    }

    public static obtenerTarjeta getobtenerTarjeta() {
        return instancia;
    }
    /*------------*/
    /*VARIABLES*/
    private HBox hBoxVista; 
    private GridPane gridPane;
    
    private TableColumn<SolicitudTarjeta, String> tableColumnId;
    private TableColumn<SolicitudTarjeta, String> tableColumnFecha;
    private TableColumn<SolicitudTarjeta, String> tableColumnEstado;
    private TableColumn<SolicitudTarjeta, String> tableColumnCliente;
    private TableColumn<SolicitudTarjeta, String> tableColumnDireccion;
    private TableColumn<SolicitudTarjeta, String> tableColumnTelefono;
    private TableView<SolicitudTarjeta> tableView;
    private ObservableList<SolicitudTarjeta> observableList;
    
    public HBox getVista() {
        hBoxVista = new HBox();
        
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Solcotudes de Taretas");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        
        
                Button buttonModificar = new Button("Seleccionar Solicitud");
        buttonModificar.setId("btnNaranja");
        buttonModificar.setGraphic(new ImageView("/resources/3.png"));
        
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    hBoxVista.getChildren().clear();
                    hBoxVista.getChildren().addAll(gridPane, ActualizarSolicitudTarjeta.getActualizar().getGridPane(tableView.getSelectionModel().getSelectedItem()));
                    tableView.getSelectionModel().clearSelection();
                    
                    actualizarDatosTabla();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("No ha seleccionado ninguna solicitud para modificar");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();
                }

            }
        });

        gridPane.add(buttonModificar, 0, 1);
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("Codigo");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idSolicitud"));
        tableColumnId.setMinWidth(100);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de Solicitud");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableColumnFecha.setMinWidth(250);

        
        
        tableColumnEstado = new TableColumn<>();
        tableColumnEstado.setText("Estado");
        tableColumnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableColumnEstado.setMinWidth(100);

     
        
        tableColumnCliente = new TableColumn<>();
        tableColumnCliente.setText("Cliente");
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnCliente.setMinWidth(250);

     
        
        tableColumnDireccion = new TableColumn<>();
        tableColumnDireccion.setText("Direccion");
        tableColumnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnDireccion.setMinWidth(250);

        tableColumnTelefono = new TableColumn<>();
        tableColumnTelefono.setText("Telefono");
        tableColumnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumnTelefono.setMinWidth(150);

        
        tableView = new TableView<>();
        tableView.setItems(getObservableList());

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnEstado, tableColumnCliente, tableColumnDireccion, tableColumnTelefono);
        tableView.setMinSize(100, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0, 7);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<SolicitudTarjeta> getObservableList() {
        observableList = FXCollections.observableArrayList(SolicitudController.getSolicitudController().getSolicitudTarjeta());
        return observableList;
    }
    public void restarthBoxCRUD() {
        System.out.println("hola");
        hBoxVista.getChildren().clear();
        hBoxVista.getChildren().add(gridPane);
    }
        public void actualizarDatosTabla() {
            System.out.println("ho");
        actualizarDatos();
        tableView.setItems(observableList);
    }
    public void actualizarDatos() {
        System.out.println("h");
        observableList.clear();
        observableList = FXCollections.observableArrayList(SolicitudController.getSolicitudController().getSolicitudTarjeta());
        
    }
}


class obtenerPrestamos {
        /*----SINGLETON------*/
    private static final obtenerPrestamos instancia = new obtenerPrestamos();
    
    private obtenerPrestamos() {
    }

    public static obtenerPrestamos getobtenerPrestamos() {
        return instancia;
    }
    /*------------*/
    
    
    private TableColumn<SolicitudPrestamo, String> tableColumnId;
    private TableColumn<SolicitudPrestamo, String> tableColumnFecha;
    private TableColumn<SolicitudPrestamo, String> tableColumnEstado;
    private TableColumn<SolicitudPrestamo, String> tableColumnCliente;
    private TableColumn<SolicitudPrestamo, String> tableColumnDireccion;
    private TableColumn<SolicitudPrestamo, String> tableColumnTelefono;
    private TableColumn<SolicitudPrestamo, String> tableColumnMonto;
    private TableView<SolicitudPrestamo> tableView;
    private ObservableList<SolicitudPrestamo> observableList;
    
    /*VARIABLES*/
    private HBox hBoxVista;
    private GridPane gridPane;
        
    public HBox getVista() {
        
        hBoxVista = new HBox();
        
        gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        
        Text textTitle = new Text("  Solicitudes de Prestamos");
        textTitle.setFont(Font.font("Helvetica", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0);
        
        
        Button buttonModificar = new Button("Seleccionar Solicitud");
        buttonModificar.setId("btnNaranja");
        buttonModificar.setGraphic(new ImageView("/resources/3.png"));
        
        buttonModificar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (tableView.getSelectionModel().getSelectedItem() != null) {
                    hBoxVista.getChildren().clear();
                    hBoxVista.getChildren().addAll(gridPane, ActualizarSolicitudPrestamo.getActualizar().getGridPane(tableView.getSelectionModel().getSelectedItem()));
                    tableView.getSelectionModel().clearSelection();
                    
                    actualizarDatosTabla();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information");
                    alert.setHeaderText("No ha seleccionado ninguna solicitud para modificar");
                    alert.initStyle(StageStyle.UTILITY);
                    alert.showAndWait();
                }

            }
        });

        gridPane.add(buttonModificar, 0, 1);
        
        
        
        tableColumnId = new TableColumn<>();
        tableColumnId.setText("Codigo");
        tableColumnId.setCellValueFactory(new PropertyValueFactory<>("idSolicitud"));
        tableColumnId.setMinWidth(100);

        
        
        tableColumnFecha = new TableColumn<>();
        tableColumnFecha.setText("Fecha de Solicitud");
        tableColumnFecha.setCellValueFactory(new PropertyValueFactory<>("fecha"));
        tableColumnFecha.setMinWidth(250);

        
        
        tableColumnEstado = new TableColumn<>();
        tableColumnEstado.setText("Estado");
        tableColumnEstado.setCellValueFactory(new PropertyValueFactory<>("estado"));
        tableColumnEstado.setMinWidth(100);

     
        
        tableColumnCliente = new TableColumn<>();
        tableColumnCliente.setText("Cliente");
        tableColumnCliente.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        tableColumnCliente.setMinWidth(250);

     
        
        tableColumnDireccion = new TableColumn<>();
        tableColumnDireccion.setText("Direccion");
        tableColumnDireccion.setCellValueFactory(new PropertyValueFactory<>("direccion"));
        tableColumnDireccion.setMinWidth(125);

        tableColumnTelefono = new TableColumn<>();
        tableColumnTelefono.setText("Telefono");
        tableColumnTelefono.setCellValueFactory(new PropertyValueFactory<>("telefono"));
        tableColumnTelefono.setMinWidth(125);

        tableColumnMonto = new TableColumn<>();
        tableColumnMonto.setText("Monto");
        tableColumnMonto.setCellValueFactory(new PropertyValueFactory<>("monto"));
        tableColumnMonto.setMinWidth(100);

        
        
        tableView = new TableView<>();
        tableView.setItems(getObservableList());

        tableView.getColumns().addAll(tableColumnId, tableColumnFecha, tableColumnEstado, tableColumnCliente, tableColumnDireccion, tableColumnTelefono, tableColumnMonto);
        tableView.setMinSize(100, 250);
        tableView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
        gridPane.add(tableView, 0,7);


        hBoxVista.getChildren().add(gridPane);
        hBoxVista.setAlignment(Pos.CENTER_LEFT);
        hBoxVista.setMinSize(5000, 5000);
        return hBoxVista;
        
    }
    private ObservableList<SolicitudPrestamo> getObservableList() {
        observableList = FXCollections.observableArrayList(SolicitudController.getSolicitudController().getSolicitudPrestamo());
        return observableList;
    }
    public void restarthBoxCRUD() {
        System.out.println("hola pre");
        hBoxVista.getChildren().clear();
        hBoxVista.getChildren().add(gridPane);
    }
        public void actualizarDatosTabla() {
            System.out.println("ho pre");
        actualizarDatos();
        tableView.setItems(observableList);
    }
    public void actualizarDatos() {
        System.out.println("h pre");
        observableList.clear();
        observableList = FXCollections.observableArrayList(SolicitudController.getSolicitudController().getSolicitudPrestamo());
        
    }
}


class ActualizarSolicitudPrestamo {

    private static final ActualizarSolicitudPrestamo Actualizar = new ActualizarSolicitudPrestamo();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelDireccion;
    private TextField textFieldDireccion;
    private Label labelTelefono;
    private TextField textFieldTelefono;
    private Button buttonAceptar;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private ActualizarSolicitudPrestamo() {
       
    }

    public static ActualizarSolicitudPrestamo getActualizar() {
        return Actualizar;
    }

    public GridPane getGridPane(SolicitudPrestamo solicitud) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Detalles");
        textTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Cliente: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField(solicitud.getCliente().getNombre());
        textFieldNombre.setEditable(false);
        gridPane.add(textFieldNombre, 1, 3, 3, 1);

        labelDireccion = new Label("Direccion: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField(solicitud.getCliente().getDireccion());
        textFieldDireccion.setEditable(false);
        gridPane.add(textFieldDireccion, 1, 4, 3, 1);
        
        
        labelTelefono = new Label("Telefono: ");
        gridPane.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField(solicitud.getCliente().getTelefono());
        textFieldTelefono.setEditable(false);
        gridPane.add(textFieldTelefono, 1, 5, 3, 1);

        Label labelMonto = new Label("Monto: ");
        gridPane.add(labelMonto, 0, 6);

        TextField textFieldMonto = new TextField(String.valueOf(solicitud.getMonto()));
        textFieldMonto.setEditable(false);
        gridPane.add(textFieldMonto, 1, 6, 3, 1);
        
        Label labelID = new Label("ID Solicitud: ");
        gridPane.add(labelID, 0, 7);

        TextField textFieldId = new TextField(String.valueOf(solicitud.getIdSolicitud()));
        textFieldId.setEditable(false);
        gridPane.add(textFieldId, 1, 7, 3, 1);
        
        
        
        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setId("btnNaranja");
        buttonAceptar.setDefaultButton(true);
        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                SolicitudController.getSolicitudController().aceptarPrestamo(solicitud);
                obtenerPrestamos.getobtenerPrestamos().actualizarDatosTabla();
                getAlert("Solicitud aceptada con exito");
            }
        });

        gridPane.add(buttonAceptar, 1, 8);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setId("btnRojoR");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                obtenerPrestamos.getobtenerPrestamos().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 2, 8);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
         public void getAlert(String cadena) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alert");
        alerta.setHeaderText(null);
        alerta.setContentText(cadena);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.showAndWait();
    }
}


class ActualizarSolicitudTarjeta {

    private static final ActualizarSolicitudTarjeta Actualizar = new ActualizarSolicitudTarjeta();
    private GridPane gridPane;
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelDireccion;
    private TextField textFieldDireccion;
    private Label labelTelefono;
    private TextField textFieldTelefono;
    private Button buttonAceptar;
    private Alert alert = new Alert(Alert.AlertType.INFORMATION);

    private ActualizarSolicitudTarjeta() {
       
    }

    public static ActualizarSolicitudTarjeta getActualizar() {
        return Actualizar;
    }

    public GridPane getGridPane(SolicitudTarjeta solicitud) {
        gridPane = new GridPane();
        gridPane.setVgap(10);
        gridPane.setHgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));

        textTitle = new Text("Detalles");
        textTitle.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        gridPane.add(textTitle, 0, 0, 3, 1);

        labelNombre = new Label("Cliente: ");
        gridPane.add(labelNombre, 0, 3);

        textFieldNombre = new TextField(solicitud.getCliente().getNombre());
        textFieldNombre.setEditable(false);
        gridPane.add(textFieldNombre, 1, 3, 3, 1);

        labelDireccion = new Label("Direccion: ");
        gridPane.add(labelDireccion, 0, 4);

        textFieldDireccion = new TextField(solicitud.getCliente().getDireccion());
        textFieldDireccion.setEditable(false);
        gridPane.add(textFieldDireccion, 1, 4, 3, 1);
        
        
        labelTelefono = new Label("Telefono: ");
        gridPane.add(labelTelefono, 0, 5);

        textFieldTelefono = new TextField(solicitud.getCliente().getTelefono());
        textFieldTelefono.setEditable(false);
        gridPane.add(textFieldTelefono, 1, 5, 3, 1);

        Label labelID = new Label("ID Solicitud: ");
        gridPane.add(labelID, 0, 6);

        
        
        
        TextField textFieldId = new TextField(String.valueOf(solicitud.getIdSolicitud()));
        textFieldId.setEditable(false);
        gridPane.add(textFieldId, 1, 6, 3, 1);
        
        
        
        Label labelMonto = new Label("Monto de la tarjeta: ");
        gridPane.add(labelMonto, 0, 7);

        TextField textFieldMonto = new TextField();
        gridPane.add(textFieldMonto, 1, 7, 3, 1);
        
        
        
        buttonAceptar = new Button("Aceptar");
        buttonAceptar.setId("btnNaranja");
        buttonAceptar.setDefaultButton(true);
        buttonAceptar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (esNumero(textFieldMonto.getText())) {
                    SolicitudController.getSolicitudController().aceptarTarjeta(solicitud, Double.parseDouble(textFieldMonto.getText()));
                    obtenerTarjeta.getobtenerTarjeta().actualizarDatosTabla();
                    getAlert("Solicitud Aceptada con exito");
                } else {
                    getAlert("Debe introducir valore validos para el monto de la tarjeta");
                }
                
            }
        });

        gridPane.add(buttonAceptar, 1, 8);

        Button buttonCerrar = new Button("Cerrar");
        buttonCerrar.setId("btnRojoR");
        buttonCerrar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                obtenerTarjeta.getobtenerTarjeta().restarthBoxCRUD();
            }
        });
        gridPane.add(buttonCerrar, 2, 8);
        gridPane.getStyleClass().add("gridPane");
        gridPane.setMinSize(200, 400);

        return gridPane;
    }
    
    public boolean esNumero(String cadena) {
        boolean resultado;

        try {
            Double.parseDouble(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        } catch (InputMismatchException a) {
            resultado = false;
        }

        return resultado;
    }
     public void getAlert(String cadena) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Alert");
        alerta.setHeaderText(null);
        alerta.setContentText(cadena);
        alerta.initStyle(StageStyle.UTILITY);
        alerta.showAndWait();
    }
}
