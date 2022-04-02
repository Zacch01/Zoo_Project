package animals;

import diet.Herbivore;
import mobility.Point;
import privateutil.Chew;
import utilities.MessageUtility;


/**
 * A class representing a Turtle
 * Note : a Turtle is Herbivore
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Animal
 */
public class Turtle extends Chew {
    private int age;


    /**
     * The constructor of the object Turtle, it sets the attributes of the object
     * Note : Weight,Location and the age have a default value
     *
     * @param name A String that represent the name of the Turtle
     */
    public Turtle(String name){
        super(name,new Point(80,0));
        MessageUtility.logConstractor("Turtle", name);
        setWeight(1);
        setAge(1);
        setDiet(new Herbivore());
    }


    /**
     * The constructor of the object Turtle, it sets the attributes of the object
     * Note : Weight and the age have a default value
     *
     * @param name A String that represent the name of the Turtle
     * @param p A Point that represent the initial location of the Turtle
     */
    public Turtle(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        MessageUtility.logConstractor("Turtle", name);
        setWeight(1);
        setAge(1);
        setDiet(new Herbivore());
    }


    /**
     * Setter method for the attribute age
     * return True if the age is in the valid range, else False
     * Note : age is an Integer between 0 and 500
     *
     * @param age is an Integer representing the age of the Turtle
     * @return True if the setter succeed, else False
     */
    public boolean setAge( int age)
    {
        if (age<=500 && age>=0)
        {
            this.age = age;
            MessageUtility.logSetter(this.getName(), "setAge", this.age, true);
            return true;
        }
        MessageUtility.logSetter(this.getName(), "setAge", this.age, false);
        return false;
    }


    /**
     * Getter method for the attribute age
     * @return The object age
     */
    public int getAge() {
        MessageUtility.logGetter(this.getName(), "getAge", this.age);
        return this.age;
    }


    /**
     * The sound and the action that the Turtle makes
     */
    @Override
    public void chew(){
        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");
    }

}
