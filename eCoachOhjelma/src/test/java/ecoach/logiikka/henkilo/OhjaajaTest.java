package ecoach.logiikka.henkilo;

import ecoach.logiikka.henkilo.Ohjaaja;
import ecoach.logiikka.henkilo.PelaajaLista;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OhjaajaTest {

    Ohjaaja ohjaaja;
    PelaajaLista pelaajalista;

    public OhjaajaTest() {
    }

    @Before
    public void setUp() {
        ohjaaja = new Ohjaaja("ohjaaja", "ohjaaja@mail.com");
        pelaajalista = new PelaajaLista();
    }

    @Test
    public void ohjaajalleVoiMaarittaaPelaajaListan() {
        ohjaaja.lisaaPelaajaLista(pelaajalista);
        assertNotNull(ohjaaja.getPelaajaLista());
    }
}