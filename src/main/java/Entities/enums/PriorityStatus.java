
package Entities.enums;

public enum PriorityStatus {
    GRAVIDA,
    IDOSO,
    CRIANCA,
    COMUM;
    
    
    public int getPriority() {
        return ordinal(); 
    }
}
