package ecoach.logiikka.henkilo;

/**
 * Ohjaaja luokka joka laajentaa henkilö luokkaa lisäämällä ohjaajalle
 * pelaajalistan. Kontrolloidaan OhjaajanPaasivu käyttöliittymän kautta.
 */
public class Ohjaaja extends Henkilo {

    private PelaajaLista pelaajalista;

    public Ohjaaja(String nimike, String email) {
        super(nimike, email);
        this.pelaajalista = null;
    }

    public void lisaaPelaajaLista(PelaajaLista pelaajalista) {

        this.pelaajalista = pelaajalista;
    }

    public PelaajaLista getPelaajaLista() {

        return this.pelaajalista;
    }
}
