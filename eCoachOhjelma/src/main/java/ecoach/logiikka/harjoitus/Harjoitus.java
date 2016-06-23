package ecoach.logiikka.harjoitus;

import java.io.Serializable;

/**
 * Luokka harjoitusten luomista varten, kontrolloidaan OhjaajanPaasivu
 * käyttöliittymän kautta.
 *
 * @author Jontsu
 */
public class Harjoitus implements Serializable {

    private String nimi;
    private String kuvaus;
    private String harjoitusLinkki;
    private Suoritus suoritus;

    /**
     * Luokan konstruktori joka alustaa tyhjän Harjoitus olion ja luo tälle
     * harjoitukseen liittyvän Suoritus olion.
     */
    public Harjoitus() {

        this.nimi = "";
        this.kuvaus = "";
        this.harjoitusLinkki = "";
        this.suoritus = new Suoritus();

    }

    /**
     * Metodi joka lisää harjoitukselle nimen ja tarkistaa, että syöte on
     * sopivan pituinen käyttäen parametrivalidori metodia.
     *
     * @param nimi String syöte.
     */
    public void setNimi(String nimi) {

        this.nimi = nimi;
    }

    /**
     * Metodi joka lisää harjoitukselle kuvauksen ja tarkistaa, että syöte on
     * sopivan pituinen käyttäen parametrivalidori metodia.
     *
     * @param kuvaus String syöte.
     */
    public void setKuvaus(String kuvaus) {

        this.kuvaus = kuvaus;
    }

    /**
     * Metodi joka lisää harjoitukselle harjoituslinkin ja tarkistaa, että syöte
     * on sopivan pituinen käyttäen parametrivalidori metodia.
     *
     * @param harjoitusLinkki String syöte.
     */
    public void setHarjoitusLinkki(String harjoitusLinkki) {

        this.harjoitusLinkki = harjoitusLinkki;
    }

    public String getNimi() {

        return this.nimi;
    }

    public String getKuvaus() {

        return this.kuvaus;
    }

    public String getLinkki() {

        return this.harjoitusLinkki;
    }

    public Suoritus getSuoritus() {

        return this.suoritus;
    }
}
