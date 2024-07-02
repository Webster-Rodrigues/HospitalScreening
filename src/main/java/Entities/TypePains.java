
package Entities;

import Entities.enums.PainStatus;
import Entities.enums.SymptomsStatus;
import java.util.HashMap;
import java.util.Map;

public class TypePains extends Symptoms{
    
    private PainStatus painStatus;
    
    public TypePains(){
        super("Dores");
    }

    public PainStatus getPainStatus() {
        return painStatus;
    }

    public void setPainStatus(PainStatus painStatus) {
        this.painStatus = painStatus;
    }
     
    public void defineSymptom(String valuePain){
        
    if (valuePain.equalsIgnoreCase("DORES SEVERAS")) {
        this.painStatus = PainStatus.DORES_SEVERAS;
    }
    else if (valuePain.equalsIgnoreCase("DORES MODERADAS")) {
        this.painStatus = PainStatus.DORES_MODERADAS;
    }
    else if (valuePain.equalsIgnoreCase("DORES LEVES")) {
        this.painStatus = PainStatus.DORES_LEVES;
    }
    else {
        this.painStatus = PainStatus.SEM_DORES;
    }
        mapPainStatus(painStatus);
    
    }
    
    private static final Map<PainStatus, SymptomsStatus> mapPain = new HashMap<>();

    static {
        mapPain.put(PainStatus.DORES_SEVERAS, SymptomsStatus.GRAVISSIMO);
        mapPain.put(PainStatus.DORES_MODERADAS, SymptomsStatus.NORMAL);
        mapPain.put(PainStatus.DORES_LEVES, SymptomsStatus.LEVE);
        mapPain.put(PainStatus.SEM_DORES, SymptomsStatus.MUITO_LEVE);  
    }

    public void mapPainStatus (PainStatus painStatus) {
         super.setStatus(mapPain.get(painStatus));
    }
    
    
    @Override
    public String toString(){
         return "Sintoma: " + getNameSymptoms()+ ", Categoria: " + getStatus() + ", Definição: " + painStatus;
    }
}
