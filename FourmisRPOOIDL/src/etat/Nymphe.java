package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Nymphe extends Etat {
	
	
	public Nymphe(Fourmi fourmi) {
		super(fourmi);
		// TODO Auto-generated constructor stub
		this.nombreStepExistence = 0;
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

	@Override
	public void manger() {
		// TODO Auto-generated method stub
		
	}


/*
	public void jourSuivant() {
		super.jourSuivant();
	}
*/
}
