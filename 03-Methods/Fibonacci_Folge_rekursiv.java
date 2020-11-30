import java.util.Scanner;
//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Fibonacci-Folge Rekursiv
// Dateiname    : Fibonacci_Folge_rekursiv.java
// Autor        : Sascha Brägger
// Beschreibung : Ausgabe einer bestimmte länge der Fibbonaci Folge
// Erstellt     : 30.11.2020
// Version      : 1.0
//===============================================================================

/**
 * Fibonacci-Folge
 */
public class Fibonacci_Folge_rekursiv {

    static int n = 3;

    public static void main(String[] args) {

        System.out.println("Die wievielte Fibonaccizahl soll ausgegeben werden: ");
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        scanner.close();
        System.out.println("Resultat: " + fibonacci(n));
    }

    // fib(n) = fib(n-1) + fib(n-2) mit fib(1) = fib(2) = 1
    public static int fibonacci(int n) {

        if (n == 1 || n == 2) {
            return 1;
        } else
            return fibonacci(n - 1) + fibonacci(n - 2);

    }
}