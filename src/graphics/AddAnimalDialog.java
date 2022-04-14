package graphics;

import animals.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.util.ArrayList;

public class AddAnimalDialog extends JDialog {
    private final String[] animalTypes = {"Lion", "Bear", "Giraffe", "Elephant", "Turtle"};
    private final String[] animalColors = {"Natural", "Red", "Blue"};
    private ZooPanel zoopanel;

    public AddAnimalDialog(ZooPanel zoopanel, ArrayList<Animal> Animallist){
        this.setTitle("Add Animal");
        this.setSize(500,300);
        this.setVisible(true);
        this.setResizable(false);
        this.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
        this.setLocation(150,150);
        this.setLayout(new BoxLayout(this.getContentPane(),BoxLayout.PAGE_AXIS));
        this.zoopanel = zoopanel;

        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int result = JOptionPane.showConfirmDialog(
                        getRootPane().getParent(), "Are you sure?");
                if (result == JOptionPane.OK_OPTION) {
                    setDefaultCloseOperation(
                            JFrame.DISPOSE_ON_CLOSE);
                    setVisible(false);
                    dispose();
                }
            }
        });

        //JPanel animalTypesPanel = new JPanel();
        JComboBox<String> animalTypesCombo = new JComboBox<>(animalTypes);
        TitledBorder animalChoiceBorder = BorderFactory.createTitledBorder("Choose Animal: ");
        animalTypesCombo.setBorder(animalChoiceBorder);
        //animalTypesPanel.add(animalTypesCombo);
        this.getContentPane().add(animalTypesCombo);

        //JPanel sizePanel = new JPanel();
        JTextField textField = new JTextField(500);
        TitledBorder sizechoice = BorderFactory.createTitledBorder("Write the animal's size: ");
        textField.setBorder(sizechoice);
        //sizePanel.add(textField);
        this.getContentPane().add(textField );

        textField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });







        //JPanel horizontalspeedPanel = new JPanel();
        JTextField textspeedField = new JTextField(500);
        TitledBorder horizontalspeedhchoice = BorderFactory.createTitledBorder("Write the animal's horizontal speed: ");
        textspeedField.setBorder(horizontalspeedhchoice);
        //sizePanel.add(textField);
        this.getContentPane().add(textspeedField);
        textspeedField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });

        //JPanel verticalspeedPanel = new JPanel();
        JTextField textspeedvField = new JTextField(500);
        TitledBorder verticalspeedchoice = BorderFactory.createTitledBorder("Write the animal's vertical speed: ");
        textspeedvField.setBorder(verticalspeedchoice);
        //sizePanel.add(textField);
        this.getContentPane().add(textspeedvField);
        textspeedvField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if ( ((c < '0') || (c > '9')) && (c != KeyEvent.VK_BACK_SPACE)) {
                    e.consume();
                }
            }
        });


        //JPanel animalTypesPanel = new JPanel();
        JComboBox<String> animalcolorsCombo = new JComboBox<>(animalColors);
        TitledBorder animalcolorChoiceBorder = BorderFactory.createTitledBorder("Choose the animal's color: ");
        animalcolorsCombo.setBorder(animalcolorChoiceBorder);
        //animalTypesPanel.add(animalTypesCombo);
        this.getContentPane().add(animalcolorsCombo);

        JButton jButton = new JButton("Add");
        jButton.setBounds(15, 40, 30, 30);
        this.getContentPane().add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(textField.getText().length()>3||textField.getText().length()==0)
                    JOptionPane.showMessageDialog(null, "The size of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textField.getText())>300 || Integer.parseInt(textField.getText())<50)
                    JOptionPane.showMessageDialog(null, "The size of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(textspeedField.getText().length()>3||textspeedField.getText().length()==0)
                    JOptionPane.showMessageDialog(null, "The horizontal speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textspeedField.getText())<1|| Integer.parseInt(textspeedField.getText())>10)
                    JOptionPane.showMessageDialog(null, "The horizontal speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(textspeedvField.getText().length()>3||textspeedvField.getText().length()==0)
                    JOptionPane.showMessageDialog(null, "The vertical speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else if(Integer.parseInt(textspeedvField.getText())<1|| Integer.parseInt(textspeedvField.getText())>10)
                    JOptionPane.showMessageDialog(null, "The vertical speed of your animal isn't correct.\nTry again.", "Error", JOptionPane.ERROR_MESSAGE);
                else {
                    switch (animalTypesCombo.getItemAt(animalTypesCombo.getSelectedIndex())) {
                        case "Bear" -> Animallist.add(new Bear(Integer.parseInt(textField.getText()), textspeedField.getText().length(), textspeedvField.getText().length(), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                        case "Elephant" -> Animallist.add(new Elephant(Integer.parseInt(textField.getText()), textspeedField.getText().length(), textspeedvField.getText().length(), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                        case "Giraffe" -> Animallist.add(new Giraffe(Integer.parseInt(textField.getText()), textspeedField.getText().length(), textspeedvField.getText().length(), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                        case "Lion" -> Animallist.add(new Lion(Integer.parseInt(textField.getText()), textspeedField.getText().length(), textspeedvField.getText().length(), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                        case "Turtle" -> Animallist.add(new Turtle(Integer.parseInt(textField.getText()), textspeedField.getText().length(), textspeedvField.getText().length(), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                    }
                    JOptionPane.showMessageDialog(null, "Animal added", "Message",JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                }
            }
        });

    }


}
