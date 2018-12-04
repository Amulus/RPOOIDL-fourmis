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

	//@Override
	public void changerEtat() {
		// TODO Auto-generated method stub

	}


/*
	public void jourSuivant() {
		super.jourSuivant();
	}
*/
}
