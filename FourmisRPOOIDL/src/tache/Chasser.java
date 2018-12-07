package tache;

import java.util.List;

import etat.Adulte;
import fourmilliere.Fourmi;
import proie.Proie;

//cette tâche permet aux fourmis ouvrière de chasser

public class Chasser extends Tache {

	List<Proie> proies = null;
	boolean rameneNourriture;//Boolean pour savoir si elle a de la nourriture à ramener
	boolean combat;//boolean pour savoir si elle est assigné à une proie
	Proie proie;//la proie assigné à la fourmi
	int dureeCombat;
	int dureeTache = 240; //le nombre d'étape avant que la fourmi décide de rentrer à la fourmilière pour faire une autre tache

	public Chasser(Tache tache, List<Proie> proies) {
		super(tache);
		this.typeTache=Tache.CHASSER;
		this.proies = proies;
		this.dureeTache = 240;
	}

	
	
	//A chaque étape le fourmis éxécute une action suivant certain parametre : 
	//Si elle à faim et qu'elle n'est pas assigné à une proie elle rentre à la fourmillière
	//si elle est assigné à une proie elle ne fait rien
	//si la proie qu'elle était assigné est morte, elle repart en chasse
	//si elle tue la proie, elle ramene la nourriture et termine la tache
	@Override
	public void step(Fourmi fourmi) {
		Adulte etat = (Adulte) fourmi.getEtat();
		dureeTache--;
		addStep();
		if (!etat.estDehors()) {
			etat.sortir();
			dureeTache=240;
		}
		
		else if(this.dureeTache <= 0 ){
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

			else if (this.rameneNourriture) {
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
						this.rameneNourriture = true;
						this.combat = false;
					}
				}
			}
		}
	}
}
