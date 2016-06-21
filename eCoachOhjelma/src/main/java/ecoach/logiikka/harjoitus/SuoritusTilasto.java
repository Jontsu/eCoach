package ecoach.logiikka.harjoitus;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Suoritusten analyysiä suorittava luokka. Mahdollistaa pelaajien vertailun
 * keskiarvoon, maximi pisteiden lukumäärään, jakaumaan, jne. Arvot näkyvät
 * ohjaajalle ja pelaajalle niiden käyttöliittymien kautta.
 *
 * @author Jontsu
 */
public class SuoritusTilasto implements Serializable {

    private ArrayList<Integer> suoritusTilasto;

    /**
     * Luokan konstruktori joka luo tyhjän integerejä sisältävän ArrayList:in.
     */
    public SuoritusTilasto() {

        this.suoritusTilasto = new ArrayList<>();
    }

    /**
     * Metodi joka lisää suorituksen suoritustilastoon.
     *
     * @param suoritus Suoritus olio syöte.
     */
    public void lisaaTilastoon(Suoritus suoritus) {

        this.suoritusTilasto.add(suoritus.getArvosana());
    }

    /**
     * Metodi joka palauttaa tilastossa olevien suoritusten määrän.
     *
     * @return suoritusTilasto.
     */
    public int tilastonOtoksenKoko() {

        return suoritusTilasto.size();
    }

    /**
     * Metodi joka laskee kaikkien suoritusten keskiarvon.
     *
     * @return keskiarvo.
     */
    public double tilastonKeskiarvo() {

        double keskiarvo = 1.0 * tilastonSumma() / tilastonOtoksenKoko();

        return keskiarvo;
    }

    private int tilastonSumma() {

        int summa = 0;

        for (int i = 0; i < this.suoritusTilasto.size(); i++) {
            summa = summa + this.suoritusTilasto.get(i);
        }

        return summa;
    }
}
