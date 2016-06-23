package ecoach.kayttoliittyma;

import ecoach.tiedonkasittely.OhjelmanInstanssi;
import ecoach.logiikka.henkilo.*;

/**
 * Pelaajan käyttöliittymä johon päädytään sisäänkirjautumis
 * käyttöliittymäsivulta.
 *
 * @author Jontsu
 */
public class PelaajanPaasivu extends javax.swing.JFrame {

    private Pelaaja pelaaja;
    private int valitunHarjoituksenIndeksi;

    public PelaajanPaasivu(Pelaaja pelaaja) {

        initComponents();
        this.pelaaja = pelaaja;
        this.valitunHarjoituksenIndeksi = 0;
        harjoituksenLinkkiTxt.setEditable(false);
        harjoituksenKuvaus.setEditable(false);
        arvosanaTxt.setEditable(false);
        keskiarvoTxt.setEditable(false);
        keskiarvoTxt.setText("" + OhjelmanInstanssi.getInstance().getSuoritusTilasto().tilastonKeskiarvo());

        if (this.pelaaja.getHarjoitusLista() != null) {
            System.out.println("totta");
            if (pelaaja.getHarjoitusLista().getHarjoitusLista().size() > 0) {

                for (int i = 0; i < pelaaja.getHarjoitusLista().getHarjoitusLista().size(); i++) {
                    harjoitusValikkoCBox.addItem(pelaaja.getHarjoitusLista().getHarjoitusLista().get(i).getNimi());
                }

                harjoitusValikkoCBox.setSelectedIndex(valitunHarjoituksenIndeksi);

                this.tarkistaSuoritusStatus();
            }
        }
    }

    private void tarkistaSuoritusStatus() {

        if (pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getSuoritus().suoritusStatus() == true) {
            suoritusNappi.setEnabled(false);
            linkkiLabel.setText(pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getSuoritus().getSuoritusLinkki());
            linkkiLabel.setEditable(false);

            if (pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getSuoritus().getArvosana() != -1) {
                arvosanaTxt.setText("" + pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getSuoritus().getArvosana());
            }

        } else {
            suoritusNappi.setEnabled(true);
            linkkiLabel.setText("Lisää tähän suoritus nauhoituksen linkki");
            linkkiLabel.setEditable(true);
        }
    }

    private void paivitaHarjoituksenTiedot() {

        harjoituksenKuvaus.setText(pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getKuvaus());
        harjoituksenLinkkiTxt.setText(pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getLinkki());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        harjoitusValikkoCBox = new javax.swing.JComboBox<>();
        linkkiLabel = new javax.swing.JTextField();
        kuvauksenPaneeli = new javax.swing.JScrollPane();
        harjoituksenKuvaus = new javax.swing.JTextArea();
        harjoitusValikkoCBnOtsikko = new javax.swing.JLabel();
        otsikkoLoL = new javax.swing.JLabel();
        suoritusNappi = new javax.swing.JButton();
        keskiarvoLabel = new javax.swing.JLabel();
        arvosanaLabel = new javax.swing.JLabel();
        arvosanaTxt = new javax.swing.JTextField();
        keskiarvoTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        harjoituksenLinkkiLbl = new javax.swing.JLabel();
        harjoituksenLinkkiTxt = new javax.swing.JTextField();

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

        harjoitusValikkoCBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoitusValikkoCBoxActionPerformed(evt);
            }
        });

        linkkiLabel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                linkkiLabelActionPerformed(evt);
            }
        });

        harjoituksenKuvaus.setColumns(20);
        harjoituksenKuvaus.setRows(5);
        kuvauksenPaneeli.setViewportView(harjoituksenKuvaus);

        harjoitusValikkoCBnOtsikko.setText("Avoimet harjoitukset:");

        otsikkoLoL.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
        otsikkoLoL.setForeground(java.awt.Color.black);
        otsikkoLoL.setText("League of Legends Harjoitustyökalu");

        suoritusNappi.setText("Merkitse Suoritetuksi");
        suoritusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                suoritusNappiActionPerformed(evt);
            }
        });

        keskiarvoLabel.setText("Pelaajien kaikkien harjoitusten suoritusten keskiarvo:");

        arvosanaLabel.setText("Arvosana:");

        arvosanaTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                arvosanaTxtActionPerformed(evt);
            }
        });

        jLabel1.setText("Suorituksen nauhoituksen linkki:");

        harjoituksenLinkkiLbl.setText("Harjoituksen linkki:");

        harjoituksenLinkkiTxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoituksenLinkkiTxtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(otsikkoLoL, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(kuvauksenPaneeli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(linkkiLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(suoritusNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 379, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(harjoitusValikkoCBnOtsikko, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(4, 4, 4))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(harjoituksenLinkkiLbl)
                                .addGap(49, 49, 49)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(harjoitusValikkoCBox, 0, 423, Short.MAX_VALUE)
                            .addComponent(harjoituksenLinkkiTxt)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(arvosanaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(arvosanaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(keskiarvoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(keskiarvoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(otsikkoLoL, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harjoitusValikkoCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(harjoitusValikkoCBnOtsikko, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(harjoituksenLinkkiLbl)
                    .addComponent(harjoituksenLinkkiTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kuvauksenPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(arvosanaLabel)
                    .addComponent(arvosanaTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(keskiarvoLabel)
                    .addComponent(keskiarvoTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(linkkiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 35, Short.MAX_VALUE)
                    .addComponent(suoritusNappi, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void harjoitusValikkoCBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoitusValikkoCBoxActionPerformed

        valitunHarjoituksenIndeksi = harjoitusValikkoCBox.getSelectedIndex();
        this.tarkistaSuoritusStatus();
        this.paivitaHarjoituksenTiedot();
    }//GEN-LAST:event_harjoitusValikkoCBoxActionPerformed

    private void suoritusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_suoritusNappiActionPerformed

        if (this.pelaaja.getHarjoitusLista() != null) {

            if (evt.getSource() == suoritusNappi) {
                pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getSuoritus().muutaSuoritusStatus();
                pelaaja.getHarjoitusLista().getHarjoitusLista().get(valitunHarjoituksenIndeksi).getSuoritus().setSuoritusLinkki(linkkiLabel.getText());
                this.tarkistaSuoritusStatus();
            }
        }
    }//GEN-LAST:event_suoritusNappiActionPerformed

    private void linkkiLabelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_linkkiLabelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_linkkiLabelActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        OhjelmanInstanssi.getInstance().tallennaOhjelma();
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        OhjelmanInstanssi.getInstance().tallennaOhjelma();
    }//GEN-LAST:event_formWindowClosing

    private void arvosanaTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_arvosanaTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_arvosanaTxtActionPerformed

    private void harjoituksenLinkkiTxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoituksenLinkkiTxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harjoituksenLinkkiTxtActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel arvosanaLabel;
    private javax.swing.JTextField arvosanaTxt;
    private javax.swing.JTextArea harjoituksenKuvaus;
    private javax.swing.JLabel harjoituksenLinkkiLbl;
    private javax.swing.JTextField harjoituksenLinkkiTxt;
    private javax.swing.JLabel harjoitusValikkoCBnOtsikko;
    private javax.swing.JComboBox<String> harjoitusValikkoCBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel keskiarvoLabel;
    private javax.swing.JTextField keskiarvoTxt;
    private javax.swing.JScrollPane kuvauksenPaneeli;
    private javax.swing.JTextField linkkiLabel;
    private javax.swing.JLabel otsikkoLoL;
    private javax.swing.JButton suoritusNappi;
    // End of variables declaration//GEN-END:variables
}
