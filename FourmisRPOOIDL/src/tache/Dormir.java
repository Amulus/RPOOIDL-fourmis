package tache;

import etat.Adulte;
import fourmilliere.Fourmi;

public class Dormir extends Tache {
	
	public Dormir(Tache tachePrecedente) {
		super(tachePrecedente);
		this.typeTache=Tache.DORMIR;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void step(Fourmi fourmi) {
		addStep();
		if(fourmi.getEtat().getFaim()) {
			this.termine = true;
		}
		if(this.NbStep%9312==0 && this.NbStep>1) {
			this.termine = true;
		}
	}

}
