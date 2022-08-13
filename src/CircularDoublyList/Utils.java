package CircularDoublyList;

public class Utils {

    public static boolean isPalindrome(DoublyLinkedList list) {
        DoublyListNode head = list.getHead();
        DoublyListNode tail = list.getTail();
       
        if (list.size() == 1) { // {1} - is palidrome
            return true;
        }
        if (head.getValue() != tail.getValue()) { 
            return false;
        }
        while(head.getNext().getValue() == tail.getPrevious().getValue()) {
            if (head.getValue() == tail.getValue()) {
                return true;
            }
        }
      
      
        return false;
    }

}
