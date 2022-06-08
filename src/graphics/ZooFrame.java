package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * A class representing the GUI main frame
 * Note : It inherits from JFrame and implements from ActionListener
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see JFrame
 * @see ActionListener
 */
public class ZooFrame extends JFrame implements  ActionListener{
    private final JMenuBar menuBar;
    private final ZooPanel zooPanel;
    private BufferedImage img = null;
    private JLabel label;
    private static ZooFrame instance = null;

    /**
     * The constructor of the ZooFrame object: it sets the attributes of the object
     * Note : ZooFrame is the main frame of the program
     */
    private ZooFrame(){
        super("Zoo");
        menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem exit = new JMenuItem("Exit");
        file.add(exit);
        JMenu background = new JMenu("Background");
        JMenuItem image = new JMenuItem("Image");
        JMenuItem green = new JMenuItem("Green");
        JMenuItem none = new JMenuItem("None");
        background.add(image);
        background.add(green);
        background.add(none);
        JMenu help = new JMenu("Help");
        JMenuItem help2 = new JMenuItem("Help");
        help.add(help2);
        menuBar.add(file);
        menuBar.add(background);
        menuBar.add(help);

        exit.addActionListener(this);
        image.addActionListener(this);
        green.addActionListener(this);
        none.addActionListener(this);
        help2.addActionListener(this);

        label = new JLabel();
        this.add(label);
        this.setLayout(new BorderLayout());
        this.setSize(814,636);
        this.add(menuBar,BorderLayout.PAGE_START);
        this.setResizable(false);

        zooPanel = ZooPanel.getInstance(this);
        zooPanel.setOpaque(false);
        this.add(zooPanel);
    }

    /**
     * Invoked when an action occurs
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case "Exit" -> System.exit(0);
            case "Help" -> JOptionPane.showMessageDialog(this, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
            case "Green" -> {
                this.remove(label);
                this.getContentPane().setBackground(Color.green);
            }
            case "None" -> {
                this.remove(label);
                this.getContentPane().setBackground(null);
            }
            case "Image" -> {
                try {
                    this.remove(label);
                    this.getContentPane().setBackground(null);
                    img = ImageIO.read(new File(IDrawable.PICTURE_PATH + "savanna.png"));
                    label = new JLabel();
                    label.setBounds(0, 11, 800, 600);
                    Image dimg = img.getScaledInstance(label.getWidth(), label.getHeight(), Image.SCALE_SMOOTH);
                    ImageIcon imageIcon = new ImageIcon(dimg);
                    label.setIcon(imageIcon);
                    this.getContentPane().add(label);
                }
                catch (IOException a) { System.out.println("Cannot load image");
                    System.out.println(a.toString());}
            }
        }
    }

    /**
     * The main method of the project
     * @param args Possible arguments that may be passed
     */
    public static void main(String[] args){
        ZooFrame frame = ZooFrame.getInstance();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public static ZooFrame getInstance(){
        if(instance == null)
            instance = new ZooFrame();
        return instance;
    }
}



