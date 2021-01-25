package Testaufgaben;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Projektarbeit 01 Partygäste
// Dateiname    : Partygaeste.java
// Autor        : Sascha Brägger
// Beschreibung : Wie oft klingen die Gläser der Partygäste. Nach und nach betreten
//                die 20 Gäste den Ballsaal. Einer nach dem anderen. Nachdem der
//                der zweite Gast den Raum betritt, stossen die beiden Personen an.
//                Trifft der dritte Gast ein haben die anderen 2 leer und sie stossen
//                noch mal an und so weiter.
// Erstellt     : 07.11.2020
// Version      : 1.1
// Aenderungen  : Option Programmneustart hinzugefügt
//===============================================================================
import java.util.Scanner;

public class Partygaeste {

    static int Anz_Gaeste_Total = 0;
    static int Anz_Weingläser = 0;
    static boolean Stop = false; // Boolean zum beenden des Programms
    static int Total = 0; // Variable zum das Total der Anstösse auszugeben

    public static void main(String[] args) {

        do {

            // Einlesen der Gäste und Weingläser
            Scanner eingabe_1 = new Scanner(System.in);
            System.out.println("\n\n\n\nWie viel Gäste erwarten sie heute?:   ");
            Anz_Gaeste_Total = eingabe_1.nextInt();
            System.out.println("\n\n\nWie viele Weinglaeser sind vorhanden?: ");
            Anz_Weingläser = eingabe_1.nextInt();
            eingabe_1.close();

            // Falls 0 Gläser eingegeben werden, wird die Grundberechnung durchgefürt mit
            // der Anzahl Gäste die eingegeben wurde
            if (Anz_Weingläser == 0) {
                Berechnung_Basis();

                // Falls eine Zahl über 0 eingegeben wird, wird berechnet gemäss Aufgabe
            } else {
                // Berechnung 1
                Berechnung_Weinleute();
                // Berechnung 2
                Berechnung_Orangensaftleute();
            }

            // Ausgeben wie oft angestossen wurde wenn alle eingetroffen sind
            if (Anz_Weingläser != 0) {
                System.out.println("\n\nInsgesammt wird " + Total + " mal angestossen!!!\n\n");
            }

            // Option um das Programm nochmal durchzuspielen!
            System.out.println("Drücken sie die 1 für einen Neustart, oder eine andere Taste zum Beenden!");
            int bedingung = eingabe_1.nextInt();
            if (bedingung != 1) {
                Stop = true;

            }
        } while (Stop != true);
    }

    // Methode zur Grundberechung wie oft geklingelt wird
    public static void Berechnung_Basis() {
        int loesung = 0;
        int zwischenresultat = 1;
        int i = 1;
        for (i = 1; i <= Anz_Gaeste_Total; i++) {
            loesung += zwischenresultat * (zwischenresultat - 1) / 2;
            zwischenresultat++;

        }
        System.out.print("\n\n****************************************\n\n");
        System.out.printf("Es wird insgesammt " + loesung + " mal angestossen!!");
        System.out.print("\n\n****************************************\n\n");
    }

    // Methode zur Berechnung wie oft nur die Weinleute miteinander anstossen
    public static void Berechnung_Weinleute() {
        int loesung = 0;
        int zwischenresultat = 1;
        int i = 1;
        for (i = 1; i <= Anz_Weingläser; i++) {
            loesung += zwischenresultat * (zwischenresultat - 1) / 2;
            zwischenresultat++;

        }
        Total = loesung;
        System.out.print("\n\n****************************************\n\n");
        System.out.printf("Leute mit Weingläser stossen total " + loesung + " mal zusammen an!!");
        System.out.print("\n\n****************************************");
    }

    // Methode zur Berechnung wie of nur Orangensaftgläser zusammenstossen
    public static void Berechnung_Orangensaftleute() {
        int Anz_Gaeste_Orangensaft = Anz_Gaeste_Total - Anz_Weingläser;
        int loesung = 0;
        int zwischenresultat = 1;
        int i = 1;
        for (i = 1; i <= Anz_Gaeste_Orangensaft; i++) {
            loesung += zwischenresultat * (zwischenresultat - 1) / 2;
            zwischenresultat++;

        }
        Total += loesung;
        System.out.print("\n\n****************************************\n\n");
        System.out.printf("Leute mit Orangensaft stossen total " + loesung + " mal zusammen an!!");
        System.out.print("\n\n****************************************");
    }
}