package ecoach.tiedonkasittely;

import java.io.*;

/**
 * Tallentaa/avaa ohjelman tiedot tiedostoon/tiedostosta.
 *
 * @author Jontsu
 */
public class TiedostonKasittelija {

    /**
     * Metodi joka tallentaa ohjelman tiedot.
     *
     * @param ohjelmanTiedot OhjelmanTiedot syöte.
     * @param tiedostonNimi String syöte.
     *
     * @throws FileNotFoundException poikkeus.
     * @throws IOException poikkeus.
     */
    public static void kirjoitaTiedostoon(OhjelmanTiedot ohjelmanTiedot, String tiedostonNimi) throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream(tiedostonNimi);

        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(ohjelmanTiedot);
        oos.close();
    }

    /**
     * Metodi joka lataa ohjelman tiedot.
     *
     * @param tiedostonNimi String syöte.
     * @throws FileNotFoundException poikkeus.
     * @throws IOException poikkeus.
     * @throws ClassNotFoundException poikkeus.
     * @return ohjelmanTiedot OhjelmanTiedot olio.
     */
    public static OhjelmanTiedot lueTiedostosta(String tiedostonNimi) throws IOException, ClassNotFoundException {

        FileInputStream fis = new FileInputStream(tiedostonNimi);
        ObjectInputStream ois = new ObjectInputStream(fis);
        OhjelmanTiedot ohjelmanTiedot = (OhjelmanTiedot) ois.readObject();
        ois.close();
        return ohjelmanTiedot;
    }
}
