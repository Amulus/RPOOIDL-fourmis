package fourmilliere;

import java.util.Hashtable;

public class Nid {
	private Hashtable<Integer,Oeuf> oeufs = new Hashtable<Integer,Oeuf>();
	private Hashtable<Integer,Nymphe> nymphes = new Hashtable<Integer,Nymphe>();
	private Hashtable<Integer,Larve> larves = new Hashtable<Integer,Larve>();
	
	public Nid() {
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
	
}
