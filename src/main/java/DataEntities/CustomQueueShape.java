
package DataEntities;
import java.util.function.Consumer;

public interface CustomQueueShape <T>{
    
    T peek();
    void enqueue(T element);
    T dequeue();
    boolean isEmpty();
    void displayQueue();
    void comparatorQueue();
    int size();
    T get(int index);
   void set(int index, T element);
   void forEach(Consumer<? super T> action);
}
