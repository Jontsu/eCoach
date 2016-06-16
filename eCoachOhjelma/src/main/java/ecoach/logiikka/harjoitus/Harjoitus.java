package ecoach.logiikka.harjoitus;

/**
 * Luokka harjoitusten luomista varten, kontrolloidaan OhjaajanPaasivu
 * käyttöliittymän kautta.
 *
 * @author Jontsu
 */
public class Harjoitus {

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

        parametriValidori(nimi, 5);

        this.nimi = nimi;
    }

    /**
     * Metodi joka lisää harjoitukselle kuvauksen ja tarkistaa, että syöte on
     * sopivan pituinen käyttäen parametrivalidori metodia.
     *
     * @param kuvaus String syöte.
     */
    public void setKuvaus(String kuvaus) {

        parametriValidori(kuvaus, 30);

        this.kuvaus = kuvaus;
    }

    /**
     * Metodi joka lisää harjoitukselle harjoituslinkin ja tarkistaa, että syöte
     * on sopivan pituinen käyttäen parametrivalidori metodia.
     *
     * @param harjoitusLinkki String syöte.
     */
    public void setHarjoitusLinkki(String harjoitusLinkki) {

        parametriValidori(harjoitusLinkki, 10);

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

    /**
     * Parametrivalidori metodi, jota muut metodit kutsuu tarkistaakseen, että
     * syötteet eivät ole null arvoja, tyhjiä tai ole liian lyhyitä.
     *
     * @param parametri trakistettava parametri String syötteenä.
     * @param minPituus tarkistettavan parametrin minimi pituus integer
     * syötteenä.
     */
    public static void parametriValidori(String parametri, int minPituus) {

        if (parametri == null || parametri.isEmpty() || parametri.length() < minPituus) {
            throw new IllegalArgumentException(parametri + " syöte ei ole oikein");
        }
    }
}
