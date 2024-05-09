
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
        
        filaSintomas.push(sm1);//EMERGENTE
        filaSintomas.push(sm2);
        filaSintomas.push(sm7);
        filaSintomas.push(sm4);

        
        filaSintomas1.push(sm3);//URGENTE
        filaSintomas1.push(sm4);
        //filaSintomas1.push(sm7);
        //filaSintomas1.push(sm7);
        
        filaSintomas2.push(sm9);
        filaSintomas2.push(sm10);//POUCO URGENTE
        //filaSintomas2.push(sm4);
        //filaSintomas2.push(sm4);
        
        Patient patient1 = new Patient("André", "Masculino", 25,false,"456", filaSintomas);
        Patient patient6 = new Patient("Luiza", "Feminino", 60,false,"179",filaSintomas);
        Patient patient4 = new Patient("Alice", "Feminino", 20, true,"147",filaSintomas);
        Patient patient = new Patient("Leo", "Masculino", 60, false,"123",filaSintomas1);
        Patient patient5 = new Patient("Laura", "Feminino", 20,true,"258",filaSintomas1);
        Patient patient2 = new Patient("Lucas", "Masculino", 29,false,"789",filaSintomas1);
        Patient patient3 = new Patient("Allan", "Masculino", 29,false,"1011",filaSintomas2);
        Patient patient8 = new Patient("Jõao", "Masculino", 60,false,"78",filaSintomas2);
        Patient patient7 = new Patient("Vitória", "Feminino", 29,true,"7811",filaSintomas2);
        
        
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
        
        //qp.bucketSort(qp);
        //System.out.println("ORDENADA QP completa");
        //qp.displayQueue();
        
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
        
        
        System.out.println("Atendendo o paciente ---Lucas---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---Vitória---"); 
        qps.servePatient();
        
        System.out.println("Atendendo o paciente ---João---"); 
        qps.servePatient();
        
        
        System.out.println("Atendendo o paciente ---Allan---"); 
        qps.servePatient();
        
        System.out.println("Print QPS completa");
        qps.displayQueues();
        
        System.out.println("QP completa");
        qp.displayQueue();
        
        Patient patient001 = new Patient("Dora", "Feminino", 40,"783", Status.POUCO_URGENTE,  PriorityStatus.GRAVIDA, filaSintomas2);
        qp.enqueue(patient001);
        qps.addPatients(qp);
        
        
        System.out.println("Atendendo o paciente ---Dora---"); 
        qps.servePatient();
        
        System.out.println("QP completa");
        qp.displayQueue();
        
        
        qps.addPatients(qp);
        System.out.println("Print QPS completa");
        qps.displayQueues();
        
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
        
        
        System.out.println(filaSintomas.showFrequentSymptom());
        System.out.println(filaSintomas1.showFrequentSymptom());
        System.out.println(filaSintomas2.showFrequentSymptom());
       
        StackArryList filaSintomasss = new StackArryList();
        System.out.println(filaSintomasss.showFrequentSymptom());
            
        
        
    }
    
}
