package coucheGraphique;

import java.awt.Dimension;
import java.awt.Point;

public class CalculDeplacement {

	private Point Coordonnee = null;
	private Dimension taille = null;
	private Monde monde = null;
	private int deplacement = -1;
	private int deplacementAcienDeplacement = -1;

	public CalculDeplacement(Point Coordonnee, Dimension taille) {
		this.Coordonnee = Coordonnee;
		this.taille = taille;
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

	public void ChercherPhéromoneChasseEtChoixDeplacement() {
		int Right = 0, Left = 0, Down = 0, Up = 0;
		Right = this.getPhéromoneChasse(0);
		Left = this.getPhéromoneChasse(1);
		Down = this.getPhéromoneChasse(2);
		Up = this.getPhéromoneChasse(3);
		ChoixDeplacement(Left, Down, Up, Right);

	}

	private void ChoixDeplacement(int Left, int Down, int Up, int Right) {
		if (Left == 0 && Down == 0 && Up == 0 && Right == 0)
			GenererDeplacementAleatoire();
		else {
			int max = Math.max(Right, Math.max(Up, Math.max(Left, Down)));
			if (max == Right) {
				this.deplacement = 0;
				return;
			}
			if (max == Left) {
				this.deplacement = 1;
				return;
			}
			if (max == Down) {
				this.deplacement = 2;
				return;
			}
			if (max == Up) {
				this.deplacement = 3;
				return;
			}
		}

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

	public void ChercherPhéromoneRetourEtChoixDeplacement() {
		int Right = 0, Left = 0, Down = 0, Up = 0;
		Right = this.getPhéromoneRetour(0);
		Left = this.getPhéromoneRetour(1);
		Down = this.getPhéromoneRetour(2);
		Up = this.getPhéromoneRetour(3);
		ChoixDeplacement(Left, Down, Up, Right);
	}

	public void moveRight(int gap) {
		setXPoint(getXPoint() + gap);
	}

	public void moveLeft(int gap) {
		setXPoint(getXPoint() - gap);
	}

	public void moveDown(int gap) {
		setYPoint(getYPoint() + gap);
	}

	public void moveUp(int gap) {
		setYPoint(getYPoint() - gap);
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

	public void deplacementRetour() {
		deplacementAcienDeplacement = this.deplacement;
		GenererDeplacementRetour();
		deplacer();
	}

	public void deplacementAleatoire() {
		deplacementAcienDeplacement = this.deplacement;
		GenererDeplacementAleatoire();
		deplacer();
	}

	public void deplacementChasse() {
		deplacementAcienDeplacement = this.deplacement;
		GenererDeplacementChasse();
		deplacer();
	}

	private void deplacer() {
		VerifierMur();
		if (this.deplacement != -1) {
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

	public void GenererDeplacementAleatoire() {
		this.deplacement = (int) Math.floor(Math.random() * 4);
		PoserPheromoneRetour();
		deplacer();
	}

	private void PoserPheromoneRetour() {
		switch (deplacementAcienDeplacement) {
		case 0:
			this.monde.ajoutPheromoneRetour(getXPoint() - 1, getYPoint());
			break;

		case 1:
			this.monde.ajoutPheromoneRetour(getXPoint() + 1, getYPoint());
			break;

		case 2:
			this.monde.ajoutPheromoneRetour(getXPoint(), getYPoint() - 1);
			break;

		case 3:
			this.monde.ajoutPheromoneRetour(getXPoint(), getYPoint() + 1);
			break;
		default:
			break;
		}
	}

	private void PoserPheromoneChasse() {
		if (this.deplacement != -1) {
			if (getXPoint() + 1 < monde.getHeight())
				this.monde.ajoutPheromoneChasse(getXPoint() + 1, getYPoint(), 1);
			if (getXPoint() - 1 > 0)
				this.monde.ajoutPheromoneChasse(getXPoint() - 1, getYPoint(), 1);
			if (getYPoint() + 1 < monde.getWidth())
				this.monde.ajoutPheromoneChasse(getXPoint(), getYPoint() + 1, 1);
			if (getYPoint() - 1 > 0)
				this.monde.ajoutPheromoneChasse(getXPoint(), getYPoint() - 1, 1);
			this.monde.ajoutPheromoneChasse(getXPoint(), getYPoint(), 100);
		}
	}

	private void GenererDeplacementChasse() {
		//SuisjeSurUneProie();
		ChercherPhéromoneChasseEtChoixDeplacement();
		
		//Si on est sur une proie, et que le pheromone chasse deja a 100 ne rien faire sinon faire poser pheromone de chasse.
		//si on est sur une proie et quellen'est pas morte ne pas se deplacer
		//PoserPheromoneChasse();
		//deplacer();
	}

	/*private void SuisjeSurUneProie() {
		if(this.Coordonnee  == )
		
	}*/

	private void GenererDeplacementRetour() {
		ChercherPhéromoneRetourEtChoixDeplacement();
		PoserPheromoneRetour();
		deplacer();

	}
}
