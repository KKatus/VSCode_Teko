package Testaufgaben;

import java.util.Scanner;

public class Aufgabe_2 {
    public static void main(String[] args) {
        boolean check = false;
        boolean ende = false;
        double Kontostand = 0;
        System.out.println("Was wollen sie tun: ? \n");
        System.out.println("- (o) open\n- (i) increas \n- (d) decrease \n- (c) close\n - (e) Ende\n");
        Scanner scanner = new Scanner(System.in);

        do {
            switch (scanner.nextLine()) {
                case "o": {
                    check = true;
                    System.out.println("Konto geöffnet\n");
                    break;
                }
                case "i": {
                    if (check) {
                        Kontostand += 100;
                        System.out.println("Neuer Kontostand\n" + Kontostand);
                    }
                    break;
                }
                case "d": {
                    if (check) {
                        if (Kontostand >= 20) {
                            Kontostand -= 20;
                            System.out.println("Neuer Kontostand\n" + Kontostand);
                        } else {
                            System.out.println("Kontostand zu niedrig\n" + Kontostand);
                        }
                        break;
                    }
                    break;
                }
                case "c": {
                    check = false;
                    System.out.println("Konto geschlossen\n");
                }
                case "e": {
                    ende = true;
                }

            }
        } while (!ende);
        scanner.close();

    }

}
