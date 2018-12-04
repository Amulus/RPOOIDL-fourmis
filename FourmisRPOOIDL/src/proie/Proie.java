package proie;

import outils.LireParametres;

public class Proie {
	protected double Poid=0.0;
	protected boolean EstEnVie=false;
	
	public Proie() {
		LireParametres lecturefichier = new LireParametres();
		this.Poid = GenererUnPoidDeProie((int) lecturefichier.ChercherParametre("PoidProieMaximum"),
				(int) lecturefichier.ChercherParametre("PoidProieMinimum"),
			(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
	}
	
	private double GenererUnPoidDeProie(int PoidProieMaximum,int PoidProieMinimum, double MultiplicateurDecimales) {
		return (double) Math.floor(Math.random() * (PoidProieMaximum - PoidProieMinimum) + 1 + PoidProieMinimum)
				* MultiplicateurDecimales;
		}
}
