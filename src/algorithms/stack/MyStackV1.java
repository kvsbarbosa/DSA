package algorithms.stack;

import java.util.List;
import java.util.LinkedList;

public class MyStackV1<T> implements StackV1<T>{
	
	private List<T> pecas = new LinkedList<T>();
	
	public void push(T value) {
		this.pecas.add(value);
	}
	
	public T remove() {
		return this.pecas.remove(this.pecas.size() - 1);
	}
	
	public boolean isEmpty() {
		return this.pecas.size() == 0;
		// ou return this.isEmpty();
	}

}
