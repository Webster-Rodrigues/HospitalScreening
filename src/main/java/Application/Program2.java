package Application;

import DataEntities.QueuesPriority;
import DataEntities.QueuesPriorityStatus;
import DataEntities.StackArryList;
import DataEntities.Symptoms;
import Entities.Patient;
import Entities.enums.PriorityStatus;
import Entities.enums.Status;
import Entities.enums.SymptomsStatus;
import java.util.ArrayList;
import java.util.List;

public class Program2 {

    public static void main(String[] args) {

        StackArryList filaSintomas1 = new StackArryList();
        StackArryList filaSintomas2 = new StackArryList();
        StackArryList filaSintomas3 = new StackArryList();
        StackArryList filaSintomas4 = new StackArryList();
        StackArryList filaSintomas5 = new StackArryList();

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

        filaSintomas1.push(sm9);
        filaSintomas1.push(sm10);//MUITO LEVE
        //filaSintomas1.push(sm3);
        //filaSintomas1.push(sm1);

        filaSintomas2.push(sm8);
        filaSintomas2.push(sm7); //LEVE
        //filaSintomas2.push(sm4);
        //filaSintomas2.push(sm4);

        filaSintomas3.push(sm6);
        filaSintomas3.push(sm5);//NORMAL
        //filaSintomas3.push(sm7);
        //filaSintomas3.push(sm4);

        filaSintomas4.push(sm4);
        filaSintomas4.push(sm3);//GRAVE
        //filaSintomas4.push(sm7);
        //filaSintomas4.push(sm4);

        filaSintomas5.push(sm2);
        filaSintomas5.push(sm1);//GRAVISSÍMO
        //filaSintomas5.push(sm7);
        //filaSintomas5.push(sm4);

        Patient pt1 = new Patient("André", "Masculino", 60,false , "456", filaSintomas1);
        Patient pt2 = new Patient("Luiza", "Feminino", 20, true,  "179", filaSintomas2);
        Patient pt3 = new Patient("Alice", "Feminino", 20,false,  "147", filaSintomas3);
        Patient pt4 = new Patient("Leo", "Masculino",6,false,  "123", filaSintomas4);
        Patient pt5 = new Patient("Lucas", "Masculino", 29, false, "789", filaSintomas5);
        
        QueuesPriority qp = new QueuesPriority();
        QueuesPriorityStatus qps = new QueuesPriorityStatus();
        qp.enqueue(pt1);
        qp.enqueue(pt2);
        qp.enqueue(pt3);
        qp.enqueue(pt4);
        qp.enqueue(pt5);
        
        qp.priorityPatients();
        qp.displayQueue();
        
        /*for(Patient pt : test){
            pt.setStatusPatients(pt);
            System.out.println("O status do paciente: " + pt.getName() + ", Foi definido como: " + pt.getStatus());
        }
        System.out.println();
        for(Patient pt : test){
            pt.calculatePriority();
            System.out.println("A prioridade do paciente: " + pt.getName() + ", Foi definida como: " + pt.getPriorityStatus());
        }*/
        
        

    }

}
