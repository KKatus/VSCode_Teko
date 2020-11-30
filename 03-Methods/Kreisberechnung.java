import java.util.Scanner;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Kreisberechnung
// Dateiname    : Kreisberechnung.java
// Autor        : Sascha Brägger
// Beschreibung : Testet ob ein Punkt in einem Kreis liegt
// Erstellt     : 30.11.2020
// Version      : 1.0
//===============================================================================
public class Kreisberechnung {

    public static void main(String[] args) {

        double resultat;
        System.out.println("Wie gross ist der Radius: ");
        Scanner scanner = new Scanner(System.in);
        double radius = scanner.nextDouble();
        System.out.println("Geben sie den X Wert ein: ");
        double x = scanner.nextDouble();
        System.out.println("Geben sie den Y Wert ein: ");
        double y = scanner.nextDouble();

        resultat = Math.sqrt((x * x) + (y * y));
        if (resultat < radius) {
            System.out.println("Richtig");
        } else if (resultat == radius) {
            System.out.println("Auf dem Rand");
        } else if (resultat > radius) {
            System.out.println("Falsch");
        }
        scanner.close();

    }
}