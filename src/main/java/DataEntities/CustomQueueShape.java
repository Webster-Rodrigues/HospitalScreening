
package DataEntities;

public interface CustomQueueShape <T>{
    
    T peekMiddle();
    T peekFrist();
    T peekLast();
    boolean isEmpty();
    
}
