package animals;

import diet.Omnivore;
import graphics.ZooPanel;
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
     * Note : Name, Location and the fur color have a default value
     *
     * @param animalSize A int that represent the size of the Bear
     * @param horizontalspeed A int that represent the horizontal speed of the Bear
     * @param verticalspeed A int that represent the vertical speed of the Bear
     * @param animalColor A String that represent the color of the Bear image
     * @param pan A Zoopanel that represent the parent panel of the Bear
     */
    public Bear(int animalSize, int horizontalspeed, int verticalspeed, String animalColor, ZooPanel pan) {
        super("Bear", new Point(100, 5), animalSize, horizontalspeed, verticalspeed, animalSize * 1.5, animalColor, pan);
        this.furColor="GRAY";
        setDiet(new Omnivore());
        this.loadImages("bea_" + animalColor.toLowerCase().charAt(0));
    }

    /**
     * The constructor of the object Bear, it sets the attributes of the object
     * Note : Weight,Location and the fur color have a default value
     *
     * @param name A String that represent the name of the Bear
     */
    public Bear(String name){
        super(name,new Point(100,5));
        MessageUtility.logConstractor("Bear", name);
        setWeight(308.2);
        this.furColor="GRAY";
        setDiet(new Omnivore());
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
        if(!Point.checkBoundaries(p))
            setLocation(new Point(100,5));
        MessageUtility.logConstractor("Bear", name);
        setWeight(308.2);
        this.furColor="GRAY";
        setDiet(new Omnivore());
    }


    /**
     * The constructor of the object Bear, it sets the attributes of the object
     * Note : Weight and the location have a default value
     *
     * @param name A String that represent the name of the Bear
     * @param color A String that represent the fur color of the Bear
     */
    public Bear(String name,String color){
        super(name,new Point(100,5));
        MessageUtility.logConstractor("Bear", name);
        setWeight(308.2);
        if(!setFurColor(color))
            setFurColor("GRAY");
        setDiet(new Omnivore());
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
            MessageUtility.logSetter(this.getName(), "setFurColor", color, true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setFurColor", color, false);
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
    @Override
    public void roar(){
        MessageUtility.logSound(getName(),"Stands on its hind legs, roars and scratches its belly");
    }
}
