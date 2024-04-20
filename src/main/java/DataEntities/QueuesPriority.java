

package DataEntities;
import java.util.Queue;
import Entities.Patient;
import Entities.enums.Status;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;



public class QueuesPriority {
   private Map<Status, Queue<Patient>> queues = new HashMap<>();

    public QueuesPriority() {
        for (Status status : Status.values()) {
            queues.put(status, new PriorityQueue<>(Comparator.comparingInt(s -> s.getStatus().ordinal())));
        }
    }

    public void addPatient(Patient patient) {
        queues.get(patient.getStatus()).offer(patient);    
        
    }
    
    public boolean isEmpity(Status status){
       return queues.get(status).isEmpty();
    }
    
    
    public void servePatient() {
    for (Status status : Status.values()) {
        Queue<Patient> queue = queues.get(status);
        if (!queue.isEmpty()) {
            Patient patient = queue.poll();
            System.out.println("Atendendo paciente: " + patient.getName());
        }
        else{
            System.out.println("Fila vazia!!");
        }
      }
    }
    
    
    public void displayQueues(){
        for(Queue<Patient> patient : queues.values()){
            if(!queues.isEmpty()){
                System.out.println(patient);
            }
            else{
                System.out.println("Fila vazia!!");
            }
        }
    }



}

