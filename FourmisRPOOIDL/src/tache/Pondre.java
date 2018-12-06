package tache;

import fourmilliere.Fourmi;
import etat.Adulte;

public class Pondre extends Tache {
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
			((Adulte) fourmi.getEtat()).getRole().nouvelleTache();
		}
		
	}

}
