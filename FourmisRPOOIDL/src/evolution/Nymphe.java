package evolution;

import fourmilliere.Nid;
import outils.LireParametres;

public class Nymphe extends Enfant {
	
	protected int nombreDeJourAvantEvolution=0;
	
	public Nymphe(Nid nid, int identifiant) {
		super(nid);
		// TODO Auto-generated constructor stub
		LireParametres lecturefichier = nid.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionNymphes");
		this.identifiant = identifiant;
	}

	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Fourmi fourmi = new Fourmi(this.nid.getFourmilliere(),this.identifiant);
		this.nid.getFourmilliere().getFourmis().put(fourmi.getIdentifiant(), fourmi);
		this.nid.getFourmilliere().getNymphes().remove(this.identifiant);
	}

	public int getIdentifiant() {
		return this.identifiant;
	}
}
