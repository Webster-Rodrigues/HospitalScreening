package Application;

import DataEntities.QueuesPriority;
import Entities.Patient;
import Entities.enums.Status;
import java.awt.BorderLayout;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import net.miginfocom.swing.MigLayout;

public class MainScreen extends javax.swing.JFrame {

    private QueuesPriority qp;

    public MainScreen() {
        initComponents();

        qp = new QueuesPriority();
        patientLabels();

    }

    public MainScreen(QueuesPriority qp) {
        initComponents();
        this.qp = qp;
        patientLabels();

    }

    private void patientLabels() {
        panel.setLayout(new MigLayout("wrap 1", "[grow]", "[]"));
        panel.setOpaque(false);
        for (Patient patient : qp) {
            panel.add(createPanelPatients(patient));
        }
        panelPatientsScroll.getViewport().setOpaque(false);
        panelPatientsScroll.getViewport().setBorder(null);
        panelPatientsScroll.setBorder(null);
        panelPatientsScroll.setOpaque(false);
        panelPatientsScroll.setViewportView(panel);
    }

    private JPanel createPanelPatients(Patient patient) {
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource(mapIconStatus(patient.getStatus()))));
        backgroundLabel.setLayout(new MigLayout("insets 0, gap 0"));
        backgroundLabel.setOpaque(false);

        Font font = new Font("Dialog", Font.PLAIN, 12);

        JPanel namePanel = createLabelPanel(patient.getName(), new Dimension(180, 20), font);
        namePanel.setOpaque(false);
        //GUIA: top, left, bottom, right
        backgroundLabel.add(namePanel, "cell 0 0, pad 2 48 0 0, growx, wmax 200");

        JPanel sexPanel = createLabelPanel(patient.getSex(), new Dimension(150, 20), font);
        sexPanel.setOpaque(false);
        backgroundLabel.add(sexPanel, "cell 1 0, pad  2 69 0 0, growx, wmax 150");

        JPanel agePanel = createLabelPanel(String.valueOf(patient.getAge()) + " anos", new Dimension(90, 20), font);
        agePanel.setOpaque(false);
        backgroundLabel.add(agePanel, "cell 0 1, pad 2 46 0 0, growx, wmax 90");

        JPanel gravityPanel = createLabelPanel(patient.getStatus().toString(), new Dimension(200, 20), font);
        gravityPanel.setOpaque(false);
        backgroundLabel.add(gravityPanel, "cell 1 1, pad 2 97 0 0, growx, wmax 250");

        JPanel patientPanel = new JPanel(new BorderLayout());
        patientPanel.add(backgroundLabel, BorderLayout.CENTER);

        patientPanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ScreenPatientFile ms = new ScreenPatientFile(qp, patient.getListSymptoms());
                ms.setVisible(true);
                ms.findPatient(patient);

                closeScreening();
            }

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconStatus(patient.getStatus()))));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource(iconSelectedStatusMap(patient.getStatus()))));
            }
        });

        return patientPanel;
    }

    private JPanel createLabelPanel(String text, Dimension size, Font font) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panel.setOpaque(false); 
        JLabel label = new JLabel(text);
        label.setPreferredSize(size);
        label.setFont(font);
        label.setOpaque(false); 
        label.setBorder(BorderFactory.createEmptyBorder());
        panel.add(label);
        return panel;
    }

    private static final Map<Status, String> mapIconStatus = new HashMap<>();

    static {
        mapIconStatus.put(Status.EMERGENCIA, "/Imagens/EtiquetaVermelha.png");
        mapIconStatus.put(Status.MUITO_URGENTE, "/Imagens/EtiquetaLaranja.png");
        mapIconStatus.put(Status.URGENTE, "/Imagens/EtiquetaAmarelo.png");
        mapIconStatus.put(Status.POUCO_URGENTE, "/Imagens/EtiquetaVerde.png");
        mapIconStatus.put(Status.NAO_URGENTE, "/Imagens/EtiquetaAzul.png");
    }

    public String mapIconStatus(Status status) {
        return mapIconStatus.get(status);
    }
    
    
    private static final Map<Status, String> mapIconSelectedStatus = new HashMap<>();

    static {
        mapIconSelectedStatus.put(Status.EMERGENCIA, "/Imagens/EtiquetaClickVermelha.png");
        mapIconSelectedStatus.put(Status.MUITO_URGENTE, "/Imagens/EtiquetaClickLaranja.png");
        mapIconSelectedStatus.put(Status.URGENTE, "/Imagens/EtiquetaClickAmarelo.png");
        mapIconSelectedStatus.put(Status.POUCO_URGENTE, "/Imagens/EtiquetaClickVerde.png");
        mapIconSelectedStatus.put(Status.NAO_URGENTE, "/Imagens/EtiquetaClickAzul.png");
    }

    public String iconSelectedStatusMap(Status status) {
        return mapIconSelectedStatus.get(status);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelPatientsScroll = new javax.swing.JScrollPane();
        panel = new javax.swing.JPanel();
        btnServePatient = new javax.swing.JButton();
        btnScreening = new javax.swing.JButton();
        btnDoc = new javax.swing.JButton();
        BkgroundScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelPatientsScroll.setBackground(new java.awt.Color(255, 255, 255));
        panelPatientsScroll.setBorder(null);
        panelPatientsScroll.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panelPatientsScroll.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        panel.setBackground(new java.awt.Color(255, 255, 255));
        panelPatientsScroll.setViewportView(panel);

        getContentPane().add(panelPatientsScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 140, 505, 438));

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
        btnDoc.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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

        BkgroundScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/imgFundo.png"))); // NOI18N
        getContentPane().add(BkgroundScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 760));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnServePatientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnServePatientActionPerformed
        qp.dequeue();
        panel.removeAll();
        patientLabels();
        panel.repaint();
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

    public void closeScreening() {
       this.dispose();
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
    private javax.swing.JPanel panel;
    private javax.swing.JScrollPane panelPatientsScroll;
    // End of variables declaration//GEN-END:variables
}
