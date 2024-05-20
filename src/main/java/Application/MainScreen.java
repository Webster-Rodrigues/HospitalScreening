package Application;

import DataEntities.QueuesPriority;
import Entities.Patient;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MainScreen extends javax.swing.JFrame {

    private QueuesPriority qp;

    public MainScreen() {
        initComponents();

        qp = new QueuesPriority();

    }

    public MainScreen(QueuesPriority qp) {
        initComponents();
        this.qp = qp;
        patientLabels();

    }

    private void patientLabels() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        for (Patient patient : qp) {
            JPanel panelPatient = patientsPanel(patient);
            panel.add(panelPatient);
        }
        patientsDashboard.setViewportView(panel);
    }
    
    private JPanel patientsPanel(Patient patient) {
    JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource("/Imagens/PosicaoVerde.png")));
    backgroundLabel.setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();


    gbc.anchor = GridBagConstraints.WEST; 
    gbc.insets = new Insets(0, 0, 0, 0);

    gbc.gridx = 1; 
    gbc.gridy = 0; 
    gbc.insets = new Insets(13, 10, 3, 100); 
    JLabel nameValueLabel = new JLabel(patient.getName());
    backgroundLabel.add(nameValueLabel, gbc);
    
    
    gbc.gridx = 1; 
    gbc.gridy = 1; 
    gbc.insets = new Insets(10, 7, 17, 80); 
    JLabel ageValueLabel = new JLabel(String.valueOf(patient.getAge()));
    backgroundLabel.add(ageValueLabel, gbc);
    
    gbc.gridx = 2; 
    gbc.gridy = 1; 
    gbc.insets = new Insets(5, 20, 10, 0); 
    JLabel gravityValueLabel = new JLabel(String.valueOf(patient.getStatus().toString()));
    backgroundLabel.add(gravityValueLabel, gbc);

       
    gbc.gridx = 2; 
    gbc.gridy = 0; 
    gbc.insets = new Insets(10, 0, 0, 30); 
    JLabel sexLabel = new JLabel(patient.getSex());
    backgroundLabel.add(sexLabel, gbc);


    JPanel patientPanel = new JPanel(new BorderLayout());
    patientPanel.add(backgroundLabel, BorderLayout.CENTER);

    return patientPanel;
}



    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        patientsDashboard = new javax.swing.JScrollPane();
        btnServePatient = new javax.swing.JButton();
        btnScreening = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        BkgroundScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        patientsDashboard.setBackground(new java.awt.Color(247, 252, 255));
        patientsDashboard.setBorder(null);
        getContentPane().add(patientsDashboard, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 110, 405, 460));

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
        getContentPane().add(btnServePatient, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 340, 120, 40));

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

        btnDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDoc.png"))); // NOI18N
        btnDoc.setContentAreaFilled(false);
        btnDoc.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDocMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDocMouseExited(evt);
            }
        });
        btnDoc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDocActionPerformed(evt);
            }
        });
        getContentPane().add(btnDoc, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 420, 120, 40));

        BkgroundScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imgFundo .png"))); // NOI18N
        getContentPane().add(BkgroundScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1140, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnServePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServePatientActionPerformed
        qp.dequeue();
        //patientsDashboard.revalidate();
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
        openScreeningScreen();
        this.dispose();
    }//GEN-LAST:event_btnScreeningActionPerformed

    public void openScreeningScreen() {
        ScreeningScreen sc = new ScreeningScreen(qp);
        sc.setVisible(true);
    }

    private void btnDocMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDocMouseEntered
        btnDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDoc2.png")));
    }//GEN-LAST:event_btnDocMouseEntered

    private void btnDocMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDocMouseExited
        btnDoc.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDoc.png")));
    }//GEN-LAST:event_btnDocMouseExited

    private void btnDocActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDocActionPerformed
        try {
            Desktop.getDesktop().browse(new URI("https://github.com/Andrey-de-Freitas-Souza/Projeto-EDAA/blob/main/FilaPrioridade.pdf"));
        } catch (IOException | URISyntaxException ex) {
            ex.printStackTrace();
        }

    }//GEN-LAST:event_btnDocActionPerformed

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
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnDoc;
    private javax.swing.JButton btnScreening;
    private javax.swing.JButton btnServePatient;
    private javax.swing.JScrollPane patientsDashboard;
    // End of variables declaration//GEN-END:variables
}
