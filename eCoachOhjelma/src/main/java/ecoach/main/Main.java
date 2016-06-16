//KÄYTÄN TÄTÄ VAIN TESTAAMISEEN, TÄMÄ POISTETAAN ELI EI ARVOSTELTAVAKSI
//
//package ecoach.main;
//
//import ecoach.kayttoliittyma.*;
//import ecoach.logiikka.harjoitus.*;
//import ecoach.logiikka.henkilo.*;
//
//public class Main {
//
//    public static void main(String args[]) {
//
//        PelaajaLista pelaajalista;
//        HarjoitusLista harjoituslista;
//        Pelaaja pelaaja;
//        Pelaaja pelaaja2;
//        Ohjaaja ohjaaja;
//
//        harjoituslista = new HarjoitusLista();
//        pelaaja = new Pelaaja("pete", "pete@peteland.com");
//        pelaaja2 = new Pelaaja("pete2", "pete2@peteland.com");
//        ohjaaja = new Ohjaaja("ohja", "ohja@email");
//        pelaajalista = new PelaajaLista();
//
//        Harjoitus harjoitus1;
//        Harjoitus harjoitus2;
//        Harjoitus harjoitus3;
//
//        harjoitus1 = new Harjoitus();
//        harjoitus2 = new Harjoitus();
//        harjoitus3 = new Harjoitus();
//
//        harjoitus1.setNimi("harkka1");
//        harjoitus2.setNimi("harkka2");
//        harjoitus3.setNimi("harkka3");
//
//        harjoitus1.setKuvaus("tässä kuvataan monta monta asiaa1");
//        harjoitus2.setKuvaus("tässä kuvataan monta monta asiaa2");
//        harjoitus3.setKuvaus("tässä kuvataan monta monta asiaa3");
//
//        harjoituslista.lisaaHarjoitus(harjoitus1);
//        harjoituslista.lisaaHarjoitus(harjoitus2);
//        pelaaja.lisaaHarjoitusLista(harjoituslista);
//
//        harjoituslista.lisaaHarjoitus(harjoitus3);
//
//        pelaaja2.lisaaHarjoitusLista(harjoituslista);
//
//        pelaajalista.lisaaPelaaja(pelaaja);
//        pelaajalista.lisaaPelaaja(pelaaja2);
//
//        ohjaaja.lisaaPelaajaLista(pelaajalista);
//
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new OhjaajanPaasivu(ohjaaja, harjoituslista, pelaajalista).setVisible(true);
//            }
//        });
//    }
//
//}
