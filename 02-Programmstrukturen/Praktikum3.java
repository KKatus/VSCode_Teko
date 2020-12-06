package Programmstrukturen;

//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Arrays sortieren
// Dateiname    : Praktikum3
// Autor        : Sascha Brägger
// Beschreibung : Schreiben Sie ein Programm welches ein im Source-Code vorgegebenes Array nach der Grösse
//                sortiert. Dabei soll am Schluss der kleinste Wert im ersten Element und der grösste Wert im letzten
//                Element sein. Gehen Sie dabei wie folgt vor:
//
// Erstellt     : 
// Version      : 1.0
// Aenderungen  : keine
//===============================================================================

public class Praktikum3 {

    public static void main(String[] args) {

        // define original array
        int[] intArray = new int[] { 5, 3, 7, 6, 1, 10, 2, 14, 1 };
        int temp = 0;

        // print original array
        System.out.println("Original array: ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
        // Sort the array in ascending order using two for loops
        for (int i = 0; i < intArray.length; i++) {
            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[i] > intArray[j]) { // swap elements if not in order
                    temp = intArray[i];
                    intArray[i] = intArray[j];
                    intArray[j] = temp;
                }
            }
        }
        // print sorted array
        System.out.println("\nArray sorted in ascending order: ");
        for (int i = 0; i < intArray.length; i++) {
            System.out.print(intArray[i] + " ");
        }
    }
}
