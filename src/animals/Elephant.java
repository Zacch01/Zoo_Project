package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.Chew;
import utilities.MessageUtility;


/**
 * A class representing an Elephant
 * Note : an Elephant is Herbivore
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public class Elephant extends Chew {
    private double trunkLength;


    /**
     * The constructor of the object Elephant, it sets the attributes of the object
     * Note : Weight,Location and the trunk length have a default value
     *
     * @param name A String that represent the name of the Elephant
     */
    public Elephant(String name){
        super(name,new Point(50,90));
        setWeight(500);
        this.trunkLength = 1;
        setdiet(new Herbivore());
    }


    /**
     * The constructor of the object Elephant, it sets the attributes of the object
     * Note : Weight and the trunk length have a default value
     *
     * @param name A String that represent the name of the Elephant
     * @param p A Point that represent the initial location of the Elephant
     */
    public Elephant(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(500);
        this.trunkLength = 1;
        setdiet(new Herbivore());
    }


    /**
     * Setter method for the attribute trunkLength
     * return True if the trunkLength is in the valid range, else False
     * Note : trunkLength is a Double number between 0.5 and 3 meters
     *
     * @param trunkLength is a Double representing of the Elephant's trunk length
     * @return True if the setter succeed, else False
     */
    public boolean settrunkLength( double trunkLength)
    {
        if (trunkLength<=3 && trunkLength>=0.5)
        {
            this.trunkLength = trunkLength;
            return true;
        }
        return false;
    }


    /**
     * Getter method for the attribute trunkLength
     *
     * @return The Elephant's trunk length
     */
    public double getTrunkLength() {
        MessageUtility.logGetter(this.getName(), "getTrunkLength", this.trunkLength);
        return this.trunkLength;
    }


    /**
     * The sound and the action that the Elephant makes
     */
    public void chew(){
        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");
    }

}
