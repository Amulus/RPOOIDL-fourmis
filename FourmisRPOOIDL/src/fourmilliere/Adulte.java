package fourmilliere;

import outils.LireParametres;

public class Adulte extends Evolution {
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	private Role role = null;
	Boolean EstEnVie;
	
	public Adulte(Fourmilliere fourmilliere, Role role) {
		super(fourmilliere);
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.Poid = GenererUnPoidDeFourmi((int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
		this.role = role;
	}
	
	public Adulte(Fourmilliere fourmilliere) {
		super(fourmilliere);
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.Poid = GenererUnPoidDeFourmi((int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
		GenererUnRole(this, (int) lecturefichier.ChercherParametre("PourcentageChanceOuvrier"),
				(int) lecturefichier.ChercherParametre("PourcentageChanceSoldat"),
				(int) lecturefichier.ChercherParametre("PourcentageChanceSexue"));
	}

	private void GenererUnRole(Adulte fourmi, int PourcentageChanceOuvrier, int PourcentageChanceSoldat,
			int PourcentageChanceSexue) {
		int RoleAleatoire = (int) Math
				.floor(Math.random() * PourcentageChanceOuvrier + PourcentageChanceSoldat + PourcentageChanceSexue);
		if (RoleAleatoire <= PourcentageChanceSexue)
			 fourmi.role = new FourmiSexue(fourmi);
		else
			if (RoleAleatoire <= PourcentageChanceSoldat)
				 fourmi.role = new FourmiSoldat(fourmi);
			else
				fourmi.role = new FourmiOuvriere(fourmi);
	}

	private void ChangerRole(Adulte fourmi,Boolean Soldat){
		if(Soldat)
			fourmi.role =new FourmiSoldat(fourmi);
		else
			fourmi.role =new FourmiOuvriere(fourmi);
			
	}
	public double GenererUnPoidDeFourmi(int PoidFourmiMinimum, int PoidFourmiMaximum, double MultiplicateurDecimales) {
		// Genere un nombre entre 1.5 et 2
		return (double) Math.floor(Math.random() * (PoidFourmiMaximum - PoidFourmiMinimum) + 1 + PoidFourmiMinimum)
				* MultiplicateurDecimales;

	}

	public void VerifierAlimentation() {
		if (this.Poid / 3 < NouritureMangée)
			this.EstEnVie = false;
	}
}
