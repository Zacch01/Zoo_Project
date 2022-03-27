package animals;

import diet.Herbivore;
import mobility.Point;
import utilities.MessageUtility;

public class Turtle extends Chew{
    private int age;

    public Turtle(String name){
        super(name,new Point(80,0));
        setWeight(1);
        this.age = 1;
        setdiet(new Herbivore());
    }

    public Turtle(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(1);
        this.age = 1;
        setdiet(new Herbivore());
    }

    public void chew(){
        MessageUtility.logSound(getName(),"Retracts its head in then eats quietly");
    }


    public boolean setAge( int age)
    {
        if (age<=500 && age>=0)
        {
            this.age = age;
            return true;
        }
        return false;
    }
}
