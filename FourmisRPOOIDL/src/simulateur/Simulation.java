package simulateur;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Point;
import java.util.List;

import coucheGraphique.Transformateur;
import etat.Adulte;
import coucheGraphique.Ovale;
import coucheGraphique.Rect;
import coucheGraphique.Monde;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;

public class Simulation extends Rect {

	public Simulation(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}
	public static void main(String[] args) {
		test bidule = new test();
		bidule.tester();
	}
	public static class test extends Thread {

		public void tester(){
			Monde jc = new Monde("Simulation d'une fourmilliere");
			jc.setBackground(new Color(100,125 , 0));
			jc.setPreferredSize(new Dimension(500, 500));

			jc.add(new Ovale(new Color(150, 50, 0), new Point(250, 250), new Dimension(10, 10),true));
			Fourmilliere Colonie = new Fourmilliere();

			for (int i = 1; i < 500; i++) {
				Colonie.getFourmis().add(new Fourmi(Colonie));
			}
			/*for (int i = 0; i < Colonie.getFourmis().size(); i++) {
				if (Colonie.getFourmis().get(i).getRole().getNumeroRole() == 1)
					jc.add(new Rect(Color.RED, new Point(250,250), new Dimension(4, 4)));
			}*/
			jc.open();

			List<Transformateur> drawables = jc.contents();
			
			Thread fourmi = new Thread();
			fourmi.start();
			while (true) {
				for (Transformateur fourmies : drawables) {
					if(fourmies.getClass()!=Ovale.class)
						fourmies.testDeplacement();
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}
