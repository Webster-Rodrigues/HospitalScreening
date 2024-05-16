package Application;

import ConversionTools.conversions;
import DataEntities.CustomQueue;
import DataEntities.QueueSymptoms;
import DataEntities.QueuesPriority;
import Entities.Symptoms;
import Entities.Patient;
import Entities.Temp;
import Entities.TypePains;
import Entities.enums.SymptomsStatus;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JCheckBox;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class ScreeningScreen extends javax.swing.JFrame {

    public QueuesPriority qp;

    public ScreeningScreen() {

        formatDatetxt();
        formatRGtxt();
        initComponents();

        qp = new QueuesPriority();

        cbxPregnant.setBackground(new Color(0, 0, 0, 0));
        cbxPainLevel.setBackground(new Color(0, 0, 0, 0));
        cbxSex.setBackground(new Color(0, 0, 0, 0));
    }
    
    public ScreeningScreen(QueuesPriority qp) {

        formatDatetxt();
        formatRGtxt();
        initComponents();

        this.qp = qp;

        cbxPregnant.setBackground(new Color(0, 0, 0, 0));
        cbxPainLevel.setBackground(new Color(0, 0, 0, 0));
        cbxSex.setBackground(new Color(0, 0, 0, 0));
    }

    private MaskFormatter formatDatetxt() {
        try {
            MaskFormatter mfdate = new MaskFormatter("##/##/####");
            return mfdate;

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar a data. Tente novamente!");
            return null;
        }
    }

    private MaskFormatter formatRGtxt() {
        try {
            MaskFormatter mfRG = new MaskFormatter("##.###.###-#");
            return mfRG;

        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o RG. Tente novamente!");
            return null;
        }
    }
    
    //revisar
    private void clearUserChoices() {
        txtName.setText("");
        jlTemp.setText("36.6");
        ftxtDate.setValue(null);
        ftxtRG.setValue(null);
        cbxPainLevel.setSelectedItem(null);
        cbxSex.setSelectedItem(null);
        cbxPregnant.setSelectedItem(null);
        boxSevere1.setSelected(false);
        boxSevere2.setSelected(false);
        boxSevere3.setSelected(false);
        boxSevere4.setSelected(false);
        boxSevere5.setSelected(false);
        boxSevere6.setSelected(false);
        boxSevere7.setSelected(false);
        boxSevere8.setSelected(false);
        boxSevere9.setSelected(false);
        boxSevere10.setSelected(false);
        boxSevere11.setSelected(false);

    }

    public QueuesPriority getQueuesPriority() {
        return qp;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        cbxPainLevel = new javax.swing.JComboBox<>();
        cbxPregnant = new javax.swing.JComboBox<String>();
        sldTemp = new javax.swing.JSlider();
        boxSevere2 = new javax.swing.JCheckBox();
        boxSevere3 = new javax.swing.JCheckBox();
        boxSevere4 = new javax.swing.JCheckBox();
        boxSevere1 = new javax.swing.JCheckBox();
        boxSevere5 = new javax.swing.JCheckBox();
        boxSevere6 = new javax.swing.JCheckBox();
        boxSevere7 = new javax.swing.JCheckBox();
        boxSevere8 = new javax.swing.JCheckBox();
        boxSevere9 = new javax.swing.JCheckBox();
        boxSevere10 = new javax.swing.JCheckBox();
        boxSevere11 = new javax.swing.JCheckBox();
        ftxtDate = new javax.swing.JFormattedTextField(formatDatetxt());
        cbxSex = new javax.swing.JComboBox<>();
        btnReturn = new javax.swing.JButton();
        btnRegister = new javax.swing.JButton();
        ftxtRG = new javax.swing.JFormattedTextField(formatRGtxt());
        jlTemp = new javax.swing.JLabel();
        BkgroundScreen = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtName.setBorder(null);
        txtName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNameActionPerformed(evt);
            }
        });
        getContentPane().add(txtName, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 220, 390, 30));

        cbxPainLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sem Dores", "Dores Leves", "Dores Moderadas", "Dores Severas" }));
        cbxPainLevel.setBorder(null);
        cbxPainLevel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbxPainLevelActionPerformed(evt);
            }
        });
        getContentPane().add(cbxPainLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 190, 30));

        cbxPregnant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        cbxPregnant.setBorder(null);
        getContentPane().add(cbxPregnant, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 130, 30));

        sldTemp.setMaximum(455);
        sldTemp.setMinimum(205);
        sldTemp.setValue(365);
        sldTemp.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        sldTemp.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                sldTempStateChanged(evt);
            }
        });
        getContentPane().add(sldTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 350, 130, 20));

        boxSevere2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere2ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere2, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 487, 20, 40));

        boxSevere3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere3ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere3, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 520, 20, 40));

        boxSevere4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere4ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere4, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 550, 20, 40));

        boxSevere1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere1ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 455, 20, 40));

        boxSevere5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere5ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere5, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 580, 20, 40));

        boxSevere6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere6ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere6, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 704, 20, 40));

        boxSevere7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere7ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere7, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 662, 20, 40));

        boxSevere8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere8ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere8, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 456, 20, 40));

        boxSevere9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere9ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 489, 20, 40));

        boxSevere10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere10ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere10, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 522, 20, 40));

        boxSevere11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxSevere11ActionPerformed(evt);
            }
        });
        getContentPane().add(boxSevere11, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 672, 20, 40));

        ftxtDate.setBorder(null);
        ftxtDate.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftxtDateFocusLost(evt);
            }
        });
        ftxtDate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ftxtDateActionPerformed(evt);
            }
        });
        getContentPane().add(ftxtDate, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 218, 120, 30));

        cbxSex.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));
        getContentPane().add(cbxSex, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 310, 150, 30));

        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnVoltar.png"))); // NOI18N
        btnReturn.setContentAreaFilled(false);
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
        getContentPane().add(btnReturn, new org.netbeans.lib.awtextra.AbsoluteConstraints(820, 600, 270, 70));

        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnRegistrar.png"))); // NOI18N
        btnRegister.setContentAreaFilled(false);
        btnRegister.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnRegisterMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnRegisterMouseExited(evt);
            }
        });
        btnRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegisterActionPerformed(evt);
            }
        });
        getContentPane().add(btnRegister, new org.netbeans.lib.awtextra.AbsoluteConstraints(819, 515, 270, -1));

        ftxtRG.setBorder(null);
        ftxtRG.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftxtRGFocusLost(evt);
            }
        });
        getContentPane().add(ftxtRG, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 360, 130, 30));

        jlTemp.setFont(new java.awt.Font("Sitka Subheading", 0, 24)); // NOI18N
        jlTemp.setForeground(new java.awt.Color(0, 0, 0));
        jlTemp.setText(" 36.5");
        jlTemp.setToolTipText("");
        getContentPane().add(jlTemp, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 310, 70, 30));

        BkgroundScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaTriagem.png"))); // NOI18N
        getContentPane().add(BkgroundScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1093, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void boxSevere1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere1ActionPerformed

    }//GEN-LAST:event_boxSevere1ActionPerformed

    public void registerPatient() {
        conversions conversionTools = new conversions();
        Temp temp = new Temp();
        TypePains tps = new TypePains();
        QueueSymptoms listSymptoms1 = new QueueSymptoms();

        String name = txtName.getText();
        String sex = cbxSex.getSelectedItem().toString();
        String date = ftxtDate.getText();
        String userChoice = cbxPregnant.getSelectedItem().toString();
        String RG = ftxtRG.getText();
        double temperature = Double.parseDouble(jlTemp.getText());
        temp.defineSymptom(temperature);
        listSymptoms1.enqueue(temp);

        addCheckBoxs(listSymptoms1);

        String pain = cbxPainLevel.getSelectedItem().toString();
        tps.defineSymptom(pain);
        listSymptoms1.enqueue(tps);

        int age = conversionTools.conversionForAge(date);
        boolean isPregnant = conversionTools.conversionPregnant(userChoice);

        Patient patient = new Patient(name, sex, age, isPregnant, RG, listSymptoms1);
        qp.enqueue(patient);
        qp.priorityPatients();

    }

    public void addCheckBoxs(QueueSymptoms listSymptoms) {
        ArrayList<JCheckBox> checkboxes = new ArrayList<>();
        checkboxes.add(boxSevere1);
        checkboxes.add(boxSevere2);
        checkboxes.add(boxSevere3);
        checkboxes.add(boxSevere4);
        checkboxes.add(boxSevere5);
        checkboxes.add(boxSevere6);
        checkboxes.add(boxSevere7);
        checkboxes.add(boxSevere8);
        checkboxes.add(boxSevere9);
        checkboxes.add(boxSevere10);
        checkboxes.add(boxSevere11);

        CustomQueue<Symptoms> symptomsList = new CustomQueue<>();
        symptomsList.enqueue(new Symptoms("Vias aéreas comprometidas", SymptomsStatus.GRAVISSIMO));
        symptomsList.enqueue(new Symptoms("Respiração ineficaz", SymptomsStatus.GRAVISSIMO));
        symptomsList.enqueue(new Symptoms("Choque", SymptomsStatus.GRAVISSIMO));
        symptomsList.enqueue(new Symptoms("Não responde a estímulos", SymptomsStatus.GRAVISSIMO));
        symptomsList.enqueue(new Symptoms("Convulsão", SymptomsStatus.GRAVISSIMO));
        symptomsList.enqueue(new Symptoms("Pequena hemorragia", SymptomsStatus.NORMAL));
        symptomsList.enqueue(new Symptoms("Náuseas", SymptomsStatus.LEVE));
        symptomsList.enqueue(new Symptoms("Hemorragia incontrolável", SymptomsStatus.GRAVE));
        symptomsList.enqueue(new Symptoms("Alteração do estado de consciência", SymptomsStatus.GRAVE));
        symptomsList.enqueue(new Symptoms("Trauma craniano severo", SymptomsStatus.GRAVE));
        symptomsList.enqueue(new Symptoms("Vômito persistente", SymptomsStatus.NORMAL));

        for (int i = 0; i < checkboxes.size(); i++) {
            JCheckBox checkbox = checkboxes.get(i);
            if (checkbox.isSelected()) {
                Symptoms symptom = symptomsList.get(i);
                listSymptoms.enqueue(symptom);
            }
        }
    }

    private void boxSevere5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere5ActionPerformed

    }//GEN-LAST:event_boxSevere5ActionPerformed

    private void boxSevere6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere6ActionPerformed

    }//GEN-LAST:event_boxSevere6ActionPerformed

    private void boxSevere7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere7ActionPerformed

    }//GEN-LAST:event_boxSevere7ActionPerformed

    private void boxSevere8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere8ActionPerformed

    }//GEN-LAST:event_boxSevere8ActionPerformed

    private void boxSevere9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere9ActionPerformed


    }//GEN-LAST:event_boxSevere9ActionPerformed

    private void boxSevere10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere10ActionPerformed

    }//GEN-LAST:event_boxSevere10ActionPerformed

    private void boxSevere11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere11ActionPerformed
    }//GEN-LAST:event_boxSevere11ActionPerformed

    private void ftxtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtDateActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        registerPatient();
    }//GEN-LAST:event_btnRegisterActionPerformed

    private void btnRegisterMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseEntered
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnRegistrar2.png")));
    }//GEN-LAST:event_btnRegisterMouseEntered

    private void btnReturnMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseEntered
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnVoltar2.png")));
    }//GEN-LAST:event_btnReturnMouseEntered

    private void btnRegisterMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnRegisterMouseExited
        btnRegister.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnRegistrar.png")));
    }//GEN-LAST:event_btnRegisterMouseExited

    private void btnReturnMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnReturnMouseExited
        btnReturn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnVoltar.png")));
    }//GEN-LAST:event_btnReturnMouseExited

    private void ftxtDateFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxtDateFocusLost
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            Date date = sdf.parse(ftxtDate.getText());
            Date currentDate = new Date();

            if (date.after(currentDate)) {
                JOptionPane.showMessageDialog(null, "Data inválida! Por favor, insira uma data atual.");
                ftxtDate.setFocusLostBehavior(JFormattedTextField.PERSIST);
                ftxtDate.setText("");
                ftxtDate.setValue(null);
            } else {
                ftxtDate.setValue(sdf.format(date));
            }

        } catch (ParseException e) {
            ftxtDate.setFocusLostBehavior(JFormattedTextField.PERSIST);
            ftxtDate.setText("");
            ftxtDate.setValue(null);
            JOptionPane.showMessageDialog(null, "Data inválida! Por favor, insira uma data válida.");
        }
    }//GEN-LAST:event_ftxtDateFocusLost

    private void ftxtRGFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftxtRGFocusLost

        try {
            ftxtRG.commitEdit();

        } catch (ParseException e) {
            ftxtRG.setFocusLostBehavior(JFormattedTextField.PERSIST);
            ftxtRG.setText("");
            ftxtRG.setValue(null);
            JOptionPane.showMessageDialog(null, "RG inválido! Por favor, insira um RG válido.");
        }

    }//GEN-LAST:event_ftxtRGFocusLost

    private void boxSevere2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere2ActionPerformed

    }//GEN-LAST:event_boxSevere2ActionPerformed

    private void boxSevere3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere3ActionPerformed

    }//GEN-LAST:event_boxSevere3ActionPerformed

    private void boxSevere4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere4ActionPerformed

    }//GEN-LAST:event_boxSevere4ActionPerformed

    private void btnReturnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReturnActionPerformed
        //qp.displayQueue();
        openMainScreen();
        this.dispose();
    }//GEN-LAST:event_btnReturnActionPerformed

    public void openMainScreen() {
        MainScreen mainScreen = new MainScreen(qp);
        mainScreen.setVisible(true);
    }
    
    
    private void sldTempStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_sldTempStateChanged
        double value = sldTemp.getValue() / 10.0;
        jlTemp.setText(String.valueOf(value));
    }//GEN-LAST:event_sldTempStateChanged

    private void cbxPainLevelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbxPainLevelActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbxPainLevelActionPerformed

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
            java.util.logging.Logger.getLogger(ScreeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ScreeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ScreeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ScreeningScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ScreeningScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BkgroundScreen;
    private javax.swing.JCheckBox boxSevere1;
    private javax.swing.JCheckBox boxSevere10;
    private javax.swing.JCheckBox boxSevere11;
    private javax.swing.JCheckBox boxSevere2;
    private javax.swing.JCheckBox boxSevere3;
    private javax.swing.JCheckBox boxSevere4;
    private javax.swing.JCheckBox boxSevere5;
    private javax.swing.JCheckBox boxSevere6;
    private javax.swing.JCheckBox boxSevere7;
    private javax.swing.JCheckBox boxSevere8;
    private javax.swing.JCheckBox boxSevere9;
    private javax.swing.JButton btnRegister;
    private javax.swing.JButton btnReturn;
    private javax.swing.JComboBox<String> cbxPainLevel;
    private javax.swing.JComboBox<String> cbxPregnant;
    private javax.swing.JComboBox<String> cbxSex;
    private javax.swing.JFormattedTextField ftxtDate;
    private javax.swing.JFormattedTextField ftxtRG;
    private javax.swing.JLabel jlTemp;
    private javax.swing.JSlider sldTemp;
    private javax.swing.JTextField txtName;
    // End of variables declaration//GEN-END:variables
}
