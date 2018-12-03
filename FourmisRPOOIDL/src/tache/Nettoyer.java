package tache;

import evolution.Adulte;
import evolution.Larve;
import fourmilliere.Depot;
import fourmilliere.Fourmilliere;

//Parcourir l'ensemble de larve et fourmi : check décédé et déplacer dans le dépot

public class Nettoyer extends Tache {
	Depot depot =null;
	Fourmilliere fourmilliere=null;
	public Nettoyer(Depot depot,Fourmilliere fourmilliere){
		this.depot=depot;
		this.fourmilliere=fourmilliere;
	}
	@Override
	public void execute(Adulte fourmi) {
		int i=1;
		for(int cle : this.fourmilliere.getMorts().keySet()){
			if(i>3) break;
			i++;
			Object mort = this.fourmilliere.getMorts().get(cle);
			if(mort.getClass()==Larve.class)
				this.depot.AjouterMort((Larve)mort);
			else
				this.depot.AjouterMort((Adulte)mort);
		}	
	}

}
