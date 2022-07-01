// Vincenzo D'Aria
// CS 253
// Homework 1 - binary search

public class BinaryRecursive {
	int binarySearch(int arr[], int l, int r, int target) {
		if (r >= l && l <= arr.length - 1) {
			int mid = l + (r - l) / 2;
			// If the element is at the middle 
			if (arr[mid] == target) {
				return mid;
			}
			// go left
			if (arr[mid] > target) {
				return binarySearch(arr, l, mid - 1, target);
			}
			//go right
			return binarySearch(arr, mid + 1, r, target);
		}
		//else, return -1
		return -1;
	}

	// Main Method
	public static void main(String args[]) {

		// Creating object instance of above class
		BinaryRecursive binary = new BinaryRecursive();

		int arr[] = {10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20};

		// Length of array
		int n = arr.length;

		//target value
		int target = 16;

		int result = binary.binarySearch(arr, 0, n - 1, target);

		if (result == -1) {
			System.out.println("Element not present");
		} else {
			System.out.println("Element " + target + " found at index " + result);
		}

	}

}
