package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class Stanza {
    static final private int NUMERO_MASSIMO_DIREZIONI = 4;
    static final private int NUMERO_MASSIMO_ATTREZZI = 10;

    private String nome;
    private Attrezzo[] attrezzi;
    private int numeroAttrezzi;

    private Stanza[] stanzeAdiacenti;
    private String[] direzioni;
    private int numeroStanzeAdiacenti;

    public Stanza(String nome) {
        this.nome = nome;
        this.attrezzi = new Attrezzo[NUMERO_MASSIMO_ATTREZZI];
        this.numeroAttrezzi = 0;
        this.stanzeAdiacenti = new Stanza[NUMERO_MASSIMO_DIREZIONI];
        this.direzioni = new String[NUMERO_MASSIMO_DIREZIONI];
        this.numeroStanzeAdiacenti = 0;
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

        this.attrezzi[this.numeroAttrezzi] = attrezzo;
        this.numeroAttrezzi++;
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
                // sposta gli elementi successivi indietro
                for (int j = i; j < numeroAttrezzi - 1; j++) {
                    attrezzi[j] = attrezzi[j + 1];
                }
                attrezzi[--numeroAttrezzi] = null;
                return true;
            }
        }
        return false;
    }

    public void impostaStanzaAdiacente(String direzione, Stanza stanza) {
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

    public Stanza getStanzaAdiacente(String direzione) {
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
