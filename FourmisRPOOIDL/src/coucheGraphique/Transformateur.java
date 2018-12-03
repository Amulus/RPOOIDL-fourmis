
package coucheGraphique;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import role.FourmiOuvriere;
import role.FourmiSexue;
import role.FourmiSoldat;

public abstract class Transformateur {
	protected Monde world;
	protected Rectangle bounds;
	protected Color color;
	private boolean TableauFeromones[][];
	protected List<Transformateur> submorphs = new ArrayList<Transformateur>();

	public Transformateur(Color color, Point pos, Dimension dim) {
		this.color = color;
		this.bounds = new Rectangle(dim);
		setPosition(pos);

	}

	public void setWorld(Monde w) {
		world = w;
		Dimension d = w.getSize();
		TableauFeromones = new boolean[(int) d.getHeight()][(int) d.getWidth()];
	}

	public void setColor (Color c) {
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

	public void deplacementAleatoire() {
			int deplacementAleatoire = 0;
			deplacementAleatoire = (int) Math.floor(Math.random() * 4);
			deplacementAleatoire = (int) Math.floor(Math.random() * 4);
			
	}

	
}
