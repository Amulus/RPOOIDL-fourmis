package tache;

import etat.Adulte;
import fourmilliere.Fourmi;

public class Chasser extends Tache {
	boolean rameneBouffe;
	boolean combat;
	@Override
	public void step(Fourmi fourmi) {
		// TODO Auto-generated method stub
		Adulte etat = (Adulte) fourmi.getEtat();
		if(!etat.estDehors()) {
			etat.sortir();
		}
		else {
			//si mode rameneBouffeActiver
				//se deplacer en direction de la fourmilliere
			//sinon si mode combat activer
				//si la proie s'enfuit
					//fin mode combat
					//se déplacer
				//si la proie a pas assez de fourmi sur sa tronche
					//rien faire
				//sinon
					//fin du mode combat
					//mod rameneBouffeActive
			//sinon
				//se déplacer
				//si proie sur la case
					//PHEROMONE DE CHASSE A BALLE
					//mode combat activé
					// la proie devient immobile
			//fin			
		}
	}

}
