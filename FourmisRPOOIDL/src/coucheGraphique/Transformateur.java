
package coucheGraphique;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Transformateur {
	protected Monde world;
	protected Rectangle bounds;
	protected Color color;
	protected List<Transformateur> submorphs = new ArrayList<Transformateur>();
	protected int deplacement=0;
	
	public Transformateur(Color color, Point pos, Dimension dim) {
		this.color = color;
		this.bounds = new Rectangle(dim);
		setPosition(pos);

	}

	public void setWorld(Monde w) {
		world = w;
	}

	public void setColor(Color c) {
		color = c;
		if (world != null)
			world.repaint();
	}

	public void draw(Graphics g) {
		Iterator<Transformateur> itor = submorphs.iterator();
		while (itor.hasNext()) {
			Transformateur m = itor.next();
			m.draw(g);
		}
	}

	public Rectangle getBounds() {
		return (Rectangle) bounds.clone();
	}

	public void addSubmorph(Transformateur m) {
		if (submorphs.contains(m))
			return;
		submorphs.add(m);
	}

	public Point getPosition() {
		Point p = bounds.getLocation();
		return p;
	}

	public void setPosition(Point p) {
		bounds.x = p.x;
		bounds.y = p.y;
		if (world != null)
			world.repaint();
	}

	public void setX(int x) {
		Point p = getPosition();
		setPosition(new Point(x, p.y));
	}

	public int getX() {
		return (getPosition().x);
	}

	public void setY(int y) {
		Point p = getPosition();
		setPosition(new Point(p.x, y));
	}

	public int getY() {
		return (getPosition().y);
	}

	public void moveRight(int gap) {
		setX(getX() + gap);
	}

	public void moveLeft(int gap) {
		setX(getX() - gap);
	}

	public void moveUp(int gap) {
		setY(getY() - gap);
	}

	public void moveDown(int gap) {
		setY(getY() + gap);
	}

	public Rectangle getWorldBounds() {
		return world.getBounds();
	}

	public boolean getPhéromone(int Position) {
		if(Position==0 && getX()+1<world.getHeight())
			return this.world.TableauFeromones[getX()+1][getY()];
		if(Position==1 && getX()-1>0)
			return this.world.TableauFeromones[getX()-1][getY()];
		if(Position==2 && getY()+1<world.getWidth())
			return this.world.TableauFeromones[getX()][getY()+1];
		if(Position==3 && getY()-1>0)
			return this.world.TableauFeromones[getX()][getY()-1];
		return false;
	}
	
	
	public void deplacementAleatoire(){
		this.deplacement = (int) Math.floor(Math.random() * 4);
	}
	public void VerifierPhéromone(){
		Boolean Avant=false,Arriere=false,Haut=false,Bas=false;
		Avant=this.getPhéromone(0);
		Arriere=this.getPhéromone(1);
		Haut=this.getPhéromone(2);
		Bas=this.getPhéromone(3);
	}

	private void VarifierMur() {
		switch(this.deplacement){
		case 0:
			if(world.getWidth()<getX()+ 1 +bounds.width) this.deplacement=-1;
			break;
		case 1:
			if(0>getX()-1 - bounds.width) this.deplacement=-1;
			break;
		case 2:
			if(world.getHeight()<getY()+ 1 +bounds.height) this.deplacement=-1;
			break;
		case 3:
			if(0>getY()-1 - bounds.height) this.deplacement=-1;
			break;
		default:
			break;
		}
	}
	public void deplacement(){
		deplacementAleatoire();
		VarifierMur();
		if(this.deplacement!=-1){
			VerifierPhéromone();
			switch(this.deplacement){
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
