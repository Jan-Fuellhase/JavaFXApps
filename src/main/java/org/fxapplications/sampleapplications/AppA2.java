package org.fxapplications.sampleapplications;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;

/**
 * JavaFX App
 *        //run by clicking Maven -> projects -> javafx -> compile then run :)
 *        or set this as Maven Goal
 */
public class AppA2 extends Application {

    ComboBox<String> combobox;
    ToggleGroup toggleGroup;
    Stage window;
    Scene scene;
    Button button;
    Button button2;
    Button button3;
    TextArea textArea;

    @Override
    public void start(Stage stage) {
        var label = new Label("Made by Jan");

        //Fenster
        window = stage;
        window.setTitle("ComboBox is cool");
        button = new Button("OK");

        button2 = new Button("Knopf");
        button3 = new Button("Close");

        textArea = new TextArea();
        textArea.setWrapText(true);
        textArea.setEditable(false);
        textArea.setPromptText("Welcome");
        

        //window layout
        VBox layout= new VBox(10);
        layout.setPadding(new Insets(20,20,50,20));
        layout.getChildren().addAll(button,button2,button3,textArea,label);


        //actions
        button.setOnMouseClicked(BLUE ->
                textArea.appendText("clicked, ")



        );
        button.setOnMouseReleased(BLUE ->
                textArea.appendText("released, ")

        );
        button.setOnMousePressed(BLUE ->
                textArea.appendText("pressed, ")

        );
        button.setOnMouseEntered(BLUE ->
                textArea.appendText("entered, ")

        );
        button.setOnMouseExited(BLUE ->
                textArea.appendText("exited, ")

        );

        button2.setOnMouseEntered(new EventHandler<MouseEvent>(){

                  @Override
                  public void handle(MouseEvent mouseEvent) {
                      //position, use getX for position on the mouse event
                      button2.setText(String.valueOf(mouseEvent.getScreenX())+"  "+ String.valueOf(mouseEvent.getScreenY()));
                  }

              }
        );
        button2.setOnMouseExited(new EventHandler<MouseEvent>(){

                  @Override
                  public void handle(MouseEvent mouseEvent) {
                      //position, use getX for position on the mouse event
                      button2.setText("Knopf");
                  }

              }
        );

        //easteregg
        button2.setOnMouseClicked(new EventHandler<MouseEvent>(){

                  @Override
                  public void handle(MouseEvent mouseEvent) {
                      //position, use getX for position on the mouse event
                      textArea.appendText(String.valueOf(mouseEvent.getScreenX())+"  "+ String.valueOf(mouseEvent.getScreenY()) +"  ");
                  }

              }
        );
        button3.setOnMouseClicked(BLUE ->
                System.exit(0)
        );

        scene = new Scene(layout,300,250);

        window.setScene(scene);
        window.show();


    }

    public static void main(String[] args) {
        launch();
    }

}