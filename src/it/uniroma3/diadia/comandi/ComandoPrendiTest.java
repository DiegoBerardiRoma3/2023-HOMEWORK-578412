package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPrendiTest {

	private ComandoPrendi comandoPrendi;
	private Partita partita;

	@Before
	public void setUp() throws Exception {
		this.comandoPrendi = new ComandoPrendi();
		this.comandoPrendi.setIO(new IOConsole());
		this.partita = new Partita();
		Attrezzo attrezzoNuovo = new Attrezzo("attrezzoIniziale", 1);
		this.partita.getStanzaCorrente().addAttrezzo(attrezzoNuovo);
	}

	@Test
	public void testPrendiCorrettamente() {
		this.comandoPrendi.setParametro("attrezzoIniziale");
		this.comandoPrendi.esegui(partita);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoIniziale"));
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzoIniziale"));
	}

	@Test
	public void testPrendiAttrezzoFake() {

		this.comandoPrendi.setParametro("attrezzoFake");
		this.comandoPrendi.esegui(partita);
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoFake"));

	}

}