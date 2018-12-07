package fourmilliere;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import coucheGraphique.Monde;
import etat.Adulte;
import etat.Nymphe;
import outils.LireParametres;

public class Fourmilliere {

	private int nombreEtapeAvantRepas = 1440;
	private List<Fourmi> morts = new ArrayList<Fourmi>();
	private List<Fourmi> fourmis = new ArrayList<Fourmi>();
	private List<Fourmi> fourmisEtapeAvant = new ArrayList<Fourmi>();
	private Depot Depot;
	private Monde monde =null;
	private Reserve Reserve;
	
	private LireParametres lectureFichier = new LireParametres();

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
			Fourmi fourmi = it.next();
			if(this.nombreEtapeAvantRepas <= 0) {
				if(verificationFaim(fourmi)) {
					fourmi.step();
				}
			}
			else {
				fourmi.step();
			}
		}
		fourmisEtapeAvant.clear();
	}
	
	public boolean verificationFaim(Fourmi fourmi) {
		boolean retour = true;
		if(this.nombreEtapeAvantRepas <= 0 && fourmi.getEtat().estAdulte()) {
			if(fourmi.getEtat().VerifierAlimentation()) {
				this.finDeVie(fourmi);
				retour = false;
			}
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
	/*
	public void affichage(){
		System.out.println("Nombre d'ouefs: "+this.nid.nombreOeuf());
		System.out.println("Nombre de larves: "+this.nid.nombreDeLarve());
		System.out.println("Nombre de Nymphes: "+this.nid.nombreDeNymphe());
		System.out.println("Nombre de Fourmies: "+this.nombreDeFourmis());
		int NombreOuvrieres = 0,NombreSoldats = 0,NombreReproducteurs = 0,NombreReine=0;
		for(int i=0; i< this.fourmis.size();i++){
			if(this.fourmis.get(i).getNumeroRole()==0){NombreReine++; break;}	
			if(this.fourmis.get(i).getNumeroRole()==1){NombreOuvrieres++; break;}
			if(this.fourmis.get(i).getNumeroRole()==2){NombreSoldats++; break;}
			if(this.fourmis.get(i).getNumeroRole()==3){NombreReproducteurs++; break;}	
		}
		System.out.println("Nombre de Fourmies Reine: "+NombreReine);
		System.out.println("Nombre de Fourmies Ouvrieres: "+NombreOuvrieres);
		System.out.println("Nombre de Fourmies Soldats: "+NombreSoldats);
		System.out.println("Nombre de Fourmies Reproducteurs: "+NombreReproducteurs);
		System.out.println("Nourriture dans la Reserve: "+this.Reserve.getReserveNouriture());
		System.out.println("Nombre de Morts: "+this.Depot.getNombreDeMorts());
		
	}
*/

	public void fourmisMorteDehors(Fourmi fourmi) {
		if(fourmi.etat.estAdulte())
			((Adulte)fourmi.etat).mourir();
		
	}

	public Monde getMonde() {	
		return this.monde;
	}

}
