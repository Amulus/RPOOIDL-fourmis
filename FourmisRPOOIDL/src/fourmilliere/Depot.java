package fourmilliere;

import evolution.Fourmi;
import evolution.Larve;

public class Depot {
	Fourmilliere fourmilliere=null;
	private int NombreDeMorts=0;
	public Depot(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
	}
	public void AjouterMort(Fourmi mort){
		this.fourmilliere.getMorts().remove(mort.getIdentifiant());
		this.NombreDeMorts++;
	}
	public void AjouterMort(Larve mort){
		this.fourmilliere.getMorts().remove(mort.getIdentifiant());
		this.NombreDeMorts++;
	}
	//Predateur A ajouter
	
	public void ViderDepot(){
		NombreDeMorts=0;
	}
	public long getNombreDeMorts(){
		return this.NombreDeMorts;
	}
}
