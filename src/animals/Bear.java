package animals;

import diet.Omnivore;
import mobility.Point;
import privateutil.Roar;
import utilities.MessageUtility;


/**
 * A class representing a Bear
 * Note : a Bear is Omnivore
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public class Bear extends Roar {
    private String furColor;


    /**
     * The constructor of the object Bear, it sets the attributes of the object
     * Note : Weight,Location and the fur color have a default value
     *
     * @param name A String that represent the name of the Bear
     */
    public Bear(String name){
        super(name,new Point(100,5));
        setWeight(308.2);
        this.furColor = "GRAY";
        setdiet(new Omnivore());
    }



    /**
     * The constructor of the object Bear, it sets the attributes of the object
     * Note : Weight and the fur color have a default value
     *
     * @param name A String that represent the name of the Bear
     * @param p A Point that represent the initial location of the Bear
     */
    public Bear(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(308.2);
        this.furColor = "GRAY";
        setdiet(new Omnivore());
    }


    /**
     * Setter method for the attribute furColor
     * return True if the furColor is in the valid options, else False
     * Note : furColor is a String which can be GRAY, WHITE or BLACK
     *
     * @param color is a String representing of the Bear's fur color
     * @return True if the setter succeed, else False
     */
    public boolean setFurColor(String color)
    {
        if(color.equals("GRAY")|| color.equals("BLACK")|| color.equals("WHITE")) {
            this.furColor = color;
            return true;
        }
        return false;
    }


    /**
     * Getter method for the attribute furColor
     * @return The Bear's fur color
     */
    public String getFurColor() {
        MessageUtility.logGetter(this.getName(), "getFurColor", this.furColor);
        return this.furColor;
    }


    /**
     * The sound and the action that the Bear makes
     */
    public void roar(){
        MessageUtility.logSound(getName(),"Stands on its hind legs, roars and scratches its belly");
    }
}
