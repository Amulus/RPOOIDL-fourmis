package tache;

import java.util.List;

import etat.Adulte;
import fourmilliere.Fourmi;
import fourmilliere.Reserve;
import proie.Proie;

public class Chasser extends Tache {

	List<Proie> proies = null;
	boolean rameneBouffe;
	boolean combat;
	Proie proie;
	int dureeCombat;
	int dureeTache = 240;

	public Chasser(Tache tache, List<Proie> proies) {
		super(tache);
		this.typeTache=Tache.CHASSER;
		this.proies = proies;
		this.dureeTache = 240;
	}

	@Override
	public void step(Fourmi fourmi) {
		// TODO Auto-generated method stub
		Adulte etat = (Adulte) fourmi.getEtat();
		dureeTache--;
		addStep();
		if (!etat.estDehors()) {
			etat.sortir();
			dureeTache=240;
		}
		
		else if(this.dureeTache <= 0 ){
			//System.out.println("je rentre");
			//System.out.println(fourmi.getCalculDeplacement().estSurFourmilliere());
			fourmi.getCalculDeplacement().deplacementRetour();
			if (fourmi.getCalculDeplacement().estSurFourmilliere()) {
				((Adulte) fourmi.getEtat()).rentrer();
				this.termine = true;
				this.addStep();
			}
		}
		else {

			if (this.combat) {
				if (!this.proie.estEnVie()) {
					this.proie = null;
					this.combat = false;
				}
				else {
					this.dureeTache++;
				}
			}

			else if (this.rameneBouffe) {
				fourmi.getCalculDeplacement().deplacementRetour();
				if (fourmi.getCalculDeplacement().estSurFourmilliere()) {
					((Adulte) fourmi.getEtat()).rentrer();
					double nourriture = fourmi.getEtat().getStockage();
					fourmi.getFourmilliere().getReserve().AjouterNourriture(nourriture);
					fourmi.getEtat().setStockage(0.0);
					this.termine = true;
					this.addStep();
				}
			}

			else {
				Proie proieEventuel = fourmi.getCalculDeplacement().testPositionProie(this.proies, fourmi);

				if (proieEventuel == null) {
					fourmi.getCalculDeplacement().deplacementChasse();
				} else {
					this.proie = proieEventuel;
					if (proieEventuel.VerifierVie()) {
						this.combat = true;
					} else {
						fourmi.getEtat().setStockage(proieEventuel.getPoid());
						proieEventuel.mourrir();
						this.rameneBouffe = true;
						this.combat = false;
					}
				}
			}
		}
	}
}
