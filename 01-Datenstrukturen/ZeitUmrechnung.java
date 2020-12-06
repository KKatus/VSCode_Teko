
//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : HA Zeit−Umrechnung
// Dateiname    : ZeitUmrechnung.java
// Autor        : Sascha Brägger
// Beschreibung : Umrechnung von Sekunden auf Tage, Stunden, Minuten und Sekunden.
// Erstellt     : 01.11.2020
// Version      : 1.0
//===============================================================================
import java.util.Scanner;

public class ZeitUmrechnung {

    public static void main(String[] args) {
        final int ENDE = -1;
        boolean ende = false;

        Scanner eingabe = new Scanner(System.in);

        do {
            System.out.print("\nSekunden  : ");
            int sekunden = eingabe.nextInt();
            if (sekunden > ENDE) {
                int tage = sekunden / (24 * 60 * 60);
                sekunden = sekunden % (24 * 60 * 60); // der Rest
                int stunden = sekunden / (60 * 60);
                sekunden = sekunden % (60 * 60); // der Rest
                int minuten = sekunden / 60;
                sekunden = sekunden % 60; // der Rest
                System.out.println("  Tage     = " + tage);
                System.out.println("  Stunden  = " + stunden);
                System.out.println("  Minuten  = " + minuten);
                System.out.println("  Sekunden = " + sekunden);
            } else {
                System.out.println("Good Bye.");
                ende = true;
            }
        } while (!ende);
        eingabe.close();
    }
}