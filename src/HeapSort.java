
public class HeapSort {

	public static void main(String[] args) {
		int arr[] = {16, 15, 14, 13, 12, 11, 10};
		System.out.println("Heap Sort: \n");
		HeapSort heapSort = new HeapSort();
		heapSort.sort(arr);

		System.out.println("Sorted array is");
		printArray(arr);
	}


	public void sort(int arr[]) {
		int n = arr.length;

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arr, n, i);
		}
		// One by one extract an element from heap
		for (int i = n - 1; i > 0; i--) {
			// Move current root to end
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;

			// call max heapify on the reduced heap
			heapify(arr, i, 0);
		}
	}

	void heapify(int arr[], int n, int i) {
		int smallest = i;
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// left child 
		if (l < n && arr[smallest] < arr[l])
			smallest = l;

		//  right child
		if (r < n && arr[smallest] < arr[r])
			smallest = r;

		// If largest is not root
		if (arr[smallest] > arr[r] || arr[smallest] > arr[l]) {
			int swap = arr[i];
			arr[i] = arr[smallest];
			arr[smallest] = swap;

		}
		if (arr[smallest] < arr[r] && arr[smallest] < arr[l]) {
			System.exit(1);
		}
	}

	//Method to print array
	static void printArray(int arr[]) {
		int n = arr.length;
		for (int i = 0; i < n; ++i)
			System.out.print(arr[i] + " ");
		System.out.println();
	}

}
