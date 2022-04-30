package privateutil;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;



/**
 * Abstract class that defines the chew for an animal
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public abstract class Chew extends Animal {

    /**
     * The constructor of the object Chew, it sets the attributes of the object
     *
     * @param name A String that represent the animal's name
     * @param location A Point that represent the animal's location
     * @param animalSize An int that represent the size of the Chew
     * @param horizontalspeed A int that represent the horizontal speed of the Chew
     * @param verticalspeed A int that represent the vertical speed of the Chew
     * @param weight A Double that represent the animal's weight
     * @param animalColor A String that represent the color of the Chew image
     * @param pan A Zoopanel that represent the parent panel of the Chew
     */
    public Chew (String name, Point location, int animalSize, int horizontalspeed, int verticalspeed, double weight, String animalColor, ZooPanel pan) {
        super(name,location, animalSize, horizontalspeed, verticalspeed, weight, animalColor,pan);
    }

    /**
     * Constructor of the object Chew : it sets the attributes of the object
     *
     * @param name A String that represent the name of the Animal
     * @param p A Point object that represent the actual location of the Animal
     */
    public Chew(String name, Point p){
        super(name,p);
    }



    /**
     * Function that defines an action
     * Call the function chew()
     */
    @Override
    public void makeSound(){
        chew();
    }

    public abstract void chew();
}
