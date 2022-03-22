package diet;

import food.*;
import animals.Animal;

public interface IDiet {
    public boolean canEat(EFoodType food);
    double eat(Animal animal, IEdible food);
}
