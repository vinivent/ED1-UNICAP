package CircularDoublyList;

public class DoublyLinkedList {

    private DoublyListNode head;
    private int size;

    public void addFirst(Integer value) {
        DoublyListNode newElement = new DoublyListNode(value, null, this.head);
        if (isEmpty()) {
            this.head = newElement;
        } else {
            this.head.setPrevious(newElement);
            newElement.setNext(this.head);
            this.head = newElement;
        }
    }

    public void addLast(Integer value) {
        if (isEmpty()) {
            addFirst(value);
        } else {
            DoublyListNode lastElement = getTail();
            DoublyListNode newLastElement = new DoublyListNode(value, lastElement, null);
            lastElement.setNext(newLastElement);
        }

    }

    public boolean isEmpty() {
        return head == null;
    }

    public int size() {
        size = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            getTail();
        }
        return size + 1;
    }

    DoublyListNode search(Integer searched) {

        DoublyListNode searching = head;
        while (searching != null) {
            if (searching.getValue() == searched) {
                return searching;
            }
            searching = searching.getNext();
        }
        return null;
    }

    public boolean isOrdered(boolean ascending) {
        DoublyListNode ordering = head;
        Integer previousValue = null;

        while (ordering != null) {
            previousValue = ordering.getValue();
            ordering = ordering.getNext();
            if (ordering != null) {
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

    public void reverse() { // {1,2,3} -> {3,2,1}
        DoublyListNode currentElement = head;
        DoublyListNode nextElement = null;
        while (currentElement != null) {
            nextElement = currentElement.getPrevious();
            currentElement.setPrevious(currentElement.getNext());
            currentElement.setNext(nextElement);
            currentElement = currentElement.getPrevious();
        }
        if(nextElement != null){
            this.setHead(nextElement.previous);
        }
    }

    public void delete(DoublyListNode nodeDelete) {
        DoublyListNode nodeToBeDeleted = getHead();
        DoublyListNode lastNode = getTail();
        DoublyListNode previousNode = null;
        if (nodeToBeDeleted == nodeDelete) {
            head = head.getNext();
            return;
        } else if (nodeDelete == lastNode) {
            lastNode = lastNode.getPrevious();
            lastNode.setNext(null);
        }
        while (nodeToBeDeleted != null) {
            if (nodeToBeDeleted != nodeDelete) {
                previousNode = nodeToBeDeleted;
                nodeToBeDeleted = nodeToBeDeleted.getNext();
            } else {
                previousNode.setNext(nodeToBeDeleted.getNext());
                nodeToBeDeleted.getNext().setPrevious(previousNode);
                break;
            }
        }
    }

    public DoublyListNode getHead() {
        if (isEmpty()) {
            return null;
        }
        return head;
    }

    public void setHead(DoublyListNode head) {
        this.head = head;
    }

    public DoublyListNode getTail() {
        DoublyListNode lastElement = head;
        while (lastElement.getNext() != null) {
            lastElement = lastElement.getNext();
            size++;
        }
        return lastElement;
    }
}
