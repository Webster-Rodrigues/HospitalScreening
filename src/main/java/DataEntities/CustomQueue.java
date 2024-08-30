package DataEntities;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.ToIntFunction;

public class CustomQueue<T> implements CustomQueueShape<T>, Comparator<T>, Iterable<T> {

    List<T> customQueue;

    public CustomQueue() {
        customQueue = new ArrayList<>();
    }

    @Override
    public void enqueue(T element) {
        customQueue.add(element);
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia! Não é possível remover.");
            return null;
        }
        return customQueue.remove(0);
    }

    public boolean isEmpty() {
        return customQueue.isEmpty();
    }

    @Override
    public T peek() {
        if (isEmpty()) {
            System.out.println("A fila está vazia! Não é possível visualizar o primeiro elemento.");
            return null;
        }
        return customQueue.get(0);
    }

    @Override
    public void displayQueue() {
        if (isEmpty()) {
            System.out.println("A fila está vazia!");
        } else {
            for (T element : customQueue) {
                System.out.print(element + " \n");
            }
            System.out.println();
        }
    }

    @Override
    public int compare(T o1, T o2) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Comparator<T> thenComparingInt(ToIntFunction<? super T> keyExtractor) {
        return Comparator.super.thenComparingInt(keyExtractor); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    public void comparatorQueue(ToIntFunction<? super T> keyExtractor) {
        customQueue.sort(Comparator.comparingInt(keyExtractor));
    }

    @Override
    public int size() {
        return customQueue.size();
    }

    @Override
    public T get(int index) {
        return customQueue.get(index);
    }

    @Override
    public void set(int index, T element) {
        customQueue.set(index, element);
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        customQueue.forEach(action);
    }

    @Override
    public Iterator<T> iterator() {
        return customQueue.iterator();
    }

    @Override
    public void clear() {
        customQueue.clear();
    }

    @Override
    public String toString() {
        return customQueue.toString();
    }

    @Override
    public boolean equals(Object o) {
        return customQueue.equals(o);
    }

    @Override
    public int hashCode(){
        return customQueue.hashCode();
    }
    
    
    
}
