package ecoach.logiikka;

public class Harjoitus {

    private String nimi;
    private String kuvaus;
    private String linkki;

    public Harjoitus(String nimi) {

        parametriValidori(nimi, 5);

        this.nimi = nimi;
        this.kuvaus = "";
        this.linkki = "";
    }

    public void setKuvaus(String kuvaus) {

        parametriValidori(kuvaus, 30);

        this.kuvaus = kuvaus;
    }

    public void setLinkki(String linkki) {

        parametriValidori(linkki, 10);

        this.linkki = linkki;
    }

    public String getNimi() {

        return nimi;
    }

    public String getKuvaus() {

        return kuvaus;
    }

    public String getLinkki() {

        return linkki;
    }

    public static void parametriValidori(String parametri, int minPituus) {

        if (parametri == null || parametri.isEmpty() || parametri.length() < minPituus) {
            throw new IllegalArgumentException(parametri + " ei ole oikein");
        }
    }

    @Override
    public String toString() {

        return "Harjoitus " + nimi + "\nKuvaus: " + kuvaus + "\nLinkki: " + linkki;
    }
}
