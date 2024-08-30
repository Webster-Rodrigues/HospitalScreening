package Application;

import ConversionTools.Conversions;
import DataEntities.QueueSymptoms;
import DataEntities.QueuesPriority;
import Entities.Patient;
import Entities.Symptoms;
import Entities.enums.SymptomsStatus;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.text.MaskFormatter;
import net.miginfocom.swing.MigLayout;

public class ScreenPatientFile extends javax.swing.JFrame {

    private QueuesPriority qp;
    private Patient patient;
    private boolean isEditing = false;
    private List<JButton> listDeleteButtons = new ArrayList<>();
    private FileInputStream fis; // intancia obj para o fluxo de bytes
    private int photoSize;

    public ScreenPatientFile() {
        formatRGtxt();
        initComponents();

    }

    public ScreenPatientFile(QueuesPriority qp, Patient patient) {
        formatRGtxt();
        initComponents();
        this.patient = patient;
        this.qp = qp;
        symptomLabels(patient);

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
            if (patient.getPhotoPatient() != null) {
                labelPhoto.setIcon(new ImageIcon(patient.getPhotoPatient()));
            }

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

    // Contêiner dos sintomas
    private JPanel createPanelSymptoms(QueueSymptoms qs) {
        JPanel symptomListPanel = new JPanel(new MigLayout("wrap 1, insets 0, gapy 5", "[grow, fill]", "[]"));

        for (Symptoms symptoms : qs) {
            JPanel symptomPanel = new JPanel(new MigLayout("insets 0, gap 0", "[grow][]"));

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
            backgroundLabel.add(statusSymptomsPanel, "cell 0 1, pad 1 63 0 0, growx");

            // Config do botão para deletar sintomas
            JButton btnDeleteSymptoms = new JButton();
            btnDeleteSymptoms.setBorder(null);
            btnDeleteSymptoms.setEnabled(false);
            btnDeleteSymptoms.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    System.out.println("REMOVIDO TESTE");
                    qs.remove(symptoms);
                    //precisa recalcular o score do paciente
                }
            });

            symptomPanel.add(backgroundLabel, "cell 0 0, growx");
            symptomPanel.add(btnDeleteSymptoms, "cell 1 0, align right, pad 6 0 0 0");

            symptomPanel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseExited(MouseEvent evt) {
                    backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconStatusSymptoms(symptoms.getStatus()))));
                }

                @Override
                public void mouseEntered(MouseEvent evt) {
                    backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconSelectedSymptoms(symptoms.getStatus()))));
                }
            });

            listDeleteButtons.add(btnDeleteSymptoms);

            symptomListPanel.add(symptomPanel);
        }
        return symptomListPanel;
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

    public void symptomLabels(Patient patient) {
        symptomsPanel.setLayout(new MigLayout("wrap 1", "[grow]", "[]"));
        symptomsPanel.setOpaque(false);
        symptomsPanel.add(createPanelSymptoms(patient.getListSymptoms()));
        symptomsPanelScroll.getViewport().setOpaque(false);
        symptomsPanelScroll.getViewport().setBorder(null);
        symptomsPanelScroll.setBorder(null);
        symptomsPanelScroll.setOpaque(false);
        symptomsPanelScroll.setViewportView(symptomsPanel);
    }

    //modo de edição
    private void toggleMode() {
        isEditing = !isEditing;
        for (JButton btn : listDeleteButtons) {
            if (isEditing) {
                btn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDelSymptoms.png")));
                btn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
                btn.setBorder(null);
                btn.setContentAreaFilled(false);
                btn.setEnabled(true);
                btn.setVisible(true);
            } else {
                btn.setIcon(null);
                btn.setEnabled(false);
                btn.setVisible(false);

            }

        }
    }

    private void uploadPhoto() {
        //Como o Java independe da plataforma, ele gera o seu próprio explorador de arquivos
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecione a foto de perfil");
        //Filtro de arquivos que podem ser selecionados
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de iamgens(*.PNG, *.JPG, *.JPEG)", "png", "jpg", "jpeg"));
        int userChoice = jfc.showOpenDialog(this);

        if (userChoice == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(jfc.getSelectedFile());
                photoSize = (int) jfc.getSelectedFile().length();
                //Realiza a leitura da imagem selecionada por meio do jfc(explorador de arquivos do Java) e redimensiona a imagem ao tamanho do panel
                Image photo = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(labelPhoto.getWidth(), labelPhoto.getHeight(), Image.SCALE_SMOOTH);
                labelPhoto.setIcon(new ImageIcon(photo));
                labelPhoto.updateUI();
                patient.setPhotoPatient(photo);

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    private void deletePhoto() {
        labelPhoto.setIcon(null);
        labelPhoto.updateUI();
        patient.setPhotoPatient(null);
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
        btnEditSymptoms = new javax.swing.JButton();
        btnDeletePhoto = new javax.swing.JButton();
        btnUploadPhoto = new javax.swing.JButton();
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

        btnEditSymptoms.setBackground(new java.awt.Color(187, 187, 187));
        btnEditSymptoms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iconEditar.png"))); // NOI18N
        btnEditSymptoms.setToolTipText("");
        btnEditSymptoms.setBorder(null);
        btnEditSymptoms.setContentAreaFilled(false);
        btnEditSymptoms.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditSymptoms.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnEditSymptomsMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnEditSymptomsMouseExited(evt);
            }
        });
        btnEditSymptoms.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditSymptomsActionPerformed(evt);
            }
        });
        getContentPane().add(btnEditSymptoms, new org.netbeans.lib.awtextra.AbsoluteConstraints(352, 812, 70, 70));

        btnDeletePhoto.setBorder(null);
        btnDeletePhoto.setContentAreaFilled(false);
        btnDeletePhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnDeletePhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnDeletePhotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnDeletePhotoMouseExited(evt);
            }
        });
        btnDeletePhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDeletePhotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnDeletePhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 317, 45, 43));

        btnUploadPhoto.setBorder(null);
        btnUploadPhoto.setContentAreaFilled(false);
        btnUploadPhoto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnUploadPhoto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnUploadPhotoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnUploadPhotoMouseExited(evt);
            }
        });
        btnUploadPhoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUploadPhotoActionPerformed(evt);
            }
        });
        getContentPane().add(btnUploadPhoto, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 317, 45, 40));

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


    private void btnEditSymptomsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditSymptomsActionPerformed
        toggleMode();
    }//GEN-LAST:event_btnEditSymptomsActionPerformed

    private void btnUploadPhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUploadPhotoActionPerformed
        uploadPhoto();
    }//GEN-LAST:event_btnUploadPhotoActionPerformed

    private void btnUploadPhotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadPhotoMouseEntered
        btnUploadPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addPhotoSelected.png")));
    }//GEN-LAST:event_btnUploadPhotoMouseEntered

    private void btnUploadPhotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUploadPhotoMouseExited
        btnUploadPhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/addPhoto.png")));
    }//GEN-LAST:event_btnUploadPhotoMouseExited

    private void btnDeletePhotoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePhotoMouseEntered
        btnDeletePhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDelPhotoSelected.png")));
    }//GEN-LAST:event_btnDeletePhotoMouseEntered

    private void btnDeletePhotoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeletePhotoMouseExited
        btnDeletePhoto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDelPhoto.png")));
    }//GEN-LAST:event_btnDeletePhotoMouseExited

    private void btnDeletePhotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeletePhotoActionPerformed
        deletePhoto();
    }//GEN-LAST:event_btnDeletePhotoActionPerformed

    private void btnEditSymptomsMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditSymptomsMouseEntered
        btnEditSymptoms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iconEditarClick.png")));
    }//GEN-LAST:event_btnEditSymptomsMouseEntered

    private void btnEditSymptomsMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEditSymptomsMouseExited
        btnEditSymptoms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/iconEditar.png")));
    }//GEN-LAST:event_btnEditSymptomsMouseExited

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
            java.util.logging.Logger.getLogger(ScreenPatientFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreenPatientFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreenPatientFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreenPatientFile.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JButton btnDeletePhoto;
    private javax.swing.JButton btnEditSymptoms;
    private javax.swing.JButton btnReturn;
    private javax.swing.JButton btnUploadPhoto;
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
