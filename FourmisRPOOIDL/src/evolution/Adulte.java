package evolution;

import fourmilliere.Fourmilliere;

public abstract class Adulte extends Evolution {
	Fourmilliere fourmilliere;
	
	Adulte(Fourmilliere fourmilliere){
		this.fourmilliere = fourmilliere;
	}
	
	abstract void jourSuivant();
	abstract void heureSuivant();
	abstract void minuteSuivant();

}
