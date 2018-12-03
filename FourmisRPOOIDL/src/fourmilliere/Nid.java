package fourmilliere;

import java.util.Hashtable;

import evolution.Larve;
import evolution.Nymphe;
import evolution.Oeuf;

public class Nid {
	Fourmilliere fourmilliere=null;
	private Hashtable<Integer,Oeuf> oeufs = new Hashtable<Integer,Oeuf>();
	private Hashtable<Integer,Nymphe> nymphes = new Hashtable<Integer,Nymphe>();
	private Hashtable<Integer,Larve> larves = new Hashtable<Integer,Larve>();
	
	public Nid(Fourmilliere fourmilliere) {
		this.fourmilliere=fourmilliere;
		this.oeufs = new Hashtable<Integer,Oeuf>();
		this.nymphes = new Hashtable<Integer,Nymphe>();
		this.larves = new Hashtable<Integer,Larve>();
		
	}

	public Hashtable<Integer, Oeuf> getOeufs() {
		return oeufs;
	}

	public Hashtable<Integer, Nymphe> getNymphes() {
		return nymphes;
	}

	public Hashtable<Integer, Larve> getLarves() {
		return larves;
	}
	
	public void ajoutOeuf(Oeuf oeuf) {
		this.oeufs.put(oeuf.getIdentifiant(),oeuf);
	}
	
	public void ajoutLarve(Larve larve) {
		this.larves.put(larve.getIdentifiant(), larve);
	}
	
	public void ajoutNymphe(Nymphe nymphe) {
		this.nymphes.put(nymphe.getIdentifiant(), nymphe);
	}
	public int nombreDeLarve() {
		return this.getLarves().size();
	}
	
	public int nombreDeNymphe() {
		return this.getNymphes().size();
	}
	
	public int nombreOeuf() {
		return this.getOeufs().size();
	}
	
}
