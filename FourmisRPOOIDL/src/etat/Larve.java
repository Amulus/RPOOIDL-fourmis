package etat;

import fourmilliere.Fourmi;
import outils.LireParametres;

public class Larve extends Etat {
	protected int nombreDeJourAvantEvolution=0;
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	Boolean EstEnVie;
	public Larve(Fourmi fourmi) {
		super(fourmi);
		LireParametres lecturefichier = this.fourmi.getFourmilliere().getLireParametres();
		this.Poid = GenererUnPoidDeLarve((int) lecturefichier.ChercherParametre("MultiplicateurPoidLarveMin"),
				(int) lecturefichier.ChercherParametre("MultiplicateurPoidLarveMax"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie=true;
		this.nombreDeJourAvantEvolution = (int) lecturefichier.ChercherParametre("dureeEvolutionLarves");
	}

	public static double GenererUnPoidDeLarve(int MultiplicateurPoidLarveMin, int MultiplicateurPoidLarveMax,
			int PoidFourmiMinimum, int PoidFourmiMaximum, double MultiplicateurDecimales) {
		// Genere un nombre entre 3 et 4, correspond(max-min)+1+min
		int multiplicateurDePoid = (int) Math
				.floor(Math.random() * (MultiplicateurPoidLarveMax - MultiplicateurPoidLarveMin) + 1
						+ MultiplicateurPoidLarveMin);
		double poidDuneFourmi = Adulte.GenererUnPoidDeFourmi(PoidFourmiMinimum,
				PoidFourmiMaximum, MultiplicateurDecimales);
		return poidDuneFourmi * multiplicateurDePoid;
	}
	

	//@Override
	public void evoluer() {
		this.fourmi.changerEtat(new Nymphe(this.fourmi));
	}
	
	public boolean VerifierAlimentation(){
		return this.Poid>NouritureMangée;

	}
	/*
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
	*/
}
