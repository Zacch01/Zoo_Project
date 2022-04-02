package zoo;

import java.lang.reflect.*;
import java.lang.*;
import animals.*;
import food.IEdible;
import diet.*;
import mobility.Mobile;
import mobility.Point;
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
        if(!(animal instanceof Mobile)&&!(Point.checkBoundaries(point)))
            return false;
        Animal typeofanimal = (Animal) animal;
        typeofanimal.move(point);
        //try exeption
        return true;
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
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = 0, choice,locationchoice,x,y;
        String name;
        System.out.print("Enter the number of animals : ");
        size = sc.nextInt();
        while (size < 3) {
            System.out.print("The number must be bigger than 2. Enter the number of animals : ");
            size = sc.nextInt();
        }
        Animal[] zoo = new Animal[size];
        Class c;
        ClassLoader cl = ClassLoader.getSystemClassLoader();
        System.out.println("In our Zoo, we have Lion, Bear, Giraffe, Turtle Elephant.\n");
        /*
        for (int i = 0; i < size; i++) {
            System.out.println("Please select the animal number " + (i + 1));
            System.out.println("1. Lion");
            System.out.println("2. Bear");
            System.out.println("3. Giraffe");
            System.out.println("4. Turtle");
            System.out.println("5. Elephant");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            choice = sc.nextInt();

            while (choice < 0 || choice > 6) {
                System.out.println("Invalid choice, please try again");
                choice = sc.nextInt();
            }
            if (choice == 6)
                System.exit(1);

            System.out.println("\nPlease enter the animal name");
            name = sc.next();


            System.out.print("\nDo you want to enter his location\n\t1 - Yes\n\t2 - No\n->");
            locationchoice = sc.nextInt();
            while (locationchoice != 1 && locationchoice != 2) {
                System.out.println("Invalid choice, please try again");
                locationchoice = sc.nextInt();
            }
            if (locationchoice == 1){
                System.out.print("\nPlease enter the location of the animal :\n\tx=");
                x = sc.nextInt();
                System.out.print("y=");
                y = sc.nextInt();
                switch (choice) {
                    case 1 -> zoo[i] = new Lion(name, new Point(x, y));
                    case 2 -> zoo[i] = new Bear(name, new Point(x, y));
                    case 3 -> zoo[i] = new Giraffe(name, new Point(x, y));
                    case 4 -> zoo[i] = new Turtle(name, new Point(x, y));
                    case 5 -> zoo[i] = new Elephant(name, new Point(x, y));
                }
            }
            else {
                switch (choice) {
                    case 1 -> zoo[i] = new Lion(name);
                    case 2 -> zoo[i] = new Bear(name);
                    case 3 -> zoo[i] = new Giraffe(name);
                    case 4 -> zoo[i] = new Turtle(name);
                    case 5 -> zoo[i] = new Elephant(name);
                }
            }
        }
        */
        for (int i=0; i<size; i++) {
            try {
                System.out.println("Please enter the animal you want to add: ");
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
                if (locationchoice == 1) {
                    Constructor con = c.getConstructor(String.class, Point.class);
                    System.out.print("\nPlease enter the location of the animal :\n\tx=");
                    x = sc.nextInt();
                    System.out.print("y=");
                    y = sc.nextInt();
                    zoo[i] = (Animal) con.newInstance(name, new Point(x, y));
                } else {
                    Constructor con = c.getConstructor(String.class);
                    zoo[i] = (Animal) con.newInstance(name);
                }
            } catch (Exception e) {
                System.out.println("You make an error. Try again");
                i = -1;
            }
        }
        for (Animal animal : zoo)
        {
            int movetox,movetoy;
            System.out.print("enter the point you want to move "+animal.getName()+"\n\tx=");
            movetox = sc.nextInt();
            System.out.print("\ty=");
            movetoy = sc.nextInt();
            while(!Point.checkBoundaries(new Point(movetox,movetoy)))
            {
                System.out.println("you enter point out of range : \nenter x between 0 to 800 and y between 0 to 600\n enter x=");
                movetox = sc.nextInt();
                System.out.print("y=");
                movetoy = sc.nextInt();
            }
            Point tmppoint = new Point(movetox,movetoy);
            if (move(animal,tmppoint))
                System.out.println(animal.getName()+"is moved the new weight is :"+animal.getWeight());
            else
                System.out.println(animal.getName()+"is not moved");

        }
        int timestoeat = size/2;
        Random rnd = new Random();
        for(int i=0;i<timestoeat;i++) {
            int rnd1 = rnd.nextInt(size);
            while (zoo[rnd1] == null)
                rnd1 = rnd.nextInt(size);
            int rnd2 = rnd.nextInt(size);
            while ((rnd1 != rnd2) && (zoo[rnd2] == null)) // to avoid from eating my self
                rnd2 = rnd.nextInt(size);
            //There is no chenge in the weight
            if (eat(zoo[rnd1], zoo[rnd2])) {
                System.out.println(zoo[rnd1].getName() + " eat " + zoo[rnd2].getName() + "the new weight is :" + zoo[rnd1].getWeight());
                zoo[rnd2]=null;
            }
            else
                System.out.println(zoo[rnd1].getName()+"dont eat");
        }


        sc.close();

    }
}
