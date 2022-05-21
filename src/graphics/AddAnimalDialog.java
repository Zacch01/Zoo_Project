package graphics;

import animals.*;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.lang.reflect.Constructor;
import java.util.ArrayList;


/**
 * A class representing the GUI Dialog in order to add an animal to our zoo program
 * Note : It inherits from JDialog
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see JDialog
 */
public class AddAnimalDialog extends JDialog {
    private final String[] animalTypes = {"Lion", "Bear", "Giraffe", "Elephant", "Turtle"};
    private final String[] animalColors = {"Natural", "Red", "Blue"};
    private ZooPanel zoopanel;

    /**
     * Constructor of the JDialog AddAnimalDialog : it sets the attributes of the JDialog
     * Note : Adds animals to a zoo according to the user's choice
     *
     * @param Animallist  A ArrayList<Animal> that represent the animals in the zoo
     * @param zoopanel A Zoopanel that represent the parent panel of the JDialog
     */
    public AddAnimalDialog(ZooPanel zoopanel, ArrayList<Animal> Animallist){
        this.setTitle("Add Animal");
        this.setSize(500,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocation(150,150);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
        this.zoopanel = zoopanel;
        this.zoopanel.getF().setEnabled(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        getRootPane().getParent(), "Are you sure?");
                if (result == JOptionPane.OK_OPTION) {
                    setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    setVisible(false);
                    zoopanel.getF().setEnabled(true);
                    dispose();
                }
            }
        });


        JComboBox<String> animalTypesCombo = new JComboBox<>(animalTypes);
        TitledBorder animalChoiceBorder = BorderFactory.createTitledBorder("Choose Animal: ");
        animalTypesCombo.setBorder(animalChoiceBorder);
        this.getContentPane().add(animalTypesCombo);

        JTextField textField = new JTextField(500);
        TitledBorder sizechoice = BorderFactory.createTitledBorder("Write the animal's size (50-300): ");
        textField.setBorder(sizechoice);
        this.getContentPane().add(textField );

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        JTextField textspeedField = new JTextField(500);
        TitledBorder horizontalspeedhchoice = BorderFactory.createTitledBorder("Write the animal's horizontal speed (1-10): ");
        textspeedField.setBorder(horizontalspeedhchoice);
        this.getContentPane().add(textspeedField);
        textspeedField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        JTextField textspeedvField = new JTextField(500);
        TitledBorder verticalspeedchoice = BorderFactory.createTitledBorder("Write the animal's vertical speed (1-10): ");
        textspeedvField.setBorder(verticalspeedchoice);

        this.getContentPane().add(textspeedvField);
        textspeedvField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        JComboBox<String> animalcolorsCombo = new JComboBox<>(animalColors);
        TitledBorder animalcolorChoiceBorder = BorderFactory.createTitledBorder("Choose the animal's color: ");
        animalcolorsCombo.setBorder(animalcolorChoiceBorder);
        this.getContentPane().add(animalcolorsCombo);

        JButton jButton = new JButton("Add");
        jButton.setBounds(15, 40, 30, 30);
        this.getContentPane().add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().length()>3||textField.getText().length()==0)
                    JOptionPane.showMessageDialog(zoopanel, "The size of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textField.getText())>300 || Integer.parseInt(textField.getText())<50)
                    JOptionPane.showMessageDialog(zoopanel, "The size of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(textspeedField.getText().length()>3||textspeedField.getText().length()==0)
                    JOptionPane.showMessageDialog(zoopanel, "The horizontal speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textspeedField.getText())<1|| Integer.parseInt(textspeedField.getText())>10)
                    JOptionPane.showMessageDialog(zoopanel, "The horizontal speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(textspeedvField.getText().length()>3||textspeedvField.getText().length()==0)
                    JOptionPane.showMessageDialog(zoopanel, "The vertical speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textspeedvField.getText())<1|| Integer.parseInt(textspeedvField.getText())>10)
                    JOptionPane.showMessageDialog(zoopanel, "The vertical speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    Class c;
                    ClassLoader cl = ClassLoader.getSystemClassLoader();
                    try {
                        c = cl.loadClass("animals."+animalTypesCombo.getItemAt(animalTypesCombo.getSelectedIndex()));
                        Constructor con = c.getConstructor(int.class, int.class, int.class, String.class,ZooPanel.class);
                        Animallist.add((Animal) con.newInstance(Integer.parseInt(textField.getText()), Integer.parseInt(textspeedField.getText()), Integer.parseInt(textspeedvField.getText()), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                        Animallist.get(Animallist.size()-1).start();
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                    //zoopanel.manageZoo();
                    JOptionPane.showMessageDialog(zoopanel, "Animal added", "Message",JOptionPane.INFORMATION_MESSAGE);
                    zoopanel.getF().setEnabled(true);
                    dispose();

                }
            }
        });
    }
}
