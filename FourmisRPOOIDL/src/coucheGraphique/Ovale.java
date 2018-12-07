package coucheGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

public class Ovale extends Dessin {
	private boolean isFourmilliere=false;
	
	public Ovale(Color color, Point pos, Dimension dim,boolean isFourmilliere) {
		super(color, pos, dim, null);
		this.isFourmilliere=isFourmilliere;
	}
	
	public boolean getIsFourmilliere(){
		return this.isFourmilliere;
	}
	
	//Dessine l'ovale
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillOval(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
		super.draw(g);
	}

}
