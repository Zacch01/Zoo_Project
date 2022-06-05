package DesignPatterns;

import animals.Animal;

public class AnimalColorDecorator implements AnimalColor{
    private Animal animal;

    public AnimalColorDecorator(Animal animal){
        super();
        this.animal = animal;
    }

    @Override
    public void PaintAnimal(String col){
        animal.setColor(col);
        switch (animal.getAnimalName()) {
            case "Bear" -> animal.loadImages("bea_" + animal.getColor().toLowerCase().charAt(0));
            case "Elephant" -> animal.loadImages("elf_" + animal.getColor().toLowerCase().charAt(0));
            case "Giraffe" -> animal.loadImages("grf_" + animal.getColor().toLowerCase().charAt(0));
            case "Lion" -> animal.loadImages("lio_" + animal.getColor().toLowerCase().charAt(0));
            case "Turtle" -> animal.loadImages("trt_" + animal.getColor().toLowerCase().charAt(0));
        }
    }
}
