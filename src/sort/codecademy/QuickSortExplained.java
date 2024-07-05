package sort.codecademy;

import sort.common.CommonUtility;

import java.util.Arrays;

public class QuickSortExplained extends CommonUtility {

    public int[] quickSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        return quickSort(arr, 0, arr.length - 1);
    }

    public int[] quickSort(int[] arr, int start, int end) {
        if (end > start) {
            int partition = partition(arr, start, end);
            if (start < partition) {
                quickSort(arr, start, partition);
            }
            if (partition + 1< end) {
                quickSort(arr, partition + 1, end);
            }
        }
        return arr;
    }

    public int partition(int[] arr, int leftPointer, int rightPointer) {
        System.out.println("Partitioning the current subarray:");
        System.out.println(Arrays.toString(Arrays.copyOfRange(arr, leftPointer, rightPointer + 1)));

        int pivot = arr[Math.floorDiv((leftPointer + rightPointer), 2)];
        System.out.println("The pivot value is: " + pivot);

        while (leftPointer < rightPointer) {
            while (arr[leftPointer] < pivot) {
                leftPointer++;
                System.out.println("Incrementing left pointer to " + arr[leftPointer]);
            }
            while (arr[rightPointer] > pivot) {
                rightPointer--;
                System.out.println("Decrementing right pointer to " + arr[rightPointer]);
            }
            if (leftPointer < rightPointer) {
                System.out.println("Swapping " + arr[leftPointer] + " and " + arr[rightPointer]);
                swap(arr, leftPointer, rightPointer);
            }
        }
        return leftPointer;
    }
}
