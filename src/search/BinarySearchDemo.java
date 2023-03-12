package search;

class BinarySearch {

	public int binarySearch(int a[], int low, int high, int key) {

		if (low <= high) {
			int mid = low + (high - low) / 2;
			if (a[mid] == key)
				return mid;
			else if (key < a[mid])
				return binarySearch(a, low, mid - 1, key);
			else
				return binarySearch(a, mid + 1, high, key);
		} else
			return -1;
	}

	public int binarySearchIterative(int arr[], int n, int k) {
		if(k<arr[0] || k>arr[n-1]) {
			return -1;
		}
		else{
			int low = 0;
			int high = n-1;
			while(low <= high){
				int mid = low + (high - low) / 2;
				if(arr[mid] == k)
					return mid;
				else if(k < arr[mid])
					high = mid - 1;
				else
					low = mid + 1;
			}
		}
		return -1;
	}

}

public class BinarySearchDemo{

	public static void main(String args[]){
		int array[] = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

		int low = 0;
		int high = array.length - 1;

		int key = 70;
		BinarySearch search = new BinarySearch();

		int index = search.binarySearch( array, low, high, key);

		System.out.println("Element "+key+" found at "+index+ " position");
	}

}