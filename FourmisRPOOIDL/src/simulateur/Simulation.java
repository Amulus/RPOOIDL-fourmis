package simulateur;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Point;

import etat.Adulte;
import coucheGraphique.Ovale;
import coucheGraphique.Monde;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import proie.Proie;

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


			for (int i = 1; i < 100; i++) {
				Fourmi test = new Fourmi(Colonie);
				test.changerEtat(new Adulte(test));
				((Adulte) test.getEtat()).sortir();
				Colonie.getFourmis().add(test);
				test.getCalculDeplacement().setMonde(jc);
			}
			for (int i = 1; i < 100; i++) {
				Proie proie = new Proie();
				jc.getProies().add(proie);
			}
			
			jc.add(Colonie);

			jc.open();

			Thread Simulation = new Thread();
			Simulation.start();

			
			while (true) {
				checkFourmi(Colonie,jc);
				checkProie(jc);
				
				for (int i = 0; i < jc.getFourmies().size(); i++)
					//TO DO FOURMILIERE .STEP
				try {
					if (jc != null){
						jc.uptade();
						jc.repaint();
					}
					Thread.sleep(1);
				} catch (InterruptedException e1){
					e1.printStackTrace();
				}
			}
		}
		private void checkProie(Monde jc) {
			for(Proie proies : jc.getProies()){
				if(proies.estEnVie()){
						if (jc.getProies().contains(proies))
							return;
						else
							jc.add(proies);	
				}else{
					//TO DO
				}	
			}
		}
		private void checkFourmi(Fourmilliere Colonie, Monde jc) {
			for(Fourmi fourmie : Colonie.getFourmis()) {
				if (fourmie.getEtat().estDehors() && fourmie.getEtat().estAdulte())
						Ajout(fourmie,jc);
				else
					if(fourmie.getEtat().estAdulte())
						Remove(fourmie,jc);
				}
		}
		
		private void Remove(Fourmi fourmie,Monde monde) {
			if (monde.getFourmies().contains(fourmie))
				monde.remove(fourmie);
		}

		private void Ajout(Fourmi fourmie,Monde monde) {
			if (monde.getFourmies().contains(fourmie))
				return;
			else{
				monde.add(fourmie);	
				fourmie.getCalculDeplacement().setPoint(250,250);
			}
		}
	}
}

