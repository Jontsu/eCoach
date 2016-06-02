package ecoach.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OhjaajaTest {

    Ohjaaja ohjaaja;

    public OhjaajaTest() {
    }

    @Before
    public void setUp() {
        ohjaaja = new Ohjaaja("ohjaaja", "ohjaaja@mail.com");
    }

    @Test
    public void ohjaajalleVoiLisataPelaajan() {
        Pelaaja pelaaja;
        ohjaaja.lisaaOhjattuPelaaja(pelaaja = new Pelaaja("pelaaja", "pelaaja@mail.com"));
    }

    @Test
    public void ohjaajaltaVoiPoistaaPelaajan() {
        Harjoitus harjoitus;
        Pelaaja pelaaja;
        ohjaaja.lisaaOhjattuPelaaja(pelaaja = new Pelaaja("pelaaja", "pelaaja@mail.com"));
        ohjaaja.poistaOhjattuPelaaja(pelaaja);
    }

    @Test
    public void ohjaajanPelaajaListaTulostuu() {
        ohjaaja.lisaaOhjattuPelaaja(new Pelaaja("pelaaja1", "pelaaja1@mail.com"));
        ohjaaja.lisaaOhjattuPelaaja(new Pelaaja("pelaaja2", "pelaaja2@mail.com"));
        ohjaaja.tulostaOhjatutPelaajat();
    }

    @Test
    public void ohjaajanTiedotTulostuuOikein() {
        assertEquals("Ohjaaja, ohjaaja, ohjaaja@mail.com", ohjaaja.toString());
    }
}
