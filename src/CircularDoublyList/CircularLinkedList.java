package CircularDoublyList;

public class CircularLinkedList {

    private CircularListNode sentinel;

    public CircularLinkedList() {
        this.sentinel = new CircularListNode(0, null, null);
        this.sentinel.setNext(this.sentinel);
        this.sentinel.setPrevious(this.sentinel);
    }

    public boolean isEmpty() {
        return this.getHead() == this.sentinel && this.getTail() == this.sentinel;
    }

    public void addFirst(Integer value) {
        CircularListNode oldHead = this.sentinel.getNext();
        CircularListNode newHead = new CircularListNode(value, this.sentinel.getPrevious(), oldHead);
        if (isEmpty()) {
            this.sentinel.setNext(newHead);
            this.sentinel.setPrevious(newHead);
        } else {
            oldHead.setPrevious(newHead);
        }
        this.sentinel.setNext(newHead);
    }

    public void addLast(Integer value) {
        CircularListNode newTail = new CircularListNode(value, getTail(), sentinel);
        CircularListNode currentTail = getTail();
        if (isEmpty()) {
            addFirst(value);
        } else {
            currentTail.setNext(newTail);
            sentinel.setPrevious(newTail);
        }
    }

    public int size() {
        int size = 0;
        CircularListNode nodeCount = sentinel;
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
        CircularLinkedList currentNode = new CircularLinkedList();
        CircularListNode previousNode = getHead();
        do {
            currentNode.addFirst(previousNode.getValue());
            previousNode = previousNode.getNext();
        } while (previousNode != sentinel);
        sentinel = currentNode.sentinel;
    }

    public boolean isOrdered(boolean ascending) {
        CircularListNode ordering = getHead();
        Integer previousValue;

        while (ordering != sentinel) {
            previousValue = ordering.getValue();
            ordering = ordering.getNext();
            if (ordering != sentinel) {
                if (previousValue > ordering.getValue() && ascending) {
                    return false;
                }
                if (previousValue < ordering.getValue() && !ascending) {
                    return false;
                }
            }
        }
        return true;
    }

    public CircularListNode search(Integer searched) {
        CircularListNode searching = getHead();
        while (searching != sentinel) {
            if (searching.getValue() == searched) {
                return searching;
            }
            searching = searching.getNext();
        }
        return null;
    }

    public void delete(CircularListNode nodeDelete) {
        CircularListNode previousNode = nodeDelete.getPrevious();
        CircularListNode nextNode = nodeDelete.getNext();
        nextNode.setPrevious(previousNode);
        previousNode.setNext(nextNode);
    }

    public boolean isEquals(CircularLinkedList listTwo) {
        CircularListNode listTwoHead = listTwo.getHead();
        CircularListNode otherListHead = getHead();
        while (otherListHead != this.sentinel) {
            if (otherListHead.getValue() != listTwoHead.getValue()) {
                return false;
            }
            listTwoHead = listTwoHead.getNext();
            otherListHead = otherListHead.getNext();
        }

        return true;
    }

    public CircularLinkedList copy() {
        CircularLinkedList copy = new CircularLinkedList();
        CircularListNode currentNode = sentinel.getNext();
        for (int i = 0; i < size(); i++) {
            copy.addLast(currentNode.getValue());
            currentNode = currentNode.getNext();
        }
        return copy;
    }

    public Integer get(Integer value) {
        CircularListNode currentNode = getHead();
        int getSize = 0;
        if (this.isEmpty()) {
            throw new RuntimeException("List is empty");
        }

        while (getSize != value) {
            currentNode = currentNode.getNext();
            if (currentNode == this.sentinel) {
                currentNode = getHead();
            }
            getSize++;
        }
        return currentNode.getValue();
    }

    public CircularListNode getSuccessor(CircularListNode currentNode) {
        CircularListNode successor = currentNode.getNext();
        if (isEmpty()) {
            throw new RuntimeException("List is empty.");
        }
        if (successor == sentinel) {
            return getHead();
        }
        return successor;
    }

    public CircularListNode getHead() {
        return this.sentinel.getNext();
    }

    public CircularListNode getTail() {
        return this.sentinel.getPrevious();
    }

}
