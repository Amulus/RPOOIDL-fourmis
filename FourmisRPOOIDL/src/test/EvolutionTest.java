package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import evolution.Larve;
import evolution.Oeuf;
import fourmilliere.*;

public class EvolutionTest {
	
	Fourmilliere fourmilliere = new Fourmilliere();
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testEvolution() {
		int identifiantDepart = 2;
		Oeuf oeuf = new Oeuf(fourmilliere);
		assertTrue(oeuf.getIdentifiant()==identifiantDepart);
		fourmilliere.ajoutOeuf(oeuf);
		assert(fourmilliere.getLarves().size()==0);
		oeuf.changerEtat();
		assert(fourmilliere.getLarves().size()>0);
		Larve larve = fourmilliere.getLarves().get(identifiantDepart);
		System.out.println(larve);
		assertTrue(larve != null);
		
		assertTrue(larve.getIdentifiant() == identifiantDepart);
		
	}

	@Test
	public void testChangerEtat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetEtat() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetIdentifiant() {
		fail("Not yet implemented");
	}

}
