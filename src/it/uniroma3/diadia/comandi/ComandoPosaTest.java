package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosaTest {

	private ComandoPosa comandoPosa;
	private Partita partita;

	@Before
	public void setUp() throws Exception {

		this.comandoPosa = new ComandoPosa();
		this.comandoPosa.setIO(new IOConsole());
		this.partita = new Partita();
		Borsa borsa = partita.getGiocatore().getBorsa();
		Attrezzo attrezzoNuovo = new Attrezzo("attrezzoDaPosare", 1);
		borsa.addAttrezzo(attrezzoNuovo);
	}

	@Test
	public void testPosaCorrettamente() {
		this.comandoPosa.setParametro("attrezzoDaPosare");
		this.comandoPosa.esegui(partita);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("attrezzoDaPosare"));
		assertFalse(partita.getGiocatore().getBorsa().hasAttrezzo("attrezzoDaPosare"));
	}

	@Test
	public void testPosaAttrezzoFake() {

		this.comandoPosa.setParametro("attrezzoFake");
		this.comandoPosa.esegui(partita);
		assertFalse(partita.getStanzaCorrente().hasAttrezzo("attrezzoFake"));

	}

}
