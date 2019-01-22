package treeSearchDef;

/**
 * Schnittstelle fuer die Implementierung von Suchverfahren.
 */
public interface TreeSearch {
	
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
	 * liefert als Ergebnis einen Zielknoten zurueck. 
	 * 
	 * Falls kein Zielknoten gefunden wurde, wird null zurueckgeliefert.
	 * 
	 * @return Der gefundene Zielknoten oder null.
	 */
	public Knoten loop();
}
