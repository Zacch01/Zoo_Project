package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.Chew;
import utilities.MessageUtility;


/**
 * A class representing a Giraffe
 * Note : a Giraffe is Herbivore
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public class Giraffe extends Chew {
    private double neckLength;


    /**
     * The constructor of the object Giraffe, it sets the attributes of the object
     * Note : Weight,Location and the neck length have a default value
     *
     * @param name A String that represent the name of the Giraffe
     */
    public Giraffe(String name){
        super(name,new Point(50,0));
        MessageUtility.logConstractor("Giraffe", name);
        setWeight(450);
        setNeckLength(1.5);
        setdiet(new Herbivore());
    }


    /**
     * The constructor of the object Giraffe, it sets the attributes of the object
     * Note : Weight and the neck length have a default value
     *
     * @param name A String that represent the name of the Giraffe
     * @param p A Point that represent the initial location of the Giraffe
     */
    public Giraffe(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        MessageUtility.logConstractor("Giraffe", name);
        setWeight(450);
        setNeckLength(1.5);
        setdiet(new Herbivore());
    }


    /**
     * Setter method for the attribute neckLength
     * return True if the neckLength is in the valid range, else False
     * Note : neckLength is a Double number between 1 and 2.5 meters
     *
     * @param neckLength is a Double representing of the Giraffe's neck length
     * @return True if the setter succeed, else False
     */
    public boolean setNeckLength( double neckLength)
    {
        if (neckLength<=2.5 && neckLength>=1)
        {
            this.neckLength = neckLength;
            MessageUtility.logSetter(this.getName(), "setNeckLength", this.neckLength, true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setNeckLength", this.neckLength, false);
        return false;
    }


    /**
     * Getter method for the attribute neckLength
     *
     * @return The object neck length
     */
    public double getNeckLength() {
        MessageUtility.logGetter(this.getName(), "getNeckLength", this.neckLength);
        return this.neckLength;
    }


    /**
     * The sound and the action that the Giraffe makes
     */
    public void chew(){
        MessageUtility.logSound(getName(),"Bleats and Stomps its legs, then chews");
    }
}
