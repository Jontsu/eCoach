package ecoach.logiikka;

import java.util.ArrayList;

public class HarjoitusLista {

    private String nimi;
    private ArrayList<Harjoitus> harjoituslista;

    public HarjoitusLista(String nimi) {

        this.nimi = nimi;
        this.harjoituslista = new ArrayList<>();
    }

    public String getNimi() {

        return nimi;
    }

    public void setNimi(String nimi) {

        this.nimi = nimi;
    }

    public void lisaaHarjoitus(Harjoitus harjoitus) {

        this.harjoituslista.add(harjoitus);
    }

    public void poistaHarjoitus(Harjoitus harjoitus) {

        this.harjoituslista.remove(harjoitus);
    }

    public void tulostaHarjoitukset() {

        for (Harjoitus i : this.harjoituslista) {
            System.out.println(i);
        }
    }

    @Override
    public String toString() {
        return "Harjoituslista: " + nimi;
    }
}
