package ecoach.kayttoliittyma;

import ecoach.logiikka.henkilo.*;
import javax.swing.*;

/**
 * Pelaajan käyttöliittymä johon päädytään sisäänkirjautumis
 * käyttöliittymäsivulta.
 */
public class PelaajanPaasivu extends javax.swing.JFrame {

    private Pelaaja pelaaja;
    private int valitunHarjoituksenIndeksi;

    public PelaajanPaasivu(Pelaaja pelaaja) {

        initComponents();
        this.pelaaja = pelaaja;
        this.valitunHarjoituksenIndeksi = 0;

        for (int i = 0; i < pelaaja.getHarjoitusLista().getLista().size(); i++) {
            harjoitusValikkoCBox.addItem(pelaaja.getHarjoitusLista().getLista().get(i).getNimi());
        }

        harjoitusValikkoCBox.setSelectedIndex(valitunHarjoituksenIndeksi);

        this.tarkistaSuoritusStatus();
    }

    public final void tarkistaSuoritusStatus() {

        if (pelaaja.getHarjoitusLista().getLista().get(valitunHarjoituksenIndeksi).getSuoritus().suoritusStatus() == true) {
            suoritusNappi.setEnabled(false);
            wwwLinkki.setText(pelaaja.getHarjoitusLista().getLista().get(valitunHarjoituksenIndeksi).getSuoritus().getSuoritusLinkki());
            wwwLinkki.setEditable(false);
        } else {
            suoritusNappi.setEnabled(true);
            wwwLinkki.setText("Lisää tähän suoritus nauhoituksen linkki");
            wwwLinkki.setEditable(true);
        }
    }

    public final void paivitaKuvaus() {

        String apuString;
        apuString = pelaaja.getHarjoitusLista().getLista().get(valitunHarjoituksenIndeksi).getKuvaus();
        harjoituksenKuvaus.setText(apuString);
        harjoituksenKuvaus.setEditable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        harjoitusValikkoCBox = new javax.swing.JComboBox<>();
        wwwLinkki = new javax.swing.JTextField();
        kuvauksenPaneeli = new javax.swing.JScrollPane();
        harjoituksenKuvaus = new javax.swing.JTextArea();
        harjoitusValikkoCBnOtsikko = new javax.swing.JLabel();
        sivunOtsikko = new javax.swing.JLabel();
        suoritusNappi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(javax.swing.UIManager.getDefaults().getColor("ColorChooser.foreground"));

        harjoitusValikkoCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoitusValikkoCBoxActionPerformed(evt);
            }
        });

        wwwLinkki.setText("Lisää tähän suoritus nauhoituksen linkki");
        wwwLinkki.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wwwLinkkiActionPerformed(evt);
            }
        });

        harjoituksenKuvaus.setColumns(20);
        harjoituksenKuvaus.setRows(5);
        kuvauksenPaneeli.setViewportView(harjoituksenKuvaus);

        harjoitusValikkoCBnOtsikko.setText("Avoimet harjoitukset:");

        sivunOtsikko.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        sivunOtsikko.setForeground(java.awt.Color.black);
        sivunOtsikko.setText("League of Legends Harjoitustyökalu");

        suoritusNappi.setText("Merkitse Suoritetuksi");
        suoritusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suoritusNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(sivunOtsikko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kuvauksenPaneeli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(harjoitusValikkoCBnOtsikko, javax.swing.GroupLayout.DEFAULT_SIZE, 175, Short.MAX_VALUE)
                        .addGap(4, 4, 4)
                        .addComponent(harjoitusValikkoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(wwwLinkki, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suoritusNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(sivunOtsikko, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harjoitusValikkoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harjoitusValikkoCBnOtsikko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kuvauksenPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(wwwLinkki, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(suoritusNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void harjoitusValikkoCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoitusValikkoCBoxActionPerformed

        JComboBox apuCB = (JComboBox) evt.getSource();
        valitunHarjoituksenIndeksi = (int) apuCB.getSelectedIndex();
        this.tarkistaSuoritusStatus();
        this.paivitaKuvaus();
    }//GEN-LAST:event_harjoitusValikkoCBoxActionPerformed

    private void suoritusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suoritusNappiActionPerformed

        if (evt.getSource() == suoritusNappi) {
            pelaaja.getHarjoitusLista().getLista().get(valitunHarjoituksenIndeksi).getSuoritus().muutaSuoritusStatus();
            pelaaja.getHarjoitusLista().getLista().get(valitunHarjoituksenIndeksi).getSuoritus().setSuoritusLinkki(wwwLinkki.getText());
            this.tarkistaSuoritusStatus();
        }
    }//GEN-LAST:event_suoritusNappiActionPerformed

    private void wwwLinkkiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wwwLinkkiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wwwLinkkiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea harjoituksenKuvaus;
    private javax.swing.JLabel harjoitusValikkoCBnOtsikko;
    private javax.swing.JComboBox<String> harjoitusValikkoCBox;
    private javax.swing.JScrollPane kuvauksenPaneeli;
    private javax.swing.JLabel sivunOtsikko;
    private javax.swing.JButton suoritusNappi;
    private javax.swing.JTextField wwwLinkki;
    // End of variables declaration//GEN-END:variables
}
