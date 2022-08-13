package GenericCircularListWithQueueStack;

public class StackCircularLinkedList<T> implements IStack<T> {

    private CircularLinkedList<T> list; 
    
        public StackCircularLinkedList(){
            this.list = new CircularLinkedList<T>();
        }
    
        public boolean isEmpty() {
            return this.list.isEmpty();
        }
    
        public T pop() throws Exception {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is Empty");
            }
            CircularListNode<T> tail = this.list.getTail();
            this.list.delete(tail);
            return tail.getValue();
        }
    
        @Override
        public void push(T key) {
            this.list.addLast(key);
        }
    
    }
    