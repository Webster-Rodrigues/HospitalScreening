package Application;

import DataEntities.CustomQueue;
import DataEntities.QueuesPriority;
import Entities.Patient;
import Entities.enums.PriorityStatus;

public class Program2 {

    public static void main(String[] args) {
       
        
        QueuesPriority queuesPriority = new QueuesPriority();

        // Adicionando alguns pacientes à fila
        queuesPriority.enqueue(new Patient("Ana", PriorityStatus.IDOSO));
        queuesPriority.enqueue(new Patient("João", PriorityStatus.CRIANCA));
        queuesPriority.enqueue(new Patient("Maria", PriorityStatus.COMUM));
        queuesPriority.enqueue(new Patient("Pedro", PriorityStatus.GRAVIDA));
        queuesPriority.enqueue(new Patient("Marta", PriorityStatus.IDOSO));
        queuesPriority.enqueue(new Patient("Carlos", PriorityStatus.COMUM));
        queuesPriority.enqueue(new Patient("Laura", PriorityStatus.CRIANCA));
        queuesPriority.enqueue(new Patient("Fernanda", PriorityStatus.GRAVIDA));

        // Exibindo a fila antes da ordenação
        System.out.println("Fila antes do bucketSort:");
        queuesPriority.displayQueue();
        System.out.println();

        // Chamando o método bucketSort para ordenar a fila
        queuesPriority.bucketSort(queuesPriority);

        // Exibindo a fila depois da ordenação
        System.out.println("Fila depois do bucketSort:");
        queuesPriority.displayQueue();
    
        
    }

}
