package ecoach.logiikka;

import java.util.ArrayList;

public class Ohjaaja extends Henkilo {

    private ArrayList<Pelaaja> ohjatutPelaajat;

    public Ohjaaja(String nimike, String email) {
        super(nimike, email);
        this.ohjatutPelaajat = new ArrayList<>();
    }

    public void lisaaOhjattuPelaaja(Pelaaja pelaaja) {
        this.ohjatutPelaajat.add(pelaaja);
    }

    public void poistaOhjattuPelaaja(Pelaaja pelaaja) {
        this.ohjatutPelaajat.remove(pelaaja);
    }

    public void tulostaOhjatutPelaajat() {

        for (Pelaaja i : this.ohjatutPelaajat) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {

        return getClass().getSimpleName() + ", " + super.toString();
    }
}
