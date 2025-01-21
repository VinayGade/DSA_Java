package search.practice;

/*
LeetCode 4. Median of Two Sorted Arrays

Given two sorted arrays nums1 and nums2 of size m and n respectively,
return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).

Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

* */

public class MedianOfSortedArrays {

    static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        //using merge sort

        int n1 = nums1.length;
        int n2 = nums2.length;

        int n = n1+n2;

        int[] array = new int[n];

        int i=0;
        int j=0;
        int k=0;

        while(i<=n1 && j<=n2){
            if(i==n1){
                while(j<n2)
                    array[k++] = nums2[j++];
                break;
            }else if(j==n2){
                while(i<n1)
                    array[k++] = nums1[i++];
                break;
            }
            if(nums1[i]<nums2[j])
                array[k++] = nums1[i++];
            else
                array[k++] = nums2[j++];
        }
        return (n%2==0) ? (float)(array[n/2-1]+array[n/2])/2 : array[n/2];
    }

    public double findMedian2SortedArrays(int[] nums1, int[] nums2) {
        int index1 = 0;
        int index2 = 0;
        int med1 = 0;
        int med2 = 0;
        for (int i=0; i<=(nums1.length+nums2.length)/2; i++) {
            med1 = med2;
            if (index1 == nums1.length) {
                med2 = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                med2 = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2] ) {
                med2 = nums1[index1];
                index1++;
            }  else {
                med2 = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length+nums2.length)%2 == 0) {
            return (float)(med1+med2)/2;
        }

        return med2;
    }

    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        double median = findMedianSortedArrays(nums1, nums2);
        System.out.println(median);
    }
}