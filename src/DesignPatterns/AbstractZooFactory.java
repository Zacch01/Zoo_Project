package DesignPatterns;

import animals.Animal;
import graphics.ZooPanel;


public interface AbstractZooFactory {
    Animal createAnimal(String name, int animalSize, int horizontalspeed, int verticalspeed, String animalcolor, ZooPanel pan);
}