package DataEntities;

import Entities.Patient;
import Entities.enums.Status;
import java.util.HashMap;
import java.util.Map;


public class QueuesPriorityStatus{

    private Map<Status, CustomQueue<Patient>> queues = new HashMap<>();

    public QueuesPriorityStatus() {
    for (Status status : Status.values()) {
        queues.put(status, new CustomQueue<Patient>());
        CustomQueue<Patient> queue = queues.get(status);
        queue.comparatorQueue(patient -> patient.getStatus().ordinal());
    }
}


    public void addPatient(QueuesPriority customQueue) {
        customQueue.bucketSort(customQueue);
        for (Patient patient : customQueue) {
            queues.get(patient.getStatus()).enqueue(patient);
        }
        customQueue.clear();
    }

    public boolean isEmpity(Status status) {
        return queues.get(status).isEmpty();
    }

    public void servePatient() {
    for (Status status : Status.values()) {
        CustomQueue<Patient> queue = queues.get(status);
        if (!queue.isEmpty()) {
            Patient patient = queue.dequeue();
            System.out.println("Atendendo paciente: " + patient.getName());
            return;
        }
    }
    throw new IllegalStateException("Todas as filas estão vazias!!");
}

    public void displayQueues() {
        for (CustomQueue<Patient> patient : queues.values()) {
            if (!queues.isEmpty()) {
                System.out.println(patient);
            } else {
                throw new IllegalStateException("A fila está vazia");
            }
        }
    }

    public Patient findPatient(Status status, String RG) {
        CustomQueue<Patient> queue = queues.get(status);
        if (queue != null && !queue.isEmpty()) {
            for (Patient patient : queue) {
                if (patient.getRG().equals(RG)) {
                    return patient;
                }
            }
        }
        return null;
    }
/*

    public boolean validateRG(String RG) {
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
     */
}
