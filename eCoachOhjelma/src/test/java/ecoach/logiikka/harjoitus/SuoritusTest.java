package ecoach.logiikka.harjoitus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuoritusTest {

    Suoritus suoritus;

    public SuoritusTest() {
    }

    @Before
    public void setUp() {
        suoritus = new Suoritus();
    }

    @Test
    public void konstruktoriToimiiOikein() {
        assertFalse(suoritus.suoritusStatus());
        assertNull(suoritus.getSuoritusLinkki());
        assertEquals(suoritus.getArvosana(), -1);
    }

    @Test
    public void muuttaaSuoritusStatuksenJosEiSuoritettu() {
        suoritus.muutaSuoritusStatus();
        suoritus.muutaSuoritusStatus();
        assertFalse(suoritus.suoritusStatus());
    }

    @Test
    public void muuttaaSuoritusStatuksenJosJoSuoritettu() {
        suoritus.muutaSuoritusStatus();
        assertTrue(suoritus.suoritusStatus());
    }

    @Test
    public void setteritJaGetteritToimii() {
        suoritus.setArvosana(5);
        suoritus.setSuoritusLinkki("linkki");
        assertEquals(suoritus.getArvosana(), 5);
        assertEquals(suoritus.getSuoritusLinkki(), "linkki");
    }

}
