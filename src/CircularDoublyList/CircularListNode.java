package CircularDoublyList;

public class CircularListNode {
    private CircularListNode previous;
    private CircularListNode next;
    private Integer value;

    public CircularListNode(Integer value, CircularListNode previous, CircularListNode next) {
        this.value = value;
        this.previous = previous;
        this.next = next;
    
    }

    public int getValue() {
        return this.value;
    }
    public void setValue(Integer value) {
        this.value = value;
    }

    public CircularListNode getPrevious() {
        return this.previous;
    }

    public void setPrevious(CircularListNode previous) {
        this.previous = previous;
    }
    
    public CircularListNode getNext() {
        return this.next;
    }
    
    public void setNext(CircularListNode next) {
        this.next = next;
    }

}
