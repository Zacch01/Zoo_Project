package DesignPatterns;

import animals.Animal;
import plants.Plant;
import privateutil.Meat;
import java.util.ArrayList;

public class ZooMemento {
    private ArrayList<Animal> animals;
    private Meat meat=null;
    private Plant plant = null;
    private int background;

    public ZooMemento(ArrayList<Animal> animals, Meat meat, Plant plant, int background) throws CloneNotSupportedException {
        this.animals = new ArrayList<Animal>();
        for(int i = 0; i < animals.size(); i++)
        {
            Animal animal = (Animal)animals.get(i).clone();
            this.animals.add(animal);
        }
        if(plant != null)
            this.plant = (Plant) plant.clone();
        if(meat != null)
            this.meat = (Meat) meat.clone();
        this.background = background;
    }

    public ArrayList<Animal> getAnimalList() {return animals;}
    public Plant getplant() {return plant;}
    public Meat getmeat() {return meat;}
    public int getbackground() {return background;}

}
