package SinglyList;

public class SinglyLinkedList {

    private SinglyListNode head;
   
    public boolean isEmpty() {
    return this.head == null;
    }

    public void addFirst(Integer value) {
        SinglyListNode newElement = new SinglyListNode(value, this.getHead());
        this.setHead(newElement);

    }

    public void addLast(int value) {
        if (this.isEmpty()) {
            this.addFirst(value);

        } else {
            SinglyListNode newTail = new SinglyListNode(value, null);
            SinglyListNode currentTail = head;
            while (currentTail.getNext() != null) {
                currentTail = currentTail.getNext();
            }
            currentTail.setNext(newTail);
        }
    }

    public int size() {
        int size = 0;
        if (this.isEmpty()) {
            return 0;
        } else {
            SinglyListNode lastElement = head;
            while (lastElement.getNext() != null) {
                lastElement = lastElement.getNext();
                size++;
            }
        }
        return size + 1;
    }

    public void delete(SinglyListNode nodeDelete) {
        SinglyListNode previousElement = head;

        if (previousElement == nodeDelete) {
            head = head.getNext();
            return;
        }
        while (previousElement != nodeDelete) {
            if (previousElement.getNext() == nodeDelete) {
                previousElement.setNext(nodeDelete.getNext());
                return;
            }
            previousElement = previousElement.getNext();
        }

    }

    SinglyListNode search(Integer value) {

        SinglyListNode searching = head;
        while (searching != null) {
            if (searching.getValue() == value) {
                return searching;
            }
            searching = searching.getNext();
        }
        return null;
    }

    public void reverse() {
        SinglyListNode currentElement = this.head;
        SinglyListNode nextElement = null;
        SinglyListNode previousElement = null;
        while (currentElement != null) {
            nextElement = currentElement.getNext();
            currentElement.setNext(previousElement);
            previousElement = currentElement;
            currentElement = nextElement;
        }
         this.head = previousElement;
    }

    public boolean isOrdered(boolean ascending) {
        SinglyListNode ordering = head;
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

    private void setHead(SinglyListNode head) {
        this.head = head;
    }

    public SinglyListNode getHead() {
        return this.head;
    }
}
