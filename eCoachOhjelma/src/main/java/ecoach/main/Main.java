// KÄYTÄN TÄTÄ VAIN TESTAAMISEEN, TÄMÄ POISTETAAN ELI EI ARVOSTELTAVAKSI
package ecoach.main;

import ecoach.kayttoliittyma.*;
import ecoach.logiikka.OhjelmanInstanssi;
import ecoach.logiikka.harjoitus.*;
import ecoach.logiikka.henkilo.*;

public class Main {

    public static void main(String args[]) {

        OhjaajaLista ohjaajalista;
        PelaajaLista ohjaamattomatPelaajalista;
        PelaajaLista kaikkiPelaajalista;
        HarjoitusLista harjoituslista;
        HarjoitusLista pelaajanharkat;
        Pelaaja pelaaja;
        Pelaaja pelaaja2;
        Ohjaaja ohjaaja;
        Ohjaaja ohjaaja2;

        ohjaajalista = OhjelmanInstanssi.getInstance().getOhjaajaLista();
        ohjaamattomatPelaajalista = OhjelmanInstanssi.getInstance().getPelaajatIlmanOhjaajaa();
        kaikkiPelaajalista = OhjelmanInstanssi.getInstance().getKaikkiPelaajat();
        harjoituslista = OhjelmanInstanssi.getInstance().getHarjoitusLista();
        pelaajanharkat = new HarjoitusLista();
        pelaaja = new Pelaaja("pete", "pete@peteland.com");
        pelaaja2 = new Pelaaja("pete2", "pete2@peteland.com");
        ohjaaja = new Ohjaaja("ohja", "ohja@email");
        ohjaaja2 = new Ohjaaja("ohja2", "ohja2@email");

        Harjoitus harjoitus1;
        Harjoitus harjoitus2;
        Harjoitus harjoitus3;

        harjoitus1 = new Harjoitus();
        harjoitus2 = new Harjoitus();
        harjoitus3 = new Harjoitus();

        harjoitus1.setNimi("harkka1");
        harjoitus2.setNimi("harkka2");
        harjoitus3.setNimi("harkka3");

        harjoitus1.setKuvaus("tässä kuvataan monta monta asiaa1");
        harjoitus2.setKuvaus("tässä kuvataan monta monta asiaa2");
        harjoitus3.setKuvaus("tässä kuvataan monta monta asiaa3");

        harjoitus1.setHarjoitusLinkki("www.harkka1.com");
        harjoitus2.setHarjoitusLinkki("www.harkka2.com");
        harjoitus3.setHarjoitusLinkki("www.harkka3.com");

        harjoituslista.lisaaHarjoitus(harjoitus1);
        harjoituslista.lisaaHarjoitus(harjoitus2);
        harjoituslista.lisaaHarjoitus(harjoitus3);

        ohjaamattomatPelaajalista.lisaaPelaaja(pelaaja);
        ohjaamattomatPelaajalista.lisaaPelaaja(pelaaja2);

        kaikkiPelaajalista.lisaaPelaaja(pelaaja);
        kaikkiPelaajalista.lisaaPelaaja(pelaaja2);

        pelaajanharkat.lisaaHarjoitus(harjoitus3);
        pelaajanharkat.lisaaHarjoitus(harjoitus2);

        ohjaajalista.lisaaOhjaaja(ohjaaja);
        ohjaaja.lisaaPelaajaLista(kaikkiPelaajalista);

        pelaaja.lisaaHarjoitusLista(pelaajanharkat);

        pelaaja.getHarjoitusLista().getHarjoitusListasta(harjoitus3).getSuoritus().setSuoritusLinkki("wwww.suoritus.fi");
        pelaaja.getHarjoitusLista().getHarjoitusListasta(harjoitus3).getSuoritus().muutaSuoritusStatus();

//        if (pelaaja.getHarjoitusLista() == null) {
//            System.out.println("true");
//        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SisaanKirjautumissivu().setVisible(true);
            }
        });
    }

}
