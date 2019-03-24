/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Juan José Ramos
 */
public class AccessWindow {
    private static final AccessWindow AccessWindow = new AccessWindow();
    

    private GridPane grid;
    private TextField userTextField;
    private PasswordField pwBox;
    private Text actiontarget;

    private AccessWindow() {
    }

    public static AccessWindow getAccessWindow() {
        return AccessWindow;
    }

    public GridPane getGridPane(Stage primaryStage) {
        Image image = new Image("/resources/BID2.png");
        ImageView view = new ImageView();
        view.setImage(image);
        grid = new GridPane();
        grid.setId("gridLogin");
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        grid.add(view, 1, 0);
        
        
        userTextField = new TextField("admin");
        userTextField.setPromptText("User Name");
        grid.add(userTextField, 1, 2);


        pwBox = new PasswordField();
        pwBox.setPromptText("Password");
        grid.add(pwBox, 1, 3);
        
        Button btn = new Button("Sign in");
        btn.setId("btnAzulA");
        HBox hbBtn = new HBox(10);
        hbBtn.setId("hboxLogin");
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 4);

        btn.setOnAction(new EventHandler<ActionEvent>() {
              @Override
               public void handle(ActionEvent e) {
                  boolean auth = autenticar(userTextField.getText(), pwBox.getText());
                  
                  if (auth) {
                      AdminInterface.getAdminInterface().start(primaryStage);
                  } else {
                      actiontarget.setFill(Color.FIREBRICK);
                      actiontarget.setText("Usuario o password Invalidos");
                  }
                  
            }
        });

        Button btn1 = new Button("Regresar");
        btn1.setId("btnRojoR");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e ) {
                UIMenu.getUI().start(primaryStage);
            }
          }
        );
        
        
        hbBtn.setAlignment(Pos.BASELINE_RIGHT);
        hbBtn.getChildren().addAll(btn, btn1);
        grid.add(hbBtn, 1, 5);
        
        
        Scene scene = new Scene(grid, 800, 600);
        scene.getStylesheets().addAll("/resources/root.css");
        
        primaryStage.setTitle("Access Window");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        return grid;
    }
    
    private Boolean autenticar(String nombre, String clave) {
        if(nombre.length() != 0 && clave.length() != 0) {
            if (esNumero(clave)) {
                if (nombre.equals("admin") && Integer.parseInt(clave) ==  123456) {
                    return true;
                }
            } else {
                return false;
            }
            return false;
        } else {
            return false;
        }
    }
    
    public static boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException e) {
            resultado = false;
        }

        return resultado;
    }
}

