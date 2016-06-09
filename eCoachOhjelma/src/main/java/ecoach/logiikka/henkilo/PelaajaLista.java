package ecoach.logiikka.henkilo;

import java.util.ArrayList;

/**
 * Luokka pelaajien listaan "pakkaamista" varten. Lista määritetään ohjaajalle
 * ohjaajan käyttöliittymän kautta.
 */
public class PelaajaLista {

    private ArrayList<Pelaaja> pelaajalista;

    public PelaajaLista() {

        this.pelaajalista = new ArrayList<>();
    }

    public void lisaaPelaaja(Pelaaja pelaaja) {

        this.pelaajalista.add(pelaaja);
    }

    public void poistaPelaaja(Pelaaja pelaaja) {

        this.pelaajalista.remove(pelaaja);
    }

    public ArrayList<Pelaaja> getPelaajaLista() {

        return this.pelaajalista;
    }
}
