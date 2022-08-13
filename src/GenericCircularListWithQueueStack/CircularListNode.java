package GenericCircularListWithQueueStack;

public class CircularListNode<T> {
    private CircularListNode<T> previous;
    private CircularListNode<T> next;
    private T value;

    public CircularListNode(T value, CircularListNode<T> previous, CircularListNode<T> next) {
        this.value = value;
        this.previous = previous;
        this.next = next;

    }

    public T getValue() {
        return this.value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public CircularListNode<T> getPrevious() {
        return this.previous;
    }

    public void setPrevious(CircularListNode<T> previous) {
        this.previous = previous;
    }

    public CircularListNode<T> getNext() {
        return this.next;
    }

    public void setNext(CircularListNode<T> next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CircularListNode<?>) {
            CircularListNode<?> other = (CircularListNode<?>) obj;
            return this.value.equals(other.value);
        }
        return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }
}