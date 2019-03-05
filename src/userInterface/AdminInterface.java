/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import beans.*;
import controller.ClienteController;
import javafx.collections.FXCollections;

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
        Scene scene = new Scene(root, 1000, 500, Color.WHITE);

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();
        Tab tab = new Tab();
        tab.setText("Clientes");
        HBox hbox = new HBox();
        hbox.getChildren().add(new Label("Clientes"));
        hbox.setAlignment(Pos.CENTER);
        tab.setContent(CRUDCliente.getCRUDCliente().getViewCliente());
        tab.setClosable(false);

        Tab tab1 = new Tab();
        tab1.setText("Tab" + 1);
        HBox hbox1 = new HBox();
        hbox1.getChildren().add(new Label("Tab" + 1));
        hbox1.setAlignment(Pos.CENTER);
        tab1.setContent(hbox1);
        tab1.setClosable(false);

        Tab tab2 = new Tab();
        tab2.setText("Tab" + 2);
        HBox hbox2 = new HBox();
        hbox2.getChildren().add(new Label("Tab" + 2));
        hbox2.setAlignment(Pos.CENTER);
        tab2.setContent(hbox2);
        tab2.setClosable(false);

        tabPane.getTabs().addAll(tab, tab1, tab2);

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
