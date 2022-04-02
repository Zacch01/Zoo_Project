package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;


/**
 * A class representing the Omnivores
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see IDiet
 */
public class Omnivore implements IDiet {
    /**
     * Getting a food and checking if the Omnivores can eat it
     * Note : Herbivores can either eat MEAT and VEGETABLE
     *
     * @param food is a String representing the food type (an object of type EFoodType)
     * @return True if the food is MEAT or VEGETABLE, else False
     * @see EFoodType
     */
    @Override
    public boolean canEat(EFoodType food) {
        return food != EFoodType.NOTFOOD;
    }


    /**
     * Getting Animal object and a food, and checking if the animal can eat the food using the canEat method,
     * If yes, calculate the gained weight, else the gained weight is zero
     *
     * @param animal is an object Animal
     * @param food   is a String representing the food type (an object of type EFoodType)
     * @return a Double representing of the gained weight
     */
    @Override
    public double eat(Animal animal, IEdible food) {
        Carnivore crv = new Carnivore();
        Herbivore hrb = new Herbivore();
        if (canEat(food.getFoodType())) {
            if (food.getFoodType() == EFoodType.MEAT) {
                return crv.eat(animal, food);
            }
            return hrb.eat(animal, food);
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
