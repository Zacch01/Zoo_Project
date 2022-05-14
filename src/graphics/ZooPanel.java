package graphics;

import animals.Animal;
import plants.Cabbage;
import plants.Lettuce;
import plants.Plant;
import privateutil.Meat;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;



/**
 * A class representing the GUI main panel
 * Note : It inherits from JPanel and implements from ActionListener
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see JPanel
 * @see ActionListener
 */
public class ZooPanel extends JPanel implements  ActionListener, Runnable {
    private JPanel actionPanel;
    private JDialog addAnimalDialog;
    private ArrayList<Animal> Animallist;
    private ZooFrame f;
    private BufferedImage img = null;
    private Plant plant=null;
    private Meat meat =null;
    private Thread controller;
    /**
     * The constructor of the ZooPanel object: it sets the attributes of the object
     * Note : ZooPanel contain two panels, one for control buttons, and the other for the visual board
     */
    public ZooPanel(ZooFrame frame){
        this.f = frame;
        actionPanel = new JPanel(new FlowLayout());
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
        this.setLayout(new BorderLayout());
        this.add(actionPanel,BorderLayout.PAGE_END);
        this.controller = new Thread(this);
        this.controller.start();
    }

    /**
     * Invoked when an action occurs
     * @param e the event to be processed
     */
    public void actionPerformed(ActionEvent e)
    {
        switch (e.getActionCommand()){
            case "Exit":System.exit(0);
                break;
            case "Add Animal":
                if(Animallist.size()==10)
                    JOptionPane.showMessageDialog(this, "You cannot add more than 10 animals.", "Message", JOptionPane.WARNING_MESSAGE);
                else
                    new AddAnimalDialog(this,Animallist);
                break;

            case "Move Animal":
                if(Animallist.size()==0)
                    JOptionPane.showMessageDialog(this, "There are no animals in the zoo.", "Message", JOptionPane.WARNING_MESSAGE);
                else
                    new MoveAnimalDialog(this,Animallist);
                break;

            case "Food": Object[] options = {"Lettuce", "Cabbage", "Meat"};
                int foodchoice = JOptionPane.showOptionDialog(f, "Please choose food:", "Food for animal", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
                if(foodchoice == 0)
                    this.plant = new Lettuce(this);
                else if(foodchoice == 1)
                    this.plant = new Cabbage(this);
                else
                    this.meat =new Meat(this);

                repaint();
                break;

            case "Info": JFrame infoframe = new JFrame("Info");
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

                int total =0;
                for(Animal an : Animallist)
                    total+= an.getEatCount();
                JTable footer = new JTable(1, 6);
                footer.setValueAt("Total",0,0);
                footer.setValueAt(total,0,5);
                infoframe.add(footer,BorderLayout.SOUTH);

                infoframe.pack();
                infoframe.setVisible(true);
                break;

            case "Clear":
                this.Animallist.clear();
                this.plant = null;
                this.meat = null;
                repaint();
                break;
        }
    }

    /**
     * The controller of the program, follow after all the user actions and update the program accordingly
     * Check if one animal can eat another one
     * Check if one animal can eat a plant or the meat
     */
    public void manageZoo() {

            if (isChange())
                repaint();
            for (Animal animal : Animallist) {
                if (plant != null) {
                    if (animal.calcDistance(plant.getLocation()) <= animal.geteatdistance() && (animal.getDiet().canEat(plant.getFoodType()))) {
                        animal.eat(plant);
                        animal.eatInc();
                        plant = null;
                        repaint();
                    }
                }
                if (meat != null) {
                    if (animal.calcDistance(meat.getLocation()) <= animal.geteatdistance() && (animal.getDiet().canEat(meat.getFoodType()))) {
                        animal.eat(meat);
                        animal.eatInc();
                        meat = null;
                        repaint();
                    }
                }
            }
            for (Animal animalpreda : Animallist) {
                for (Animal animalpreay : Animallist) {
                    if (animalpreda.equals(animalpreay))
                        continue;
                    if ((animalpreda.getDiet().canEat(animalpreay.getFoodType())) && (animalpreda.getWeight() > animalpreay.getWeight() * 2) && (animalpreda.calcDistance(animalpreay.getLocation()) < animalpreay.getSize())) {
                        animalpreda.eat(animalpreay);
                        animalpreda.eatInc();
                        Animallist.remove(Animallist.indexOf(animalpreay));
                        animalpreay.stop();
                        repaint();
                        return;
                    }
                }
            }

    }


    /**
     * Check if anything has changed in our program
     * @return True if something have changed, else False
     */
    public boolean isChange(){
        for (Animal animal : Animallist)
            if(animal.getChanges())
            {
                animal.setChanges(false);
                return true;
            }
        return false;
    }


    /**
     * Printing all the components in our frame
     * @param g the graphics context
     */
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(plant!= null)
            plant.drawObject(g);
        if(meat!=null)
            meat.drawObject(g);
        if(Animallist.size()!=0)
            for(Animal animal :Animallist)
                animal.drawObject(g);
    }

    /**
     * Getter method for the attribute f
     * @return The frame where the panel is located
     */
    public ZooFrame getF(){return this.f;}

    @Override
    public void run() {
        while(true)
            manageZoo();
    }
}
