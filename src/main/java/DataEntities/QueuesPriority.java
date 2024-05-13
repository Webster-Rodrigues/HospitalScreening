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
        try {
            if (!validateRG(patient.getRG())) {
                customQueue.add(patient);
                isModified = true;
            }
        } catch (IllegalStateException e) {
            throw new IllegalStateException("RG já cadastrado! Tente novamente com um RG válido.");
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
        System.out.println("Atendendo paciente: " + peek().getName());
        System.out.println("Atendendo paciente: " + peek().getPriorityStatus());
        System.out.println("Atendendo paciente: " + peek().getStatus());
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

        PriorityStatus minPriorityStatus = PriorityStatus.values()[0];
        PriorityStatus maxPriorityStatus = PriorityStatus.values()[0];
        for (Patient patient : patients) {
            if (patient.getPriorityStatus().ordinal() < minPriorityStatus.ordinal()) {
                minPriorityStatus = patient.getPriorityStatus();
            }
            if (patient.getPriorityStatus().ordinal() > maxPriorityStatus.ordinal()) {
                maxPriorityStatus = patient.getPriorityStatus();
            }
        }

        int bucketCount = maxPriorityStatus.ordinal() - minPriorityStatus.ordinal() + 1;

        List<CustomQueue<Patient>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new CustomQueue());
        }

        for (Patient patient : customQueue) {
            int index = patient.getPriorityStatus().ordinal() - minPriorityStatus.ordinal();
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

        Status minStatus = Status.values()[0];
        Status maxStatus = Status.values()[0];
        for (Patient patient : patients) {
            if (patient.getPriorityStatus().ordinal() < minStatus.ordinal()) {
                minStatus = patient.getStatus();
            }
            if (patient.getPriorityStatus().ordinal() > maxStatus.ordinal()) {
                maxStatus = patient.getStatus();
            }
        }

        int bucketCount = maxStatus.ordinal() - minStatus.ordinal() + 1;

        List<CustomQueue<Patient>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new CustomQueue());
        }

        for (Patient patient : customQueue) {
            int index = patient.getStatus().ordinal() - minStatus.ordinal();
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
