package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * A class representing a Cabbage
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Plant
 */
public class Cabbage extends Plant {

	public Cabbage(ZooPanel pan){
		super(pan);
		this.loadImages("cabbage.png");
	}


	/**
	 * Constructor of the object Lettuce
	 */
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}


}
