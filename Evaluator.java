package stack;

import java.util.Scanner;
import java.util.Stack; 

//Some code below is commented out. 
//It can be uncommented after the method convert is implemented 
//in the class Conversion.


public class Evaluator {
	
	public static double evalPostfix (String postfix) {
    	Stack <Double> valueStack = new Stack <>();
    	int n = postfix.length();
    	double result;
    	char ch; 
    	for (int i = 0; i < n; i ++) {
    		ch = postfix.charAt(i);
    		if (Character.isDigit(ch)){  			
    			valueStack.push ((double)(ch - '0'));
    		}
    		else if (isOperator (ch)) {
    			double operand2 = valueStack.pop();
    			double operand1 = valueStack.pop();
    			result = operation (ch, operand1, operand2);
    			valueStack.push (result);
    		}
    		else
    			continue;
    	}
    	
    	result = valueStack.pop();
    	assert (valueStack.isEmpty());
    	return result;
    }
    
    public static boolean isOperator (char ch) {
    	return (ch =='+' || ch == '-' || ch == '*' || ch == '/' || ch == '^');
    }
    
    public static double operation (char op, double operand1, double operand2) {
    	switch (op) {
    	case '+': return operand1 + operand2;
    	case '-': return operand1 - operand2;
    	case '*': return operand1 * operand2;
    	case '/': return operand1 / operand2;
    	case '^': return Math.pow(operand1, operand2);
    	default: throw new IllegalArgumentException ("Wrong operation: check the code or input");
    	}
    }
    
    
//    public static double evalInfix (String infix) {
//    	String postfix = Conversion.convert (infix);
//    	return evalPostfix (postfix);
//    }
    

	public static void main(String[] args) {
		Scanner input = new Scanner (System.in);
		System.out.print ("Enter a postfix expression: ");		
//		System.out.print ("Enter a infix expression: ");
    	String expression = input.nextLine();
//		double res = evalInfix (expression);
    	double res = evalPostfix (expression);
    	System.out.println ("The result is " + res);

	}

}
