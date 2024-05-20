package DataEntities;

import Entities.Patient;
import Entities.enums.PriorityStatus;
import Entities.enums.Status;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class QueuesPriority extends CustomQueue<Patient> {

    private boolean isModified;

    public QueuesPriority() {
        super();
        isModified = false;
    }

    @Override
    public void enqueue(Patient patient) {
        if (!validateRG(patient.getRG())) {
            customQueue.add(patient);
            isModified = true;
            //JOptionPane.showMessageDialog(null, "Paciente cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Esse RG já está sendo usado. Por favo tente novamente com um RG válido!");
        }
    }

    public boolean validateRG(String RG) {
        for (Patient patient : customQueue) {
            if (patient.getRG().equals(RG)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Patient dequeue() {
        if (isModified) {
            completeOrdination();
            isModified = false;
        }
        if(!isEmpty()){
            JOptionPane.showMessageDialog(null,"Atendendo paciente: " + peek().getName());
            System.out.println("Atendendo paciente: " + peek().getPriorityStatus());
            System.out.println("Atendendo paciente: " + peek().getStatus()); 
        }
        return super.dequeue();
    }

    public void completeOrdination() {
        bucketSortPS(this);
        bucketSortStatus(this);
        isModified = false;
    }

    private static void insertionSortPS(CustomQueue<Patient> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            Patient key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j).getPriorityStatus().ordinal() > key.getPriorityStatus().ordinal()) {
                bucket.set(j + 1, bucket.get(j));
                j = j - 1;
            }
            bucket.set(j + 1, key);
        }
    }

    public void bucketSortPS(CustomQueue<Patient> patients) {
        CustomQueue<Patient> customQueue = this;

        int minPriority = PriorityStatus.values()[0].getPriority();
        int maxPriority = PriorityStatus.values()[0].getPriority();
        for (Patient patient : patients) {
            if (patient.getPriorityStatus().getPriority() < minPriority) {
                minPriority = patient.getPriorityStatus().getPriority();
            }
            if (patient.getPriorityStatus().getPriority() > maxPriority) {
                maxPriority = patient.getPriorityStatus().getPriority();
            }
        }

        int bucketCount = maxPriority - minPriority + 1;

        List<CustomQueue<Patient>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new CustomQueue());
        }

        for (Patient patient : customQueue) {
            int index = patient.getPriorityStatus().getPriority() - minPriority;
            buckets.get(index).enqueue(patient);
        }

        for (CustomQueue<Patient> bucket : buckets) {
            insertionSortPS(bucket);
        }

        int position = 0;
        for (CustomQueue<Patient> bucket : buckets) {
            for (Patient patient : bucket) {
                customQueue.set(position++, patient);
            }
        }
    }

    private static void insertionSortStatus(CustomQueue<Patient> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            Patient key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j).getStatus().ordinal() > key.getStatus().ordinal()) {
                bucket.set(j + 1, bucket.get(j));
                j = j - 1;
            }
            bucket.set(j + 1, key);
        }
    }

    public void bucketSortStatus(CustomQueue<Patient> patients) {
        CustomQueue<Patient> customQueue = this;

        int minPriority = Status.values()[0].getPriority();
        int maxPriority = Status.values()[0].getPriority();
        for (Patient patient : patients) {
            if (patient.getStatus().getPriority() < minPriority) {
                minPriority = patient.getStatus().getPriority();
            }
            if (patient.getStatus().getPriority() > maxPriority) {
                maxPriority = patient.getStatus().getPriority();
            }
        }

        int bucketCount = maxPriority - minPriority + 1;

        List<CustomQueue<Patient>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new CustomQueue());
        }

        for (Patient patient : customQueue) {
            int index = patient.getStatus().getPriority() - minPriority;
            buckets.get(index).enqueue(patient);
        }

        for (CustomQueue<Patient> bucket : buckets) {
            insertionSortStatus(bucket);
        }

        int position = 0;
        for (CustomQueue<Patient> bucket : buckets) {
            for (Patient patient : bucket) {
                customQueue.set(position++, patient);
            }
        }
    }

    public void priorityPatients() {
        for (Patient patient : customQueue) {
            patient.calculatePriority();
            patient.setStatusPatients(patient);
        }
    }

}
