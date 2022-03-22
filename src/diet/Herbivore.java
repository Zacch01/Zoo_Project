package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Herbivore {
    public boolean canEat(EFoodType food) {
        return food == EFoodType.VEGETABLE;
    }

    public double eat(Animal animal, IEdible food) {
        return 0;
    }
}