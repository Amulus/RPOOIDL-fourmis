package fourmilliere;

import java.util.Hashtable;

import outils.LireParametres;

public class Fourmilliere {

	private Hashtable<Integer,Adulte> fourmis = new Hashtable<Integer,Adulte>();
	
	private Nid nid;
	
	private LireParametres lectureFichier = new LireParametres();

	public Fourmilliere() {
		this.fourmis = new Hashtable<Integer,Adulte>();
		this.nid = new Nid();
		
		Adulte fourmi = new Adulte(this,0);
		FourmiReine reine = new FourmiReine(fourmi);
		Nymphe nymphe = new Nymphe(this,1);
		
		this.fourmis.put(fourmi.getIdentifiant(), fourmi);
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
}
