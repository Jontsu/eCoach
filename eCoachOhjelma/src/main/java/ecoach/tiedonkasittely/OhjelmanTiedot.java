package ecoach.tiedonkasittely;

import ecoach.logiikka.harjoitus.HarjoitusLista;
import ecoach.logiikka.harjoitus.SuoritusTilasto;
import ecoach.logiikka.henkilo.OhjaajaLista;
import ecoach.logiikka.henkilo.PelaajaLista;

public class OhjelmanTiedot {

    private PelaajaLista pelaajatIlmanOhjaajaa;
    private PelaajaLista kaikkiPelaajat;
    private OhjaajaLista ohjaajaLista;
    private HarjoitusLista harjoitusLista;
    private SuoritusTilasto suoritusTilasto;

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
