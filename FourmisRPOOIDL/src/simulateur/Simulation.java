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

public class Simulation extends Ovale {

	public Simulation(Color color, Point pos, Dimension dim) {
		super(color, pos, dim, false);
	}

	public static void main(String[] args) {
		test bidule = new test();
		bidule.tester();
	}

	public static class test extends Thread {

		public void tester() {
			Monde jc = new Monde("Simulation d'une fourmilliere");
			jc.setBackground(new Color(100, 125, 0));
			jc.setPreferredSize(new Dimension(500, 500));
			Fourmilliere Colonie = new Fourmilliere();


			for (int i = 1; i < 500; i++) {
				Fourmi test = new Fourmi(Colonie);
				test.changerEtat(new Adulte(test));
				((Adulte) test.getEtat()).sortir();
				Colonie.getFourmis().add(test);
			}
			jc.add(new Ovale(new Color(150, 50, 0), new Point(250, 250), new Dimension(10, 10), true));

			jc.open();

			Thread fourmi = new Thread();
			fourmi.start();

			
			
			while (true) {
				List<Transformateur> drawables = jc.contents();
				checkFourmi(drawables,Colonie,jc);
				
				for (int i = 1; i < drawables.size(); i++) {
					drawables.get(i).deplacement();
				}
				try {
					Thread.sleep(1);
				} catch (InterruptedException e1){
					e1.printStackTrace();
				}
			}
		}
		private void checkFourmi(List<Transformateur> drawables, Fourmilliere Colonie, Monde jc) {
			for(Fourmi fourmie : Colonie.getFourmis()) {
			if (fourmie.getEtat().getClass() == Adulte.class)
				if (((Adulte) fourmie.getEtat()).getEstDehors()) {
					Ajout(drawables,fourmie,jc);
				}else{
					Remove(drawables,fourmie,jc);
				}
			}
		}
		
		private void Remove(List<Transformateur> drawables, Fourmi fourmie,Monde monde) {
			int i = 0;
			for (; i < drawables.size(); i++) {
				if (drawables.get(i).getClass() == Rect.class) {
					if (((Rect) drawables.get(i)).contains(fourmie))
						monde.remove(drawables.get(i));	
				}
			}
		}

		private void Ajout(List<Transformateur> drawables, Fourmi fourmie,Monde monde) {
			int i = 0;
			for (; i < drawables.size(); i++) {
				if (drawables.get(i).getClass() == Rect.class) {
					if (((Rect) drawables.get(i)).contains(fourmie))
						break;
				}
			}
			if (i == drawables.size())
				monde.add(new Rect(Color.RED, new Point(250, 250), new Dimension(4, 4), fourmie));	
		}
	}
}

