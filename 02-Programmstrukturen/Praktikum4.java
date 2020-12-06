package Programmstrukturen;

import java.util.ArrayList;
import java.util.Scanner;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Primzahlen
// Dateiname    : Praktikum4
// Autor        : Sascha Brägger
// Beschreibung : Schreiben Sie ein Programm, dass die ersten n Primzahlen bestimmt und ausgibt. Den Wert für n
//                können Sie fest als Variable in Ihrem Code bestimmen.
//
// Erstellt     : 16.11.2020
// Version      : 1.0
// Aenderungen  : keine
//===============================================================================

public class Praktikum4 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Wiso zu welcher zahl sollen die Primzahlen ausgegeben werden?");
        int max = scanner.nextInt();
        scanner.close();
        // ArrayList erstellen mit boolean
        ArrayList<Boolean> resultate = aussieben(max);

        System.out.println("Primzahlen sind: ");
        for (int i = 0; i <= max - 1; i++) {
            if (resultate.get(i) == true && i > 1) {
                System.out.print(i + " ");
            }
        }
    }

    // Methode zum aussieben
    public static ArrayList<Boolean> aussieben(double max) {

        // Legt eine neue Liste an
        ArrayList<Boolean> zahlenListe = new ArrayList<Boolean>();

        // Füllt die neue Liste mit lauter true-Elementen
        for (int i = 0; i <= max; i++) {
            zahlenListe.add(i, true);
        }
        // 1 überspringen weil die Vervielfachung unten sonst nicht funktioniert
        for (int i = 2; i <= max; i++) {

            if (zahlenListe.get(i) == true) {
                int j = i;
                do {
                    // Vielfaches bilden um die zahl nicht versehentlich zu markieren
                    j = j + i;
                    if (j <= max) {
                        // Ist die Zahl ein Vielfaches einer
                        // Primzahl, dann wird sie mit false
                        // markiert
                        zahlenListe.set(j, false);
                    }
                } while (j <= max);
            }
        }
        // fertige Zahlenliste zurück geben
        return zahlenListe;
    }
}
