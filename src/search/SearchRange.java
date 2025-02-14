package search;

//LeetCode 34. Find First and Last Position of Element in Sorted Array

// Search for a Range

/*
Given a sorted array of integers A(0 based index) of size N, find the starting and
the ending position of a given integer B in array A.

Your algorithm's runtime complexity must be in the order of O(log n).

Return an array of size 2, such that the first element = starting position of B in A and
the second element = ending position of B in A, if B is not found in A return [-1, -1].

Input 1:

 A = [5, 7, 7, 8, 8, 10]
 B = 8

Input 2:

 A = [5, 17, 100, 111]
 B = 3

Output 1:

 [3, 4]

Output 2:

 [-1, -1]
* */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchRange {

    static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);
        result[0] = left;
        result[1] = right;
        return result;
    }

    static int binarySearch(int[] nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.length - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return idx;
    }

    static ArrayList<Integer> searchRange(List<Integer> nums, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        result.add(-1);
        result.add(-1);
        int left = binarySearchList(nums, target, true);
        int right = binarySearchList(nums, target, false);
        result.set(0,left);
        result.set(1,right);
        return result;
    }

    static int binarySearchList(List<Integer> nums, int target, boolean isSearchingLeft) {
        int left = 0;
        int right = nums.size() - 1;
        int idx = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int midValue = nums.get(mid);
            if (midValue > target) {
                right = mid - 1;
            } else if (midValue < target) {
                left = mid + 1;
            } else {
                idx = mid;
                if (isSearchingLeft) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }
        return idx;
    }

    public static void main(String[] args) {
        List<Integer>  A = Arrays.asList(5, 7, 7, 8, 8, 10);
        int B = 8;
        List<Integer> range = searchRange(A, B);
        int x = range.get(0);
        int y = range.get(1);

        System.out.println(x+" "+y);

        int[] a = {5, 17, 100, 111};
        int target = 3;
        int[] pair = searchRange(a, target);
        System.out.println(pair[0]+" "+pair[1]);

        a = new int[]{5, 7, 7, 8, 8, 10};
        target = 7;
        pair = searchRange(a, target);
        System.out.println(pair[0]+" "+pair[1]);
    }
}
