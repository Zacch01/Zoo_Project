package DesignPatterns;

import animals.Animal;

public class AnimalColorDecorator implements AnimalColor{
    private AnimalColor anicol;


    public AnimalColorDecorator(AnimalColor anicol){
        this.anicol = anicol;
    }

    @Override
    public void PaintAnimal(String col){
        anicol.PaintAnimal(col);
    }
}
