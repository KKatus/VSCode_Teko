//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : HA Zeit−Umrechnung
// Dateiname    : Datenstrukturen_4.java
// Autor        : Sascha Brägger
// Beschreibung : Schreiben Sie ein Java-Programm, das die x- und y-Koordinaten
//                zweier Punkte einliest und den Abstand zwischen ihnen berechnet
//                und ausgibt. Hinweis: Die Ganzzahlige Wurzel einer Zahl n können 
//                Sie als (float)Math.sqrt(n) berechnen. Zeichnen Sie als Unterstützung
//                zuerst ein Flussdiagramm.
// Erstellt     : 02.11.2020
// Version      : 1.0
//===============================================================================

//Imports
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Datenstrukturen_6 {

    public static void main(String[] args) {
        // Deklarationen
        float X_Koordinate = 0.00000f;
        float Y_Koordinate = 0.00000f;
        float Zwischenresulatat1 = 0.0f;
        float Zwischenresulatat2 = 0.0f;

        // Einlesen der X-Koordinaten
        Scanner eingabe_x = new Scanner(System.in);
        System.out.print("\nX-Kordinate  : ");

        // Eingabe einer Variable zuweisen zum speichern
        // Eingabe wird vom Objekt zu FLoat konvertiert mittels nextFlaot
        X_Koordinate = eingabe_x.nextFloat();

        // Einlesen der Y-Koordinaten
        Scanner eingabe_y = new Scanner(System.in);
        System.out.print("\nY-Kordinate  : ");

        // Eingabe einer Variable zuweisen zum speichern
        // Eingabe wird vom Objekt zu FLoat konvertiert mittels nextFlaot
        Y_Koordinate = eingabe_y.nextFloat();

        // Umrechnung mit Pytaghoras Y-Achse
        // Y hoch 2 rechnen
        Zwischenresulatat1 = Y_Koordinate * Y_Koordinate;

        // Umrechnung mit Pytaghoras X-Achse
        // X hoch 2 rechnen
        Zwischenresulatat2 = X_Koordinate * X_Koordinate;

        // Lösung mit Abkürzung des Floats
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        // Ausgabe der Lösung
        System.out.print(df.format(Math.sqrt(Zwischenresulatat1 + Zwischenresulatat2)));
        // Scanner abschliessen
        eingabe_x.close();
        eingabe_y.close();
    }

}