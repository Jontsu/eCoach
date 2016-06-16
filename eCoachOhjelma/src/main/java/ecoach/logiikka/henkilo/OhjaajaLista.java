package ecoach.logiikka.henkilo;

import java.util.ArrayList;

/**
 * Luokka ohjaajien ohjelmaan tallentamista varten.
 *
 * @author Jontsu
 */
public class OhjaajaLista {

    private ArrayList<Ohjaaja> ohjaajalista;

    /**
     * Luokan konstruktori joka luo tyhjän Ohjaaja olioille tarkoitetun
     * ArrayList:in.
     */
    public OhjaajaLista() {

        this.ohjaajalista = new ArrayList<>();
    }

    /**
     * Metodi joka lisää ohjaajan ohjaajalistaan.
     *
     * @param ohjaaja Ohjaaja olio syöte.
     */
    public void lisaaOhjaaja(Ohjaaja ohjaaja) {

        this.ohjaajalista.add(ohjaaja);
    }

    public ArrayList<Ohjaaja> getOhjaajaLista() {

        return this.ohjaajalista;
    }
}
