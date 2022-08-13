package GenericCircularListWithQueueStack;

public interface IQueue<Value> {

	public void enqueue(Value key);

	public Value dequeue() throws Exception;

	public boolean isEmpty();

}