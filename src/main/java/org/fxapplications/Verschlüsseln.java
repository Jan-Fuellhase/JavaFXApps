package org.fxapplications;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

/**
 * @author Jan FÜllhase
 * Verschlüsselung die nur Jan jochen und lucia lesen können, anhand von passwort oder sicherheitsfragen
 */
//only works in folder which is asserted in pom -> javafx:compile,run
public class Verschlüsseln extends Application {

    //todo: auswählbar welches textfeld
    static boolean passwortmode = false;
    static boolean adminmode = false;

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

    ScrollPane scrollPane = new ScrollPane();

    @Override
    public void start(Stage stage) {


        Button buttonverschlüsseln = new Button("Verschlüsseln");
        Button buttonentschlüsseln = new Button("Entschlüsseln");
        Button buttonsupport = new Button("Support");
        ToggleButton buttonpasswortmodus = new ToggleButton("Passwortmodus");
        buttonpasswortmodus.setEffect(new DropShadow());


//        buttonzeichen.setEffect(new DropShadow());

        buttonverschlüsseln.setOnAction(b -> {
            try {
                buttonhandler(text1.getText(),textfeld.getText(),textfeld2.getText(),1);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        buttonentschlüsseln.setOnAction(b -> {
            try {
                buttonhandler(text1.getText(),textfeld.getText(),textfeld2.getText(),2);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        buttonsupport.setOnAction(b -> ergebnistext.setText("--- Passwort darf nur Zahlen und Buchstaben enthalten! ---\n--- Felder leerlassen für programminternes Passwort. ---\n\njan.fuellhase@uni-ulm.de :)\n\n-JJLEncro V1.0-"));
        buttonsupport.setOnContextMenuRequested(i -> text1.setText(""));
        text1.setWrapText(true);
        ergebnistext.setEditable(false);
        ergebnistext.setWrapText(true);
        ergebnistext.setText("--- Passwort darf nur Zahlen und Buchstaben enthalten! ---\n--- Felder leerlassen für programminternes Passwort. ---       \n\n\n\n                                                       ¯\\_(ツ)_/¯");


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

        text1.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.ENTER) {
                try {
                    //invalid type, does nothing if not used for adminmode as console
                    buttonhandler(text1.getText(),textfeld.getText(),textfeld2.getText(),187);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (event.getCode() == KeyCode.F10) {
                try {
                    //invalid type, does nothing if not used for adminmode as console
                    buttonverschlüsseln.fire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (event.getCode() == KeyCode.F11) {
                try {
                    //invalid type, does nothing if not used for adminmode as console
                    buttonentschlüsseln.fire();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });



        //Buttons hinzufügen
        VBox box = new VBox(10);
        VBox box2 = new VBox(10);
        VBox boxpisscine = new VBox(10);

        box.getChildren().add(fragegeburtsort);
        box.getChildren().add(textfeld);
        box.getChildren().add(fragepasswort);
        box.getChildren().add(textfeld2);
        box.getChildren().add(buttonverschlüsseln);
        box.getChildren().add(buttonentschlüsseln);


        boxpisscine.getChildren().add(emptytext);
        boxpisscine.getChildren().add(buttonsupport);
        boxpisscine.getChildren().add(copyright);


        //am ende box und textarea hinzufügen
        GridPane grid = new GridPane();
        grid.setPadding(new Insets(5,5,5,5));
        grid.setBackground(new Background(new BackgroundFill(Color.rgb(0,90,70),CornerRadii.EMPTY,Insets.EMPTY)));


        grid.setHgap(3);
        grid.setVgap(3);
        grid.add(headline,0,1);
        grid.add(buttonpasswortmodus,1,1);
        grid.add(text1,0,2);
        grid.add(box,1,2);
//        grid.add(box2,2,2);
        grid.add(ergebnistext,0,3);
        //column = spalte
        grid.add(boxpisscine,1,3);
//        grid.setAlignment(Pos.TOP_LEFT);
//        stage.setAlwaysOnTop(true);

        stage.setTitle("Verschlüsseln und Entschlüsseln");
        scene = new Scene(grid,650,430);

        stage.setResizable(false);


        stage.setMinHeight(410);
        stage.setMinWidth(650);
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

    /**
     * Simplified encryption
     *
     * @param type 1==versch, 2 = entsch
     * @throws Exception
     */
    public static String buttonhandler(String ttext1,String ttextfeld1,String ttextfeld2,int type) throws Exception {
        ttextfeld1 = ttextfeld1.toLowerCase(Locale.ROOT);
        ttextfeld2 = ttextfeld2.toLowerCase(Locale.ROOT);

        //case felder leer
        if ((ttextfeld1).isBlank() || ttextfeld2.isBlank()) {
            ttextfeld1 = "ohbtet";
            ttextfeld2 = "hjbtsj";
        }

        System.out.println(ttextfeld1 + ttextfeld2);
        if (type == 1) {
            ergebnistext.setText(encryptRotation(ttext1,ttextfeld1 + ttextfeld2));
        }
        if (type == 2) {
//            decryptRotation(ttext1,ttextfeld1+ttextfeld2);
            ergebnistext.setText(decryptRotation(ttext1,ttextfeld1 + ttextfeld2));
        }
        //remove enter for console reasons
        if(type==187){
            ttext1=ttext1.replaceAll("\n","");
            System.out.println("Befehl "+ttext1+" ausgeführt");
        }
        //admin lernstoff commands ._.
        if (adminmode) {

            if ((ttext1.equals("dtd"))) {
                ergebnistext.setText(dtdtextsatz);
            }
            if ((ttext1.equals("xsd schreibt xml vor")) || ttext1.equals("xsd")) {
                ergebnistext.setText(xsdvsxmltextsatz);
            }
            if ((ttext1.equals("erd")) || ttext1.equals("ER Diagramm")) {
                ergebnistext.setText(erDiagrammtextsatz);
            }
            if ((ttext1.equals("threads")) || ttext1.equals("threads deadlocks")) {
                ergebnistext.setText(threadsdeadlockstextsatzbesser+threadsdeadlockstextsatz);
            }
            if ((ttext1.equals("generics"))) {
                ergebnistext.setText(genericstextsatz);
            }
            if ((ttext1.equals("streams"))) {
                ergebnistext.setText(inputstreamstextsatz);
            }
            //console reasons
            text1.setText("");

        }
        //special commands in text1, left big text

            if ((ttext1.equals("adminmode"))) {
                adminmode = true;
                ergebnistext.setText("ttextfeld1=\"ohbtet\"; ttextfeld2=\"hjbtsj\";");
                text1.setText("");
            }
            if ((ttext1.equals("info"))) {
                ergebnistext.setText("9 Walziger Enigma, anhand von hashcode.\nHashcode iteriert durch seine Ziffern und wälzt Zahl für Zahl.");
            }
            if ((ttext1.equals("help")) || ttext1.equals("commands")) {
                ergebnistext.setText("Commands: help, adminmode, info, exit, exit out, au revoir");
            }
            if ((ttext1.equals("exit")) || ttext1.equals("exit out") || text1.equals("au revoir")) {
                System.exit(0);
            }


        return null;
    }


    public static String encryptRotation(String strClearText,String strKey) throws Exception {
        int rot = 0;
        System.out.println(strKey.hashCode());
        String iter = String.valueOf(strKey.hashCode());
        var rotarray = iter.toCharArray();
        int j = 1;
        String out = "";
        for (int i = 0; i < strClearText.length(); i++) {

            //enigma
            //j muss hier immer 7 sein
            if (j >= 7) {
                j = 1;
            }
            rot = rotarray[j];
            j = j + 1;

            char c = strClearText.charAt(i);

            //encryption
            c += rot;              //Rotation um rot
//            if (c < 32)
//                c += (char) 125 - 32 + 1;               //verschlüsselungs umbruch, um die gesuchten 32-125 Zeichen einzuhalten

            System.out.print(c);            //buchstabe für buchstabe wird geprintet

            out += c;
        }
        return out;
    }

    public static String decryptRotation(String strEncrypted,String strKey) throws Exception {
        //char array hashcode
        int rot = 0;
        System.out.println(strKey.hashCode());
        String iter = String.valueOf(strKey.hashCode());
        var rotarray = iter.toCharArray();
        System.out.println(Arrays.toString(rotarray));

        int j = 1;
        String out = "";
        for (int i = 0; i < strEncrypted.length(); i++) {

            //enigma
            //j muss hier immer 7 sein
            if (j >= 7) {
                j = 1;
            }
            rot = rotarray[j];
            j = j + 1;


            char c = strEncrypted.charAt(i);

            //decryption
            c -= rot;              //Rotation um rot
//            if (c < 32)
//                c += (char) 125 - 32 + 1;               //verschlüsselungs umbruch, um die gesuchten 32-125 Zeichen einzuhalten

            System.out.print(c);            //buchstabe für buchstabe wird geprintet
            out += c;
        }
        return out;
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

    static String inputstreamstextsatz="\n" +
            "public static void bigInputscan() throws FileNotFoundException {\n" +
            "    Scanner scan = new Scanner(new FileInputStream(\"bigInput.txt\"));\n" +
            "    long sum = 0;\n" +
            "    while (scan.hasNextInt()) {\n" +
            "        sum += scan.nextInt();\n" +
            "    }\n" +
            "    System.out.println(\"Summe von BigInput: \"+sum);\n" +
            "}\n" +
            "\n" +
            "\n" +
            "/**\n" +
            " * @throws IOException\n" +
            " * sums up File with BufferedReader, prints out sum as int\n" +
            " */\n" +
            "public static void fasterbigInputscan() throws IOException {\n" +
            "    BufferedReader reader = new BufferedReader(new FileReader(\"bigInput.txt\"));\n" +
            "    long sum = 0;\n" +
            "    while(reader.ready()) {    //reader.readLine() == null does NOT work, reader.ready() works\n" +
            "        sum += Integer.parseInt(reader.readLine());\n" +
            "    }\n" +
            "    System.out.println(\"Summe von BigInput: \"+sum);\n" +
            "}\n";
    static String genericstextsatz="Für alle Arten von Variablen, verhindert wiederholenden code\n" +
            "\n" +
            "\n" +
            "Beispiel an einer List und dem Object Eagle aus Üb1\n" +
            "\tList<Eagle> aviary = new ArrayList<>(); // diese Liste nimmt NUR Objekte vom Typ Eagle auf\n" +
            "Anstelle von Eagle kann auch ein Fragezeichen super Eagle stehen. Das ist eine Wildcard, also ein unbekannter Typ\n" +
            "\tArrayList<? super Integer> numArrList = new ArrayList<>(); //? super Integer bedeuted: ein Typ der ein Integer oder sein supertype ist";

    static String threadsdeadlockstextsatzbesser="Deadlock:\n" +
            "Alle Prozesse warten bis anderer Prozess gemeinsam genutzte Ressource freigibt.\n" +
            "\n" +
            "\n" +
            "\n" +
            "Monitor:\n" +
            "while(locked);\n" +
            "locked = true;"+"Threads – Zugriff auf gemeinsame Ressourcen\n" +
            "Wichtig!\n" +
            "▪ Gemeinsame Ressourcen vermeiden\n" +
            "▪ Genau überlegen, wann welcher Thread welche Ressource benötigt\n" +
            "▪ Nicht wild mit synchronized um sich werfen\n" +
            "\n" +
            "\n" +
            "Threads – Probleme mit .stop()\n" +
            "▪ Thread wird einfach „abgeschossen“\n" +
            "▪ Inkonsistente Daten als Folge\n" +
            "▪ Sehr schwer zu debuggen\n" +
            "▪ Ist Deprecated ➔ nicht benutzen\n" +
            "\n" +
            "\n" +
            "\n" +
            " sleep(x)\n" +
            "• Bringt den Scheduler dazu den Thread für x Millisekunden nicht zu bearbeiten.\n" +
            "\n" +
            "▪ yield()\n" +
            "• Gibt dem Scheduler bescheid, dass der Thread pausiert werden kann, um andere Threads zu \n" +
            "bearbeiten.\n" +
            "\n" +
            "▪ wait()\n" +
            "• kann nur auf gesperrtem Objekt verwendet werden\n" +
            "• Hebt Sperre auf\n" +
            "• wartet bis anderer Thread notify() aufruft.\n" +
            "\n" +
            "▪ notify(), notifyAll()\n" +
            "• kann nur auf gesperrtem Objekt verwendet werden\n" +
            "• Weckt wartende(n) Thread(s) auf";

    static String threadsdeadlockstextsatz="Thread.stop()\n" +
            "\tIst deprecated, nicht benutzen, schießt thread nur ab\n" +
            "\t\n" +
            "Gemeinsame Ressourcen\n" +
            "\tGemeinsame Ressourcen so weit wie möglich minimieren\n" +
            "\tWer darf auf die gemeinsamen Ressourcen zugreifen?\n" +
            "\t\n" +
            "\t\n" +
            "Synchronized\n" +
            "\tSynchronisation von Methoden über sychronized Modifizierer \n" +
            "\tZugriffe auf Instanz werden von VM synchronisiert\n" +
            "\t\n" +
            "\t\n" +
            "aktives Warten\n" +
            "\tGuarded block: Threadabschnitt wartet auf etwas, \n" +
            "\t-> wait() wartet bis aufwecken durch notify() oder\n" +
            "\t\tInterrupt oder vorgegebene Zeit\n" +
            "\t\n" +
            "\tnotifyall() wird häufiger aufgerufen, da viele Objekte auf \n" +
            "\tdieselbe Ressource warten und gleichzeitig aufgeweckt werden\n" +
            "\t\n" +
            "Buffer, Puffer\n" +
            "\tsollte nicht selber implementiert werden -> java.util.concurrent\n" +
            "\t\n" +
            "Performance von Threads\n" +
            "\tgroße liste von boolschen Werten, trues sollen gezählt werden\n" +
            "\t\n" +
            "\tPvS-24-Threads2-1-waitNotify Ergebis? 1, 100 ,1000?";

    static String erDiagrammtextsatz = "Beziehungen durch beschriftete Striche\n" +
            "ER-Diagramm\n" +
            " Angabe der Kadinalitäten unter Benutzung der Unified Modeling Language.\n" +
            "\n" +
            "\n" +
            "Raute: Beziehung wie \"veranstaltet\"\n" +
            "Kreis: Attribut\n" +
            "Viereck: Entität\n" +
            "\n" +
            "\n" +
            "Als Tabelle geschrieben, Beziehungen zwischen Tabellenwerten:\n" +
            "        -jeder Entitätstyp bekommt eigene Tabelle\n" +
            "        -Beziehung wird durch wieder Benutzung der Schlüssel hergestellt\n" +
            "        \n" +
            "\n" +
            "\tIn Tabelle gespeichert. Keine Zeiger oder sonstiges.\n" +
            "        \n" +
            "\t\tZeile = Entität / Tupel genannt\n" +
            "\t\tSpalte = Attribut / Schlüssel\n";


    static String xsdvsxmltextsatz = "XML Schema - XSD\n" +
            "\tXSD ist in XML definiert\n" +
            "\tunterstützt mehr und komplexere Datentypen \t\n" +
            "\n" +
            "FÜllt Lücken von DTD\n" +
            "\tAnzahl Elemente in einem Kind Element\n" +
            "\tArt eines Strings in einem Element\n" +
            "\tBedeutung eines Elements\n" +
            "\t\n" +
            "Typ: simpleType und complexType\n" +
            "\t<xs:element name=\"author\" type=\"xs:string\"/>\n" +
            "\t\n" +
            "\tEntweder im Element, oder als name=\"typname\" und dann wie oben angeben\n" +
            "\t\n" +
            "\t<xs:simpleType> \n" +
            "\t...XXX\n" +
            "\t</xs:simpleType>\n" +
            "\n" +
            "Wertebereich\n" +
            "\tbei XXX zb. minInclusive oder minExclusive\n" +
            "\t<xs:minInclusive value=\"0\"> ==> mind. 0\n" +
            "\t\n" +
            "min/maxOccours bei Complextypes";


    static String dtdtextsatz = "Document Type Definition\n" +
            "    IST SCHWÄCHER ALS XSD!!!!\n" +
            "    ist nicht notwendig\n" +
            "    dient als Dokumentation/Beschreibung von XML-Dokumenten\n" +
            "    \n" +
            "    \n" +
            "Verweis auf DTD in XML\n" +
            "    <!DOCTYPE collection SYSTEM \"booklist.dtd\">\n" +
            "    <!DOCTYPE <Wurzelelement> SYSTEM/PUBLIC \"URI\">\n" +
            "    \n" +
            "    Inhalt von booklist.dtd\n" +
            "        <!ELEMENT collection (book+)> <!--book kann Kind element sein innerhalb collection, durch + markiert-->\n" +
            "        <!ELEMENT book (title, authorlist, description?)>  <!--kinder von book können title, al, d sein. Description ist hierbei optional durch ?-->\n" +
            "        <!ELEMENT title (#PCDATA)>  <!--title kann nur string sein-->\n" +
            "        \n" +
            "        \n" +
            "        \n" +
            "        <!ELEMENT <name> <Inhaltspez.>>  <!--Inhaltsspez. (#PCDATA) = beliebiger text -->\n" +
            "        \n" +
            "\t\tInhaltsspezifizierung:\n" +
            "        • beliebiger Text: (#PCDATA)\n" +
            "        • bestimmte Kinder: reguläre Ausdrücke\n" +
            "        • leere Elemente: EMPTY\n" +
            "        • beliebiger Inhalt: ANY\n" +
            "        • Text gemischt mit Tags: reg. Ausdruck mit #PCDATA"
            +"\n\nDTD: Validierung Abschnitt 2 (nach !ELEMENT)\n" +
            "\t  <!ATTLIST elem name type value>\n" +
            "\t  <!ATTLIST person name CDATA #REQUIRED>\n" +
            "\n" +
            "\ttype  =>  \t\tBeschreibung\n" +
            "\n" +
            "\tCDATA     \t\tcharacter data\n" +
            "\t(en1|en2|..) \t\tEnum\n" +
            "\tID \t\t\t\tunique ID\n" +
            "\tIDREF \t\t\tID von anderem Element\n" +
            "\t--------------------------------------\n" +
            "\tvalue =>\t\tBeschreibung\n" +
            "\n" +
            "\tvalue \t\t\tdefault Wert\n" +
            "\t#REQUIRED \t\tbenötigt\n" +
            "\t#IMPLIED \t\toptionel\n" +
            "\t#FIXED \t\t\tfester Wert";
}