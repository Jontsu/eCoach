package ecoach.logiikka;

public class Henkilo {

    private String nimike;
    private String email;

    public Henkilo(String nimike, String email) {

        this.nimike = nimike;
        this.email = email;
    }

    public String getNimike() {
        return nimike;
    }

    public void setNimike(String nimike) {
        this.nimike = nimike;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {

        return nimike + ", " + email;
    }
}
