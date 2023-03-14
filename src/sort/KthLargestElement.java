package sort;

import java.util.Scanner;

public class KthLargestElement {

    // Quick select to find kth largest element

    // Returns the k-th largest element of list within left..right inclusive
    // (i.e. left <= k <= right).
    public int findKthElementByQuickSelect(int[] arr, int left, int right, int k) {
        if (k >= 0 && k <= right - left + 1) {
            int pos = partition(arr, left, right);
            if (pos - left == k) {
                return arr[pos];
            }
            if (pos - left > k) {
                return findKthElementByQuickSelect(arr, left, pos - 1, k);
            }
            return findKthElementByQuickSelect(arr, pos + 1,
                    right, k - pos + left - 1);
        }
        return 0;
    }

    public int partition(int[] arr, int left, int right) {
        int pivot = arr[right], i = left;
        for (int j = left; j <= right - 1; j++) {
            if (arr[j] >= pivot) {                           // if (arr[j] <= pivot) for kth smallest
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, right);
        return i;
    }

    public void swap(int[] arr, int n1, int n2) {
        int temp = arr[n2];
        arr[n2] = arr[n1];
        arr[n1] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {100, 50, 20, 30, 10, 40, 70, 80, 65, 5};

        KthLargestElement kthLargestElement = new KthLargestElement();

        Scanner scanner = new Scanner(System.in);

        int k = scanner.nextInt();

        int kthLargest = kthLargestElement.findKthElementByQuickSelect(arr, 0, arr.length-1, k);

        System.out.println("\n "+k+"th Largest Element ="+kthLargest);
    }
}
