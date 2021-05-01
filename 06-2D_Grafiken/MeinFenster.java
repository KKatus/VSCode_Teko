import javax.swing.JFrame;
import java.awt.*;

public class MeinFenster extends JFrame{
    public void paint(Graphics g){
        // X Y width height
        // ------> x
        // |
        // |
        // v
        setBackground(Color.black);
        setForeground(Color.red);
       
       g.drawRoundRect(100, 100, 80, 80, 100, 100);
       
       // the syntax of drawOval is (x1,y1,w,h)
       //    where (x1,y1) is the top left corner  and
       //    (w,h) is the width and height of the bounding rectangle
	
       // augen
       g.drawRoundRect(125,135,10,10, 100, 100);
       g.drawRoundRect(145,135,10,10, 100, 100);
       
       // the syntax of drawLine is (x1,y1,x2,y2);
       // to draw a line from point (x1,y1) to (x2,y2)
       
       // the body
       g.drawLine(90,60,100,120);
       
       // the hands
       g.drawLine(100,100,80,100);
       g.drawLine(100,100,120,100);
       
       // the legs
       g.drawLine(100,120,85,135);
       g.drawLine(100,120,115,135);
       
    }
}
