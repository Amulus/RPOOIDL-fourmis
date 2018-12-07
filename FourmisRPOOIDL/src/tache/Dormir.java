package tache;

import fourmilliere.Fourmi;

public class Dormir extends Tache {
	
	public Dormir(Tache tachePrecedente) {
		super(tachePrecedente);
		this.typeTache=Tache.DORMIR;
	}

	//ne fait rien pendant un tour, soit 388 step() ou si la fourmie a fait elle arrete de dormir
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
