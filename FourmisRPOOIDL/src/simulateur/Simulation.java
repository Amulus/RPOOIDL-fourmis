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

			Fourmilliere Colonie = new Fourmilliere(jc);

			for (int i = 1; i < 300; i++) {
				Fourmi test = new Fourmi(Colonie);
				test.changerEtat(new Adulte(test));
				((Adulte) test.getEtat()).sortir();
				Colonie.getFourmis().add(test);
				test.getCalculDeplacement().setMonde(jc);
			}

			Point CoordonneesFourilliere = new Point(250, 250);
			jc.add(Colonie, CoordonneesFourilliere);

			jc.open(CoordonneesFourilliere);

			for (int i = 1; i < 10; i++) {
				Proie proie = new Proie();
				proies.add(proie);
				jc.add(proie);
			}
			Thread Simulation = new Thread();
			Simulation.start();
			int CompteurJours = 0;
			while (true) {

				checkFourmi(Colonie, jc);
				checkProie(jc, CompteurJours);
				Colonie.step();
				if (CompteurJours == 388)
					CompteurJours = 0;
				CompteurJours++;
				try {
					if (jc != null) {
						jc.uptade();
						jc.repaint();
					}
					Thread.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

		}

		private void checkProie(Monde jc, int CompteurJours) {
			for (Proie proie : jc.getProies())
				proies.add(proie);
			for (Proie proies : proies) {
				if (CompteurJours >= 388) {
					proies.ajouterTemp();
				}
				if (proies.estEnVie())
					AjoutProie(proies, jc);
				else
					RemoveProie(proies, jc);
			}
			if (jc.getProies().size() < 10)
				for (int i = 0; i <= 5; i++) {
					Proie proie = new Proie();
					jc.add(proie);
					AjoutProie(proie, jc);
				}
			proies.clear();
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
				Etat etatfourmi = fourmie.getEtat();
				if (etatfourmi.estAdulte()) {
					if (etatfourmi.estDehors() && ((Adulte) etatfourmi).estEnvie())
						Ajout(fourmie, jc);
					else
						Remove(Colonie, fourmie, jc);
				}
			}
		}

		private void Remove(Fourmilliere Colonie, Fourmi fourmie, Monde monde) {
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
