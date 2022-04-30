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

	/**
	 * Constructor of the object Cabbage
	 * @param pan A Zoopanel that represent the parent panel of the Cabbage
	 */
	public Cabbage(ZooPanel pan){
		super(pan);
		this.loadImages("cabbage.png");
	}


	/**
	 * Constructor of the object Cabbage
	 */
	public Cabbage() {
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}


}
