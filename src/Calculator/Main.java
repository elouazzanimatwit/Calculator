package Calculator;

import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		do{
			String infix;
			System.out.println(infix = input.nextLine() + "\n C < Q / \n 7 8 9 * \n 4 5 6 - \n 3 2 1 + \n 0 ( ) =");
			
			System.out.println(Evaluator.evalInfix(infix));
			System.out.println(Conversion.convert(infix));
			
		}while(true);
	}
}
