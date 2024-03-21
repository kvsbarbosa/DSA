package algorithms.stack;

public interface StackV2<T> {
	
	public void push(T value);

    public T pop();

    public T peek();

    public int getSize();

}
