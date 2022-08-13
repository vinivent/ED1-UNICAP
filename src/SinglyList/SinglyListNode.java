package SinglyList;

public class SinglyListNode {

    private Integer value;
    private SinglyListNode next;

    public SinglyListNode(Integer valueAdded, SinglyListNode next) {
        this.next = next;
        this.value = valueAdded;
        }

    public Integer getValue() {
        return value;
    }

    public SinglyListNode getNext() {
        return next;
    }
    
    public void setValue(Integer value) {
        this.value = value;
    }

    public void setNext(SinglyListNode next){
        this.next = next;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof SinglyListNode)) {
            return false;
        }
        return true;
    }

  }
