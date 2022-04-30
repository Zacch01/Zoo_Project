package graphics;

/**
 * Interface to describe the behavior of an animal
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 */
public interface IAnimalBehavior {
    public String getAnimalName();
    public int getSize();
    public void eatInc();
    public int getEatCount();
    public boolean getChanges ();
    public void setChanges (boolean state);
}