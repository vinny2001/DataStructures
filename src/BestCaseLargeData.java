import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class BestCaseLargeData {

	public static void main(String[] args) throws IOException {

		//Provides an input file to write into
		//Scanner input = new Scanner(new File("input.txt"));

		//Defines the output text file that the data will be stored in
		PrintWriter output = new PrintWriter(new FileWriter("output.txt"));

		//Prints out integers 1-2000, delimited by a comma, and stores them in output.txt
		long startTime = System.currentTimeMillis();
		for (int i = 1; i <= 2000; i++) {
			output.println(i);
		}
		long endTime = System.currentTimeMillis();
		long timeDiff = endTime - startTime;
		//Prints when operation completes
		System.out.println("Operation Complete in " + timeDiff + " millisec.");
		//PrintWriter closed to prevent security vulnerabilities
		output.close();
	}

}
