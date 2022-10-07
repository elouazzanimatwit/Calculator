package Calculator;

import java.util.Arrays;

public class ArrayStack <T> implements StackInterface<T>{

	private T[] stackArray;
	private int numberOfEntries;
	private int capacity;
	public static final int DEFAULT_CAPACITY = 10;
	
	@SuppressWarnings("unchecked")
	public ArrayStack(int capacity) {
		stackArray = (T[]) new Object[capacity];
		numberOfEntries = 0;
		this.capacity = capacity;
	}
	
	public ArrayStack() {
		this(DEFAULT_CAPACITY);
	}
	
	public boolean isEmpty() {
		return numberOfEntries == 0;
	}
	
	@Override
	public void push(T anEntry) {
		stackArray[numberOfEntries++] = anEntry;
		if(isFull()) {
			ensureCapacity();
		}
	}

	private boolean isFull() {
		return numberOfEntries == capacity;
	}

	private void ensureCapacity() {
		capacity *= 2;
		stackArray = Arrays.copyOf(stackArray, capacity);
		
	}

	@Override
	public T pop() {
		T outData = stackArray[numberOfEntries-1];
		stackArray[-- numberOfEntries] = null;
		return outData;
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public void clear() {
		for(int i = 0; i < numberOfEntries; i++) {
			
		}
	}

}
