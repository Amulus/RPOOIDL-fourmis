package tache;


import fourmilliere.Fourmi;

public class Manger extends Tache {

	public Manger(){
		
	}
	@Override
	public void execute(Fourmi fourmi) {
		//fourmi.getFourmilliere().getReserve().PrendreNourriture( fourmi.getPoid()*0.333);
		Tache nettoyer = new Nettoyer(fourmi.getFourmilliere().getDepot(), fourmi.getFourmilliere());
		nettoyer.execute(fourmi);
	}

}
