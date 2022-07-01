import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RandomLargeData {
	public static void main(String[] args) throws IOException {

		//Instance variables to define a range
		int max = 2000;
		int min = 1;
		int range = max - min + 1;

		//For writing to the output text file
		PrintWriter output = new PrintWriter(new FileWriter("output.txt"));

		//Starts tracking time
		long startTime = System.currentTimeMillis();
		//Loops 2000 times, creates new random integer each time, puts it in a new line in the output text file
		for (int i = min; i <= max; i++) {
			int rand = (int) (Math.random() * range) + min;
			output.println(rand);
		}
		//Ends time tracking and calcuates time elapsed
		long endTime = System.currentTimeMillis();
		long timeDiff = endTime - startTime;

		//Result is complete
		System.out.println("Operation Complete in " + timeDiff + " millisec.");
		//PrintWriter closed to prevent vulnerabilities
		output.close();
	}

}
