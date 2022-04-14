package graphics;

import animals.Animal;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ZooPanel extends JPanel implements  ActionListener {
    private JPanel actionPanel;
    private JDialog addAnimalDialog;
    private ArrayList<Animal> Animallist;

    public ZooPanel(){
        actionPanel = new JPanel();
        JButton addanimal = new JButton("Add Animal");
        JButton moveanimal = new JButton("Move Animal");
        JButton clear = new JButton("Clear");
        JButton food = new JButton("Food");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");

        Animallist = new ArrayList<Animal>();

        addanimal.addActionListener(this);
        moveanimal.addActionListener(this);
        clear.addActionListener(this);
        food.addActionListener(this);
        info.addActionListener(this);
        exit.addActionListener(this);




        actionPanel.add(addanimal);
        actionPanel.add(moveanimal);
        actionPanel.add(clear);
        actionPanel.add(food);
        actionPanel.add(info);
        actionPanel.add(exit);


        actionPanel.setBackground(Color.BLUE);
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));

        this.add(actionPanel);




    }

    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()){
            case "Exit":System.exit(0);
                break;
            case "Add Animal":
                if(Animallist.size()==10)
                    JOptionPane.showMessageDialog(null, "You cannot add more than 10 animals.", "Message", JOptionPane.WARNING_MESSAGE);
                else {
                    AddAnimalDialog addanimaldialog = new AddAnimalDialog(Animallist);
                }
                break;
            case "Move Animal":
                if(Animallist.size()==0)
                    JOptionPane.showMessageDialog(null, "There are no animals in the zoo.", "Message", JOptionPane.WARNING_MESSAGE);
                else {
                    MoveAnimalDialog moveanimaldialog = new MoveAnimalDialog(Animallist);
                }
                break;
        }
    }

}
