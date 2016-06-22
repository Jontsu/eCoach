package ecoach.kayttoliittyma;

import ecoach.tiedonkasittely.OhjelmanInstanssi;
import ecoach.logiikka.henkilo.*;

public class SisaanKirjautumissivu extends javax.swing.JFrame {

    Henkilo apuHenkilo;

    public SisaanKirjautumissivu() {
        initComponents();
        OhjelmanInstanssi.getInstance();
        apuHenkilo = null;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        otsikkoLoL = new javax.swing.JLabel();
        nimikeText = new javax.swing.JTextField();
        emailText = new javax.swing.JTextField();
        kirjauduNappi = new javax.swing.JButton();
        uusiKayttajaNappi = new javax.swing.JButton();
        ohjaajaNappi = new javax.swing.JToggleButton();
        pelaajaNappi = new javax.swing.JToggleButton();
        kayttajaLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        otsikkoLoL.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        otsikkoLoL.setForeground(java.awt.Color.black);
        otsikkoLoL.setText("League of Legends Harjoitustyökalu");

        nimikeText.setText("nimike tähän");

        emailText.setText("email tähän");

        kirjauduNappi.setText("Kirjaudu");
        kirjauduNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kirjauduNappiActionPerformed(evt);
            }
        });

        uusiKayttajaNappi.setText("Uusi Käyttäjä");
        uusiKayttajaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uusiKayttajaNappiActionPerformed(evt);
            }
        });

        ohjaajaNappi.setText("Ohjaaja");
        ohjaajaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ohjaajaNappiActionPerformed(evt);
            }
        });

        pelaajaNappi.setText("Pelaaja");
        pelaajaNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pelaajaNappiActionPerformed(evt);
            }
        });

        kayttajaLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        kayttajaLabel.setText("Käyttäjätyyppi:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(nimikeText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 241, Short.MAX_VALUE)
                            .addComponent(emailText, javax.swing.GroupLayout.Alignment.LEADING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ohjaajaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pelaajaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(kayttajaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 8, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(kirjauduNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(uusiKayttajaNappi, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(otsikkoLoL))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(otsikkoLoL)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nimikeText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kayttajaLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ohjaajaNappi)
                    .addComponent(pelaajaNappi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kirjauduNappi)
                    .addComponent(uusiKayttajaNappi))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void kirjauduNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kirjauduNappiActionPerformed

        if (pelaajaNappi.isSelected()) {

            System.out.println(OhjelmanInstanssi.getInstance().getKaikkiPelaajat().onkoPelaajaListassa((Pelaaja) apuHenkilo));

            if (OhjelmanInstanssi.getInstance().getKaikkiPelaajat().onkoPelaajaListassa((Pelaaja) apuHenkilo) == true) {
                new PelaajanPaasivu((Pelaaja) apuHenkilo).setVisible(true);
                super.dispose();
            }

        } else if (ohjaajaNappi.isSelected()) {

            if (OhjelmanInstanssi.getInstance().getOhjaajaLista().onkoOhjaajaListassa((Ohjaaja) apuHenkilo) == true) {
                new OhjaajanPaasivu((Ohjaaja) apuHenkilo).setVisible(true);
                super.dispose();
            }
        }
    }//GEN-LAST:event_kirjauduNappiActionPerformed

    private void uusiKayttajaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uusiKayttajaNappiActionPerformed

        if (pelaajaNappi.isSelected()) {

            if (OhjelmanInstanssi.getInstance().getKaikkiPelaajat().onkoPelaajaListassa((Pelaaja) apuHenkilo) == false) {
                OhjelmanInstanssi.getInstance().getKaikkiPelaajat().lisaaPelaaja((Pelaaja) apuHenkilo);
                OhjelmanInstanssi.getInstance().getPelaajatIlmanOhjaajaa().lisaaPelaaja((Pelaaja) apuHenkilo);

                new PelaajanPaasivu((Pelaaja) apuHenkilo).setVisible(true);
                super.dispose();
            }

        } else if (ohjaajaNappi.isSelected()) {

            if (OhjelmanInstanssi.getInstance().getOhjaajaLista().onkoOhjaajaListassa((Ohjaaja) apuHenkilo) == false) {
                OhjelmanInstanssi.getInstance().getOhjaajaLista().lisaaOhjaaja((Ohjaaja) apuHenkilo);

                new OhjaajanPaasivu((Ohjaaja) apuHenkilo).setVisible(true);
                super.dispose();
            }
        }
    }//GEN-LAST:event_uusiKayttajaNappiActionPerformed

    private void ohjaajaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ohjaajaNappiActionPerformed

        apuHenkilo = new Ohjaaja(nimikeText.getText(), emailText.getText());
        OhjelmanInstanssi.getInstance().getOhjaajaLista().getOhjaajaListasta((Ohjaaja) apuHenkilo);
        ohjaajaNappi.setSelected(true);
        pelaajaNappi.setSelected(false);
    }//GEN-LAST:event_ohjaajaNappiActionPerformed

    private void pelaajaNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pelaajaNappiActionPerformed

        apuHenkilo = new Pelaaja(nimikeText.getText(), emailText.getText());
        OhjelmanInstanssi.getInstance().getKaikkiPelaajat().getPelaajaListasta((Pelaaja) apuHenkilo);
        pelaajaNappi.setSelected(true);
        ohjaajaNappi.setSelected(false);
    }//GEN-LAST:event_pelaajaNappiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField emailText;
    private javax.swing.JLabel kayttajaLabel;
    private javax.swing.JButton kirjauduNappi;
    private javax.swing.JTextField nimikeText;
    private javax.swing.JToggleButton ohjaajaNappi;
    private javax.swing.JLabel otsikkoLoL;
    private javax.swing.JToggleButton pelaajaNappi;
    private javax.swing.JButton uusiKayttajaNappi;
    // End of variables declaration//GEN-END:variables
}
