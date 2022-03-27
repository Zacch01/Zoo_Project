package animals;

import diet.Carnivore;
import food.EFoodType;
import mobility.Point;
import utilities.MessageUtility;

public class Bear extends Roar{
    private String furColor;

    public Bear(String name){
        super(name,new Point(100,5));
        setWeight(308.2);
        this.furColor = "GRAY";
        setdiet(new Carnivore());
        //a checker
    }





    public Bear(String name,Point p){
        super(name,new Point(p.getx(), p.gety()));
        setWeight(308.2);
        this.furColor = "GRAY";
        setdiet(new Carnivore());
        //a checker
    }


    public boolean setFurColor(String color)
    {
        if(color.equals("GRAY")|| color.equals("BLACK")|| color.equals("WHITE")) {
            this.furColor = color;
            return true;
        }
        return false;
    }



    public void roar(){
        MessageUtility.logSound(getName(),"Stands on its hind legs, roars and scratches its belly");
    }
}
