package proie;

import java.awt.Dimension;
import java.awt.Point;

import outils.LireParametres;

public class Proie {
	protected double Poid=0.0;
	protected boolean EstEnVie=false;
	private Dimension dimension= null;
	private Point point= null;
	
	public Proie() {
		LireParametres lecturefichier = new LireParametres();
		this.Poid = GenererUnPoidDeProie((int) lecturefichier.ChercherParametre("PoidProieMaximum"),
				(int) lecturefichier.ChercherParametre("PoidProieMinimum"),
			(double) lecturefichier.ChercherParametre("MultiplicateurDecimales"));
		this.EstEnVie = true;
		int taille = (int) lecturefichier.ChercherParametre("TailleProie");
		this.dimension = new Dimension(taille,taille);
		int tailleMondeMin=(int) lecturefichier.ChercherParametre("TailleMondeMin");
		int tailleMondeMax=(int) lecturefichier.ChercherParametre("TailleMondeMax");
		int x = GenererUnPoint(tailleMondeMax,tailleMondeMin);
		int y = GenererUnPoint(tailleMondeMax,tailleMondeMin);
		this.point = new Point(x,y);
		
	}
	private double GenererUnPoidDeProie(int PoidProieMaximum,int PoidProieMinimum, double MultiplicateurDecimales) {
		return (double) Math.floor(Math.random() * (PoidProieMaximum - PoidProieMinimum) + 1 + PoidProieMinimum)
				* MultiplicateurDecimales;
		}
	private int GenererUnPoint(int TailleMondeMax,int TailleMondeMin) {
		return (int) Math.floor(Math.random() * (TailleMondeMax - TailleMondeMin) + 1 + TailleMondeMin);
		}
	public boolean estEnVie() {
		return this.EstEnVie;
	}
	public Dimension getSize() {
		return this.dimension;
	}
	public Point getPoint() {
		return this.point;
	}
}
