package coucheGraphique;

public class Pheromone {
	private int ForceRetour=0;
	private int ForceChasse=0;
	
	public Pheromone(){
		
	}
	
	public void ajouterPheromoneChasse(){
		this.ForceChasse++;
	}
	public void ajouterPheromoneRetour(){
		this.ForceRetour++;
	}
	public int avoirPheromoneChasse(){
		return this.ForceChasse;
	}
	public int avoirPheromoneRetour(){
		return this.ForceRetour;
	}
}
