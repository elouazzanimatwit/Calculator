package list;

public interface ListInterface <T>{
	
	public void add (T newEntry);
	
	public void add (int newPosition, T newEntry);
	
	public int getLength();
	
	public T remove (int givenPosition);
	
	public boolean remove(T anEntry);
	
	public void clear();
	
	public T replace (int givenPosition, T newEntry);
	
	public T getEntry (int givenPosition);
	
	public boolean isEmpty();
	
	public boolean contains (T anEntry);

	public Object[] toArray();
}
