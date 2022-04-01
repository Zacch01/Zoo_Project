package zoo;

import java.lang.reflect.*;
import java.lang.*;
import animals.*;
import food.IEdible;
import mobility.Mobile;
import mobility.Point;
import java.util.Scanner;
import java.util.Random;

public class ZooActions {
    public static boolean eat(Object animal, IEdible food){
        if (animal instanceof Animal)
        {
            Animal eatinganimal = (Animal) animal;
            return eatinganimal.eat(food);
        }
        return false;

    }

    public static boolean move(Object animal, Point point){
        if(!(animal instanceof Mobile)&&!(Point.checkBoundaries(point)))
            return false;
        Animal animal2 = (Animal) animal;
        animal2.move(point);
        //try exeption

        return true;
    }

    public static void main(String[] args) {
        Lion ln = new Lion("yuval");
        Class st = ln.getClass();
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
                System.out.println("How would you like to call it?");
                name = sc.next();
                System.out.print("\nDo you want to enter his location\n\t1 - Yes\n\t2 - No\n->");
                locationchoice = sc.nextInt();
                while (locationchoice != 1 && locationchoice != 2) {
                    System.out.println("Invalid choice, please try again");
                    locationchoice = sc.nextInt();
                }
                c = cl.loadClass("animals."+type);
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
            System.out.println("enter the point you want to move "+animal.getName()+"\n\t enter x=");
            movetox = sc.nextInt();
            System.out.print("y=");
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
