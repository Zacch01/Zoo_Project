package diet;

import food.*;
import animals.Animal;


/**
 * An interface to describe animal's diet
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 */
public interface IDiet {
    public boolean canEat(EFoodType food);
    double eat(Animal animal, IEdible food);
}
