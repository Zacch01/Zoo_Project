package animals;

import diet.Herbivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Elephant extends Chew{
    private double trunkLength;

    public Elephant(String name){
        super(name,new Point(50,90));
        setWeight(500);
        this.trunkLength = 1;
        setdiet(new Herbivore());
    }

    public Elephant(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(500);
        this.trunkLength = 1;
        setdiet(new Herbivore());
    }

    public void chew(){
        MessageUtility.logSound(getName(),"Trumpets with joy while flapping its ears, then chews");
    }


    public boolean settrunkLength( double lenght)
    {
        if (lenght<=3 && lenght>=0.5)
        {
            this.trunkLength = lenght;
            return true;
        }
        return false;
    }
}
