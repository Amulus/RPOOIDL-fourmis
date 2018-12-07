
package coucheGraphique;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import fourmilliere.Fourmi;
import proie.Proie;


public class Rect extends Dessin{

	public Rect(Color color, Point pos, Dimension dim,Fourmi fourmie) {
		super(color, pos, dim,fourmie);	
	}

	public Rect(Color color, Point pos, Dimension dim, Proie proie) {
		super(color, pos, dim,proie);	
	}
	//Dessine le rectangle
	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
		super.draw(g);
	}

}
