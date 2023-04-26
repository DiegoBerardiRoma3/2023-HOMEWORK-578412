package it.uniroma3.diadia.comandi;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;

public class ComandoVaiTest {

	private Partita partita;
	private Comando comandoVai;

	@Before
	public void setUp() throws Exception {
		this.comandoVai = new ComandoVai();
		this.comandoVai.setIO(new IOConsole());
		this.partita = new Partita();
//		this.partenza = new Stanza(NOME_STANZA_PARTENZA);
//		this.partita.setStanzaCorrente(this.partenza);
	}

	@Test
	public void testComandoVaiParametroNull() {

		this.comandoVai.esegui(this.partita);
		assertEquals("Atrio", this.partita.getStanzaCorrente().getNome());

	}

	@Test
	public void testVaiStanzaNuovaStanza() {
		Stanza stanzaPartenza = new Stanza("stanzaPartenza");
		this.partita.setStanzaCorrente(stanzaPartenza);

		Stanza nuovaStanza = new Stanza("NuovaStanza");

		stanzaPartenza.impostaStanzaAdiacente("nord", nuovaStanza);
		this.comandoVai.setParametro("nord");
		this.comandoVai.esegui(partita);
		assertEquals("NuovaStanza", this.partita.getStanzaCorrente().getNome());
	}

}
