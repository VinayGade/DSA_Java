package search;

class BinarySearch {

	//Precise Binary Search
	public int search(int[] arr, int target) {
		int left = 0;
		int right = arr.length;
		while (left < right) {
			int mid = Math.floorDiv(left + right, 2);
			int midValue = arr[mid];
			if (midValue == target) {
				return mid;
			} else if (midValue < target) {
				left = mid + 1;
			} else {
				right = mid;
			}
		}
		return -1;
	}

	public int binarySearch(int a[], int low, int high, int key) {

		if (low <= high) {
			int mid = (low + high) / 2;
			if (a[mid] == key)
				return mid;
			else if (key < a[mid])
				return binarySearch(a, low, mid - 1, key);
			else
				return binarySearch(a, mid + 1, high, key);
		} else
			return -1;
	}

	// efficient    iterative >= recursive
	// recursive call incurs more overhead. O(log N) extra space.
	public int binarySearchIterative(int arr[], int n, int k) {
		if(k<arr[0] || k>arr[n-1]) {
			return -1;
		}
		else{
			int low = 0;
			int high = n-1;
			while(low <= high){
				int mid = (high + low) / 2;
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

	// Efficiency :  Ternary Search >= Binary Search
	public int ternarySearch(int arr[], int N, int K)
	{
		// mid1, mid2

		int l=0;
		int r=N-1;

		while(l<=r){

			int mid1=l+(r-l)/3;
			int mid2=r-(r-l)/3;

			if(K == arr[mid1])
				return mid1;
			else if(K == arr[mid2])
				return mid2;
			else if(K < arr[mid1])
				r=mid1-1;
			else if(K > arr[mid2])
				l=mid2+1;
			else{
				l=mid1+1;
				r=mid2-1;
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
		int key2 = 80;
		BinarySearch search = new BinarySearch();

		int index = search.binarySearch( array, low, high, key);

		int i = search.ternarySearch(array, array.length, key2);

		System.out.println("Element "+key+" found at "+index+ " position");
		System.out.println("Using Ternary Search Element "+key2+" found at "+i+ " position");

		int idx = search.search(array, key);
		System.out.println("target "+key+" found at "+idx+ " position");
	}
}