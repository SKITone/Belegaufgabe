package problemExamples;

import java.util.LinkedList;

import problemDef.*;

public class DameProblem extends java.lang.Object implements SuchProblem {
	
	private int laenge, DameAnzahl;											//laenge = hoehe und breite des Spielfelds	
	
	public DameProblem(int laenge) {
		this.laenge=laenge-1;
		this.DameAnzahl=laenge;
	}

	@Override
	public Zustand getStartState() {
		// TODO Auto-generated method stub
		
		char[][] Feld= new char[laenge+1][laenge+1];					// leeres Feld
		for (int i=0; i<=laenge; i++) {
			for (int j=0; j<=laenge; j++) {
				Feld[i][j]=' ';
			}
		}
		DameZustand start = new DameZustand(Feld,0);
		return start;
	}

	@Override
	public boolean isGoalState(Zustand state) {				//alle Tupel sind belegt
		// TODO Auto-generated method stub
		
		DameZustand current= (DameZustand) state;
		int Damen=0;
		for (int i=0; i<=laenge; i++) {
			for (int j=0; j<=laenge; j++) {
				if (current.Feld[i][j]=='O') {
					Damen++;
					//System.out.println(Damen);
				}
			}
		}
		return (Damen>=DameAnzahl);
	}

	@Override
	public LinkedList<Zustand> genNf(Zustand state) {
		// TODO Auto-generated method stub
		
		DameZustand z = (DameZustand) state;
		
		LinkedList<Zustand> successor= new LinkedList <Zustand>();
		//System.out.println(ausgabe(feld));

		//System.out.println("start");
		//System.out.println(ausgabe(z.Feld));
		
		int Tiefe=z.getTiefe();
		int letzteDame_i= z.letzteDame_i;
		
		if (z.getTiefe()==0) {
			
			for (int j=0; j<=(laenge/2)+(laenge%2); j++){
						
						char[][] Feld= new char[laenge+1][laenge+1];
						for (int x=0; x<=laenge; x++) {
							for (int y=0; y<=laenge; y++) {
								Feld[x][y]=z.Feld[x][y];
							}
						}
						
						//System.out.println("successor size: "+successor.size());
						successor.add(new DameZustand(besetzen(Feld,0,j),Tiefe+1,0));
						
						//System.out.println(ausgabe(Feld));
						//System.out.println(ausgabe(z.Feld));

					
					
				}
		} else {
		
		
		//System.out.println(letzteDame_i);
		//System.out.println(letzteDame_j);
		//System.out.println(laenge);
		if (letzteDame_i<laenge) {
			for (int j=0; j<=laenge; j++) {
				//System.out.println("j: "+j);
				if (z.Feld[letzteDame_i+1][j]==' ') {
					

					char[][] Feld= new char[laenge+1][laenge+1];
					for (int x=0; x<=laenge; x++) {
						for (int y=0; y<=laenge; y++) {
							Feld[x][y]=z.Feld[x][y];
						}
					}
					//System.out.println("successor size: "+successor.size());
					successor.add(new DameZustand(besetzen(Feld,letzteDame_i+1,j),Tiefe+1,letzteDame_i+1));
					
					//System.out.println(ausgabe(Feld));
					//System.out.println(ausgabe(z.Feld));

				}
				
			}
		}
		}
		//System.out.println(successor.getLast());
		//System.out.println(successor.getFirst());
		return successor;
	}
	
	public String ausgabe(char[][] Feld) {
		String str="\n";
		for (int x=0; x<Feld.length; x++) {
			for (int y=0; y<Feld.length; y++) {
			
				str=str+"| "+Feld[x][y]+" ";
			}
			str=str+"|\n";
		}
		return str;
	}
	
	private char[][] besetzen (char[][] Feld,int i,int j) {
		
		int thisi, thisj;
		
		//Zeile belegt
		thisi=0;
		
		while (thisi<=laenge) {
			Feld[thisi][j]='X';
			thisi++;
		}
		
		//Spalte belegt
		thisj=0;
		
		while (thisj<=laenge) {
			Feld[i][thisj]='X';
			thisj++;
		}
		
		//Diagonale links oben nach rechts unten ist belegt
		thisi=i;
		thisj=j;
		
		while (thisi>0 && thisj>0) {
			thisi--;
			thisj--;
		}
		
		while (thisi<=laenge && thisj<=laenge) {
			Feld[thisi][thisj]='X';
			thisi++;
			thisj++;
		}
		
		//Diagonale links unten nach rechts oben ist belegt
		thisi=i;
		thisj=j;
		
		while (thisi>0 && thisj<laenge) {
			thisi--;
			thisj++;
		}
		
		while (thisi<=laenge && thisj>0) {
			Feld[thisi][thisj]='X';
			thisi++;
			thisj--;
		}
		
		Feld[i][j]='O';
	
	return Feld;
	}
}
