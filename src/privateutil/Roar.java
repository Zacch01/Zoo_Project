package privateutil;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;


/**
 * Abstract class that defines the roar for an animal
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public abstract class Roar extends Animal {

    public Roar (String name, Point location, int animalSize, int horizontalspeed, int verticalspeed, double weight, String animalColor, ZooPanel pan) {
        super(name,location, animalSize, horizontalspeed, verticalspeed, weight, animalColor, pan);
    }

    /**
     * Constructor of the object Roar : it sets the attributes of the object
     *
     * @param name A String that represent the name of the Animal
     * @param p A Point object that represent the actual location of the Animal
     */
    public Roar(String name, Point p){
        super(name,p);
    }


    /**
     * Function that defines an action
     * Call the function chew()
     */
    @Override
    public void makeSound(){roar();}

    public abstract void roar();
}
