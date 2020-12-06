package Programmstrukturen;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Äthiopisches rechnen
// Dateiname    : Praktikum2_Programmstrukturen
// Autor        : Sascha Brägger
// Beschreibung : Die Äthiopier hatten einen interessanten Weg gefunden, 
//                zwei grosse Zahlen miteinander zu multiplizieren. Zunächst
//                haben sie beiden Zahlen, die es zu multiplizieren galt, nebeneinander geschrieben, 
//                z.B.:17 x 34
//                Nun geht es aber etwas anders weiter, als wir das gewohnt sind. Die linke Zahl 
//                wird für jede darunterliegende Zeile halbiert, Nachkommastellen werden abgeschnitten. 
//                Die Rechte Zahl hingegen wird Zeile für Zeile verdoppelt. Dies wird so lange durchgeführt, bis die linke Zahl gleich 1 ist.
//
// Erstellt     : 14.11.2020
// Version      : 1.0
// Aenderungen  : keine
//===============================================================================

import java.io.IOException;
import java.util.Scanner;

public class Praktikum2 {

    public static void main(String[] args) throws IOException {
        Scanner eingabe = new Scanner(System.in);

        int resultat = 0;

        // Eingabe erste Zahl
        System.out.println("Geben sie die erste Zahl ein: ");
        int x = eingabe.nextInt();

        // Eingabe zweite Zahl
        System.out.println("Geben sie die zweite Zahl ein: ");
        int y = eingabe.nextInt();
        resultat = y;

        // Rechnung ausgeben
        System.out.println("\n" + x + "   *   " + y);

        while (x != 1) {
            x /= 2;
            y *= 2;

            if (x % 2 == 0) {
                System.out.println(x + " \t---");
            } else {
                System.out.println(x + " \t" + y);
                resultat = y + resultat;
            }
        }
        System.out.println("\t===");
        System.out.println("\t" + resultat);
        eingabe.close();
    }
}
