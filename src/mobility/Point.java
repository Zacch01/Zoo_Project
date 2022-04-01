package mobility;


/**
 * A class to define position on a two-dimensional axis
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 */
public class Point {
    private int x;
    private int y;

    static private final int xmax = 800,ymax=600,xmin=0,ymin=0;


    /**
     * The constructor of the Point object, sets the attributes of the object
     *
     * @param x is an Integer representing the location on axis X
     * @param y is an Integer representing the location on axis Y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


    /**
     * The constructor of the Point object, sets the attributes of the object from a Point given
     *
     * @param point is an Object Point representing a location
     */
    public Point(Point point) {
        this.x = point.getx();
        this.y = point.gety();
    }


    /**
     * Setter method for the attributes x and y
     * return True if the coordinates x and y received are in the valid range, else False
     *
     * @param x is an Integer representing ta location on axis X
     * @param y is an Integer representing a location on axis Y
     * @return True if the setter succeed, else False
     */
    public boolean setpoint(int x,int y)
    {
        if((xmin<=x && x<=xmax)&&(ymin<=y && y<=ymax))
        {
            this.x=x;
            this.y=y;
            return true;
        }
        return false;
    }


    /**
     * Getter method for the attribute x
     *
     * @return The object location on axis X
     */
    public int getx()
    {
        return this.x;
    }


    /**
     * Getter method for the attribute y
     *
     * @return The object location on axis Y
     */
    public int gety()
    {
        return this.y;
    }


    /**
     * Check if the received point is in the valid axis border, and return the answer
     *
     * @param pointToCheck Object Point we want to check
     * @return True if the point in the valid border, else False
     */
    public static boolean checkBoundaries(Point pointToCheck){return (xmin<= pointToCheck.getx() && pointToCheck.getx()<=xmax)&&(ymin<= pointToCheck.gety() && pointToCheck.gety() <=ymax);}
}
