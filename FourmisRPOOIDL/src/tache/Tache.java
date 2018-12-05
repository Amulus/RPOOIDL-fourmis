package tache;

import java.util.ArrayList;
import java.util.List;

import fourmilliere.Fourmi;

public abstract class Tache {
	
	List<Couple<Integer,Object>> listAction = new ArrayList<Couple<Integer,Object>>();
	
	public abstract void step(Fourmi fourmis);
}
