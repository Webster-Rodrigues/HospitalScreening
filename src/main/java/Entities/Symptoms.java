
package Entities;


import Entities.enums.SymptomsStatus;
import java.util.HashMap;
import java.util.Map;

public class Symptoms {
    
    private String nameSymptoms;
    private SymptomsStatus status;
    
    public  Symptoms(){
        
    }

    public Symptoms(String nameSymptoms) {
        this.nameSymptoms = nameSymptoms;
    }
        
    public Symptoms(String nameSymptoms, SymptomsStatus status){
        this.nameSymptoms = nameSymptoms;
        this.status = status;
        
    }
        
    private static final Map<SymptomsStatus, Integer> mapValueSymptomsStatus = new HashMap<>();

    static {
        mapValueSymptomsStatus.put(SymptomsStatus.MUITO_LEVE,7);
        mapValueSymptomsStatus.put(SymptomsStatus.LEVE, 20);
        mapValueSymptomsStatus.put(SymptomsStatus.NORMAL, 100);
        mapValueSymptomsStatus.put(SymptomsStatus.GRAVE, 400);
        mapValueSymptomsStatus.put(SymptomsStatus.GRAVISSIMO,1000);
    }
    
    public Integer calculateScore(SymptomsStatus symptomsStatus) {
        return mapValueSymptomsStatus.get(symptomsStatus);
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

    public int getScore() {
        return calculateScore(status);
    }
    
    @Override
    public String toString(){
        return "Sintoma: " + nameSymptoms + ", Categoria: " + status;
    }
    
}
