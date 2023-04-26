package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {

	private IO io;
	private String nomeAttrezzo;
	private static final String NOME = "posa";

	@Override
	public void esegui(Partita partita) {
//		Borsa borsa = partita.getGiocatore().getBorsa();
//		Attrezzo attrezzoDaPosare = borsa.getAttrezzo(this.nomeAttrezzo);
//		if (attrezzoDaPosare == null) {
//			this.io.mostraMessaggio("Attrezzo " + attrezzoDaPosare + " non presente nella borsa");
//			return;
//		}
//
//		boolean attrezzoPosato = partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare);
//		if (!attrezzoPosato) {
//			this.io.mostraMessaggio("Non c'è più spazio per nuovi attrezzi nella stanza");
//			return;
//		}
//
//		borsa.removeAttrezzo(this.nomeAttrezzo);
//		this.io.mostraMessaggio("Attrezzo " + this.nomeAttrezzo + " posato!");
//		
		if (nomeAttrezzo == null) {
			this.io.mostraMessaggio("inserisci nome attrezzo");
			return;
		}
		if (!partita.getGiocatore().getBorsa().hasAttrezzo(nomeAttrezzo)) {
			this.io.mostraMessaggio("borsa non ha questo attrezzo");
			return;
		}
		Attrezzo attrezzoDaPosare = partita.getGiocatore().getBorsa().getAttrezzo(nomeAttrezzo);
		if (partita.getStanzaCorrente().addAttrezzo(attrezzoDaPosare) == false) {
			this.io.mostraMessaggio(
					"la stanza è piena di oggetti, non è stato possibile posare l'oggetto nella stanza");
		}
		partita.getGiocatore().getBorsa().removeAttrezzo(nomeAttrezzo);
		this.io.mostraMessaggio("attrezzo rimosso dalla borsa e posato nella stanza");

	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public void setIO(IO io) {
		this.io = io;
	}

	@Override
	public String getNome() {
		return NOME;
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}