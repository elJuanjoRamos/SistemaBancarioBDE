package userInterface;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import userInterface.AccessWindow;
import controller.*;
import beans.Cliente;
import userInterface.UISeleccionCliente;


import controller.*;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Juan José Ramos
 */
public class UIMenu {
 ImageView view = new ImageView();
    private HBox hBox;
    private HBox hBox2;
    private GridPane gridPane;
    private GridPane gridPane2;
    private HBox hBoxButtons;
    
    private Button buttonUser;
    private Button buttonLogin;
    
    
    /*SINGLETON*/
    private static final UIMenu instancia = new UIMenu();

    private UIMenu() {
    }

    public static UIMenu getUI() {
        return instancia;
    }

    
    public void start(Stage primaryStage) {
      
        hBox = new HBox();
        hBox2 = new HBox(); 
        
        hBoxButtons = new HBox(10);
  
        
        buttonLogin = new Button("Modulo Admin");
        buttonLogin.setId("btnAzul");
        
        buttonUser = new Button("Modulo Transaccion ");
        buttonUser.setId("btnRojo");
        
        //UNO
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(30, 30, 30, 30));
        gridPane.setMinSize(900, 650);
        gridPane.setAlignment(Pos.BOTTOM_CENTER);
        
        Button modificacionDeCodigo = new Button("Modificacion de codifo");
        
       
        
        hBoxButtons.getChildren().addAll(buttonLogin, buttonUser,modificacionDeCodigo);
        
        
        gridPane.add(hBoxButtons, 1,90);
        
        hBox.getChildren().addAll(gridPane);
        
        
        //dos

        Image image = new Image("/resources/BID.png"); 
        
        gridPane2 = new GridPane();
        gridPane2.setPadding(new Insets(30, 30, 30, 30));
        gridPane2.setAlignment(Pos.CENTER);
        
        view.setImage(image);
        view.setFitHeight(475);
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
        buttonUser.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                UISeleccionCliente.getUI().start(primaryStage);
                
            }
        });
        
        modificacionDeCodigo.setOnAction(new EventHandler<ActionEvent>() {
         
            @Override
            
            public void handle(ActionEvent event) {
                Cliente cliente = ClienteController.getClienteController().buscar(0);
                UIOperacionesCliente.getUI().start(primaryStage, cliente);
            }
            
            
        });
        primaryStage.setScene(scene);
        primaryStage.show();
      
       
     

    }
   
}
