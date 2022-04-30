package animals;

import diet.Carnivore;
import food.IEdible;
import graphics.ZooPanel;
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
     * Note : Name, Location and the scar count have a default value,
     *
     * @param animalSize A int that represent the size of the Lion
     * @param horizontalspeed A int that represent the horizontal speed of the Lion
     * @param verticalspeed A int that represent the vertical speed of the Lion
     * @param animalColor A String that represent the color of the Lion image
     * @param pan A Zoopanel that represent the parent panel of the Lion
     */
    public Lion(int animalSize, int horizontalspeed, int verticalspeed, String animalColor, ZooPanel pan) {
        super("Lion", new Point(20, 0), animalSize, horizontalspeed, verticalspeed, animalSize * 0.8, animalColor,pan);
        this.scarCount=0;
        setDiet(new Carnivore());
        this.loadImages("lio_" + animalColor.toLowerCase().charAt(0) + "_1.png");
    }


    /**
     * The constructor of the object Lion, it sets the attributes of the object
     * Note : Weight,Location and the scar count have a default value
     *
     * @param name A String that represent the name of the Lion
     */
    public Lion(String name){
        super(name,new Point(20,0));
        MessageUtility.logConstractor("Lion", name);
        setWeight(408.2);
        this.scarCount=0;
        setDiet(new Carnivore());
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
        if(!Point.checkBoundaries(p))
            setLocation(new Point(20,0));
        MessageUtility.logConstractor("Lion", name);
        setWeight(408.2);
        this.scarCount=0;
        setDiet(new Carnivore());
    }


    /**
     * The constructor of the object Lion, it sets the attributes of the object
     * Note : Weight and the location have a default value
     *
     * @param name A String that represent the name of the Lion
     * @param scarCount A Int that represent the scar's counter of the Lion
     */
    public Lion(String name, int scarCount){
        super(name,new Point(20,0));
        MessageUtility.logConstractor("Lion", name);
        setWeight(408.2);
        if(!setScarCount(scarCount))
            setScarCount(0);
        setDiet(new Carnivore());
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
            MessageUtility.logSetter(this.getName(), "setScarCount", scarCount, true);
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


    /**
     * Getter method for know the food type of the Lion
     * @see IEdible
     * @return The object's food type
     */
    @Override
    public EFoodType getFoodType() {
        MessageUtility.logGetter(this.getName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }



    /**
     * Calls the eat method (from Animal) with the food given.
     * If the eating was successful, then the number of scars has a chance in two to increase (+1)
     * @see Animal
     * @param food is a String representing the food type (an object of type EFoodType)
     * @return True if the eating was successful, else False
     */
    @Override
    public boolean eat(IEdible food) {
        if (super.eat(food)) {
            Random rand = new Random();
            int r = rand.nextInt(2);
            if (r == 1) {
                setScarCount(this.scarCount+1);
            }
            return true;
        }
        return false;
    }


    /**
     * The sound and the action that the Lion makes
     */
    @Override
    public void roar(){
        MessageUtility.logSound(getName(),"Roars, then stretches and shakes its mane");
    }

}
