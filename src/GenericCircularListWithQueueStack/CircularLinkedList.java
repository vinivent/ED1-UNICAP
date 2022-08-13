package GenericCircularListWithQueueStack;

public class CircularLinkedList<T> {

    private CircularListNode<T> sentinel;

    public CircularLinkedList() {
        this.sentinel = new CircularListNode<T>(null, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
    }

    public boolean isEmpty() {
        return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
    }

    public void addFirst(T value) {
        CircularListNode<T> oldHead = this.sentinel.getNext();
        CircularListNode<T> newHead = new CircularListNode<T>(value, this.sentinel.getPrevious(), oldHead);
        if (isEmpty()) {
            this.sentinel.setNext(newHead);
            this.sentinel.setPrevious(newHead);
        } else {
            oldHead.setPrevious(newHead);
        }
        this.sentinel.setNext(newHead);
    }

    public void addLast(T value) {
        CircularListNode<T> newTail = new CircularListNode<T>(value, getTail(), sentinel);
        CircularListNode<T> currentTail = getTail();
        if (isEmpty()) {
            addFirst(value);
        } else {
            currentTail.setNext(newTail);
            sentinel.setPrevious(newTail);
        }
    }

    public int size() {
        int size = 0;
        CircularListNode<T> nodeCount = sentinel;
        if (!isEmpty()) {
            while (nodeCount.getNext() != sentinel) {
                size++;
                nodeCount = nodeCount.getNext();

            }
            return size;
        }
        return size;
    }

    public void reverse() { // 1 2 3
        CircularLinkedList<T> currentNode = new CircularLinkedList<T>();
        CircularListNode<T> previousNode = getHead();
        do {
            currentNode.addFirst(previousNode.getValue());
            previousNode = previousNode.getNext();
        } while (previousNode != sentinel);
        sentinel = currentNode.sentinel;
    }

    public CircularListNode<T> search(Integer searched) {
        CircularListNode<T> searching = getHead();
        while (searching != sentinel) {
            if (searching.getValue() == searched) {
                return searching;
            }
            searching = searching.getNext();
        }
        return null;
    }

    public void delete(CircularListNode<T> nodeDelete) {
        CircularListNode<T> previousNode = nodeDelete.getPrevious();
        CircularListNode<T> nextNode = nodeDelete.getNext();
        nextNode.setPrevious(previousNode);
        previousNode.setNext(nextNode);
    }

    public boolean isEquals(CircularLinkedList<T> listTwo) {
        CircularListNode<T> listTwoHead = listTwo.getHead();
        CircularListNode<T> otherListHead = getHead();
        while (otherListHead != this.sentinel) {
            if (otherListHead.getValue() != listTwoHead.getValue()) {
                return false;
            }
            listTwoHead = listTwoHead.getNext();
            otherListHead = otherListHead.getNext();
        }

        return true;
    }

    public CircularLinkedList<T> copy() {
        CircularLinkedList<T> copy = new CircularLinkedList<T>();
        CircularListNode<T> currentNode = sentinel.getNext();
        for (int i = 0; i < size(); i++) {
            copy.addLast(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return copy;
    }

    public CircularListNode<T> getHead() {
        return this.sentinel.getNext();
    }

    public CircularListNode<T> getTail() {
        return this.sentinel.getPrevious();
    }

}
