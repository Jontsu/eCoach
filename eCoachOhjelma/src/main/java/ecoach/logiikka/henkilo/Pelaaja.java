package ecoach.logiikka.henkilo;

import ecoach.logiikka.harjoitus.HarjoitusLista;

/**
 * Pelaaja luokka joka laajentaa henkilö luokkaa lisäämällä pelaajalle
 * harjoituslistan. Harjoituslista näkyy pelaajalle käyttöliittymässä. Ohjaaja
 * määrittelee pelaajan harjoituslistan ohjaajan käyttöliitymästä.
 *
 * @author Jontsu
 */
public class Pelaaja extends Henkilo {

    HarjoitusLista harjoitusLista;

    /**
     * Luokan konstruktori joka perii Henkilo luokan ja lisäksi alustaa
     * pelaajaan liittyvän harjoituslista olion.
     *
     * @param nimike String syöte.
     * @param email String syöte.
     */
    public Pelaaja(String nimike, String email) {

        super(nimike, email);
        this.harjoitusLista = null;
    }

    /**
     * Metodi joka lisää pelaajalle harjoituslistan.
     *
     * @param harjoituslista HarjoitusLista olio syöte.
     */
    public void lisaaHarjoitusLista(HarjoitusLista harjoituslista) {

        this.harjoitusLista = harjoituslista;
    }

    public HarjoitusLista getHarjoitusLista() {

        return this.harjoitusLista;
    }
}
