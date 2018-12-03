package evolution;

import fourmilliere.Fourmilliere;
import outils.LireParametres;

public class Nymphe extends Evolution {
	
	private int nombreDeJourAvantEvolution=0;
	
	public Nymphe(Fourmilliere fourmilliere, int identifiant) {
		super(fourmilliere);
		// TODO Auto-generated constructor stub
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionNymphes");
		this.identifiant = identifiant;
	}

	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Adulte fourmi = new Adulte(this.fourmilliere,this.identifiant);
		this.fourmilliere.getFourmis().put(fourmi.getIdentifiant(), fourmi);
		this.fourmilliere.getNymphes().remove(this.identifiant);
	}

	public int getIdentifiant() {
		return this.identifiant;
	}
}
