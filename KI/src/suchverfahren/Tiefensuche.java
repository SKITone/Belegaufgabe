package suchverfahren;

import java.util.LinkedList;
import java.util.Stack;

import problemDef.SuchProblem;
import problemDef.Zustand;
import treeSearchDef.Knoten;
import treeSearchDef.TreeSearch;

public class Tiefensuche implements TreeSearch {

	Stack<Knoten> open = new Stack<Knoten>();
	SuchProblem suchproblem;
	int d_max=10;														//manuell begrenzte Tiefe (vermeidet Programmabsturz)
	
	public Tiefensuche(SuchProblem suchproblem, int d_max) {			//Konstruktor für Tiefensuche mit begrenzter Tiefe
		this.d_max=d_max;
		this.suchproblem=suchproblem;
		open.add(new Knoten(suchproblem.getStartState()));				//Die Warteschlange open wird mit dem Wurzelknoten des Suchbaums initialisiert. 
	}
	
	public Tiefensuche(SuchProblem suchproblem) {						////Konstruktor für Tiefensuche mit unbegrenzter Tiefe
		this.suchproblem=suchproblem;
		open.add(new Knoten(suchproblem.getStartState()));				//Die Warteschlange open wird mit dem Wurzelknoten des Suchbaums initialisiert. 
	}
	
	@Override
	public Knoten select() {
		// TODO Auto-generated method stub
		
		Knoten knoten=open.peek();										//letzte Knoten der Liste wird gewählt, Knoten wird aus Liste gelöscht										
		return knoten;
	}

	@Override
	public boolean isGoalNode(Knoten k) {
		// TODO Auto-generated method stub	
		
		return (suchproblem.isGoalState(k.getState()));			//Das Zielkriterium des zu lösenden Suchproblems wird auf den Zustand state von K angewendet.
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
		LinkedList<Zustand> successor= suchproblem.genNf(select().getState());	//Es werden alle Folgezustände des Zustands state von K erzeugt. Dies geschieht durch Anwendung aller möglichen Aktionen auf state.
		Knoten alterknoten=open.pop();
		while (!successor.isEmpty()) {
			Zustand zustand= successor.pollLast();
			//System.out.println(zustand);
			open.add(alterknoten.succNode(zustand));								//Für jeden Folgezustand state_new wird ein neuer Knoten im Suchbaum erzeugt
			//System.out.println("peek: "+open.peek());
		}
		
	}

	@Override
	public Knoten loop() {												//Last in First out
		// TODO Auto-generated method stub
		//System.out.println("offene Knoten: "+open.size());
		//System.out.println(open);
		//System.out.println("test");
		if (isGoalNode(select())) {
			System.out.println("Zustand: "+select().getState()+", vorheriger select(): "+select().getPredNode()+", Tiefe: "+select().getTiefe()+", Tiefenbegrenzung: "+d_max);
			//System.out.println("offene Knoten: "+open);
			//System.out.println("abgeschlossene Knoten: "+close);
			//System.out.println("abgeschlossene Knoten: "+close.size());
			System.out.println("offene Knoten: "+open.size());
			return select();
		}
		if (select().getTiefe()<d_max) {
			//close.add(K);
			update();
			return loop();
		} else {
			//close.add(K);
			if (!open.empty()) {
			return loop();			
		}	else {
			System.out.println("Zu Tief");
			//System.out.println("abgeschlossene Knoten: "+close.size());
			return select();
		}
		}
	}
}

