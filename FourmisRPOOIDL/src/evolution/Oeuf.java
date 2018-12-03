package evolution;

import fourmilliere.Fourmilliere;
import outils.LireParametres;

public class Oeuf extends Evolution {
	
	public int nombreDeJourAvantEvolution=0;
	
	public Oeuf(Fourmilliere fourmilliere) {
		super(fourmilliere);
		
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.nombreDeJourAvantEvolution = (int)lecturefichier.ChercherParametre("dureeEvolutionOeufs");
		
		this.identifiant = identifiantSuivant;
		identifiantSuivant++;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Larve larve = new Larve(this.fourmilliere,this.identifiant);
		this.fourmilliere.ajoutLarve(larve);
		this.fourmilliere.getOeufs().remove(this.identifiant);
		
	}
	

}
