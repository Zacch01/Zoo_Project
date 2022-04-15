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
        this.setSize(800,600);
        this.add(menuBar,BorderLayout.PAGE_START);
        this.setResizable(false);

        zooPanel = new ZooPanel(this);
        this.add(zooPanel, BorderLayout.SOUTH);

    }

    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()) {
            case "Exit" -> System.exit(0);
            case "Help" -> JOptionPane.showMessageDialog(null, "Home Work 2\nGUI", "Message", JOptionPane.INFORMATION_MESSAGE);
            case "Green" -> {
                this.remove(label);
                this.getContentPane().setBackground(Color.green);
            }
            case "None" -> {
                this.remove(label);
                this.getContentPane().setBackground(null);
            }
            case "Image" -> {

                /*ImageIcon background=new ImageIcon("C:\\Users\\zacch\\OneDrive\\Documents\\savanna.png");
                Image img=background.getImage();
                Image temp=img.getScaledInstance(1920,800,Image.SCALE_SMOOTH);
                background=new ImageIcon(temp);
                JLabel back=new JLabel(background);
                back.setLayout(new BorderLayout());

                back.setBounds(0,0,1920,800);
                this.add(back);*/
                /*t
                try {
                    final Image backgroundImage = javax.imageio.ImageIO.read(new File("C:\\Users\\zacch\\OneDrive\\Documents\\savanna.png"));
                    this.setContentPane(new JPanel() {
                    @Override
                    public void paintComponent(Graphics g) {
                        super.paintComponent(g);
                        g.drawImage(backgroundImage, 0, 0, null);
                    }
                });
                    this.setLayout(new BorderLayout());
                    this.add(zooPanel, BorderLayout.PAGE_END);
                    this.add(menuBar,BorderLayout.PAGE_START);
                } catch (IOException a) {
                    throw new RuntimeException(a);
                }*/
                this.remove(label);
                this.getContentPane().setBackground(null);
                label = new JLabel("", new ImageIcon("C:\\Users\\zacch\\OneDrive\\Documents\\savanna.png"), SwingConstants.CENTER);
                label.setBounds(0, 0, 800, 600);
                this.add(label);
            }
        }

    }

    public static void main(String[] args){
        ZooFrame frame = new ZooFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.zooPanel.manageZoo();
    }
}



