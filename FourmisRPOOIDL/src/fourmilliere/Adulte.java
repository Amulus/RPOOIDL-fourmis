package fourmilliere;

import outils.LireParametres;

public class Adulte extends Evolution {
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	Boolean EstEnVie;

	public Adulte(Fourmilliere fourmilliere) {
		super(fourmilliere);
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.Poid = GenererUnPoidDeFourmi((int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie=true;
	}

	public double GenererUnRole(int PourcentageChanceOuvrier, int PourcentageChanceSoldat, int PourcentageChanceSexue) {

		int RoleAleatoire = (int) Math
				.floor(Math.random() * PourcentageChanceOuvrier + PourcentageChanceSoldat + PourcentageChanceSexue);
		if (RoleAleatoire <= PourcentageChanceSexue)
			// return ;
			if (RoleAleatoire <= PourcentageChanceSoldat)
				// return;
				if (RoleAleatoire <= PourcentageChanceOuvrier)
					return RoleAleatoire;
		return -1.0;
	}

	public double GenererUnPoidDeFourmi(int PoidFourmiMinimum, int PoidFourmiMaximum, double MultiplicateurDecimales) {
		// Genere un nombre entre 1.5 et 2
		return (double) Math.floor(Math.random() * (PoidFourmiMaximum - PoidFourmiMinimum) + 1 + PoidFourmiMinimum)
				* MultiplicateurDecimales;

	}
	public void VerifierAlimentation(){
		if(this.Poid/3<NouritureMangée) this.EstEnVie=false;
	}
}
