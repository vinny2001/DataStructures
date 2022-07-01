// Vincenzo D'Aria
// CS-253
//
//
//
// Infix to Postfix using operator stack, infix queue, and postfix queue
// Then, postfix expression is evaluated using value stack
//
//
//

import java.util.Scanner;

public class Homework3Part1 {

	// Data Structures needed for the conversions & operations
	static StackLL operatorStack = new StackLL();
	static QueueLL postfixQ = new QueueLL();
	static QueueLL infixQ = new QueueLL();
	static StackLL valueStack = new StackLL();

	//given a non-operand token, returns an integer associated with its priority 
	protected static int infixPriority(char c) {
		switch (c) {
			case '(':
				return 3;
			case '*':
				return 2;
			case '/':
				return 2;
			case '+':
				return 1;
			case '-':
				return 1;
			case ')':
				return 0;
			case '#':
				return 0;
			default:
				return 0;
		}
	}

	//given a token returns integer associated with its priority 
	protected static int stackPriority(char c) {
		switch (c) {
			case '(':
				return 3;
			case '*':
				return 2;
			case '/':
				return 2;
			case '+':
				return 1;
			case '-':
				return 1;
			case ')':
				return 0;
			case '#':
				return 0;
			default:
				return 0;
		}
	}

	//to check if the input character
	// is an operator or a '('
	public static boolean isOperator(char input) {
		switch (input) {
			case ')':
				return true;
			case '+':
				return true;
			case '-':
				return true;
			case '*':
				return true;
			case '%':
				return true;
			case '/':
				return true;
			case '(':
				return true;
			default:
				return false;
		}
	}


	//Code infixToPostfix (the hard part)
	public static void infix2postfix(String exp) {
		operatorStack.push('#');
		//enqueue the infix expression onto a queue
		for (int i = 0; i < exp.length(); i++) {
			char infixChar = exp.charAt(i);
			infixQ.enqueue(infixChar);
		}

		//Run while the infix queue still has character tokens
		while (infixQ.front != null) {
			//current infix token to be compared
			char deq = infixQ.dequeue();
			//if the token is an operand
			if (!isOperator(deq)) {
				//enqueues the operand onto postfix queue
				postfixQ.enqueue(deq);
				//if the token is #
				if (deq == '#') {
					for (int opstk = 0; opstk < operatorStack.length(); opstk++) {
						//pop all remaining entries on operator stack
						char popOp = operatorStack.pop().getData();
						//enqueue onto postfix
						postfixQ.enqueue(popOp);
					}
				}
				//if token is a left parenthesis
			} else if (deq == '(') {
				//DO NOTHING TO DEQUEUE, the statement that defines deq dequeues the token already
				operatorStack.push(deq);

				// if token is a right parenthesis
			} else if (deq == ')') {
				while (operatorStack.peek().getData() != '(') {
					char topStk = operatorStack.peek().getData();
					operatorStack.pop();
					postfixQ.enqueue(topStk);
				}
				operatorStack.pop();
			} else {
				//Condition runs if the token is an operator
				//(Gets pushed onto operator stack)
				//push operators onto operator stack based on priority
				//
				//if the precedence of current token > next token
				if (infixPriority(deq) > stackPriority(operatorStack.peek().getData())) {
					operatorStack.push(deq);
				} else if (infixPriority(deq) <= stackPriority(operatorStack.peek().getData())) {
					for (int o = 0; o < operatorStack.length(); o++) {
						char popTop = operatorStack.peek().getData();
						if (popTop == '(') {
							//Do Nothing
						} else {
							operatorStack.pop();
							postfixQ.enqueue(popTop);
						}
					}
					operatorStack.push(deq);
				}

			}

		}
		for (int o = 0; o < operatorStack.length(); o++) {
			if (infixQ.next == null) {
				char opToPost = operatorStack.peek().getData();
				operatorStack.pop();
				postfixQ.enqueue(opToPost);
			} else {
				operatorStack.pop();
			}

		}

	}

	//Evaluate postfix using value stack
	public static int evaluatePostfix(QueueLL post) {

		// Scan all characters one by one
		while (post.front != null) {
			//current character being evaluated is dequeued from the 'cloned' postfix queue
			char c = post.dequeue();

			// If the scanned character is an operand (number here),
			// push it to the stack.
			if (!isOperator(c)) {
				valueStack.push(c - '0');
			}

			//  If the scanned character is an operator, pop two
			// elements from stack apply the operator
			else {
				int val1 = valueStack.next.getIntData();
				valueStack.pop();
				int val2 = valueStack.next.getIntData();
				valueStack.pop();

				//Based on the current operator, the two elements are evaluated 
				//according to the following cases:
				switch (c) {
					case '+':
						valueStack.push(val2 + val1);
						break;

					case '-':
						valueStack.push(val2 - val1);
						break;

					case '/':
						valueStack.push(val2 / val1);
						break;

					case '*':
						valueStack.push(val2 * val1);
						break;

				}
			}
		}
		return valueStack.next.getIntData();
	}

	//Main
	public static void main(String[] args) {
		//Scanner to take in infix expression
		Scanner scan = new Scanner(System.in);
		//Queue that 'clones' the postfix queue. Used when evaluating the postfix expression.
		//Since postfix queue is dequeued when returning postfix expression, this queue is used in its place
		QueueLL evalQ = new QueueLL();

		//Enter the infix expression with the scanner
		System.out.print("Enter Infix Expression: ");
		String exp = scan.nextLine();

		//Convert from infix to postfix
		infix2postfix(exp);

		System.out.print("Postfix: ");
		//Complete for the size of the postfix queue
		int i = 0;
		while (i < postfixQ.size() && postfixQ.front != null) {
			//As the postfix queue is dequeued, the 'cloned' queue is enqueued
			char post = postfixQ.dequeue();
			evalQ.enqueue(post);
			//if the current character is a # (placeholder), then delete it
			if (post == '#') {
				postfixQ.delete(post);
			}
			//print the postfix queue expression
			System.out.print(post);
		}

		//Evaluates and returns Postfix expression using 'cloned' postfix queue
		evaluatePostfix(evalQ);
		System.out.print("\nEvaluated Postfix Expression: ");
		System.out.print(valueStack.next.getIntData());

		//Scanner closed for security
		scan.close();
	}
}
