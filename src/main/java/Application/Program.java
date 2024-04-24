
package Application;

import DataEntities.QueuesPriority;
import DataEntities.StackArryList;
import DataEntities.Symptoms;
import Entities.Patient;
import Entities.enums.Status;
import Entities.enums.SymptomsStatus;

public class Program {
    public static void main(String[] args) {
        
        StackArryList filaSintomas = new StackArryList();
        StackArryList filaSintomas1 = new StackArryList();
        StackArryList filaSintomas2 = new StackArryList();
        
        Symptoms sm = new Symptoms("Cólica", SymptomsStatus.GRAVE);
        Symptoms sm1 = new Symptoms("AVC", SymptomsStatus.GRAVISSIMO);
        Symptoms sm2 = new Symptoms("Dor de cabeça", SymptomsStatus.NORMAL);
        Symptoms sm3 = new Symptoms("Indisposição", SymptomsStatus.MUITO_LEVE);
        Symptoms sm4 = new Symptoms("Dengue", SymptomsStatus.GRAVE);
        Symptoms sm5 = new Symptoms("ÂNSIA", SymptomsStatus.LEVE);
        Symptoms sm6 = new Symptoms("ASMA", SymptomsStatus.NORMAL);
        Symptoms sm7 = new Symptoms("PERNA QUEBRADA", SymptomsStatus.GRAVISSIMO);
        
        filaSintomas.push(sm1);//GRAVISSIMO
        filaSintomas.push(sm2);//NORMAL
        filaSintomas.push(sm7);//GRAVISSIMO
        filaSintomas.push(sm4);//GRAVE
        Patient patient = new Patient("Leo", "Masculino", 20, "1123", "4156165", Status.URGENTE, filaSintomas);
        
        filaSintomas1.push(sm1);//GRAVISSIMO
        filaSintomas1.push(sm7);//GRAVISSIMO
        filaSintomas1.push(sm7);//GRAVISSIMO
        filaSintomas1.push(sm7);//GRAVISSIMO
        Patient patient1 = new Patient("André", "Masculino", 50, "12590", "541691", Status.EMERGENCIA, filaSintomas1);
        
        filaSintomas2.push(sm1);
        filaSintomas2.push(sm4);
        filaSintomas2.push(sm4);
        filaSintomas2.push(sm4);
        Patient patient2 = new Patient("Lucas", "Masculino", 29, "12549590", "5491", Status.POUCO_URGENTE, filaSintomas2);
        
        Patient patient3 = new Patient("Allan", "Masculino", 29, "12549590", "5111491", Status.URGENTE, filaSintomas2);
   
        Patient patient4 = new Patient("Alice", "Feminino", 20, "1123", "4165", Status.EMERGENCIA, filaSintomas);
        
        
        
        
        
        QueuesPriority qp = new QueuesPriority();
        qp.addPatient(patient);
        qp.addPatient(patient1);
        qp.addPatient(patient2);
        qp.addPatient(patient3);
        qp.addPatient(patient4);
        
        
        System.out.println("Print da lista completa");
        qp.displayQueues();
        
        
        System.out.println("Atendendo o paciente ---André---"); 
        qp.servePatient();
        
        
        System.out.println("Print da lista completa");
        qp.displayQueues();
        
        System.out.println("Atendendo o paciente ---Alice---"); 
        qp.servePatient();
        
        
        System.out.println("Atendendo o paciente ---Leo---"); 
        qp.servePatient();
        
        
        System.out.println("Atendendo o paciente ---Allan---"); 
        qp.servePatient();
        
        
        System.out.println("Atendendo o paciente ---Lucas---"); 
        qp.servePatient();
        
        System.out.println("Print da lista completa");
        qp.displayQueues();
        
        System.out.println("Print pilha de sintomas");
        filaSintomas.displayStack();
        
        System.out.println("Print pilha de sintomas1");
        filaSintomas1.displayStack();
        
        System.out.println("Print pilha de sintomas2");
        filaSintomas2.displayStack();
        System.out.println();
        
        
        System.out.println("Teste de visualização de lista individual ---Leo---: ");
        patient.displayStackPatient();
        
        
        System.out.println(filaSintomas.countSymptomsStatus());
        System.out.println(filaSintomas1.countSymptomsStatus());
        
        
        System.out.println(filaSintomas.maxSymptomsStatus());
        System.out.println(filaSintomas1.maxSymptomsStatus());
        System.out.println(filaSintomas2.maxSymptomsStatus());
        
        
        System.out.println(filaSintomas.setStatusPatient());
        System.out.println(filaSintomas1.setStatusPatient());
        System.out.println(filaSintomas2.setStatusPatient());
       
        StackArryList filaSintomasss = new StackArryList();
        System.out.println(filaSintomasss.setStatusPatient());
        
        
        
        
               
        
        
    }
    
}
