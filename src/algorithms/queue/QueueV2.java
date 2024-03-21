package algorithms.queue;

public interface QueueV2<T> {
	
	public void offer(T element);
	
	public T peek();
	
	public T poll();
	
	public int getSize();

}
