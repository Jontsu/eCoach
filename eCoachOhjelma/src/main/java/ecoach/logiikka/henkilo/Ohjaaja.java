package ecoach.logiikka.henkilo;

/**
 * Ohjaaja luokka joka laajentaa henkilö luokkaa lisäämällä ohjaajalle
 * pelaajalistan. Kontrolloidaan OhjaajanPaasivu käyttöliittymän kautta.
 *
 * @author Jontsu
 */
public class Ohjaaja extends Henkilo {

    private PelaajaLista pelaajalista;

    /**
     * Luokan konstruktori joka perii Henkilo luokan ja lisäksi alustaa
     * ohjaajaan liittyvän pelaajalista olion.
     *
     * @param nimike String syöte.
     * @param email String syöte.
     */
    public Ohjaaja(String nimike, String email) {
        super(nimike, email);
        this.pelaajalista = null;
    }

    /**
     * Metodi joka lisää ohjaajalle pelaajalistan.
     *
     * @param pelaajalista PelaajaLista olio syöte.
     */
    public void lisaaPelaajaLista(PelaajaLista pelaajalista) {

        this.pelaajalista = pelaajalista;
    }

    public PelaajaLista getPelaajaLista() {

        return this.pelaajalista;
    }
}
