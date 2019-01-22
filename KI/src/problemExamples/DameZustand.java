package problemExamples;

import problemDef.*;

public class DameZustand extends Zustand{
	
	char[][] Feld;
	int Tiefe;
	int letzteDame_i;

	public DameZustand(char[][] Feld, int Tiefe) {
		this.Feld=Feld;
		this.Tiefe=Tiefe;
	}
	public DameZustand(char[][] Feld, int Tiefe, int letzteDame_i) {
		this.Feld=Feld;
		this.Tiefe=Tiefe;
		this.letzteDame_i=letzteDame_i;
	}
	
	
	public String toString(){								//Overrides: String in class java.lang.Object
		String str="\n";
		for (int i=0; i<Feld.length; i++) {
			for (int j=0; j<Feld.length; j++) {
			
				str=str+"| "+Feld[i][j]+" ";
			}
			str=str+"|\n";
		}
		return str;
	}
	
	public int getTiefe() {
		return Tiefe;
	}
	
	public int getletzteDame_i() {
		return letzteDame_i;
	}
}
