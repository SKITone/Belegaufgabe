package problemDef;

import java.util.*;

/**
 * Interface fuer alle Arten von Suchproblemklassen
 */
public interface SuchProblem {

	/**
	 * Methode zur Ermittlung des Startzustandes eines Suchproblems. 
	 * 
	 * @return Returns the start.
	 */
	public Zustand getStartState();
	
	/**
	 * Methode prueft, ob der uebergebene Zustand das Zielkriterium erfuellt. 
	 * 
	 * @param state Der zu pruefende Zustand.
	 * @return true, falls der Zustand ein Zielzustand ist, sonst false
	 */
	public boolean isGoalState(Zustand state);
	
	/**
	 * Methode, die alle Zustaende generiert, die in einem Schritt von
	 * einem gegebenen Zustand aus erreichbar sind.
	 * 
	 * @param state Zustand, dessen Nachfolger bestimmt werden sollen
	 * @return Liste mit den Nachfolgern von state
	 */
	public LinkedList<Zustand> genNf(Zustand state);
}
