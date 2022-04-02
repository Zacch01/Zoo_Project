package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;


/**
 * A class representing the Herbivores
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see IDiet
 */
public class Herbivore implements IDiet{
    /**
     * Getting a food and checking if the Herbivores can eat it
     * Note : Herbivores can only eat MEAT
     *
     * @param food is a String representing the food type (an object of type EFoodType)
     * @see EFoodType
     * @return True if the food is VEGETABLE, else False
     */
    @Override
    public boolean canEat(EFoodType food) {
        return food == EFoodType.VEGETABLE;
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
            return animal.getWeight()*0.07;
        }
        return 0;
    }


    /**
     * Representation of the object as a string
     *
     * @return a String of the object data in the requested format
     */
    @Override
    public String toString() {return "[" + this.getClass().getSimpleName() + "]";}
}