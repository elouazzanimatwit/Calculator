 package Calculator;

import java.util.Stack;

public class Conversion {
	public void checkBalance(String s) {
		Stack<Character> cstack = new Stack<>();
		boolean isBalanced = true;
		for(int i =0; i<s.length() && isBalanced; i++) {
			char ch = s.charAt(i);
			switch(ch) {
			case'(','[','{':
				cstack.push(ch);
				break;
			case')',']','}':
				if(cstack.isEmpty()){
					isBalanced = false;
				} else {
					char openDelimiter = cstack.pop();
					isBalanced = match(ch, openDelimiter);
				}
			default:
				break;
			}
		}
	}
	
	private boolean match(char od, char cd) {
		return(od == '(' && cd ==')') || (od == '[' && cd ==']') || (od == '{' && cd =='}');
	}
	
	public static boolean isPaired(char first, char second) {
		return(first == '(' && second ==')') || (first == '[' && second ==']') || (first == '{' && second =='}');
	}
	
	public static String convert(String infix) {
		if(!isBalanced(infix)) {
			throw new IllegalArgumentException();
		}
		Stack <Character> opStack = new Stack<>();
		String postFix = "";
		
		char nextCh;
		
		for(int i = 0; i < infix.length(); i++) {
			nextCh = infix.charAt(i);
			if(Character.isLetterOrDigit(nextCh)) {
				postFix += nextCh;
			} else if(nextCh == '(') {
				opStack.push(nextCh);
			} else if(nextCh == '+' || nextCh == '-' || nextCh == '*' || nextCh == '/') {
				while(!opStack.isEmpty() && precedence(nextCh) <= precedence(opStack.peek())) {
					postFix += opStack.pop();
				}
			} else if(nextCh == ')') {
				while(!opStack.isEmpty() && opStack.peek() != '('){
					postFix += opStack.pop();
				}
				opStack.pop();
			} else {
				continue;
			}
		}
		
		while(!opStack.isEmpty()){
			postFix += opStack.pop();
		}
		
		return postFix;
	}

	private static boolean isBalanced(String infix) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < infix.length(); i++) {
            char x = infix.charAt(i);
 
            if (x == '(' || x == '[' || x == '{') {
                // Push the element in the stack
                stack.push(x);
                continue;
            }
 
            
            if (stack.isEmpty())
                return false;
            char check;
            switch (x) {
            case ')':
                check = stack.pop();
                if (check == '{' || check == '[')
                    return false;
                break;
 
            case '}':
                check = stack.pop();
                if (check == '(' || check == '[')
                    return false;
                break;
 
            case ']':
                check = stack.pop();
                if (check == '(' || check == '{')
                    return false;
                break;
            }}
		return true;
	}

	private static int precedence(char ch) {
		int level = 0;
		switch(ch) {
		case'+':
		case'-':
			level = 1;
			break;
		case'*':
		case'/':
			level = 2;
			break;
		case'^':
			level = 3;
			break;
		case'(':
			level = 0;
			break;
			default:
				break;
		}
		
		return level;
	}

}
