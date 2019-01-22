package treeSearchDef;

import java.util.LinkedList;

/**
 * Schnittstelle fuer die Implementierung von Suchverfahren, die statt des ersten
 * gefundenen Zielknotens eine Liste aller gefundenen Zielknoten liefern.
 * 
 * @author schwen
 * last modified 30.04.2018
 */
public interface TreeSearchAllSolutions {
	
	/**
	 * Auswahl eines Knotens aus der Menge der noch nicht geprueften Knoten.
	 * 
	 * @return Knoten, der vom Suchverfahren geprueft werden soll
	 */
	public Knoten select();
	
	/**
	 * Ueberprueft einen Knoten des Suchbaums, ob er das Zielkriterium
	 * des zu loesenden Suchproblems erfuellt. 
	 * 
	 * Das Suchproblem ist Teil einer Instanz von Treeserach und wird dieser 
	 * beim Erzeugen der Instanz uebergeben.
	 * 
	 * @param k der zu pruefende Knoten
	 * @return liefert true, wenn das Zielkriterium des Suchproblems
	 * erfuellt wird, sonst false.
	 */
	public boolean isGoalNode(Knoten k);
	
	/**
	 * Aktualisiert die Menge der noch zu testenden Knoten.
	 */
	public void update();
	
	/**
	 * Benutzt die drei Methoden select, isGoalNode und update fuer die Suche und 
	 * liefert als Ergebnis eine Liste aller Zielknoten zurueck. 
	 * 
	 * @return Eine Liste aller Zielknoten.
	 */
	public LinkedList<Knoten> loop();
}