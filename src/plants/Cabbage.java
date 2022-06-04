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
	private static Cabbage instance = null;

	/**
	 * Constructor of the object Cabbage
	 * @param pan A Zoopanel that represent the parent panel of the Cabbage
	 */
	private Cabbage(ZooPanel pan){
		super(pan);
		this.loadImages("cabbage.png");
		MessageUtility.logConstractor("Cabbage", "Cabbage");
	}

	public static Cabbage getInstance(ZooPanel pan){
		if(instance == null)
			instance = new Cabbage(pan);
		return instance;
	}
}
