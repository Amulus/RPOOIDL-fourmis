package tache;

import fourmilliere.Fourmi;

public class Dormir extends Tache {
	@Override
	public void step(Fourmi fourmi) {
		// TODO Auto-generated method stub
		if(fourmi.getEtat().getFaim()) {
			this.termine = true;
		}
	}

}
