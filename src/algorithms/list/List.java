package algorithms.list;

public interface List {
	
	public void add(Object object);
	
	public void add(int index, Object object);
	
	public Object get(int index);
	
	public void remove(int index);
	
	public boolean contains(Object object);
	
	public int size();
	

}
