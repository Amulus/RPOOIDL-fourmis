package etat;

import fourmilliere.Fourmi;
import fourmilliere.Reserve;
import outils.LireParametres;

public class Larve extends Etat {
	
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	private int dureeAjeun=0;
	Boolean EstEnVie;
	public Larve(Fourmi fourmi) {
		super(fourmi);
		this.nombreStepExistence = 0;
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
		int multiplicateurDePoid = (int) Math
				.floor(Math.random() * (MultiplicateurPoidLarveMax - MultiplicateurPoidLarveMin) + 1
						+ MultiplicateurPoidLarveMin);
		double poidDuneFourmi = Adulte.GenererUnPoidDeFourmi(PoidFourmiMinimum,
				PoidFourmiMaximum, MultiplicateurDecimales);
		return poidDuneFourmi * multiplicateurDePoid;
	}
	

	@Override
	public void evoluer() {
		this.fourmi.changerEtat(new Nymphe(this.fourmi));
	}
	
	public boolean VerifierAlimentation(){
		return this.Poid>NouritureMangée;
	}

	//Permet de faire une tache, ici juste attendre que le temp passe et manger si besoin 
	@Override
	public void step() {
		if(this.dureeAjeun >= 388) {
			this.fourmi.getFourmilliere().finDeVie(this.fourmi);
		}
		if(this.aFaim = true) {
			this.dureeAjeun++;
		}
		else {
			this.dureeAjeun = 0;
		}
		
		this.nombreStepExistence++;
		if(this.nombreStepExistence <= 388*this.nombreDeJourAvantEvolution);
			this.evoluer();
	}

	//Permet a la larve de manger si le stock le permet
	@Override
	public void manger() {
		Reserve reserve = this.fourmi.getFourmilliere().getReserve();
		if(reserve.PrendreNourriture(this.poid)) {
			this.nouritureMangée=this.poid;
			this.aFaim = false;
		}
		
	}
}
