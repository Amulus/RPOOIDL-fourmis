package tache;

import java.util.ArrayList;

import evolution.Fourmi;
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
		//lirefichier parametre nb morts
	}
	@Override
	public void execute(Fourmi fourmi) {
		int i=1;
		//boucler sur nb morts
		//mettre X Objects de getmorts() dans un tableau
		//boucler sur le tableau
		
		for(int cle : this.fourmilliere.getMorts().keySet()){
			if(i>3) break;
			i++;
			Object mort = this.fourmilliere.getMorts().get(cle);
			if(mort.getClass()==Larve.class)
				this.depot.AjouterMort((Larve)mort);
			else
				this.depot.AjouterMort((Fourmi)mort);
		}	
	}

}
