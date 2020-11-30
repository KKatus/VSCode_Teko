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
            System.out.println(doSomethingClever(testValues[i]));
        }
    }

    // int a is the value from the array[i]
    public static int doSomethingClever(int a) {
        int b;
        // a <= is never happening with the given test numbers, so you dont need this
        // condition
        if (a <= 1) {
            if (a == 1) {
                b = calcSomethingNice(a);
            } else {
                b = getSomeSmartInt(a - 1);
            }
        } else {
            return theSmartestMethodsAlwaysNeedRidiculouslyLongNames(a); // function allways jumps right in here
        }
        return b; // b is not used at all and can be deleted
    }

    // this method is not used at all and can be deleted
    public static int getSomeSmartInt(int c) {
        return ++c;
    }

    // this method is not used at all and can be deleted
    public static int calcSomethingNice(int d) {
        int i = 1;
        for (i = d * 11; i > d; i--) {
            i--;
        }
        return i;
    }

    // Die eigentliche Rechnung
    public static int theSmartestMethodsAlwaysNeedRidiculouslyLongNames(int e) {
        int container = doSomethingClever(e - 1);
        return container + doSomethingClever(e - 2);
    }
}
