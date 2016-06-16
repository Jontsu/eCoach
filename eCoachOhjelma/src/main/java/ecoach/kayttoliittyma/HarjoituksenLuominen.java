package ecoach.kayttoliittyma;

import ecoach.logiikka.harjoitus.*;

public class HarjoituksenLuominen extends javax.swing.JFrame {

    private HarjoitusLista kaikkiHarjoitukset;
    private Harjoitus harjoitus;

    public HarjoituksenLuominen(HarjoitusLista kaikkiHarjoitukset) {
        initComponents();

        this.kaikkiHarjoitukset = kaikkiHarjoitukset;
        this.harjoitus = new Harjoitus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        nimiLabel = new javax.swing.JLabel();
        linkkiLabel = new javax.swing.JLabel();
        kuvausLabel = new javax.swing.JLabel();
        kuvausTxtPaneeli = new javax.swing.JScrollPane();
        kuvausTxtArea = new javax.swing.JTextArea();
        harjoituksenNimiTxtField = new javax.swing.JTextField();
        harjoituksenLinkkiTxtField = new javax.swing.JTextField();
        luoHarjoitusNappi = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        nimiLabel.setText("Lisää nimi:");

        linkkiLabel.setText("Lisää linkki:");

        kuvausLabel.setText("Lisää kuvaus:");

        kuvausTxtArea.setColumns(20);
        kuvausTxtArea.setRows(5);
        kuvausTxtPaneeli.setViewportView(kuvausTxtArea);

        harjoituksenNimiTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoituksenNimiTxtFieldActionPerformed(evt);
            }
        });

        harjoituksenLinkkiTxtField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                harjoituksenLinkkiTxtFieldActionPerformed(evt);
            }
        });

        luoHarjoitusNappi.setText("Luo harjoitus");
        luoHarjoitusNappi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                luoHarjoitusNappiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(kuvausTxtPaneeli, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(linkkiLabel)
                            .addComponent(nimiLabel))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(harjoituksenNimiTxtField)
                            .addComponent(harjoituksenLinkkiTxtField)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(kuvausLabel)
                            .addComponent(luoHarjoitusNappi))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(harjoituksenNimiTxtField)
                    .addComponent(nimiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(harjoituksenLinkkiTxtField)
                    .addComponent(linkkiLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(kuvausLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(kuvausTxtPaneeli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(luoHarjoitusNappi)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void harjoituksenNimiTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoituksenNimiTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harjoituksenNimiTxtFieldActionPerformed

    private void harjoituksenLinkkiTxtFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_harjoituksenLinkkiTxtFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_harjoituksenLinkkiTxtFieldActionPerformed

    private void luoHarjoitusNappiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_luoHarjoitusNappiActionPerformed

        this.harjoitus.setNimi(harjoituksenNimiTxtField.getText());
        this.harjoitus.setHarjoitusLinkki(harjoituksenLinkkiTxtField.getText());
        this.harjoitus.setKuvaus(kuvausTxtArea.getText());
        this.kaikkiHarjoitukset.lisaaHarjoitus(this.harjoitus);
        super.dispose();
    }//GEN-LAST:event_luoHarjoitusNappiActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField harjoituksenLinkkiTxtField;
    private javax.swing.JTextField harjoituksenNimiTxtField;
    private javax.swing.JLabel kuvausLabel;
    private javax.swing.JTextArea kuvausTxtArea;
    private javax.swing.JScrollPane kuvausTxtPaneeli;
    private javax.swing.JLabel linkkiLabel;
    private javax.swing.JButton luoHarjoitusNappi;
    private javax.swing.JLabel nimiLabel;
    // End of variables declaration//GEN-END:variables
}
