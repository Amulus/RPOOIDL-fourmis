package tache;

import etat.Adulte;
import etat.Larve;
import fourmilliere.Depot;
import fourmilliere.Fourmilliere;
import outils.LireParametres;

//Parcourir l'ensemble de larve et fourmi : check décédé et déplacer dans le dépot

public class Nettoyer extends Tache {
	private Depot depot =null;
	private Fourmilliere fourmilliere=null;
	private int NombreDeMorts=0;
	public Nettoyer(Depot depot,Fourmilliere fourmilliere){
		this.depot=depot;
		this.fourmilliere=fourmilliere;
		LireParametres lecturefichier = fourmilliere.getLireParametres();
		this.NombreDeMorts= (int) lecturefichier.ChercherParametre("NombreCadavreMaxNettoyer");
	}
	@Override
	public void execute(Adulte fourmi) {
		Integer temporaire[] = new Integer[NombreDeMorts];
		int j=0;
		for(int cle : this.fourmilliere.getMorts().keySet()){
			if(j>=NombreDeMorts) break;
			temporaire[j]= cle;
			j++;
		}
		for(int i=0; i<temporaire.length ; i++){
			Object mort = this.fourmilliere.getMorts().get(temporaire[i]);
			if(mort.getClass()==Larve.class)
				this.depot.AjouterMort((Larve)mort);
			else
				this.depot.AjouterMort((Adulte)mort);
		}	
	}

}
