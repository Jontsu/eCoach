package ecoach.logiikka.henkilo;

import ecoach.logiikka.harjoitus.HarjoitusLista;

/**
 * Pelaaja luokka joka laajentaa henkilö luokkaa lisäämällä pelaajalle
 * harjoituslistan. Harjoituslista näkyy pelaajalle käyttöliittymässä. Ohjaaja
 * määrittelee harjoituslistan ohjaajan käyttöliitymästä.
 */
public class Pelaaja extends Henkilo {

    HarjoitusLista harjoitusLista;

    public Pelaaja(String nimike, String email) {

        super(nimike, email);
        this.harjoitusLista = null;
    }

    public void lisaaHarjoitusLista(HarjoitusLista harjoituslista) {

        this.harjoitusLista = harjoituslista;
    }

    public HarjoitusLista getHarjoitusLista() {

        return this.harjoitusLista;
    }
}
