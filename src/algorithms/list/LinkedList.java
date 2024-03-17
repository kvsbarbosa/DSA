package algorithms.list;

public class LinkedList implements List {

	private Node head;
	private Node tail;
	private int size;
	
	
	private boolean occupedIndex(int index) {
		return index >= 0 && index < this.size;
	}
	
	
	private Node getNode(int index) {
		if (!this.occupedIndex(index)) {
			throw new IllegalArgumentException("Index out of bounds");
		}
		
		Node now = head;
		for (int i = 0; i < index; i++) {
			now = now.getNext();
		}
		
		return now;
	}

	public void add(Object element) {
		if (this.size == 0) {
			this.addHead(element);
		} else {
			Node newNode = new Node(element);
			this.tail.setNext(newNode);
			newNode.setBefore(newNode);
			this.tail = newNode;
			this.size++;
		}

	}

	public void add(int index, Object element) {
		if (index == 0) {
			this.addHead(element);
		} else if (index == this.size) {
			this.add(element);
		} else {
			Node before = this.getNode(index - 1);
			Node now = before.getNext();
			Node newNode = new Node(before.getNext(), element);
			newNode.setBefore(before);
			before.setNext(newNode);
			now.setBefore(newNode);
			this.size++;
		}

	}

	public void addHead(Object element) {
		if (this.size == 0) {
			Node newNode = new Node(element);
			this.head = newNode;
			this.tail = newNode;
		} else {
			Node newNode = new Node(this.head, element);
			this.head.setBefore(newNode);
			this.head = newNode;
		}
		
		this.size++;
	}

	@Override
	public Object get(int index) {
		return this.getNode(index).getElement();
	}

	@Override
	public void remove(int index) {
		if (!this.occupedIndex(index)) {
			throw new IllegalArgumentException("Index does not exist");
		}
		
		if (index == 0) {
			this.removeHead();
		} else if (index == this.size - 1) {
			this.removeTail();
		} else {
			Node before = this.getNode(index - 1);
			Node now = before.getNext();
			Node next = now.getNext();
			
			before.setNext(next);
			next.setBefore(before);
			
			this.size--;
		}

	}

	public void removeHead() {
		if (!this.occupedIndex(0)) {
			throw new IllegalArgumentException("Index does not exist.");
		}
		
		this.head = this.head.getNext();
		this.size--;
		
		if (this.size == 0) {
			this.tail = null;
		}
	}

	public void removeTail() {
		
		if(!this.occupedIndex(this.size - 1)) {
			throw new IllegalArgumentException("Index does not exist");
		}
		
		if (this.size == 1) {
			this.removeHead();
		} else {
			Node penultimate = this.tail.getBefore();
			penultimate.setNext(null);
			this.tail = penultimate;
			this.size--;
		}
		
	}

	@Override
	public boolean contains(Object object) {
		
		Node now = this.head;
		
		while (now != null) {
			if (now.getElement().equals(object)) {
				return true;
			}
			now = now.getNext();
		}
		
		return false;
		
	}

	@Override
	public int size() {
		return this.size;

	}

	public String toString() {
		if (this.size == 0) {
			return "[]";
		}

		StringBuilder builder = new StringBuilder("[");
		Node actual = head;

		for (int i = 0; i < this.size - 1; i++) {
			builder.append(actual.getElement());
			builder.append(", ");
			actual = actual.getNext();
		}

		builder.append(actual.getElement());
		builder.append("]");
		return builder.toString();
	}

	private class Node {
		private Node next;
		private Node before;
		private Object element;

		public Node(Node next, Object element) {
			this.next = next;
			this.element = element;
		}

		public Node(Object element) {
			this.element = element;
		}

		public void setNext(Node next) {
			this.next = next;
		}
		
		public void setBefore(Node before) {
			this.before = before;
		}

		public Node getNext() {
			return next;
		}
		
		public Node getBefore() {
			return before;
		}

		public Object getElement() {
			return element;
		}
	}
}