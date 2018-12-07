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

		simulation Simulation = new simulation();
		Simulation.demarrer();
	}

	public static class simulation extends Thread {

		public void demarrer() {

			Monde monde = new Monde("Simulation d'une fourmilliere");
			monde.setBackground(new Color(100, 125, 0));
			monde.setPreferredSize(new Dimension(500, 500));

			Fourmilliere Colonie = new Fourmilliere(monde);

			for (int i = 1; i < 300; i++) {
				Fourmi test = new Fourmi(Colonie);
				test.changerEtat(new Adulte(test));
				((Adulte) test.getEtat()).sortir();
				Colonie.getFourmis().add(test);
				test.getCalculDeplacement().setMonde(monde);
			}

			Point CoordonneesFourilliere = new Point(250, 250);
			monde.add(Colonie, CoordonneesFourilliere);

			monde.demarrer(CoordonneesFourilliere);

			for (int i = 1; i < 10; i++) {
				Proie proie = new Proie();
				proies.add(proie);
				monde.add(proie);
			}
			Thread Simulation = new Thread();
			Simulation.start();
			int CompteurJours = 0;

			ArrayList<Fourmi> fourmisEtapeAvant = new ArrayList<Fourmi>();
			while (true) {

				for(int i =0; i<Colonie.getFourmis().size();i++)
					fourmisEtapeAvant.add(Colonie.getFourmis().get(i));
				checkFourmi(Colonie, monde,fourmisEtapeAvant);
				checkProie(monde, CompteurJours);
				Colonie.step();
				if (CompteurJours == 388)
					CompteurJours = 0;
				CompteurJours++;
				try {
					if (monde != null) {
						monde.uptade();
						monde.repaint();
					}
					Thread.sleep(1);
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
			}

		}


		private void checkProie(Monde monde, int CompteurJours) {
			for (Proie proie : monde.getProies())
				proies.add(proie);
			for (Proie proies : proies) {
				if (CompteurJours >= 388) {
					proies.ajouterTemp();
				}
				if (proies.estEnVie())
					AjoutProie(proies, monde);
				else
					RemoveProie(proies, monde);
			}
			if (monde.getProies().size() < 10)
				for (int i = 0; i <= 5; i++) {
					Proie proie = new Proie();
					monde.add(proie);
					AjoutProie(proie, monde);
				}
			proies.clear();
		}

		private void RemoveProie(Proie proies, Monde monde) {
			if (monde.getProies().contains(proies))
				monde.remove(proies);

		}

		private void AjoutProie(Proie proies, Monde monde) {
			if (monde.getProies().contains(proies))
				return;
			else
				monde.add(proies);

		}

		private void checkFourmi(Fourmilliere Colonie, Monde monde,ArrayList<Fourmi>fourmisEtapeAvant) {
			for (Fourmi fourmie : fourmisEtapeAvant) {
				Etat etatfourmi = fourmie.getEtat();
				if (etatfourmi.estAdulte()) {
					if (etatfourmi.estDehors() && ((Adulte) etatfourmi).estEnvie())
						Ajout(fourmie, monde);
					else
						Remove(Colonie, fourmie, monde);
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
