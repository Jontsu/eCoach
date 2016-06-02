package ecoach.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;
    HarjoitusLista harjoituslista;

    public PelaajaTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("pelaaja", "pelaaja@mail.com");
        harjoituslista = new HarjoitusLista("harjoituslista");
    }

    @Test
    public void konstruktoriOverrideToimii() {
        HarjoitusLista harjoituslista1;
        harjoituslista1 = new HarjoitusLista("harjoituslista1");
        Pelaaja pelaaja1 = new Pelaaja(harjoituslista, "pelaaja1", "pelaaja@mail.com1");
    }

    @Test
    public void voiMaarittaaHarjoitusListan() {
        pelaaja.lisaaHarjoitusLista(harjoituslista);
    }

    @Test
    public void voiTarkistaaKaytossaOlevanHarjoitusListan() {
        pelaaja.lisaaHarjoitusLista(harjoituslista);
        assertEquals("Harjoituslista: harjoituslista", pelaaja.kaytossaOlevaHarjoitusLista().toString());
    }

    @Test
    public void pelaajanTiedotTulostuuOikein() {
        assertEquals("Pelaaja, pelaaja, pelaaja@mail.com", pelaaja.toString());
    }
}
