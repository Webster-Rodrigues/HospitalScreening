
package Application;

import DataEntities.QueuesPriority;
import DataEntities.QueuesPriorityStatus;
import DataEntities.StackArryList;
import DataEntities.Symptoms;
import Entities.Patient;
import Entities.enums.PriorityStatus;
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

        
        filaSintomas1.push(sm1);//GRAVISSIMO
        filaSintomas1.push(sm7);//GRAVISSIMO
        filaSintomas1.push(sm7);//GRAVISSIMO
        filaSintomas1.push(sm7);//GRAVISSIMO
        
        filaSintomas2.push(sm1);
        filaSintomas2.push(sm4);
        filaSintomas2.push(sm4);
        filaSintomas2.push(sm4);
        
        Patient patient1 = new Patient("André", "Masculino", 50, "12590", "456", Status.EMERGENCIA, PriorityStatus.COMUM, filaSintomas1);
        Patient patient6 = new Patient("Luiza", "Feminino", 20, "25646", "179", Status.EMERGENCIA,  PriorityStatus.IDOSO, filaSintomas);
        Patient patient4 = new Patient("Alice", "Feminino", 20, "25646", "147", Status.EMERGENCIA,  PriorityStatus.GRAVIDA, filaSintomas);
        Patient patient = new Patient("Leo", "Masculino", 20, "1123", "123", Status.URGENTE, PriorityStatus.IDOSO, filaSintomas);
        Patient patient2 = new Patient("Lucas", "Masculino", 29, "12549590", "789", Status.POUCO_URGENTE,  PriorityStatus.COMUM, filaSintomas2);
        Patient patient3 = new Patient("Allan", "Masculino", 29, "12590", "1011", Status.URGENTE,  PriorityStatus.COMUM, filaSintomas);
        Patient patient5 = new Patient("Laura", "Feminino", 20, "1100023", "258", Status.URGENTE,  PriorityStatus.GRAVIDA, filaSintomas1);
        Patient patient8 = new Patient("Jõao", "Masculino", 29, "12549590", "78", Status.POUCO_URGENTE,  PriorityStatus.IDOSO, filaSintomas2);
        Patient patient7 = new Patient("Vitória", "Masculino", 29, "12549590", "78", Status.POUCO_URGENTE,  PriorityStatus.GRAVIDA, filaSintomas2);
        
        
        QueuesPriorityStatus qps = new QueuesPriorityStatus();
        QueuesPriority qp = new QueuesPriority();
        qp.enqueue(patient1);
        qp.enqueue(patient4);
        qp.enqueue(patient6);
        qp.enqueue(patient);
        qp.enqueue(patient3);
        qp.enqueue(patient5);
        qp.enqueue(patient2);
        qp.enqueue(patient7);
        qp.enqueue(patient8);
        
        System.out.println("ANTES QP completa");
        qp.displayQueue();
  
        
        qps.addPatients(qp);
        System.out.println("Print QPS completa");
        qps.displayQueues();
       
        System.out.println("Atendendo o paciente ---Alice---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---Luiza---"); 
        qps.servePatient();
        
        
        System.out.println("Atendendo o paciente ---André---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---Laura---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---Leo---"); 
        qps.servePatient();
        
        
        System.out.println("Atendendo o paciente ---Allan---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---Vitória---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---João está utilizando RG já cadastrado---"); 
        qps.servePatient();
        
        
        System.out.println("Atendendo o paciente ---Lucas---"); 
        //qps.servePatient();
        
        System.out.println("Print QPS completa");
        qps.displayQueues();
        
        System.out.println("QP completa");
        qp.displayQueue();
        
        Patient patient001 = new Patient("Dora", "Feminino", 40, "12549590", "78", Status.POUCO_URGENTE,  PriorityStatus.GRAVIDA, filaSintomas2);
        qp.enqueue(patient001);
        qps.addPatients(qp);
        
        
        System.out.println("Atendendo o paciente ---Dora---"); 
        qps.servePatient();
        
        System.out.println("QP completa");
        qp.displayQueue();
        
        
        qps.addPatients(qp);
        System.out.println("Print QPS completa");
        qps.displayQueues();
        
        /*System.out.println("Print pilha de sintomas");
        filaSintomas.displayStack();
        
        System.out.println("Print pilha de sintomas1");
        filaSintomas1.displayStack();
        
        System.out.println("Print pilha de sintomas2");
        filaSintomas2.displayStack();
        System.out.println();
        
        
        System.out.println("Teste de visualização de lista individual ---Leo---: ");
        patient.displayStackPatient();
        */
        
        System.out.println(filaSintomas.countSymptomsStatus());
        System.out.println(filaSintomas1.countSymptomsStatus());
        System.out.println(filaSintomas2.countSymptomsStatus());
        
        
        System.out.println(filaSintomas.maxSymptomsStatus());
        System.out.println(filaSintomas1.maxSymptomsStatus());
        System.out.println(filaSintomas2.maxSymptomsStatus());
        
        
        System.out.println(filaSintomas.showFrequentSymptom());
        System.out.println(filaSintomas1.showFrequentSymptom());
        System.out.println(filaSintomas2.showFrequentSymptom());        
        
        
    }
    
}
