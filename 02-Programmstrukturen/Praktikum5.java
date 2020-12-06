package Programmstrukturen;

import java.util.Scanner;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : 
// Dateiname    : 
// Autor        : Sascha Brägger
// Beschreibung : 
//
//
//
// Erstellt     : 
// Version      : 1.0
// Aenderungen  : keine
//===============================================================================

public class Praktikum5 {

    public static void main(String[] args) {
        int quersumme = 0;
        int pruefziffer;
        int resultat;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Bitte geben sie die zuprüfende Serienummer ein:");
        char[] serienummer = scanner.nextLine().toCharArray();
        if (serienummer[0] == 'S') {
            for (int i = 1; i <= 11; i++) {
                quersumme += Character.getNumericValue(serienummer[i]);
            }
            quersumme += 10;
            int rest = quersumme % 9;
            if (8 - rest == 0) {
                pruefziffer = 9;

            } else {
                pruefziffer = 8 - rest;
            }
            resultat = Character.getNumericValue(serienummer[11]);
            if (resultat == pruefziffer) {
                System.out.println("Ihre Serienummer ist korrekt");

            } else {
                System.out.println("Ihre Serienummer ist falsch");
            }

        }

    }
}
