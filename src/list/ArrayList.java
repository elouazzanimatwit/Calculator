package list;

import java.util.Arrays;
import java.util.concurrent.RejectedExecutionException;

public class ArrayList <T> implements ListInterface <T>{
	private T[] list;
	private int numberOfEntries;
	private int length;
	private static final int DEFAULT_CAPACITY = 10;
	private static final int MAX_CAPACITY = 100;
	
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}

	@SuppressWarnings("unchecked")
	public ArrayList(int length) {
		if(length < DEFAULT_CAPACITY) {
			length = DEFAULT_CAPACITY;
		}
		list = (T[]) new Object[length];
		numberOfEntries = 0;
		this.length = length;
	}
	
	private void checkCapacity() {
		if(length > MAX_CAPACITY) {
			throw new RejectedExecutionException("Capacity too big");
		}
	}

	@Override
	public void add(T newEntry) {
		list[numberOfEntries ++] = newEntry;
		
	}

	@Override
	public void add(int newPosition, T newEntry) {
		list[newPosition] = newEntry;
		numberOfEntries ++;
		ensureCapacity();
	}

	private void ensureCapacity() {
		if(isFull()) {
			list = Arrays.copyOf(list, length*2);
			length *= 2;
		}
	}

	private boolean isFull() {
		return length == numberOfEntries;
	}

	@Override
	public int getLength() {
		return length;
	}

	@Override
	public T remove(int givenPosition) {
		
		
		return list[givenPosition];
	}
	
	public void makeRoom (int position) {
		for(int i = numberOfEntries; i > position; i--)
			list[i] = list[i-1];
	}

	@Override
	public boolean remove(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T replace(int givenPosition, T newEntry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getEntry(int givenPosition) {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}

	@Override
	public boolean contains(T anEntry) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object[] toArray() {
		@SuppressWarnings("unchecked")
		Object[] result = (T[]) new Object[numberOfEntries];
		for(int i = 0; i < numberOfEntries; i++) {
			result[i] = list[i];
		}
		return result;
	}

}
