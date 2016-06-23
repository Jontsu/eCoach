package ecoach.tiedonkasittely;

import ecoach.logiikka.henkilo.*;
import ecoach.logiikka.harjoitus.*;
import ecoach.tiedonkasittely.OhjelmanTiedot;
import ecoach.tiedonkasittely.TiedostonKasittelija;
import static ecoach.tiedonkasittely.TiedostonKasittelija.lueTiedostosta;
import java.io.Serializable;

/**
 * Luo ohjelmasta instanssin, varmistaen vain yhden lähteen tiedolle. Tämän
 * avulla tietoa siirretään ohjelman sisällä eri olioiden kesken.
 */
public class OhjelmanInstanssi implements Serializable {

    private static OhjelmanInstanssi ohjelmanInstanssi;
    private OhjelmanTiedot tallennetutTiedot;
    private PelaajaLista pelaajatIlmanOhjaajaa;
    private PelaajaLista kaikkiPelaajat;
    private OhjaajaLista ohjaajaLista;
    private HarjoitusLista harjoitusLista;
    private SuoritusTilasto suoritusTilasto;

    private OhjelmanInstanssi() {

        try {
            tallennetutTiedot = TiedostonKasittelija.lueTiedostosta("masterOhjelmaServerilla.tmp");
            kaikkiPelaajat = tallennetutTiedot.getKaikkiPelaajat();
            pelaajatIlmanOhjaajaa = tallennetutTiedot.getPelaajatIlmanOhjaajaa();
            ohjaajaLista = tallennetutTiedot.getOhjaajaLista();
            harjoitusLista = tallennetutTiedot.getHarjoitusLista();
            suoritusTilasto = tallennetutTiedot.getSuoritusTilasto();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            kaikkiPelaajat = new PelaajaLista();
            pelaajatIlmanOhjaajaa = new PelaajaLista();
            ohjaajaLista = new OhjaajaLista();
            harjoitusLista = new HarjoitusLista();
            suoritusTilasto = new SuoritusTilasto();
        }
    }

    /**
     * Metodi joka palauttaa piilotetussa konstruktorissa määriteltävän
     * instanssin.
     *
     * @return ohjelmanInstanssi.
     */
    public static OhjelmanInstanssi getInstance() {

        if (ohjelmanInstanssi == null) {
            ohjelmanInstanssi = new OhjelmanInstanssi();
        }

        return ohjelmanInstanssi;
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

    /**
     * Metodi joka tallentaa ohjelman hyödyntäen OhjelmanTiedot luokkaa ja
     * TiedostonKasittelija luokkaa.
     */
    public void tallennaOhjelma() {

        OhjelmanTiedot ohjelmanTiedot = new OhjelmanTiedot(
                this.pelaajatIlmanOhjaajaa, this.kaikkiPelaajat,
                this.ohjaajaLista, this.harjoitusLista, this.suoritusTilasto);

        try {
            TiedostonKasittelija.kirjoitaTiedostoon(ohjelmanTiedot, "masterOhjelmaServerilla.tmp");

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
