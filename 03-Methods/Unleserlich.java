//===============================================================================
// Projekt      : TEKO WISE Semester 3
// Titel        : Unleserlich
// Dateiname    : Unleserlich.java
// Autor        : Sascha Brägger
// Beschreibung : Ein vorgegebenes Program ist sehr unleserlich. Es soll verständlich, schön und leserlich gemacht werden. 
//                Implementieren sie Kommentare. Die detallierte Aufgabe befindet sich im Teams unter 03-Methoden Praktikum.
// Erstellt     : 30.11.2020
// Version      : 1.0
// Notizen      : Der erste Output an der Konsole war  5, 55, 610, 6765, 832040, 102334155        
//===============================================================================

public class Unleserlich {
    public static void main(String args[]) {
        int[] testValues = { 5, 10, 15, 20, 30, 40 };
        for (int i = 0; i < testValues.length; ++i) {
            System.out.println(fibonacci(testValues[i]));
        }

    }

    // int a is the value from the array[i]
    public static int fibonacci(int Wert_Array) {
        if (Wert_Array <= 1) {
            if (Wert_Array == 1) {
                return Wert_Array;
            }
            return Wert_Array;

        } else {
            return fibonacci(Wert_Array - 1) + fibonacci(Wert_Array - 2);
        }

    }

}
