package etat;

import outils.LireParametres;

public class Oeuf extends Etat {
	
	protected int nombreDeJourAvantEvolution=0;
	
	public Oeuf(Fourmi fourmi) {
		super(fourmi);
		
		LireParametres lecturefichier = this.fourmi.fourmilliere.getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionOeufs");
		
		// TODO Auto-generated constructor stub
	}
	//@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		
		
	}
	

}
