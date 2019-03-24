/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import jfxtras.styles.jmetro8.JMetro;

/**
 *
 * @author Juan José Ramos
 */
public class UIRetiro {
    /*SINGLETON*/
    private static final JMetro.Style style = JMetro.Style.LIGHT;
    private static final UIRetiro UIRetiroAgencia = new UIRetiro();

    private UIRetiro() {
    }

    public static UIRetiro getUI() {
        return UIRetiroAgencia;
    }
    
    public void start(Stage primaryStage, Cliente cliente) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
        Scene scene = new Scene(vbox, 1300, 700, Color.WHITE);

        TabPane tabPane = new TabPane();
        BorderPane borderPane = new BorderPane();
        Tab tab = new Tab();
        tab.setText("Retiro de Agencias");
        HBox hbox = new HBox();
          
        hbox.getChildren().add(new Label("Clientes"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(UICliente.getCRUDCliente().getViewCliente());
        tab.setClosable(false);
        tab.setId("menuBar");
        
        
        Tab tab1 = new Tab();
        tab1.setText("Retiro de cajero");
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label("Empleados"));
        hbox1.setAlignment(Pos.CENTER);
        tab1.setContent(UIEmpleado.getUIEmpleado().getVistaData());
        tab1.setClosable(false);

        
        
        
        
        
  
        
        tabPane.getTabs().addAll(tab1, tab);

        tabPane.setSide(Side.TOP);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        
        
        vbox.getChildren().addAll(getMenuBar(primaryStage, cliente), borderPane);
        scene.getStylesheets().addAll("/resources/jmetro.css");
        new JMetro(style).applyTheme(scene);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    
    
    
    
    
    private MenuBar getMenuBar(Stage primaryStage, Cliente cliente) {
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
                UIOperacionesCliente.getUI().start(primaryStage, cliente);
            }
        });

        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);

        menuBar.getMenus().addAll(menuArchivo);
        return menuBar;
    }
}


class retiroAgencia {
    
}