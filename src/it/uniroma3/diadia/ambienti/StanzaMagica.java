package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class StanzaMagica extends Stanza {

    private static final int SOGLIA_MAGICA_DEFAULT = 3;

    private int sogliaMagica;
    private int contatoreAttrezzi;

    public StanzaMagica(String nome) {
        this(nome, SOGLIA_MAGICA_DEFAULT);
    }

    public StanzaMagica(String nome, int sogliaMagica) {
        super(nome);
        this.sogliaMagica = sogliaMagica;
        this.contatoreAttrezzi = 0;
    }

    @Override
    public boolean addAttrezzo(Attrezzo attrezzo) {
        contatoreAttrezzi++;
        if (contatoreAttrezzi > sogliaMagica)
            attrezzo = this.trasforma(attrezzo);

        return super.addAttrezzo(attrezzo);
    }

    private Attrezzo trasforma(Attrezzo attrezzo) {
        String nomeInvertito = new StringBuilder(attrezzo.getNome()).reverse().toString();
        int pesoRaddoppiato = attrezzo.getPeso() * 2;
        return new Attrezzo(nomeInvertito, pesoRaddoppiato);
    }
}

