
package Entities.enums;


public enum SymptomsStatus {
    GRAVISSIMO,
    GRAVE,
    NORMAL,
    LEVE,
    MUITO_LEVE;
    
    
    public int getPriority() {
        return ordinal(); 
    }
}
