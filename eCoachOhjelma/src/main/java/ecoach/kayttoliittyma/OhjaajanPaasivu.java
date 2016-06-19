package ecoach.kayttoliittyma;

import ecoach.logiikka.*;
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
    
    public OhjaajanPaasivu(Ohjaaja ohjaaja) {
        
        initComponents();
        
        this.ohjaaja = ohjaaja;
        this.kaikkiHarjoitukset = OhjelmanInstanssi.getInstance().getHarjoitusLista();
        this.pelaajatIlmanOhjaajaa = OhjelmanInstanssi.getInstance().getPelaajatIlmanOhjaajaa();
        this.valittuPelaaja = null;
        this.apuIndeksi = 0;
        
        paivitaOhjaajanCB();
    }
    
    public final void paivitaOhjaajanCB() {

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
    }
    
    public void paivitaPelaajanHarjoitusCB() {
        
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
    
    public void paivitaHarjoituksenTiedot() {
        
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

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("ColorChooser.foreground"));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        ohjaajanPelaajatCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ohjaajanPelaajatCBActionPerformed(evt);
            }
        });
        getContentPane().add(ohjaajanPelaajatCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 200, 409, -1));

        harjoituksenKuvausTA.setColumns(20);
        harjoituksenKuvausTA.setRows(5);
        harjoituksenKuvausScrollFld.setViewportView(harjoituksenKuvausTA);

        getContentPane().add(harjoituksenKuvausScrollFld, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 569, -1));

        ohjatutPelaajatLabel.setText("Ohjatut pelaajat:");
        getContentPane().add(ohjatutPelaajatLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 171, 149, 30));

        otsikkoLoL.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        otsikkoLoL.setForeground(java.awt.Color.black);
        otsikkoLoL.setText("League of Legends Harjoitustyökalu");
        getContentPane().add(otsikkoLoL, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 569, 43));

        pelaajanHarjoituksetLabel.setText("Pelaajan harjoitukset:");
        getContentPane().add(pelaajanHarjoituksetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, 27));

        pelaajanHarjoituksetCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajanHarjoituksetCBActionPerformed(evt);
            }
        });
        getContentPane().add(pelaajanHarjoituksetCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 409, -1));

        harjoituksenKuvausField.setText("Harjoituksen kuvaus");
        getContentPane().add(harjoituksenKuvausField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 320, -1, 30));

        palautusLinkkiField.setText("Palautuslinkki");
        palautusLinkkiField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                palautusLinkkiFieldActionPerformed(evt);
            }
        });
        getContentPane().add(palautusLinkkiField, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 470, 200, 30));

        arvosteltuNappi.setText("Merkitse arvosteltuksi");
        arvosteltuNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosteltuNappiActionPerformed(evt);
            }
        });
        getContentPane().add(arvosteltuNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 470, 230, 30));

        arvosanaCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5" }));
        arvosanaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosanaCBActionPerformed(evt);
            }
        });
        getContentPane().add(arvosanaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 470, 80, 30));

        annaArvosanaLabel.setText("Arvosana:");
        getContentPane().add(annaArvosanaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 450, -1, -1));

        harjoitusLinkkiLabel.setText("Harjoituksen linkki:");
        getContentPane().add(harjoitusLinkkiLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 26));

        harjoitusLinkkiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoitusLinkkiTxtActionPerformed(evt);
            }
        });
        getContentPane().add(harjoitusLinkkiTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 409, -1));

        harjoituksetLabel.setText("Harjoitukset:");
        getContentPane().add(harjoituksetLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, -1, 14));

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
        getContentPane().add(lisaaHarjoitusNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 200, 148, -1));

        pelaajatIlmanOhjaajaaLabel.setText("Pelaajat ilman ohjaajaa:");
        getContentPane().add(pelaajatIlmanOhjaajaaLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 113, -1, 30));

        pelaajatIlmanOhjaajaaCB.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajatIlmanOhjaajaaCBActionPerformed(evt);
            }
        });
        getContentPane().add(pelaajatIlmanOhjaajaaCB, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 140, 409, -1));

        lisaaOhjattavaksiNappi.setText("Lisää pelaaja");
        lisaaOhjattavaksiNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lisaaOhjattavaksiNappiActionPerformed(evt);
            }
        });
        getContentPane().add(lisaaOhjattavaksiNappi, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 140, 148, -1));

        jLabel1.setText("Palautuslinkki:");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 450, -1, -1));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
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

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void palautusLinkkiFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_palautusLinkkiFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_palautusLinkkiFieldActionPerformed

    private void arvosteltuNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosteltuNappiActionPerformed
        
        valittuPelaaja.getHarjoitusLista().getHarjoitusLista().get(apuIndeksi).getSuoritus().setArvosana(arvosanaCB.getSelectedIndex() + 1);
        paivitaHarjoituksenTiedot();
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
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
