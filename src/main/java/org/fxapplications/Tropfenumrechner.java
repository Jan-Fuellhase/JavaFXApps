package org.fxapplications;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author Jan Füllhase
 * Milliliter, Wie viel Tropfen ein milliliter?, Milligram
 */
//only works in folder which is asserted in pom -> javafx:compile,run
public class Tropfenumrechner extends Application {



    Scene scene;
    //for modifying in methods
    static Button buttontropfinmg = new Button("Anzahl Milligramm berechnen");
    static TextArea text1 = new TextArea();
    static TextArea text2 = new TextArea();
    static TextArea text3 = new TextArea();
    static TextArea ergebnistext = new TextArea();


    @Override
    public void start(Stage stage){

        Button buttonmgintropf = new Button("Anzahl Tropfen berechnen");
        Button buttonende = new Button("Beenden");

        Button buttonsupport = new Button("Support");
        Button buttonplus = new Button("+") ;
        Button buttonminus = new Button("-") ;




        ergebnistext.setEditable(false);
        ergebnistext.setWrapText(true);
        ergebnistext.setText("         ¯\\_(ツ)_/¯");
        ergebnistext.setFont(new Font(21));




//        text2.setText("");
//        ergebnistext.setText("12");

        Text copyright = new Text("                         © Dr. Jochen Füllhase 2021");
        Text tropfenin1ml = new Text("Wie viel Tropfen sind 1ml?");
        Text mgin1ml = new Text("Wie viel mg sind in 1ml drin?      ");
        Text verschriebenemg = new Text("Wie viel mg sind verschrieben?");
        tropfenin1ml.setFont(new Font(16));
        mgin1ml.setFont(new Font(16));
        verschriebenemg.setFont(new Font(16));


        //Buttons hinzufügen
        VBox box = new VBox(10);
        HBox box2 = new HBox(10);

        //am ende box und textarea hinzufügen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5,5,0,5));
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(150,65,0),CornerRadii.EMPTY,Insets.EMPTY)));


        buttonmgintropf.setOnAction(b -> ergebnistext.setText("Benötigte Tropfen bei "+ text3.getText()+" mg: " + ((Double.parseDouble(text3.getText()) / Double.parseDouble(text2.getText()))* Double.parseDouble(text1.getText())))  );
        buttonende.setOnAction(b -> System.exit(0));
        buttonsupport.setOnAction(b -> ergebnistext.setText("jan.fuellhase\n@uni-ulm.de\n\n-Version Orange 2.0-"));
        buttonplus.setOnAction(b-> text3.setText(buttonhandler(text3.getText(),1)));
        buttonminus.setOnAction(b-> text3.setText(buttonhandler(text3.getText(),2)));


        box.getChildren().add(buttonmgintropf);
        box.getChildren().add(buttonplus);
        box.getChildren().add(buttonminus);
        box2.getChildren().add(buttonende);
        box2.getChildren().add(buttonsupport);


        //bei grid kein getChildren() nur bei Box
//        box.getChildren().add(buttonende);
        grid.setHgap(3);
        grid.setVgap(3);
        grid.add(box,2,2);
//        grid.add(box2,2,1);

        grid.add(text1,1,1);
        grid.add(ergebnistext,1,2);
        grid.add(text2,2,1);
        grid.add(text3,3,1);
        grid.add(tropfenin1ml,1,0);
        grid.add(mgin1ml,2,0);
        grid.add(verschriebenemg,3,0);
        grid.add(box2,3,2);
        grid.add(copyright,3,3);

        stage.setAlwaysOnTop(true);

        stage.setTitle("Tropfenumrechner");
        scene = new Scene(grid, 700, 400);
        stage.setResizable(false);
        stage.setMinHeight(400);
        stage.setMinWidth(700);
        stage.setScene(scene);
        stage.show();

    }

    public static String buttonhandler(String text, int type){
        if(text.isBlank()){return "0";}
        if(text1.getText().isBlank() || text2.getText().isBlank()){text1.setText("0");text2.setText("0");}
        if (type == 1) {
            String out = String.valueOf(Double.parseDouble(text)+1);
            ergebnistext.setText("Benötigte Tropfen bei "+(Double.parseDouble(text3.getText())+1)+" mg: " + (((Double.parseDouble(text3.getText())+1) / Double.parseDouble(text2.getText()))* Double.parseDouble(text1.getText())));
            return out;}
        // 2 = minus
        if (type == 2) {
            String out = String.valueOf(Double.parseDouble(text)-1);
            if((Double.parseDouble(text)-1) < 0) {return "0";}
            ergebnistext.setText("Benötigte Tropfen bei "+(Double.parseDouble(text3.getText())-1)+" mg: " + (((Double.parseDouble(text3.getText())-1) / Double.parseDouble(text2.getText()))* Double.parseDouble(text1.getText())));
            return out;
        }

        return null;
    }

    public static void main(String[] args) {
        //simply launches tropfen application
        launch();
    }

}