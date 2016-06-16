package ecoach.logiikka.henkilo;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PelaajaListaTest {

    PelaajaLista pelaajalista;

    public PelaajaListaTest() {
    }

    @Before
    public void setUp() {

        pelaajalista = new PelaajaLista();
        Pelaaja pelaaja = new Pelaaja("testi", "testi@mail.com");
        Pelaaja pelaaja1 = new Pelaaja("testi1", "testi1@mail.com");
        Pelaaja pelaaja2 = new Pelaaja("testi2", "testi2@mail.com");
        pelaajalista.lisaaPelaaja(pelaaja);
        pelaajalista.lisaaPelaaja(pelaaja1);
        pelaajalista.lisaaPelaaja(pelaaja2);
    }

    @Test
    public void listaanVoiLisataPelaajan() {

        assertEquals(pelaajalista.getPelaajaLista().get(0).getNimike(), "testi");
        assertEquals(pelaajalista.getPelaajaLista().get(0).getEmail(), "testi@mail.com");
    }

    @Test
    public void listaLisaaOikeanMaaranPelaajia() {

        assertEquals(pelaajalista.getPelaajaLista().size(), 3);
    }

    @Test
    public void listataVoiPoistaPelaajan() {

        Pelaaja pelaaja3 = new Pelaaja("testi3", "testi3@mail.com");
        pelaajalista.lisaaPelaaja(pelaaja3);
        assertEquals(pelaajalista.getPelaajaLista().size(), 4);
        pelaajalista.poistaPelaaja(pelaaja3);
        assertEquals(pelaajalista.getPelaajaLista().size(), 3);
    }
}
