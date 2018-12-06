package tache;

import etat.Adulte;
import fourmilliere.Fourmi;

public class Dormir extends Tache {
	
	@Override
	public void step(Fourmi fourmi) {
		if(fourmi.getEtat().getFaim()) {
			this.termine = true;
			this.addStep();
		}
		if(this.NbStep%9312==0 && this.NbStep>1) {
			this.termine = true;
			this.addStep();
			if(fourmi.getEtat().getClass() == Adulte.class)
				((Adulte) fourmi.getEtat()).getRole().nouvelleTache();
		}else{
			this.addStep();
		}
	}

}
