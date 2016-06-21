package ecoach.tiedonkasittely;

import java.io.*;
import ecoach.logiikka.*;

/**
 * Tallentaa/avaa ohjelman tilanteen tiedostoon/tiedostosta
 */
public class TiedostonKasittelija {

    public static void kirjoitaTiedostoon(OhjelmanTiedot ohjelmanTiedot, String tiedostonNimi) throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream(tiedostonNimi);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ohjelmanTiedot);
        oos.close();
    }

    public static OhjelmanTiedot lueTiedostosta(String tiedostonNimi) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(tiedostonNimi);
        ObjectInputStream ois = new ObjectInputStream(fis);
        OhjelmanTiedot ohjelmanTiedot = (OhjelmanTiedot) ois.readObject();
        ois.close();
        return ohjelmanTiedot;
    }
}
