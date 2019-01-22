package treeSearchDef;

import problemDef.Zustand;

/**
 * Oberklasse fuer alle Arten von Knoten von Suchverfahren.
 * 
 */
public class Knoten {
	private Zustand state;
	private int tiefe = 0;
	private Knoten predNode;
	private String action;
	
	/**
	 * Erzeugt einen Knoten, in dem als Zustand das Objekt st eingetragen ist. 
	 * @param st der einzutragende Zustand
	 */
	public Knoten(Zustand st) {
		this.state=st;
		this.predNode=null;
		this.action = new String();
	}
	public Zustand getState() {
		return state;
	}

	/**
	 * Liefert den Wert fuer die Tiefe, auf der sich der Knoten im Suchbaum befindet. 
	 * @return Wert der Tiefe als natuerliche Zahl
	 */
	public int getTiefe() {
		return tiefe;
	}

	/**
	 * Liefert den Vorgaengerknoten des aktuellen Knotens im Suchbaum. 
	 * 
	 * Falls der Knoten der Wurzelknoten ist, wird null zurueckgegeben.
	 * @return der Vorgaengerknoten
	 */
	public Knoten getPredNode() {
		return predNode;
	}

	public void setAction(String action) {
		this.action = new String(action);
	}

	/**
	 * Methode erzeugt einen neuen Knoten, der Nachfolger des aktuellen
	 * Knotens ist und als Zustand den vorgegebenen Zustand enthaelt.
	 * 
	 * @param st Der Zustand, der im neuen Knoten eingetragen werden soll.
	 * @return ein neuer Knoten, der Nachfolger des aufrufenden Knotens ist
	 */
	public Knoten succNode(Zustand st) {
		Knoten next = new Knoten(st);
		next.tiefe=this.tiefe+1;
		next.predNode=this;
		next.setAction("Schritt");
		return next;
	}

	public String toString() {
		String ant = "" + state;
		return ant;
	}
}
