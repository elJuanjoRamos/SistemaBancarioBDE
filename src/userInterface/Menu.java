/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Juan José Ramos
 */
public class Menu {
     private static final Menu Menu = new Menu();
    private VBox vBoxPrincipal;
    private VBox vBoxPrueba;
    private Stage stage;
    
     private Menu() {
        
    }

    public static Menu getMemu() {
        return Menu;
    }
    
    
        
    
        public HBox gethBoxCRUD() {
            
            
            
        HBox hBoxCRUD = new HBox();
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(25, 25, 25, 25));
        Text textTitle = new Text("Menu Principal");
        textTitle.setId("TituloPrincipal");
        gridPane.add(textTitle, 0, 0);
        
        Button botonAlumno = new Button("Alumnos");
        botonAlumno.setId("botonAlumno");
        botonAlumno.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        botonAlumno.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                vBoxPrueba = new VBox();
                Scene scene = new Scene(vBoxPrueba, 1150, 600);
                stage.setTitle("Alumno");
                stage.setScene(scene);
                stage.show();
                Button botonRegresar = new Button("Regresar");

                botonAlumno.setCancelButton(false);

                botonRegresar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                       Menu.start(stage);

                    }
                });
                //vBoxPrueba.getChildren().addAll(getMenuBar(), CRUDAlumno.getCRUDAlumno().gethBoxCRUDAlumno(), botonRegresar);
            }
        });
        Button botonProfesor= new Button("Profesores");

        botonProfesor.setId("botonProfesor");
        botonProfesor.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        
        Button botonUsuario = new Button("Usuarios");

        botonUsuario.setId("botonUsuario");

        botonUsuario.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
       
        Button botonMateria = new Button("Materias");

        botonMateria.setId("botonMateria");
        botonMateria.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        
        Button botonGrado = new Button("Grados");
        

        botonGrado.setId("botonGrado");
        botonGrado.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        

        Button botonSalon = new Button("Salones");
        botonSalon.setId("botonSalon");
        botonSalon.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        
        

        Button botonAsignacion= new Button("Asignaciones");
        botonAsignacion.setId("botonAsignacion");
        botonAsignacion.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        
        Button botonNotas= new Button("Notas");
        botonNotas.setId("botonNotas");
        botonNotas.getStylesheets().addAll("/org/juanjoseramos/resource/root.css");
        
        HBox hBoxButtons = new HBox(10);
        HBox hBoxPosicion = new HBox(10);
        HBox hBoxPosicion1 = new HBox(10);
        HBox hBoxPosicion2 = new HBox(10);
        HBox hBoxPosicion3 = new HBox(10);
        HBox hBoxPosicion4 = new HBox(10);

        HBox hBoxPosicion5 = new HBox(10);
        HBox hBoxPosicion6 = new HBox(10);
        Button buttonEliminar = new Button("Eliminar");
       buttonEliminar.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
               
            }
        });
   
        hBoxButtons.getChildren().addAll(botonUsuario);
        hBoxPosicion.getChildren().addAll(botonAlumno);
        hBoxPosicion1.getChildren().addAll(botonProfesor);
        hBoxPosicion2.getChildren().addAll(botonMateria);
        hBoxPosicion3.getChildren().addAll(botonGrado);
        hBoxPosicion4.getChildren().addAll(botonSalon);
        hBoxPosicion5.getChildren().addAll(botonAsignacion);
        hBoxPosicion6.getChildren().addAll(botonNotas);

        
        gridPane.add(hBoxButtons, 0, 1);
        gridPane.add(hBoxPosicion, 0, 5);
        gridPane.add(hBoxPosicion1, 0, 10);
        gridPane.add(hBoxPosicion2, 4, 1);
        gridPane.add(hBoxPosicion3, 4, 5);
        gridPane.add(hBoxPosicion4, 4, 10);

        gridPane.add(hBoxPosicion5, 8, 1);
        gridPane.add(hBoxPosicion6, 8, 5);

        hBoxCRUD.setId("hBox");
        StackPane stackPane = new StackPane();
        stackPane.setId("stackPane");

        stackPane.setMinSize(600, 400);
        stackPane.getChildren().addAll(gridPane);
        
        hBoxCRUD.getChildren().addAll(stackPane);
        hBoxCRUD.setId("Interfaz");
       // hBoxCRUD.getStylesheets().add("/org/juanjoseramos/resource/DashBoard.css");
      
        return hBoxCRUD;
    }

        
        

        
        
        
        
        
        
        
    public void start(Stage primaryStage) {
        
       primaryStage.setTitle("Tabs");
        Group root = new Group();
        Scene scene = new Scene(root, 500, 400, Color.WHITE);

        TabPane tabPane = new TabPane();

        BorderPane borderPane = new BorderPane();
        Tab tab = new Tab();
            tab.setText("Clientes");
            HBox hbox = new HBox();
            hbox.getChildren().add(new Label("Clientes"));
            hbox.setAlignment(Pos.CENTER);
            tab.setContent(hbox);
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
            
        
        //tabPane.setSide(Side.LEFT);
        tabPane.setSide(Side.TOP);
        //tabPane.setSide(Side.RIGHT);
        //tabPane.setSide(Side.BOTTOM);
        
        // bind to take available space
        borderPane.prefHeightProperty().bind(scene.heightProperty());
        borderPane.prefWidthProperty().bind(scene.widthProperty());
        
        borderPane.setCenter(tabPane);
        root.getChildren().add(borderPane);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
        /*BorderPane root = new BorderPane();
        root.setLeft(sideMenu());
        Scene scene = new Scene(root, 1000,500);
        scene.getStylesheets().addAll("/resources/root.css");
        primaryStage.setScene(scene);
        primaryStage.show();*/

    }
    
    private VBox sideMenu() {
        vBoxPrincipal = new VBox();
        vBoxPrincipal.setPrefWidth(50);
        for (int i = 1; i < 10; i++) {
            vBoxPrincipal.getChildren().add(Item());
        }
        return vBoxPrincipal;
    }
    private HBox Item() {
       Button btn = new Button();
       btn.setPrefSize(45, 50);
       btn.setId("btnTab");
       btn.setStyle("-fx-background-color: #212121; -fx-graphic : url('/resources/1.png')");
       
       Button btn2 = new Button();
       btn2.setPrefSize(45, 50);
       btn2.setId("btnTab");
       btn2.setStyle("-fx-background-color: #212121; -fx-graphic : url('/resources/1.png')");
       
       Pane paneIndicator = new Pane();
       paneIndicator.setPrefSize(10, 50);
       paneIndicator.setStyle("-fx-background-color:#212121");
        decodadorMenu(btn, paneIndicator);
       HBox hbox = new HBox(paneIndicator, btn, btn2);
       return hbox;
    }
    private void decodadorMenu(Button btn, Pane pane){
        btn.setOnMouseEntered(value -> {
            btn.setStyle("-fx-background-color: black");
            pane.setStyle("-fx-background-color: blue");
            
        });
        btn.setOnMouseExited(value -> {
            btn.setStyle("-fx-background-color: gray");
            pane.setStyle("-fx-background-color: #212121");
            
        });
        
    }
}
