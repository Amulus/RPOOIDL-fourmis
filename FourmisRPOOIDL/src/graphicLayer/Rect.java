
package graphicLayer;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;


public class Rect extends Morph{

	public Rect(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);		
	}

	public void draw(Graphics g) {
		Color c = g.getColor();
		g.setColor(color);
		g.fillRect(bounds.x,bounds.y,bounds.height,bounds.width);
		g.setColor(c);
		super.draw(g);
	}

}
