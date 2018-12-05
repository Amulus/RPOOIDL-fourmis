package tache;

public class Couple<U,V> {
	U gauche;
	V droite;
	
	public U getGauche() {
		return gauche;
	}
	public void setGauche(U gauche) {
		this.gauche = gauche;
	}
	public V getDroite() {
		return droite;
	}
	public void setDroite(V droite) {
		this.droite = droite;
	}
	
}
