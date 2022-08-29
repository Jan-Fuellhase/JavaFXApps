package org.fxapplications.sampleapplications;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//only works in folder which is asserted in pom -> javafx:compile,run

/**
 * @author Jan FÜllhase
 */
public class Eich extends Application {


    Scene scene;

    @Override
    public void start(Stage stage) {

        Button button = new Button("Ergebnis");
        Button buttonende = new Button("Beenden");
        button.setText("Ergebnis");
        buttonende.setText("Beenden");

        TextArea text = new TextArea();
        TextArea text1 = new TextArea();
        TextArea text2 = new TextArea();
        text2.setText("7");
//        text1.setText("12");
        Text texttext = new Text("Anzahl Tage");
        Text texttext1 = new Text("Erdnüsse pro Tag");


        //Buttons hinzufügen
        HBox box = new HBox(10);

        //am ende box und textarea hinzufügen
        GridPane grid = new GridPane();

//        text.setText("Ergebnis: ");

        button.setOnAction(b -> text1.setText("Erdnüsse verbraucht in " + text.getText() + " Tagen: " + (Integer.parseInt(text.getText())) * Integer.parseInt(text2.getText())));
        buttonende.setOnAction(b -> System.exit(0));

        box.getChildren().add(button);
        box.getChildren().add(buttonende);

        //bei grid kein getChildren() nur bei Box
        grid.add(box, 1, 1);
        grid.add(text, 1, 0);
        grid.add(text1, 1, 2);
        grid.add(text2, 2, 0);
        grid.add(texttext, 1, 0);
        grid.add(texttext1, 2, 0);


        stage.setTitle("Eichhörnchen");
        scene = new Scene(grid, 500, 400);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        //simply launches eichhörnchen application
        launch();
    }

}