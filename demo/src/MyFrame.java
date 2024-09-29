import javax.swing.*;
import java.awt.*;

public class MyFrame extends JFrame {
    public MyFrame() {
        System.out.println("Hello world!");

        //JFrame frame = new JFrame();
        this.setTitle("Demo"); // to give title to frame
        this.setVisible(true); //make frame visible
        this.setSize(500, 500); // x,y dimension
        //the frame would not close if we simply hit the cross button
        //so to close the frame using x we have to :

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //frame will exit when x is pressed
        //We can also use( DO_NOTHING_ON_CLOSE ),

        //To prevent the user to resize the frame use:
        this.setResizable(false);


        //to set logo
//        ImageIcon logo = new ImageIcon("logo.png");
//        this.setIconImage(logo.getImage());


        //to set background color

        this.getContentPane().setBackground(Color.orange);
        //custom color
        this.getContentPane().setBackground(new Color(0,0,0)); //black
        this.getContentPane().setBackground(new Color(255,0,0)); //red
        this.getContentPane().setBackground(new Color(0xFFFFF)); //hexadecimal

    }
}
