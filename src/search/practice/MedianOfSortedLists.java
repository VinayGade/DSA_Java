package search.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Median of Array (Lists):

There are two sorted arrays A and B of size m and n respectively.

Find the median of the two sorted arrays ( The median of the array formed by merging both arrays ).

The overall run time complexity should be O(log (m+n)).

NOTE: If the number of elements in the merged array is even, then the median is
the average of n / 2 th and n/2 + 1th element.
For example, if the array is [1 2 3 4], the median is (2 + 3) / 2.0 = 2.5

 Input
A : [1 4 5]
B : [2 3]

Output
3

Explanation
Merged A and B will be : [1, 2, 3, 4, 5]
Its median will be 3
* */
public class MedianOfSortedLists {

    static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b) {
        if (a.size() > b.size())
            return findMedianSortedArrays(b, a);

        //binary search : O(log(M+N))
        int m = a.size();
        int n = b.size();
        int low = 0, high = m;

        while (low <= high) {
            int partitionA = (low + high) / 2;
            int partitionB = (m + n + 1) / 2 - partitionA;

            int maxLeftA = (partitionA == 0) ? Integer.MIN_VALUE : a.get(partitionA - 1);
            int minRightA = (partitionA == m) ? Integer.MAX_VALUE : a.get(partitionA);

            int maxLeftB = (partitionB == 0) ? Integer.MIN_VALUE : b.get(partitionB - 1);
            int minRightB = (partitionB == n) ? Integer.MAX_VALUE : b.get(partitionB);

            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeftA, maxLeftB) + Math.min(minRightA, minRightB)) / 2.0;
                } else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            } else if (maxLeftA > minRightB) {
                high = partitionA - 1;
            } else {
                low = partitionA + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted");
    }

    // using Merging technique
    static double findMedianSortedArrays(final List<Integer> a, final List<Integer> b, int m, int n) {
        // Merge 2 List

        /*
        int m = a.size();
        int n = b.size();
        */

        boolean even = (m + n) % 2 == 0;
        int mid = (m + n) / 2;

        List<Integer> merged = new ArrayList<>();

        int i = 0, j = 0;

        // Merge the two sorted lists
        while (i < m && j < n) {
            if (a.get(i) < b.get(j)) {
                merged.add(a.get(i++));
            } else {
                merged.add(b.get(j++));
            }
        }

        // Add remaining elements from list a
        while (i < m) {
            merged.add(a.get(i++));
        }

        // Add remaining elements from list b
        while (j < n) {
            merged.add(b.get(j++));
        }

        // Return the median based on even or odd length
        return !even ? (double) merged.get(mid) :
                (merged.get(mid) + merged.get(mid - 1)) / 2.0;
    }

    public static void main(String[] args) {
        List<Integer> a = Arrays.asList(1, 4, 5);
        List<Integer> b = Arrays.asList(2, 3);

        double medianUsingMerging = findMedianSortedArrays(a, b, a.size(), b.size());

        System.out.println("median1 = "+medianUsingMerging);

        a = Arrays.asList(10, 20, 50, 60, 100);
        b = Arrays.asList(5, 25, 40, 70, 80);

        double medianUsingBinarySearch= findMedianSortedArrays(a, b);

        System.out.println("median2 = "+medianUsingBinarySearch);
    }
}
