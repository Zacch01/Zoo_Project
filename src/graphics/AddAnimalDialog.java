package graphics;

import DesignPatterns.AbstractZooFactory;
import DesignPatterns.CarnivoreFactory;
import DesignPatterns.HerbivoreFactory;
import DesignPatterns.OmnivoreFactory;
import animals.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.*;
import java.util.*;


/**
 * A class representing the GUI Dialog in order to add an animal to our zoo program
 * Note : It inherits from JDialog
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see JDialog
 */
public class AddAnimalDialog extends JDialog {
    private List<String> animalTypes = new ArrayList<String>();
    private final String[] animalColors = {"Natural", "Red", "Blue"};
    private final String[] dietTypes = {"Carnivore", "Herbivore", "Omnivore"};
    private ZooPanel zoopanel;
    private Map<String, List<String>> modelNameTermName = new LinkedHashMap<String, List<String>>();

    /**
     * Constructor of the JDialog AddAnimalDialog : it sets the attributes of the JDialog
     * Note : Adds animals to a zoo according to the user's choice
     *
     * @param Animallist  A ArrayList<Animal> that represent the animals in the zoo
     * @param zoopanel A Zoopanel that represent the parent panel of the JDialog
     */
    public AddAnimalDialog(ZooPanel zoopanel, ArrayList<Animal> Animallist){
        this.setTitle("Add Animal");
        this.setSize(500,325);
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
                    zoopanel.getF().setEnabled(true);
                    dispose();
                }
            }
        });

        modelNameTermName.put("Carnivore", Arrays.asList("Lion"));
        modelNameTermName.put("Omnivore", Arrays.asList("Bear"));
        modelNameTermName.put("Herbivore", Arrays.asList("Elephant", "Giraffe", "Turtle"));

        JComboBox<String> dietTypesCombo = new JComboBox<>(dietTypes);
        TitledBorder dietChoiceBorder = BorderFactory.createTitledBorder("Choose the diet: ");
        dietTypesCombo.setBorder(dietChoiceBorder);
        this.getContentPane().add(dietTypesCombo);

        JComboBox<String> animalTypesCombo = new JComboBox<>();
        TitledBorder animalChoiceBorder = BorderFactory.createTitledBorder("Choose Animal: ");
        animalTypesCombo.setBorder(animalChoiceBorder);
        animalTypesCombo.addItem("Lion");
        this.getContentPane().add(animalTypesCombo);


        dietTypesCombo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox<String> source = (JComboBox<String>) e.getSource();;
                String selecteddiet = source.getSelectedItem().toString();
                List<String> termNames = modelNameTermName.get(selecteddiet);
                animalTypesCombo.removeAllItems();
                for (String name : termNames) {
                        animalTypesCombo.addItem(name);

                }
            }
        });
        /*switch (dietTypesCombo.getItemAt(dietTypesCombo.getSelectedIndex())) {
            case "Carnivore" -> animalTypes.add("Lion");
            case "Omnivore" -> animalTypes.add("Bear");
            case "Herbivore" -> {
                animalTypes.add("Elephant");
                animalTypes.add("Giraffe");
                animalTypes.add("Turtle");
            }
        }

        String[] stockArr = new String[animalTypes.size()];
        stockArr = animalTypes.toArray(stockArr);
        JComboBox<String> animalTypesCombo = new JComboBox<>(stockArr);
        TitledBorder animalChoiceBorder = BorderFactory.createTitledBorder("Choose Animal: ");
        animalTypesCombo.setBorder(animalChoiceBorder);
        this.getContentPane().add(animalTypesCombo);*/

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
                    AbstractZooFactory zooFactory = null;
                    switch (dietTypesCombo.getItemAt(dietTypesCombo.getSelectedIndex())) {
                        case "Carnivore" -> zooFactory = new CarnivoreFactory();
                        case "Omnivore" -> zooFactory = new OmnivoreFactory();
                        case "Herbivore" -> zooFactory = new HerbivoreFactory();
                    }
                    Animallist.add(zooFactory.createAnimal(animalTypesCombo.getItemAt(animalTypesCombo.getSelectedIndex()),Integer.parseInt(textField.getText()), Integer.parseInt(textspeedField.getText()), Integer.parseInt(textspeedvField.getText()), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));
                    zoopanel.getThreadpool().addtopoll(Animallist.get(Animallist.size()-1));
                    /*Class c;
                    ClassLoader cl = ClassLoader.getSystemClassLoader();
                    try {
                        c = cl.loadClass("animals."+animalTypesCombo.getItemAt(animalTypesCombo.getSelectedIndex()));
                        Constructor con = c.getConstructor(int.class, int.class, int.class, String.class,ZooPanel.class);
                        Animallist.add((Animal) con.newInstance(Integer.parseInt(textField.getText()), Integer.parseInt(textspeedField.getText()), Integer.parseInt(textspeedvField.getText()), animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()),zoopanel));

                        //Animallist.get(Animallist.size()-1).start();
                        zoopanel.getThreadpool().addtopoll(Animallist.get(Animallist.size()-1));
                    } catch (Exception a) {
                        a.printStackTrace();
                    }
                    zoopanel.manageZoo();*/
                    JOptionPane.showMessageDialog(zoopanel, "Animal added", "Message",JOptionPane.INFORMATION_MESSAGE);
                    zoopanel.getF().setEnabled(true);
                    dispose();
                }
            }
        });
    }
}
