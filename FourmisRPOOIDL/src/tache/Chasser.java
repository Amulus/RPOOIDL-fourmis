package tache;

import etat.Adulte;
import fourmilliere.Fourmi;
import fourmilliere.Reserve;
import proie.Proie;

public class Chasser extends Tache {
	boolean rameneBouffe;
	boolean combat;
	Proie proie;
	int dureeCombat;
	@Override
	public void step(Fourmi fourmi) {
		// TODO Auto-generated method stub
		Adulte etat = (Adulte) fourmi.getEtat();
		if(!etat.estDehors()) {
			etat.sortir();
		}
		else {
			if(this.rameneBouffe) {
				if(fourmi.getEtat().estDehors() == false) {
					Reserve reserve = fourmi.getFourmilliere().getReserve();
					reserve.AjouterNourriture(5);
					this.termine = true;
				}
				else {
					fourmi.getCalculDeplacement().deplacementRetour();
				}
				
			}
			else if(this.combat) {
				if(this.dureeCombat >= 180) {
					this.combat = false;
					this.proie = null;
					fourmi.getCalculDeplacement().deplacementAleatoire();
				}
				else {
					if(!true) {//si la proie nbFourmie < nbFourmieRequis
						this.combat = false;
						this.rameneBouffe = true;
					}
				}
			}
			else {
				fourmi.getCalculDeplacement().deplacementAleatoire();
				if(fourmi.getCalculDeplacement().detecterProie) {
					this.combat = true;
					//lancer pheromone
				}
				else {
					fourmi.getCalculDeplacement().deplacementAleatoire();
				}
			}
		}
	}

}
