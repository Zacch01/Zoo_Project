package privateutil;

import food.EFoodType;
import food.IEdible;
import graphics.IDrawable;
import graphics.ZooPanel;
import mobility.Ilocatable;
import mobility.Point;
import utilities.MessageUtility;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class Meat implements IEdible, Ilocatable, IDrawable
{
    private int height;////////////////////////////////////////////////////////////
    private Point location;
    private int weight;
    private BufferedImage img;
    private ZooPanel pan;
    private String col;



    public void loadImages(String nm) {
        try { img = ImageIO.read(new File(PICTURE_PATH + nm)); }
        catch (IOException e) { System.out.println("Cannot load image");
            System.out.println(e.toString());}
    }

    public void drawObject (Graphics g) {
        g.drawImage(img, getLocation().getx(), getLocation().gety(), this.getHeight(), this.getHeight(), pan);
    }

    public String getColor(){return this.col; }


    public Meat(ZooPanel pan) {
        Random rand = new Random();
        this.height = rand.nextInt(90);//////////////////////////////////////////////////
        this.weight = rand.nextInt(36);
        this.location = new Point(pan.getWidth()/2-this.height/2, pan.getHeight()/2-this.weight/2-36);
        MessageUtility.logConstractor("Meat", "Meat");
        this.col = "Natural";
        this.pan=pan;
        loadImages("meat.gif");
    }

    /**
     * Getter method for know the food type of the Meat
     * @see IEdible
     * @return The object's food type
     */
    @Override
    public EFoodType getFoodType() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getFoodType", EFoodType.MEAT);
        return EFoodType.MEAT;
    }

    /**
     * Getter method for the attribute height
     * @return The object's height
     */
    public int getHeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getHeight", this.height);
        return this.height;
    }


    /**
     * Getter method for the attribute Location
     * @see Ilocatable
     * @return The object's location
     */
    @Override
    public Point getLocation() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getLocation", this.location);
        return this.location;
    }


    /**
     * Getter method for the attribute weight
     * @return The object's weight
     */
    public int getWeight() {
        MessageUtility.logGetter(this.getClass().getSimpleName(), "getWeight", this.weight);
        return weight;
    }

    /**
     * Setter method for the attribute height
     * return True if the height is in the valid range (greater or equal than zero),
     * @param height is a Integer representing of the new height
     * @return True if the setter succeed, else False
     */
    public boolean setHeight(int height) {

        boolean isSuccess = (height >= 0);
        if (isSuccess) {
            this.height = height;
        } else {
            this.height = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setHeight", height, isSuccess);
        return isSuccess;
    }


    /**
     * Getting a new object Point, check if the object location is valid,
     * if its valid we change the location of the Meat to the new one, else there is no changes
     *
     * @param newLocation is an object Point that indicate a location
     * @see Ilocatable
     * @return True if the location change, else False
     */
    @Override
    public boolean setLocation(Point newLocation) {
        boolean isSuccess = Point.checkBoundaries(newLocation);
        if (isSuccess) {
            this.location = newLocation;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setLocation", newLocation, isSuccess);
        return isSuccess;
    }


    /**
     * Setter method for the attribute weight
     * return True if the weight is in the valid range (greater or equal than zero),
     * @param weight is a Integer representing of the new weight
     * @return True if the setter succeed, else False
     */
    public boolean setWeight(int weight) {
        boolean isSuccess = (weight >= 0);
        if (isSuccess) {
            this.weight = weight;
        } else {
            this.weight = 0;
        }
        MessageUtility.logSetter(this.getClass().getSimpleName(), "setWeight", weight, isSuccess);

        return isSuccess;
    }


    /**
     * Representation of the object as a string
     *
     * @return a String of the object data in the requested format
     */
    @Override
    public String toString() {
        return "[" + this.getClass().getSimpleName() + "] ";
    }

}
