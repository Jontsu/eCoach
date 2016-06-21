package ecoach.logiikka;

import ecoach.logiikka.henkilo.*;
import ecoach.logiikka.harjoitus.*;

/**
 * Luo ohjelmasta instanssin, varmistan vain yhden lähteen tiedolle. Tämän
 * avulla tietoa siirretään ohjelman sisällä eri olioiden kesken.
 */
public class OhjelmanInstanssi {

    private static OhjelmanInstanssi ohjelmanInstanssi;
    private PelaajaLista pelaajatIlmanOhjaajaa;
    private PelaajaLista kaikkiPelaajat;
    private OhjaajaLista ohjaajaLista;
    private HarjoitusLista harjoitusLista;
    private SuoritusTilasto suoritusTilasto;

    private OhjelmanInstanssi() {

        pelaajatIlmanOhjaajaa = new PelaajaLista();
        kaikkiPelaajat = new PelaajaLista();
        ohjaajaLista = new OhjaajaLista();
        harjoitusLista = new HarjoitusLista();
        suoritusTilasto = new SuoritusTilasto();
    }

    public static OhjelmanInstanssi getInstance() {

        if (ohjelmanInstanssi == null) {
            ohjelmanInstanssi = new OhjelmanInstanssi();
        }

        return ohjelmanInstanssi;
    }

    public static void setInstance(OhjelmanInstanssi tallennettuInstanssi) {

        ohjelmanInstanssi = tallennettuInstanssi;
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
