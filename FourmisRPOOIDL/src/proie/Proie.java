package proie;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;

import outils.LireParametres;
import fourmilliere.Fourmi;

public class Proie {
	protected double Poid = 0.0;
	protected double PoidMaxFourmiesAttaque = 0.0;
	protected boolean EstEnVie = false;
	private Dimension dimension = null;
	private Point point = null;
	private int MAX= 999;
	private int tempHarcelement = MAX;
	private ArrayList<Fourmi> fourmies = new ArrayList<Fourmi>();

	//Une proie ne se deplace pas pour le momment
	public Proie() {
		LireParametres lecturefichier = new LireParametres();
		this.Poid = GenererUnPoidDeProie((int) lecturefichier.ChercherParametre("PoidProieMaximum"),
				(int) lecturefichier.ChercherParametre("PoidProieMinimum"),
				(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
		this.PoidMaxFourmiesAttaque = (double) lecturefichier.ChercherParametre("PoidMaxFourmiesAttaque");
		int taille = (int) lecturefichier.ChercherParametre("TailleProie");
		this.dimension = new Dimension(taille, taille);
		int tailleMondeMin = (int) lecturefichier.ChercherParametre("TailleMondeMin");
		int tailleMondeMax = (int) lecturefichier.ChercherParametre("TailleMondeMax");
		int x = GenererUnPoint(tailleMondeMax, tailleMondeMin);
		int y = GenererUnPoint(tailleMondeMax, tailleMondeMin);
		this.point = new Point(x, y);
	}

	private double GenererUnPoidDeProie(int PoidProieMaximum, int PoidProieMinimum, double MultiplicateurDecimales) {
		return (double) Math.floor(Math.random() * (PoidProieMaximum - PoidProieMinimum) + 1 + PoidProieMinimum)
				* MultiplicateurDecimales;
	}

	//Positionne la proie sur la grille aleatoirement
	private int GenererUnPoint(int TailleMondeMax, int TailleMondeMin) {
		return (int) Math.floor(Math.random() * (TailleMondeMax - TailleMondeMin) + 1 + TailleMondeMin);
	}

	public boolean estEnVie() {
		return this.EstEnVie;
	}

	public void mourrir() {
		fourmies.clear();
		this.EstEnVie = false;
	}

	public Dimension getSize() {
		return this.dimension;
	}

	public Point getPoint() {
		return this.point;
	}

	public double getPoid() {
		return this.Poid;
	}

	public int getTempHarcelement() {
		return this.tempHarcelement;
	}

	public boolean TropGros() {
		return (this.Poid >= this.PoidMaxFourmiesAttaque);
	}

	//Si une fourmie est sur une proie elle est ajouté a la proie et teste si la proie est encore vivante
	public void ajouterFourmie(Fourmi fourmie) {
		if (!contains(fourmie) && this.EstEnVie==true)
			fourmies.add(fourmie);
		if (this.tempHarcelement==MAX && this.EstEnVie==true) {
			LireParametres lecturefichier = new LireParametres();
			this.tempHarcelement = (int) lecturefichier.ChercherParametre("TempHarcelement");
		}
		VerifierVie();
	}

	//Verifie si la proie est encore vivante en fonction du poid cumulé des fourmies sur elle
	public boolean VerifierVie() {
		if (this.tempHarcelement > 0) {
			double poidFourmies = 0.0;
			for (Fourmi fourmie : fourmies)  {
				poidFourmies += fourmie.getEtat().getPoid();
			}
			if (poidFourmies >= this.Poid) {
				this.EstEnVie=false;
				return false;
			}
			return this.EstEnVie;
		}
		this.mourrir();
		return false;
	}

	public boolean contains(Fourmi fourmi) {
		return this.fourmies.contains(fourmi);
	}
	
	//Diminue le tempHarcelement
	public void ajouterTemp() {
		if (this.tempHarcelement != MAX) {
			this.tempHarcelement -= 1;
			VerifierVie();
		}
	}
}
