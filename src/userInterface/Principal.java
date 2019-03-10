/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.application.Application;

import javafx.stage.Stage;

import controller.*;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
/**
 *
 * @author Juan José Ramos
 */
public class Principal extends Application {
    ImageView view = new ImageView();
    private HBox hBox;
    private HBox hBox2;
    private GridPane gridPane;
    private GridPane gridPane2;
    private HBox hBoxButtons;
    
    private Button buttonUser;
    private Button buttonLogin;
    

    
    @Override
    public void start(Stage primaryStage) {
        
 /*       
        hBox = new HBox();
        hBox2 = new HBox(); 
        
        hBoxButtons = new HBox(10);
  
        
        buttonLogin = new Button("Modulo Admin");
        buttonLogin.setId("btnAzul");
        
        buttonUser = new Button("Modulo Usuario ");
        buttonUser.setId("btnRojo");
        
        //UNO
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setMinSize(900, 650);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        
        
        hBoxButtons.getChildren().addAll(buttonLogin, buttonUser );
        
        
        gridPane.add(hBoxButtons, 1,90);
        
        hBox.getChildren().addAll(gridPane);
        
        
        //dos

        Image image = new Image("/resources/BID.png"); 
        
        gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(30, 30, 30, 30));
        gridPane2.setAlignment(Pos.CENTER);
        
        view.setImage(image);
        view.setFitHeight(500);
        view.setFitWidth(800);
        gridPane2.add(view, 0, 0);
        
        hBox2.getChildren().addAll(gridPane2);
        
        Group root = new Group();
        Scene scene = new Scene(root, 850,700);

        root.getChildren().addAll(hBox, hBox2);
        scene.getStylesheets().addAll("/resources/root.css");

        buttonLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                AccessWindow.getAccessWindow().getGridPane(primaryStage);
            }
        });
        primaryStage.setScene(scene);
        primaryStage.show();
*/       
        
                ClienteController.getClienteController().agregar("1", "dir1", "tel");
        ClienteController.getClienteController().agregar("2", "dir2", "tel");
        ClienteController.getClienteController().agregar("3", "dir3", "tel");
        
        EmpleadoController.getEmpleadoController().agregar("juan", "dir1", "tel", "Call-Center");
        EmpleadoController.getEmpleadoController().agregar("luis", "dir2", "tel", "Agencia");
        EmpleadoController.getEmpleadoController().agregar("pedro", "dir3", "tel", "Autobanco");
        
        //AGENCIA
        AgenciaController.getAgenciaController().agregar("1", "DIR1", "TEL", 1, 1, 0, 50.450);
        AgenciaController.getAgenciaController().agregar("2", "DIR1", "TEL", 1, 1, 0, 50.450);
        AgenciaController.getAgenciaController().agregar("3", "DIR1", "TEL", 1, 1, 0, 50.450);
        AgenciaController.getAgenciaController().agregar("4", "DIR1", "TEL", 1, 1, 0, 50.450);
        
        
        
        
        
        
        //AGENCIAAUTOBANCOS
        AgenciaController.getAgenciaController().agregar("A", "dir1", "tel1", 5, 5, 1, 332.997);
        AgenciaController.getAgenciaController().agregar("B", "dir2", "tel2", 15, 5, 2, 15265.03);
        AgenciaController.getAgenciaController().agregar("C", "dir3", "tel3", 11, 5, 3, 998.03);
        AgenciaController.getAgenciaController().agregar("D", "dir4", "tel4", 9, 5, 4, 50.03);
        AgenciaController.getAgenciaController().agregar("E", "dir5", "tel5", 7, 5, 5, 37.03);
        AdminInterface.getAdminInterface().start(primaryStage);
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        launch(args);
        
    }
    
    
    
}
