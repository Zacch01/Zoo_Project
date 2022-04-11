package graphics;

import javax.swing.*;
import java.awt.*;

public class ZooFrame extends JFrame {
    private final JMenuBar menuBar;
    private final JPanel zooPanel;

    public ZooFrame(){
        this.setTitle("Zoo");
        zooPanel = new ZooPanel();
        this.add(zooPanel, BorderLayout.PAGE_END);
        this.setSize(800,800);

        menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        JMenu background = new JMenu("Background");
        JMenuItem image = new JMenuItem("Image");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem none = new JMenuItem("none");
        background.add(image);
        background.add(green);
        background.add(none);
        JMenu help = new JMenu("Help");
        JMenuItem help2 = new JMenuItem("Help");
        help.add(help2);
        menuBar.add(file);
        menuBar.add(background);
        menuBar.add(help);



        this.add(menuBar,BorderLayout.PAGE_START);




    }
    public static void main(String[] args){
        JFrame frame = new ZooFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}


