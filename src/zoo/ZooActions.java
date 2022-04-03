package zoo;

import java.lang.reflect.*;
import java.lang.*;
import animals.*;
import food.IEdible;
import diet.*;
import mobility.Mobile;
import mobility.Point;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;


/**
 * Class for the action in the zoo
 * Runner class, contains the main method
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 */
public class ZooActions {
    /**
     * Getting an animal and a food, and check to which animal Object belong,
     * and check if the animal can eat the food given,
     * If it can return True, else False
     *
     * @param animal is an object Animal representing an animal
     * @param food is a String representing the food type (an object of type EFoodType)
     * @see IDiet
     * @return True if it can eat, else False
     */
    public static boolean eat(Object animal, IEdible food){
        if (animal instanceof Animal)
        {
            Animal eatinganimal = (Animal) animal;
            return eatinganimal.eat(food);
        }
        return false;

    }


    /**
     * Getting an animal and a point, and check to which animal Object belong,
     * check if the point is valid, and make move the animal to this point
     * If it can return True, else False
     *
     * @param animal is an Animal object representing animal
     * @param point is an object Point that indicate a location
     * @see Mobile
     * @return True if the animal have moved, else False
     */
    public static boolean move(Object animal, Point point){
        if(animal instanceof Animal)
            return false;
        Animal typeofanimal = (Animal) animal;
        return typeofanimal.move(point)!=0;
    }


    /**
     * Main function
     * Initialize an animal array with a minimum of 3 animals.
     * For each animal in the array, it makes an attempt to use the move method.
     * After that, raffles references of two animals at a time (a predator and a prey).
     * The predator makes an attempt to eat its prey.
     * If it's possible, then it eats it. Else there is no change.
     *
     * @see Animal,IDiet,Mobile
     * @param args set of arguments from the command line.
     * @exception
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0, choice,locationchoice,x,y;
        String name;
        System.out.print("Enter the number of animals : ");
        size = sc.nextInt();
        while (size < 3) {
            System.out.print("The number must be bigger than or equal to 3. Enter the number of animals : ");
            size = sc.nextInt();
        }
        ArrayList<Animal> zoo = new ArrayList<Animal>();
        Class c;
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println("\n\nIn our Zoo, we have Lion, Bear, Giraffe, Turtle Elephant.\n");

        for (int i=0; i<size; i++) {
            try {
                System.out.println("\n\nPlease enter the animal you want to add: ");
                String type = sc.next();
                c = cl.loadClass("animals."+type);
                System.out.println("How would you like to call it?");
                name = sc.next();
                System.out.print("\nDo you want to enter his location\n\t1 - Yes\n\t2 - No\n->");
                locationchoice = sc.nextInt();
                while (locationchoice != 1 && locationchoice != 2) {
                    System.out.println("Invalid choice, please try again");
                    locationchoice = sc.nextInt();
                }
                System.out.print("\n");
                if (locationchoice == 1) {
                    Constructor con = c.getConstructor(String.class, Point.class);
                    System.out.print("\nPlease enter the location of the animal :\n\tx=");
                    x = sc.nextInt();
                    System.out.print("\ty=");
                    y = sc.nextInt();
                    zoo.add((Animal) con.newInstance(name, new Point(x, y)));;
                } else {
                    Constructor con = c.getConstructor(String.class);
                    zoo.add((Animal) con.newInstance(name));
                }
            } catch (Exception e) {
                System.out.println("You make an error. Try again");
                i = -1;
            }
        }
        for (Animal animal : zoo)
        {
            int movetox,movetoy;
            System.out.print("\n\nEnter the point you want to move "+animal.getName()+"\n\tx=");
            movetox = sc.nextInt();
            System.out.print("\ty=");
            movetoy = sc.nextInt();
            Point tmppoint = new Point(movetox,movetoy);
            if (move(animal,tmppoint))
                System.out.println(animal.getName()+" is moved the new weight is :"+animal.getWeight());
            else
                System.out.println(animal.getName()+" is not moved");

        }
        int timestoeat = size/2;
        Random rnd = new Random();
        for(int i=0;i<timestoeat;i++) {
            int dynmsize=zoo.size();
            int rnd1 = rnd.nextInt(dynmsize);
            int rnd2 = rnd.nextInt(dynmsize);
            while (rnd1 == rnd2) // to avoid from eating my self
                rnd2 = rnd.nextInt(dynmsize);
            //There is no change in the weight
            if (eat(zoo.get(rnd1), zoo.get(rnd2))) {
                System.out.println(zoo.get(rnd1).getName() + " eat " + zoo.get(rnd2).getName() + " the new weight is :" + zoo.get(rnd1).getWeight());
                zoo.remove(rnd2);
                //zoo[rnd2]=null;
            }
            else
                System.out.println(zoo.get(rnd1).getName()+" dont eat");
        }


        sc.close();

    }
}
