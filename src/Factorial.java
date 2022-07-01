// Vincenzo D'Aria
// CS 253
// Compute Factorial of N (Recursive Algorithm)

public class Factorial {
	//public method defining the factorial math and it's return value
	public static int factorialIterative(int n) {
		if (n >= 1) {
			return n * factorialIterative(n - 1);
		} else {
			return 1;
		}
	}

	//Main method acting as a program driver
	public static void main(String[] args) {
		int iterative = 3;
		System.out.println("The Factorial of " + iterative + " is " + factorialIterative(iterative));
	}
}
