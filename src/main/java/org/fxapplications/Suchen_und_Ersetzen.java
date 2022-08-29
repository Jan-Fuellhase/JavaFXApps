package org.fxapplications;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.effect.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Jan Füllhase
 * Word Funktion Suchen und Ersetzen aber simpler
 */
//only works in folder which is asserted in pom -> javafx:compile,run
public class Suchen_und_Ersetzen extends Application {

    //todo: auswählbar welches textfeld
    static boolean ergebnistextmode = false;


    Scene scene;
    //for modifying in methods
    static Button buttontropfinmg = new Button("Anzahl Milligramm berechnen");
    static TextArea text1 = new TextArea();
    static TextArea text2 = new TextArea();
    static TextArea text3 = new TextArea();
    static TextArea ergebnistext = new TextArea();

    static TextField textfeld = new TextField();
    static TextField textfeld2 = new TextField();
    static TextField textfeld3 = new TextField();

    ScrollPane scrollPane = new ScrollPane();


    @Override
    public void start(Stage stage){

        Button buttonleer = new Button("Leerzeichen entfernen");
        Button buttonzeichen = new Button("Dieses Zeichen entfernen:");
        Button buttonersetzen = new Button("Ersetzen");
//        buttonzeichen.setEffect(new DropShadow());

        buttonleer.setOnAction(b-> buttonhandler(text1.getText(),0));
        buttonzeichen.setOnAction(b->buttonhandler(textfeld.getText(),1));
        buttonersetzen.setOnAction(b->buttonhandler(textfeld2.getText(),textfeld3.getText(),2));


        ergebnistext.setEditable(false);
        ergebnistext.setWrapText(true);
        ergebnistext.setText("         \n\n\n\n                                                       ¯\\_(ツ)_/¯");


//        text2.setText("");
//        ergebnistext.setText("12");

        Text copyright = new Text("                      © Jan Füllhase 2021");
        Text headline = new Text("Text eingeben:");
        Text diesentext = new Text("Diesen Text:");
        Text ersetzendurch = new Text("Ersetzen durch:");
        Text emptytext = new Text("\n\n\n\n\n\n\n\n");
        Text emptytext1 = new Text("\n\n\n\n\n\n");
        Text emptytext2 = new Text("");
        headline.setFont(new Font(16));
//        copyright.setTextAlignment(TextAlignment.JUSTIFY);


        BoxBlur blureffect = new BoxBlur();
        //Buttons hinzufügen
        VBox box = new VBox(10);
        VBox box2 = new VBox(10);
        VBox boxpisscine = new VBox(10);

        box.getChildren().add(buttonzeichen);
        box.getChildren().add(diesentext);
        box.getChildren().add(textfeld2);
        box.getChildren().add(ersetzendurch);
        box.getChildren().add(textfeld3);
        box.getChildren().add(buttonersetzen);


        box2.getChildren().add(textfeld);
        box2.getChildren().add(emptytext1);
        box2.getChildren().add(buttonleer);

        boxpisscine.getChildren().add(emptytext);

        boxpisscine.getChildren().add(copyright);





        //am ende box und textarea hinzufügen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5,5,5,5));
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(150,65,0),CornerRadii.EMPTY,Insets.EMPTY)));




        grid.setHgap(3);
        grid.setVgap(3);

        grid.add(headline,0,1);
        grid.add(text1,0,2);
        grid.add(box,1,2);
        grid.add(box2,2,2);
        grid.add(ergebnistext,0,3);
        //column = spalte
        grid.add(boxpisscine,2,3);
        grid.setAlignment(Pos.TOP_LEFT);

        stage.setAlwaysOnTop(true);

        stage.setTitle("Suchen und Ersetzen");
        scene = new Scene(grid, 720, 400);
        stage.setResizable(true);
        stage.setMinHeight(400);
        stage.setMinWidth(840);
        stage.setScene(scene);
        stage.show();

    }

    /**
     * @param text
     * @param type 0==leer, 1==dieses Zeichen, 2 = ersetzen
     * @return String
     */
    public static String buttonhandler(String text, int type){
        if(type == 0) {
            text1.setText(text1.getText().replaceAll(" ", ""));
            ergebnistext.setText(text1.getText().replaceAll(" ", ""));
        }
        if(type == 1) {
            if(text.equals("."))text="\\.";
            text1.setText(text1.getText().replaceAll(text, ""));
            ergebnistext.setText(text1.getText().replaceAll(text, ""));
        }


        return null;
    }
    public static String buttonhandler(String text,String text2, int type){
        if(type==2){
            text1.setText(text1.getText().replaceAll(text,text2));
            ergebnistext.setText(text1.getText().replaceAll(text,text2));
        }
        return null;
    }

    public static void main(String[] args) {
        //simply launches tropfen application
        launch();
    }

}