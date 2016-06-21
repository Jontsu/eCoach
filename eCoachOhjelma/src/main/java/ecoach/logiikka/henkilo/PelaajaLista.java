package ecoach.logiikka.henkilo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Luokka pelaajien ohjelmaan tallentamista ja listaan "pakkaamista" varten.
 * Listan instanssi voidaan määrittää ohjaajalle ohjaajan käyttöliittymän
 * kautta.
 */
public class PelaajaLista implements Serializable {

    private ArrayList<Pelaaja> pelaajalista;

    /**
     * Luokan konstruktori joka luo tyhjän Pelaaja olioille tarkoitetun
     * ArrayList:in.
     */
    public PelaajaLista() {

        this.pelaajalista = new ArrayList<>();
    }

    /**
     * Metodi joka lisää pelaajan pelaajalistaan.
     *
     * @param pelaaja Pelaaja olio syöte.
     */
    public void lisaaPelaaja(Pelaaja pelaaja) {

        this.pelaajalista.add(pelaaja);
    }

    /**
     * Metodi joka poistaa pelaajan pelaajalistasta.
     *
     * @param pelaaja Pelaaja olio syöte.
     */
    public void poistaPelaaja(Pelaaja pelaaja) {

        this.pelaajalista.remove(pelaaja);
    }

    public Pelaaja getPelajaListasta(Pelaaja pelaaja) {

        for (int i = 0; i < this.pelaajalista.size(); i++) {

            if (this.pelaajalista.get(i).getNimike().equals(pelaaja.getNimike())) {
                return this.pelaajalista.get(i);
            }
        }

        return null;
    }

    public ArrayList<Pelaaja> getPelaajaLista() {

        return this.pelaajalista;
    }
}
