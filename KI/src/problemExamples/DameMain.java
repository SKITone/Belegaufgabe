package problemExamples;

import problemExamples.DameProblem;

import suchverfahren.*;


public class DameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		DameProblem DPr1 = new DameProblem(12);
		
		System.out.println();
		System.out.println();
		System.out.println("Breitensuche:");
		System.out.println();
		
		Breitensuche BS1= new Breitensuche(DPr1,6);
		//BS1.loop();
		
		
		System.out.println();
		System.out.println();
		System.out.println("Tiefensuche:");
		System.out.println();
		
		Tiefensuche TS1= new Tiefensuche(DPr1);
		//TS1.loop();
		
		System.out.println();
		System.out.println();
		System.out.println("TiefensucheAll:");
		System.out.println();
		
		TiefensucheAlle TS2= new TiefensucheAlle(DPr1,6);
		TS2.loop();
	}

}
