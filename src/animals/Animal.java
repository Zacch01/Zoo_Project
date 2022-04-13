package animals;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import graphics.IAnimalBehavior;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * Abstract class that defines the attributes of the animals
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Mobile,IEdible
 */
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior {
    private String name;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 5;
    private int size;
    private Color col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    private Thread thread;
    private int x_dir;
    private int y_dir;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;


    public Animal(String name, Point p, int animalSize, int horizontalspeed, int verticalspeed, double weight, String animalcolor) {
        super(p);

        this.name = name;
        this.size = animalSize;
        this.horSpeed = horizontalspeed;
        this.verSpeed = verticalspeed;
        this.col = Color.getColor(animalcolor);
        this.weight = weight;
        this.coordChanged = false;
        this.x_dir = 1;
        this.y_dir = 1;
        this.eatCount=0;
    }

    public final static String PICTURE_PATH = "C:\\Users\\zacch\\IdeaProjects\\untitled\\src\\graphics\\assignment2_pictures\\";
    public void loadImages(String nm) {
        try { img1 = ImageIO.read(new File(PICTURE_PATH + nm)); }
        catch (IOException e) { System.out.println("Cannot load image");
            System.out.println(e.toString());}
    }

    public void drawObject (Graphics g) {
        g.setColor(col);
        if(x_dir==1)// giraffe goes to the right side
            g.drawImage(img1, getLocation().getx()-size/2, getLocation().gety()-size/10, size/2, size, pan);
        else // giraffe goes to the left side
            g.drawImage(img2, getLocation().getx(), getLocation().gety()-size/10, size/2, size, pan);
    }

    public String getColor() {return this.col.toString(); }
    public String getAnimalName() { return this.name; }
    public int getSize() { return this.size; }
    public void eatInc() {this.eatCount++; }
    public int getEatCount() {return this.eatCount; }
    public boolean getChanges () {return this.coordChanged; }
    public void setChanges (boolean state) {this.coordChanged = state; }
    public int getHorSpeed() { return this.horSpeed; }
    public int getVerSpeed() { return this.verSpeed; }



    /**
     * Constructor of the object Animal : it sets the attributes of the object
     *
     * @param name A String that represent the name of the Animal
     * @param p A Point object that represent the actual location of the Animal
     */
    public Animal(String name, Point p){
        super(p);
        MessageUtility.logConstractor("Animal", name);
        setName(name);
    }


    /**
     * Moving the animal to a new location, calculate the weight he lost on the way and update his new current weight
     *
     * @param p Point object that indicate a location
     * @return the distance traveled by the animal
     */
    @Override
    public double move(Point p)
    {
        double d = super.move(p);
        if(d!=0) {
            double temp = getWeight();
            setWeight(temp-(d*temp*0.00025));
        }
        MessageUtility.logBooleanFunction(this.name,"move",p, d != 0);
        return d;
    }


    /**
     * Getter method for the attribute diet
     * @see IDiet
     * @return An object diet which represents the type of diet of the animal
     */
    public IDiet getDiet(){
        MessageUtility.logGetter(this.name, "getDiet", this.diet);
        return this.diet;
    }



    /**
     * Calls the eat method (from interface IDiet) with the food given.
     * It returns the weight gained form the action. The eating was successful if the weight is greater than zero.
     * If the eating was successful, then the weight of the animal is update and calls the function makeSound, else nothing.
     *
     * @see IEdible,IDiet
     * @param food is a String representing the food type (an object of type EFoodType)
     * @return True if the eating was successful, else False
     */
    public boolean eat(IEdible food){
        double gainWeight = diet.eat(this, food);
        if(gainWeight>0){
            setWeight((this.weight+gainWeight));
            makeSound();
            MessageUtility.logBooleanFunction(this.name,"eat", food,true);
            return true;
        }
        MessageUtility.logBooleanFunction(this.name,"eat", food,false);
        return false;
    }


    /**
     * Setter method for the attribute weight
     * return True if the weight intake is in the valid range (greater than zero), else False
     *
     * @param weight is a Double representing of the weight intake of the Animal
     * @return True if the setter succeed, else False
     */
    public  boolean setWeight( double weight){
        if (weight<=0){
            MessageUtility.logSetter(this.name,"setWeight",weight,false);
            return false;
        }
        this.weight = weight;
        MessageUtility.logSetter(this.name,"setWeight",weight,true);
        return true;

    }


    /**
     * Setter method for the attribute diet
     * return True if the diet is in the valid options, else False
     * Note : diet can only be Omnivore, Herbivore or Carnivore
     * @param diet is an IDiet representing the diet of the animal
     * @return True if the setter succeed, else False
     */
    public boolean setDiet(IDiet diet){
        this.diet = diet;
        MessageUtility.logSetter(this.name,"setDiet",diet,true);
        return true;
    }


    /**
     * Getter method for the attribute name
     *
     * @return The Animal's name
     */
    public  String getName(){
        MessageUtility.logGetter(this.name, "getName", this.name);
        return this.name;
    }


    /**
     * Getter method for the attribute weight
     *
     * @return The Animal's weight
     */
    public  double getWeight(){
        MessageUtility.logGetter(this.name, "getWeight", this.weight);
        return this.weight;
    }


    /**
     * Getter method for Animal food type (all animals food type is MEAT, expect Lion which is NOTFOOD)
     * @see EFoodType
     * @return The Animal's food type
     */
    @Override
    public  EFoodType getFoodType(){
        MessageUtility.logGetter(this.name, "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }


    /**
     * Setter method for the attribute name
     * @param name is a String representing the name of the Animal
     * @return True if the setter succeed, else False
     */
    public boolean setName(String name){
        this.name = name;
        MessageUtility.logSetter(this.name,"setName",name,true);
        return true;
    }


    /**
     * Representation of the object as a string
     *
     * @return a String of the object data in the requested format
     */
    @Override
    public String toString() {return "[" + this.getClass().getSimpleName() + "] "+this.name;}

    public String getanimal(){return this.name + ", "+this.size+ ", "+this.col ;}

    public abstract void makeSound();
}
