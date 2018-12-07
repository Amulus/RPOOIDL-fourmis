package tache;

import fourmilliere.Fourmi;

public class Dormir extends Tache {
	
	public Dormir(Tache tachePrecedente) {
		super(tachePrecedente);
		this.typeTache=Tache.DORMIR;
	}

	@Override
	public void step(Fourmi fourmi) {
		addStep();
		if(fourmi.getEtat().getFaim()) {
			this.termine = true;
		}
		if(this.NbStep%388==0 && this.NbStep>1) {
			this.termine = true;
		}
	}

}
