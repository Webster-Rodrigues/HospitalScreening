package DataEntities;

import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public interface CustomQueueShape<T> {

    T peek();

    void enqueue(T element);

    T dequeue();

    boolean isEmpty();

    void displayQueue();

    void comparatorQueue(ToIntFunction<? super T> keyExtractor);

    int size();

    @Override
    String toString();

    T get(int index);

    void set(int index, T element);

    void forEach(Consumer<? super T> action);

    void clear();

    @Override
    boolean equals(Object o);

    @Override
    int hashCode();
    
    boolean remove(Object o);
    
}
