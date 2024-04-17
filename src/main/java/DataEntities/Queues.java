

package DataEntities;
import java.util.Queue;
import Entities.Patient;
import Entities.enums.Status;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;



public class Queues {
   private Map<Status, Queue<Patient>> Queues = new HashMap<>();

    public Queues() {
        for (Status status : Status.values()) {
            Queues.put(status, new LinkedList<>());
        }
    }

    public void addPatient(Patient patient) {
        Queues.get(patient.getStatus()).offer(patient);
    }
    
    public void removePatient(Patient patient) {
        Queues.get(patient.getStatus().poll());
    }



    }

