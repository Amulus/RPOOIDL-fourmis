package evolution;

import fourmilliere.Fourmilliere;
import fourmilliere.Nid;
import outils.LireParametres;

public class Oeuf extends Enfant {
	
	public int nombreDeJourAvantEvolution=0;
	
	public Oeuf(Nid nid) {
		super(nid);
		
		LireParametres lecturefichier = nid.getFourmilliere().getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionOeufs");
		
		this.identifiant = identifiantSuivant;
		identifiantSuivant++;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Larve larve = new Larve(this.nid,this.identifiant);
		this.nid.ajoutLarve(larve);
		this.nid.getOeufs().remove(this.identifiant);
		
	}
	

}
