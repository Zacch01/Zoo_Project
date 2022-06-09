package mobility;

import java.util.Observable;


/**
 * Abstract class that defines the mobility
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Ilocatable
 */
public abstract class Mobile extends Observable implements Ilocatable {
    private Point location;
    private double totaldistance;
    private boolean flag;


    /**
     * Constructor of the Mobile object : it sets the attributes of the object
     * Note : It set the localization on (0,0) if the given location exceeds the boundaries
     * @param p A Point object that represent a location
     */
    public Mobile(Point p)
    {
        setLocation(p);
        this.totaldistance = 0;
    }


    /**
     * Getting a distance, and add it to the object's distance
     *
     * @param distance Distance that the object made
     */
    public void addTotalDistance(double distance)
    {
        this.totaldistance+=distance;
    }

    /**
     * Getting an object Point and calculate the distance between them
     * @param p Object Point that indicate a location
     * @return Distance between the two objects
     */
    public double calcDistance(Point p) {return Math.sqrt(Math.pow(getLocation().getx() - p.getx(), 2) + (Math.pow(getLocation().gety() - p.gety(), 2)));}


    /**
     * Getting an object Point, check if the object is in the valid borders,
     * If yes, then calculate the distance between them, and then relocate (this) to the new received location
     * And Finally add the distance traveled into the object totaldistance
     *
     * @param p Object Point that indicate a location
     * @return Distance made by the object (this)
     */
    public double move(Point p)
    {
        flag = false;
        double distance = calcDistance(p);
        if (setLocation(p)) {
            flag = true;
            addTotalDistance(distance);
            setChanged();
            notifyObservers();
            return distance;
        }
        return 0;
    }


    /**
     * Getter method for the attribute totalDistance
     *
     * @return The distance that the object made
     */
    public double getTotalDistance() {return this.totaldistance;}


    /**
     * Getting a new object Point, check if the object location is valid,
     * if its valid we change our location to the new one, else there is no changes
     *
     * @param p is an object Point that indicate a location
     * @return True if the location change, else False
     */
    @Override
    public boolean setLocation(Point p) {
        if (Point.checkBoundaries(p)) {
            this.location = new Point(p);
            return true;
        }
        this.location = new Point(0,0);
        return false;
    }


    /**
     * Getter method for the attribute location
     *
     * @return The object location
     */
    @Override
    public Point getLocation() {
        return this.location;
    }

    @Override
    public boolean hasChanged() {
        return flag;
    }
}
