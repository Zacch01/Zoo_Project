package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Herbivore implements IDiet{
    public boolean canEat(EFoodType food) {
        return food == EFoodType.VEGETABLE;
    }

    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodType())){
            return animal.getWeight()*0.07;
        }
        return 0;
    }
}