package mobility;


/**
 * An interface to describe the localisation
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 */
public interface Ilocatable {
    public Point getLocation();
    public boolean setLocation(Point p);
}
