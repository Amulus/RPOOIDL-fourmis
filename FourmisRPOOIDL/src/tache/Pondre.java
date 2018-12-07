package tache;

import fourmilliere.Fourmi;
public class Pondre extends Tache {
	
	public Pondre(Tache tachePrecedente) {
		super(tachePrecedente);
		this.typeTache = Tache.PONDRE;
	}
	private int oeufPondu = 0;
	//La fourmie reinne pond 100 oeufs puis termine la tache
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
		}
		
	}

}
