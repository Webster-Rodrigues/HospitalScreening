
package Entities.enums;

public enum Status {
    EMERGENCIA(1),
    MUITO_URGENTE(2),
    URGENTE(4),
    POUCO_URGENTE(5),
    NAO_URGENTE(6);
    
    
    private final int priority;

    Status(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }

  
}
