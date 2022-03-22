package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Carnivore implements IDiet{
    public boolean canEat(EFoodType food) {
        return food == EFoodType.MEAT;
    }

    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodType())){
            return animal.getWeight()*0.1;
        }
        return 0;
    }
}