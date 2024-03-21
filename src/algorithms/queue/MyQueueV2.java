package algorithms.queue;

public class MyQueueV2<T> implements QueueV2<T>{
	
	private Node front;
	private Node back;
	private int size;
	
	@Override
	public void offer(T element) {
		Node newNode = new Node(element);
		
		if (this.front == null) {
			this.front = newNode;
			this.back = newNode;
		} else {
			this.back.setNext(newNode);
			this.back = newNode;
		}
		
		this.size++;
	}

	@Override
	public T peek() {
		validateListEmpty();
		return this.front.getValue();
	}

	@Override
	public T poll() {
		validateListEmpty();
		T value = this.front.getValue();
		this.front = front.getNext();
		this.size--;
		return value;
	}
	
	public void validateListEmpty() {
		if (this.front == null) {
			throw new RuntimeException("Empty queue");
		}
	}

	@Override
	public int getSize() {
		return this.size;
	}
	
	private class Node {
		private T value;
		private Node next;
		
		public Node(T value) {
			this.value = value;
		}

		public T getValue() {
			return value;
		}

		public void setValue(T value) {
			this.value = value;
		}

		public Node getNext() {
			return next;
		}

		public void setNext(Node next) {
			this.next = next;
		}
	}


}
