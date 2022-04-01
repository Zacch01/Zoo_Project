package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;


/**
 * A class representing the Carnivores
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see IDiet
 */
public class Carnivore implements IDiet{
    /**
     * Getting a food and checking if the Carnivore can eat it
     * Note : Carnivores can only eat MEAT
     *
     * @param food is a String representing the food type (an object of type EFoodType)
     * @see EFoodType
     * @return True if the food is MEAT, else False
     */
    @Override
    public boolean canEat(EFoodType food) {
        return food == EFoodType.MEAT;
    }


    /**
     * Getting Animal object and a food, and checking if the animal can eat the food using the canEat method,
     * If yes, calculate the gained weight, else the gained weight is zero
     *
     * @param animal is an object Animal
     * @param food is a String representing the food type (an object of type EFoodType)
     * @return a Double representing of the gained weight
     */
    @Override
    public double eat(Animal animal, IEdible food) {
        if (canEat(food.getFoodType())){
            return animal.getWeight()*0.1;
        }
        return 0;
    }
}