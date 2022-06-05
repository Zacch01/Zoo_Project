package DesignPatterns;

import animals.Animal;
import animals.*;
import graphics.ZooPanel;
import mobility.Point;


public class HerbivoreFactory implements AbstractZooFactory{
    @Override
    public Animal createAnimal(String name, int animalSize, int horizontalspeed, int verticalspeed, String animalcolor, ZooPanel pan) {
        return switch (name) {
            case "Elephant" -> new Elephant(animalSize, horizontalspeed, verticalspeed, animalcolor, pan);
            case "Giraffe" -> new Giraffe(animalSize, horizontalspeed, verticalspeed, animalcolor, pan);
            case "Turtle" -> new Turtle(animalSize, horizontalspeed, verticalspeed, animalcolor, pan);
            default -> null;
        };
    }
}