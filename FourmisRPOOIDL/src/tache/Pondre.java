package tache;

import fourmilliere.Fourmi;

public class Pondre extends Tache {
	private int oeufPondu = 0;
	@Override
	public void step(Fourmi fourmi) {
		// TODO Auto-generated method stub
		if(oeufPondu < 10) {
			Fourmi oeuf = new Fourmi(fourmi.getFourmilliere());
			fourmi.getFourmilliere().ajoutFourmi(oeuf);
		}
		else {
			this.termine = true;
		}
		
	}

}
