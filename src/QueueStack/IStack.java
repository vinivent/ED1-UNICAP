package QueueStack;

public interface IStack {

	public void push(Integer value);

	public Integer pop() throws IllegalStateException;

	public boolean isEmpty();
}
