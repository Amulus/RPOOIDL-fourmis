package tache;

import fourmilliere.Depot;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import outils.LireParametres;

//Parcourir l'ensemble de larve et fourmi : check décédé et déplacer dans le dépot
//tout est à changer
public class Nettoyer extends Tache {
	private int NombreDeMorts=0;
	private boolean occupe;
	private Fourmi fourmiMorte;
	public Nettoyer(Tache tache){
		super(tache);
		this.typeTache = Tache.NETTOYER;
		LireParametres lecturefichier = new LireParametres();
		this.NombreDeMorts= (int) lecturefichier.ChercherParametre("NombreCadavreMaxNettoyer");
	}
	@Override
	public void step(Fourmi fourmi) {
		addStep();
		for(int i=0;i<this.NombreDeMorts;i++) {
			if(occupe) {
				this.deposerMort(fourmi);
				
			}
			else {
				this.attraperMort(fourmi);
				
			}
		}
	}
	
	public void attraperMort(Fourmi fourmi) {
		this.occupe = true;
		this.fourmiMorte = fourmi.getFourmilliere().getMorts().get(0);
		fourmi.getFourmilliere().getMorts().remove(fourmiMorte);
	}
	
	public void deposerMort(Fourmi fourmi) {
		this.occupe = false;
		fourmi.getFourmilliere().getDepot().AjouterMort(this.fourmiMorte);
	}
}
