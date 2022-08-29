package org.fxapplications;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Scanner;

/**
 * @author Jan Füllhase
 * Yi Jing - unfinished doctors application for medizine organisation
 */
//only works in folder which is asserted in pom -> javafx:compile,run
public class Yi_Jing extends Application {

    //todo: auswählbar welches textfeld
    static boolean passwortmode = false;

    Scene scene;
    //for modifying in methods
    static Button buttontropfinmg = new Button("Anzahl Milligramm berechnen");
    static TextArea text1 = new TextArea();
    static TextArea text2 = new TextArea();
    static TextArea text3 = new TextArea();
    static TextArea ergebnistext = new TextArea();

    static Text fragegeburtsort = null;
    static Text fragepasswort = null;

    static TextField textfeld = new TextField();
    static TextField textfeld2 = new TextField();
    static TextField textfeld3 = new TextField();




    @Override
    public void start(Stage stage) {


        Button button1 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━1");
        Button button2 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━2");
        Button button3 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━3");
        Button button4 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━4");
        Button button5 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━5");
        Button button6 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━6");
        Button button7 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━7");
        Button button8 = new Button("━━━━━━━━━\n━━━          ━━━\n━━━━━━━━━8");

        button7.setOnAction(c-> ergebnistext.setText(" DROGEN "));

        Button buttonsupport = new Button("Support");
        ToggleButton buttonpasswortmodus = new ToggleButton("Passwortmodus");
        button1.setWrapText(true);
        buttonpasswortmodus.setEffect(new DropShadow());

        text1.setWrapText(true);
        ergebnistext.setEditable(false);
        ergebnistext.setWrapText(true);
        ergebnistext.setText("¯\\_(ツ)_/¯");


//        text2.setText("");
//        ergebnistext.setText("12");

        Text copyright = new Text("                      © Jan Füllhase 2021");
        Text headline = new Text("Text eingeben:");
        fragegeburtsort = new Text("Jans Geburtsort:");
        fragepasswort = new Text("8 Zeichen Passwort:");
        Text emptytext = new Text("\n\n\n\n\n\n\n");
        Text emptytext1 = new Text("\n\n\n\n\n\n");
        Text emptytext2 = new Text("");
        headline.setFont(new Font(16));
        fragegeburtsort.setFont(new Font(16));
        fragepasswort.setFont(new Font(16));
//        copyright.setTextAlignment(TextAlignment.JUSTIFY);

        passwortvisible(false,false);
        buttonpasswortmodus.setOnAction(b -> passwortvisible(true,true));


        HBox finalbox = new HBox(10);
        //Buttons hinzufügen
        VBox box = new VBox(10);
        VBox box2 = new VBox(10);
        VBox boxpisscine = new VBox(10);

        box.getChildren().add(fragegeburtsort);


        boxpisscine.getChildren().add(emptytext);
        boxpisscine.getChildren().add(buttonsupport);
        boxpisscine.getChildren().add(copyright);


        //am ende box und textarea hinzufügen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5,5,5,5));
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(0,90,70),CornerRadii.EMPTY,Insets.EMPTY)));


        grid.setHgap(3);
        grid.setVgap(3);



        grid.add(button2,1,2);
        grid.add(button3,1,3);
        grid.add(button4,1,4);

        grid.add(button1,2,5);

        grid.add(button5,2,1);


        grid.add(button6,3,2);
        grid.add(button7,3,3);
        grid.add(button8,3,4);

        finalbox.getChildren().add(grid);
        finalbox.getChildren().add(ergebnistext);

        stage.setTitle("Yi Jing");
        scene = new Scene(finalbox,800,430);

        stage.setMaximized(true);

//
//
//        stage.setMinHeight(410);
//        stage.setMinWidth(650);
        stage.setScene(scene);
        stage.show();

    }

    private void passwortvisible(boolean visible, boolean b) {
        if (b) {
            visible = passwortmode;
            ergebnistext.setText("Passwortmodus ist nichts für DAUs!\nNur Zahlen und Buchstaben!");
        }
        if (!visible) {
            textfeld.setText("");
            textfeld2.setText("");
        }
        textfeld.setVisible(visible);
        textfeld2.setVisible(visible);
        fragegeburtsort.setVisible(visible);
        fragepasswort.setVisible(visible);
        passwortmode = !passwortmode;
    }


    public static String scanner(String ausgabe) {
        Scanner scan = new Scanner(text1.getText());          //eingabe

//        System.out.print(ausgabe + ": ");
        String out = scan.nextLine();
        return out;
    }

    public static void main(String[] args) {
        //simply launches tropfen application
        launch();
    }


}