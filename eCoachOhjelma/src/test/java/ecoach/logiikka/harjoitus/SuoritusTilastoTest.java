package ecoach.logiikka.harjoitus;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class SuoritusTilastoTest {

    SuoritusTilasto suoritusTilasto;

    public SuoritusTilastoTest() {
    }

    @Before
    public void setUp() {
        suoritusTilasto = new SuoritusTilasto();
    }

    @Test
    public void suoritusTilastoonVoiLisataArvosanan() {
        Suoritus suoritus = new Suoritus();
        suoritus.setArvosana(5);
        suoritusTilasto.lisaaTilastoon(suoritus);
        assertEquals(suoritusTilasto.tilastonOtoksenKoko(), 1);
    }

    @Test
    public void suoritusTilastonKeskiarvoToimii() {
        Suoritus suoritus = new Suoritus();
        Suoritus suoritus2 = new Suoritus();
        suoritus.setArvosana(5);
        suoritus2.setArvosana(3);
        suoritusTilasto.lisaaTilastoon(suoritus);
        suoritusTilasto.lisaaTilastoon(suoritus2);
        assertEquals(suoritusTilasto.tilastonKeskiarvo(), 4.5, 2);
    }

}
