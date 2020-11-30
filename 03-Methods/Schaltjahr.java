import java.util.Scanner;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Schaltjahr
// Dateiname    : Schaltjahr.java
// Autor        : Sascha Brägger
// Beschreibung : In dieser Aufgabe geht es darum eine Methode zu schreiben, 
//                die herausfinden kann, ob ein bestimmtes Jahr ein Schaltjahr ist. 
//                Die Instruktionen in der main-Methode sind zum testen dieser Methode
//                gedacht. Dabei wird die fehlende Methode mit verschiedenen Jahren aufgerufen: 
//                Einen Teil mit richtigen Schaltjahren und einen Teil mit falschen Schaltjahre.
// Erstellt     : 30.11.2020
// Version      : 1.0
//===============================================================================
public class Schaltjahr {

    public static void main(String[] args) {
        int[] test_richtig = { 1640, 1884, 2060, 1404, 2020, 1648, 2072, 1504 };
        int[] test_falsch = { 1700, 1800, 1900, 1402, 1406, 2018, 2294 };

        for (int i = 0; i < test_richtig.length; i++) {
            System.out.print("teste Schaltjahr " + test_richtig[i] + ": ");
            if (isLeapYear(test_richtig[i])) {
                System.out.println("richtig");
            } else {
                System.out.println("falsch");
            }
        }

        for (int i = 0; i < test_falsch.length; i++) {
            System.out.print("teste kein Schaltjahr " + test_falsch[i] + ": ");
            if (!isLeapYear(test_falsch[i])) {
                System.out.println("richtig");
            } else {
                System.out.println("falsch");
            }
        }
    }

    // Jahr wird in funktion übergeben
    private static boolean isLeapYear(int Jahr) {
        // ist schaltjahr wenn durch 4 aber nicht durch 100
        if (Jahr % 4 == 0 && Jahr % 100 != 0) {
            return true;
        }
        // ist schaltjahr wenn durch 4 und durch 100 und durch 400
        else if (Jahr % 4 == 0 && Jahr % 100 == 0 && Jahr % 400 == 0) {
            return true;
        } else
            return false;

    }

}
