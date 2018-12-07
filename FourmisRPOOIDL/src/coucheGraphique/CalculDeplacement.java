package coucheGraphique;

import java.awt.Dimension;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

import fourmilliere.Fourmi;
import proie.Proie;

public class CalculDeplacement {

	private Point Coordonnee = null;
	private Dimension taille = null;
	private Monde monde = null;
	private int deplacement = -1;
	private int deplacementAcienDeplacement = -1;
	private ArrayList<Point> AnciensPoints = new ArrayList<Point>();

	public CalculDeplacement(Point Coordonnee, Dimension taille, Monde monde) {
		this.Coordonnee = Coordonnee;
		this.taille = taille;
		this.monde = monde;
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
	private int getPhéromoneChasse(int Position) {
		if (Position == 0 && getXPoint() + 1 < monde.getHeight())
			return this.monde.getPheromoneChasse(getXPoint() + 1, getYPoint());
		if (Position == 1 && getXPoint() - 1 > 0)
			return this.monde.getPheromoneChasse(getXPoint() - 1, getYPoint());
		if (Position == 2 && getYPoint() + 1 < monde.getWidth())
			return this.monde.getPheromoneChasse(getXPoint(), getYPoint() + 1);
		if (Position == 3 && getYPoint() - 1 > 0)
			return this.monde.getPheromoneChasse(getXPoint(), getYPoint() - 1);
		return this.monde.getPheromoneChasse(getXPoint(), getYPoint());
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
			this.monde.ajoutPheromoneChasse(getXPoint(), getYPoint(), 1);
		}
	}
	
	private void PoserPheromoneRetour() {
		switch (deplacementAcienDeplacement) {
		case 0:
			if (getXPoint() - 1 > 0)
				this.monde.ajoutPheromoneRetour(getXPoint() - 1, getYPoint());
			break;

		case 1:
			if (getXPoint() + 1 < monde.getHeight())
				this.monde.ajoutPheromoneRetour(getXPoint() + 1, getYPoint());
			break;

		case 2:
			if (getYPoint() - 1 > 0)
				this.monde.ajoutPheromoneRetour(getXPoint(), getYPoint() - 1);
			break;

		case 3:
			if (getYPoint() + 1 <  monde.getWidth())
				this.monde.ajoutPheromoneRetour(getXPoint(), getYPoint() + 1);
			break;
		default:
			break;
		}
	}
	
	public void deplacementAleatoire() {
		this.deplacement = GenererDeplacementAleatoire();
		deplacementAcienDeplacement = this.deplacement;
		PoserPheromoneRetour();
		deplacer();
	}
	public int GenererDeplacementAleatoire() {
		return (int) Math.floor(Math.random() * 4);
	}
	public boolean estSurFourmilliere(){
		return this.monde.EstSurFourmillilere(this.Coordonnee);
	}
	public Proie testPositionProie(List<Proie> proies, Fourmi fourmi) {
		for(Proie proie : proies)
			if(this.getXPoint() == proie.getPoint().x && this.getYPoint() == proie.getPoint().y && !proie.TropGros() && proie.estEnVie()){
					this.PoserPheromoneChasse();
					proie.ajouterFourmie(fourmi);
					if(!proie.estEnVie())
						this.clearPhéromoneChasse();
					return proie;
			}
		return null;
	}

	private void clearPhéromoneChasse() {
		if (getXPoint() - 1 < 0)
			this.monde.clearPheromoneChasse(getXPoint() - 1, getYPoint());
		if (getXPoint() + 1 < monde.getHeight())
			this.monde.clearPheromoneChasse(getXPoint() + 1, getYPoint());
		if (getYPoint() - 1 < 0)
			this.monde.clearPheromoneChasse(getXPoint(), getYPoint() - 1);
		if (getYPoint() + 1 <  monde.getWidth())
			this.monde.clearPheromoneChasse(getXPoint(), getYPoint() + 1);
		this.monde.clearPheromoneChasse(getXPoint(), getYPoint());
	}
	
	public void deplacementChasse() {
		this.deplacementAcienDeplacement = this.deplacement;
		ArrayList<Integer> deplacements = new ArrayList<Integer>();
		deplacements.add(this.getPhéromoneChasse(0));
		deplacements.add(this.getPhéromoneChasse(1));
		deplacements.add(this.getPhéromoneChasse(2));
		deplacements.add(this.getPhéromoneChasse(3));
		DeplacementP(deplacements,true);
	}
	public void deplacementRetour() {
		this.deplacementAcienDeplacement = this.deplacement;
		ArrayList<Integer> deplacements = new ArrayList<Integer>();
		deplacements.add(this.getPhéromoneRetour(0));
		deplacements.add(this.getPhéromoneRetour(1));
		deplacements.add(this.getPhéromoneRetour(2));
		deplacements.add(this.getPhéromoneRetour(3));
		DeplacementP(deplacements,false);
	}

	private void DeplacementP(ArrayList<Integer> deplacements,boolean Chasser) {
		int MaxPheromone = 0, AncienMax = 0;
		for (int i = 0; i < deplacements.size() - 1; i++) {
			MaxPheromone = Math.max(deplacements.get(i), deplacements.get(i + 1));
			if (MaxPheromone > AncienMax)
				AncienMax = MaxPheromone;
		}
		int Direction = 0;
		if (AncienMax > 0) {
			Direction = deplacements.indexOf(AncienMax);
		} else {
			Direction = GenererDeplacementAleatoire();
		}
		Point action = new Point(ActionDirection(Direction));

		if (AnciensPoints.contains(action)) {
			deplacements.set(Direction, 0);
			DeplacementP(deplacements,Chasser);
		} else {
			AnciensPoints.add(action);
			this.deplacement = Direction;
			if(Chasser)
				PoserPheromoneRetour();
			deplacer();
			return;
		}

	}

	private Point ActionDirection(int direction) {
		Point Actuel = this.Coordonnee;
		switch (direction) {
		case 0:
			return getPointRight(Actuel);
		case 1:
			return getPointLeft(Actuel);
		case 2:
			return getPointDown(Actuel);
		case 3:
			return getPointUp(Actuel);
		default:
			return Actuel;
		}
	}

	private Point getPointRight(Point Actuel) {
		if (Actuel.x + 1 < monde.getWidth()) {
			Actuel.x = Actuel.x + 1;
			return Actuel;
		} else
			return Actuel;
	}

	private Point getPointLeft(Point Actuel) {
		if (Actuel.x - 1 > 0) {
			Actuel.x = Actuel.x - 1;
			return Actuel;
		} else
			return Actuel;
	}

	private Point getPointDown(Point Actuel) {
		if (Actuel.y + 1 < monde.getHeight()) {
			Actuel.y = Actuel.y + 1;
			return Actuel;
		} else
			return Actuel;
	}

	private Point getPointUp(Point Actuel) {
		if (Actuel.y - 1 > 0) {
			Actuel.y = Actuel.y - 1;
			return Actuel;
		} else
			return Actuel;
	}

	public void clearDeplacements() {
		this.AnciensPoints=new ArrayList<Point>();
	}

}
