import javax.swing.JPanel;
import javax.swing.*;
import java.util.Random;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

public class MyPanel extends JPanel implements ActionListener{
    static final int SCREEN_WIDTH = 700;
    static final int SCREEN_HIGHT = 500;
    static final int DELAY = 1000;
    static final int START_POSX = (SCREEN_WIDTH/2) - 20;
    static final int START_POSY = (SCREEN_HIGHT/2) - 20;

    Timer timer;
    Random random;
    int breite = 0;
    int maximum = 50;
    int minimum = 10;
    int shakex;
    int shakey;
    int breite2 = 0 - breite;

    MyPanel(){
        random = new Random();
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        start(); 
    }
    public void start(){
        timer = new Timer(DELAY, this);
        timer.start();
        shake();
    }
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        draw(g);
    }
    public void draw(Graphics g){
        //Hauptfigur
        
        g.setColor(Color.red);
        g.fillRect(START_POSX - shakex , START_POSY, 40, 40);
        g.setColor(Color.green);
        g.drawRect(START_POSX - shakex , START_POSY, 40, 40);
        }
   
    public void shake(){
        int j = maximum - minimum + 1;
        int k = random.nextInt() % j;
        breite = minimum + k; 
    } 
    public void move(){
        
        if(shakex < breite){
            shakex++;
            System.out.println("Breite zurückgelegt: " + shakex);
            System.out.println("Breite: " + breite);
         }//for (int i = 0; i > (0 - breite); i--) {
        //     shakex--;
        // }
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        move();
        repaint();
    }
}
