
public class Schach {

    public static final int KEINE_ANGABE = 0;
    public static final int BAUER = 1;
    public static final int KOENIG = 2;
    public static final int TURM = 3;
    public static final int LAEUFER = 4;
    public static final int DAME = 5;
    public static final int PFERD = 6;
    public static final int SCHWARZ = 10;
    public static final int WEISS = 20;

    public static final int FELD_TYP = 0;
    public static final int FELD_FARBE = 1;

    public static int[][][] spielfeld = initialisiereSpielfeld();

    public static void main(String[] args) {

        int gewinner = KEINE_ANGABE;

        for (int zug = 0; gewinner == KEINE_ANGABE; zug++) {
            System.out.print("Zug Nummer: " + (zug + 1));
            if (zug % 2 == 0) {
                System.out.println(" / Schwarz");
                macheEinenZuefaelligenZug(SCHWARZ);
            } else {
                System.out.println(" / Weiss!");
                macheEinenZuefaelligenZug(WEISS);
            }

            System.out.println("");

            gewinner = pruefeObEsGewinnerGibt(spielfeld);
        }

        if (gewinner == SCHWARZ) {
            System.out.println("Schwarz gewinnt!");
        } else {
            System.out.println("Weiss gewinnt!");
        }
    }

    public static void macheEinenZuefaelligenZug(int farbe) {

        String welcheFarbe = (farbe == SCHWARZ ? "Schwarz" : "Weiss");

        int[][] possibleFigures = getMoeglicheFigurenZumFahren(farbe);
        int[] gewaehlteFigur = possibleFigures[getRandom(0, possibleFigures.length - 1)];
        System.out.println(welcheFarbe + " wählt " + gewaehlteFigur[0] + "/" + gewaehlteFigur[1]);

        int[][] possibleMoves = getPossibleMoves(gewaehlteFigur[0], gewaehlteFigur[1], farbe == SCHWARZ,
                gewaehlteFigur[2]);
        System.out.println("Die gewählte Figur besitzt " + possibleMoves.length + " mögliche moves");

        if (possibleMoves.length == 0) {
            return;
        }
        int[] gewaehlterMove = possibleMoves[getRandom(0, possibleMoves.length - 1)];

        // do move
        System.out.println("Figur " + gewaehlteFigur[2] + " springt von " + gewaehlteFigur[0] + "/" + gewaehlteFigur[1]
                + " auf " + gewaehlterMove[0] + "/" + gewaehlterMove[1]);
        // alter ort auf leer stellen
        spielfeld[gewaehlteFigur[0]][gewaehlteFigur[1]][0] = KEINE_ANGABE;
        spielfeld[gewaehlteFigur[0]][gewaehlteFigur[1]][1] = KEINE_ANGABE;

        // figur am neuen ort eintragen
        spielfeld[gewaehlterMove[0]][gewaehlterMove[1]][0] = gewaehlteFigur[2];
        spielfeld[gewaehlterMove[0]][gewaehlterMove[1]][1] = farbe;
    }

    public static int getRandom(int min, int max) {
        return min + (int) (Math.random() * ((max - min) + 1));
    }

    public static int[][] getMoeglicheFigurenZumFahren(int farbe) {
        int[][] moeglicheFigures = new int[getAnzahlFigurenFuerFarbe(farbe)][3];
        int counter = 0;
        for (int x = 0; x < spielfeld.length; x++) {
            for (int y = 0; y < spielfeld.length; y++) {
                if (spielfeld[x][y][FELD_FARBE] == farbe) {
                    moeglicheFigures[counter][0] = x;
                    moeglicheFigures[counter][1] = y;
                    moeglicheFigures[counter][2] = spielfeld[x][y][FELD_TYP];
                    counter++;
                }

            }
        }
        return moeglicheFigures;
    }

    public static int getAnzahlFigurenFuerFarbe(int farbe) {
        int counter = 0;
        for (int[][] reihe : spielfeld) {
            for (int[] feld : reihe) {
                if (feld[FELD_FARBE] == farbe) {
                    counter++;
                }
            }
        }
        return counter;
    }

    /**
     * Überprüft ob die Könige noch leben
     */
    public static int pruefeObEsGewinnerGibt(int[][][] spielfeld) {
        boolean schwarzNochImRennen = false;
        boolean weissNochImRennen = false;

        for (int[][] reihe : spielfeld) {
            for (int[] feld : reihe) {
                if (feld[FELD_TYP] == KOENIG) {
                    switch (feld[FELD_FARBE]) {
                        case SCHWARZ:
                            schwarzNochImRennen = true;
                            break;
                        case WEISS:
                            weissNochImRennen = true;
                            break;
                    }
                }
            }
        }

        if (schwarzNochImRennen && weissNochImRennen) {
            return 0;
        } else if (schwarzNochImRennen) {
            return SCHWARZ;
        } else {
            return WEISS;
        }
    }

    /**
     * Gibt die möglichen Spielzüge für die gegebene Figur zurück
     */
    public static int[][] getPossibleMoves(int x, int y, boolean schwarz, int type) {

        boolean[][] possibleFields = new boolean[8][8];

        switch (type) {
            case BAUER:
                possibleFields = getPossibleMovesBauer(x, y, schwarz);
                break;
            case KOENIG:
                possibleFields = getPossibleMovesKoenig(x, y, schwarz);
                break;
            case TURM:
                possibleFields = getPossibleMovesKoenig(x, y, schwarz);
                break;
            case LAEUFER:
                possibleFields = getPossibleMovesLaeufer(x, y, schwarz);
                break;
            case DAME:
                possibleFields = getPossibleMovesDame(x, y, schwarz);
                break;
            case PFERD:
                possibleFields = getPossibleMovesPferd(x, y, schwarz);
                break;
        }

        int anzahlMoves = 0;

        // kurz durchzählen wie viele mögliche moves das es gibt
        for (boolean[] reihe : possibleFields) {
            for (boolean feld : reihe) {
                if (feld) {
                    anzahlMoves++;
                }
            }
        }

        // array mit möglichen moves erstellen
        int[][] possibleMoves = new int[anzahlMoves][2];

        int counter = 0;

        for (int x_koordinate = 0; x_koordinate < possibleFields.length; x_koordinate++) {
            for (int y_koordinate = 0; y_koordinate < possibleFields.length; y_koordinate++) {
                // falls dies ein möglicher move ist, füge ihn dem 3d array mit den möglichen
                // moves hinzu
                if (possibleFields[x_koordinate][y_koordinate]) {
                    possibleMoves[counter][0] = x_koordinate;
                    possibleMoves[counter][1] = y_koordinate;
                    counter++;
                }
            }
        }
        return possibleMoves;
    }

    /**
     * Kann sich zwei Felder horizontal und ein Feld vertikal oder zwei Felder
     * Vertikal und ein Feld horizontal bewegen.
     */
    public static boolean[][] getPossibleMovesPferd(int x, int y, boolean schwarz) {
        boolean[][] schachbrett = new boolean[8][8];
        for (int s_x = 0; s_x < schachbrett.length; s_x++) {
            for (int s_y = 0; s_y < schachbrett.length; s_y++) {

                // darf ich hier überhaupt drauffahren?
                if (spielfeld[s_x][s_y][FELD_FARBE] == (schwarz ? SCHWARZ : WEISS)) {
                    break;
                }

                if ((s_x == x + 1 || s_x == x - 1) && (s_y == y + 2 || s_y == y - 2)) {
                    schachbrett[s_x][s_y] = true;
                }

                if ((s_x == x + 2 || s_x == x - 2) && (s_y == y + 1 || s_y == y - 1)) {
                    schachbrett[s_x][s_y] = true;
                }
            }
        }
        return schachbrett;
    }

    /**
     * Kann sich horizontal, vertikal und diagonal bewegen. Kann beliebig weit
     * gehen.
     */
    public static boolean[][] getPossibleMovesDame(int x, int y, boolean schwarz) {
        boolean[][] schachbrett = new boolean[8][8];
        for (int s_x = 0; s_x < schachbrett.length; s_x++) {
            for (int s_y = 0; s_y < schachbrett.length; s_y++) {

                // darf ich hier überhaupt drauffahren?
                if (spielfeld[s_x][s_y][FELD_FARBE] == (schwarz ? SCHWARZ : WEISS)) {
                    break;
                }

                // horizontal & vertikal
                if ((s_x == x || s_y == y) && !(s_x == x && s_y == y)) {
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x - s_y == x - y && !(s_x == x && s_y == y)) {
                    // befindet sich auf diagonalen aufsteigend
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x + s_y == x + y && !(s_x == x && s_y == y)) {
                    // befindet sich auf diagonalen absteigend
                    schachbrett[s_x][s_y] = true;
                }
            }
        }
        return schachbrett;
    }

    /**
     * Kann sich diagonal bewegen. Kann beliebig weit gehen.
     */
    public static boolean[][] getPossibleMovesLaeufer(int x, int y, boolean schwarz) {
        boolean[][] schachbrett = new boolean[8][8];
        for (int s_x = 0; s_x < schachbrett.length; s_x++) {
            for (int s_y = 0; s_y < schachbrett.length; s_y++) {

                // darf ich hier überhaupt drauffahren?
                if (spielfeld[s_x][s_y][FELD_FARBE] == (schwarz ? SCHWARZ : WEISS)) {
                    break;
                }

                if (s_x - s_y == x - y && !(s_x == x && s_y == y)) {
                    // befindet sich auf diagonalen aufsteigend
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x + s_y == x + y && !(s_x == x && s_y == y)) {
                    // befindet sich auf diagonalen absteigend
                    schachbrett[s_x][s_y] = true;
                }
            }
        }
        return schachbrett;
    }

    /**
     * Kann sich horizontal und vertikal bewegen. Kann beliebig weit gehen.
     */
    public static boolean[][] getPossibleMovesTurm(int x, int y, boolean schwarz) {
        boolean[][] schachbrett = new boolean[8][8];
        for (int s_x = 0; s_x < schachbrett.length; s_x++) {
            for (int s_y = 0; s_y < schachbrett.length; s_y++) {

                // darf ich hier überhaupt drauffahren?
                if (spielfeld[s_x][s_y][FELD_FARBE] == (schwarz ? SCHWARZ : WEISS)) {
                    break;
                }

                // moves des turms
                if ((s_x == x || s_y == y) && !(s_x == x && s_y == y)) {
                    schachbrett[s_x][s_y] = true;
                }
            }
        }
        return schachbrett;
    }

    /**
     * Kann sich horizontal, vertikal und diagonal bewegen. Kann nur ein Feld weit
     * gehen.
     */
    public static boolean[][] getPossibleMovesKoenig(int x, int y, boolean schwarz) {
        boolean[][] schachbrett = new boolean[8][8];
        for (int s_x = 0; s_x < schachbrett.length; s_x++) {
            for (int s_y = 0; s_y < schachbrett.length; s_y++) {

                // darf ich hier überhaupt drauffahren?
                if (spielfeld[s_x][s_y][FELD_FARBE] == (schwarz ? SCHWARZ : WEISS)) {
                    break;
                }

                if (s_y == y && (s_x == x + 1 || s_x == x - 1)) {
                    // horizontaler move des koenigs
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x == x && (s_y == y + 1 || s_y == y - 1)) {
                    // vertikaler move des koenigs
                    schachbrett[s_x][s_y] = true;
                }

                // diagonale moves des koenigs
                if (s_x == x + 1 && s_y == y + 1) {
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x == x + 1 && s_y == y - 1) {
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x == x - 1 && s_y == y + 1) {
                    schachbrett[s_x][s_y] = true;
                }

                if (s_x == x - 1 && s_y == y - 1) {
                    schachbrett[s_x][s_y] = true;
                }
            }
        }
        return schachbrett;
    }

    /**
     * Kann sich immer nur ein Feld nach vorne (weg von der Anfangsposition)
     * bewegen, ausser diese Figur steht am Anfangspunkt. Dann kann sie auch zwei
     * Felder anstelle ein Feld nach vorne bewegen.
     */
    public static boolean[][] getPossibleMovesBauer(int x, int y, boolean spielerSchwarz) {
        boolean[][] schachbrett = new boolean[8][8];
        for (int s_x = 0; s_x < schachbrett.length; s_x++) {
            for (int s_y = 0; s_y < schachbrett.length; s_y++) {

                // darf ich hier überhaupt drauffahren?
                if (spielfeld[s_x][s_y][FELD_FARBE] == (spielerSchwarz ? SCHWARZ : WEISS)) {
                    break;
                }

                if (spielerSchwarz) {
                    if (s_y == y && s_x == x + 1) {
                        // normaler move des schwarzen bauern
                        schachbrett[s_x][s_y] = true;
                    }

                    if (s_y == y && x == 1 && s_x == x + 2) {
                        // schwarzer bauer steht an anfangsposition
                        schachbrett[s_x][s_y] = true;
                    }
                } else {

                    if (s_y == y && s_x == x - 1) {
                        // normaler move des weissen bauern
                        schachbrett[s_x][s_y] = true;
                    }

                    if (s_y == y && x == 6 && s_x == x - 2) {
                        // weisser bauer steht an anfangsposition
                        schachbrett[s_x][s_y] = true;
                    }
                }
            }
        }
        return schachbrett;
    }

    /**
     * Initialisiere das Spielfeld
     * 
     * @return das aufgebaute Spielfeld
     */
    public static int[][][] initialisiereSpielfeld() {
        int[][][] spielfeld = new int[8][8][2];

        // team schwarz
        spielfeld[0][0][0] = TURM;
        spielfeld[0][0][1] = SCHWARZ;

        spielfeld[0][1][0] = PFERD;
        spielfeld[0][1][1] = SCHWARZ;

        spielfeld[0][2][0] = LAEUFER;
        spielfeld[0][2][1] = SCHWARZ;

        spielfeld[0][3][0] = KOENIG;
        spielfeld[0][3][1] = SCHWARZ;

        spielfeld[0][4][0] = DAME;
        spielfeld[0][4][1] = SCHWARZ;

        spielfeld[0][5][0] = LAEUFER;
        spielfeld[0][5][1] = SCHWARZ;

        spielfeld[0][6][0] = PFERD;
        spielfeld[0][6][1] = SCHWARZ;

        spielfeld[0][7][0] = TURM;
        spielfeld[0][7][1] = SCHWARZ;

        spielfeld[1][0][0] = BAUER;
        spielfeld[1][0][1] = SCHWARZ;

        spielfeld[1][1][0] = BAUER;
        spielfeld[1][1][1] = SCHWARZ;

        spielfeld[1][2][0] = BAUER;
        spielfeld[1][2][1] = SCHWARZ;

        spielfeld[1][3][0] = BAUER;
        spielfeld[1][3][1] = SCHWARZ;

        spielfeld[1][4][0] = BAUER;
        spielfeld[1][4][1] = SCHWARZ;

        spielfeld[1][5][0] = BAUER;
        spielfeld[1][5][1] = SCHWARZ;

        spielfeld[1][6][0] = BAUER;
        spielfeld[1][6][1] = SCHWARZ;

        spielfeld[1][7][0] = BAUER;
        spielfeld[1][7][1] = SCHWARZ;

        // team weiss
        spielfeld[7][0][0] = TURM;
        spielfeld[7][0][1] = WEISS;

        spielfeld[7][1][0] = PFERD;
        spielfeld[7][1][1] = WEISS;

        spielfeld[7][2][0] = LAEUFER;
        spielfeld[7][2][1] = WEISS;

        spielfeld[7][3][0] = KOENIG;
        spielfeld[7][3][1] = WEISS;

        spielfeld[7][4][0] = DAME;
        spielfeld[7][4][1] = WEISS;

        spielfeld[7][5][0] = LAEUFER;
        spielfeld[7][5][1] = WEISS;

        spielfeld[7][6][0] = DAME;
        spielfeld[7][6][1] = WEISS;

        spielfeld[7][7][0] = TURM;
        spielfeld[7][7][1] = WEISS;

        spielfeld[6][0][0] = BAUER;
        spielfeld[6][0][1] = WEISS;

        spielfeld[6][1][0] = BAUER;
        spielfeld[6][1][1] = WEISS;

        spielfeld[6][2][0] = BAUER;
        spielfeld[6][2][1] = WEISS;

        spielfeld[6][3][0] = BAUER;
        spielfeld[6][3][1] = WEISS;

        spielfeld[6][4][0] = BAUER;
        spielfeld[6][4][1] = WEISS;

        spielfeld[6][5][0] = BAUER;
        spielfeld[6][5][1] = WEISS;

        spielfeld[6][6][0] = BAUER;
        spielfeld[6][6][1] = WEISS;

        spielfeld[6][7][0] = BAUER;
        spielfeld[6][7][1] = WEISS;

        return spielfeld;
    }
}