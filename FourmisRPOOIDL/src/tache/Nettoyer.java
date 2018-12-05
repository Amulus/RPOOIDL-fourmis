package tache;

import fourmilliere.Depot;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import outils.LireParametres;

//Parcourir l'ensemble de larve et fourmi : check décédé et déplacer dans le dépot
//tout est à changer
public class Nettoyer extends Tache {
	private int NombreDeMorts=0;
	public Nettoyer(){
		LireParametres lecturefichier = new LireParametres();
		this.NombreDeMorts= (int) lecturefichier.ChercherParametre("NombreCadavreMaxNettoyer");
	}
	@Override
	public void step(Fourmi fourmi) {
		Integer temporaire[] = new Integer[NombreDeMorts];
		int j=0;
		/*for(int cle : this.fourmilliere.getMorts().keySet()){
			if(j>=NombreDeMorts) break;
			temporaire[j]= cle;
			j++;
		}*/
		for(int i=0; i<temporaire.length ; i++){
			Object mort = fourmi.getFourmilliere().getMorts().get(temporaire[i]);
			if(mort.getClass()==Fourmi.class)
				fourmi.getFourmilliere().getDepot().AjouterMort((Fourmi)mort);
			else
				fourmi.getFourmilliere().getDepot().AjouterMort((Fourmi)mort);
		}	
	}

}
