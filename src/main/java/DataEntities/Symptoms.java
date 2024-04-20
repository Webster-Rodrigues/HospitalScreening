
package DataEntities;

import Entities.enums.SymptomsStatus;

public class Symptoms {
    
    private String nameSymptoms;
    private SymptomsStatus status;
    
    
    public Symptoms(String nameSymptoms, SymptomsStatus status){
        this.nameSymptoms = nameSymptoms;
        this.status = status;
    }

    public String getNameSymptoms() {
        return nameSymptoms;
    }

    public void setNameSymptoms(String nameSymptoms) {
        this.nameSymptoms = nameSymptoms;
    }

    public SymptomsStatus getStatus() {
        return status;
    }

    public void setStatus(SymptomsStatus status) {
        this.status = status;
    }
    

    
}
