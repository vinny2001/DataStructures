import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Homework1 {

	//Bubble Sort Method
	public static void bubbleSort(int array[]) throws IOException {
		//output = text file that sorted elements will be stored in later
		PrintWriter output = new PrintWriter(new FileWriter("sorted.txt"));
		int length = array.length;
		int comparisons = 0;
		int exchanges = 0;
		boolean condition = true;

		//iterating through the data
		for (int i = 1; i != length; i++) {
			if (condition) {
				condition = false;
				for (int j = 0; j != length - i; j++) {
					comparisons++;
					if (array[j] > array[j + 1]) {
						//swapping arr[j+1] and arr[j]
						int temp = array[j];
						array[j] = array[j + 1];
						array[j + 1] = temp;
						condition = true;
						exchanges++;
					}
				}
			} else {
				break;
			}
		}
		//Prints the sorted array to the text file
		for (int i = 0; i < array.length; i++) {
			output.println(array[i]);
		}
		System.out.println("Bubble Sort:\n");
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Exchanges: " + exchanges + "\n");
		output.close();
	}

	//End bubbleSort
	//-----------------------------------------------------------------------------------------------------
	//Selection Sort Method
	public static void selectionSort(int array[]) throws IOException {
		//output = text file that sorted elements will be stored in later
		PrintWriter output = new PrintWriter(new FileWriter("sorted.txt"));
		int comparisons = 0;
		int exchanges = 0;
		for (int i = 0; i < array.length - 1; i++) {
			int index = i;
			for (int j = index + 1; j != array.length; j++) {
				comparisons++;
				if (array[j] < array[index]) {
					index = j;
				}
			}
			int temp = array[index];
			array[index] = array[i];
			array[i] = temp;
			exchanges++;
		}
		for (int i = 0; i < array.length; i++) {
			output.println(array[i]);
		}
		System.out.println("Selection Sort:\n");
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Exchanges: " + exchanges + "\n");
		output.close();
	}

	//End Selection Sort
	//-----------------------------------------------------------------------------------------------------
	//Insertion Sort Method
	public static void insertionSort(int arr[]) throws IOException {
		//output = text file that sorted elements will be stored in later
		PrintWriter output = new PrintWriter(new FileWriter("sorted.txt"));
		int exchanges = 0;
		int comparisons = 0;
		int length = arr.length;
		for (int i = 1; i < length; i++) {
			int temp = arr[i];
			int j = i - 1;
			while (j > -1 && arr[j] > temp) {
				arr[j + 1] = arr[j];
				j--;
				comparisons++;
				exchanges++;
			}
			arr[j + 1] = temp;
		}
		for (int i = 0; i < length; i++) {
			output.println(arr[i]);
		}
		System.out.println("Insertion Sort:\n");
		System.out.println("Comparisons: " + comparisons);
		System.out.println("Exchanges: " + exchanges + "\n");
		output.close();
	}

	//End Insertion Sort

	//-----------------------------------------------------------------------------------------------------

	//Main method for testing
	//** BEFORE RUNNING: Run one of the source files to generate large or prototype data ** 

	public static void main(String[] args) throws IOException {

		//Scanner gathers raw data to be sorted from txt file after it was generated
		Scanner inputFile = new Scanner(new File("output.txt"));
		int iterator = 0;

		//Adjust array size with size of data list.
		int array[] = new int[2000];

		//parse txt data out into an integer array
		while (inputFile.hasNextInt()) {
			array[iterator++] = inputFile.nextInt();
		}

		//Can easily plug a sort algorithm in

		//bubbleSort(array);
		//selectionSort(array);
		insertionSort(array);


		//Scanner closed for security
		inputFile.close();
	}

}
