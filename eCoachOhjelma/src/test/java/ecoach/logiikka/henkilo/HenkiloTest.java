package ecoach.logiikka.henkilo;

import ecoach.logiikka.henkilo.Henkilo;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HenkiloTest {

    Henkilo henkilo;

    public HenkiloTest() {
    }

    @Before
    public void setUp() {
        henkilo = new Henkilo("henkilo", "henkilo@mail.com");
    }

    @Test
    public void konstruktoriAntaaNimikkeenJaMailinOikein() {
        assertEquals("henkilo, henkilo@mail.com", henkilo.toString());
    }
    
    @Test
    public void henkilonTietojaVoiMuokata() {
        henkilo.setNimike("henkilo1");
        henkilo.setEmail("henkilo1@mail.com");
        assertEquals("henkilo1, henkilo1@mail.com", henkilo.toString());
    }
}
