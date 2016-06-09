package ecoach.logiikka;

import ecoach.logiikka.harjoitus.HarjoitusLista;
import ecoach.logiikka.henkilo.Pelaaja;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaTest {

    Pelaaja pelaaja;
    HarjoitusLista harjoituslista;

    public PelaajaTest() {
    }

    @Before
    public void setUp() {
        pelaaja = new Pelaaja("pelaaja", "pelaaja@mail.com");
        harjoituslista = new HarjoitusLista();
    }

    @Test
    public void pelaajalleVoiMaarittaaHarjoitusListan() {
        pelaaja.lisaaHarjoitusLista(harjoituslista);
        assertNotNull(pelaaja.getHarjoitusLista());
    }
}
