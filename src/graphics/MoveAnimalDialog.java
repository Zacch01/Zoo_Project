package graphics;

import animals.*;
import mobility.Point;
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.util.ArrayList;


/**
 * A class representing the GUI Dialog in order to move an animal in our zoo program
 * Note : It inherits from JDialog
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see JDialog
 */
public class MoveAnimalDialog extends JDialog {
    private ZooPanel zoopanel;

    /**
     * Constructor of the JDialog MoveAnimalDialog : it sets the attributes of the JDialog
     * Note : Moves the animal to a new point in the zoo according to the user's choice
     *
     * @param Animallist  A ArrayList<Animal> that represent the animals in the zoo
     * @param zoopanel A Zoopanel that represent the parent panel of the JDialog
     */
    public MoveAnimalDialog(ZooPanel zoopanel, ArrayList<Animal> Animallist){
        this.setTitle("Move Animal");
        this.setSize(500, 200);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocation(150, 250);
        this.setLayout(new BoxLayout(this.getContentPane(), BoxLayout.PAGE_AXIS));
        this.zoopanel =zoopanel;
        this.zoopanel.getF().setEnabled(false);

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        getRootPane().getParent(), "Are you sure?");
                if (result == JOptionPane.OK_OPTION) {
                    setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    zoopanel.getF().setEnabled(true);
                    dispose();
                }
            }
        });



        JComboBox<String> allanimalsCombo = new JComboBox();
        DefaultComboBoxModel modele= new DefaultComboBoxModel();
        for (Animal animal : Animallist) {
            modele.addElement(animal.getanimal());
        }
        allanimalsCombo.setModel(modele);
        TitledBorder animalChoiceBorder = BorderFactory.createTitledBorder("Choose Animal: ");
        allanimalsCombo.setBorder(animalChoiceBorder);
        this.getContentPane().add(allanimalsCombo);

        JTextField textFieldx = new JTextField(500);
        TitledBorder xchoice = BorderFactory.createTitledBorder("Write the animal's new location on the axis x (0-800): ");
        textFieldx.setBorder(xchoice);
        this.getContentPane().add(textFieldx );
        textFieldx.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        JTextField textFieldy = new JTextField(500);
        TitledBorder ychoice = BorderFactory.createTitledBorder("Write the animal's new location on the axis y (0-600): ");
        textFieldy.setBorder(ychoice);
        this.getContentPane().add(textFieldy );
        textFieldy.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        JButton jButton = new JButton("Move");
        jButton.setBounds(15, 40, 30, 30);
        this.getContentPane().add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textFieldx.getText().length()>3||textFieldx.getText().length()==0)
                    JOptionPane.showMessageDialog(zoopanel, "The location x of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textFieldx.getText())>800 || Integer.parseInt(textFieldx.getText())<0)
                    JOptionPane.showMessageDialog(zoopanel, "The location x of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(textFieldy.getText().length()>3||textFieldy.getText().length()==0)
                    JOptionPane.showMessageDialog(zoopanel, "The location y of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textFieldy.getText())>600 || Integer.parseInt(textFieldy.getText())<0)
                    JOptionPane.showMessageDialog(zoopanel, "The location y of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    Animallist.get(allanimalsCombo.getSelectedIndex()).setLocation(new Point(Integer.parseInt(textFieldx.getText()), Integer.parseInt(textFieldy.getText())));
                    Animallist.get(allanimalsCombo.getSelectedIndex()).setChanges(true);
                    //zoopanel.manageZoo();
                    JOptionPane.showMessageDialog(null, "Animal moved", "Message",JOptionPane.INFORMATION_MESSAGE);
                    zoopanel.getF().setEnabled(true);
                    dispose();
                }
            }
        });
    }
}
