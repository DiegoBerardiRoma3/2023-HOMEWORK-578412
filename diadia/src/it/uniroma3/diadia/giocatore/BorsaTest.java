package it.uniroma3.diadia.giocatore;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class BorsaTest {

	private Borsa borsa;

	@Before
	public void setUp() throws Exception {
		this.borsa = new Borsa();

	}

	@Test
	public void testAddAttrezzo() {
		Attrezzo nuovoAttrezzo = new Attrezzo("attrezzoTest", 1);
		this.borsa.addAttrezzo(nuovoAttrezzo);
		assertTrue(this.borsa.hasAttrezzo(nuovoAttrezzo.getNome()));

	}

}
