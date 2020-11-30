import java.util.Scanner;
//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Fibonacci-Folge
// Dateiname    : Fibonacci_Folge.java
// Autor        : Sascha Brägger
// Beschreibung : Ausgabe einer bestimmte länge der Fibbonaci Folge
// Erstellt     : 30.11.2020
// Version      : 1.0
//===============================================================================

/**
 * Fibonacci-Folge
 */
public class Fibonacci_Folge {

    static int result = 0;
    static int zahl1 = 0;
    static int zahl2 = 1;
    static int resultat = 0;

    public static void main(String[] args) {

        System.out.println("Die wievielte Fibonaccizahl soll ausgegeben werden: ");
        Scanner scanner = new Scanner(System.in);
        result = scanner.nextInt();
        scanner.close();
        System.out.println("Resultat: " + fibonacci(zahl1, zahl2, resultat));
    }

    public static int fibonacci(int zahl1, int zahl2, int resultat) {

        if (result < 2) {
            if (result == 1) {
                resultat = result;
                return resultat;
            } else {
                resultat = result;
            }
        } else {
            for (int i = 2; i <= result; i++) {
                resultat = zahl1 + zahl2;
                zahl1 = zahl2;
                zahl2 = resultat;
            }
        }

        return resultat;

    }
}