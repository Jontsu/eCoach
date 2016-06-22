package ecoach.logiikka.henkilo;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Luokka ohjaajien ohjelmaan tallentamista varten.
 *
 * @author Jontsu
 */
public class OhjaajaLista implements Serializable {

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

    public Ohjaaja getOhjaajaListasta(Ohjaaja ohjaaja) {

        for (int i = 0; i < this.ohjaajalista.size(); i++) {

            if (this.ohjaajalista.get(i).equals(ohjaaja)) {
                return ohjaaja;
            }
        }

        return null;
    }

    public boolean onkoOhjaajaListassa(Ohjaaja ohjaaja) {

        for (int i = 0; i < this.ohjaajalista.size(); i++) {

            if (this.ohjaajalista.get(i).equals(ohjaaja)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Ohjaaja> getOhjaajaLista() {

        return this.ohjaajalista;
    }
}
