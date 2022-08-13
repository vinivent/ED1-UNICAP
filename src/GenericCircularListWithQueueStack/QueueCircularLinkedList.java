package GenericCircularListWithQueueStack;

public class QueueCircularLinkedList<T> {

    private CircularLinkedList<T> list;

    public QueueCircularLinkedList() {
        this.list = new CircularLinkedList<T>();
    }

    public boolean isEmpty() {
        return this.list.isEmpty();
    }

    public void enqueue(T valueFirst) {
        list.addLast(valueFirst);
    }

    public T dequeue() throws Exception{
        if (isEmpty()) {
            throw new IllegalStateException("Stack is Empty");
        }
        CircularListNode<T> head = this.list.getHead();
        this.list.delete(head);
        return head.getValue();
    }

}