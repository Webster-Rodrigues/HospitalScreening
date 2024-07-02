package DataEntities;

import Entities.Symptoms;

public class QueueSymptoms extends CustomQueue<Symptoms> {

    public QueueSymptoms() {
        super();
    }

    @Override
    public void enqueue(Symptoms symptoms) {
        if (customQueue.equals(symptoms)) {
            throw new IllegalStateException("Sintoma já adicionado a lista!!");
        } else {
            customQueue.add(symptoms);
        }
    }
    

    public int calculateTotalScore() {
        int totalScore = 0;
        for (Symptoms symptom : this) {
            totalScore += symptom.getScore();
        }
        return totalScore;
    }
   
}
