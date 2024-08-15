package Application;

import ConversionTools.Conversions;
import DataEntities.QueueSymptoms;
import DataEntities.QueuesPriority;
import Entities.Patient;
import Entities.Symptoms;
import Entities.enums.SymptomsStatus;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;
import net.miginfocom.swing.MigLayout;

public class ScreenPatientFile extends javax.swing.JFrame {

    private QueuesPriority qp;
    private QueueSymptoms qs;

    public ScreenPatientFile() {
        formatRGtxt();
        initComponents();
        symptomLabels(qs);
        
    } 

    public ScreenPatientFile(QueuesPriority qp, QueueSymptoms qs) {
        formatRGtxt();
        initComponents();
        this.qs = qs;
        this.qp = qp;
        symptomLabels(qs);
        
    }

    public void findPatient(Patient patient) {
        if (patient != null) {
            Conversions conversionTools = new Conversions();
            labelName.setText(patient.getName());
            labelRG.setText(patient.getRG());
            labelPregnant.setText(conversionTools.conversionBoolean(patient.IsPregnant()));
            labelPriorityStatus.setText(patient.getPriorityStatus().toString());
            labelStatus.setText(patient.getStatus().toString());
            labelSex.setText(patient.getSex());
            labelAge.setText(String.valueOf(patient.getAge()));

        } else {
            JOptionPane.showMessageDialog(null, "Esse paciente não existe!!");
        }
    }

    private MaskFormatter formatRGtxt() {
        try {
            MaskFormatter mfRG = new MaskFormatter("##.###.###-#");
            return mfRG;

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Insira um RG válido!!");
            return null;
        }
    }

    private JPanel createPanelSymptoms(Symptoms symptoms) {
        JLabel backgroundLabel = new JLabel(new ImageIcon(getClass().getResource(mapIconStatusSymptoms(symptoms.getStatus()))));
        backgroundLabel.setLayout(new MigLayout("insets 0, gap 0"));
        backgroundLabel.setOpaque(false);

        Font font = new Font("Dialog", Font.PLAIN, 11);

        JPanel nameSymptomsPanel = createSymptomLabelPanel(symptoms.getNameSymptoms(), new Dimension(300, 20), font);
        nameSymptomsPanel.setOpaque(false);
        //GUIA: top, left, bottom, right
        backgroundLabel.add(nameSymptomsPanel, "cell 0 0, pad 1 100 0 0, growx");

        JPanel statusSymptomsPanel = createSymptomLabelPanel(symptoms.getStatus().toString(), new Dimension(150, 20), font);
        statusSymptomsPanel.setOpaque(false);
        backgroundLabel.add(statusSymptomsPanel, "cell 0 1, pad  1 63 0 0, growx");

        JPanel SymptomPanel = new JPanel(new BorderLayout());
        SymptomPanel.add(backgroundLabel, BorderLayout.CENTER);

        /*SymptomPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconStatusSymptoms(symptoms.getStatus()))));
            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconSelectedSymptoms(symptoms.getStatus()))));
            }
        });
*/
        return SymptomPanel;
    }

    private JPanel createSymptomLabelPanel(String text, Dimension size, Font font) {
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

    private static final Map<SymptomsStatus, String> mapIconSymptoms = new HashMap<>();

    static {
        mapIconSymptoms.put(SymptomsStatus.GRAVISSIMO, "/Imagens/EtiquetaSintomasVermelha.png");
        mapIconSymptoms.put(SymptomsStatus.GRAVE, "/Imagens/EtiquetaSintomasLaranja.png");
        mapIconSymptoms.put(SymptomsStatus.NORMAL, "/Imagens/EtiquetaSintomasAmarelo.png");
        mapIconSymptoms.put(SymptomsStatus.LEVE, "/Imagens/EtiquetaSintomasVerde.png");
        mapIconSymptoms.put(SymptomsStatus.MUITO_LEVE, "/Imagens/EtiquetaSintomasAzul.png");
    }

    public String mapIconStatusSymptoms(SymptomsStatus status) {
        return mapIconSymptoms.get(status);
    }

    private static final Map<SymptomsStatus, String> mapIconSymptomsSelected = new HashMap<>();

    static {
        mapIconSymptomsSelected.put(SymptomsStatus.GRAVISSIMO, "/Imagens/EtiquetaSintomasClickVermelha.png");
        mapIconSymptomsSelected.put(SymptomsStatus.GRAVE, "/Imagens/EtiquetaSintomasClickLaranja.png");
        mapIconSymptomsSelected.put(SymptomsStatus.NORMAL, "/Imagens/EtiquetaSintomasClickAmarelo.png");
        mapIconSymptomsSelected.put(SymptomsStatus.LEVE, "/Imagens/EtiquetaSintomasClickVerde.png");
        mapIconSymptomsSelected.put(SymptomsStatus.MUITO_LEVE, "/Imagens/EtiquetaSintomasClickAzul.png");
    }

    public String mapIconSelectedSymptoms(SymptomsStatus status) {
        return mapIconSymptomsSelected.get(status);
    }

    public void symptomLabels(QueueSymptoms qs) {
        symptomsPanel.setLayout(new MigLayout("wrap 1", "[grow]", "[]"));
        symptomsPanel.setOpaque(false);
        for (Symptoms symptoms : qs) {
            symptomsPanel.add(createPanelSymptoms(symptoms));
        }
        symptomsPanelScroll.getViewport().setOpaque(false);
        symptomsPanelScroll.getViewport().setBorder(null);
        symptomsPanelScroll.setBorder(null);
        symptomsPanelScroll.setOpaque(false);
        symptomsPanelScroll.setViewportView(symptomsPanel);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        symptomsPanelScroll = new javax.swing.JScrollPane();
        symptomsPanel = new javax.swing.JPanel();
        labelName = new javax.swing.JLabel();
        labelSex = new javax.swing.JLabel();
        labelPregnant = new javax.swing.JLabel();
        labelAge = new javax.swing.JLabel();
        labelPriorityStatus = new javax.swing.JLabel();
        labelStatus = new javax.swing.JLabel();
        labelRG = new javax.swing.JLabel();
        btnReturn = new javax.swing.JButton();
        labelPhoto = new javax.swing.JLabel();
        BkgroundScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        symptomsPanelScroll.setBackground(new java.awt.Color(255, 255, 255));
        symptomsPanelScroll.setBorder(null);
        symptomsPanelScroll.setViewportBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        symptomsPanel.setBackground(new java.awt.Color(255, 255, 255));
        symptomsPanelScroll.setViewportView(symptomsPanel);

        getContentPane().add(symptomsPanelScroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 450, 370, 330));

        labelName.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelName, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 134, 300, 30));

        labelSex.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 228, 110, 30));

        labelPregnant.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelPregnant, new org.netbeans.lib.awtextra.AbsoluteConstraints(605, 228, 70, 30));

        labelAge.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelAge, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 133, 90, 30));

        labelPriorityStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelPriorityStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 228, 130, 30));

        labelStatus.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelStatus, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 322, 200, 30));

        labelRG.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        getContentPane().add(labelRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 322, 170, 30));

        btnReturn.setBorder(null);
        btnReturn.setContentAreaFilled(false);
        btnReturn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnReturn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnReturnMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnReturnMouseExited(evt);
            }
        });
        btnReturn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReturnActionPerformed(evt);
            }
        });
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(802, 22, 135, 40));
        getContentPane().add(labelPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 133, 190, 150));

        BkgroundScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/ScreenPatientFile_Inicial.png"))); // NOI18N
        getContentPane().add(BkgroundScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 950, 920));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        openMainScreen();
        this.dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

    private void btnReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseEntered
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnVoltarMenorSelecionado.png")));
    }//GEN-LAST:event_btnReturnMouseEntered

    private void btnReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseExited
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnVoltarMenor.png")));
    }//GEN-LAST:event_btnReturnMouseExited

    public void openMainScreen() {
        MainScreen mainScreen = new MainScreen(qp);
        mainScreen.setVisible(true);
    }

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ScreenPatientFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenPatientFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenPatientFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenPatientFile.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreenPatientFile().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BkgroundScreen;
    private javax.swing.JButton btnReturn;
    private javax.swing.JLabel labelAge;
    private javax.swing.JLabel labelName;
    private javax.swing.JLabel labelPhoto;
    private javax.swing.JLabel labelPregnant;
    private javax.swing.JLabel labelPriorityStatus;
    private javax.swing.JLabel labelRG;
    private javax.swing.JLabel labelSex;
    private javax.swing.JLabel labelStatus;
    private javax.swing.JPanel symptomsPanel;
    private javax.swing.JScrollPane symptomsPanelScroll;
    // End of variables declaration//GEN-END:variables
}
