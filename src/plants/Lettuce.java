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
	private static Lettuce instance = null;

	/**
	 * Constructor of the object Lettuce
	 * @param pan A Zoopanel that represent the parent panel of the Lettuce
	 */
	private Lettuce(ZooPanel pan){
		super(pan);
		this.loadImages("lettuce.png");
		MessageUtility.logConstractor("Lettuce", "Lettuce");
	}

	public static Lettuce getInstance(ZooPanel pan){
		if(instance == null)
			instance = new Lettuce(pan);
		return instance;
	}
}
