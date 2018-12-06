package simulateur;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import etat.Adulte;
import etat.Etat;
import coucheGraphique.Ovale;
import coucheGraphique.Monde;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import proie.Proie;

public class Simulation extends Ovale {

	private static List<Proie> proies = new ArrayList<Proie>();
	
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
				test.getCalculDeplacement().setMonde(jc);
			}

			for (int i = 1; i < 100; i++) {
				Proie proie = new Proie();
				proies.add(proie);
				jc.add(proie);
			}
			Point CoordonneesFourilliere = new Point(250, 250);
			jc.add(Colonie, CoordonneesFourilliere);

			jc.open(CoordonneesFourilliere);

			Thread Simulation = new Thread();
			Simulation.start();
			int j=0;
			while (true) {
				if(j==360){
					for (int i = 0; i < jc.getProies().size(); i++)
						jc.getProies().get(i).ajouterTemp();
				j=0;
				}
					
				checkFourmi(Colonie, jc);
				checkProie(jc);
				
				for (int i = 0; i < jc.getFourmies().size(); i++)
					if(jc.getFourmies().get(i).getCalculDeplacement().testPositionProie(proies, jc.getFourmies().get(i)) == null)
						jc.getFourmies().get(i).getCalculDeplacement().deplacementChasse();

				try {
					if (jc != null) {
						j++;
						jc.uptade();
						jc.repaint();
					}
					Thread.sleep(5);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}
		}

		private void checkProie(Monde jc) {
			for (Proie proies : proies) {
				if (proies.estEnVie())
					AjoutProie(proies, jc);
				else
					RemoveProie(proies, jc);
			}
		}

		private void RemoveProie(Proie proies, Monde jc) {
			if (jc.getProies().contains(proies))
				jc.remove(proies);

		}

		private void AjoutProie(Proie proies, Monde jc) {
			if (jc.getProies().contains(proies))
				return;
			else
				jc.add(proies);

		}

		private void checkFourmi(Fourmilliere Colonie, Monde jc) {
			for (Fourmi fourmie : Colonie.getFourmis()) {
				Etat fourmi = fourmie.getEtat();
				if (fourmi.estDehors() && fourmi.estAdulte() && fourmi.tempsPasseDehors() < fourmi.tempsDehorsMax())
					Ajout(fourmie, jc);
				else if (fourmi.estAdulte() && fourmi.estDehors()
						&& fourmi.tempsPasseDehors() >= fourmi.tempsDehorsMax())
					Remove(fourmie, jc);
			}
		}

		private void Remove(Fourmi fourmie, Monde monde) {
			if (monde.getFourmies().contains(fourmie))
				monde.remove(fourmie);
		}

		private void Ajout(Fourmi fourmie, Monde monde) {
			if (monde.getFourmies().contains(fourmie))
				return;
			else {
				monde.add(fourmie);
				fourmie.getCalculDeplacement().setPoint(250, 250);
			}
		}

	}
}
