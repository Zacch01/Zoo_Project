package animals;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;


/**
 * Abstract class that defines the attributes of the animals
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Mobile,IEdible
 */
public abstract class Animal extends Mobile implements IEdible  {
    private String name;
    private double weight;
    private IDiet diet;


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
    public String toString() {return "[" + this.getClass().getSimpleName() + "] "+getName();}


    public abstract void makeSound();
}
