package DesignPatterns;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

public class ChangeColorDialog extends JDialog {
    private ZooPanel zoopanel;
    private final String[] animalColors = {"Natural", "Red", "Blue"};


    /**
     * Constructor of the JDialog ChangeColorDialog : it sets the attributes of the JDialog
     * Note : Change the color of an animals in the zoo according to the user's choice
     *
     * @param Animallist  A ArrayList<Animal> that represent the animals in the zoo
     * @param zoopanel A Zoopanel that represent the parent panel of the JDialog
     */
    public ChangeColorDialog(ZooPanel zoopanel, ArrayList<Animal> Animallist){
        for (int i = 0; i < Animallist.size(); i++)
            Animallist.get(i).setSuspended();
        this.setTitle("Change Color Of An Animal");
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
                    for (int i = 0; i < Animallist.size(); i++)
                        Animallist.get(i).setResumed();
                    zoopanel.getF().setEnabled(true);
                    dispose();
                }
            }
        });

        JComboBox<String> allanimalsCombo = new JComboBox();
        DefaultComboBoxModel modele= new DefaultComboBoxModel();
        for (Animal animal : Animallist) {
            if(animal.getisalive())
                modele.addElement(animal.getanimal());
        }
        allanimalsCombo.setModel(modele);
        TitledBorder animalChoiceBorder = BorderFactory.createTitledBorder("Choose Animal: ");
        allanimalsCombo.setBorder(animalChoiceBorder);
        this.getContentPane().add(allanimalsCombo);

        JComboBox<String> animalcolorsCombo = new JComboBox<>(animalColors);
        TitledBorder animalcolorChoiceBorder = BorderFactory.createTitledBorder("Choose the animal's color: ");
        animalcolorsCombo.setBorder(animalcolorChoiceBorder);
        this.getContentPane().add(animalcolorsCombo);

        JButton jButton = new JButton("Change");
        jButton.setBounds(15, 40, 30, 30);
        this.getContentPane().add(jButton);
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Animallist.get(allanimalsCombo.getSelectedIndex()).PaintAnimal(animalcolorsCombo.getItemAt(animalcolorsCombo.getSelectedIndex()));
                for (int i = 0; i < Animallist.size(); i++)
                    Animallist.get(i).setResumed();
                JOptionPane.showMessageDialog(zoopanel, "Color changed", "Message", JOptionPane.INFORMATION_MESSAGE);
                zoopanel.getF().setEnabled(true);
                dispose();
            }
        });
    }
}
