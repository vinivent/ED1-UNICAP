package QueueStack;

public class StackArray implements IStack {
    private int[] stack;
    private int top;


    public StackArray(int capacity) {
        this.stack = new int[capacity];
        this.top = -1; // empty stack at position -1
    }

    @Override
    public void push(Integer value) {
        if(this.top == stack.length -1) {
            throw new IllegalStateException("Stack cannot push more than 3 elements");
        }
        else if(this.top < this.stack.length-1) {
            this.stack[++top] = value;
        }
    }

    @Override
    public Integer pop() throws IllegalStateException {
        if (isEmpty()) {   
            throw new IllegalStateException("Queue is Empty");
        } else {
            return this.stack[this.top--];
        }   


    }

    @Override
    public boolean isEmpty() {
        if (top == -1) {
            return true;
        }
        return false;
    }

}