import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Homework4 extends Homework1 {

	protected static int comparisons = 0;
	protected static int exchanges = 0;

	//----- Shell Sort ----- 

	//Insertion Sort Portion of the Code
	public static void segmentedInsertionSort(int array[], int numberOfElements,
			int distanceBetween) {
		for (int i = distanceBetween; i < numberOfElements; i++) {
			int current = array[i];
			int j = i;
			while (j > distanceBetween - 1 && (array)[j - distanceBetween] > current) {
				comparisons++;
				array[j] = array[j - distanceBetween];
				j = j - distanceBetween;
				exchanges++;
			}
			array[j] = current;
		}
	}

	//The Shell Sort piece: divide and conqueror based on the interval sequence (which can be changed)
	public static void shellSort(int array[], int numberOfElements) {
		numberOfElements = array.length;
		int distanceBetween = numberOfElements / 2;
		while (distanceBetween > 0) {
			segmentedInsertionSort(array, numberOfElements, distanceBetween);
			distanceBetween = distanceBetween / 2;
		}
	}

	// --- Merge Sort ---

	//Defines how the sub-arrays compare & swap elements, and how sub-arrays merge
	public static void merge(int[] a, int[] subArr1, int[] subArr2, int left, int right) {
		int s1 = 0;
		int s2 = 0;
		int k = 0;

		while (s1 < left && s2 < right) {
			if (subArr1[s1] <= subArr2[s2]) {
				a[k++] = subArr1[s1++];
			} else {
				exchanges++;
				a[k++] = subArr2[s2++];
			}
		}
		while (s1 < left) {
			a[k++] = subArr1[s1++];
			comparisons++;
		}
		while (s2 < right) {
			a[k++] = subArr2[s2++];
			comparisons++;
		}
	}

	//Recursive piece of Merge Sort
	public static void mergeSort(int[] a, int n) {
		//Base Case: If array is 1 element long, just return the array
		if (n < 2) {
			return;
		}
		//Sub arrays created based off size of source array
		int mid = n / 2;
		int[] subArr1 = new int[mid];
		int[] subArr2 = new int[n - mid];
		//Elements from their sub arrays placed in the appropriate spot of destination array
		for (int i = 0; i < mid; i++) {
			subArr1[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			subArr2[i - mid] = a[i];
		}
		//Sort Elements in 1st sub array
		mergeSort(subArr1, mid);
		//Sort Elements in 2nd sub array
		mergeSort(subArr2, n - mid);
		//Merge the arrays and elements together 
		merge(a, subArr1, subArr2, mid, n - mid);
	}

	// ------ Heap Sort & Supporting Methods ------

	public static boolean precedes(int one, int two) {
		if (one < two) {
			return true;
		} else {
			return false;
		}
	}

	//downHeap Method
	public static void downHeap(int arr[], int j, int y) {
		boolean foundSpot = false;
		int n = y;
		int l = j;
		int key = arr[l];
		int k = 2 * l;
		while (k <= n && !foundSpot) {
			if (k < n && !precedes(arr[k + 1], arr[k])) {
				k = k + 1;
				comparisons++;
			}
			if (!precedes(arr[k], key)) {
				comparisons++;
				exchanges++;
				arr[l] = arr[k];
				l = k;
				k = 2 * l;
			} else {
				foundSpot = true;
			}
		}
		arr[l] = key;
	}

	//Heap Sort
	public static void heapSort(int arr[]) {
		int temp = 0;
		int n = arr.length - 1;
		int y = n / 2;
		while (y > 0) {
			downHeap(arr, y, n);
			y--;
		}
		y = n;
		while (y > 1) {
			exchanges++;
			temp = arr[1];
			arr[1] = arr[y];
			arr[y] = temp;
			y--;
			downHeap(arr, 1, y);
		}
	}

	//Method to print array
	static void printArray(int arr[]) {
		int n = arr.length - 1;
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	//--- Main Method --- 

	public static void main(String[] args) throws IOException {

		//Scanner gathers raw data to be sorted from txt file after it was generated
		Scanner inputFile = new Scanner(new File("output.txt"));

		int iterator = 1;

		//Adjust array size based on list size
		//----------------------------------------

		//ADJUSTED TO SIZE + 1**
		int array[] = new int[17];
		//int array[] = new int[2001];


		//parse txt data out into an integer array
		//-----------------------------------------
		while (inputFile.hasNextInt()) {
			array[iterator++] = inputFile.nextInt();
		}

		//Can easily plug in each sorting algorithm
		//-----------------------------------------

		//System.out.println("Merge Sort:\n");
		//mergeSort(array, array.length);

		//System.out.println("Shell Sort: \n");
		//shellSort(array, array.length);

		System.out.println("Heap Sort: \n");
		heapSort(array);

		//-----------------------------------------
		System.out.println("Sorted array is");
		printArray(array);
		System.out.println("\nComparisons: " + comparisons + "\nExchanges: " + exchanges);
		//Closes the scanner for security
		inputFile.close();
	}
}
