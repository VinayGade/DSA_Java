package heap.quick_select;

public class QuickSelect {

    // Function to find the k-th smallest element in the array
    public static int quickSelect(int[] arr, int k) {
        return quickSelectHelper(arr, 0, arr.length - 1, k - 1);
    }

    // Helper function to perform the quick select
    private static int quickSelectHelper(int[] arr, int left, int right, int k) {
        if (left == right) { // If the list contains only one element
            return arr[left];
        }

        // Select a pivotIndex between left and right
        int pivotIndex = partition(arr, left, right);

        // The pivot is in its final sorted position
        if (k == pivotIndex) {
            return arr[k];
        } else if (k < pivotIndex) {
            // Recur on the left side of the pivot
            return quickSelectHelper(arr, left, pivotIndex - 1, k);
        } else {
            // Recur on the right side of the pivot
            return quickSelectHelper(arr, pivotIndex + 1, right, k);
        }
    }

    // Partition function similar to QuickSort
    private static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr[j] <= pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    // Function to swap two elements in the array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Main function to test the implementation
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 5, 4};
        int k = 4;

        int result = quickSelect(arr, k);
        System.out.println(k + "-th smallest element is " + result);
    }
}
