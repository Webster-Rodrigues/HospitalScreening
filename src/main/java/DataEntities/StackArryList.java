package DataEntities;

import Entities.enums.SymptomsStatus;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StackArryList {

    private List<Symptoms> elements;

    public StackArryList() {
        this.elements = new ArrayList<>();
    }

    public void push(Symptoms symptoms) {
        elements.add(symptoms);
    }

    public Symptoms pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.remove(elements.size() - 1);
    }

    public Symptoms peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }

    public Symptoms displayStack() {
        for (Symptoms symptoms : elements) {
            if (!isEmpty()) {
                System.out.println(symptoms);
            } else {
                throw new IllegalStateException("A pilha está vazia");
            }
        }
        return null;

    }

    public Map<SymptomsStatus, Integer> countSymptomsStatus() {
        Map<SymptomsStatus, Integer> statusCounter = new HashMap<>();

        for (SymptomsStatus status : SymptomsStatus.values()) {
            statusCounter.put(status, 0);
        }

        for (Symptoms symptoms : elements) {
            int count = statusCounter.get(symptoms.getStatus());
            statusCounter.put(symptoms.getStatus(), count + 1);
        }

        return statusCounter;
    }

    public int maxSymptomsStatus() {
        int max = 0;
        max = countSymptomsStatus().values().stream().max(Integer::compare).get();
        return max;
    }

    public SymptomsStatus setStatusPatient() {
        Map<SymptomsStatus, Integer> statusCounter = countSymptomsStatus();
        int maxOccurrences = maxSymptomsStatus();

        for (Map.Entry<SymptomsStatus, Integer> entry : statusCounter.entrySet()) {
            SymptomsStatus status = entry.getKey();
            int occurrences = entry.getValue();

            if (occurrences == maxOccurrences) {
                return status;
            }
        }
        return null;
    }

}
