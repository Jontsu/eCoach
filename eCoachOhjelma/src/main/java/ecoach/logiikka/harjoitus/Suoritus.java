package ecoach.logiikka.harjoitus;

/**
 * Harjoitukseen liityvä suoritus. Molemmat ohjaaja ja pelaaja käyttää tätä
 * käyttöliittymiensä kautta.
 *
 * @author Jontsu
 */
public class Suoritus {

    private boolean suoritettu;
    private String suoritusLinkki;
    private int arvosana;

    /**
     * Luokan konstruktori joka alustaa tyhjän Suoritus olion, jonka status on
     * käyttöliittymässä suorittamatta.
     */
    public Suoritus() {

        this.suoritettu = false;
        this.suoritusLinkki = null;
        this.arvosana = -1;
    }

    /**
     * Metodi joka muuttaa suorituksen statuksen, kontrolloidaan pelaajan
     * käyttöliittymän kautta.
     */
    public void muutaSuoritusStatus() {

        if (this.suoritettu == false) {
            this.suoritettu = true;

        } else {
            this.suoritettu = false;
        }
    }

    /**
     * Metodi lisää suoritukselle suorituslinkin, kontrolloidaan pelaajan
     * käyttöliittymän kautta.
     *
     * @param suorituslinkki String syöte.
     */
    public void setSuoritusLinkki(String suorituslinkki) {

        this.suoritusLinkki = suorituslinkki;
    }

    /**
     * Metodi lisää suoritukselle arvosanan, kontrolloidaan pelaajan
     * käyttöliittymän kautta.
     *
     * @param arvosana int syöte.
     */
    public void setArvosana(int arvosana) {

        this.arvosana = arvosana;
    }

    /**
     * Metodi joka palauttaa suorituksen statuksen.
     * 
     * @return suoritettu.
     */
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
