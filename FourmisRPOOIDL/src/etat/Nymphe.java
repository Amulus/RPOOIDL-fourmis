package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Nymphe extends Etat {
	
	
	public Nymphe(Fourmi fourmi) {
		super(fourmi);
		// TODO Auto-generated constructor stub
		LireParametres lecturefichier = fourmi.getFourmilliere().getLireParametres();
		//this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionNymphes");
	}

	public void evoluer() {
		this.fourmi.changerEtat(new Adulte(this.fourmi));
	}


/*
	public void jourSuivant() {
		super.jourSuivant();
	}
*/
}
