package fourmilliere;

public class Depot {
	Fourmilliere fourmilliere=null;
	private int NombreDeMorts=0;
	
	public Depot(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
	}
	//Ajoute un nombre de morts au compteur et supprime de la liste de morts
	//But: Eviter de stocker pour rien des fourmies (la liste de morts est plutot une liste d'attente de morts a deposer)
	public void AjouterMort(Fourmi morte){
		this.fourmilliere.getMorts().remove(morte);
		this.NombreDeMorts+=1;
	}
	
	public void ViderDepot(){
		NombreDeMorts=0;
	}
	public long getNombreDeMorts(){
		return this.NombreDeMorts;
	}
}
