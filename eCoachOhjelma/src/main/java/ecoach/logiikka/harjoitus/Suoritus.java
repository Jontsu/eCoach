package ecoach.logiikka.harjoitus;

/**
 * Harjoitukseen liityvä suoritus. Molemmat ohjaaja ja pelaaja käyttää tätä
 * käyttöliittymiensä kautta.
 */
public class Suoritus {

    private boolean suoritettu;
    private String suoritusLinkki;
    private int arvosana;

    public Suoritus() {

        this.suoritettu = false;
        this.suoritusLinkki = null;
        this.arvosana = -1;
    }

    /**
     * Pelaajan kontrolloima metodi.
     */
    public void muutaSuoritusStatus() {

        if (this.suoritettu == false) {
            this.suoritettu = true;

        } else {
            this.suoritettu = false;
        }
    }

    /**
     * Pelaajan kontrolloima metodi.
     */
    public void setSuoritusLinkki(String suorituslinkki) {

        this.suoritusLinkki = suorituslinkki;
    }

    /**
     * Ohjaajan kontrolloima metodi.
     */
    public void setArvosana(int arvosana) {

        this.arvosana = arvosana;
    }

    public boolean suoritusStatus() {

        return suoritettu;
    }

    public int getArvosana() {

        return arvosana;
    }

    public String getSuoritusLinkki() {

        return suoritusLinkki;
    }
}
