package corejavaprograms;

import java.util.Stack;
import java.util.Scanner;
public class IsBalancedDemonstration
{

	public static void main(String[ ] args)
	{
		Scanner stdin = new Scanner(System.in);
		String expression;

		System.out.print("Your string: ");
		expression = stdin.nextLine( );
		if (isBalanced(expression))
			System.out.println("That is balanced.");
		else
			System.out.println("That is not balanced.");
		stdin.close();
	}
	public static boolean isBalanced(String expression)
	{
		final char LEFT_NORMAL  = '(';
		final char RIGHT_NORMAL = ')';
		final char LEFT_CURLY   = '{';
		final char RIGHT_CURLY  = '}';
		final char LEFT_SQUARE  = '[';
		final char RIGHT_SQUARE = ']';

		Stack<Character> store = new Stack<Character>( ); // Stores parens
		int i;                              // An index into the string
		boolean failed = false;             // Change to true for a mismatch

		for (i = 0; !failed && (i < expression.length( )); i++)
		{
			switch (expression.charAt(i))
			{
			case LEFT_NORMAL:
			case LEFT_CURLY:
			case LEFT_SQUARE: 
				store.push(expression.charAt(i));
				break;
			case RIGHT_NORMAL:
				if (store.isEmpty( ) ||( !(store.pop( ) == LEFT_NORMAL)))
					failed = true;
				break;
			case RIGHT_CURLY:
				if (store.isEmpty( ) || (store.pop( ) != LEFT_CURLY))
					failed = true;
				break;
			case RIGHT_SQUARE:
				if (store.isEmpty( ) || (store.pop( ) != LEFT_SQUARE))
					failed = true;
				break;
			}
		}

		return (store.isEmpty( ) && !failed);
	}

}