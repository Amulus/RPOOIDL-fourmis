package tache;


import etat.Adulte;
import fourmilliere.Fourmi;
import fourmilliere.Reserve;
import role.*;

public class Manger extends Tache {

	public Manger(){
		
	}
	
	@Override
	public void step(Fourmi fourmi) {
		//fourmi.getFourmilliere().getReserve().PrendreNourriture( fourmi.getPoid()*0.333);
		/*Tache nettoyer = new Nettoyer(fourmi.getFourmilliere().getDepot(), fourmi.getFourmilliere());
		nettoyer.execute(fourmi);*/
		if(((Adulte) fourmi.getEtat()).estDehors()){
			fourmi.getCalculDeplacement().deplacementRetour();
			if (fourmi.getCalculDeplacement().estSurFourmilliere()) {
				((Adulte) fourmi.getEtat()).rentrer();
			}
		}
		else {
			
			fourmi.getEtat().manger();
			this.termine = true;
			this.addStep();
		}
	}

}
