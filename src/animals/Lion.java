package animals;

import diet.Carnivore;
import food.IEdible;
import mobility.Point;
import food.EFoodType;
import utilities.MessageUtility;

public class Lion extends Animal{
    private int scarCount;
    public Lion(String name){
        super(name,new Point(20,0));
        setweight(408.2);
        this.scarCount = 0;
        this.setdiet(new Carnivore());
        //a checker
    }

    public EFoodType getFoodtype() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.NOTFOOD);
        return EFoodType.NOTFOOD;
    }

    public void roar(){
        MessageUtility.logSound(getName(),"Roars, then stretches and shakes its mane");
    }

    public void makeSound(){
        roar();
    }




}
