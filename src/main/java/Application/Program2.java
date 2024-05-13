package Application;

import ConversionTools.conversions;
import DataEntities.QueuesPriority;
import DataEntities.StackArryList;
import DataEntities.Symptoms;
import Entities.Patient;
import Entities.enums.SymptomsStatus;



public class Program2 {

    public static void main(String[] args) {
        conversions calculator = new conversions();
        String dateOfBirth = "21/04/2003"; 
        int age = calculator.conversionForAge(dateOfBirth);
        System.out.println("Idade: " + age);

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

        /*
        Patient patient001 = new Patient("Dora", "Feminino", 40,"179", Status.POUCO_URGENTE,  PriorityStatus.GRAVIDA, filaSintomas2);
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
