package ecoach.logiikka;

import ecoach.logiikka.harjoitus.Harjoitus;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HarjoitusTest {

    Harjoitus harjoitus;

    public HarjoitusTest() {
    }

    @Before
    public void setUp() {
        harjoitus = new Harjoitus("testiHarjoitus");
    }

    @Test
    public void konstruktoriNimeaaHarjoituksenOikein() {
        assertEquals("testiHarjoitus", harjoitus.getNimi());
    }

    @Test
    public void harjoituksellePystyyAntamaanSisaltoa() {
        harjoitus.setKuvaus("Tämä kuvaa mistä harjoituksessa on kyse");
        harjoitus.setHarjoitusLinkki("Tähän lisätään youtube linkki");
        assertEquals("Tämä kuvaa mistä harjoituksessa on kyse", harjoitus.getKuvaus());
        assertEquals("Tähän lisätään youtube linkki", harjoitus.getLinkki());
    }

    @Test
    public void harjoitusTulostusMuotoOnOikein() {
        harjoitus.setKuvaus("testaillaanKuvaustaRiittävilläMerkeillä");
        harjoitus.setHarjoitusLinkki("testaillaanLinkkia");
        harjoitus.toString().compareTo("Harjoitus testeri\n"
                + "Kuvaus: testaillaanKuvaustaRiittävilläMerkeillä\n"
                + "Linkki: testaillaanLinkkia");
    }

    @Test
    public void harjoitusKonstruktoriHeittaaPoikkeuksenJosNimiSyoteOnHuono() {
        try {
            Harjoitus harjoiuts = new Harjoitus("a");
        } catch (IllegalArgumentException i) {
        }
    }

    @Test
    public void harjoitusKuvausSetteriHeittaaPoikkeuksenJosKuvausSyoteOnHuono() {
        try {
            harjoitus.setKuvaus("a");
        } catch (IllegalArgumentException i) {
        }
    }

    @Test
    public void harjoitusLinkkiSetteriHeittaaPoikkeuksenJosLinkkiSyoteOnHuono() {
        try {
            harjoitus.setHarjoitusLinkki("a");
        } catch (IllegalArgumentException i) {
        }
    }
}
