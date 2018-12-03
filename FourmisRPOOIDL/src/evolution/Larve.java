package evolution;

import fourmilliere.Fourmilliere;
import outils.LireParametres;

public class Larve extends Evolution {
	private int nombreDeJourAvantEvolution;
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	Boolean EstEnVie;
	public Larve(Fourmilliere fourmilliere, int identifiant) {
		super(fourmilliere);
		LireParametres lecturefichier = fourmilliere.getLireParametres();
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
		double poidDuneFourmi = fourmilliere.getPremierAdulte().GenererUnPoidDeFourmi(PoidFourmiMinimum,
				PoidFourmiMaximum, MultiplicateurDecimales);
		return poidDuneFourmi * multiplicateurDePoid;
	}
	public void VerifierAlimentation(){
		if(this.Poid<NouritureMangée) this.EstEnVie=false;
	}

	@Override
	public void changerEtat() {
		// TODO Auto-generated method stub
		Nymphe nymphe = new Nymphe(this.fourmilliere, this.identifiant);
		this.fourmilliere.ajoutNymphe(nymphe);
		this.fourmilliere.getLarves().remove(this.identifiant);
	}

	@Override
	public void getEtat() {
		// TODO Auto-generated method stub
	}
	
	
}
