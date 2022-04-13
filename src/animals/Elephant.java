package animals;

import diet.Herbivore;
import diet.Omnivore;
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



    public Elephant(int animalSize, int horizontalspeed, int verticalspeed, String animalColor) {
        super("Elephant", new Point(50, 90), animalSize, horizontalspeed, verticalspeed, animalSize * 10, animalColor);
        this.trunkLength=1;
        setDiet(new Herbivore());
        this.loadImages("elf_" + animalColor.toLowerCase().charAt(0) + "_1.png");
    }

    /**
     * The constructor of the object Elephant, it sets the attributes of the object
     * Note : Weight,Location and the trunk length have a default value
     *
     * @param name A String that represent the name of the Elephant
     */
    public Elephant(String name){
        super(name,new Point(50,90));
        MessageUtility.logConstractor("Elephant", name);
        setWeight(500);
        this.trunkLength=1;
        setDiet(new Herbivore());
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
        if(!Point.checkBoundaries(p))
            setLocation(new Point(50,90));
        MessageUtility.logConstractor("Elephant", name);
        setWeight(500);
        this.trunkLength=1;
        setDiet(new Herbivore());
    }


    /**
     * The constructor of the object Bear, it sets the attributes of the object
     * Note : Weight and the location have a default value
     *
     * @param name A String that represent the name of the Bear
     * @param trunkLength A Double that represent the trunk's length of the Elephant
     */
    public Elephant(String name,double trunkLength){
        super(name,new Point(50,90));
        MessageUtility.logConstractor("Elephant", name);
        setWeight(500);
        if(!settrunkLength(trunkLength))
            settrunkLength(1);
        setDiet(new Herbivore());
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
            MessageUtility.logSetter(this.getName(), "setTrunkLength", trunkLength, true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setTrunkLength", trunkLength, false);
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
    @Override
    public void chew(){
        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");
    }

}
