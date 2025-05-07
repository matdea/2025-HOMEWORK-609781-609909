package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagicaProtected extends StanzaProtected {

    private int sogliaMagica;
    private int contatoreAttrezzi = 0;

    public StanzaMagicaProtected(String nome, int sogliaMagica) {
        super(nome);
        this.sogliaMagica = sogliaMagica;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        contatoreAttrezzi++;

        if (contatoreAttrezzi > sogliaMagica)
            attrezzo = trasforma(attrezzo);

        if (numeroAttrezzi < NUMERO_MASSIMO_ATTREZZI) {
            attrezzi[numeroAttrezzi++] = attrezzo;
            return true;
        }

        return false;
    }

    private Attrezzo trasforma(Attrezzo attrezzo) {
        String nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse().toString();
        int pesoRaddoppiato = attrezzo.getPeso() * 2;
        return new Attrezzo(nomeInvertito, pesoRaddoppiato);
    }
}

