package Application;

import DataEntities.QueueSymptoms;
import DataEntities.Symptoms;
import Entities.enums.SymptomsStatus;
import java.awt.Color;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JFormattedTextField;
import javax.swing.JOptionPane;
import javax.swing.text.MaskFormatter;

public class ScreeningScreen extends javax.swing.JFrame {

    private QueueSymptoms listSymptoms;

    public ScreeningScreen() {
        formatDatetxt();
        formatRGtxt();
        initComponents();

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

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtName = new javax.swing.JTextField();
        cbxPainLevel = new javax.swing.JComboBox<>();
        cbxPregnant = new javax.swing.JComboBox<String>();
        txtTemperature = new javax.swing.JTextField();
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
        BkgroundScreen = new javax.swing.JLabel();
        jScrollBar1 = new javax.swing.JScrollBar();

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
        getContentPane().add(cbxPainLevel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 310, 190, 30));

        cbxPregnant.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Sim", "Não" }));
        cbxPregnant.setBorder(null);
        getContentPane().add(cbxPregnant, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 310, 130, 30));

        txtTemperature.setBorder(null);
        getContentPane().add(txtTemperature, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 310, 140, 30));
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

        BkgroundScreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/TelaTriagem.png"))); // NOI18N
        getContentPane().add(BkgroundScreen, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 6, 1093, -1));
        getContentPane().add(jScrollBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, -1, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txtNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNameActionPerformed

    private void boxSevere1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere1ActionPerformed
        Symptoms sympt = new Symptoms("Convulsão", SymptomsStatus.GRAVISSIMO);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere1ActionPerformed

    private void boxSevere5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere5ActionPerformed
        Symptoms sympt = new Symptoms("", SymptomsStatus.GRAVISSIMO);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere5ActionPerformed

    private void boxSevere6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere6ActionPerformed
        Symptoms sympt = new Symptoms("Vômito persistente", SymptomsStatus.NORMAL);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere6ActionPerformed

    private void boxSevere7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere7ActionPerformed
        Symptoms sympt = new Symptoms("Náuseas", SymptomsStatus.LEVE);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere7ActionPerformed

    private void boxSevere8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere8ActionPerformed
        Symptoms sympt = new Symptoms("Hemorragia incontrolável", SymptomsStatus.GRAVE);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere8ActionPerformed

    private void boxSevere9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere9ActionPerformed
        Symptoms sympt = new Symptoms("Alteração do estado de consciência", SymptomsStatus.GRAVE);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere9ActionPerformed

    private void boxSevere10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere10ActionPerformed
        Symptoms sympt = new Symptoms("Trauma craniano severo", SymptomsStatus.GRAVE);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere10ActionPerformed

    private void boxSevere11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere11ActionPerformed
        Symptoms sympt = new Symptoms("Pequena hemorragia", SymptomsStatus.NORMAL);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere11ActionPerformed

    private void ftxtDateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ftxtDateActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ftxtDateActionPerformed

    private void btnRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegisterActionPerformed
        String name = txtName.getText();
        String sex = cbxSex.getSelectedItem().toString();
        String date = ftxtDate.getText();
        String isPregnant = cbxPregnant.getSelectedItem().toString();
        String RG = ftxtRG.getText();

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
        Symptoms sympt = new Symptoms("Respiração ineficaz", SymptomsStatus.GRAVISSIMO);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere2ActionPerformed

    private void boxSevere3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere3ActionPerformed
        Symptoms sympt = new Symptoms("Choque", SymptomsStatus.GRAVISSIMO);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere3ActionPerformed

    private void boxSevere4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxSevere4ActionPerformed
        Symptoms sympt = new Symptoms("Não responde a estímulos", SymptomsStatus.GRAVISSIMO);
        listSymptoms.enqueue(sympt);
    }//GEN-LAST:event_boxSevere4ActionPerformed

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
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JSlider sldTemp;
    private javax.swing.JTextField txtName;
    private javax.swing.JTextField txtTemperature;
    // End of variables declaration//GEN-END:variables
}
