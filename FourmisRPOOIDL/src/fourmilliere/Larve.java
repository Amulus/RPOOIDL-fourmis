package fourmilliere;

import outils.LireParametres;

public class Larve extends Evolution {
	private double Poid = 0.0;
	private double NouritureMangée = 0.0;
	Boolean EstEnVie;
	public Larve(Fourmilliere fourmilliere) {
		super(fourmilliere);
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.Poid = GenererUnPoidDeLarve((int) lecturefichier.ChercherParametre("MultiplicateurPoidLarveMin"),
				(int) lecturefichier.ChercherParametre("MultiplicateurPoidLarveMax"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMinimum"),
				(int) lecturefichier.ChercherParametre("PoidFourmiMaximum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie=true;
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
}
