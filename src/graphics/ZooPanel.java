package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ZooPanel extends JPanel implements  ActionListener {
    private JPanel actionPanel;
    private JDialog addAnimalDialog;

    public ZooPanel(){
        actionPanel = new JPanel();
        JButton addanimal = new JButton("Add Animal");
        JButton moveanimal = new JButton("Move Animal");
        JButton clear = new JButton("Clear");
        JButton food = new JButton("Food");
        JButton info = new JButton("Info");
        JButton exit = new JButton("Exit");

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
            case "Add Animal":AddAnimalDialog dialog = new AddAnimalDialog();
                break;
        }
    }

}
