package coucheGraphique;

public class Pheromone {
	private int ForceRetour;
	private int ForceChasse;
	
	public Pheromone(){
		this.ForceChasse=0;
		this.ForceRetour=0;
	}
	
	public void ajouterPheromoneChasse(int quantite){
		this.ForceChasse=this.ForceChasse+quantite;
	}
	public void ajouterPheromoneRetour(){
		this.ForceRetour=this.ForceRetour+1;
	}
	public int avoirPheromoneChasse(){
		return this.ForceChasse;
	}
	public int avoirPheromoneRetour(){
		return this.ForceRetour;
	}
}
