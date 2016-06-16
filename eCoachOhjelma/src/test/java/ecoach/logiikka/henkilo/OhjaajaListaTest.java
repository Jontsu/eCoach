package ecoach.logiikka.henkilo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OhjaajaListaTest {

    OhjaajaLista ohjaajalista;

    public OhjaajaListaTest() {

        ohjaajalista = new OhjaajaLista();

        Ohjaaja ohjaaja1 = new Ohjaaja("testi1", "testi1@mail.com");
        Ohjaaja ohjaaja2 = new Ohjaaja("testi2", "testi2@mail.com");
        ohjaajalista.lisaaOhjaaja(ohjaaja1);
        ohjaajalista.lisaaOhjaaja(ohjaaja2);
    }

    @Before
    public void setUp() {
    }

    @Test
    public void listaanVoiLisataOhjaajan() {

        assertEquals(ohjaajalista.getOhjaajaLista().get(0).getNimike(), "testi1");
        assertEquals(ohjaajalista.getOhjaajaLista().get(0).getEmail(), "testi1@mail.com");
    }

    @Test
    public void listaLisaaOikeanMaaranPelaajia() {

        assertEquals(ohjaajalista.getOhjaajaLista().size(), 2);
    }
}
