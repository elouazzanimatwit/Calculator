package LetterStacking;
import java.util.List;
import java.util.ArrayList;

public class Stacks<T> implements StackInterface<T>{


	int top = -1;
	int stack;
	
	
	private boolean isFull() {
		if(top >= stack)
	    {
	        return true;
	    }
	    else
	    {
	        return false;
	    }
	}
	
	public boolean isEmpty() {
		
		if(top < 0)
			return true;
		else
			return false;
	}

	
	public void peek() {
		return stack[top];
	}

	
	public void pop() {
		boolean control = isEmpty();
		if(control == false) {
			top = top - 1;
		}
		
	}

	
	public void push() {
		boolean control = isFull();
		if(control == false) {
			top = top + 1;
			stack[top] = item;
		}
	}
	
	
}
