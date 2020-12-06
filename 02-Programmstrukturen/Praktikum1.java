package Programmstrukturen;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Das Kleine 1 x 1
// Dateiname    : Praktikum_Programmstrukturen
// Autor        : Sascha Brägger
// Beschreibung : Schreiben Sie ein Programm, welches das „kleine Einmaleins“ ausgibt. 
//                Hierbei müssen zwei verschachtelte Schleifen verwendet werden 
//                (also eine Schleife innerhalb eines Blocks einer anderenSchleife)
//
// Erstellt     : 14.11.2020
// Version      : 1.0
// Aenderungen  : keine
//===============================================================================

import java.io.IOException;
import java.util.Scanner;

public class Praktikum1 {

    public static void main(String[] args) throws IOException {
        // Einlesen der Eingabe
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n*******************************************************\n");
        System.out.println("Bitte wählen sie eine Methode um das 1 x 1 darzustellen");
        System.out.println("\n*******************************************************\n");
        System.out.println("\n(1) ----- Einfache Methode von Sascha\n");
        System.out.println("\n(2) ----- Schwierige Methode\n: ");
        switch (scanner.nextInt()) {
            case 1: {
                clearScreen();
                System.out.println("Das 1 x 1 einfach programiert:\n");
                Einfache_Methode();
            }
                break;
            case 2: {
                clearScreen();
                System.out.println("Das 1 x 1 kompliziert programiert:\n");
                Schwierige_Methode();
            }
                break;

            default:
                break;
        }
        scanner.close();
    }

    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void Einfache_Methode() {

        int x = 1;
        int y = 1;
        int resultat = 0;

        for (int i = 1; i <= 100; i++) {
            if (x > 10) {
                x = 1;
                y++;
                System.out.println("\n-----------------------");
            }
            resultat = x * y;
            System.out.println(x + " * " + y + " = " + resultat);
            x++;
        }
    }

    public static void Schwierige_Methode() {
        int x = 1;
        int y = 0;
        for (int k = 1; k <= 10; k++) {
            y++;
            x = 1;
            System.out.println("\n-----------------------");
            for (int j = 1; j <= 10; j++) {
                System.out.println(x + " * " + y + " = " + (x * y));
                x++;
            }

        }

    }

}
