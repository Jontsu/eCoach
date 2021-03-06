package ecoach.kayttoliittyma;

import ecoach.tiedonkasittely.OhjelmanInstanssi;
import ecoach.logiikka.harjoitus.*;
import ecoach.logiikka.henkilo.*;

/**
 * Ohjaajan käyttöliittymä johon päädytään sisäänkirjautumis
 * käyttöliittymäsivulta.
 *
 * @author Jontsu
 */
public class OhjaajanPaasivu extends javax.swing.JFrame {

    private Ohjaaja ohjaaja;
    private HarjoitusLista kaikkiHarjoitukset;
    private PelaajaLista pelaajatIlmanOhjaajaa;
    private Pelaaja valittuPelaaja;
    private int apuIndeksi;

    public OhjaajanPaasivu(Ohjaaja ohjaaja) {

        initComponents();

        this.ohjaaja = ohjaaja;
        this.kaikkiHarjoitukset = OhjelmanInstanssi.getInstance().getHarjoitusLista();
        this.pelaajatIlmanOhjaajaa = OhjelmanInstanssi.getInstance().getPelaajatIlmanOhjaajaa();
        this.valittuPelaaja = null;
        this.apuIndeksi = 0;

        paivitaOhjaajanCB();
    }

    private void paivitaOhjaajanCB() {

        // lisätään ohjaajan pelaajat comboboxiin
        if (ohjaaja.getPelaajaLista() == null) {
            ohjaaja.lisaaPelaajaLista(new PelaajaLista());
        }

        for (int i = 0; i < ohjaaja.getPelaajaLista().getPelaajaLista().size(); i++) {

            if (ohjaajanPelaajatCB.getItemAt(i) == null || !ohjaajanPelaajatCB.getItemAt(i).equals(ohjaaja.getPelaajaLista().getPelaajaLista().get(i).getNimike())) {
                ohjaajanPelaajatCB.addItem(ohjaaja.getPelaajaLista().getPelaajaLista().get(i).getNimike());
            }
        }

        // lisätään kaikki harjoitukset comboboxiin        
        for (int i = 0; i < kaikkiHarjoitukset.getHarjoitusLista().size(); i++) {

            if (kaikkiHarjoituksetCB.getItemAt(i) == null || !kaikkiHarjoituksetCB.getItemAt(i).equals(kaikkiHarjoitukset.getHarjoitusLista().get(i).getNimi())) {
                kaikkiHarjoituksetCB.addItem(kaikkiHarjoitukset.getHarjoitusLista().get(i).getNimi());
            }
        }

        // lisätään pelaajat ilman ohjaajaa comboboxiin
        for (int i = 0; i < pelaajatIlmanOhjaajaa.getPelaajaLista().size(); i++) {

            if (pelaajatIlmanOhjaajaaCB.getItemAt(i) == null || !pelaajatIlmanOhjaajaaCB.getItemAt(i).equals(pelaajatIlmanOhjaajaa.getPelaajaLista().get(i).getNimike())) {
                pelaajatIlmanOhjaajaaCB.addItem(pelaajatIlmanOhjaajaa.getPelaajaLista().get(i).getNimike());
            }
        }

        // lisätään yhteenvetokenttien arvot
        arvosanojenKaTxt.setText("" + OhjelmanInstanssi.getInstance().getSuoritusTilasto().tilastonKeskiarvo());
        arvosanojenOtosTxt.setText("" + OhjelmanInstanssi.getInstance().getSuoritusTilasto().tilastonOtoksenKoko());

        // tehdään ei muutettavista kentistä vain luku kenttiä
        harjoitusLinkkiTxt.setEditable(false);
        harjoituksenKuvausTA.setEditable(false);
        palautusLinkkiField.setEditable(false);
        arvosanojenKaTxt.setEditable(false);
        arvosanojenOtosTxt.setEditable(false);
    }

    private void paivitaPelaajanHarjoitusCB() {

        if (!ohjaaja.getPelaajaLista().getPelaajaLista().isEmpty()) {

            valittuPelaaja = ohjaaja.getPelaajaLista().getPelaajaLista().get(ohjaajanPelaajatCB.getSelectedIndex());

            if (valittuPelaaja.getHarjoitusLista() == null) {
                valittuPelaaja.lisaaHarjoitusLista(new HarjoitusLista());
            }

            if (pelaajanHarjoituksetCB.getSelectedIndex() != -1) {
                pelaajanHarjoituksetCB.removeAllItems();
            }

            for (int i = 0; i < valittuPelaaja.getHarjoitusLista().getHarjoitusLista().size(); i++) {

                if (pelaajanHarjoituksetCB.getItemAt(i) == null) {
                    pelaajanHarjoituksetCB.addItem(valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(i).getNimi());
                }
            }
        }
    }

    private void paivitaHarjoituksenTiedot() {

        harjoitusLinkkiTxt.setText("");
        harjoituksenKuvausTA.setText("");

        if (pelaajanHarjoituksetCB.getSelectedIndex() != -1) {

            apuIndeksi = pelaajanHarjoituksetCB.getSelectedIndex();
            harjoitusLinkkiTxt.setText(valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getLinkki());
            harjoituksenKuvausTA.setText(valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getKuvaus());

            if (valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getSuoritus().suoritusStatus() == true) {
                palautusLinkkiField.setText(valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getSuoritus().getSuoritusLinkki());

            } else {
                palautusLinkkiField.setText("Ei palautusta");
            }

            if (valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getSuoritus().getArvosana() == -1) {
                arvosteltuNappi.setEnabled(true);
                arvosanaCB.setEnabled(true);
                arvosanaCB.setSelectedIndex(0);

            } else {
                arvosteltuNappi.setEnabled(false);
                arvosanaCB.setSelectedIndex(valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getSuoritus().getArvosana() - 1);
                arvosanaCB.setEnabled(false);
            }
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ohjaajanPelaajatCB = new javax.swing.JComboBox<>();
        harjoituksenKuvausScrollFld = new javax.swing.JScrollPane();
        harjoituksenKuvausTA = new javax.swing.JTextArea();
        ohjatutPelaajatLabel = new javax.swing.JLabel();
        otsikkoLoL = new javax.swing.JLabel();
        pelaajanHarjoituksetLabel = new javax.swing.JLabel();
        pelaajanHarjoituksetCB = new javax.swing.JComboBox<>();
        harjoituksenKuvausField = new javax.swing.JLabel();
        palautusLinkkiField = new javax.swing.JTextField();
        arvosteltuNappi = new javax.swing.JToggleButton();
        arvosanaCB = new javax.swing.JComboBox<>();
        annaArvosanaLabel = new javax.swing.JLabel();
        harjoitusLinkkiLabel = new javax.swing.JLabel();
        harjoitusLinkkiTxt = new javax.swing.JTextField();
        harjoituksetLabel = new javax.swing.JLabel();
        kaikkiHarjoituksetCB = new javax.swing.JComboBox<>();
        luoUusiHarjoitusNappi = new javax.swing.JButton();
        lisaaHarjoitusNappi = new javax.swing.JButton();
        pelaajatIlmanOhjaajaaLabel = new javax.swing.JLabel();
        pelaajatIlmanOhjaajaaCB = new javax.swing.JComboBox<>();
        lisaaOhjattavaksiNappi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        arvosanojenKaLabel = new javax.swing.JLabel();
        arvosanojenOtosLabel = new javax.swing.JLabel();
        arvosanojenKaTxt = new javax.swing.JTextField();
        arvosanojenOtosTxt = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("ColorChooser.foreground"));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ohjaajanPelaajatCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ohjaajanPelaajatCBActionPerformed(evt);
            }
        });
        getContentPane().add(ohjaajanPelaajatCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 250, 409, -1));

        harjoituksenKuvausTA.setColumns(20);
        harjoituksenKuvausTA.setRows(5);
        harjoituksenKuvausScrollFld.setViewportView(harjoituksenKuvausTA);

        getContentPane().add(harjoituksenKuvausScrollFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 380, 569, -1));

        ohjatutPelaajatLabel.setText("Ohjatut pelaajat:");
        getContentPane().add(ohjatutPelaajatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 230, 149, 20));

        otsikkoLoL.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        otsikkoLoL.setForeground(java.awt.Color.black);
        otsikkoLoL.setText("League of Legends Harjoitustyökalu");
        getContentPane().add(otsikkoLoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 569, 43));

        pelaajanHarjoituksetLabel.setText("Pelaajan harjoitukset:");
        getContentPane().add(pelaajanHarjoituksetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 290, -1, 27));

        pelaajanHarjoituksetCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajanHarjoituksetCBActionPerformed(evt);
            }
        });
        getContentPane().add(pelaajanHarjoituksetCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 290, 409, -1));

        harjoituksenKuvausField.setText("Harjoituksen kuvaus");
        getContentPane().add(harjoituksenKuvausField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 360, -1, 20));

        palautusLinkkiField.setText("Palautuslinkki");
        palautusLinkkiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palautusLinkkiFieldActionPerformed(evt);
            }
        });
        getContentPane().add(palautusLinkkiField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 500, 200, 30));

        arvosteltuNappi.setText("Merkitse arvosteltuksi");
        arvosteltuNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosteltuNappiActionPerformed(evt);
            }
        });
        getContentPane().add(arvosteltuNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 500, 230, 30));

        arvosanaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        arvosanaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosanaCBActionPerformed(evt);
            }
        });
        getContentPane().add(arvosanaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 80, 30));

        annaArvosanaLabel.setText("Arvosana:");
        getContentPane().add(annaArvosanaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 480, -1, -1));

        harjoitusLinkkiLabel.setText("Harjoituksen linkki:");
        getContentPane().add(harjoitusLinkkiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 26));

        harjoitusLinkkiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoitusLinkkiTxtActionPerformed(evt);
            }
        });
        getContentPane().add(harjoitusLinkkiTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 409, 27));

        harjoituksetLabel.setText("Harjoitukset:");
        getContentPane().add(harjoituksetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 54, -1, 30));

        kaikkiHarjoituksetCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaikkiHarjoituksetCBActionPerformed(evt);
            }
        });
        getContentPane().add(kaikkiHarjoituksetCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 80, 409, -1));

        luoUusiHarjoitusNappi.setText("Uusi harjoitus");
        luoUusiHarjoitusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luoUusiHarjoitusNappiActionPerformed(evt);
            }
        });
        getContentPane().add(luoUusiHarjoitusNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 80, 148, -1));

        lisaaHarjoitusNappi.setText("Lisää harjoitus");
        lisaaHarjoitusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaHarjoitusNappiActionPerformed(evt);
            }
        });
        getContentPane().add(lisaaHarjoitusNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 248, 148, -1));

        pelaajatIlmanOhjaajaaLabel.setText("Pelaajat ilman ohjaajaa:");
        getContentPane().add(pelaajatIlmanOhjaajaaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, -1, 20));

        pelaajatIlmanOhjaajaaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajatIlmanOhjaajaaCBActionPerformed(evt);
            }
        });
        getContentPane().add(pelaajatIlmanOhjaajaaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 409, -1));

        lisaaOhjattavaksiNappi.setText("Lisää pelaaja");
        lisaaOhjattavaksiNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaOhjattavaksiNappiActionPerformed(evt);
            }
        });
        getContentPane().add(lisaaOhjattavaksiNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 148, -1));

        jLabel1.setText("Palautuslinkki:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 480, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 500, -1, 10));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 160, 0, -1));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 510, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 0, 10, 510));

        arvosanojenKaLabel.setText("Pelaajien kaikkien harjoitusten suoritusten keskiarvo:");
        getContentPane().add(arvosanojenKaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        arvosanojenOtosLabel.setText("Kaikkien harjoitusten suoritusten määrä:");
        getContentPane().add(arvosanojenOtosLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 148, -1, -1));

        arvosanojenKaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosanojenKaTxtActionPerformed(evt);
            }
        });
        getContentPane().add(arvosanojenKaTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 115, 60, 27));

        arvosanojenOtosTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosanojenOtosTxtActionPerformed(evt);
            }
        });
        getContentPane().add(arvosanojenOtosTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 145, 60, 27));

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 570, 10));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void palautusLinkkiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palautusLinkkiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palautusLinkkiFieldActionPerformed

    private void arvosteltuNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosteltuNappiActionPerformed

        valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getSuoritus().setArvosana(arvosanaCB.getSelectedIndex() + 1);
    }//GEN-LAST:event_arvosteltuNappiActionPerformed

    private void luoUusiHarjoitusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luoUusiHarjoitusNappiActionPerformed

        new HarjoituksenLuominen(this.ohjaaja).setVisible(true);
        super.dispose();
    }//GEN-LAST:event_luoUusiHarjoitusNappiActionPerformed

    private void lisaaHarjoitusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaHarjoitusNappiActionPerformed

        if (valittuPelaaja != null && valittuPelaaja.getHarjoitusLista() != null) {

            if (!valittuPelaaja.getHarjoitusLista().getHarjoitusLista().contains(kaikkiHarjoitukset.getHarjoitusLista().get(kaikkiHarjoituksetCB.getSelectedIndex()))) {
                valittuPelaaja.getHarjoitusLista().lisaaHarjoitus(kaikkiHarjoitukset.getHarjoitusLista().get(kaikkiHarjoituksetCB.getSelectedIndex()));
                pelaajanHarjoituksetCB.addItem(kaikkiHarjoitukset.getHarjoitusLista().get(kaikkiHarjoituksetCB.getSelectedIndex()).getNimi());
            }
        }
    }//GEN-LAST:event_lisaaHarjoitusNappiActionPerformed

    private void arvosanaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosanaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arvosanaCBActionPerformed

    private void kaikkiHarjoituksetCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaikkiHarjoituksetCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kaikkiHarjoituksetCBActionPerformed

    private void ohjaajanPelaajatCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ohjaajanPelaajatCBActionPerformed

        paivitaPelaajanHarjoitusCB();
    }//GEN-LAST:event_ohjaajanPelaajatCBActionPerformed

    private void pelaajanHarjoituksetCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajanHarjoituksetCBActionPerformed

        paivitaHarjoituksenTiedot();
    }//GEN-LAST:event_pelaajanHarjoituksetCBActionPerformed

    private void lisaaOhjattavaksiNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaOhjattavaksiNappiActionPerformed

        if (!pelaajatIlmanOhjaajaa.getPelaajaLista().isEmpty()) {
            apuIndeksi = pelaajatIlmanOhjaajaaCB.getSelectedIndex();
            ohjaaja.getPelaajaLista().lisaaPelaaja(pelaajatIlmanOhjaajaa.getPelaajaLista().get(apuIndeksi));
            pelaajatIlmanOhjaajaa.poistaPelaaja(pelaajatIlmanOhjaajaa.getPelaajaLista().get(apuIndeksi));
            pelaajatIlmanOhjaajaaCB.removeItemAt(apuIndeksi);
            paivitaOhjaajanCB();
        }
    }//GEN-LAST:event_lisaaOhjattavaksiNappiActionPerformed

    private void pelaajatIlmanOhjaajaaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajatIlmanOhjaajaaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pelaajatIlmanOhjaajaaCBActionPerformed

    private void harjoitusLinkkiTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoitusLinkkiTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harjoitusLinkkiTxtActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        OhjelmanInstanssi.getInstance().tallennaOhjelma();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        System.out.println("valittuPelaaja.getHarjoitusLista().getHarjoitusLista().size()");
        OhjelmanInstanssi.getInstance().tallennaOhjelma();
    }//GEN-LAST:event_formWindowClosing

    private void arvosanojenKaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosanojenKaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arvosanojenKaTxtActionPerformed

    private void arvosanojenOtosTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosanojenOtosTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arvosanojenOtosTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel annaArvosanaLabel;
    private javax.swing.JComboBox<String> arvosanaCB;
    private javax.swing.JLabel arvosanojenKaLabel;
    private javax.swing.JTextField arvosanojenKaTxt;
    private javax.swing.JLabel arvosanojenOtosLabel;
    private javax.swing.JTextField arvosanojenOtosTxt;
    private javax.swing.JToggleButton arvosteltuNappi;
    private javax.swing.JLabel harjoituksenKuvausField;
    private javax.swing.JScrollPane harjoituksenKuvausScrollFld;
    private javax.swing.JTextArea harjoituksenKuvausTA;
    private javax.swing.JLabel harjoituksetLabel;
    private javax.swing.JLabel harjoitusLinkkiLabel;
    private javax.swing.JTextField harjoitusLinkkiTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JComboBox<String> kaikkiHarjoituksetCB;
    private javax.swing.JButton lisaaHarjoitusNappi;
    private javax.swing.JButton lisaaOhjattavaksiNappi;
    private javax.swing.JButton luoUusiHarjoitusNappi;
    private javax.swing.JComboBox<String> ohjaajanPelaajatCB;
    private javax.swing.JLabel ohjatutPelaajatLabel;
    private javax.swing.JLabel otsikkoLoL;
    private javax.swing.JTextField palautusLinkkiField;
    private javax.swing.JComboBox<String> pelaajanHarjoituksetCB;
    private javax.swing.JLabel pelaajanHarjoituksetLabel;
    private javax.swing.JComboBox<String> pelaajatIlmanOhjaajaaCB;
    private javax.swing.JLabel pelaajatIlmanOhjaajaaLabel;
    // End of variables declaration//GEN-END:variables
}
