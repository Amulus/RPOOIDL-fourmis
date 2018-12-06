package tache;

import fourmilliere.Fourmi;
import etat.Adulte;

public class Pondre extends Tache {
	
	public Pondre(Tache tachePrecedente) {
		super(tachePrecedente);
		this.typeTache = 0;
		// TODO Auto-generated constructor stub
	}
	private int oeufPondu = 0;
	@Override
	public void step(Fourmi fourmi) {
		if(oeufPondu < 100) {
			Fourmi oeuf = new Fourmi(fourmi.getFourmilliere());
			fourmi.getFourmilliere().ajoutFourmi(oeuf);
			this.oeufPondu+=1;
			this.addStep();
		}
		else {
			this.termine = true;
			oeufPondu=0;
			this.addStep();
		}
		
	}

}
