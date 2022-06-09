package DesignPatterns;

import animals.Animal;
import animals.Bear;
import graphics.ZooPanel;

public class OmnivoreFactory implements AbstractZooFactory{
    @Override
    public Animal createAnimal(String name, int animalSize, int horizontalspeed, int verticalspeed, String animalcolor, ZooPanel pan) {
        if(name.equals("Bear"))
            return new Bear(animalSize, horizontalspeed, verticalspeed, animalcolor, pan);
        else
            return null;
    }
}