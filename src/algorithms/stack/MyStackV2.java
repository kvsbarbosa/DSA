package algorithms.stack;

public class MyStackV2<T> implements StackV2<T> {

	private Node top;
	private int size;

	@Override
	public void push(T value) {
		if (this.top == null) {
			this.top = new Node(value, null);
		} else {
			Node node = new Node(value, this.top);
			this.top = node;
		}
		this.size++;
	}

	@Override
	public T pop() {
		if (this.top == null) {
			throw new RuntimeException("Stack is empty");
		}

		T value = this.top.getValue();
		this.top = this.top.getNext();
		this.size--;
		return value;
	}

	@Override
	public T peek() {
		if (this.top == null) {
			throw new RuntimeException("Stack is empty");
		}

		return this.top.getValue();
	}

	@Override
	public int getSize() {
		return this.size;
	}

	private class Node {

		private T value;
		private Node next;

		public Node(T value, Node next) {
			this.value = value;
			this.next = next;
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
