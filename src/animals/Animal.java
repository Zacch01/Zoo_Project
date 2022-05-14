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
public abstract class Animal extends Mobile implements IEdible, IDrawable, IAnimalBehavior, Runnable {
    private String name;
    private double weight;
    private IDiet diet;
    private final int EAT_DISTANCE = 10;
    private int size;
    private String col;
    private int horSpeed;
    private int verSpeed;
    private boolean coordChanged;
    protected Thread thread;
    protected boolean threadSuspended;
    private int x_dir;
    private int y_dir;
    private int eatCount;
    private ZooPanel pan;
    private BufferedImage img1, img2;
    private boolean exitt = false;


    public void setSuspended(){
        this.thread.suspend();
    }

    public void setResumed(){
        this.thread.resume();
    }

    public void stop(){exitt =true;}

    @Override
    public void run() {
        synchronized (this) {
            while (!exitt || !threadSuspended) {

                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                int new_x = this.getLocation().getx() + horSpeed * x_dir;
                int new_y = this.getLocation().gety() + verSpeed * y_dir;
                if (new_x>=800)
                    x_dir=-1;
                if (new_x<=0)
                    x_dir=1;
                if (new_y>=600)
                    y_dir=-1;
                if (new_y<=0)
                    y_dir=1;
                this.move(new Point(new_x,new_y));
            }
        }

    }




    /**
     * Constructor of the object Animal : it sets the attributes of the object
     *
     * @param name A String that represent the name of the Animal
     * @param p A Point object that represent the actual location of the Animal
     * @param animalSize A String that represent the animal's size
     * @param horizontalspeed An Integer that represent the animal's horizontal speed
     * @param verticalspeed An Integer that represent the animal's vertical speed
     * @param weight A Double that represent the animal's weight
     * @param animalcolor A String that represent the animal's color
     * @param pan is a ZooPanel representing the animal GUI Panel
     */
    public Animal(String name, Point p, int animalSize, int horizontalspeed, int verticalspeed, double weight, String animalcolor,ZooPanel pan) {
        super(p);
        this.thread = new Thread(this);
        this.thread.start();
        this.threadSuspended = false;
        this.name = name;
        this.size = animalSize;
        this.horSpeed = horizontalspeed;
        this.verSpeed = verticalspeed;
        this.col = animalcolor;
        this.weight = weight;
        this.coordChanged = true;
        this.x_dir = 1;
        this.y_dir = 1;
        this.eatCount=0;
        this.pan =pan;
    }



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
            setChanges(true);
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
     * Getter method for the attribute col
     *
     * @return The animal color
     */
    public String getColor(){return this.col; }

    /**
     * Getter method for the attribute name
     *
     * @return The animal's name
     */
    public String getAnimalName() { return this.name; }

    /**
     * Getter method for the attribute size
     *
     * @return The animal's size
     */
    public int getSize() { return this.size; }

    /**
     * Getter method for the attribute eatcount
     *
     * @return The animal's eat counter
     */
    public int getEatCount() {return this.eatCount; }

    /**
     * Increasing eat counter field eatcount of the animal by one
     */
    public void eatInc() { this.eatCount++; }

    /**
     * Getter method for the attribute coordChanged
     * @return If the coordinate of the animal changed
     */
    public boolean getChanges () {return this.coordChanged; }

    /**
     * Change the status of coordChanged of the animal
     *
     * @param state is a Boolean representing the status coordChanged of the Animal
     */
    public void setChanges (boolean state) {this.coordChanged = state; }

    /**
     * Getter method for the attribute horSpeed
     * @return The animal's horizontal speed
     */
    public int getHorSpeed() { return this.horSpeed; }

    /**
     * Getter method for the attribute verSpeed
     * @return The animal's vertical speed
     */
    public int getVerSpeed() { return this.verSpeed; }

    /**
     * Getter method for the attributes of the animal
     * @return The animal's attributes
     */
    public String getanimal(){return this.name + ", "+this.size+ ", "+this.col+ ", x="+this.getLocation().getx()+ ", y="+getLocation().gety() ;}

    /**
     * Getter method for the attributes EAT_DISTANCE
     * @return The animal's EAT_DISTANCE
     */
    public int geteatdistance(){return EAT_DISTANCE;}


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
     * load image method for the attribute img1
     * Note : catch error from IOException if cannot load the image
     *
     * @param nm is a String representing the name animal type
     */

    public void loadImages(String nm) {
        try { img1 = ImageIO.read(new File(PICTURE_PATH + nm+ "_1.png"));
            img2 = ImageIO.read(new File(PICTURE_PATH + nm+ "_2.png"));}
        catch (IOException e) { System.out.println("Cannot load image");
            System.out.println(e.toString());}
    }

    /**
     * draw image method for the attribute img1
     * Note : draw the image in first time as default location , paint different image in case of different side
     *
     * @param g is a Graphics object that return from repaint to paintComponent
     */

    public void drawObject (Graphics g) {
        if(x_dir==1)//right side
            g.drawImage(img1, getLocation().getx()-size/2, getLocation().gety()-size/10, size/2, size, pan);
        else //left side
            g.drawImage(img2, getLocation().getx(), getLocation().gety()-size/10, size/2, size, pan);
    }
    

    /**
     * Representation of the object as a string
     *
     * @return a String of the object data in the requested format
     */
    @Override
    public String toString() {return "[" + this.getClass().getSimpleName() + "] "+this.name;}


    public abstract void makeSound();
}
