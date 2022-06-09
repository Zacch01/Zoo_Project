package DesignPatterns;

import animals.Animal;
import animals.Lion;
import graphics.ZooPanel;


public class CarnivoreFactory implements AbstractZooFactory{
    @Override
    public Animal createAnimal(String name, int animalSize, int horizontalspeed, int verticalspeed, String animalcolor, ZooPanel pan) {
        if(name.equals("Lion"))
            return new Lion(animalSize, horizontalspeed, verticalspeed, animalcolor, pan);
        else
            return null;
    }
}