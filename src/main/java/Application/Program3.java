
package Application;

import DataEntities.QueueSymptoms;
import DataEntities.QueuesPriority;
import Entities.Patient;
import Entities.Symptoms;
import Entities.enums.SymptomsStatus;

public class Program3 {
     public static void main(String[] args) {
         
         QueueSymptoms filaSintomas1 = new QueueSymptoms();
        QueueSymptoms filaSintomas2 = new QueueSymptoms();
        QueueSymptoms filaSintomas3 = new QueueSymptoms();
        QueueSymptoms filaSintomas4 = new QueueSymptoms();
        QueueSymptoms filaSintomas5 = new QueueSymptoms();

        Symptoms sm1 = new Symptoms("AVC", SymptomsStatus.GRAVISSIMO);
        Symptoms sm2 = new Symptoms("PERNA QUEBRADA", SymptomsStatus.GRAVISSIMO);
        Symptoms sm3 = new Symptoms("Cólica", SymptomsStatus.GRAVE);
        Symptoms sm4 = new Symptoms("Dengue", SymptomsStatus.GRAVE);
        Symptoms sm5 = new Symptoms("Dor de cabeça", SymptomsStatus.NORMAL);
        Symptoms sm6 = new Symptoms("ASMA", SymptomsStatus.NORMAL);
        Symptoms sm7 = new Symptoms("ÂNSIA", SymptomsStatus.LEVE);
        Symptoms sm8 = new Symptoms("TONTURA", SymptomsStatus.LEVE);
        Symptoms sm9 = new Symptoms("Indisposição", SymptomsStatus.MUITO_LEVE);
        Symptoms sm10 = new Symptoms("DOR MUSCULAR", SymptomsStatus.MUITO_LEVE);

        filaSintomas1.enqueue(sm9);
        filaSintomas1.enqueue(sm10);//MUITO LEVE
        //filaSintomas1.push(sm3);
        //filaSintomas1.push(sm1);

        filaSintomas2.enqueue(sm8);
        filaSintomas2.enqueue(sm7); //LEVE
        //filaSintomas2.push(sm4);
        //filaSintomas2.push(sm4);

        filaSintomas3.enqueue(sm6);
        filaSintomas3.enqueue(sm5);//NORMAL
        //filaSintomas3.push(sm7);
        //filaSintomas3.push(sm4);

        //filaSintomas4.enqueue(tempp);
        filaSintomas4.enqueue(sm3);//GRAVE
        //filaSintomas4.push(sm7);
        filaSintomas4.enqueue(sm4);

        filaSintomas5.enqueue(sm2);
        filaSintomas5.enqueue(sm1);//GRAVISSÍMO
        //filaSintomas5.push(sm7);
        //filaSintomas5.push(sm4);

        Patient patient1 = new Patient("André", "Masculino", 25, false, "456", filaSintomas5);
        Patient patient6 = new Patient("Luiza", "Feminino", 60, false, "179", filaSintomas5);
        Patient patient4 = new Patient("Alice", "Feminino", 20, true, "147", filaSintomas5);
        Patient patient = new Patient("Leo", "Masculino", 60, false, "123", filaSintomas4);
        Patient patient5 = new Patient("Laura", "Feminino", 20, true, "258", filaSintomas4);
        Patient patient2 = new Patient("Lucas", "Masculino", 29, false, "789", filaSintomas4);
        Patient patient3 = new Patient("Allan", "Masculino", 29, false, "1011", filaSintomas1);
        Patient patient8 = new Patient("Jõao", "Masculino", 60, false, "78", filaSintomas1);
        Patient patient7 = new Patient("Vitória", "Feminino", 29, true, "7811", filaSintomas1);

        QueuesPriority qp = new QueuesPriority();
        qp.enqueue(patient);
        qp.enqueue(patient1);
        qp.enqueue(patient2);
        qp.enqueue(patient3);
        qp.enqueue(patient4);
        qp.enqueue(patient5);
        qp.enqueue(patient6);
        qp.enqueue(patient7);
        qp.enqueue(patient8);
        

        System.out.println("Queue normal");
        qp.displayQueue();
        
        System.out.println("Queue ordenada");
        qp.completeOrdination();
        qp.displayQueue();
        qp.dequeue();
        qp.dequeue();
        qp.dequeue();
        
         System.out.println();
         qp.displayQueue();
         
         /* //Contêiner dos sintomas
    private JPanel createPanelSymptoms(Symptoms symptoms) {
        JPanel SymptomPanel = new JPanel(new MigLayout("insets 0, gap 0"));
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

        //Config do botão para deletar sintomas
        JButton btnDeleteSymptoms = new javax.swing.JButton();

        //btnDeleteSymptoms.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/btnDelSymptoms.png"))); setar imagem nele com btn invisível gera bug visual
        btnDeleteSymptoms.setBorder(null);
        btnDeleteSymptoms.setEnabled(false);
        btnDeleteSymptoms.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("REMOVIDO TESTE");
            }
        });

        SymptomPanel.add(backgroundLabel, "cell 0 0, growx");
        SymptomPanel.add(btnDeleteSymptoms, "cell 1 0, pad 6 0 0 0");

        SymptomPanel.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseExited(java.awt.event.MouseEvent evt) {
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconStatusSymptoms(symptoms.getStatus()))));

            }

            @Override
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                backgroundLabel.setIcon(new ImageIcon(getClass().getResource(mapIconSelectedSymptoms(symptoms.getStatus()))));
            }

        });

        listDeleteButtons.add(btnDeleteSymptoms);

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
         
         
         public void symptomLabels(Patient patient) {
        symptomsPanel.setLayout(new MigLayout("wrap 1", "[grow]", "[]"));
        symptomsPanel.setOpaque(false);
        for (Symptoms symptoms : patient.getListSymptoms()) {
            symptomsPanel.add(createPanelSymptoms(symptoms));
        }
        symptomsPanelScroll.getViewport().setOpaque(false);
        symptomsPanelScroll.getViewport().setBorder(null);
        symptomsPanelScroll.setBorder(null);
        symptomsPanelScroll.setOpaque(false);
        symptomsPanelScroll.setViewportView(symptomsPanel);
    }*/
         
         
         
         
         
         
     }
    
}
