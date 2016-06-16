package ecoach.kayttoliittyma;

import ecoach.logiikka.harjoitus.*;
import ecoach.logiikka.henkilo.*;
import javax.swing.*;

/**
 * Ohjaajan käyttöliittymä johon päädytään sisäänkirjautumis
 * käyttöliittymäsivulta.
 */
public class OhjaajanPaasivu extends javax.swing.JFrame {

    private Ohjaaja ohjaaja;
    private HarjoitusLista kaikkiHarjoitukset;
    private PelaajaLista pelaajatIlmanOhjaajaa;
    private Pelaaja valittuPelaaja;
    private int apuIndeksi;

    public OhjaajanPaasivu(Ohjaaja ohjaaja, HarjoitusLista kaikkiHarjoitukset, PelaajaLista pelaajatIlmanOhjaajaa) {
        initComponents();

        this.ohjaaja = ohjaaja;
        this.kaikkiHarjoitukset = kaikkiHarjoitukset;
        this.pelaajatIlmanOhjaajaa = pelaajatIlmanOhjaajaa;
        this.valittuPelaaja = null;
        this.apuIndeksi = 0;

        // lisätään ohjaajan pelaajat comboboxiin
        for (int i = 0; i < ohjaaja.getPelaajaLista().getPelaajaLista().size(); i++) {
            ohjaajanPelaajatCB.addItem(ohjaaja.getPelaajaLista().getPelaajaLista().get(i).getNimike());
        }

        // tarvitaanko? ohjaajanPelaajatCB.setSelectedIndex(apuIndeksi);
        // lisätään olemassa olevat harjoitukset comboboxiin        
        for (int i = 0; i < kaikkiHarjoitukset.getLista().size(); i++) {
            kaikkiHarjoituksetCB.addItem(kaikkiHarjoitukset.getLista().get(i).getNimi());
        }

        // tarvitaanko? kaikkiHarjoituksetCB.setSelectedIndex(apuIndeksi);
        // lisätään ohjaajan pelaajat ilman ohjaajaa comboboxiin
        for (int i = 0; i < pelaajatIlmanOhjaajaa.getPelaajaLista().size(); i++) {
            pelaajatIlmanOhjaajaaCB.addItem(pelaajatIlmanOhjaajaa.getPelaajaLista().get(i).getNimike());
        }

        // tarvitaanko? pelaajatIlmanOhjaajaaCB.setSelectedIndex(apuIndeksi);
    }

    public void paivitaHarjoitukseenLiittyvatTiedot() {

        harjoitusLinkkiTxt.setText(valittuPelaaja.getHarjoitusLista().getLista().get(apuIndeksi).getLinkki());
        harjoituksenKuvausTA.setText(valittuPelaaja.getHarjoitusLista().getLista().get(apuIndeksi).getKuvaus());

        if (valittuPelaaja.getHarjoitusLista().getLista().get(apuIndeksi).getSuoritus().suoritusStatus() == true) {
            palautusLinkkiField.setText(valittuPelaaja.getHarjoitusLista().getLista().get(apuIndeksi).getSuoritus().getSuoritusLinkki());
        } else {
            palautusLinkkiField.setText("Ei palautusta");
        }

        if (valittuPelaaja.getHarjoitusLista().getLista().get(apuIndeksi).getSuoritus().getArvosana() == -1) {
            arvosteltuNappi.setEnabled(true);
        } else {
            arvosteltuNappi.setEnabled(false);
            arvosanaCB.setSelectedIndex(valittuPelaaja.getHarjoitusLista().getLista().get(apuIndeksi).getSuoritus().getArvosana() - 1);
            arvosanaCB.setEnabled(false);
        }
    }

    public void cbMouseListener() {
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("ColorChooser.foreground"));

        ohjaajanPelaajatCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ohjaajanPelaajatCBActionPerformed(evt);
            }
        });

        harjoituksenKuvausTA.setColumns(20);
        harjoituksenKuvausTA.setRows(5);
        harjoituksenKuvausScrollFld.setViewportView(harjoituksenKuvausTA);

        ohjatutPelaajatLabel.setText("Ohjatut pelaajat:");

        otsikkoLoL.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        otsikkoLoL.setForeground(java.awt.Color.black);
        otsikkoLoL.setText("League of Legends Harjoitustyökalu");

        pelaajanHarjoituksetLabel.setText("Pelaajan harjoitukset:");

        pelaajanHarjoituksetCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajanHarjoituksetCBActionPerformed(evt);
            }
        });

        harjoituksenKuvausField.setText("Harjoituksen kuvaus");

        palautusLinkkiField.setText("Palautuslinkki");
        palautusLinkkiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palautusLinkkiFieldActionPerformed(evt);
            }
        });

        arvosteltuNappi.setText("Merkitse arvosteltuksi");
        arvosteltuNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosteltuNappiActionPerformed(evt);
            }
        });

        arvosanaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        arvosanaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosanaCBActionPerformed(evt);
            }
        });

        annaArvosanaLabel.setText("Anna arvosana:");

        harjoitusLinkkiLabel.setText("Harjoituksen linkki:");

        harjoitusLinkkiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoitusLinkkiTxtActionPerformed(evt);
            }
        });

        harjoituksetLabel.setText("Harjoitukset:");

        kaikkiHarjoituksetCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kaikkiHarjoituksetCBActionPerformed(evt);
            }
        });

        luoUusiHarjoitusNappi.setText("Luo uusi harjoitus");
        luoUusiHarjoitusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luoUusiHarjoitusNappiActionPerformed(evt);
            }
        });

        lisaaHarjoitusNappi.setText("Lisää harjoitus");
        lisaaHarjoitusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaHarjoitusNappiActionPerformed(evt);
            }
        });

        pelaajatIlmanOhjaajaaLabel.setText("Pelaajat ilman ohjaajaa:");

        pelaajatIlmanOhjaajaaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajatIlmanOhjaajaaCBActionPerformed(evt);
            }
        });

        lisaaOhjattavaksiNappi.setText("Lisää ohjattavaksi");
        lisaaOhjattavaksiNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaOhjattavaksiNappiActionPerformed(evt);
            }
        });

        jLabel1.setText("Palautuslinkki:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otsikkoLoL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(harjoituksenKuvausScrollFld, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harjoituksenKuvausField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ohjaajanPelaajatCB, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ohjatutPelaajatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lisaaHarjoitusNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(pelaajanHarjoituksetLabel)
                                    .addComponent(harjoitusLinkkiLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(harjoitusLinkkiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(pelaajanHarjoituksetCB, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(pelaajatIlmanOhjaajaaLabel)
                                .addGap(263, 263, 263))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(harjoituksetLabel)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(pelaajatIlmanOhjaajaaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(kaikkiHarjoituksetCB, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(luoUusiHarjoitusNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lisaaOhjattavaksiNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(palautusLinkkiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(115, 115, 115)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(arvosanaCB, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(98, 98, 98)
                                .addComponent(arvosteltuNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(annaArvosanaLabel)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(otsikkoLoL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(harjoituksetLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(luoUusiHarjoitusNappi)
                    .addComponent(kaikkiHarjoituksetCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(pelaajatIlmanOhjaajaaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lisaaOhjattavaksiNappi)
                    .addComponent(pelaajatIlmanOhjaajaaCB, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lisaaHarjoitusNappi)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ohjatutPelaajatLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ohjaajanPelaajatCB, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pelaajanHarjoituksetCB)
                    .addComponent(pelaajanHarjoituksetLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harjoitusLinkkiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harjoitusLinkkiTxt))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(harjoituksenKuvausField)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(harjoituksenKuvausScrollFld, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(annaArvosanaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arvosteltuNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(palautusLinkkiField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(arvosanaCB, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void palautusLinkkiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palautusLinkkiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palautusLinkkiFieldActionPerformed

    private void arvosteltuNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosteltuNappiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arvosteltuNappiActionPerformed

    private void luoUusiHarjoitusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luoUusiHarjoitusNappiActionPerformed

        new HarjoituksenLuominen(kaikkiHarjoitukset).setVisible(true);
    }//GEN-LAST:event_luoUusiHarjoitusNappiActionPerformed

    private void lisaaHarjoitusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaHarjoitusNappiActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_lisaaHarjoitusNappiActionPerformed

    private void arvosanaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosanaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arvosanaCBActionPerformed

    private void kaikkiHarjoituksetCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kaikkiHarjoituksetCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kaikkiHarjoituksetCBActionPerformed

    private void ohjaajanPelaajatCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ohjaajanPelaajatCBActionPerformed
        JComboBox apuCB = (JComboBox) evt.getSource();
        valittuPelaaja = ohjaaja.getPelaajaLista().getPelaajaLista().get(apuCB.getSelectedIndex());

        
        
        for (int i = 0; i < valittuPelaaja.getHarjoitusLista().getLista().size(); i++) {

            pelaajanHarjoituksetCB.addItem(valittuPelaaja.getHarjoitusLista().getLista().get(i).getNimi());

        }
    }//GEN-LAST:event_ohjaajanPelaajatCBActionPerformed

    private void pelaajanHarjoituksetCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajanHarjoituksetCBActionPerformed
        JComboBox apuCB = (JComboBox) evt.getSource();
        apuIndeksi = apuCB.getSelectedIndex();
        paivitaHarjoitukseenLiittyvatTiedot();
    }//GEN-LAST:event_pelaajanHarjoituksetCBActionPerformed

    private void lisaaOhjattavaksiNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lisaaOhjattavaksiNappiActionPerformed
        // TODO add your handling code here:
        if (evt.getSource() == lisaaOhjattavaksiNappi) {
            ohjaaja.getPelaajaLista().lisaaPelaaja(pelaajatIlmanOhjaajaa.getPelaajaLista().get(pelaajatIlmanOhjaajaaCB.getSelectedIndex()));
        }
    }//GEN-LAST:event_lisaaOhjattavaksiNappiActionPerformed

    private void pelaajatIlmanOhjaajaaCBActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajatIlmanOhjaajaaCBActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pelaajatIlmanOhjaajaaCBActionPerformed

    private void harjoitusLinkkiTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoitusLinkkiTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harjoitusLinkkiTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel annaArvosanaLabel;
    private javax.swing.JComboBox<String> arvosanaCB;
    private javax.swing.JToggleButton arvosteltuNappi;
    private javax.swing.JLabel harjoituksenKuvausField;
    private javax.swing.JScrollPane harjoituksenKuvausScrollFld;
    private javax.swing.JTextArea harjoituksenKuvausTA;
    private javax.swing.JLabel harjoituksetLabel;
    private javax.swing.JLabel harjoitusLinkkiLabel;
    private javax.swing.JTextField harjoitusLinkkiTxt;
    private javax.swing.JLabel jLabel1;
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
