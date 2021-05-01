import javax.swing.JFrame;
public class MyFrame extends JFrame {
    MyFrame(){
        this.add(new MyPanel());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
    }
}
