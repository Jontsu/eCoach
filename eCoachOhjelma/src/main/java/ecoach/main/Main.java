package ecoach.main;

import ecoach.kayttoliittyma.*;
import ecoach.logiikka.harjoitus.*;
import ecoach.logiikka.henkilo.*;

public class Main {

    public static void main(String args[]) {

        HarjoitusLista harjoituslista;
        Pelaaja pelaaja;

        harjoituslista = new HarjoitusLista();
        pelaaja = new Pelaaja("pete", "pete@peteland.com");

        Harjoitus harjoitus1;
        Harjoitus harjoitus2;
        Harjoitus harjoitus3;

        harjoitus1 = new Harjoitus("petenharkka1");
        harjoitus2 = new Harjoitus("petenharkka2");
        harjoitus3 = new Harjoitus("petenharkka3");

        harjoituslista.lisaaHarjoitus(harjoitus1);
        harjoituslista.lisaaHarjoitus(harjoitus2);
        harjoituslista.lisaaHarjoitus(harjoitus3);

        pelaaja.lisaaHarjoitusLista(harjoituslista);

        harjoitus1.setKuvaus("tässä kuvataan monta monta asiaa1");
        harjoitus2.setKuvaus("tässä kuvataan monta monta asiaa2");
        harjoitus3.setKuvaus("tässä kuvataan monta monta asiaa3");

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PelaajanPaasivu(pelaaja).setVisible(true);
            }
        });
    }

}
