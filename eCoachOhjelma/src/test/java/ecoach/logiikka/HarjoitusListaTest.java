package ecoach.logiikka;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitusListaTest {

    HarjoitusLista harjoitusLista;

    public HarjoitusListaTest() {
    }

    @Before
    public void setUp() {
        harjoitusLista = new HarjoitusLista("testiHarjoitusLista");
    }

    @Test
    public void konstruktoriNimeaaHarjoitusListanOikein() {
        assertEquals("testiHarjoitusLista", harjoitusLista.getNimi());
    }

    @Test
    public void harjoituksenLisaaminenListaanOnnistuu() {
        Harjoitus harjoitus;
        harjoitusLista.lisaaHarjoitus(harjoitus = new Harjoitus("testiHarjoitus"));
    }

    @Test
    public void harjoituksenPoistaminenOnnistuu() {
        Harjoitus harjoitus;
        harjoitusLista.lisaaHarjoitus(harjoitus = new Harjoitus("testiHarjoitus"));
        harjoitusLista.poistaHarjoitus(harjoitus);
    }

    @Test
    public void harjoitusListanTulostaminenOnnistuu() {
        harjoitusLista.lisaaHarjoitus(new Harjoitus("testiHarjoitus 1"));
        harjoitusLista.lisaaHarjoitus(new Harjoitus("testiHarjoitus 2"));
        harjoitusLista.lisaaHarjoitus(new Harjoitus("testiHarjoitus 3"));
        harjoitusLista.tulostaHarjoitukset();
    }
}
