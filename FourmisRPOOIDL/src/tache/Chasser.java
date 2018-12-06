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

	public Chasser(List<Proie> proies) {
		this.proies = proies;
	}

	@Override
	public void step(Fourmi fourmi) {
		// TODO Auto-generated method stub
		Adulte etat = (Adulte) fourmi.getEtat();
		if (!etat.estDehors()) {
			etat.sortir();
		}

		else {

			if (this.combat) {
				if (!this.proie.estEnVie()) {
					this.proie = null;
					this.combat = false;
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
						this.rameneBouffe = true;
						this.combat = false;
					}
				}
			}
		}
	}
}
