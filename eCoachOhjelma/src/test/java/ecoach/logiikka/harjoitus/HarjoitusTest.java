package ecoach.logiikka.harjoitus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitusTest {

    Harjoitus harjoitus;

    public HarjoitusTest() {
    }

    @Before
    public void setUp() {
        harjoitus = new Harjoitus();
        harjoitus.setNimi("testiHarjoitus");
        harjoitus.setKuvaus("Tämä kuvaa mistä harjoituksessa on kyse");
        harjoitus.setHarjoitusLinkki("Tähän lisätään youtube linkki");
    }

    @Test
    public void konstruktoriNimeaaHarjoituksenOikein() {

        assertEquals("testiHarjoitus", harjoitus.getNimi());
    }

    @Test
    public void harjoituksellePystyyAntamaanSisaltoa() {

        assertEquals("Tämä kuvaa mistä harjoituksessa on kyse", harjoitus.getKuvaus());
        assertEquals("Tähän lisätään youtube linkki", harjoitus.getLinkki());
    }

    @Test
    public void harjoituksellaOnSuoritus() {

        assertFalse(harjoitus.getSuoritus().suoritusStatus());
    }
}
