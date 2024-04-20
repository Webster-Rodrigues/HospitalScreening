
package Entities.enums;

public enum Status {
    EMERGENCIA,
    MUITO_URGENTE,
    URGENTE,
    POUCO_URGENTE,
    NAO_URGENTE;
    
    
    public int getPriority() {
        return ordinal(); 
    }

  
}
