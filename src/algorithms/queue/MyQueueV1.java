package algorithms.queue;

import java.util.List;
import java.util.LinkedList;

public class MyQueueV1<T> implements QueueV1<T> {
	
	private List<T> objects = new LinkedList<T>();

	@Override
	public void push(T t) {
		this.objects.add(t);
		
	}

	@Override
	public T remove() {
		return this.objects.remove(0);
	}

	@Override
	public boolean isEmpty() {
		return this.objects.isEmpty();
	}
	
	

}
