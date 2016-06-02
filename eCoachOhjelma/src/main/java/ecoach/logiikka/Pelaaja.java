package ecoach.logiikka;

public class Pelaaja extends Henkilo {

    HarjoitusLista harjoitusLista;

    public Pelaaja(String nimike, String email) {
        super(nimike, email);
    }

    public Pelaaja(HarjoitusLista harjoituslista, String nimike, String email) {
        this(nimike, email);
        this.harjoitusLista = harjoituslista;
    }

    public void lisaaHarjoitusLista(HarjoitusLista harjoituslista) {
        this.harjoitusLista = harjoituslista;
    }

    public HarjoitusLista kaytossaOlevaHarjoitusLista() {
        return this.harjoitusLista;
    }

    @Override
    public String toString() {

        return getClass().getSimpleName() + ", " + super.toString();
    }
}
