package plants;

import graphics.ZooPanel;
import utilities.MessageUtility;

/**
 * A class representing a Lettuce
 *
 * @version 17.0.2
 * @author Attias Zaccharie, Amar Yuval
 * @see Plant
 */
public class Lettuce extends Plant {

	/**
	 * Constructor of the object Lettuce
	 * @param pan A Zoopanel that represent the parent panel of the Lettuce
	 */
	public Lettuce(ZooPanel pan){
		super(pan);
		this.loadImages("lettuce.png");
	}


	/**
	 * Constructor of the object Lettuce
	 */
	public Lettuce() {
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}
}
