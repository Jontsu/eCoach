package ecoach.tiedonkasittely;

import ecoach.logiikka.harjoitus.HarjoitusLista;
import ecoach.logiikka.harjoitus.SuoritusTilasto;
import ecoach.logiikka.henkilo.OhjaajaLista;
import ecoach.logiikka.henkilo.PelaajaLista;
import java.io.Serializable;

/**
 * Luokka joka luo olion joka sisältää ohjelman kaikki listat. Luokalle annetaan
 * syötteenä listat jotta tämä voi "kopioida" ne itseensä silää hetkellä.
 *
 * @author Jontsu
 */
public class OhjelmanTiedot implements Serializable {

    private PelaajaLista pelaajatIlmanOhjaajaa;
    private PelaajaLista kaikkiPelaajat;
    private OhjaajaLista ohjaajaLista;
    private HarjoitusLista harjoitusLista;
    private SuoritusTilasto suoritusTilasto;

    /**
     * Luokan konstruktori jolle annetaan syötteenä ohjelman kaikki listat.
     *
     * @param pelaajatIlmanOhjaajaa PelaajaLista syöte.
     * @param kaikkiPelaajat PelaajaLista syöte.
     * @param ohjaajaLista OhjaajaLista syöte.
     * @param harjoitusLista HarjoitusLista syöte.
     * @param suoritusTilasto SuoritusTilasto syöte.
     */
    public OhjelmanTiedot(PelaajaLista pelaajatIlmanOhjaajaa,
            PelaajaLista kaikkiPelaajat, OhjaajaLista ohjaajaLista,
            HarjoitusLista harjoitusLista, SuoritusTilasto suoritusTilasto) {

        this.pelaajatIlmanOhjaajaa = pelaajatIlmanOhjaajaa;
        this.kaikkiPelaajat = kaikkiPelaajat;
        this.ohjaajaLista = ohjaajaLista;
        this.harjoitusLista = harjoitusLista;
        this.suoritusTilasto = suoritusTilasto;
    }

    public PelaajaLista getPelaajatIlmanOhjaajaa() {
        return pelaajatIlmanOhjaajaa;
    }

    public PelaajaLista getKaikkiPelaajat() {
        return kaikkiPelaajat;
    }

    public OhjaajaLista getOhjaajaLista() {
        return ohjaajaLista;
    }

    public HarjoitusLista getHarjoitusLista() {
        return harjoitusLista;
    }

    public SuoritusTilasto getSuoritusTilasto() {
        return suoritusTilasto;
    }
}
