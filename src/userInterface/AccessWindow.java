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
    private Text textTitle;
    private Label labelNombre;
    private TextField textFieldNombre;
    private Label labelClave;
    private TextField userTextField;
    private PasswordField passwordFieldClave;
    
    private PasswordField pwBox;
    private Button buttonAcceder;
    private Text actiontarget;

    private AccessWindow() {
    }

    public static AccessWindow getAccessWindow() {
        return AccessWindow;
    }

    public GridPane getGridPane(Stage primaryStage) {
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        
        Text scenetitle = new Text("Bienvenido");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        grid.add(scenetitle, 0, 0, 2, 1);

        Label userName = new Label("User Name:"); 
        grid.add(userName, 0, 1);

        userTextField = new TextField("admin");
        grid.add(userTextField, 1, 1);

        Label pw = new Label("Password:");
        grid.add(pw, 0, 2);

        pwBox = new PasswordField();
        grid.add(pwBox, 1, 2);
        
        Button btn = new Button("Sign in");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 6);
        
        actiontarget = new Text();
        grid.add(actiontarget, 1, 5);
        btn.setOnAction(new EventHandler<ActionEvent>() {
              @Override
               public void handle(ActionEvent e) {
                  boolean auth = autenticar(userTextField.getText(), pwBox.getText());
                  
                  if (auth) {
                      //Menu.getMemu().start(primaryStage);
                      AdminInterface.getAdminInterface().start(primaryStage);
                  } else {
                      actiontarget.setFill(Color.FIREBRICK);
                      actiontarget.setText("Usuario o Contraseña Invalidos");
                  }
                  
            }
        });
        btn.setDefaultButton(true);
        grid.setId("gridLogin");
        
        
        Scene scene = new Scene(grid, 360, 360);
        scene.getStylesheets().addAll("/resources/root.css");
        
        primaryStage.setTitle("Access Window");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        
        return grid;
    }
    
    private Boolean autenticar(String nombre, String clave) {
        if (esNumero(clave)) {
            if (nombre.equals("admin") && Integer.parseInt(clave) ==  12345) {
                return true;
            }
        } else {
            return false;
        }
        return false;
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

