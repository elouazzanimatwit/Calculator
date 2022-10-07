package Calculator;

import java.util.EmptyStackException;

import utils.Node;

public class linkedStack <T> implements StackInterface <T>{

	private Node <T> topNode;
	
	public linkedStack() {
		topNode = null;
	}
	
	@Override
	public void push(T anEntry) {
		Node <T> toAdd = new Node <>(anEntry);
		topNode = toAdd;
	}

	@Override
	public T pop() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		T outData = topNode.getData();
		topNode = topNode.getNext();
		return outData;
	}

	public boolean isEmpty() {
		return topNode == null;
	}

	@Override
	public T peek() {
		if(isEmpty()) {
			throw new EmptyStackException();
		}
		return null;
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

}
