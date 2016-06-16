package ecoach.logiikka.harjoitus;

import java.util.ArrayList;

/**
 * Suoritusten analyysiä suorittava luokka. Mahdollistaa pelaajien vertailun
 * keskiarvoon, maximi pisteiden lukumäärään, jakaumaan, jne. Arvot näkyvät
 * ohjaajalle ja pelaajalle niiden käyttöliittymien kautta.
 */
public class SuoritusTilasto {

    private ArrayList<Integer> suoritusTilasto;

    public SuoritusTilasto() {

        this.suoritusTilasto = new ArrayList<>();
    }

    public void lisaaTilastoon(Suoritus suoritus) {

        this.suoritusTilasto.add(suoritus.getArvosana());
    }

    public int tilastonOtoksenKoko() {

        return suoritusTilasto.size();
    }

    public double tilastonKeskiarvo() {

        return 1.0 * tilastonSumma() / tilastonOtoksenKoko();
    }

    private int tilastonSumma() {

        int summa = 0;

        for (int i = 0; i < this.suoritusTilasto.size(); i++) {
            summa = summa + this.suoritusTilasto.get(i);
        }

        return summa;
    }
}
