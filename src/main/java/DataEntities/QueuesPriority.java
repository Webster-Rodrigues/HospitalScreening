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
        if(validateRG(patient.getRG())){
            throw new IllegalStateException("Não foi possível adicionar paciente. RG já cadastrado");
        }
        else{
            queues.get(patient.getStatus()).offer(patient);
        }
    }

    public boolean isEmpity(Status status) {
        return queues.get(status).isEmpty();
    }

    public void servePatient() {
        for (Status status : Status.values()) {
            Queue<Patient> queue = queues.get(status);
            if (!queue.isEmpty()) {
                Patient patient = queue.poll();
                System.out.println("Atendendo paciente: " + patient.getName());
                return;
            }
        }
        throw new IllegalStateException("Todas as filas estão vazias!!");
    }

    public void displayQueues() {
        for (Queue<Patient> patient : queues.values()) {
            if (!queues.isEmpty()) {
                System.out.println(patient);
            } else {
                throw new IllegalStateException("A fila está vazia");
            }
        }
    }

    public Patient findPatient(Status status, String RG) {
        Queue<Patient> queue = queues.get(status);
        if (queue != null && !queue.isEmpty()) {
            for (Patient patient : queue) {
                if (patient.getRG().equals(RG)) {
                    return patient;
                }
            }
        }
        return null;
    }
    
    
    public boolean validateRG(String RG){
       for (Status status : Status.values()) {
           Queue<Patient> queue = queues.get(status);
           if (queue != null && !queue.isEmpty()) {
               for (Patient patient : queue) {
                   if (patient.getRG().equals(RG)) {
                       return true;
                   }
                        
               }
           }
       }
       return false;            
    }

}
