package ecoach.tiedostonkasittely;

import java.io.*;
import ecoach.logiikka.*;

/**
 * Tallentaa/avaa ohjelman tilanteen tiedostoon/tiedostosta
 */
public class TiedostonKasittelija {

    public static void kirjoitaTiedostoon(String tiedostonNimi) throws FileNotFoundException, IOException {

        FileOutputStream fos = new FileOutputStream(tiedostonNimi);
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(OhjelmanInstanssi.getInstance());
        oos.close();
    }

    public static OhjelmanInstanssi lueTiedostosta(String tiedostonNimi) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(tiedostonNimi);
        ObjectInputStream ois = new ObjectInputStream(fis);
        OhjelmanInstanssi ohjelmanInstanssi = (OhjelmanInstanssi) ois.readObject();
        ois.close();
        return ohjelmanInstanssi;
    }
}
