
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
        
        filaSintomas.push(sm1);
        filaSintomas.push(sm2);
        filaSintomas.push(sm7);
        filaSintomas.push(sm4);
        Patient patient = new Patient("Leo", "Feminino", 20, "1123", "4156165", Status.URGENTE, filaSintomas);
        
        filaSintomas1.push(sm1);
        filaSintomas1.push(sm4);
        filaSintomas1.push(sm7);
        filaSintomas1.push(sm6);
        Patient patient1 = new Patient("André", "Masculino", 50, "12590", "541691", Status.EMERGENCIA, filaSintomas1);
        
        filaSintomas2.push(sm1);
        filaSintomas2.push(sm2);
        filaSintomas2.push(sm7);
        filaSintomas2.push(sm4);
        Patient patient2 = new Patient("Lucas", "Masculino", 29, "12549590", "544491", Status.POUCO_URGENTE, filaSintomas2);
        
        QueuesPriority qp = new QueuesPriority();
        qp.addPatient(patient);
        qp.addPatient(patient1);
        qp.addPatient(patient2);
        
        
        System.out.println("Print da lista completa");
        qp.displayQueues();
        
        
        System.out.println("Atendendo o paciente B"); 
        qp.servePatient();
        
        
        System.out.println("Print da lista completa");
        qp.displayQueues();
        
        System.out.println("Atendendo o paciente A"); 
        qp.servePatient();
        
        System.out.println("Print da lista completa");
        qp.displayQueues();
        
        
               
        
        
    }
    
}
