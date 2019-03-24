/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import beans.Cliente;
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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
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
   
    Principal p = new Principal();
   
    /*SINGLETON*/
    private AdminInterface() {
    }

    public static AdminInterface getAdminInterface() {
        return AdminInterface;
    }
    ///////////////
    public void start(Stage primaryStage) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        
        AnchorPane anchorPane = new AnchorPane();
        anchorPane.minHeight(616.0);
        anchorPane.minWidth(945.0);
        
        
        Text text = new Text();
        
        
        
        
        VBox vbox = new VBox();
        vbox.setStyle("-fx-background-color: white");
   
        Scene scene = new Scene(vbox, screenSize.getWidth(), screenSize.getHeight(), Color.WHITE);

        
        
        
        
        TabPane tabPane = new TabPane();
        tabPane.setId("tabPane");
        BorderPane borderPane = new BorderPane();
        Tab tab = new Tab();
        tab.setText("Clientes");
        HBox hbox = new HBox();
          
        hbox.getChildren().add(new Label("Clientes"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(UICliente.getCRUDCliente().getViewCliente());
        tab.setClosable(false);
        tab.setId("menuBar");
        
        Tab tab1 = new Tab();
        tab1.setText("Empleados");
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label("Empleados"));
        hbox1.setAlignment(Pos.CENTER);
        tab1.setContent(UIEmpleado.getUIEmpleado().getVistaData());
        tab1.setClosable(false);

        Tab tab2 = new Tab();
        tab2.setText("Agencias");
        HBox hbox2 = new HBox();
        hbox2.getChildren().add(new Label("Agencias"));
        hbox2.setAlignment(Pos.CENTER);
        tab2.setContent(UIAgencia.getAgencia().getViewAgencia());
        tab2.setClosable(false);
        
        Tab tab3 = new Tab();
        tab3.setText("Agencias AutoBanco");
        HBox hbox3 = new HBox();
        hbox3.getChildren().add(new Label("Agencias con AutoBanco"));
        hbox3.setAlignment(Pos.CENTER);
        tab3.setContent(UIAgenciaAutobanco.getAgencia().getViewAgencia());
        tab3.setClosable(false);
        
        
        
        
        
        Tab tab4 = new Tab();
        tab4.setText("Cajeros");
        HBox hbox4 = new HBox();
        hbox4.getChildren().add(new Label("Cajeros"));
        hbox4.setAlignment(Pos.CENTER);
        tab4.setContent(UICajero.getCRUDCajero().getViewCajero());
        tab4.setClosable(false);
        
        
        tabPane.getTabs().addAll(tab4, tab3,tab2, tab1, tab);

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
        
        MenuItem menuItemSalir = new MenuItem("_Salir");
        MenuItem menuItemRegresar = new MenuItem("_Regresar");
        
        
        
        
        
        menuItemRegresar.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                
                p.start(primaryStage);
            }
        });
        menuItemSalir.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
        
        menuArchivo.getItems().addAll(menuItemRegresar, menuItemSalir);
        
        menuBar.getMenus().addAll(menuArchivo);
        return menuBar;
        
        
    }
   
}
