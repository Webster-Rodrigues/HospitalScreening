package DataEntities;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class CustomPriorityQueue<T> extends PriorityQueue<T> implements CustomQueueShape {

    private Queue<T> priorityQueue = new PriorityQueue<>();

    public CustomPriorityQueue() {
        super();
    }

    @Override
    public T peekMiddle() {
        if (priorityQueue.isEmpty()) {
            return null;
        }

        int middleIndex = (priorityQueue.size() - 1) / 2;
        Iterator<T> iterator = priorityQueue.iterator();
        T middleElement = null;
        for (int i = 0; i <= middleIndex; i++) {
            middleElement = iterator.next();
        }

        return middleElement;
    }

    @Override
    public T peekFrist() {
        return isEmpty() ? null : super.peek();
    }

    @Override
    public T peekLast() {
        T lastElement = null;
        for (T element : priorityQueue) {
            lastElement = element;
        }

        return lastElement;
    }

    @Override
    public boolean isEmpty() {
        return super.isEmpty();
    }

}
