/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Juan José Ramos
 */
public class AdminInterface {

    private static final AdminInterface AdminInterface = new AdminInterface();

    private AdminInterface() {
    }

    public static AdminInterface getAdminInterface() {
        return AdminInterface;
    }

    public void start(Stage primaryStage) {

        primaryStage.setTitle("MODULO ADMINISTRATIVO");
        Group root = new Group();
        Scene scene = new Scene(root, 1300, 700, Color.WHITE);

        TabPane tabPane = new TabPane();
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

        tabPane.setSide(Side.TOP);
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());

        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        scene.getStylesheets().addAll("/resources/root.css");

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
