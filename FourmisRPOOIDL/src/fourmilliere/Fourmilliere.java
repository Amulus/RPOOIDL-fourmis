package fourmilliere;

import java.util.Hashtable;

import evolution.Adulte;
import evolution.Larve;
import evolution.Nymphe;
import evolution.Oeuf;
import outils.LireParametres;

public class Fourmilliere {

	private Hashtable<Integer,Adulte> fourmis = new Hashtable<Integer,Adulte>();
	
	private Nid nid;
	
	private LireParametres lectureFichier = new LireParametres();

	public Fourmilliere() {
		this.fourmis = new Hashtable<Integer,Adulte>();
		this.nid = new Nid();
		
		Adulte Reine = new Adulte(this,0);
		Reine.setReine();
		Nymphe nymphe = new Nymphe(this,1);
		
		this.fourmis.put(Reine.getIdentifiant(), Reine);
		this.nid.getNymphes().put(nymphe.getIdentifiant(),nymphe);
	}

	public Adulte getPremierAdulte() {
		return this.fourmis.get(0);
	}

	public LireParametres getLireParametres() {
		return this.lectureFichier;
	}
	
	
	
	public Hashtable<Integer, Adulte> getFourmis() {
		return fourmis;
	}

	public Hashtable<Integer, Oeuf> getOeufs() {
		return nid.getOeufs();
	}

	public Hashtable<Integer, Nymphe> getNymphes() {
		return nid.getNymphes();
	}

	public Hashtable<Integer, Larve> getLarves() {
		return nid.getLarves();
	}

	public int nombreDeLarve() {
		return this.getLarves().size();
	}
	
	public int nombreDeFourmis() {
		return this.getFourmis().size();
	}
	
	public int nombreDeNymphe() {
		return this.getNymphes().size();
	}
	
	public int nombreOeuf() {
		return this.getOeufs().size();
	}
	
	public void ajoutOeuf(Oeuf oeuf) {
		this.nid.ajoutOeuf(oeuf);;
	}
	
	public void ajoutLarve(Larve larve) {
		this.nid.ajoutLarve(larve);
	}
	
	public void ajoutNymphe(Nymphe nymphe) {
		this.nid.ajoutNymphe(nymphe);
	}
	
	public void affichage(){
		System.out.println("Nombre d'ouefs: "+this.nombreOeuf());
		System.out.println("Nombre de larves: "+this.nombreDeLarve());
		System.out.println("Nombre de Nymphes: "+this.nombreDeNymphe());
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
		
	}
}
