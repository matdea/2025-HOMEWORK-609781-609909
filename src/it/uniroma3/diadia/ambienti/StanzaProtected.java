package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaProtected {
    protected static final int NUMERO_MASSIMO_DIREZIONI = 4;
    protected static final int NUMERO_MASSIMO_ATTREZZI = 10;

    protected String nome;
    protected Attrezzo[] attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
    protected int numeroAttrezzi = 0;

    protected StanzaProtected[] stanzeAdiacenti = new StanzaProtected[NUMERO_MASSIMO_DIREZIONI];
    protected String[] direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
    protected int numeroStanzeAdiacenti = 0;

    public StanzaProtected(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return this.nome;
    }
    
    public String getDescrizione() {
        return this.toString(); // usa il metodo toString() già implementato
    }

    public boolean addAttrezzo(Attrezzo attrezzo) {
        if (this.numeroAttrezzi >= NUMERO_MASSIMO_ATTREZZI)
            return false;

        this.attrezzi[this.numeroAttrezzi++] = attrezzo;
        return true;
    }

    public boolean hasAttrezzo(String nomeAttrezzo) {
        return this.getAttrezzo(nomeAttrezzo) != null;
    }

    public Attrezzo getAttrezzo(String nomeAttrezzo) {
        for (int i = 0; i < this.numeroAttrezzi; i++) {
            if (this.attrezzi[i].getNome().equals(nomeAttrezzo))
                return this.attrezzi[i];
        }
        return null;
    }

    public boolean removeAttrezzo(Attrezzo attrezzo) {
        for (int i = 0; i < numeroAttrezzi; i++) {
            if (attrezzi[i].equals(attrezzo)) {
                for (int j = i; j < numeroAttrezzi - 1; j++) {
                    attrezzi[j] = attrezzi[j + 1];
                }
                attrezzi[--numeroAttrezzi] = null;
                return true;
            }
        }
        return false;
    }

    public void impostaStanzaAdiacente(String direzione, StanzaProtected stanza) {
        boolean aggiornato = false;
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if (this.direzioni[i].equals(direzione)) {
                this.stanzeAdiacenti[i] = stanza;
                aggiornato = true;
            }
        }
        if (!aggiornato && this.numeroStanzeAdiacenti < NUMERO_MASSIMO_DIREZIONI) {
            this.direzioni[numeroStanzeAdiacenti] = direzione;
            this.stanzeAdiacenti[numeroStanzeAdiacenti] = stanza;
            this.numeroStanzeAdiacenti++;
        }
    }

    public StanzaProtected getStanzaAdiacente(String direzione) {
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++) {
            if (this.direzioni[i].equals(direzione))
                return this.stanzeAdiacenti[i];
        }
        return null;
    }

    public String[] getDirezioni() {
        String[] risultato = new String[this.numeroStanzeAdiacenti];
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
            risultato[i] = this.direzioni[i];
        return risultato;
    }

    @Override
    public String toString() {
        StringBuilder risultato = new StringBuilder();
        risultato.append(this.nome);
        risultato.append("\nUscite: ");
        for (int i = 0; i < this.numeroStanzeAdiacenti; i++)
            risultato.append(this.direzioni[i]).append(" ");
        risultato.append("\nAttrezzi nella stanza: ");
        for (int i = 0; i < this.numeroAttrezzi; i++)
            risultato.append(attrezzi[i].toString()).append(" ");
        return risultato.toString();
    }
}


