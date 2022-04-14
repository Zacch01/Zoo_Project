package graphics;

import animals.Animal;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class ZooPanel extends JPanel implements  ActionListener {
    private JPanel actionPanel;
    private JDialog addAnimalDialog;
    private ArrayList<Animal> Animallist;
    private JFrame f;
    private BufferedImage img = null;
    private Plant plant=null;

    public ZooPanel(JFrame frame){
        this.f = frame;
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


        //manageZoo();
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
                    AddAnimalDialog addanimaldialog = new AddAnimalDialog(this,Animallist);
                }
                break;
            case "Move Animal":
                if(Animallist.size()==0)
                    JOptionPane.showMessageDialog(null, "There are no animals in the zoo.", "Message", JOptionPane.WARNING_MESSAGE);
                else {
                    MoveAnimalDialog moveanimaldialog = new MoveAnimalDialog(Animallist);
                }
                break;
            case "Food": Object[] options = {"Lettuce", "Cabbage", "Meat"};
                int foodchoice = JOptionPane.showOptionDialog(f, "Please choose food:", "Food for animal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if(foodchoice == 0)
                    this.plant = new Lettuce(this);
                if(foodchoice == 1)
                    this.plant = new Cabbage(this);
                break;
            case "Info":JFrame infoframe = new JFrame("Info");
                Info model = new Info(Animallist);
                JTable table = new JTable(model);
                table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
                table.setPreferredScrollableViewportSize(new Dimension(500, 100));
                table.setFillsViewportHeight(true);
                infoframe.add(new JScrollPane(table),BorderLayout.CENTER);



                infoframe.setLocation((this.f.getSize().width/2)-250,-50+this.f.getSize().height/2);
                table.getColumnModel().getColumn(0).setHeaderValue("Animal");
                table.getColumnModel().getColumn(1).setHeaderValue("Color");
                table.getColumnModel().getColumn(2).setHeaderValue("Weight");
                table.getColumnModel().getColumn(3).setHeaderValue("Hor. Speed");
                table.getColumnModel().getColumn(4).setHeaderValue("Ver. Speed");
                table.getColumnModel().getColumn(5).setHeaderValue("Eat Counter");
                table.setValueAt("Total",Animallist.size(),1);
                int total =0;
                for(Animal an : Animallist)
                    total+= an.getEatCount();
                table.setValueAt(total,Animallist.size(),5);

                infoframe.pack();
                infoframe.setVisible(true);

                break;
        }
    }



    public void manageZoo() {
        while (true) {
            if (isChange())
                repaint();
            for (Animal animalpreda : Animallist)
            {
                for (Animal animalpreay : Animallist) {
                    if (animalpreda.equals(animalpreay))
                        continue;
                    if ((animalpreda.getDiet().canEat(animalpreay.getFoodType())) && (animalpreda.getWeight() > animalpreay.getWeight() * 2) && (animalpreda.calcDistance(animalpreay.getLocation()) > animalpreay.getSize())) {
                        animalpreda.eat(animalpreay);
                        Animallist.remove(Animallist.remove(Animallist.indexOf(animalpreay)));
                    }
                }
            }
        }
    }

    public boolean isChange(){
        for (Animal animal : Animallist)
            if(animal.getChanges())
            {
                animal.setChanges(false);
                return true;
            }
        return false;
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(img!=null)
            g.drawImage(img,0,0,getWidth(),getHeight(), this);
    }


}
