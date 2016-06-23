package ecoach.logiikka.harjoitus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Luokka harjoitusten tallentamista varten. Annetaan pelaajalle ohjaajan
 * toimesta käyttäen OhjaajanPaasivu käyttöliittymää. Näkyy pelaajalle
 * PelaajanPaasivu käyttöliittymässä.
 *
 * @author Jontsu
 */
public class HarjoitusLista implements Serializable {

    private ArrayList<Harjoitus> harjoituslista;

    /**
     * Luokan konstruktori joka luo tyhjän Harjoitus olioille tarkoitetun
     * ArrayList:in.
     */
    public HarjoitusLista() {

        this.harjoituslista = new ArrayList<>();
    }

    /**
     * Metodi joka lisää harjoituksen harjoituslistaan.
     *
     * @param harjoitus Harjoitus olio syöte.
     */
    public void lisaaHarjoitus(Harjoitus harjoitus) {

        this.harjoituslista.add(harjoitus);
    }

    /**
     * Metodi joka poistaa harjoituksen harjoituslistasta.
     *
     * @param harjoitus Harjoitus olio syöte.
     */
    public void poistaHarjoitus(Harjoitus harjoitus) {

        this.harjoituslista.remove(harjoitus);
    }

    public ArrayList<Harjoitus> getHarjoitusLista() {

        return this.harjoituslista;
    }
}
