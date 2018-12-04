
package coucheGraphique;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class Transformateur {
	protected Monde world;
	protected Rectangle bounds;
	protected Color color;
	protected boolean TableauFeromones[][];
	protected List<Transformateur> submorphs = new ArrayList<Transformateur>();

	public Transformateur(Color color, Point pos, Dimension dim) {
		this.color = color;
		this.bounds = new Rectangle(dim);
		setPosition(pos);

	}

	public void setWorld(Monde w) {
		world = w;
		TableauFeromones = new boolean[w.getHeight()][w.getWidth()];
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

	public int deplacementAleatoire() {
		return (int) Math.floor(Math.random() * 4);
	}
	public void testDeplacement(){
		int deplacement= this.deplacementAleatoire();
		if (deplacement == 0 && testDeplacementHaut()) {
			moveUp(1);
			return;
		}
		if (deplacement == 1 && testDeplacementBas()) {
			moveDown(1);
			return;
		}
		if (deplacement == 2 && testDeplacementArriere()) {
			moveLeft(1);
			return;
		}
		if(testDeplacementAvant()){
			moveRight(1);
			return;
		}else
			this.testDeplacement();
	}
	public boolean testDeplacementAvant(){
		if(world.getWidth()<getX() + 1+bounds.width) return false;
		return true;
	}
	public boolean testDeplacementArriere(){
		if(0>getX() - 1-bounds.width) return false;
		return true;
	}
	public boolean testDeplacementBas(){
		if(world.getHeight()<getY() + 1+bounds.height) return false;
		return true;
	}
	public boolean testDeplacementHaut(){
		if(0>getY() - 1-bounds.height) return false;
		return true;
	}

	public boolean contains(Point mousePosition) {
		if(this.bounds.contains(mousePosition)) {
			return true;
		}
		return false;
	}

}
