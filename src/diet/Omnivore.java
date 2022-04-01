package diet;

import food.EFoodType;
import food.IEdible;
import animals.Animal;

public class Omnivore implements IDiet {
    public boolean canEat(EFoodType food) {
        return food != EFoodType.NOTFOOD;
    }


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
    }
