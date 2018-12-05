package coucheGraphique;

import java.awt.Dimension;
import java.awt.Point;

public class CalculDeplacement {

	private Point Coordonnee = null;
	private Dimension taille = null;
	private Monde monde = null;
	private int deplacement = 0;
	
	public CalculDeplacement(Point Coordonnee,Dimension taille){
		this.Coordonnee=Coordonnee;
		this.taille=taille;
	}
	public void setPoint(int x, int y) {
		setXPoint(x);
		setYPoint(y);
	}
	public void setXPoint(int x) {
		Coordonnee.x = x;
	}

	public void setYPoint(int y) {
		Coordonnee.y = y;
	}

	public int getXPoint() {
		return getPoint().x;
	}

	public int getYPoint() {
		return getPoint().y;
	}

	public Point getPoint() {
		return this.Coordonnee;
	}

	public void setMonde(Monde monde) {
		this.monde = monde;
	}

	public Dimension getSize() {
		return this.taille;
	}

	public void deplacementAleatoire() {
		this.deplacement = (int) Math.floor(Math.random() * 4);
	}

	public int getPhéromoneChasse(int Position) {
		if (Position == 0 && getXPoint() + 1 < monde.getHeight())
			return this.monde.getPheromoneChasse(getXPoint() + 1, getYPoint());
		if (Position == 1 && getXPoint() - 1 > 0)
			return this.monde.getPheromoneChasse(getXPoint() - 1, getYPoint());
		if (Position == 2 && getYPoint() + 1 < monde.getWidth())
			return this.monde.getPheromoneChasse(getXPoint(), getYPoint() + 1);
		if (Position == 3 && getYPoint() - 1 > 0)
			return this.monde.getPheromoneChasse(getXPoint(), getYPoint() - 1);
		return 0;
	}

	public void VerifierPhéromoneChasse() {
		int Avant = 0, Arriere = 0, Haut = 0, Bas = 0;
		Avant = this.getPhéromoneChasse(0);
		Arriere = this.getPhéromoneChasse(1);
		Haut = this.getPhéromoneChasse(2);
		Bas = this.getPhéromoneChasse(3);
	}

	public int getPhéromoneRetour(int Position) {
		if (Position == 0 && getXPoint() + 1 < monde.getHeight())
			return this.monde.getPheromoneRetour(getXPoint() + 1, getYPoint());
		if (Position == 1 && getXPoint() - 1 > 0)
			return this.monde.getPheromoneRetour(getXPoint() - 1, getYPoint());
		if (Position == 2 && getYPoint() + 1 < monde.getWidth())
			return this.monde.getPheromoneRetour(getXPoint(), getYPoint() + 1);
		if (Position == 3 && getYPoint() - 1 > 0)
			return this.monde.getPheromoneRetour(getXPoint(), getYPoint() - 1);
		return 0;
	}

	public void VerifierPhéromoneRetour() {
		int Avant = 0, Arriere = 0, Haut = 0, Bas = 0;
		Avant = this.getPhéromoneRetour(0);
		Arriere = this.getPhéromoneRetour(1);
		Haut = this.getPhéromoneRetour(2);
		Bas = this.getPhéromoneRetour(3);
	}

	public void moveRight(int gap) {
		setXPoint(getXPoint() + gap);
	}

	public void moveLeft(int gap) {
		setXPoint(getXPoint() - gap);
	}

	public void moveUp(int gap) {
		setYPoint(getYPoint() - gap);
	}

	public void moveDown(int gap) {
		setYPoint(getYPoint() + gap);
	}

	private void VerifierMur() {
		switch (this.deplacement) {
		case 0:
			if (monde.getWidth() < getXPoint() + 1 + taille.width)
				this.deplacement = -1;
			break;
		case 1:
			if (0 > getXPoint() - 1 - taille.width)
				this.deplacement = -1;
			break;
		case 2:
			if (monde.getHeight() < getYPoint() + 1 + taille.height)
				this.deplacement = -1;
			break;
		case 3:
			if (0 > getYPoint() - 1 - taille.height)
				this.deplacement = -1;
			break;
		default:
			break;
		}
	}

	public void deplacement() {
		deplacementAleatoire();
		VerifierMur();
		if (this.deplacement != -1) {
			// VerifierPhéromone();
			switch (this.deplacement) {
			case 0:
				moveRight(1);
				break;
			case 1:
				moveLeft(1);
				break;
			case 2:
				moveDown(1);
				break;
			case 3:
				moveUp(1);
				break;
			default:
				break;
			}
		}
	}

	
}
