package fourmilliere;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coucheGraphique.Monde;
import etat.Adulte;
import etat.Nymphe;
import outils.LireParametres;

public class Fourmilliere {

	public int fourmisDehors = 0;//variable de test
	public int fourmisDedans = 0;//variable de test
	private int nombreEtapeAvantRepas = 388*23;
	private List<Fourmi> morts = new ArrayList<Fourmi>();
	private List<Fourmi> fourmis = new ArrayList<Fourmi>();
	private List<Fourmi> fourmisEtapeAvant = new ArrayList<Fourmi>();
	private Depot Depot;
	private Monde monde =null;
	private Reserve Reserve;
	
	private LireParametres lectureFichier = new LireParametres();//on récupère les paramètres de la fourmillière dans le fichier de configuration

	public Fourmilliere(Monde monde) {
		this.fourmis = new ArrayList<Fourmi>();
		this.Depot = new Depot(this);
		this.Reserve = new Reserve(this);
		this.monde= monde;
		Fourmi fourmiReine = new Fourmi(this);
		Adulte adulte = new Adulte(fourmiReine);
		adulte.setReine();
		fourmiReine.changerEtat(adulte);
		Fourmi premiereNymphe = new Fourmi(this);
		Nymphe nymphe = new Nymphe(premiereNymphe);
		this.Reserve.AjouterNourriture(9999);
		premiereNymphe.changerEtat(nymphe);
		this.ajoutFourmi(fourmiReine);
		this.ajoutFourmi(premiereNymphe);
		
	}
	
	public void step() {
		for(int i=0; i<fourmis.size();i++)
			fourmisEtapeAvant.add(fourmis.get(i));
		Iterator<Fourmi> it = this.fourmisEtapeAvant.iterator();
		while(it.hasNext()) {
			this.nombreEtapeAvantRepas-=1;
			Fourmi fourmi = it.next();
			if(this.nombreEtapeAvantRepas <= 0){
				if(verificationFaim(fourmi)) 
					fourmi.step();
			}else 
				fourmi.step();
		}
		if(this.nombreEtapeAvantRepas<=0)
			this.nombreEtapeAvantRepas=388*23;
		fourmisEtapeAvant.clear();
	}
	
	public boolean verificationFaim(Fourmi fourmi) {
		boolean retour = true;
		if(this.nombreEtapeAvantRepas <= 0 && fourmi.getEtat().estAdulte()) 
			if(fourmi.getEtat().VerifierAlimentation()) {
				this.finDeVie(fourmi);
				retour = false;
			}
		return retour;
	}
	
	public void finDeVie(Fourmi fourmi) {
		if(fourmi.etat.estAdulte())
			((Adulte)fourmi.etat).mourir();
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
	}
	
	public List<Fourmi> getMorts() {
		return this.morts;
	}
	
	public List<Fourmi> getFourmis() {
		return fourmis;
	}


	public int nombreDeFourmis() {
		return this.getFourmis().size();
	}
	public Depot getDepot(){
		return this.Depot;
	}

	public Reserve getReserve(){
		return this.Reserve;
	}
	
	
	public void ajoutFourmi(Fourmi fourmi) {
		this.fourmis.add(fourmi);
	}

	public void fourmisMorteDehors(Fourmi fourmi) {
		if(fourmi.etat.estAdulte())
			((Adulte)fourmi.etat).mourir();
		
	}

	public Monde getMonde() {	
		return this.monde;
	}

}
