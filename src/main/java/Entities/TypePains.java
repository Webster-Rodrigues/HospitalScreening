package Entities;

import Entities.enums.SymptomsStatus;
import java.util.HashMap;
import java.util.Map;

public class TypePains extends Symptoms {
    
    private static final Map<String, SymptomsStatus> mapPain = new HashMap<>();
    
    static {
        mapPain.put("DORES SEVERAS", SymptomsStatus.GRAVISSIMO);
        mapPain.put("DORES MODERADAS", SymptomsStatus.NORMAL);
        mapPain.put("DORES LEVES", SymptomsStatus.LEVE);
        mapPain.put("SEM DORES", SymptomsStatus.MUITO_LEVE);        
    }

    /*Tratar nullException*/
    public void setPainStatus(String painStatus) {
        painStatus = painStatus.toUpperCase();
        super.setNameSymptoms(painStatus);
        super.setStatus(mapPain.get(painStatus));
    }
    
}
