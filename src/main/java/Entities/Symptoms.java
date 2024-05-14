
package Entities;

import DataEntities.IntValue;
import Entities.enums.SymptomsStatus;

public class Symptoms implements IntValue{
    
    private String nameSymptoms;
    private SymptomsStatus status;
    
    
    public  Symptoms(){
        
    }
    
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
    
    @Override
    public String toString(){
        return "Sintoma: " + nameSymptoms + ", Categoria: " + status;
    }
    
    @Override
    public int getValue(){
        return status.ordinal();
    }
    
}
