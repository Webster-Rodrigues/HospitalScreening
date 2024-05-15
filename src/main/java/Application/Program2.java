package Application;

import ConversionTools.conversions;
import DataEntities.QueueSymptoms;
import DataEntities.QueuesPriority;
import Entities.Patient;
import Entities.Symptoms;
import Entities.Temp;
import Entities.TypePains;
import Entities.enums.SymptomsStatus;




public class Program2 {

    public static void main(String[] args) {
        TypePains tp = new TypePains();
        String st = "Dores Severas";
        
        
        tp.defineSymptom(st);
        System.out.println(tp);
        
        Temp tempp = new Temp();
        
        double test = 39.6;
        tempp.defineSymptom(test);
        
        System.out.println(tempp);
        
        
        conversions calculator = new conversions();
        String dateOfBirth = "21/04/2003"; 
        int age = calculator.conversionForAge(dateOfBirth);
        System.out.println("Idade: " + age);

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

        filaSintomas4.enqueue(tempp);
        //filaSintomas4.enqueue(sm3);//GRAVE
        //filaSintomas4.push(sm7);
        //filaSintomas4.push(sm4);

        filaSintomas5.enqueue(tp);
        //filaSintomas5.enqueue(sm1);//GRAVISSÍMO
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

        qp.priorityPatients();

        System.out.println("Queue normal");
        qp.displayQueue();

        System.out.println("Atendendo o paciente ---Alice---");
        qp.dequeue();
        qp.displayQueue();

        System.out.println("Atendendo o paciente ---Luiza---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---André---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---Laura---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---Leo---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---Lucas---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---Vitória---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---João---");
        qp.dequeue();

        System.out.println("Atendendo o paciente ---Allan---");
        qp.dequeue();

        
        /*Patient patient001 = new Patient("Dora", "Feminino", 40,"179", Status.POUCO_URGENTE,  PriorityStatus.GRAVIDA, filaSintomas2);
        qp.enqueue(patient001);
        qps.addPatients(qp);
        
        
        for(Patient pt : test){
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
