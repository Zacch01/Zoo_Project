package animals;

import mobility.Point;

public abstract class Roar extends Animal{
    public Roar(String name, Point p){
        super(name,p);
    }

    public void makeSound(){
        roar();
    }

    public abstract void roar();
}
