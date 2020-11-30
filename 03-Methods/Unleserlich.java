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
            System.out.println(funktion1(testValues[i]));
        }
    }

    // int a is the value from the array[i]
    public static int funktion1(int Wert_Array) {
        int b = 1;
        if (Wert_Array <= 1) {
            if (Wert_Array == 1) {
                return b;
            } else {
                b = addPlusOne(Wert_Array - 1);
            }
        } else {
            return function2(Wert_Array); // function allways jumps right in
                                          // here
        }
        return b;
    }

    public static int addPlusOne(int Wert_Array) {
        return ++Wert_Array;
    }

    public static int function2(int Wert_Array) {
        int container = funktion1(Wert_Array - 1); // wird bis auf 1 gerechnet
        return container + funktion1(Wert_Array - 2);
    }
}
