
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

    public Object poll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
