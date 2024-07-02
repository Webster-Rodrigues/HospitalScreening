package DataEntities;

import Entities.Patient;
import Entities.enums.PriorityStatus;
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
            super.enqueue(patient);
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
        if (!isEmpty()) {
            //JOptionPane.showMessageDialog(null, "Atendendo paciente: " + peek().getName());
            System.out.println("Atendendo paciente: " + peek().getName());
            System.out.println("Prioridade de Status: " + peek().getPriorityStatus());
            System.out.println("Status: " + peek().getStatus());
        }
        return super.dequeue();
    }

    public void completeOrdination() {
        bucketSortPS(this);
        bucketSortScore(this);
        isModified = false;
    }

    public Patient findPatientRG(String RG) {
        try {
            for (Patient patient : customQueue) {
                if (validateRG(RG)) {
                    return patient;
                }
            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(null, "Esse paciente não existe!!");

        }
        return null;
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

    private static void insertionSortScore(CustomQueue<Patient> bucket) {
        for (int i = 1; i < bucket.size(); i++) {
            Patient key = bucket.get(i);
            int j = i - 1;

            while (j >= 0 && bucket.get(j).getScore() < key.getScore()) {
                bucket.set(j + 1, bucket.get(j));
                j--;
            }
            bucket.set(j + 1, key);
        }
    }

    public void bucketSortScore(CustomQueue<Patient> patients) {
        int minScore = Integer.MAX_VALUE;
        int maxScore = Integer.MIN_VALUE;

        for (Patient patient : patients) {
            if (patient.getScore() < minScore) {
                minScore = patient.getScore();
            }
            if (patient.getScore() > maxScore) {
                maxScore = patient.getScore();
            }
        }

        int bucketCount = patients.size();

        List<CustomQueue<Patient>> buckets = new ArrayList<>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new CustomQueue<>());
        }

        float interval = ((float) maxScore - minScore + 1) / bucketCount;

        for (Patient patient : patients) {
            int index = (int) ((patient.getScore() - minScore) / interval);
            if (index < 0) {
                index = 0;
            } else if (index >= bucketCount) {
                index = bucketCount - 1;
            }
            buckets.get(index).enqueue(patient);
        }

        int position = 0;
        for (int i = buckets.size() - 1; i >= 0; i--) {
            CustomQueue<Patient> bucket = buckets.get(i);
            insertionSortScore(bucket);
            for (Patient patient : bucket) {
                patients.set(position++, patient);
            }
        }
    }
}
