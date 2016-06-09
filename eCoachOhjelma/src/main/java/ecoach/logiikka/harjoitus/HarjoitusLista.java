package ecoach.logiikka.harjoitus;

import java.util.ArrayList;

/**
 * Luokka harjoitusten tallentamista varten. Annetaan pelaajalle ohjaajan
 * toimesta käyttäen OhjaajanPaasivu käyttöliittymää. Näkyy pelaajalle
 * PelaajanPaasivu käyttöliittymässä.
 */
public class HarjoitusLista {

    private ArrayList<Harjoitus> harjoituslista;

    public HarjoitusLista() {

        this.harjoituslista = new ArrayList<>();
    }

    public void lisaaHarjoitus(Harjoitus harjoitus) {

        this.harjoituslista.add(harjoitus);
    }

    public void poistaHarjoitus(Harjoitus harjoitus) {

        this.harjoituslista.remove(harjoitus);
    }

    public ArrayList<Harjoitus> getLista() {

        return this.harjoituslista;
    }
}
