package test;

import org.junit.Test;

import coucheGraphique.Monde;
import etat.Adulte;
import fourmilliere.Depot;
import fourmilliere.Fourmi;
import fourmilliere.Fourmilliere;
import role.FourmiOuvriere;
import tache.Nettoyer;

public class NettoyerTest {
	Fourmilliere fourmilliere;
	@Test
	public void test() {
		
		fourmilliere = new Fourmilliere(new Monde("test"));
		Depot depot = fourmilliere.getDepot();
		
		Fourmi ouvriere = new Fourmi(fourmilliere);
		ouvriere.changerEtat(new Adulte(ouvriere));
		ouvriere.getEtat().setRole(new FourmiOuvriere(ouvriere));
		ouvriere.getEtat().getRole().setTache(new Nettoyer(null));
		
		
		
		
		fourmilliere.getMorts().add(new Fourmi(fourmilliere));
		fourmilliere.getMorts().add(new Fourmi(fourmilliere));
		fourmilliere.getMorts().add(new Fourmi(fourmilliere));
		
		assert(fourmilliere.getMorts().size() == 3);
		
		ouvriere.step();//attraper
		ouvriere.step();//deposer
		
		assert(depot.getNombreDeMorts() == 1);
		
		ouvriere.step();//attraper
		ouvriere.step();//deposer
		
		System.out.println(fourmilliere.getMorts().size());
		
		assert(depot.getNombreDeMorts() == 2);
		assert(fourmilliere.getMorts().size() == 1);
		
		
	}
}
