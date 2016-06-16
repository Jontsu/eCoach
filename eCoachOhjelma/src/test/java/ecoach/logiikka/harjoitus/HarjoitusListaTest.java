package ecoach.logiikka.harjoitus;

import ecoach.logiikka.harjoitus.Harjoitus;
import ecoach.logiikka.harjoitus.HarjoitusLista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitusListaTest {

    HarjoitusLista harjoitusLista;

    public HarjoitusListaTest() {
    }

    @Before
    public void setUp() {
        harjoitusLista = new HarjoitusLista();
    }

    @Test
    public void harjoituksenLisaaminenListaanOnnistuu() {
        Harjoitus harjoitus;
        harjoitusLista.lisaaHarjoitus(harjoitus = new Harjoitus());
        assertEquals(harjoitusLista.getLista().size(), 1);
    }

    @Test
    public void harjoituksenPoistaminenOnnistuu() {
        Harjoitus harjoitus;
        harjoitusLista.lisaaHarjoitus(harjoitus = new Harjoitus());
        harjoitusLista.poistaHarjoitus(harjoitus);
        assertEquals(harjoitusLista.getLista().size(), 0);
    }

    @Test
    public void harjoitusListaOnOikeanKokoinen() {
        harjoitusLista.lisaaHarjoitus(new Harjoitus());
        harjoitusLista.lisaaHarjoitus(new Harjoitus());
        harjoitusLista.lisaaHarjoitus(new Harjoitus());
        assertEquals(harjoitusLista.getLista().size(), 3);
    }

    @Test
    public void lisattyHarjoitusLoytyyListasta() {
        harjoitusLista.lisaaHarjoitus(new Harjoitus());
        harjoitusLista.getLista().get(0).setNimi("testiharjoitus");
        assertEquals(harjoitusLista.getLista().get(0).getNimi(), "testiharjoitus");
    }
}
