package ecoach.logiikka.harjoitus;

/**
 * Luokka harjoitusten luomista varten, kontrolloidaan OhjaajanPaasivu
 * käyttöliittymän kautta.
 */
public class Harjoitus {

    private String nimi;
    private String kuvaus;
    private String harjoitusLinkki;
    private Suoritus suoritus;

    public Harjoitus() {

        this.nimi = "";
        this.kuvaus = "";
        this.harjoitusLinkki = "";
        this.suoritus = new Suoritus();

    }

    public void setNimi(String nimi) {

        parametriValidori(nimi, 5);

        this.nimi = nimi;
    }

    public void setKuvaus(String kuvaus) {

        parametriValidori(kuvaus, 30);

        this.kuvaus = kuvaus;
    }

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

    public static void parametriValidori(String parametri, int minPituus) {

        if (parametri == null || parametri.isEmpty() || parametri.length() < minPituus) {
            throw new IllegalArgumentException(parametri + " syöte ei ole oikein");
        }
    }
}
