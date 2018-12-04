package tache;

import etat.Adulte;

public class Manger extends Tache {

	public Manger(){
		
	}
	@Override
	public void execute(Adulte fourmi) {
		fourmi.getFourmilliere().getReserve().PrendreNourriture( fourmi.getPoid()*0.333);
		Tache nettoyer = new Nettoyer(fourmi.getFourmilliere().getDepot(), fourmi.getFourmilliere());
		nettoyer.execute(fourmi);
	}

}
