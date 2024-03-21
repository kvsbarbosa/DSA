package algorithms.queue;

public interface QueueV1<T> {

	public void push(T t);
	
	public T remove();
	
	public boolean isEmpty();
	
}
