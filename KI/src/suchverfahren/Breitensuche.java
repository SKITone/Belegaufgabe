package suchverfahren;

import java.util.LinkedList;

import problemDef.SuchProblem;
import problemDef.Zustand;
import treeSearchDef.Knoten;
import treeSearchDef.TreeSearch;

public class Breitensuche implements TreeSearch {
	
	LinkedList<Knoten> open = new LinkedList<Knoten>(); //FIFO
	SuchProblem suchproblem;
	int d_max;
	Knoten knoten;
	
	public Breitensuche(SuchProblem suchproblem,int d_max) {
		this.d_max=d_max;
		this.suchproblem=suchproblem;
		open.add(new Knoten(suchproblem.getStartState()));				//Die Warteschlange open wird mit dem Wurzelknoten des Suchbaums initialisiert. 
	}

	@Override
	public Knoten select() {
		// TODO Auto-generated method stub
		knoten=open.poll();
		return knoten;
	}

	@Override
	public boolean isGoalNode(Knoten k) {
		// TODO Auto-generated method stub
		return suchproblem.isGoalState(k.getState());
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		LinkedList<Zustand> successor= suchproblem.genNf(knoten.getState());	//Es werden alle Folgezustände des Zustands state von K erzeugt. Dies geschieht durch Anwendung aller möglichen Aktionen auf state.
		while (!successor.isEmpty()) {
			Zustand zustand=successor.pop();
			open.add(knoten.succNode(zustand));								//Für jeden Folgezustand state_new wird ein neuer Knoten im Suchbaum erzeugt
		}
	}

	@Override
	public Knoten loop() {
		// TODO Auto-generated method stub
				knoten= select();
				//System.out.println("test");
				if (isGoalNode(knoten)) {
					System.out.println("Zustand: "+knoten.getState()+", vorheriger Knoten: "+knoten.getPredNode()+", Tiefe: "+knoten.getTiefe());
					//System.out.println("offene Knoten: "+open);
					//System.out.println("abgeschlossene Knoten: "+close);
					return knoten;
				}
				if (knoten.getTiefe()==9 || knoten.getTiefe()==d_max) {
					System.err.println("zu Tief - Abbruch");
					return knoten;
				}
				if (!open.isEmpty()) {
				update();	
				//System.out.println("test");
				return loop();
				} else {
					System.out.println("nichts gefunden");
					return knoten;
				}
	}

}
