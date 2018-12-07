package fourmilliere;

public class Depot {
	Fourmilliere fourmilliere=null;
	private int NombreDeMorts=0;
	public Depot(Fourmilliere fourmilliere){
		this.fourmilliere=fourmilliere;
	}
	public void AjouterMort(Fourmi morte){
		this.fourmilliere.getMorts().remove(morte);
		this.NombreDeMorts+=1;
	}
	//Predateur A ajouter
	
	public void ViderDepot(){
		NombreDeMorts=0;
	}
	public long getNombreDeMorts(){
		return this.NombreDeMorts;
	}
}
