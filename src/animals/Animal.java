package animals;
import diet.IDiet;
import food.EFoodType;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import utilities.MessageUtility;

public abstract class Animal extends Mobile implements IEdible  {
    private String name;
    private double weight;
    private IDiet diet;

    public Animal(String name, Point p){
        super(p);
        this.name = name;
    }

    public double move(Point p)
    {
        double d = super.move(p);
        setWeight(this.weight-(d*this.weight*0.00025));
        return d;
    }

    public IDiet getDiet(){return diet;}

    public abstract void makeSound();

    public boolean eat(IEdible ed){
        if(diet.canEat(ed.getFoodType())){
            makeSound();
            return true;
        }
        return false;
    }
    public  boolean setWeight( double w){
        if (w==0)
            return false;
        this.weight += w;
        return true;

    }
    public boolean setdiet( IDiet d){
        this.diet = d;
        return true;
    }
    public  String getName(){return this.name;}
    public  double getWeight(){return this.weight;}
    public  EFoodType getFoodType(){return EFoodType.MEAT;}
    public void setName(String name){
        this.name = name;
        // in main this need a void function but in her pdf it need bool
    }



}
