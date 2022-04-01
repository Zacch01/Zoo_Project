package privateutil;

import animals.Animal;
import mobility.Point;

public abstract class Chew extends Animal {
    public Chew(String name, Point p){
        super(name,p);
    }

    public void makeSound(){
        chew();
    }

    public abstract void chew();
}
