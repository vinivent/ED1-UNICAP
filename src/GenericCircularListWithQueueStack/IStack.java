package GenericCircularListWithQueueStack;

public interface IStack<Value> {

	public boolean isEmpty();

	public void push(Value key);

	public Value pop() throws Exception;
}
