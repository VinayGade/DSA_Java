package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/*
HackerRank: Find the Median of Unsorted array

The median of a list of numbers is essentially its middle element after sorting.
The same number of elements occur after it as before.
Given a list of numbers with an odd number of elements, find the median.
Tip: Don't use any in-built sorting function.
eg.
input
arr = [5, 3, 1, 2, 4].
median = 3 ,
hence output = 4.
* */

public class MedianUnsortedList {

    //Quick Select
    //time complexity: O(N)
    /*
    Optimized Approach: Quick Select Algorithm Quick Select is a variant of
    the Quick Sort algorithm that selects the k-th smallest element in expected
    O(n) time by partitioning the array around a pivot.

Explanation:
findMedian Function:

Calculates the middle index and calls quickSelect to find the median.

quickSelect Function:

Recursively selects a pivot and partitions the array until the middle index (k) is found.

partition Function:

Selects the last element as a pivot, rearranges the list so that elements ≤ pivot are on the left and greater ones on the right.
    * */

    public static int findMedian(List<Integer> arr) {
        int n = arr.size();
        int midPosition = (n - 1) / 2;
        return quickSelect(arr, 0, n - 1, midPosition);
    }

    private static int quickSelect(List<Integer> arr, int left, int right, int k) {
        if (left == right) {
            return arr.get(left);
        }

        int pivotIndex = partition(arr, left, right);

        if (pivotIndex == k) {
            return arr.get(k);
        } else if (pivotIndex > k) {
            return quickSelect(arr, left, pivotIndex - 1, k);
        } else {
            return quickSelect(arr, pivotIndex + 1, right, k);
        }
    }

    private static int partition(List<Integer> arr, int left, int right) {
        int pivot = arr.get(right);
        int i = left;

        for (int j = left; j < right; j++) {
            if (arr.get(j) <= pivot) {
                Collections.swap(arr, i, j);
                i++;
            }
        }
        Collections.swap(arr, i, right);
        return i;
    }

    // Java 8: streams
    public static int findMedianUsingStream(List<Integer> arr) {
        return arr.stream().sorted().collect(Collectors.toList()).get(Math.round(arr.size()/2));
    }

    //merge sort
    //time complexity: O(N * log N)
    public static int calculateMedian(List<Integer> arr) {

        // merge sort
        int n = arr.size();
        int midPosition = (n - 1)/ 2;
        mergeSort(arr, 0, n-1);
        return arr.get(midPosition);
    }

    static void mergeSort(List<Integer> a, int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort( a, left, mid);
            mergeSort( a, mid+1, right);
            merge(a, left, mid, right);
        }
    }

    private static void merge(List<Integer> a, int left, int mid, int right){

        List<Integer> sorted = new ArrayList<>();
        int i = left;
        int j = mid + 1;
        //int k = 0;
        while(i <= mid && j <= right){
            int x = a.get(i);
            int y = a.get(j);
            if(x < y){
                sorted.add(x);
                i++;
            }else{
                sorted.add(y);
                j++;
            }
            //k++;
        }
        while(i <= mid){
            sorted.add(a.get(i));
            i++;
        }
        while(j <= right){
            sorted.add(a.get(j));
            i++;
        }
    }

    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(5, 3, 1, 2, 4);
        System.out.println("Median: " + findMedian(arr));  // Expected output: 3
    }
}
