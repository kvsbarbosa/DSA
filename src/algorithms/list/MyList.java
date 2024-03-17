package algorithms.list;

public class MyList implements List {

	private Object[] objects = new Object[100];
	private int totalObjects = 0;
	
	private boolean occupiedIndex(int index) {
		return index >= 0 && index < this.totalObjects;
	}

	private boolean validIndex(int index) {
		return index >= 0 && index <= this.totalObjects;
	}
	
	public void addSpace() {
		if (this.totalObjects == this.objects.length) {
			Object[] newArray = new Object[this.objects.length * 2];
			for (int i = 0; i < this.objects.length; i++) {
				newArray[i] = this.objects[i];
			}
			
			this.objects = newArray;
		}
	}
	
	public void add(Object object) {
		this.addSpace();
		this.objects[this.totalObjects] = object;
		this.totalObjects++;
	}


	public void add(int index, Object object) {
		this.addSpace();
		if (!this.validIndex(index)) {
			throw new IllegalArgumentException("Invalid index.");
		}
		
		for (int i = this.totalObjects - 1; i >= index; i--) {
			this.objects[i + 1] = this.objects[i];
		}
		
		this.objects[index] = object;
		this.totalObjects++;

	}


	public Object get(int index) {
	    if (!this.occupiedIndex(index)) {
	        throw new IllegalArgumentException("Invalid index.");
	    }
	    
	    return this.objects[index];
	}


	public void remove(int index) {
		if (!this.occupiedIndex(index)) {
			throw new IllegalArgumentException("Invalid index.");
		}
		
		for (int i = index; i < this.totalObjects - 1; i++) {
			this.objects[i] = this.objects[i + 1];
		}
		
		this.totalObjects--;

	}


	public boolean contains(Object object) {
		for (int i = 0; i < this.objects.length; i++) {
			if (object.equals(this.objects[i])) {
				return true;
			}
		}
		
		return false;
	}

	
	public int size() {
		return this.totalObjects;
	}

	public String toString() {
		if (this.totalObjects == 0) {
			return "[]";
		}
		
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		for (int i = 0; i < this.totalObjects - 1; i++) {
			builder.append(this.objects[i]);
			builder.append(", ");
		}
		
		builder.append(this.objects[this.totalObjects - 1]);
		builder.append("]");
		return builder.toString();
	}
}
