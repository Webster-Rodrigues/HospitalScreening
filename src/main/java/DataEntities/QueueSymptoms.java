
package DataEntities;

import Entities.enums.SymptomsStatus;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

public class QueueSymptoms extends CustomQueue<Symptoms> {
    
    public QueueSymptoms(){
        super();
    }
    
    @Override
    public void enqueue(Symptoms symptoms) {
        if(customQueue.equals(symptoms)){
            JOptionPane.showMessageDialog(null, "Sintoma já adicionado a lista!!");
            return;
        }
        else{
            customQueue.add(symptoms);
        }
    }
    
    
    public Map<SymptomsStatus, Integer> countSymptomsStatus() {
        Map<SymptomsStatus, Integer> statusCounter = new HashMap<>();

        for (SymptomsStatus status : SymptomsStatus.values()) {
            statusCounter.put(status, 0);
        }

        for (Symptoms symptoms : customQueue) {
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

    public SymptomsStatus showFrequentSymptom() {
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

    public boolean checkSymptomsSerious() {
        for (Symptoms symptoms : customQueue) {
            SymptomsStatus status = symptoms.getStatus();
            if (status == SymptomsStatus.GRAVE) {
                return true;
            }
        }
        return false; 
    }
    
    public boolean checkSymptomsCritical() {
        for (Symptoms symptoms : customQueue) {
            SymptomsStatus status = symptoms.getStatus();
            if (status == SymptomsStatus.GRAVISSIMO) {
                return true;
            }
        }
        return false; 
    }
    
}
