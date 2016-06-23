package ecoach.main;

import ecoach.kayttoliittyma.*;

/**
 * Main luokka joka käynnistää ohjelman.
 *
 * @author Jontsu
 */
public class Main {

    /**
     * Luokan konstruktori joka suorittaa run metodin avaten
     * SisaanKirjautumissivu käyttöliittymän.
     *
     * @param args String syöte.
     */
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SisaanKirjautumissivu().setVisible(true);
            }
        });
    }
}
