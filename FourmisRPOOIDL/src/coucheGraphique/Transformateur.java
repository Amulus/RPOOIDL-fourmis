
package coucheGraphique;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import fourmilliere.Fourmi;
import proie.Proie;

public abstract class Transformateur {
	protected Monde world;
	protected Rectangle bounds;
	protected Color color;
	protected List<Transformateur> dessins = new ArrayList<Transformateur>();
	protected int deplacement=0;
	protected Object object=null;
	
	public Transformateur(Color color, Point pos, Dimension dim, Object object) {
		this.color = color;
		this.bounds = new Rectangle(dim);
		setPosition(pos);
		this.object=object;

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
		Iterator<Transformateur> itor = dessins.iterator();
		while (itor.hasNext()) {
			Transformateur m = itor.next();
			m.draw(g);
		}
	}

	public Rectangle getBounds() {
		return (Rectangle) bounds.clone();
	}

	public void addSubmorph(Transformateur m) {
		if (dessins.contains(m))
			return;
		dessins.add(m);
	}

	public Point getPosition() {
		if(object==null)
			return new Point(250,250);
		if(object.getClass() == Fourmi.class)
			return ((Fourmi) object).getCalculDeplacement().getPoint();
		if(object.getClass() == Proie.class)
			return ((Proie) object).getPoint();
		return new Point(250,250);
	}

	public void setPosition(Point p) {
		bounds.x = p.x;
		bounds.y = p.y;
	}

	public void Update() {
		Point p = getPosition();
		setPosition(p);
	}

	public int getX() {
		return (getPosition().x);
	}

	public int getY() {
		return (getPosition().y);
	}

	
}
