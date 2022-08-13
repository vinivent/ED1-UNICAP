package CircularDoublyList;

public class DoublyListNode {

    Integer value;
    public DoublyListNode next;
	public DoublyListNode previous;

    public DoublyListNode(Integer valueAdded, DoublyListNode previous, DoublyListNode next) {
        this.value = valueAdded;
        this.previous = previous;
        this.next = next;
    }

    public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public DoublyListNode getNext() {
		return next;
	}

	public void setNext(DoublyListNode next) {
		this.next = next;
	}

	public DoublyListNode getPrevious() {
		return this.previous;
	}
	
	public void setPrevious(DoublyListNode previous) {
		this.previous = previous;
	}

    @Override
	public boolean equals(Object obj) {
		if (this == obj) { return true;}
		if(obj instanceof DoublyListNode){
			DoublyListNode otherListNode = (DoublyListNode) obj;
			return this.value.equals(otherListNode.value);
		}
		return false;
	}
}
