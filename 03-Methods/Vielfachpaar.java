//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Vielfachpaar
// Dateiname    : Vielfachpaar.java
// Autor        : Sascha Brägger
// Beschreibung : Schreiben Sie eine Methode die als Parameter ein Array mit Integern und einen einzelnen
//                Integer aufnehmen. Ihre Methode soll daraufhin testen, ob der einzelne Integerwert durch
//                alle Integer im Array ohne Rest geteilt werden kann und entsprechen true oder false zurück
//                geben.
// Erstellt     : 07.12.2020
// Version      : 1.0
//===============================================================================
public class Vielfachpaar {

    public static void main(String[] args) {
        int[] array = { 2, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
        int number = 1;
        checkDevideTrue(array, number);

    }

    public static boolean checkDevideTrue(int array[], int number) {
        // boolean boolean_state = false; // boolean storage
        int correct_divisions = 0;
        // i need a generator
        while (correct_divisions < 10) {

            for (int i = 0; i < array.length; i++) {
                if (number % array[i] != 0) {
                    correct_divisions = 0;
                    break;
                } else {
                    correct_divisions++;
                }
            }
            number++;
        }
        System.out.println(number - 1);
        return true;
    }
}