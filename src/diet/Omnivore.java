package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Omnivore implements IDiet{
    public boolean canEat(EFoodType food) {
        return food == EFoodType.MEAT||food == EFoodType.VEGETABLE;
    }

    public double eat(Animal animal, IEdible food) {
            return animal.getDiet().eat(animal,food);
        }
}
