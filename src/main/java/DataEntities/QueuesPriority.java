package DataEntities;

import Entities.Patient;
import Entities.enums.PriorityStatus;
import java.util.ArrayList;
import java.util.List;

public class QueuesPriority extends CustomQueue<Patient> {

    public QueuesPriority() {
        super();
    }

    public static void insertionSort(CustomQueue<Patient> bucket) {
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

    public void bucketSort(CustomQueue<Patient> patients) {
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
            insertionSort(bucket);
        }

        int position = 0;
        for (CustomQueue<Patient> bucket : buckets) {
            for (Patient patient : bucket) {
                customQueue.set(position++, patient);
            }
        }
    }

}