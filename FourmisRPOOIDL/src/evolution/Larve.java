package evolution;

import fourmilliere.Nid;
import outils.LireParametres;

public class Larve extends Enfant {
	protected int nombreDeJourAvantEvolution=0;
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	Boolean EstEnVie;
	public Larve(Nid nid, int identifiant) {
		super(nid);
		LireParametres lecturefichier = nid.getFourmilliere().getLireParametres();
		this.Poid = GenererUnPoidDeLarve((int) lecturefichier.ChercherParametre("MultiplicateurPoidLarveMin"),
				(int) lecturefichier.ChercherParametre("MultiplicateurPoidLarveMax"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie=true;
		this.nombreDeJourAvantEvolution = (int) lecturefichier.ChercherParametre("dureeEvolutionLarves");
		this.identifiant = identifiant;
	}

	private double GenererUnPoidDeLarve(int MultiplicateurPoidLarveMin, int MultiplicateurPoidLarveMax,
			int PoidFourmiMinimum, int PoidFourmiMaximum, double MultiplicateurDecimales) {
		// Genere un nombre entre 3 et 4, correspond(max-min)+1+min
		int multiplicateurDePoid = (int) Math
				.floor(Math.random() * (MultiplicateurPoidLarveMax - MultiplicateurPoidLarveMin) + 1
						+ MultiplicateurPoidLarveMin);
		double poidDuneFourmi = nid.getFourmilliere().getPremierAdulte().GenererUnPoidDeFourmi(PoidFourmiMinimum,
				PoidFourmiMaximum, MultiplicateurDecimales);
		return poidDuneFourmi * multiplicateurDePoid;
	}
	

	@Override
	public void changerEtat() {
		Nymphe nymphe = new Nymphe(this.nid, this.identifiant);
		this.nid.ajoutNymphe(nymphe);
		this.nid.getLarves().remove(this.identifiant);
	}
	
	public boolean VerifierAlimentation(){
		return this.Poid>NouritureMangée;

	}
	
	public void jourSuivant() {
		super.jourSuivant();
		if(this.VerifierAlimentation()) 
			this.mourir();
		
	}
	public void mourir() {
		this.EstEnVie = false;
		this.nid.getFourmilliere().getMorts().putIfAbsent(this.getIdentifiant(), this);
		this.nid.getFourmilliere().getLarves().remove(this.getIdentifiant());
	}
	
}
