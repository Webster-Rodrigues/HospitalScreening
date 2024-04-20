
package DataEntities;

import java.util.ArrayList;
import java.util.List;

public class StackArryList<T> {
    private List<T> elements;

    public StackArryList() {
        this.elements = new ArrayList<>();
    }

    public void push(T element) {
        elements.add(element);
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.remove(elements.size() - 1);
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.get(elements.size() - 1);
    }

    public boolean isEmpty() {
        return elements.isEmpty();
    }

    public int size() {
        return elements.size();
    }
    
    
}
