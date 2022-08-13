package QueueStack;

public class QueueArray implements IQueue {
    private Integer[] queue;
    private int last, front, size;

    public QueueArray(int capacity) {
        this.queue = new Integer[capacity];
        this.size = 0;
        this.last = 0;
        this.front = 0;
    }

    @Override
    public void enqueue(Integer value) {
        if (size == queue.length) {
            throw new IllegalStateException("Queue cannot enqueue more than 3 elements");
        }
        queue[last] = value;
        last = (last + 1) % queue.length;
        size++;

    }

    @Override
    public Integer dequeue() throws Exception {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is Empty");
        } else {
            int element = queue[front];  
            front = (front + 1) % queue.length;
            size--;
            return element;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }
}
