package animals;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;

public abstract class Animal extends Mobile implements IEdible  {
    private String name;
    private double weight;
    private IDiet diet;

    public Animal(String name, Point p){
        super(p);
        this.name = name;
    }

    public abstract void makeSound();

    public boolean eat(IEdible ed){
        return diet.canEat(ed.getFoodType());
    }
    public  boolean setweight( double w){
        if (w==0)
            return false;
        this.weight += w;
        return true;

    }
    public abstract boolean setdiet( IDiet d);
    public  String getName(){return this.name;}
    public  double getWeight(){return this.weight;}



}
