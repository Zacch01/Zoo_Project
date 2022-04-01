package animals;

import diet.Carnivore;
import food.IEdible;
import mobility.Point;
import food.EFoodType;
import privateutil.Roar;
import utilities.MessageUtility;
import java.util.Random;


/**
 * A class representing a Lion
 * Note : a Lion is Carnivore
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public class Lion extends Roar {
    private int scarCount;


    /**
     * The constructor of the object Lion, it sets the attributes of the object
     * Note : Weight,Location and the scar count have a default value
     *
     * @param name A String that represent the name of the Lion
     */
    public Lion(String name){
        super(name,new Point(20,0));
        setWeight(408.2);
        this.scarCount = 0;
        setdiet(new Carnivore());
        //a checker
    }


    /**
     * The constructor of the object Lion, it sets the attributes of the object
     * Note : Weight and the scar count have a default value
     *
     * @param name A String that represent the name of the Lion
     * @param p A Point that represent the initial location of the Lion
     */
    public Lion(String name, Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(408.2);
        this.scarCount = 0;
        setdiet(new Carnivore());
        //a checker
    }


    /**
     * Setter method for the attribute scarCount
     * return True if the scarCount is in the valid range, else False
     * Note : scarCount is an Integer equal to or greater than zero
     *
     * @param scarCount is an Integer representing the scar count of the Lion
     * @return True if the setter succeed, else False
     */
    public boolean setScarCount(int scarCount) {
        if (scarCount >= 0) {
            this.scarCount = scarCount;
            MessageUtility.logSetter(this.getName(), "setScarCount", this.scarCount, true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setScarCount", scarCount, false);
        return false;
    }


    /**
     * Getter method for the attribute scarCount
     *
     * @return The object scar amount
     */
    public int getScarCount() {
        MessageUtility.logGetter(this.getName(), "getScarCount", this.scarCount);
        return this.scarCount;
    }


    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }


    public boolean eat(IEdible ed) {
        if (super.eat(ed)) {
            Random rand = new Random();
            int r = rand.nextInt(2);
            if (r == 1) {
                setScarCount(getScarCount()+1);
            }
            return true;
        }
        return false;
    }


    /**
     * The sound and the action that the Lion makes
     */
    public void roar(){
        MessageUtility.logSound(getName(),"Roars, then stretches and shakes its mane");
    }


    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }

}
