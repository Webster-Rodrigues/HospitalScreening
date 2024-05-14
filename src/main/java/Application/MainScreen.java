
package Application;


public class MainScreen extends javax.swing.JFrame {

    public MainScreen() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scpPatientDashboard = new javax.swing.JScrollPane();
        btnServePatient = new javax.swing.JButton();
        btnScreening = new javax.swing.JButton();
        BkgroundScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(scpPatientDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 130, 390, 450));

        btnServePatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnChamar.png"))); // NOI18N
        btnServePatient.setContentAreaFilled(false);
        btnServePatient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnServePatient.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnServePatientMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnServePatientMouseExited(evt);
            }
        });
        btnServePatient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnServePatientActionPerformed(evt);
            }
        });
        getContentPane().add(btnServePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 120, 30));

        btnScreening.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnTriagem.png"))); // NOI18N
        btnScreening.setContentAreaFilled(false);
        btnScreening.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnScreening.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnScreeningMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnScreeningMouseExited(evt);
            }
        });
        btnScreening.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScreeningActionPerformed(evt);
            }
        });
        getContentPane().add(btnScreening, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 380, 120, 40));

        BkgroundScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imgFundo.png"))); // NOI18N
        getContentPane().add(BkgroundScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnServePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServePatientActionPerformed
        
    }//GEN-LAST:event_btnServePatientActionPerformed

    private void btnServePatientMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServePatientMouseEntered
        btnServePatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnChamar2.png")));
    }//GEN-LAST:event_btnServePatientMouseEntered

    private void btnServePatientMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnServePatientMouseExited
        btnServePatient.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnChamar.png")));
    }//GEN-LAST:event_btnServePatientMouseExited

    private void btnScreeningMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScreeningMouseEntered
        btnScreening.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnTriagem2.png")));
    }//GEN-LAST:event_btnScreeningMouseEntered

    private void btnScreeningMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnScreeningMouseExited
        btnScreening.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnTriagem.png")));
    }//GEN-LAST:event_btnScreeningMouseExited

    private void btnScreeningActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScreeningActionPerformed
        new ScreeningScreen().setVisible(true);
    }//GEN-LAST:event_btnScreeningActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BkgroundScreen;
    private javax.swing.JButton btnScreening;
    private javax.swing.JButton btnServePatient;
    private javax.swing.JScrollPane scpPatientDashboard;
    // End of variables declaration//GEN-END:variables
}
