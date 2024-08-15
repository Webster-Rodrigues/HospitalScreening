
package Entities;

import Entities.enums.SymptomsStatus;
import Entities.enums.TempStatus;
import java.util.HashMap;
import java.util.Map;


public class Temp extends Symptoms{

    public void setTemperatureSymptoms(double valueTemp){
    if (valueTemp > 41.0) {
        this.setNameSymptoms("HIPERTERMIA");
    }
    else if (valueTemp >= 39.6 && valueTemp <= 41.0) {
        this.setNameSymptoms("FEBRE ALTA");
    }
    else if (valueTemp >= 37.6 && valueTemp <= 39.5) {
        this.setNameSymptoms("FEBRE");
    }
    else if (valueTemp >= 36.0 && valueTemp <= 37.5) {
        this.setNameSymptoms("TEMPERATURA NORMAL");
    }
    else{
        this.setNameSymptoms("HIPOTERMIA");
    }
        mapTempStatus(this.getNameSymptoms());
    
    }
    
    private static final Map<String, SymptomsStatus> mapTempStatus = new HashMap<>();

    static {
        mapTempStatus.put("HIPERTERMIA", SymptomsStatus.GRAVISSIMO);
        mapTempStatus.put("HIPOTERMIA", SymptomsStatus.GRAVISSIMO);
        mapTempStatus.put("FEBRE ALTA", SymptomsStatus.GRAVE);
        mapTempStatus.put("FEBRE", SymptomsStatus.NORMAL);
        mapTempStatus.put("TEMPERATURA NORMAL", SymptomsStatus.MUITO_LEVE);
    }

    public void mapTempStatus (String tempStatus) {
         super.setStatus(mapTempStatus.get(tempStatus));
    }
    
}
