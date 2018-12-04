package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Oeuf extends Etat {
	
	protected int nombreDeJourAvantEvolution=0;
	
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		
		LireParametres lecturefichier = this.fourmi.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionOeufs");
		
		// TODO Auto-generated constructor stub
	}
	//@Override
	public void evoluer() {
		this.fourmi.changerEtat(new Larve(this.fourmi));
	}
	

}
