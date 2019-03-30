/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
import controller.ReporteController;
import java.awt.Dimension;
import java.awt.Toolkit;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author Juan José Ramos
 */
public class AdminInterface {
    //private static final JMetro.Style style = JMetro.Style.LIGHT;
    private static final AdminInterface AdminInterface = new AdminInterface();
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
   
    /*SINGLETON*/
    private AdminInterface() {
    }

    public static AdminInterface getAdminInterface() {
        return AdminInterface;
    }
    ///////////////
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
        Text t = new Text("Clientes");
        t.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
        tab.setGraphic(t);
        tab.setContent(UICliente.getCRUDCliente().getViewCliente());
        tab.setClosable(false);
        tab.setId("menuBar");
        
        Tab tab1 = new Tab();
        Text t1 = new Text("Empleado");
        t1.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
        tab1.setGraphic(t1);
        
        tab1.setContent(UIEmpleado.getUIEmpleado().getVistaData());
        tab1.setClosable(false);

        Tab tab2 = new Tab();
        Text t2 = new Text("Agencias");
        t2.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        
        tab2.setGraphic(t2);
        tab2.setContent(UIAgencia.getAgencia().getViewAgencia());
        tab2.setClosable(false);
        
        Tab tab3 = new Tab();
        Text t3 = new Text("Agencia con autobanco");
        t3.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        tab3.setGraphic(t3);
        tab3.setContent(UIAgenciaAutobanco.getAgencia().getViewAgencia());
        tab3.setClosable(false);
        
        
        
        
        
        Tab tab4 = new Tab();
        Text t4 = new Text("Cajeros Automaticos");
        t4.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
        tab4.setGraphic(t4);
        tab4.setContent(UICajero.getCRUDCajero().getViewCajero());
        tab4.setClosable(false);
        
        
        tabPane.getTabs().addAll(tab, tab1,tab2, tab3, tab4);

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
    
    private  MenuBar getMenuBar(Stage primaryStage) {
        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("OPCIONES");
        Menu menuReportes = new Menu("REPORTES");
        
        MenuItem menuItemSalir = new MenuItem("_Salir");
        MenuItem menuItemRegresar = new MenuItem("_Regresar");
        
        
        MenuItem reporte1 = new MenuItem("_Top 3 Clientes mas cuentas");
        MenuItem reporte2 = new MenuItem("_Top 3 Clientes mayor suma dinero");
        MenuItem reporte3 = new MenuItem("_Top 3 Clientes mayor deuda");
        MenuItem reporte4 = new MenuItem("_Top 3 Agencias usadas");
        MenuItem reporte5 = new MenuItem("_Listado Mayor numero de empleados en Agencias");
        
        
        
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
        
        reporte1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               ReporteController.getReporteController().CrearPdfTopClienteCuenta();
            }
          });
        
        reporte2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               ReporteController.getReporteController().CrearPDFClienteMayorDinero();
            }
          });
        
        reporte3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ReporteController.getReporteController().CrearPDFMayorDeuda();
            }
          });
        
        reporte4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ReporteController.getReporteController().CrearPDFAgenciaMasUsada();
            }
          });
        
        reporte5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
               ReporteController.getReporteController().CrearPDFAgenciaMayorEmpleado();
            }
          });
        
        
        
        menuReportes.getItems().addAll(reporte1,reporte2,reporte3,reporte4,reporte5);
        
        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);
        
        menuBar.getMenus().addAll(menuArchivo, menuReportes);
        return menuBar;
        
        
    }
   
}
