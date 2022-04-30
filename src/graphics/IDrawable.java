package graphics;

import java.awt.*;

/**
 * Interface to control the draw functionality
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 */
public interface IDrawable {
    public final static String PICTURE_PATH = System.getProperty("user.dir")+"/assignment2_pictures/";
    public void loadImages(String nm);
    public void drawObject (Graphics g);
    public String getColor();
}