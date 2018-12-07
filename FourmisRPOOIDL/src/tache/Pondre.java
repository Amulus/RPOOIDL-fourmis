package tache;

import fourmilliere.Fourmi;
import etat.Adulte;

public class Pondre extends Tache {
	
	public Pondre(Tache tachePrecedente) {
		super(tachePrecedente);
		this.typeTache = Tache.PONDRE;
	}
	private int oeufPondu = 0;
	@Override
	public void step(Fourmi fourmi) {
		addStep();
		if(oeufPondu < 100) {
			Fourmi oeuf = new Fourmi(fourmi.getFourmilliere());
			fourmi.getFourmilliere().ajoutFourmi(oeuf);
			this.oeufPondu+=1;
		}
		else {
			this.termine = true;
			oeufPondu=0;
			((Adulte)fourmi.getEtat()).getRole().nouvelleTache(this);
		}
		
	}

}
