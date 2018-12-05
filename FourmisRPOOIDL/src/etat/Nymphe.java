package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Nymphe extends Etat {
	
	private int nombreDeJourAvantEvolution=0;
	private int nombreStepExistence=0;
	
	public Nymphe(Fourmi fourmi) {
		super(fourmi);
		// TODO Auto-generated constructor stub
		LireParametres lecturefichier = fourmi.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionNymphes");
	}

	public void evoluer() {
		this.fourmi.changerEtat(new Adulte(this.fourmi));
		this.estAdulte = true;
	}

	@Override
	public void step() {
		// TODO Auto-generated method stub
		this.nombreStepExistence++;
		if(this.nombreStepExistence == 60*24*this.nombreDeJourAvantEvolution);
			this.evoluer();
	}


/*
	public void jourSuivant() {
		super.jourSuivant();
	}
*/
}
