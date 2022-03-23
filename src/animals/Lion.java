package animals;

import diet.Carnivore;
import food.IEdible;
import mobility.Point;
import food.EFoodType;
import utilities.MessageUtility;
import java.util.Random;


public class Lion extends Animal{
    private int scarCount;

    public Lion(String name){
        super(name,new Point(20,0));
        setWeight(408.2);
        this.scarCount = 0;
        setdiet(new Carnivore());
        //a checker
    }

    public Lion(String name, Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(408.2);
        this.scarCount = 0;
        setdiet(new Carnivore());
        //a checker
    }

    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }

    public void roar(){
        MessageUtility.logSound(getName(),"Roars, then stretches and shakes its mane");
    }

    public String roar_or_chew(){
        return "Roar";
    }

    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }

    public boolean eat(IEdible ed) {
        if (super.eat(ed)) {
            Random rand = new Random();
            int r = rand.nextInt(2);
            if (r == 1) {
                this.scarCount++;
            }
            return true;
        }
        return false;
    }

}
