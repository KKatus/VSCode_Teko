import java.util.Random;

public class wuerfel extends JFrame implements ActionListener{
    {                                                           //sie wird von der Klasse JPanel abgeleitet und enthält die Schnittstelle ActionListener
        public void paintComponent(Graphics g)                     //Methode, die das Panel "malt"
           {
            super.paintComponent(g);                               //"malt" das Panel mit der Methode aus der Superklasse JPanel
            setBackground(Color.white);                            //setzt den Hintergrund auf weiß
            g.drawString("DiceRoll - Zufälliges Würfeln \n",150,20);   //Schreibt den String auf das Panel, in Pixelhöhe 150x20
            int a = 0;                                             //Initialisieren der Variablen a(Spielerwurf)
            int b = 0;                                             //Initialisieren der Variablen b(Computerwurf)
            int c = 100;                                           //Initialisieren der Variablen c("Zeilenumbruch")
            Random r = new Random();                               //Anlegen des Random-Objektes
            while (a<=b)                                            //Initiieren einer while-Schleife, solange bis a > b
            {
               g.setColor(Color.black);                            //setzt die Schriftfarbe (wieder) auf schwarz
                a = r.nextInt(6)+1;                                //Initialisieren von a mit einer Zufallszahl zw. 1-6 (Wurf)
                b = r.nextInt(6)+1;                                //   -||-            b          -||-
                g.drawString("Du würfelst eine: "+ a,150,c);       //Schreibt den String auf das Panel, in Pixelhöhe 150x c 
                g.drawString("Der Gegner würfelt eine: "+ b,150,c+20);     //Schreibt den String auf das Panel, in Pixelhöhe 150x c+20
                if(a==b) {g.setColor(Color.blue); g.drawString(a + "=" + b + " -> Gleichstand \n",150,c+50);}   //wenn Gleichstand, Schriftfarbe blau
                else
                {  
                    if(a>b)                                     //wenn Spieler gewinnt (a > b)
                    {g.setColor(Color.green);                      //Schriftfarbe grün
                    g.drawString(a + ">" + b + " -> Du gewinnst! \n",150,c+50);} //Schreibt den String auf das Panel, in Pixelhöhe 150x c+50
                    else
                    {g.setColor(Color.red);                        //Schriftfarbe rot
                    g.drawString(a + "<" + b + " -> Du verlierst! \n",150,c+50);}    //Schreibt den String auf das Panel, in Pixelhöhe 150x c+50
                }
                c = c+150;     //c wird um 150 erhöht ("Zeilenumbruch")
            }  //Ende while-Schleife    
           }   //Ende paint-Methode
        }  //Ende Panel-Klasse
    
   class DiceRollFrame extends JFrame      //Klasse, die das Fenster erstellt, wird von der Klasse JFrame abgeleitet
       {
        public DiceRollFrame()                     //Methode, die das Fenster "erstellt"
           {
            setTitle("DiceRoll");                  //Titel des Fensters benennen
            setSize(512,1024);                     //Größe des Fensters bestimmen
            addWindowListener(new WindowAdapter()  //Zuordnen des Interface WindowAdapter zum Listener Window
            {
             public void windowClosing(WindowEvent e)  //Methode, die "Klick aufs Kreuz oben rechts" initiiert
               {System.exit(0);}                   //beenden des Programms
            }  //Ende Zuordnung    
            ); //Ende Zuordnung
            Container contentPane = getContentPane();  //Anlegen eines Containers
            contentPane.add(new DiceRollPanel());      //Panel wird "auf" das Fenster gelegt
           }   //Ende Methode-frame
       }   //Ende Klasse
    
   public class DiceRoll       //die "ausführende" Klasse
       {
        public static void main(String[] args)     //main-Methode
        {
         JFrame frame = new DiceRollFrame();       //Erstellen eines neuen Fensters, Aufruf der spezifischen DiceRollFrame-Klasse
         frame.show();                             //Zeigen des Fensters
        }  //Ende main-Methode
       }   //Ende Klasse