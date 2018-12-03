package world;

import java.awt.Color;

import java.awt.Dimension;
import java.awt.Point;
import java.util.Iterator;
import java.util.List;

import fourmilliere.Adulte;
import fourmilliere.Fourmilliere;
import graphicLayer.Morph;
import graphicLayer.Oval;
import graphicLayer.Rect;
import graphicLayer.World;

public class Simulation extends Rect {
	
	public Simulation(Color color, Point pos, Dimension dim) {
		super(color, pos, dim);
	}

	public static void main(String[] args) {
		World jc = new World("Simulation d'une fourmilliere");
		jc.setBackground(new Color(100,125,0));
		jc.setPreferredSize(new Dimension(800, 600));
		Dimension dim = new Dimension(50, 50);
		
		jc.add(new Oval(new Color(150,50,0), new Point(0, 0), dim));
		Fourmilliere Colonie = new Fourmilliere();
		
		for(int i=1; i<30;i++){
			Colonie.getFourmis().put(i,new Adulte(Colonie));
			
		}
		for(int i=0; i<Colonie.getFourmis().size();i++){
			if(Colonie.getFourmis().get(i).getRole().getNumeroRole()==1)
				jc.add(new Rect(Color.RED,new Point(60,220),new Dimension(10, 10)));
		}
		jc.open();
		
		List<Morph> drawables = jc.contents();
		drawables.get(0).setPosition(new Point(0, 200));
		drawables.get(0).moveRight(10);
		
	}

}
