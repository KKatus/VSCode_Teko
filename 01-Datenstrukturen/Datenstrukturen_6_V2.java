//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : HA Zeit−Umrechnung
// Dateiname    : Datenstrukturen_6_V2.java
// Autor        : Sascha Brägger
// Beschreibung : Schreiben Sie ein Java-Programm, das die x- und y-Koordinaten
//                zweier Punkte einliest und den Abstand zwischen ihnen berechnet
//                und ausgibt. Hinweis: Die Ganzzahlige Wurzel einer Zahl n können 
//                Sie als (float)Math.sqrt(n) berechnen. Zeichnen Sie als Unterstützung
//                zuerst ein Flussdiagramm.
// Erstellt     : 02.11.2020
// Version      : 2.0
// Aenderungen  : keine
//===============================================================================

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Datenstrukturen_6_V2 {

    public static void main(String[] args) {

        // 0 = X von Punkt 1
        // 1 = Y von Punkt 1
        // 2 = X von Punkt 2
        // 3 = Y von Punkt 2
        int[] Koordinaten = new int[4];

        float Zwischenresultat_1;
        float Zwischenresultat_2;
        float Pytagoras;

        // Einlesen der Kordinaten
        Scanner eingabe_1 = new Scanner(System.in);
        System.out.print("Geben sie die Kordinaten X vom Punkt 1 ein:   ");
        Koordinaten[0] = eingabe_1.nextInt();
        System.out.print("Geben sie die Kordinaten Y vom Punkt 1 ein:   ");
        Koordinaten[1] = eingabe_1.nextInt();
        System.out.print("Geben sie die Kordinaten X vom Punkt 2 ein:   ");
        Koordinaten[2] = eingabe_1.nextInt();
        System.out.print("Geben sie die Kordinaten Y vom Punkt 2 ein:   ");
        Koordinaten[3] = eingabe_1.nextInt();
        eingabe_1.close();

        // Testausgabe des Arrays zur überprüfung
        for (int i = 0; i < Koordinaten.length; i++) {
            System.out.print(Koordinaten[i] + " ");
        }

        // Berechnung des Abstandes

        // Berechnung Abstand X Achse
        Zwischenresultat_1 = Koordinaten[2] - Koordinaten[0];
        // Berechnung Abstand Y Achse
        Zwischenresultat_2 = Koordinaten[3] - Koordinaten[1];
        // Pytagoras für Abstand
        Pytagoras = (float) Math
                .sqrt((Zwischenresultat_1 * Zwischenresultat_1) + (Zwischenresultat_2 * Zwischenresultat_2));

        // Abkürzung des Floats
        DecimalFormat df = new DecimalFormat("##.##");
        df.setRoundingMode(RoundingMode.DOWN);

        // Lösung ausgeben (Pytagoras)
        System.out.println("\n");
        System.out.print(df.format(Pytagoras));

    }
}