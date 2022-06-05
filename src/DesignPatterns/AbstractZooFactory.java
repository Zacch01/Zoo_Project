package DesignPatterns;

import animals.Animal;
import graphics.ZooPanel;
import mobility.Point;


public interface AbstractZooFactory {
    public Animal createAnimal(String name, int animalSize, int horizontalspeed, int verticalspeed, String animalcolor, ZooPanel pan);
}