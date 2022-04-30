package animals;

import diet.Herbivore;
import graphics.ZooPanel;
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
     * Note : Name, Location and the neck length have a default value
     *
     * @param animalSize A int that represent the size of the Giraffe
     * @param horizontalspeed A int that represent the horizontal speed of the Giraffe
     * @param verticalspeed A int that represent the vertical speed of the Giraffe
     * @param animalColor A String that represent the color of the Giraffe image
     * @param pan A Zoopanel that represent the parent panel of the Giraffe
     */
    public Giraffe(int animalSize, int horizontalspeed, int verticalspeed, String animalColor, ZooPanel pan) {
        super("Giraffe", new Point(50, 0), animalSize, horizontalspeed, verticalspeed, animalSize * 2.2, animalColor,pan);
        this.neckLength =1.5;
        setDiet(new Herbivore());
        this.loadImages("grf_" + animalColor.toLowerCase().charAt(0) + "_1.png");
    }

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
        this.neckLength =1.5;
        setDiet(new Herbivore());
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
        if(!Point.checkBoundaries(p))
            setLocation(new Point(50,0));
        MessageUtility.logConstractor("Giraffe", name);
        setWeight(450);
        this.neckLength =1.5;
        setDiet(new Herbivore());
    }


    /**
     * The constructor of the object Giraffe, it sets the attributes of the object
     * Note : Weight and Location have a default value
     *
     * @param name A String that represent the name of the Giraffe
     * @param neckLength A Double that represent the neck's length of the Giraffe
     */
    public Giraffe(String name, double neckLength){
        super(name,new Point(50,0));
        MessageUtility.logConstractor("Giraffe", name);
        setWeight(450);
        if(!setNeckLength(neckLength))
            setNeckLength(1.5);
        setDiet(new Herbivore());
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
            MessageUtility.logSetter(this.getName(), "setNeckLength", neckLength, true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setNeckLength", neckLength, false);
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
    @Override
    public void chew(){
        MessageUtility.logSound(getName(),"Bleats and Stomps its legs, then chews");
    }
}
