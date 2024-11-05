import javax.swing.*; // to import swing components 
import java.awt.*;      //For layouts and colors
import java.awt.event.*;  // events handling


public class Interface extends JFrame{

    private JButton button;
    private JTextField text;
    private JLabel label;

    public Interface(){
        setTitle("Chatting App");


        setLayout(new FlowLayout());  // for aligning objects in row
    }

    
}
