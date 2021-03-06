package ecoach.logiikka.henkilo;

import java.io.Serializable;

/**
 * Luokka joka määrittää henkilölle kuuluvat perustiedot.
 *
 * @author Jontsu
 */
public class Henkilo implements Serializable {

    private String nimike;
    private String email;

    /**
     * Luokan konstruktori jolle annetaan nimike ja email syötteenä.
     *
     * @param nimike String syöte.
     * @param email String syöte.
     */
    public Henkilo(String nimike, String email) {

        this.nimike = nimike;
        this.email = email;
    }

    public String getNimike() {
        return nimike;
    }

    public void setNimike(String nimike) {
        this.nimike = nimike;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
