package Testaufgaben;

import java.util.Scanner;

/**
 * Aufgabe_1 Prüfung Java Programmieren
 */
public class Aufgabe_1 {

    public static void main(String[] args) {
        boolean ende = false;
        Scanner scanner = new Scanner(System.in);
        int Kordinate_Y = 0;
        int Kordinate_X = 0;

        do {
            System.out.println("Richtungsmöglichkeiten: (l) Links, (r) Rechts, (u) Up, (d) Down \n");
            System.out.println("In welche Richtung wollen sie gehen? \n");
            switch (scanner.nextLine()) {
                case "l":
                    Kordinate_X--;
                    System.out.println("\nKordinaten X: " + Kordinate_X);
                    System.out.println("\nKordinaten Y: " + Kordinate_Y + "\n");
                    break;

                case "r":
                    Kordinate_X++;
                    System.out.println("\nKordinaten X: " + Kordinate_X);
                    System.out.println("\nKordinaten Y: " + Kordinate_Y + "\n");
                    break;
                case "u":
                    Kordinate_Y++;
                    System.out.println("\nKordinaten X: " + Kordinate_X);
                    System.out.println("\nKordinaten Y: " + Kordinate_Y + "\n");
                    break;
                case "d":
                    Kordinate_Y--;
                    System.out.println("\nKordinaten X: " + Kordinate_X);
                    System.out.println("\nKordinaten Y: " + Kordinate_Y + "\n");
                    break;
                case "e": {
                    ende = true;
                }
                    break;

                default:
                    break;
            }

        } while (!ende);
        scanner.close();
    }

}