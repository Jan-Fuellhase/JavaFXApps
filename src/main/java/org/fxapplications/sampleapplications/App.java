package org.fxapplications.sampleapplications;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * JavaFX App
 *        //run by clicking Maven -> projects -> javafx -> compile then run :)
 *        or set this as Maven Goal
 */
public class App extends Application {

    ComboBox<String> combobox;
    ToggleGroup toggleGroup;
    Stage window;
    Scene scene;
    Button button;

    @Override
    public void start(Stage stage) {
//        var javaVersion = SystemInfo.javaVersion();
//        var javafxVersion = SystemInfo.javafxVersion();
//
//        var label = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
//        var scene = new Scene(new StackPane(label), 640, 480);
//
//        stage.setScene(scene);
//        stage.show();

        window = stage;
        window.setTitle("ComboBox ist cool");
        button = new Button("Apply");

        combobox = new ComboBox<>();
        combobox.setPromptText("choose Colour");
        combobox.getItems().addAll(
            "RED",
                "BLUE",
                "GREEN"
        );

        //1b
        toggleGroup = new ToggleGroup();
        RadioButton radioButtonr = new RadioButton("RED");
        RadioButton radioButtonb = new RadioButton("BLUE");
        RadioButton radioButtong = new RadioButton("GREEN");
        radioButtonr.setToggleGroup(toggleGroup);
        radioButtonb.setToggleGroup(toggleGroup);
        radioButtong.setToggleGroup(toggleGroup);

        //window
        VBox layout= new VBox(10);
        layout.setPadding(new Insets(20,20,20,20));
        layout.getChildren().addAll(combobox, button,radioButtonb,radioButtong,radioButtonr);


        //Farbe wählen, combobox.setOnAction wäre die aufgabe, das mag ich aber nicht :)
        button.setOnAction(BLUE ->
                layout.setBackground(choosecolour(combobox.getValue()))
                );

        //radio colors
        radioButtonb.setOnAction(b ->
                layout.setBackground(new Background(new BackgroundFill(Color.rgb(1,1,250),CornerRadii.EMPTY,Insets.EMPTY)))
        );radioButtong.setOnAction(b ->
                layout.setBackground(new Background(new BackgroundFill(Color.rgb(1,111,1),CornerRadii.EMPTY,Insets.EMPTY)))
        );radioButtonr.setOnAction(b ->
                layout.setBackground(new Background(new BackgroundFill(Color.rgb(111,1,1),CornerRadii.EMPTY,Insets.EMPTY)))
        );

        scene = new Scene(layout,300,250);

        window.setScene(scene);
        window.show();


    }

    public static void main(String[] args) {
        launch();
    }


    /**
     * @param string colour
     * @return background, for Vbox
     */
    Background choosecolour(String string){

        if(string.equals("GREEN")) {
            var out = new Background(new BackgroundFill(Color.rgb(1,250,1),CornerRadii.EMPTY,Insets.EMPTY));
            return out;
        }
        if(string.equals("RED")) {
            var out = new Background(new BackgroundFill(Color.rgb(250,1,1),CornerRadii.EMPTY,Insets.EMPTY));
            return out;
        }
        if(string.equals("BLUE")) {
            var out = new Background(new BackgroundFill(Color.rgb(1,1,250),CornerRadii.EMPTY,Insets.EMPTY));
            return out;
        }
        return null;
    }
}