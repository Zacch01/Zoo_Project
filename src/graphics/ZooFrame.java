package graphics;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;



public class ZooFrame extends JFrame implements  ActionListener{
    private final JMenuBar menuBar;
    private final ZooPanel zooPanel;
    private BufferedImage img = null;
    private JLabel label;




    public ZooFrame(){
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

        zooPanel = new ZooPanel(this);
        zooPanel.setOpaque(false);
        this.add(zooPanel);

    }

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

    public static void main(String[] args){
        ZooFrame frame = new ZooFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}



