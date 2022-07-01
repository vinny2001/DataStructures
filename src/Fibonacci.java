// Vincenzo D'Aria
// CS 253
// Recursive Fibonacci Algorithm of N

public class Fibonacci {
	//Fibonacci method, fib, with integer return type, value 'n'
	static int fib(int n) {
		//Every case less than or equal to 1, simply return as 1
		if (n <= 1) {
			return n;
		} else {
			//Else, return the Fibonacci sequence of int n by calling method fib directly (recursively)
			return fib(n - 1) + fib(n - 2);
		}
	}

	public static void main(String args[]) {
		// n = number to input into Fibonacci sequence
		int n = 5;
		// Fibonacci method ran & computed
		System.out.println("The Fibonacci of " + n + " is " + fib(n));
	}
}
