
package Entities;

import Entities.enums.SymptomsStatus;
import Entities.enums.TempStatus;
import java.util.HashMap;
import java.util.Map;


public class Temp extends Symptoms{
    
    
    private TempStatus tempStatus; 
    
     public Temp(){
        super("Temperatura", null);
        
    }
    
    public TempStatus getTempStatus() {
        return tempStatus;
    }

    public void setTempStatus(TempStatus tempStatus) {
        this.tempStatus = tempStatus;
    }
    
    public void defineSymptom(double valueTemp){
    if (valueTemp > 41.0) {
        this.tempStatus = TempStatus.HIPERTERMIA;
    }
    else if (valueTemp >= 39.6 && valueTemp <= 41.0) {
        this.tempStatus = TempStatus.FEBRE_ALTA;
    }
    else if (valueTemp >= 37.6 && valueTemp <= 39.5) {
        this.tempStatus = TempStatus.FEBRE;
    }
    else if (valueTemp >= 36.0 && valueTemp <= 37.5) {
        this.tempStatus = TempStatus.NORMAL;
    }
    else{
        this.tempStatus = TempStatus.HIPOTERMIA;
    }
        mapTempStatus(tempStatus);
    
    }
    
    private static final Map<TempStatus, SymptomsStatus> statusMap = new HashMap<>();

    static {
        statusMap.put(TempStatus.HIPERTERMIA, SymptomsStatus.GRAVISSIMO);
        statusMap.put(TempStatus.HIPOTERMIA, SymptomsStatus.GRAVISSIMO);
        statusMap.put(TempStatus.FEBRE_ALTA, SymptomsStatus.GRAVE);
        statusMap.put(TempStatus.FEBRE, SymptomsStatus.NORMAL);
        statusMap.put(TempStatus.NORMAL, SymptomsStatus.MUITO_LEVE);
    }

    public void mapTempStatus (TempStatus tempStatus) {
         super.setStatus(statusMap.get(tempStatus));
    }
    
    @Override
    public String toString(){
         return "Sintoma: " + getNameSymptoms()+ ", Categoria: " + getStatus() + ", Definição: " + tempStatus;
    }
    
    
    
   
}
