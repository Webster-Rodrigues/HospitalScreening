
package Entities;

import Entities.enums.SymptomsStatus;
import Entities.enums.TempStatus;
import java.util.HashMap;
import java.util.Map;


public class Temp extends Symptoms{
    
    
    private TempStatus tempStatus; 
    
     public Temp(){
        super("Temperatura");
        
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
    
    private static final Map<TempStatus, SymptomsStatus> mapTempStatus = new HashMap<>();

    static {
        mapTempStatus.put(TempStatus.HIPERTERMIA, SymptomsStatus.GRAVISSIMO);
        mapTempStatus.put(TempStatus.HIPOTERMIA, SymptomsStatus.GRAVISSIMO);
        mapTempStatus.put(TempStatus.FEBRE_ALTA, SymptomsStatus.GRAVE);
        mapTempStatus.put(TempStatus.FEBRE, SymptomsStatus.NORMAL);
        mapTempStatus.put(TempStatus.NORMAL, SymptomsStatus.MUITO_LEVE);
    }

    public void mapTempStatus (TempStatus tempStatus) {
         super.setStatus(mapTempStatus.get(tempStatus));
    }
    
    @Override
    public String toString(){
         return "Sintoma: " + getNameSymptoms()+ ", Categoria: " + getStatus() + ", Definição: " + tempStatus;
    }

}
