
package DataEntities;

import Entities.enums.SymptomsStatus;
import java.util.ArrayList;
import java.util.List;

public class StackArryList {
    private List<Symptoms> elements;

    public StackArryList() {
        this.elements = new ArrayList<>();
    }

    public void push(Symptoms symptoms) {
        elements.add(symptoms);
    }

    public Symptoms pop() {
        if (isEmpty()) {
            throw new IllegalStateException("A pilha está vazia");
        }
        return elements.remove(elements.size() - 1);
    }

    public Symptoms peek() {
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
