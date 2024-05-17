
package Entities.enums;

public enum PriorityStatus {
    GRAVIDA(1),
    IDOSO(2),
    CRIANCA(3),
    COMUM(4);

    private final int priority;

    PriorityStatus(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return this.priority;
    }
}

