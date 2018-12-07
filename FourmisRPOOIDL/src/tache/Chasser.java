package tache;

import java.util.List;

import etat.Adulte;
import fourmilliere.Fourmi;
import proie.Proie;

//cette tâche permet aux fourmies de chasser

public class Chasser extends Tache {

	List<Proie> proies = null;
	boolean rameneNourriture;//Boolean pour savoir si elle a de la nourriture à ramener
	boolean combat;//boolean pour savoir si elle est assigné à une proie donc en combat
	Proie proie;//la proie que ombat la fourmie
	int dureeTache = 240; //le nombre d'étape avant que la fourmi décide de rentrer à la fourmilière pour faire une autre tache

	public Chasser(Tache tache, List<Proie> proies) {
		super(tache);
		this.typeTache=Tache.CHASSER;
		this.proies = proies;
		this.dureeTache = 240;
	}
	
	
	//A chaque étape le fourmis éxécute une action suivant certains parametres : 
	//Si elle a faim et qu'elle n'est pas en combat alors elle rentre à la fourmillière et et termine cette tache
	//si elle est en combat elle ne fait rien et reste sur la proie jusqu'es dureeTache<=0, elle risque de mourrir par manque de nourriture
	//si la proie qu'elle combattait est morte, elle chasse
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
		//Permet a la fourmie de rentrer si elle chasser pendant trop longtemp
		else if(this.dureeTache <= 0 ){
			fourmi.getCalculDeplacement().deplacementRetour();
			if (fourmi.getCalculDeplacement().estSurFourmilliere()) {
				((Adulte) fourmi.getEtat()).rentrer();
				this.termine = true;
				this.addStep();
			}
		}
		else {
			//Si elle est en combat
			if (this.combat) {
				if (!this.proie.estEnVie()) {
					this.proie = null;
					this.combat = false;
				}
				else {
					this.dureeTache++;
				}
			}
			//Si elle doit ramener de la nourriture
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
			//test si quand elle se deplace elle est sur une proie alor sle combat est lancé
			//test si la fourmie tue la proie
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
