package tache;

import fourmilliere.Fourmi;
import outils.LireParametres;

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
		if(fourmi.getFourmilliere().getMorts().size()>1){
			this.fourmiMorte = fourmi.getFourmilliere().getMorts().get(0);
			fourmi.getFourmilliere().getMorts().remove(fourmiMorte);
		}
	}
	
	public void deposerMort(Fourmi fourmi) {
		this.occupe = false;
		fourmi.getFourmilliere().getDepot().AjouterMort(this.fourmiMorte);
	}
}
