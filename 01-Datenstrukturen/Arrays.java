//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Uebung_Array
// Dateiname    : Arrays.java
// Autor        : Sascha Brägger
// Beschreibung : Spielerei mit Arrays
// Erstellt     : 02.11.2020
// Version      : 1.0
//===============================================================================

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {

        Scanner eingabe = new Scanner(System.in);

        // Definition des Arrays incl. Initialisierung:
        int[] array = { 1, 2, 3, 4, 5, 6 };
        eingabe.close();
        // Ausgabe des Arrays auf die Konsole:
        System.out.println("Ausgabe des Arrays:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        // Einlesen von neuen Werten für den Array:
        System.out.println("Einlesen des Arrays:");
        int zahl = 0;
        for (int i = 0; i < array.length; i++) {
            System.out.print("Zahl fuer Index [" + i + "] : ");
            zahl = eingabe.nextInt();
            array[i] = zahl;
        }

        // Ausgabe des Arrays auf die Konsole:
        System.out.println("Ausgabe des Arrays:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        // Vertauschen der Werte innerhalb des Arrays:
        for (int i = 0; i < array.length / 2; i++) {
            int buffer = array[i];
            array[i] = array[array.length - 1 - i];
            array[array.length - 1 - i] = buffer;
        }

        // Ausgabe des Arrays auf die Konsole:
        System.out.println("Ausgabe des gedrehten Arrays:");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }

}

/*
 * Session-Log:
 * 
 * Ausgabe des Arrays: 1 2 3 4 5 6 Einlesen des Arrays: Zahl fuer Index [0] : 11
 * Zahl fuer Index [1] : 22 Zahl fuer Index [2] : 33 Zahl fuer Index [3] : 44
 * Zahl fuer Index [4] : 55 Zahl fuer Index [5] : 66 Ausgabe des Arrays: 11 22
 * 33 44 55 66 Ausgabe des gedrehten Arrays: 66 55 44 33 22 11
 * 
 */
