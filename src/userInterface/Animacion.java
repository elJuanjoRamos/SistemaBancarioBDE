/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.value.ObservableBooleanValue;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.Duration;

/**
 *
 * @author RamMack001
 */
public class Animacion {
       private static final Animacion AnimatedGridPane = new Animacion();
        private Animacion() {
        }
        
         public static Animacion getAnimatedGridPane() {
         return AnimatedGridPane;
        }
    
        
        public GridPane getAnimatedGridPane(GridPane gridPane){
        GridPane gridPanX = new GridPane();
        
        ColumnConstraints leftCol = new ColumnConstraints();
        leftCol.setPrefWidth(100);
        ColumnConstraints rightCol = new ColumnConstraints();
        rightCol.setPercentWidth(100);
        gridPanX.getColumnConstraints().addAll(leftCol, rightCol);
        ObservableBooleanValue expanded = leftCol.prefWidthProperty().greaterThan(0);

                KeyFrame start;
                KeyFrame end;
                
                if (expanded.get()) {
                    start = new KeyFrame(Duration.ZERO, new KeyValue(rightCol.prefWidthProperty(), 100));
                    end = new KeyFrame(Duration.millis(250), new KeyValue(leftCol.prefWidthProperty(), 0));
                } else {                    
                    start = new KeyFrame(Duration.ZERO, new KeyValue(rightCol.prefWidthProperty(), 0));
                    end = new KeyFrame(Duration.millis(250) ,new KeyValue(leftCol.prefWidthProperty(), 100));
                }     
                Timeline timeline = new Timeline(start, end);
                timeline.play();

        Node content = gridPane;
        HBox h = new HBox();
        h.setMinSize(150, 700);
        h.setVisible(true);
        h.setAlignment(Pos.TOP_RIGHT);
        
        gridPanX.add(h, 0,0);
        gridPanX.add(content, 1, 0);
        return gridPanX;
    }
    
}
